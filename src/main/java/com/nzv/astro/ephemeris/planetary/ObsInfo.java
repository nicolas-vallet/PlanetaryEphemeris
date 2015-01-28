/*****************************************************************************\
 * ObsInfo
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * Holds latitude, longitude and time zone of an observing location.
 * <P>
 * Note that the constructors expect latitude and longitude in
 * <B>degrees</B>, not radians, for calling convenience.
 */
public class ObsInfo {

 /**
  * Default constructor
  */
  public ObsInfo() { m_longitude = m_latitude = 0D; m_timeZone = 0; }

  /**
   * Explicit (all values) constructor.
   *
   * @param lon longitude in <B>degrees</B>
   * @param lat latitude in <B>degrees</B>
   * @param tz Time Zone offset relative to UTC (-12 to 12 inclusive)
   */
  public ObsInfo( Latitude lat, Longitude lon, int tz ) {
      m_latitude = Math.toRadians(lat.value);
      m_longitude = Math.toRadians(lon.value);
      m_timeZone = tz;
  }

  /**
   * Location only constructor. <BR>
   * Timezone is taken from local computer settings.
   *
   * @param lon longitude in <B>degrees</B>
   * @param lat latitude in <B>degrees</B>
   */
  public ObsInfo( Latitude lat, Longitude lon ) {
      m_latitude = Math.toRadians(lat.value);
      m_longitude = Math.toRadians(lon.value);
      m_timeZone = TimeOps.tzOffset();
  }

 /**
  * Get latitude in degrees.
  *
  * @return Latitude in <B>degrees</B>
  */
  public double getLatitudeDeg() { return Math.toDegrees(m_latitude); }

 /**
  * Get latitude in radians.
  *
  * @return Latitude in <B>radians</B>
  */
  public double getLatitudeRad() { return m_latitude;  }

 /**
  * Set latitude in <B>degrees</B>.
  *
  * @param lat Latitude in <B>degrees</B>
  */
  public void setLatitudeDeg(double lat) { m_latitude = Math.toRadians(lat); }

 /**
  * Set latitude in <B>radians</B>.
  *
  * @param lat Latitude in <B>radians</B>
  */
  public void setLatitudeRad(double lat) { m_latitude = lat; }

 /**
  * Get longitude in degrees.
  *
  * @return Longitude in <B>degrees</B>
  */
  public double getLongitudeDeg() { return Math.toDegrees(m_longitude); }

 /**
  * Get longitude in radians.
  *
  * @return Longitude in <B>radians</B>
  */
  public double getLongitudeRad() { return m_longitude; }

 /**
  * Set longitude in degrees.
  *
  * @param lon Longitude in <B>degrees</B>
  */
  public void setLongitudeDeg(double lon) { m_longitude = Math.toRadians(lon); }

 /**
  * Set longitude in radians.
  *
  * @param lon Longitude in <B>radians</B>
  */
  public void setLongitudeRad(double lon) { m_longitude = lon; }

 /**
  * Get time zone offset.
  *
  * @return Time zone offset from UTC (-12 to 12 inclusive)
  */
  public int getTimeZone() { return m_timeZone;  }

 /**
  * Set time zone offset.
  *
  * @param tz Time zone offset from UTC (-12 to 12 inclusive)
  */
  public void setTimeZone(int tz) { m_timeZone = tz; }

  private double m_longitude;   // in radians, N positive
  private double m_latitude;    // in radians, E positive
  private int    m_timeZone;    // +/- 12 viz. UT
};
