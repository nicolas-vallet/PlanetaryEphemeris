/*****************************************************************************\
 * RiseSet
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import android.util.Log;

/**
 * Calculates rise & set times of the sun or moon, and
 * also calculates twilight times (civil/nautical/astronomical).
 * <P>
 * Based on code by Bill Gray (www.projectpluto.com)
 * <P>
 * <I>[Bill Gray's Comments:]</I><BR>
 * This class computes the times at which the sun or moon will rise
 * and set during a given day starting on the given Julian day.  It
 * does this by computing the altitude of the object during each of
 * the 24 hours of that day (and 1 hour of the next). What we really
 * want to know is the object's altitude relative to the "rise/set
 * altitude." This is the altitude at which the top of the object
 * becomes visible, after correcting for refraction and (in the case
 * of the Moon) topocentric parallax.
 * <P>
 * For the sun,  this altitude is -.8333 degrees (its apparent radius
 * is about .25 degrees, and refraction 'lifts it up' by .58333
 * degrees.) For the moon, this altitude is +.125 degrees.
 * <P>
 * If we find that the object was below this altitude at one hour,
 * and above it on the next hour, then it must have risen in that
 * interval; Conversely, if we find that the object was above this
 * altitude at one hour, and below it on the next hour, then it must
 * have set in that interval.
 * <P>
 * We then do an iterative search to find the instant during that
 * hour that it rose or set. This starts with a guessed rise/set
 * time in the middle of the particular hour in question. At each
 * step, we look at the altitude of that object at that time, and
 * use it to adjust the rise/set time based on the assumption that
 * the motion was linear during the hour (this isn't a perfect
 * assumption, but we still usually converge in a few iterations.)
 * <P>
 * As a side benefit, this function will also calculate twilight
 * times by using the sun and just changing the event altitude. The
 * modified altitudes are -6 degrees (civil twilight), -12 degrees
 * (nautical twilight) and -18 degrees (astronomical twilight).
 * <P>
 * TimePair.a stores the rise (or twilight start) times. <BR>
 * TimePair.b stores the set (or twilight end) times.
 */
public class RiseSet {
 /**
  * Calulation type (pseudo-enum)
  */
  public static final int SUN = 0, MOON = 1,
      CIVIL_TWI = 2, NAUTICAL_TWI = 3, ASTRONOMICAL_TWI = 4;

  /**
   * Solar altitude adjustment
   */
   public static final double SUN_ALT = Math.toRadians(-.83333);

   /**
    * Solar an lunar topocentric altitude adjustment
    */
    public static final double SUN_TOPO_ALT = Math.toRadians(-.83555);

  /**
   * Lunar altitude adjustment
   */

  public static final double MOON_ALT = Math.toRadians(.125);  // Valid for _geocentric_ lunar coordinates, not topocentric!

  /**
    * Stellar altitude adjustment
    */
  public static final double PLANET_ALT = Math.toRadians(-0.57);  // Valid for _geocentric_ lunar coordinates, not topocentric!

 /**
  * Civil twilight altitude (when sun is 6 degrees below horizon).
  */
  public static final double C_TWI_ALT = Math.toRadians(-6.);

 /**
  * Nautical twilight altitude (when sun is 12 degrees below horizon).
  */
  public static final double N_TWI_ALT = Math.toRadians(-12.);

 /**
  * Astronomical twilight altitude (when sun is 18 degrees below horizon).
  */
  public static final double A_TWI_ALT = Math.toRadians(-18.);

 /**
  * State enum
  */
  public static final int UNKNOWN = 0, RISING=1, SETTING=2, CULMINATING=3;

  /**
   * Calculate the rise/set (or start/end) times.
   *
   * @param rsType Rise/Set type (SUN, MOON, CIVIL_TWI, NAUTICAL_TWI, or ASTRONOMICAL_TWI).
   * @param jd The Julian day for which to calculate the desired information (set to 0h local time
   * @param oi The observer's location
   * @param pd A PlanetData instance to use for our calculations.
   *
   * @return the TimePair result, local time
   */
   public static TimePair getTimes( int rsType, double jd,
                                ObsInfo oi, PlanetData pd)
   {
     //default to SUN
     double risesetAlt = SUN_ALT;  // r/s altitude
     int planet = Planets.EARTH;

     switch ( rsType ) {
     case MOON:
       risesetAlt = MOON_ALT;
       planet = Planets.LUNA;    // moon
       break;
     case CIVIL_TWI:
       risesetAlt = C_TWI_ALT;
       break;
     case NAUTICAL_TWI:
       risesetAlt = N_TWI_ALT;
       break;
     case ASTRONOMICAL_TWI:
       risesetAlt = A_TWI_ALT;
       break;
     default:
       break;
     };

   /*
    * Mark both the rise and set times as INVALID, to indicate that
    * they've not been found.  Note that it may turn out that one or
    * both do not occur during the given 24 hours.
    */
     TimePair riseSet = new TimePair( Astro.INVALID, Astro.INVALID );

     double altitude[] = new double[Astro.IHOURS_PER_DAY+1];    // 24 hrs + 1

     // Compute the altitude for each hour:
     //
     for( int i=0; i<=Astro.IHOURS_PER_DAY; i++ ) {
       pd.calc( planet, jd + AstroOps.toDays(i), oi );
       try {
//         altitude[i] = Math.asin( pd.getAltAzRadius() ) - risesetAlt;
     	  // Strickling correction after correction of PlanetData return methods
     	  altitude[i] = pd.getAltAzLat() - risesetAlt;  
       } catch ( NoInitException ni ) {}
     }

     // Scan the hours, looking for rise/sets:
     //
     for( int i=0; i<Astro.IHOURS_PER_DAY; i++ ) {
       int rs = UNKNOWN;
       if( altitude[i] <= 0. && altitude[i+1] > 0.) {
         // object is rising
         rs = RISING;
       }
       else if( altitude[i] > 0. && altitude[i+1] <= 0. ) {
         // object is setting
         rs= SETTING;
       }

       if ( UNKNOWN != rs ) {
         // we found a rise or set to refine

         double fraction = AstroOps.toDays(i);
         double alt0 = altitude[i];
         double altDiff = altitude[i+1] - alt0;
         double delta = 1.;
         int iterations = 10;

         while( delta > .0001 && iterations > 0 ) {
           iterations--;
           delta = ( -alt0 / altDiff ) / Astro.HOURS_PER_DAY;
           fraction += delta;
           pd.calc( planet, jd + fraction, oi );
           try {
//             alt0 = Math.asin( pd.getAltAzRadius() ) - risesetAlt;
            	  // Strickling correction after correction of PlanetData return methods
         	  alt0 = pd.getAltAzLat() - risesetAlt;          	  
           } catch ( NoInitException ni ) {}
         }
         if ( RISING == rs )
           riseSet.a = fraction;
         else if ( SETTING == rs )
           riseSet.b = fraction;
       }
     }
     return riseSet;
   }


 /**
  * Calculate the rise/set (or start/end) times.
  *
  * @param rsType Rise/Set type (SUN, MOON, CIVIL_TWI, NAUTICAL_TWI, or ASTRONOMICAL_TWI).
  * @param jd The Julian day for which to calculate the desired information
  * @param oi The observer's location
  */
  public static TimePair getTimes( int rsType, double jd, ObsInfo oi) {
    return getTimes( rsType, jd, oi, new PlanetData() );
  }
}
