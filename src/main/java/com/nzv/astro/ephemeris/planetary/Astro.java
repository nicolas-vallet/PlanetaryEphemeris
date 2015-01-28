/*****************************************************************************\
 * Astro
 *
 * Astro defines misc. handy constants
 *
 * Based on C code from project pluto (www.projectpluto.com)
 *
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * Useful constants
 */
public final class Astro {

  // angles

  /**
   * Two times Pi
   */
  public static final double TWO_PI = 2D * Math.PI;

  /**
   * Pi divided by two
   */
  public static final double PI_OVER_TWO = Math.PI / 2D;

  /**
   * Two divided by Pi
   */
  public static final double TWO_OVER_PI = 2D / Math.PI;

  /**
   * Degrees in a circle = 360
   */
  public static final double DEG_PER_CIRCLE = 360D;

  /**
   * Arc minutes in one degree = 60
   */
  public static final double MINUTES_PER_DEGREE = 60D;

  /**
   * Arc seconds in one degree = 360
   */
  public static final double SECONDS_PER_DEGREE = 60D * MINUTES_PER_DEGREE;

  /**
   * Julian millenia conversion constant = 100 * days per year
   */
  public static final double TO_CENTURIES = 36525;

  /**
   * Hours in one day as a double
   */
  public static final double HOURS_PER_DAY = 24D;

  /**
   * Hours in one day as an integer
   */
  public static final int    IHOURS_PER_DAY = (int)HOURS_PER_DAY;

  /**
   * The fraction of one day equivalent to one hour = 1/24.
   */
  public static final double DAYS_PER_HOUR = 1D/HOURS_PER_DAY;

  /**
   * Minutes in one hour as a double
   */
  public static final double MINUTES_PER_HOUR = 60D;

  /**
   * Minutes in one hour as an integer
   */
  public static final int    IMINUTES_PER_HOUR = (int)MINUTES_PER_HOUR;

  /**
   * Seconds in one minute
   */
  public static final int    SECONDS_PER_MINUTE = 60;

  /**
   * Seconds in one hour
   */
  public static final int    SECONDS_PER_HOUR = IMINUTES_PER_HOUR * SECONDS_PER_MINUTE;

  /**
   * Seconds in one day
   */
  public static final int    SECONDS_PER_DAY = IHOURS_PER_DAY * SECONDS_PER_HOUR;

  /**
   * Milliseconds in one second
   */
  public static final int    MILLISECONDS_PER_SECOND = 1000;

  /**
   * Milliseconds in one hour
   */
  public static final int    MILLISECONDS_PER_HOUR = MILLISECONDS_PER_SECOND * SECONDS_PER_HOUR;

  /**
   * Our default epoch. <BR>The Julian Day which represents noon on 2001-01-01.
   */
  public static final double J2000 = 2451545.0;

 /**
  * Our generic "invalid" double value.
  */
  public static final double INVALID = -1D;

 /**
  * A convenient rounding value
  */
  public static final double ROUND_UP = 0.5;
};

