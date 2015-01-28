/*****************************************************************************\
 * LunarCalc
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
//import java.text.DecimalFormat;

/**
 * LunarCalc is a class that does lunar calculations that do not
 * directly depend on the lunar fundamentals (although some do
 * need to call functions in Lunar).
 * <P>
 * The code in this class also uses other classes outside of Lunar
 * (and some of these classes in turn use Lunar), so these functions
 * are in a separate class, to avoid circular dependencies.
 * <P>
 * Based in part on C code by Bill Gray (www.projectpluto.com)
 */
public class LunarCalc {
  // All "magic numbers" are from Meeus, Astronomical Algorithms, 2ed

 /**
  * Exact number of days from one new moon to the next new moon.
  */
  public static final double SYNODIC_MONTH = 29.530588861;

 /**
  * The base Julian day for Ernest W. Brown's numbered series of
  * lunations = 1923 Jan 17 02:41 UT.
  * <P>
  * This date has been widely quoted as "Jan 16 1923" and indeed it
  * was (in EST) at Yale University where Prof. Brown worked.
  */
  static final double LUNATION_BASE = 2423436.40347;

 /**
  * Calculate the age of the moon in days for the given Julian day.
  *
  * @param jd - Julian day for which lunar age is required
  *
  * @return The lunar age in days (0.0 to 29.5306)
  */
  public static double ageOfMoonInDays( double jd ) {

    double centuries = AstroOps.toMillenia( jd ); // convert jd to jm ref. J2000

    // first calculate solar ecliptic longitude (in RAD)
    //
    double earthLon = Vsop.calcLE( centuries, Planets.EARTH, LocationElements.LONGITUDE );
   /*
    * What we _really_ want is the location of the sun as seen from
    * the earth (geocentric view).  VSOP gives us the opposite
    * (heliocentric) view, i.e., the earth as seen from the sun.
    * To work around this, we add PI to the longitude (rotate 180 degrees)
    */
    double sunLon = earthLon + Math.PI;

    // next calculate lunar ecliptic longitude (in RAD)
    //
    Lunar luna = new Lunar(centuries);
    double moonLon = Astro.INVALID;
    try {
      moonLon = luna.getLongitudeRadians();
    }
    catch (NoInitException ni) {}

    // age of moon in radians = difference
    double moonAge = AstroOps.normalizeRadians( Astro.TWO_PI - (sunLon - moonLon) );

    // convert radians to Synodic day
    double sday = SYNODIC_MONTH * (moonAge / Astro.TWO_PI);

    return sday;
  }

 /**
  * Calculate the age of the moon in days for the given <TT>Calendar</TT>
  * instance.
  *
  * @param cal - <TT>java.util.GregorianCalendar</TT> holding date for
  * which lunar age is required
  *
  * @return The lunar age in days (0.0 to 29.5306)
  */
  public static double ageOfMoonInDays( GregorianCalendar cal ) {
    return
        ageOfMoonInDays(
            DateOps.dmyToDay(
                cal.get(Calendar.DATE),
                cal.get(Calendar.MONTH)+1,  // Calendar has 0-based months (!)
                cal.get(Calendar.YEAR)
            ) + AstroOps.toDays(
                  cal.get(Calendar.HOUR_OF_DAY) + TimeOps.tzOffset() )
        );
  }

 /**
  * Calculate the present age of the moon in days.
  *
  * @return The lunar age in days (0.0 to 29.5306)
  */
  public static double ageOfMoonInDays( /* now */ ) {
    return ageOfMoonInDays( new GregorianCalendar() );
  }

 /**
  * Calculate the lunation for specified Julian day.
  * <P>
  * A "lunation" is E. W. Brown's numbered series of lunar cycles.
  * Lunation 1 was on January 16, 1923.
  *
  * @param jd Julian day
  *
  * @return Lunation number
  */
  public static int lunation( long jd ) {
    int lun = (int)( ( (double)jd - LUNATION_BASE ) / SYNODIC_MONTH );
    // "++" to make 1-based (vs. 0-based)
    return ++lun;
  }

 /**
  * Calculate the lunation for specified <TT>GregorianCalendar</TT>
  * instance.
  * <P>
  * A "lunation" is E. W. Brown's numbered series of lunar cycles.
  * Lunation 1 was on January 16, 1923.
  *
  * @param cal <TT>java.util.GregorianCalendar</TT> to use
  *
  * @return Lunation number
  */
  public static int lunation( GregorianCalendar cal ) {
    return lunation(
        DateOps.dmyToDay(
            cal.get(Calendar.DATE),
            cal.get(Calendar.MONTH)+1,    // Calendar has 0-based months (!)
            cal.get(Calendar.YEAR) ) );
  }

 /**
  * Calculate the lunation at the present time.
  * <P>
  * A "lunation" is E. W. Brown's numbered series of lunar cycles.
  * Lunation 1 was on January 16, 1923.
  *
  * @return Lunation number
  */
  public static int lunation( /* now */ ) {
    return lunation( new GregorianCalendar() );
  }

 /**
  * Build a current lunar information summary String.
  * <P>
  * The summary contains the lunation, age in days, rise, and set
  * times.
  *
  * @param oi - The observer's location
  *
  * @return The summary string
  */
  public static String summary(ObsInfo oi) {
    GregorianCalendar now = new GregorianCalendar();

    double age = ageOfMoonInDays(now);
    int iDays = (int)age;
    int iHours = (int)(((age - iDays) * 24.) + Astro.ROUND_UP);

    String info =  "Lunation " + lunation(now)
        + ", age " + iDays + "d " + iHours + "h, \n";

   /*** commented out until RiseSet gets fixed ***/
    double offset = TimeOps.tzOffsetInDays() + TimeOps.dstOffsetInDays(now) + .5;
    double jd = (double)DateOps.calendarToDay(now) - offset;

    TimePair rs = RiseSet.getTimes( RiseSet.MOON, jd, oi, new PlanetData() );

    String setSpace = "";
    if ( rs.a >= 0.) {
      info += "Rises " + TimeOps.formatTime(rs.a);
      setSpace = " ";
    }

    if ( rs.b >= 0.)
      info += setSpace + "Sets " + TimeOps.formatTime(rs.b);
    /***/

    return info;
  }

 /**
  * Build a current lunar information summary String for Phila, PA,
  * USA (a shameless convenience function for dvaa.org).
  * <P>
  * The default summary contains the lunation, age in days, rise,
  * and set times for Philadelphia, PA, USA as the observer's
  * location.
  *
  * @return The summary string
  */
  public static String summaryPHL() {
    return summary( new ObsInfo( new Latitude(39.95), new Longitude(-75.16) ) )
           + " (Phila, PA)";
  }

  //-------------------------------------------------------------------------
  // calculate the difference between lunar and solar ecliptic longitudes
  // at the given time
  //
  private static double calcDiff( PlanetData pd, double jd, ObsInfo loc ) {
    return pd.calcLon(Planets.LUNA, jd, loc) - pd.calcLon(Planets.EARTH, jd, loc);
  }
  //-------------------------------------------------------------------------
  // returns true if the two angles are NOT in the same quadrant
  //
  private static boolean quadDiff( double a1, double a2 ) {
    return AstroOps.quadrant( a1 ) != AstroOps.quadrant( a2 );
  }
  //-------------------------------------------------------------------------
 /**
  * Calculate the relatively exact time of the lunar quarter change
  * (NM, 1Q, FM, or 3Q).
  * <P>
  * Input must be less than one day before the exact change
  *
  * @param jd Approximate Julian day number of change
  * @param loc Observer location
  *
  * @return The relatively exact time
  */
  public static double quarterChange( double jd, ObsInfo loc ) {
    double longitude[] = new double[Astro.IHOURS_PER_DAY+1];    // 24 hrs + 1
    PlanetData pd = new PlanetData();

    // Compute the longitudes for each hour:
    //
    for( int i=0; i<=Astro.IHOURS_PER_DAY; i++ )
      longitude[i] = calcDiff( pd, jd + AstroOps.toDays(i), loc );

    double fraction = -1.;
    // Scan the hours, looking for quadrant change:
    //
    for( int i=0; i<Astro.IHOURS_PER_DAY; i++ ) {
      if ( quadDiff( longitude[i+1], longitude[i] ) ){
       // we found a quadrant change to refine

        double delta = 1.;
        int iterations = 10;
        fraction = AstroOps.toDays(i);
        double lonBase = longitude[i];
        double lonCur = lonBase;

        while( delta > .0001 && iterations > 0 ) {
          delta /= Astro.HOURS_PER_DAY;
          fraction += delta;
          System.out.println( "...frac=" + fraction + ", delta=" + delta );
          lonCur = calcDiff( pd, jd + fraction, loc );
          if ( quadDiff( lonBase, lonCur ))
            iterations--;
        }
        break;
      }
    }
    return fraction;
  }

 /**
  * (for unit testing only)
  */
  public static void main( String args[] ) {
    System.out.println( "LunarCalc Test" );

    // Note: Calendar.JANUARY = 0
    GregorianCalendar gc = new GregorianCalendar();
    for ( int i = 11; i < 17; i++ ) {
      gc.set(2002,Calendar.MARCH,i);
      System.out.println( "Lunation on 3/" + i + ": " + lunation(gc) );
    }
    for ( int i = 9; i < 16; i++ ) {
      gc.set(2002,Calendar.APRIL,i);
      System.out.println( "Lunation on 4/" + i + ": " + lunation(gc) );
    }

    System.out.println( summaryPHL() );

    /*
    ObsInfo oi = new ObsInfo( new Latitude(39.95), new Longitude(-75.16) );

    double jdNM = DateOps.dmyToDoubleDay( new AstroDate(12,2,2002) );
    double jdQ1 = DateOps.dmyToDoubleDay( new AstroDate(20,2,2002) );
    double jdFM = DateOps.dmyToDoubleDay( new AstroDate(27,2,2002) );
    double jdQ3 = DateOps.dmyToDoubleDay( new AstroDate(6,3,2002) );
    System.out.println( "NM: " + TimeOps.formatTime( quarterChange( jdNM, oi ) ) );
    System.out.println( "Q1: " + TimeOps.formatTime( quarterChange( jdQ1, oi ) ) );
    System.out.println( "FM: " + TimeOps.formatTime( quarterChange( jdFM, oi ) ) );
    System.out.println( "Q3: " + TimeOps.formatTime( quarterChange( jdQ3, oi ) ) );
    */
  }

}   // end class LunarCalc
