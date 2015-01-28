/*****************************************************************************\
 * Vsop
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * This class wraps the VSOP87 data and provides VSOP planetary
 * position calculation functions for Mercury through Neptune
 * (VSOP doesn't handle the moon or Pluto).
 * <P>
 * Based on C code by Bill Gray (www.projectpluto.com)
 */
public class Vsop {
  // All "magic numbers" are from Meeus, Astronomical Algorithms, 2ed

 /**
  * Calculate a single location element (latitude, longitude, or radius).
  * <P>
  * This function, using the simplified VSOP87 data in Meeus, can
  * compute planetary positions in heliocentric ecliptic coordinates.
  * <P>
  * Longitude & latitude are in radians.
  *
  * @param t Time in Julian centuries from J2000
  * @param planet One of the constants from <TT>Planets.MERCURY</TT>
  *     to <TT>Planets.NEPTUNE</TT> inclusive.
  * @param ltype location element type:
  *  <UL><LI><TT>LocationElements.LONGITUDE</TT> for ecliptic longitude
  *  <LI><TT>LocationElements.LATITUDE</TT> for ecliptic latitude
  *  <LI><TT>LocationElements.RADIUS</TT> for distance from sun.</UL>
  *  (These are ecliptic coordinates of date, by the way!)
  * @return The selected element, or 0.0 if planet parameter is
  *      invalid.
  */
  public static double calcLE(
      double t,            // time in decimal centuries
      int planet,          // must be in the range SUN...NEPTUNE
      int ltype)           // LocationElements.LATITUDE, LONGITUDE, or RADIUS
  {
    double rval = 0.0;

    if( planet > Planets.SUN && planet < Planets.PLUTO ) {

      t /= 10.;          // convert to julian millenia
      double tPower = 1.0;

      VsopTerms pT[] = null;
      switch ( planet ) {
        case Planets.MERCURY:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.MercuryLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.MercuryLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.MercuryRadTerms;
              break;
          }
          break;
        case Planets.VENUS:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.VenusLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.VenusLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.VenusRadTerms;
              break;
          }
          break;
        case Planets.EARTH:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.EarthLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.EarthLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.EarthRadTerms;
              break;
          }
          break;
        case Planets.MARS:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.MarsLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.MarsLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.MarsRadTerms;
              break;
          }
          break;
        case Planets.JUPITER:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.JupiterLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.JupiterLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.JupiterRadTerms;
              break;
          }
          break;
        case Planets.SATURN:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.SaturnLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.SaturnLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.SaturnRadTerms;
              break;
          }
          break;
        case Planets.URANUS:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.UranusLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.UranusLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.UranusRadTerms;
              break;
          }
          break;
        case Planets.NEPTUNE:
          switch ( ltype ) {
            case LocationElements.LONGITUDE:
              pT = VsopData.NeptuneLonTerms;
              break;
            case LocationElements.LATITUDE:
              pT = VsopData.NeptuneLatTerms;
              break;
            case LocationElements.RADIUS:
              pT = VsopData.NeptuneRadTerms;
              break;
          }
          break;
        default: break;
      };

      // Always six series to calculate
      int i=0, j=0;
      try {
        for( ; i<6; i++ ) {
          double sum = 0.;
          VsopSet pv[] = pT[i].pTerms;

          // sum the term = A x cos( B + C x tc ) for each row
          for( j=0; j<pT[i].rows; j++ ) {
            sum += pv[j].A * Math.cos( pv[j].B + pv[j].C * t );
          }
          // Add to series and bump multipler
          // i.e., L = L0*t + L1*t^2 + L2*t^3 + ...
          rval += sum * tPower;
          tPower *= t;
        }
      }
      catch( java.lang.ArrayIndexOutOfBoundsException a ) {
        System.err.println( "Vsop.calcLE(): Array out of bounds\n" +
            "  i=" + i + ", j=" + j + ", p=" + planet + ", type=" + ltype );
      }

      rval *= 1.e-8;  // rescale the term

      if( LocationElements.LONGITUDE == ltype )  /* ensure 0 < rval < 2PI  */
      {
        rval = AstroOps.normalizeRadians( rval );
      }
    }

    return rval;
  }

 /**
  * Calculate all three location elements of the specified planet at
  * the given time.
  *
  * @param loc The <TT>LocationElements</TT> instance to populate
  * @param jcen Time in Julian centuries from J2000
  * @param planet The planet position to calculate, which must be in
  *  the range <TT>Planets.MERCURY</TT> to <TT>Planets.NEPTUNE</TT>
  *  inclusive.
  */
  public static void calcAllLEs(
    LocationElements loc,
    double jcen,
    int planet)
  {
    loc.set( calcLE( jcen, planet, LocationElements.LATITUDE ),
             calcLE( jcen, planet, LocationElements.LONGITUDE ),
             calcLE( jcen, planet, LocationElements.RADIUS )
           );
  }

};  // end class Vsop


