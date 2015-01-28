/*****************************************************************************\
 * VisLimitAngularBrightnessData
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * A support class for VisLimit.
 * <P>
 * Holds values which vary across the sky
 */

public class VisLimitAngularBrightnessData {

  public VisLimitAngularBrightnessData() {
      zenithAngle = 0D; distMoon=0D; distSun=0D;
  }

  public VisLimitAngularBrightnessData( double za, double dm, double ds ) {
      zenithAngle = za; distMoon=dm; distSun=ds;
  }

  /**
   * The zenith angle
   */
  public double zenithAngle;

  /**
   * The lunar angular distance
   */
  public double distMoon;

  /**
   * The solar angular distance
   */
  public double distSun;
};

