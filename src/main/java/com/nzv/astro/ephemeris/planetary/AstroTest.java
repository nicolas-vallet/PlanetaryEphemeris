/*****************************************************************************\
 * AstroTest
 *
 * A Generic Test Harness
 *
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import java.util.Date;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

public class AstroTest {

  public static void main( String args[] ) {

    // Punit();

    LunarRS();

  }

  public static void LunarRS() {
    ObsInfo oi = new ObsInfo( new Latitude(40.0), new Longitude(-75.8) );
    System.out.println( LunarCalc.summary( oi ) );
    System.out.println( LunarCalc.summaryPHL() );
  }

  public static void Punit() {
    double jd = DateOps.dmyToDay(11, 4, 1979);
    ObsInfo oi = new ObsInfo(new Latitude(27.20), new Longitude(77.02));

    PlanetData pde = new PlanetData(Planets.SUN, jd, oi);
    try {
      System.out.println( "Sun Lon = " + Math.toDegrees(pde.getEclipticLon()) );
    }
    catch ( NoInitException e ) {
      System.out.println( "Error calculating Sun: " + e );
    }

    PlanetData pdm = new PlanetData(Planets.MARS, jd, oi);

    try {
      System.out.println( "Mars Lon = " + Math.toDegrees(pdm.getEclipticLon()) );
    }
    catch ( NoInitException e ) {
      System.out.println( "Error calculating Mars: " + e );
    }
  }

}
