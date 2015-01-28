/*****************************************************************************\
 * VisLimitFixedBrightnessData
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * A support class for VisLimit.
 * <P>
 * Holds values which are constant at a given time
 */
public class VisLimitFixedBrightnessData {

 public  VisLimitFixedBrightnessData() {
    zenithAngMoon = 0D; zenithAngSun = 0D; moonElongation = 0D;
    htAboveSeaInMeters = 0D; latitude = 0D;
    temperatureInC = 0D; relativeHumidity = 0D;
    year = 0D; month = 0D;
  }

  public VisLimitFixedBrightnessData(
        double zm, double zs, double me, double h,double lat,
        double t, double rh, double y, double m )
  {
    zenithAngMoon = zm; zenithAngSun = zs; moonElongation =me;
    htAboveSeaInMeters = h; latitude = lat;
    temperatureInC = t; relativeHumidity=rh;
    year=y; month=m;
  }

 /**
  * The lunar zenith angle
  */
  public double zenithAngMoon;

 /**
  * The solar zenith angle
  */
  public double zenithAngSun;

 /**
  * The lunar elongation
  */
  public double moonElongation;

 /**
  * Altitude (above sea level) in meters
  */
  public double htAboveSeaInMeters;

 /**
  * Latitude
  */
  public double latitude;

 /**
  * Temperature in degrees Centigrade
  */
  public double temperatureInC;

 /**
  * Relative humidity
  */
  public double relativeHumidity;

 /**
  * Year
  */
  public double year;

 /**
  * Month
  */
  public double month;
};


