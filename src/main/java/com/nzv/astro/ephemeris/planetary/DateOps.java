/*****************************************************************************\
 * DateOps.java
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

//import com.mhuss.Util.DateU;

//---------------------------------------------------------------------------
/**
 * A support class for DateOps
 */
class DateConversionData {

 /**
  * Gregorian/Julian calendar values
  */
  static final int sMonthDays[] = {
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 0 };

 /**
  * Number of entries in MonthDays table
  */
  public static final int MONTH_DAYS = 13;

 /**
  * Number of days in each month
  */
  int monthDays[];

 /**
  * Number of days to end of year
  */
  long yearEndDays;

 /**
  * Number of days to end of following year
  */
  long nextYearEndDays;
  int year;

 /**
  * Constructor
  *
  * @param y year
  */
  DateConversionData(int y) {
    monthDays = new int[MONTH_DAYS];
    for (int i=0; i<MONTH_DAYS; i++ )
      monthDays[i] = sMonthDays[i];
    year = y;
  }
}

/**
 * A class to perform calendrical conversions.
 * <P>
 * Note that the Julian Day Number (JD), widely used in astronomical
 * calculations, is different from and not directly related to the
 * Julian <I>Calendar</I> discussed below.
 * <P>
 * Based on code by Bill Gray (www.projectpluto.com)
 * <P>
 * <I>Bill Gray's Comments:</I><BR>
 * General calendrical comments:
 * <P>
 * This code supports conversions between JD and two calendrical
 * systems: Julian and Gregorian. Comments pertaining to specific
 * calendars are found near the code for those calendars.
 * <P>
 * [mhuss: The original C code, which these comments are paraphrased
 * from, supported other calendars - these may be supported here in
 * the future, but for now we're pretty Gregorian.]
 * <P>
 * For each calendar, there is a <TT>(cal)DateConversionData</TT>" class,
 * used only within this code module. This class takes a particular
 * year number, and computes the JD corresponding to "new years day"
 * (first day of the first month) in that calendar in that year. It
 * also figures out the number of days in each month of that year,
 * returned in the array month_data[]. There can be up to 13 months,
 * because the Hebrew calendar (and some others that may someday be
 * added) can include an "intercalary month".  If a month doesn't
 * exist, then the month_data[] entry for it will be zero (thus, in
 * the Gregorian and Julian and Islamic calendars, month_data[12] is
 * always zero, since these calendars have only 12 months.)
 * <P>
 * [mhuss: The code here only supports Gregorian and Julian, so the
 * class is just called <TT>DateConversionData</TT>. When I get
 * around to doing the rest, <TT>DateConversionData</TT> will be
 * the interface or base class used by all.]
 * <P>
 * The next level up is the <TT>getCalendarData()</TT> function, which
 * can get the JD of New Years Day and the array of months for any given
 * year for any (supported) calendar. Above this point, all calendars
 * can be treated in a common way; one is shielded from the oddities
 * of individual calendrical systems.
 * <P>
 * Finally, at the top level, we reach the only functionality that is
 * exported for the rest of the world to use: <TT>dmyToDay()</TT> and
 * <TT>dayToDmy()</TT>. The first (and its variations) takes a day,
 * month, year, and optionally, a calendar system. It calls
 * <TT>getCalendarData()</TT> for the given year, adds in the days in
 * the months intervening New Years Day and the desired month, adds
 * in the day of the month, and returns the resulting Julian Day.
 * <P>
 * dayToDmy() reverses this process. It finds an "approximate" year
 * corresponding to an input JD,  and calls <TT>getCalendarData()</TT>
 * for that year. By adding all the monthData[] values for that year,
 * it can also find the JD for the <B>end</B> of that year; if the
 * input JD is outside that range, it may have to back up a year or
 * add in a year. Once it finds the year where
 * "JD of New Years Day < JD < JD of New Years Eve",
 * it's a simple matter to track down which month and day of the month
 * corresponds to the input JD.
 */
public class DateOps {

 /**
  * Abbreviated month names
  */
  final String monthNames[] = {
     "Jan", "Feb", "Mar", "Apr", "May", "Jun",
     "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
  };

 /**
  * Pseudo-enum for calendar type
  */
  public static final int GREGORIAN = 0, JULIAN = 1;

 /**
  * Converts a day/month/year to a Julian day in <TT>long</TT> form.
  *
  * @param day Day of the month (1..31)
  * @param month Month of the Year (1..12)
  * @param year Year
  * @param calendar GREGORIAN or JULIAN
  *
  * @return The corresponding Julian day number
  */
  public static long dmyToDay(
      int day, int month, int year, int calendar )
  {
   /*
    * Bill Gray's Comments:
    * This function gets calendar data for the current year,
    * including the Julian day  of New Years Day for that year.  After
    * that, all it has to do is add up the days in intervening months,
    * plus the day of the month, and it's done.
    */
    DateConversionData dcd = new DateConversionData( year );
    long jd = 0;
    if( getCalendarData( dcd, calendar ) ) {
      jd = dcd.yearEndDays;
      for( int i=0; i<(month-1); i++ ) {
        jd += dcd.monthDays[i];
      }
      jd += (long)(day - 1);
    }
    return jd;
  }

 /**
  * Converts a GREGORIAN day/month/year to a Julian day in <TT>long</TT>
  * form.
  *
  * @param day Day of the month (1..31)
  * @param month Month of the Year (1..12)
  * @param year Year
  *
  * @return The corresponding Julian day number
  */
  public static long dmyToDay( int day, int month, int year ) {
    return dmyToDay( day, month, year, GREGORIAN );
  }

 /**
  * Converts an AstroDate to a Julian day in long form.
  * <BR>
  * This function uses the GREGORIAN calendar.
  *
  * @param d AstroDate to convert
  *
  * @return The corresponding Julian day number
  */
  public static long dmyToDay( AstroDate d ) {
    return dmyToDay( d.day, d.month, d.year, GREGORIAN );
  }

 /**
  * Converts a day/month/year to a Julian day in <TT>double</TT> form.
  * <BR>
  * This function uses the GREGORIAN calendar.
  *
  * @param d AstroDate to convert
  *
  * @return The corresponding Julian day number
  */
  public static double dmyToDoubleDay( AstroDate d ) {
    return d.second / Astro.SECONDS_PER_DAY - .5 +
        dmyToDay( d.day, d.month, d.year, GREGORIAN );
  }

 /**
  * Converts a Julian day to an <TT>AstroDate</TT>.
  *
  * @param jd Julian day to convert
  * @param d <TT>AstroDate</TT> to put the results into
  * @param calendar GREGORIAN or JULIAN
  */
  static void dayToDmy( long jd, AstroDate d, int calendar )
  {
   /*
    * Bill Gray's Comments:
    * Estimates the year corresponding to an input JD and calls
    * getCalendarData() for that year.  Occasionally,  it will find
    * that the guesstimate was off; in such cases,  it moves ahead
    * or back a year and tries again.  Once it's done,
    * jd - yearEndDays gives the number of days since New Years Day;
    * by subtracting monthDays[] values,  we quickly determine which
    * month and day of month we're in.
    */
    d.day = -1;           /* to signal an error */
    switch( calendar) {
    case GREGORIAN:
    case JULIAN:
      d.year = (int)((jd - E_JULIAN_GREGORIAN) / 365L);
      break;
    default:       /* undefined calendar */
      return;
    }  // end switch()

    DateConversionData dcd = new DateConversionData( d.year );

    do {
      if( !getCalendarData( dcd, calendar ) )
        return;

      if( dcd.yearEndDays > jd)
        d.year--;

      if( dcd.nextYearEndDays <= jd)
        d.year++;

      dcd.year = d.year;

    } while( dcd.yearEndDays > jd || dcd.nextYearEndDays <= jd );

    long currJd = dcd.yearEndDays;
    d.month = -1;
    for( int i = 0; i < DateConversionData.MONTH_DAYS; i++) {
      d.day = (int)( jd - currJd );
      if( d.day < dcd.monthDays[i] ) {
        d.month = i + 1;
        d.day++;
        return;
      }
      currJd += (long)( dcd.monthDays[i] );
    }
    return;
  }

 /**
  * Converts a Julian day in <TT>long</TT> form to a GREGORIAN
  * <TT>AstroDate</TT>.
  *
  * @param jd Julian day to convert
  * @param d <TT>AstroDate</TT> to insert results into
  */
  static void dayToDmy( long jd, AstroDate d ) {
    dayToDmy( jd, d, GREGORIAN );
  }

 /**
  * Converts a Julian day in <TT>double</TT> form to an AstroDate.
  * <BR>
  * This function has higher precision than the <TT>long</TT> version.
  *
  * @param jd Julian day to convert
  * @param d AstroDate to insert results into
  * @param calendar GREGORIAN or JULIAN
  */
  static void dayToDmy( double jd, AstroDate d, int calendar ) {
    dayToDmy( (long)jd, d, calendar );
    d.second = (jd - Math.floor(jd)) * Astro.SECONDS_PER_DAY;
  }

 /**
  * Converts a Julian day in <TT>double</TT> form to a GREGORIAN
  * <TT>AstroDate</TT>. <BR>
  * This function has higher precision than the <TT>long</TT> version.
  *
  * @param jd Julian day to convert
  * @param d AstroDate to insert results into
  */
  static void dayToDmy( double jd, AstroDate d ) {
    dayToDmy( jd, d, GREGORIAN );
  }

  //--------------------------------------------------------------------------

 /**
  * Convert a Java <TT>Calendar</TT> to Julian day value in
  * <TT>long</TT> form.
  *
  * @param cal <TT>java.util.Calendar</TT> to convert
  *
  * @return The corresponding Julian day
  */
  public static long calendarToDay( Calendar cal ) {
    return dmyToDay(
          cal.get(Calendar.DATE),
          cal.get(Calendar.MONTH)+1,  // Calendar has 0-based months (!)
          cal.get(Calendar.YEAR)
        );
  }

 /**
  * Convert a Java Calendar to a Julian day value in <TT>double</TT>
  * form.
  *
  * @param cal <TT>java.util.Calendar</TT> to convert
  *
  * @return The corresponding Julian day
  */
  public static double calendarToDoubleDay( Calendar cal ) {

    double hours = (double)cal.get(Calendar.HOUR_OF_DAY)
                 + cal.get(Calendar.MINUTE) / Astro.MINUTES_PER_HOUR
                 + cal.get(Calendar.SECOND) / (double)Astro.SECONDS_PER_HOUR
                 - TimeOps.tzOffset(cal);
    return (double) calendarToDay( cal ) + hours/Astro.HOURS_PER_DAY - 0.5;
  }

 /**
  * Calculate the <B>current</B> Julian day value in <TT>double</TT>
  * form.
  *
  * @return The corresponding Julian day
  */
  public static double nowToDoubleDay() {
    return calendarToDoubleDay( new GregorianCalendar() );
  }

 /**
  * Calculate the <B>current</B> Julian day value in <TT>long</TT>
  * form.
  *
  * @return The corresponding Julian day
  */
  public static long nowToDay() {
    return calendarToDay( new GregorianCalendar() );
  }

 /**
  * Calculate the Julian day number for the date when Daylight time
  * starts in a given year.
  * <P>
  * The chosen start day is the first Sunday in April, and therefore
  * this function may not be applicable outside the U.S.
  *
  * @param year The year of interest
  *
  * @return The corresponding Julian day
  */
  public static long dstStart(int year)
  {
    // first Sunday in April
    long jdStart = dmyToDay( 1, 4, year );
    while ( 6 != (jdStart % 7 ) ) // Sunday
      jdStart++;

    return jdStart;
  }

 /**
  * Calculate the Julian day number for the date when Daylight time
  * ends in a given year.
  * <P>
  * This chosen day is the last Sunday in October, and therefore
  * this function may not be applicable outside the U.S.
  *
  * @param year The year of interest
  *
  * @return The corresponding Julian day
  */
  public static long dstEnd(int year)
  {
    // last Sunday in October
    long jdEnd = dmyToDay( 31, 10, year );
    while ( 6 != (jdEnd % 7 ) ) // Sunday
      jdEnd--;

    return jdEnd;
  }

  //-------------------------------------------------------------------------

  private static final long E_JULIAN_GREGORIAN = 1721060L;

 /**
  * Gregorian and Julian calendar calculations (combined for simplicity)
  * <P>
  * Bill Gray's Comments:<BR>
  * It's common to implement Gregorian/Julian calendar code with the
  * aid of cryptic formulae, rather than through simple lookup tables.
  * For example,  consider this formula from Fliegel and Van Flandern,
  * to convert Gregorian (D)ay, (M)onth, (Y)ear to JD:
  * <P>
  * <TT>
  *    JD = (1461*(Y+4800+(M-14)/12))/4+(367*(M-2-12*((M-14)/12)))/12
  *       -(3*((Y+4900+(M-14)/12)/100))/4+D-32075
  * </TT>
  * <P>
  * The only way to verify that they work is to feed through all
  * possible cases.  Personally, I like to be able to look at a chunk
  * of code and see what it means. It should resemble the Reformation
  * view of the Bible: anyone can read it and witness the truth thereof.
  *
  * @param dcd The <TT>DateConversionData</TT> to use
  * @param julian <TT>true</TT> for Julian calendar, else Gregorian
  */
  private static void getJulGregYearData(
      DateConversionData dcd, boolean julian )
  {
    if( dcd.year >= 0 ) {
      dcd.yearEndDays = dcd.year * 365 + dcd.year / 4;
      if( !julian )
        dcd.yearEndDays += -dcd.year / 100L + dcd.year / 400L;
    }
    else {
      dcd.yearEndDays = (dcd.year * 365) + (dcd.year - 3) / 4;
      if( !julian )
        dcd.yearEndDays += -(dcd.year - 99) / 100 + (dcd.year - 399) / 400;
    }

    if( julian )
      dcd.yearEndDays -= 2;

    if( 0 == (dcd.year % 4)) {
      if( 0 !=(dcd.year % 100) || 0 == (dcd.year % 400) || julian ) {
        dcd.monthDays[1] = 29;
        dcd.yearEndDays--;
      }
    }
    dcd.yearEndDays += E_JULIAN_GREGORIAN + 1;
  }

  //-------------------------------------------------------------------------
 /**
  * @param dcd The <TT>DateConversionData</TT> to use
  * @param julian <TT>true</TT> for Julian calendar, else Gregorian
  *
  * @return <TT>true</TT> if successful, <TT>false</TT> otherwise.
  */
  private static boolean getCalendarData(
      DateConversionData dcd, int calendar )
  {
    boolean isOk = true;

    //dcd.monthDays[0] = 0;
    switch( calendar)
    {
      case GREGORIAN:
      case JULIAN:
          getJulGregYearData( dcd, (JULIAN == calendar) );
          break;
      default:
          isOk = false;
          break;
    }
    if ( isOk ) {
      //
      // days[1] = JD of "New Years Eve" + 1;  that is, New Years Day of the
      // following year.  If you have days[0] <= JD < days[1],  JD is in the
      // current year.
      //
      dcd.nextYearEndDays = dcd.yearEndDays;
      for( int i=0; i<DateConversionData.MONTH_DAYS; i++ )
        dcd.nextYearEndDays += dcd.monthDays[i];
    }
    return( isOk );
  }

  //-------------------------------------------------------------------------
  /**
   * (for unit testing only)
   */
  public static void main( String args[] ) {
    System.out.println( "DateOps Test" );

    //AstroDate ad = new AstroDate();
    //double jd = dmyToDoubleDay(ad);

    //GregorianCalendar gc = new GregorianCalendar();
    //System.out.println( gc.get(Calendar.DST_OFFSET) );

    //GregorianCalendar gc = DateOps.jdToCal(  );
    //System.out.println( DateU.dateTime(gc) );

    // UTC now test

    GregorianCalendar utc = new GregorianCalendar(new SimpleTimeZone(0, "UTC"));

    int month = utc.get(Calendar.MONTH) + 1;
    int day = utc.get(Calendar.DAY_OF_MONTH);
    int year = utc.get(Calendar.YEAR);
    int hour = utc.get(Calendar.HOUR_OF_DAY);
    int minute = utc.get(Calendar.MINUTE);
    int seconds = utc.get(Calendar.SECOND);

    AstroDate astroDateUTC = new AstroDate(day, month, year, hour, minute, seconds);
    double julianDay_AstroDate = astroDateUTC.jd()
      - TimeOps.tzOffset(utc)/Astro.HOURS_PER_DAY;  // Astrodate has no built-in TZ

    System.out.println( "For current date in Greenwich:\njulianDay_AstroDate = "
      + julianDay_AstroDate);

    double julianDay_DateOps = DateOps.calendarToDoubleDay(utc);
    System.out.println( "julianDay_DateOps = " + julianDay_DateOps);

    System.out.println( "julianDay_DateOps - julianDay_AstroDate = " + (julianDay_DateOps - julianDay_AstroDate) * 24 + " hours");

    // Local TZ now test

    GregorianCalendar now = new GregorianCalendar();

    month = now.get(Calendar.MONTH) + 1;
    day = now.get(Calendar.DAY_OF_MONTH);
    year = now.get(Calendar.YEAR);
    hour = now.get(Calendar.HOUR_OF_DAY);
    minute = now.get(Calendar.MINUTE);
    seconds = now.get(Calendar.SECOND);

    AstroDate astroDateNow = new AstroDate(day, month, year, hour, minute, seconds);
    julianDay_AstroDate = astroDateNow.jd()
      - TimeOps.tzOffset(now)/Astro.HOURS_PER_DAY;  // Astrodate has no built-in TZ

    System.out.println( "For current date local TZ:\njulianDay_AstroDate = "
      + julianDay_AstroDate);

    julianDay_DateOps = DateOps.calendarToDoubleDay(now);
    System.out.println( "julianDay_DateOps = " + julianDay_DateOps);

    System.out.println( "julianDay_DateOps - julianDay_AstroDate = " + (julianDay_DateOps - julianDay_AstroDate) * 24 + " hours");

    // J2000

    AstroDate astroDate = new AstroDate();
    julianDay_AstroDate = astroDate.jd();
    System.out.println( "\nFor J2000:\njulianDay_AstroDate = " + julianDay_AstroDate);
    System.out.println( "julianDay_DateOps = " + DateOps.dmyToDay(astroDate));
    System.out.println("TimeOps.tzOffset() = " + TimeOps.tzOffset());
  }
};
