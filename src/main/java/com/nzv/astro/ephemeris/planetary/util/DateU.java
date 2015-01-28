/**
 ***************************************************************************\
 * DateU -- handy Date formatting shortcuts
 *
 * Created by Mark Huss <mark@mhuss.com>
 *
 * THIS SOFTWARE IS NOT COPYRIGHTED
 *
 * This source code is offered for use in the public domain. You may
 * use, modify or distribute it freely.
 *
 * This code is distributed in the hope that it will be useful but
 * WITHOUT ANY WARRANTY. ALL WARRANTIES, EXPRESS OR IMPLIED ARE HEREBY
 * DISCLAMED. This includes but is not limited to warranties of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Darn lawyers.
 *
\***************************************************************************/

package com.nzv.astro.ephemeris.planetary.util;

import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple set of date and time formatters. This once trivial task
 * got a bit complicated after the addition of i18n support.
 */
public class DateU {
 /**
  * Return 'now' as a date <TT>String</TT> using the default Locale
  *
  * @param dateFmt The java.text.DateFormat constant to use
  *     (<TT>FULL</TT>, <TT>LONG</TT>, <TT>MEDIUM</TT>, or
  *     <TT>SHORT</TT>).
  *
  * @return The current, formatted, date as a String
  */
  public static String dateNow( int dateFmt ) {
    return DateFormat.getDateInstance( dateFmt ).format( new Date() );
  }

 /**
  * Return 'now' as a date <TT>String</TT> using the default Locale
  * and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @return The current formatted date as a <TT>String</TT>
  */
  public static String dateNow() {
    return dateNow( DateFormat.MEDIUM );
  }

 /**
  * Return 'now' as a date and time <TT>String</TT> using the default
  * Locale and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @return The current, formatted, date and time as a String
  */
  public static String dateTimeNow() {
    return DateFormat.getInstance().format( new Date() );
  }

 /**
  * Convert a <TT>Date</TT> into a date <TT>String</TT> using the
  * default Locale.
  *
  * @param d The java.util.Date to convert
  * @param dateFmt The <TT>java.text.DateFormat</TT> constant to use
  *     (<TT>FULL</TT>, <TT>LONG</TT>, <TT>MEDIUM</TT>, or
  *     <TT>SHORT</TT>).
  *
  * @return The date formatted as a String
  */
  public static String date( Date d, int dateFmt ) {
    return DateFormat.getDateInstance( dateFmt ).format( d );
  }

 /**
  * Convert a <TT>Date</TT> into a date <TT>String</TT> using the
  * default Locale and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @param d The <TT>java.util.Date</TT> to convert
  *
  * @return The date formatted as a <TT>String</TT>
  */
  public static String date( Date d ) {
    return date( d, DateFormat.MEDIUM );
  }

 /**
  * Convert a <TT>Date</TT> into a time <TT>String</TT> using the
  * default Locale
  *
  * @param d The <TT>java.util.Date</TT> to convert
  * @param dateFmt The <TT>java.text.DateFormat</TT> constant to use
  *     (<TT>FULL</TT>, <TT>LONG</TT>, <TT>MEDIUM</TT>, or
  *     <TT>SHORT</TT>).
  *
  * @return The time formatted as a <TT>String</TT>
  */
  public static String time( Date d, int dateFmt ) {
    return DateFormat.getTimeInstance( dateFmt ).format( d );
  }

 /**
  * Convert a <TT>Date</TT> into a time <TT>String</TT> using the
  * default Locale and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @param d The <TT>java.util.Date</TT> to convert
  *
  * @return The time formatted as a <TT>String</TT>
  */
  public static String time( Date d ) {
    return time( d, DateFormat.MEDIUM );
  }

 /**
  * Convert a <TT>Date</TT> into a date and time <TT>String</TT> using
  * the default Locale
  *
  * @param d The <TT>java.util.Date</TT> to convert
  * @param dtFmt The <TT>java.text.DateFormat</TT> constant to use
  *     (<TT>FULL</TT>, <TT>LONG</TT>, <TT>MEDIUM</TT>, or
  *     <TT>SHORT</TT>).
  *
  * @return The date and time formatted as a <TT>String</TT>
  */
  public static String dateTime( Date d, int dtFmt ) {
    return DateFormat.getDateTimeInstance( dtFmt, dtFmt ).format( d );
  }

 /**
  * Convert a <TT>Date</TT> into a date and time <TT>String</TT> using
  * the default Locale and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @param d The <TT>java.util.Date</TT> to convert
  *
  * @return The date and time formatted as a <TT>String</TT>
  */
  public static String dateTime( Date d ) {
    return dateTime( d, DateFormat.MEDIUM );
  }

 /**
  * Convert a <TT>Calendar</TT> into a date and time <TT>String</TT>
  * using the default Locale and the <TT>DateFormat.MEDIUM</TT> size.
  *
  * @param c The <TT>java.util.Calendar</TT> to convert
  *
  * @return The date and time formatted as a <TT>String</TT>
  */
  public static String dateTime( Calendar c ) {
    return dateTime( c.getTime(), DateFormat.MEDIUM );
  }
}
