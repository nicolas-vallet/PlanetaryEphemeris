/*****************************************************************************\
 * AstroDate.java
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

import com.nzv.astro.ephemeris.planetary.util.Str;

import java.util.GregorianCalendar;
import java.util.TimeZone;

// A simple support class, for unit testing only
class ATest {
  public int year, month, day;
  public double frac, jd;

  ATest( int y, int m, int d, double f, double j ) {
    year=y; month=m; day=d; frac=f; jd = j;
  }
}

/**
 * A support class for DateOps.
 * <P>
 * This class stores a date/time value at a precision of one second.
 * This date/time can be specified using either the Gregorian Calendar
 * (by default) or the Julian Calendar.
 * <P>
 * It also supports conversions to and from the Julian Day number.
 */

public class AstroDate {
  /**
   * Default constructor = epoch J2000 (noon on 1/1/2000)
   */
  public AstroDate() {
    day = 1; month = 1; year = 2000; second = 12 * Astro.SECONDS_PER_HOUR;
  }

  /**
   * Literal (member by member) constructor
   *
   * @param day Day of the month (1...31)
   * @param month Month of the year (1..12)
   * @param year Year
   * @param seconds Time in seconds past midnight. This must be in the
   *  range from <TT>0</TT> to <TT>Astro.SECONDS_PER_DAY-1</TT>.
   */
  public AstroDate(int day, int month, int year, int seconds) {
    this.day=day; this.month=month; this.year=year; this.second=seconds;
  }

  /**
   * Explicit day, month, year, hour, minute, and second constructor
   *
   * @param day Day of the month (1...31)
   * @param month Month of the year (1..12)
   * @param year Year
   * @param hour Hour of the day (0...23)
   * @param min Minute of the hour (0...59)
   * @param sec Second of the minute (0...59)
   */
  public AstroDate(int day, int month, int year, int hour, int min, int sec) {
    this.day=day; this.month=month; this.year=year;
    this.second = hour*Astro.SECONDS_PER_HOUR + min*Astro.SECONDS_PER_MINUTE + sec;
  }

  /**
   * Day, Month, Year constructor (time defaults to 00:00:00 = midnight)
   *
   * @param day Day of the month (1...31)
   * @param month Month of the year (1..12)
   * @param year Year
   */
  public AstroDate(int day, int month, int year) {
    this.day = day; this.month=month; this.year=year; this.second=0;
  }

  /**
   * Day, Month, Year + fraction of a day constructor
   *
   * @param day Day of the month
   * @param month Month of the year
   * @param year Year
   * @param dayFraction Fraction of the day<BR>
   *  This must be greater than or equal to <TT>0.0</TT> and less
   *  than <TT>1.0</TT>.
   */
  public AstroDate(int day, int month, int year, double dayFraction) {
    this.day=day; this.month=month; this.year=year;
    this.second=dayFraction * Astro.SECONDS_PER_DAY;
  }

  /**
   * Julian Day constructor. <BR>
   *
   * @param jd Julian day number
   */
  public AstroDate( double jd ) {

    // The conversion formulas and magic numbers are from Meeus,
    // Chapter 7.
    jd = jd +0.5;                    // Einf�gung Strickling
    double Z = Math.floor(jd);
    double F = jd - Z;
    double A = Z;
    if ( Z >= 2299161D ) {
      int a = (int)(( Z - 1867216.25 )/Astro.TO_CENTURIES);
      A += 1 + a - a/4;
    }
    double B = A + 1524;
    int C = (int)((B-122.1)/365.25);
    int D = (int)(C * 365.25);
    int E = (int)((B-D)/30.6001);

    double exactDay = F + B - D - (int)(30.6001*E);
    day = (int)exactDay;
    month = (E<14) ? E-1 : E-13;
    year = C - 4715;
    if (month>2)
      year--;

    second = (exactDay - day) * Astro.SECONDS_PER_DAY;
  }

  //-------------------------------------------------------------------------
  // functions
  //-------------------------------------------------------------------------

  /**
   * Convert an <TT>AstroDate</TT> to a Julian Day.
   *
   * @param ad The date to convert
   * @param julian true = Julian calendar, else Gregorian
   *
   * @return The Julian Day that corresponds to the specified <TT>AstroDate</TT>
   */
  public static double jd( AstroDate ad, boolean julian ) {

    // The conversion formulas and magic numbers are from Meeus,
    // Chapter 7.

    int D = ad.day;
    int M = ad.month;
    int Y = ad.year;
    if ( M < 3 ) {
      Y--;
      M += 12;
    }
    int A = Y/100;
    int B = julian ? 0 : 2 - A + A/4;

    double dayFraction = ad.second / Astro.SECONDS_PER_DAY;

    return dayFraction
          + (int)(365.25D * (Y + 4716))
          + (int)(30.6001 * (M + 1))
          + D + B - 1524.5;
  }

  /**
   * Convert an <TT>AstroDate</TT> to a Julian Day. <BR>
   * Assumes the <TT>AstroDate</TT> is specified using the Gregorian calendar.
   *
   * @param ad The date to convert
   *
   * @return The Julian Day that corresponds to the specified
   *  <TT>AstroDate</TT>
   */
  public static double jd( AstroDate ad ) {
    return jd( ad, false );
  }

  /**
   * Convert this instance of <TT>AstroDate</TT> to a Julian Day. <BR>
   *
   * @param julian true = Julian calendar, else Gregorian
   *
   * @return The Julian Day that corresponds to this <TT>AstroDate</TT> instance
   */
  public double jd(boolean julian) {
    return jd( this, julian );
  }

  /**
   * Convert this instance of <TT>AstroDate</TT> to a Julian Day. <BR>
   * Assumes the <TT>AstroDate</TT> is specified using the Gregorian calendar.
   *
   * @return The Julian Day that corresponds to this <TT>AstroDate</TT> instance
   */
  public double jd() {
    return jd( this, false );
  }

  //-------------------------------------------------------------------------
  // accessors - NOTE: These do no sanity checking
  //-------------------------------------------------------------------------

  /**
   * Get the year. <BR>
   *
   * @return The year part of this instance of <TT>AstroDate</TT>
   */
  public int year() { return year; }

  /**
   * Set the year. <BR>
   *
   * @param The year part of this instance of <TT>AstroDate</TT>
   */
  void setYear(int y) { year = y; }

  /**
   * Get the month. <BR>
   *
   * @return The month part of this instance of <TT>AstroDate</TT> (1..12)
   */
  public int month() { return month; }

  /**
   * Set the month. <BR>
   *
   * @param The month part of this instance of <TT>AstroDate</TT> (1..12)<BR>
   *  Value is not checked!
   */
  void setMonth(int m) { month = m; }

  /**
   * Get the day. <BR>
   *
   * @return The day part of this instance of <TT>AstroDate</TT> (1..31)
   */
  public int day() { return day; }

  /**
   * Set the day. <BR>
   *
   * @param The day part of this instance of <TT>AstroDate</TT> (1..31)
   *  Value is not checked!
   */
  void setDay(int d) { day = d; }

  /**
   * Get the Hour. <BR>
   * This function truncates, and does not round up to nearest hour.
   * For example, this function will return '1' at all times from
   * 01:00:00 to 01:59:59 inclusive.
   *
   * @return The hour of the day for this instance of <TT>AstroDate</TT>,
   *     not rounded
   */
  public int hour() {
    return (int)(second / Astro.SECONDS_PER_HOUR);
  }

  /**
   * Get the rounded hour. <BR>
   * Returns the hour of the day rounded to nearest hour.
   * For example, this function will return '1' at times 01:00:00 to
   * 01:29:59, and '2' at times 01:30:00 to 01:59:59.
   *
   * @return The hour of the day for this instance of <TT>AstroDate</TT>,
   * rounded to the nearest hour.
   */
  public int hourRound() {
    return (int)((second / Astro.SECONDS_PER_HOUR) + Astro.ROUND_UP);
  }

  /**
   * Get the minute. <BR>
   *
   * This function truncates, and does not round up to nearest minute.
   * For example, this function will return 20 at all times from
   * 1:20:00 to 1:20:59 inclusive.
   *
   * @return The minute of the hour for this instance of <TT>AstroDate</TT>,
   *     not rounded.
   */
  public int minute() {
    return (int)((second - (hour() * Astro.SECONDS_PER_HOUR))/Astro.SECONDS_PER_MINUTE);
  }

  /**
   * Get the rounded minute. <BR>
   *
   * Returns the minute of the hour for this instance of <TT>AstroDate</TT>,
   * rounded to nearest minute.
   * For example, this function will return 20 at times 1:20:00 to
   * 1:20:29, and 21 at times 1:20:30 to 1:20:59.
   *
   * @return The minute of the hour for this instance of <TT>AstroDate</TT>,
   * rounded to the nearest minute.
   */
  public int minuteRound() {
    return (int)(((second - (hour() * Astro.SECONDS_PER_HOUR))/Astro.SECONDS_PER_MINUTE) + Astro.ROUND_UP);
  }

  /**
   * Get the second.
   *
   * @return The second of the minute for this instance of <TT>AstroDate</TT>.
   *
   */
  public int second() {
    return (int)(second - (hour() * Astro.SECONDS_PER_HOUR) - (minute() * Astro.SECONDS_PER_MINUTE));
  }

  /**
   * Convert this AstroDate instance to a <TT>GregorianCalendar</TT>. <BR>
   *
   * @return An instance of <TT>java.util.GregorianCalendar</TT> built
   *     using this instance of AstroDate.
   */
  public GregorianCalendar toGCalendar() {
    return new GregorianCalendar( year, month-1, day, hour(), minute(), second() );
  }

  /**
   * Convert this <TT>AstroDate</TT> instance to a <TT>String</TT>,
   * formatted to the minute.
   * This function rounds the exact time to the nearest minute.
   * <P>
   * The format of the returned string is <TT>YYYY-MM-DD hh:mm</TT>.
   *
   * @return A formatted date/time <TT>String<TT>
   */
  public String toMinString() {
    return  Str.fmt( year, 4, '-' ) +  Str.fmt( month, '-' ) +
            Str.fmt( day, ' ' ) +      Str.fmt( hour(), ':' ) +
            Str.fmt( minuteRound());
  }

  /**
   * Convert this <TT>AstroDate</TT> instance to a String formatted
   * to the minute, with Time Zone indicator. <BR>
   * Rounds the time to the nearest minute.
   * <P>
   * The format of the returned string is  <TT>YYYY-MM-DD hh:mm TZ</TT>,
   * where <TT>TZ</TT> is a locale-specific timezone name (e.g., "EST").
   *
   * @return A formatted date/time <TT>String</TT>
   */
  public String toMinStringTZ() {
    TimeZone tz = TimeZone.getDefault();
    return toMinString() + ' ' +
        tz.getDisplayName( TimeOps.dstOffset(toGCalendar()) != 0, TimeZone.SHORT);
  }

  /**
   * Convert <B>this</B> <TT>AstroDate</TT> instance to a <TT>String</TT>.
   * <P>
   * The format of the returned string is  <TT>YYYY-MM-DD hh:mm:ss</TT>.
   *
   * @return A formatted date/time <TT>String</TT>
   */
  public String toString() {
    return "" +
        Str.fmt( year, 4, '-' ) +  Str.fmt( month, '-' ) +
        Str.fmt( day, ' ' ) +      Str.fmt( hour(), ':' ) +
        Str.fmt( minute(), ':' )  + Str.fmt( second() );
  }

  /**
   * Convert <B>this</B> <TT>AstroDate</TT> instance to a <TT>String</TT>,
   * with Time Zone indicator.
   * <P>
   * The format of the returned string is <TT>YYYY-MM-DD hh:mm:ss TZ</TT>,
   * where <TT>TZ</TT> is a locale-specific timezone name (e.g., "EST")
   *
   * @return A formatted date/time <TT>String</TT>
   */
  public String toStringTZ() {
    TimeZone tz = TimeZone.getDefault();
    return toString() + ' ' +
        tz.getDisplayName( TimeOps.dstOffset(toGCalendar()) != 0, TimeZone.SHORT);
  }

  //-------------------------------------------------------------------------
  /**
   * day of the month
   */
  int day;

  /**
   * month of the year
   */
  int month;

  /**
   * year
   */
  int year;

  /**
   * Seconds past midnight == day fraction. <BR>
   * Valid values range from 0 to Astro.SECONDS_PER_DAY-1.
   */
  double second;

  //-------------------------------------------------------------------------
  /**
   * (for unit testing only)
   */
  public static void main( String args[] ) {
    System.out.println( "AstroDate Test" );

    ATest at[] = new ATest[7];
    // data from Meeus
    at[0] = new ATest( 2000,  1,  1,  .5, 2451545. );
    at[1] = new ATest( 1987,  6,  19, .5, 2446966. );
    at[2] = new ATest( 1900,  1,  1,  .0, 2415020.5 );
    at[3] = new ATest( 1600,  12, 31, .0, 2305812.5 );
    at[4] = new ATest( 837,   4,  10, .3, 2026871.8 );
    at[5] = new ATest( -1000, 7,  12, .5, 1356001. );
    at[6] = new ATest( -4712, 1,  1,  .5, 0. );

    for (int i=0; i<7; i++) {
      AstroDate ad = new AstroDate( at[i].day, at[i].month, at[i].year, at[i].frac );
      double jdm = ad.jd();
      double jdg = 0; //** circular reference ** DateOps.dmyToDoubleDay(ad);
      System.out.println(
        "year: " + at[i].year + ", expected: " + at[i].jd +
        ", jd(m)=" + jdm + ", jd(g)=" + jdg );
    }

    //jd = 2305812.5;
    //AstroDate ad = new AstroDate( jd );
    //System.out.println( "" + ad.year + '/' + ad.month + '/' + ad.day + ad.second / AstroDate.SECONDS_PER_DAY );


    //GregorianCalendar gc = DateOps.jdToCal(  );
    //System.out.println( DateU.dateTime(gc) );

  }

}

