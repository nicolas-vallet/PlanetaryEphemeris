/*****************************************************************************\
 * Planets
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * A common place to store planetary constants.
 */
public final class Planets {
 /**
  * NAP = Not A Planet.
  */
  public static final int NAP=-1;
  public static final int
          SUN=0, MERCURY=1, VENUS=2, EARTH=3, MARS=4,
          JUPITER=5, SATURN=6, URANUS=7, NEPTUNE=8, PLUTO=9;
 /**
  * Earth's moon - not a planet, but it is a heavenly body.
  */
  public static final int LUNA=10;
  
  public static final int PLANETOID=11;

}
