/*****************************************************************************\
 * LocationElements
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * This is a convenience class used for passing around polar coordinates.
 */
public class LocationElements {
 /**
  * Pseudo-enum indices into vector form of LocationElements.
  */
  public final static int LATITUDE = 0, LONGITUDE = 1, RADIUS = 2;
  public final static int X = 0, Y = 1, Z = 2;

 /**
  * Default constructor
  */
  public LocationElements() { invalidate(); }

 /**
  * Explicit constructor
  *
  * @param lat latitude,  X
  * @param lon longitude, Y
  * @param rad radius,    Z
  */
  public LocationElements(Latitude lat, Longitude lon, double rad) {
    this.lat=lat.value;
    this.lon=lon.value;
    this.rad=rad;
  }

 /**
  * Vector constructor
  *
  * @param vector { lat, lon, rad }
  */
  public LocationElements(double vector[]) { set(vector); }

  /**
   * Mark all members as invalid
   */
  public void invalidate() { lat = lon = rad = Astro.INVALID; }

 /**
  * Get the latitude
  *
  * @return The latitude value of this instance
  */
  public double getLatitude() { return lat; }

 /**
  * Get the X element
  *
  * @return The X value (in XYZ vector form) of this instance
  */
  public double getX() { return lat; }

 /**
  * Get the longitude
  *
  * @return The longitude value of this instance
  */
  public double getLongitude() { return lon; }

 /**
  * Get the Y element
  *
  * @return The Y value (in XYZ vector form) of this instance
  */
  public double getY() { return lon; }

 /**
  * Get the radius
  *
  * @return The radius value of this instance
  */
  public double getRadius() { return rad; }

 /**
  * Get the Z element
  *
  * @return The Z value (in XYZ vector form) of this instance
  */
  public double getZ() { return rad; }

 /**
  * Get all values in this instance as a vector.
  * <P>
  * The vector is an array of three doubles, latitude, longitude,
  * and radius, in that order.
  *
  * @return v[0] = latitude, v[1] = longitude, v[2] = radius
  */
  public double[] get() {
    double vector[] = new double[3];
    vector[LATITUDE] = lat;
    vector[LONGITUDE] = lon;
    vector[RADIUS] = rad;
    return vector;
  }

 /**
  * Set the latitude
  *
  * @param d The new latitude value
  */
  public void setLatitude(double d) { lat = d; }

 /**
  * Set the longitude
  *
  * @param d The new longitude value
  */
  public void setLongitude(double d) { lon = d; }

 /**
  * Set the radius
  *
  * @param d The new radius value
  */
  public void setRadius(double d) { rad = d; }

 /**
  * Set all members of this instance from a vector.
  * <P>
  * The vector is an array of three doubles, latitude, longitude,
  * and radius, in that order.
  *
  * @param vector v[0] = latitude, v[1] = longitude, v[2] = radius
  */
  public void set(double vector[]) {
    lat=vector[LATITUDE];
    lon=vector[LONGITUDE];
    rad=vector[RADIUS];
  }

 /**
  * Set all members of this instance individually
  *
  * @param lat The new latitude
  * @param lon The new longitude
  * @param rad The new radius
  */
  public void set(double lat, double lon, double rad) {
    this.lat = lat;
    this.lon = lon;
    this.rad = rad;
  }

 /**
  * latitude
  */
  private double lat;

 /**
  * longitude
  */
  private double lon;

 /**
  * radius
  */
  private double rad;
}
