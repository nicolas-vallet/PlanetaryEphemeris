/*****************************************************************************\
 * DarkCalInput
 *
 * A struct to hold the input data for DarkCal
 *
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import java.io.Serializable;

/**
 * A simple struct-style class to hold date & observer location.
 */
public class DarkCalInput /*implements Serializable*/ {

 /**
  * Default constructor. <BR> January, 2001, at 0,0.
  */
  public DarkCalInput() { month=1; year=2001; lon = lat = tz = 0; }

 /**
  * Explicit (all values) constructor.
  *
  * @param month Month to use
  * @param year Year to use
  * @param lon Longitude to use
  * @param lat Latitude to use
  * @param tz Time zone to use
  */
  public DarkCalInput( int month, int year, double lon, double lat, int tz ) {
    this.month=month;
    this.year=year;
    this.lon = lon;
    this.lat = lat;
    this.tz = tz;
  }

 /**
  * Month to process
  */
  public int month;

 /**
  * Year
  */
  public int year;

 /**
  * Observer's longitude
  */
  public double lon;

 /**
  * Observer's latitude
  */
  public double lat;

 /**
  * Observer's time zone offset relative to UTC (-12 to 12 inclusive).
  */
  public int tz;
};

