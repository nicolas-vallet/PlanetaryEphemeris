/*****************************************************************************\
 * AstroOps
 *
 * AstroOps  is a 'catch-all' class that performs odd handy calculations
 *
 * Based in part on C code from project pluto (www.projectpluto.com)
 *
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * AstroOps is a 'catch-all' class that performs some useful
 * calculation functions that didn't fit anywhere else.
 */
public class AstroOps
{
  /**
   * Calculates the mean obliquity at a given time.
   *
   * @param t Time in julian centuries from J2000.<BR>
   * Valid range is the years -8000 to +12000 (t = -100 to 100).
   *
   * @return The mean obliquity (epsilon sub 0) in radians.
   */
  public static double meanObliquity( double t ) {

    // The obliquity formula (and all the magic numbers below) come
    // from Meeus, Astro Algorithms, 2ed.

    double rval = 0.;
    double u, u0;
    double t0 = 30000.;
    final double rvalStart =
            23. * Astro.SECONDS_PER_DEGREE +
            26. * Astro.MINUTES_PER_DEGREE +
            21.448;
    final int OBLIQ_COEFFS = 10;
    final double coeffs[] = {
            -468093.,  -155.,  199925.,  -5138.,  -24967.,
            -3905.,    712.,   2787.,    579.,    245.
    };

    if( t0 != t ) {

      t0 = t;
      u = u0 = t / 100.;     // u is in julian 10000's of years
      rval = rvalStart;

      for( int i=0; i<OBLIQ_COEFFS; i++ ) {
        rval += u * coeffs[i] / 100.;
        u *= u0;
      }
      // convert from seconds to radians
      rval = Math.toRadians( rval / Astro.SECONDS_PER_DEGREE );
    }
    return rval;
  }

  /**
   * Calculates the sidereal UTC time.
   *
   * This function returns apparent Greenwich sidereal time for the
   * given Julian day.
   *
   * @param jd Julian day
   *
   * @return Sidereal time in radians
   */
  public static double greenwichSiderealTime( double jd ) {
    // See Meeus p. 84.

    jd -= Astro.J2000;      // set relative to 2000.0
    double jdm = jd / Astro.TO_CENTURIES;  // convert jd to julian centuries
    double intPart = Math.floor( jd );
    jd -= intPart;
    double rval = 280.46061837 +
                  360.98564736629 * jd +
                  .98564736629 * intPart +
                  jdm * jdm * ( 3.87933e-4 - jdm / 38710000. );

    return Math.toRadians( rval );
//    return normalizeRadians(Math.toRadians( rval ));
  }

  /**
   * Converts the hour to a day fraction. <BR>
   * For example, 12h = 0.5d
   *
   * @param hours (0..23)
   *
   * @return Fractional day
   */
  public static double toDays( int hours ) {
    return (double)hours / Astro.HOURS_PER_DAY;
  }

  /**
   * Convert a Julian day value to Julian millenia referenced to
   * epoch J2000. <BR>
   *
   * @param jd Julian day number
   *
   * @return Julian millenia ref. J2000
   */
  public static double toMillenia( double jd ) {
     return ( jd - Astro.J2000 ) / Astro.TO_CENTURIES;
  }

  /**
   * Reduce an angle in degrees to the range (0 <= deg < 360)
   *
   * @param d Value in degrees
   *
   * @return The reduced degree value
   */
  public static double normalizeDegrees(double d)
  {
    d = d - Astro.DEG_PER_CIRCLE * Math.floor( d / Astro.DEG_PER_CIRCLE );
    // Can't use Math.IEEEremainder here because remainder differs
    // from modulus for negative numbers.
    if ( d < 0. )
      d += Astro.DEG_PER_CIRCLE;

    return d;
  }

  /**
   * Reduce an angle in radians to the range (0 <= rad < 2Pi)
   *
   * @param r Value in radians
   *
   * @return The reduced radian value
   */
  public static double normalizeRadians(double r)
  {
    r = r - Astro.TWO_PI * Math.floor( r / Astro.TWO_PI );
    // Can't use Math.IEEEremainder here because remainder differs
    // from modulus for negative numbers.
    if ( r < 0. )
      r += Astro.TWO_PI;

    return r;
  }

 /**
  * Returns the quadrant (0, 1, 2, or 3) of the specified angle.
  * <P>
  * This function is useful in figuring out dates of lunar phases
  * and solstices/equinoxes.  If the solar longitude is in one
  * quadrant at the start of a day,  but in a different quadrant at
  * the end of a day, then we know that there must have been a
  * solstice or equinox during that day.  Also,  if (lunar
  * longitude - solar longitude) changes quadrants between the
  * start of a day and the end of a day,  we know there must have
  * been a lunar phase change during that day.
  *
  * @param radians Angle in Radians
  *
  * @return Quadrant of angle (0, 1, 2, or 3)
  */

  public static int quadrant( double radians ) {
    return (int)( AstroOps.normalizeRadians( radians ) * Astro.TWO_OVER_PI );
  }
//----------------------------------------------------------------------------
};
