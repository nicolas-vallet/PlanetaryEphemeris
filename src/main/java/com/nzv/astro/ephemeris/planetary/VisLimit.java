/*****************************************************************************\
 * VisLimit
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

import java.text.DecimalFormat;

/**
 * Calculates sky brightness and limiting magnitude. <BR>
 * Based on C code by Bill Gray (www.projectpluto.com), which was in
 * turn based on Brad Schaefer's article and code on pages 57-60,
 * May 1998 _Sky & Telescope_, "To the Visual Limits".
 * <P>
 * <I>[Bill Gray's Comments:]</I><BR>
 * The computations for sky brightness and limiting magnitude can be
 * logically broken up into several pieces. Some computations depend
 * on things that are constant for a given observing site and time:
 * the lunar and solar zenith distances, the air masses to those
 * objects, the temperature and relative humidity,  and so forth.
 * For use in Guide, I expect to compute brightness at many points
 * in the sky, while all these other values hold constant. So my
 * first step (after putting lat/lon and these other data into an
 * instance of VisLimitAngularBrightnessData) is to call the
 * setBrightnessParams() function. This function does a lot of
 * "setup work", figuring out the absorption per unit air mass at
 * various wavelengths from various causes (gas, aerosol,  ozone),
 * the number of air masses to the sun and moon, and so forth.
 * <P>
 * Once you've done all this, you can call computeSkyBrightness()
 * for any point in the sky. You do need to provide the zenith angle,
 * and the angular distance of that point from the moon and sun. The
 * brightnesses are available via the brightness() functions.
 * The 'mask' value can be used to specify which of the five bands
 * is to be computed. (For example,  if I use this to make a
 * realistic sky background,  I may just concern myself with the
 * V band... maybe with B and R if I want to attempt a colored sky.
 * In either case, computing all five bands would be excessive.)
 * <P>
 * Next, you can call computeExtinction() to set any or all of
 * the five extinction values. Normally, I wouldn't see much use for
 * this data. But you do need to have that data if you intend to call
 * the computeLimitingMag() function.
 * <P>
 * If you use the explicit (all values) constructor, all of the
 * above functions are called for you automatically.
 * <P>
 * <B>Notice</B> that we modified his test conditions. He had the
 * moon and sun well below the horizon; I found that this didn't
 * make testing contributions from those objects any easier, so we
 * put them where they could contribute more brightness.
 */
public class VisLimit {

 /**
  * Default constructor.
  */
  public VisLimit() {
    fixed = new VisLimitFixedBrightnessData();
    angular = new  VisLimitAngularBrightnessData();
  }

  /**
   * Explicit (all values) constructor.
   * <P>
   * Note that the <TT>BrightnessData</TT> parameters are expected
   * to contain valid data.
   *
   * @param bandMask A logical mask which represents one or more of
   * the five possible bands to calculate.
   * @param fbd The fixed brightness data
   * @param abd The angular brightness data
   */
  public VisLimit( int bandMask,
                   VisLimitFixedBrightnessData fbd,
                   VisLimitAngularBrightnessData abd ) {
    this.mask = bandMask;
    setBrightnessParams( fbd );
    computeSkyBrightness( abd );
    computeExtinction();
  }

  /**
   * Band mask
   */
  public static final int BAND_0 = 1;
  /**
   * Band mask
   */
  public static final int BAND_1 = 1 << 1;
  /**
   * Band mask
   */
  public static final int BAND_2 = 1 << 2;
  /**
   * Band mask
   */
  public static final int BAND_3 = 1 << 3;
  /**
   * Band mask
   */
  public static final int BAND_4 = 1 << 4;

 /**
  * Set the fixed brightness parameters.
  *
  * @param fbd The fixed brightness data
  */
  public void setBrightnessParams(VisLimitFixedBrightnessData fbd) {
    fixed = fbd;
    double monthAngle = (fixed.month - 3.) * Math.PI / 6.;
    double kaCoeff, krCoeff, koCoeff, kwCoeff, moonElong;
    int i;

    krCoeff = .1066 * Math.exp( -fixed.htAboveSeaInMeters / 8200.);
    kaCoeff = .1 * Math.exp( -fixed.htAboveSeaInMeters / 1500.);
    if( fixed.relativeHumidity > 0.) {
      double humidityParam;

      if( fixed.relativeHumidity >= 100.)
        humidityParam = 1000000.;
      else
        humidityParam = 1. - .32 / Math.log( fixed.relativeHumidity / 100.);

      kaCoeff *= Math.exp( 1.33 * Math.log(humidityParam));
    }
    if( fixed.latitude < 0D)
      kaCoeff *= 1D - Math.sin( monthAngle);
    else
      kaCoeff *= 1D + Math.sin( monthAngle);

    koCoeff = (3. + .4 * (fixed.latitude * Math.cos( monthAngle) -
                      Math.cos( 3. * fixed.latitude))) / 3.;

    kwCoeff = .94 * (fixed.relativeHumidity / 100.) *
                      Math.exp( fixed.temperatureInC / 15.) *
                      Math.exp( -fixed.htAboveSeaInMeters / 8200.);

    yearTerm = 1. + .3 * Math.cos( 2. * Math.PI * (fixed.year - 1992) / 11.);
    airMassMoon = computeAirMass( fixed.zenithAngMoon);
    airMassSun  = computeAirMass( fixed.zenithAngSun);
    moonElong = fixed.moonElongation * 180. / Math.PI;
    lunarMag = -12.73 + moonElong * (.026 +
                       4.e-9 * (moonElong * moonElong * moonElong));
                /* line 2180 in B Schaefer code */

    for( i = 0; i < 5; i++) {

      kr[i] = krCoeff * fourthPowerTerms[i];
      ka[i] = kaCoeff * onePointThreePowerTerms[i];
      ko[i] = koCoeff * oz[i];
      kw[i] = kwCoeff * wt[i];

      k[i] = kr[i] + ka[i] + ko[i] + kw[i];
      c3[i] = magToBrightness( k[i] * airMassMoon);
              /* compute dropoff in lunar brightness from extinction: 2200 */
      c4[i] = magToBrightness( k[i] * airMassSun);
    }
  }

 /**
  * Compute the sky brightness.
  *
  * @param abd The angular brightness data
  */
  public void  computeSkyBrightness(VisLimitAngularBrightnessData abd) {
   angular = abd;

   double sinZenith;
   double brightnessDrop2150, fs, fm;
   int i;

   double airMass = computeAirMass( angular.zenithAngle );
   sinZenith = Math.sin( angular.zenithAngle );
   brightnessDrop2150 = .4 + .6 / Math.sqrt( 1.0 - .96 * sinZenith * sinZenith);
   fm = computeFFactor( angular.distMoon );
   fs = computeFFactor( angular.distSun );

   for( i = 0; i < 5; i++)
      if( 0 != ((mask >> i) & 1) ) {
         double bn = bo[i] * yearTerm, directLoss;
                        /* accounts for a 30% variation due to sunspots? */

         double brightnessMoon, twilightBrightness;
         double brightnessDaylight;

         directLoss = magToBrightness( k[i] * airMass);
         bn *= brightnessDrop2150;
                    /* Not sure what this is.. line 2150 in B Schaefer code */
         bn *= directLoss;
                   /* drop brightness to account for extinction: 2160 */

         if( fixed.zenithAngMoon < Math.PI / 2.)      /* moon is above horizon */
            {
            brightnessMoon = magToBrightness( lunarMag + cm[i]
                                 - mo[i] + 43.27);
            brightnessMoon *= (1. - directLoss);
                  /* Maybe computing how much of the lunar light gets */
                  /* scattered?   2240 */
            brightnessMoon *= (fm * c3[i] + 440000. * (1. - c3[i]));
            }
         else
            brightnessMoon = 0.;

         twilightBrightness = ms[i] - mo[i] + 32.5 -
                           (90. - fixed.zenithAngSun * 180. / Math.PI) -
                           angular.zenithAngle / (2 * Math.PI * k[i]);
                  /* above is in magnitudes,  so gotta do this: */
         twilightBrightness = magToBrightness( twilightBrightness);
                  /* above is line 2280,  B Schaefer code */
         twilightBrightness *= 100. / (angular.distSun * 180. / Math.PI);
         twilightBrightness *= 1. - magToBrightness( k[i]);
                  /* preceding line looks suspicious to me... line 2290 */
         brightnessDaylight = magToBrightness( ms[i] - mo[i] + 43.27);
                     /* line 2340 */
         brightnessDaylight *= (1. - directLoss);
                     /* line 2350 */
         brightnessDaylight *= fs * c4[i] + 440000. * (1. - c4[i]);
         if( brightnessDaylight > twilightBrightness)
            brightness[i] = bn + twilightBrightness + brightnessMoon;
         else
            brightness[i] = bn + brightnessDaylight + brightnessMoon;

      }
  }

 /**
  * Calculate the limiting magnitude.
  *
  * @return The limiting magnitude
  */
  public double limitingMagnitude() {
    double c1, c2, bl = brightness[2] / 1.11e-15;
    double th, tval; //, rval;

    if( bl > 1500.) {
      c1 = 4.4668e-9;
      c2 = 1.2589e-6;
    }
    else {
      c1 = 1.5849e-10;
      c2 = 1.2589e-2;
    }
    tval = 1. + Math.sqrt(c2 * bl);
    th = c1 * tval * tval;        // brightness in foot-candles?
    return -16.57 + brightnessToMag(th) - extinction[2];
  }

 /**
  * Compute the extinction value.
  */
  void computeExtinction() {
    double cosZenithAng = Math.cos( angular.zenithAngle );
    double tval;
    int i;

    airMassGas = 1. / (cosZenithAng + .0286 * Math.exp( -10.5 * cosZenithAng));
    airMassAerosol =
                1. / (cosZenithAng + .0123 * Math.exp( -24.5 * cosZenithAng));
    tval = Math.sin( angular.zenithAngle ) / (1. + 20. / 6378.);
    airMassOzone = 1. / Math.sqrt( 1. - tval * tval);
    for( i = 0; i < 5; i++) {
      if( 0!= ((mask >> i) & 1) ) {
        extinction[i] = (kr[i] + kw[i]) * airMassGas +
                         ka[i] * airMassAerosol +
                         ko[i] * airMassOzone;
      }
    }
  }

 /**
  * Set the mask value.
  */
  public void setMask(int m) { mask = m; }

 /**
  * Get the K band value.
  *
  * @param i Index into the band data
  */
  public double getK(int i) throws ValueException {
    if (i < 0 || i > BANDS)
      throw new ValueException( "invalid band data index." );

    return k[i];
  }

 /**
  * Get the brightess value.
  *
  * @param i Index into the band data
  */
  public double getBrightness(int i) throws ValueException {
    if (i < 0 || i > BANDS)
      throw new ValueException( "invalid band data index." );

    return brightness[i];
  }

 /**
  * Get the extinction value.
  *
  * @param i Index into the band data
  */
  public double getExtinction(int i) throws ValueException {
    if (i < 0 || i > BANDS)
      throw new ValueException( "invalid band data index." );

    return extinction[i];
  }

  //-------------------------------------------------------------------------
  private static final int BANDS = 5;

  private static final double LOG_10 = 2.302585093;

  private static double magToBrightness(double m) {
    return Math.exp( -.4 * m * LOG_10);
  }

  private static double brightnessToMag(double b) {
    return (-2.5 * Math.log(b) / LOG_10);
  }


  // constants for a given time:
  private VisLimitFixedBrightnessData fixed;

  // values varying across the sky:
  private VisLimitAngularBrightnessData angular;

  private int mask;   // indicates which of the 5 photometric bands we want

  static final double fourthPowerTerms[] =
                    { 5.155601, 2.441406, 1., 0.381117, 0.139470 };
  static final double onePointThreePowerTerms[] =
                    { 1.704083, 1.336543, 1., 0.730877, 0.527177 };
  static final double oz[] = {0., 0., .031, .008, 0.};
  static final double wt[] = {.074, .045, .031, .02, .015};

  static final double bo[] = {8.0e-14, 7.e-14, 1.e-13, 1.e-13, 3.e-13};
        /* Base sky brightness in each band */
  static final double cm[] = {1.36, 0.91, 0.00, -0.76, -1.17 };
        /* Correction to moon's magnitude */
  static final double ms[] = {-25.96, -26.09, -26.74, -27.26, -27.55 };
        /* Solar magnitude? */
  static final double mo[] = {-10.93, -10.45, -11.05, -11.90, -12.70 };
        /* Lunar magnitude? */


  // Items computed in setBrightnessParams:
  private double airMassSun, airMassMoon, lunarMag;
  private double k[]  = { 0D, 0D, 0D, 0D, 0D },
                 c3[] = { 0D, 0D, 0D, 0D, 0D },
                 c4[] = { 0D, 0D, 0D, 0D, 0D },
                 ka[] = { 0D, 0D, 0D, 0D, 0D },
                 kr[] = { 0D, 0D, 0D, 0D, 0D },
                 ko[] = { 0D, 0D, 0D, 0D, 0D },
                 kw[] = { 0D, 0D, 0D, 0D, 0D };
  private double yearTerm;

  // Items computed in computeLimitingMag:
  private double airMassGas, airMassAerosol, airMassOzone;
  private double extinction[] = { 0D, 0D, 0D, 0D, 0D };;

  // Internal parameters from computeSkyBrightness:
  private double /*air_mass,*/ brightness[] = { 0D, 0D, 0D, 0D, 0D };

  private static double computeAirMass( double zenithAngle) {
    double rval = 40D, cosAng = Math.cos(zenithAngle);

    if( cosAng > 0.)
      rval = 1. / (cosAng + .025 * Math.exp( -11. * cosAng));

    return rval;
  }

  private static double computeFFactor(double objDist) {
    double objDistDegrees = objDist * 180D / Math.PI;
    double rval, cosDist = Math.cos(objDist);

    rval = 6.2e+7 / (objDistDegrees * objDistDegrees)
          + Math.exp( LOG_10 * (6.15 - objDistDegrees / 40.));
    rval += 229086. * (1.06 + cosDist * cosDist);  /* polarization term? */

    return rval;

    /* Seen on lines 2210 & 2200 for the moon,  and on lines
     * 2320 & 2330 for the moon.  I've only foggy ideas what
     * it means;  I think it attempts to compute the falloff in
     * scattered light from an object as a function of distance.
     */
  }

  //-------------------------------------------------------------------------
  /** (for unit testing only) */
  public static void main( String args[] ) {
    if (args.length < 1) {
      System.err.println( "usage: VisLimit <zenith angle>\n" );
      return;
    }
    double zenithAngle = Double.parseDouble(args[0]);

    VisLimitFixedBrightnessData f = new VisLimitFixedBrightnessData(
        Math.toRadians(40),     // zenithAngleMoon
        Math.toRadians(100),    // zenithAngSun
        Math.toRadians(180),    // moonElongation  // 180 = full moon
        1000,                   // htAboveSeaInMeters
        Math.toRadians(40),     // latitude
        15,                     // temperatureInC
        40,                     // relativeHumidity
        2001,                   // year
        2                       // month
    );

    // values varying across the sky:
    VisLimitAngularBrightnessData a = new VisLimitAngularBrightnessData(
        Math.toRadians(zenithAngle),  // zenithAngle
        Math.toRadians(50),           // distMoon
        Math.toRadians(40) );         // distSun

    int bandMask = 0x1F;        // all five bands

    VisLimit v = new VisLimit( bandMask, f, a );

    DecimalFormat nf = new DecimalFormat( "##0.00" );
    try {
      for( int i = 0; i < BANDS; i++) {
        System.out.println(
            "k: " + nf.format( v.getK(i) ) +
            ", br: " + nf.format( v.getBrightness(i) ) +
            ", ex: " + nf.format( v.getExtinction(i) )
        );
      }
    } catch ( ValueException ve ) {}

    System.out.println( "Limiting magnitude: " +
                        nf.format( v.limitingMagnitude() ) );
  }
};
