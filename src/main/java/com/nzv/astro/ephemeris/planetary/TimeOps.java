/*****************************************************************************\
 * TimeOps.java
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * TimeOps contains miscellaneous time-related functions. <BR>
 * These are not in DateOps because they cause a circular dependancy
 * between DateOps and AstroDate
 */
public class TimeOps {

 /**
  * Calculate the current Daylight Time offset ( 0 or -1 ). <BR>
  * Add the result of this function to the current time to adjust.
  *
  * @param cal A <TT>java.util.Calendar</TT> object which is used to
  *     get the <TT>DST_OFFSET</TT>
  * from (e.g., <TT>java.util.GregorianCalendar</TT>)
  *
  * @return <TT>DST_OFFSET</TT> in hours if Daylight time is in effect,
  *     0 otherwise.
  */
  public static int dstOffset( Calendar cal ) {
    return cal.get(Calendar.DST_OFFSET)/Astro.MILLISECONDS_PER_HOUR;
  }

 /**
  * Calculate the current Daylight Time offset. <BR>
  * Add the result of this function to the current time to adjust.<BR>
  * This function uses a <TT>GregorianCalendar</TT> object.
  *
  * @return <TT>DST_OFFSET</TT> in hours if Daylight time is in
  *     effect, 0 otherwise.
  */
  public static int dstOffset() {
    return dstOffset(new GregorianCalendar());
  }

 /**
  * Calculate the current Daylight Time offset in fractional days. <BR>
  * Add the result of this function to the current time to adjust.
  *
  * @param cal A <TT>java.util.Calendar</TT> object which is used to
  *     get the <TT>DST_OFFSET</TT>
  *
  * @return <TT>DST_OFFSET</TT> in days if Daylight time is in effect,
  *     0 otherwise.
  */
  public static double dstOffsetInDays(Calendar cal) {
    return (double)dstOffset(cal) * Astro.DAYS_PER_HOUR;
  }

 /**
  * Calculate the current Daylight Time offset in fractional days. <BR>
  * Add the result of this function to the current time to adjust.<BR>
  * This function uses a <TT>GregorianCalendar</TT> object.
  *
  * @return <TT>DST_OFFSET</TT> in days if Daylight time is in effect,
  *     0 otherwise.
  */
  public static double dstOffsetInDays() {
    return (double)dstOffset() * Astro.DAYS_PER_HOUR;
  }

 /**
  * Determine the absolute time zone offset from UTC in hours
  * (-12 to +12) for the spec'd Calendar.
  *
  * @param cal The Calendar to use
  *
  * @return The offset in hours
  */
  public static int tzOffset(Calendar cal) {
    return cal.get(Calendar.ZONE_OFFSET)/Astro.MILLISECONDS_PER_HOUR;
  }

 /**
  * Determine the absolute time zone offset from UTC in hours
  * (-12 to +12) using the local timezone.
  *
  * @return The offset in hours
  */
  public static int tzOffset() {
    return tzOffset( new GregorianCalendar() );
  }

 /**
  * Determine the absolute time zone offset from UTC in fractional
  * days (-0.5 to +0.5).
  *
  * @param cal The Calendar to use
  *
  * @return The offset in decimal day
  */
  public static double tzOffsetInDays(Calendar cal) {
    return (double)tzOffset(cal) * Astro.DAYS_PER_HOUR;
  }

 /**
  * Determine the absolute time zone offset from UTC in fractional
  * days (-0.5 to +0.5).
  *
  * @return The offset in decimal day
  */
  public static double tzOffsetInDays() {
    return (double)tzOffset() * Astro.DAYS_PER_HOUR;
  }

 /**
  * Format a time as a <TT>String</TT> using the format <TT>HH:MM</TT>. <BR>
  * The returned string will be "--:--" if the time is INVALID.
  *
  * @param t The time to format in days
  *
  * @return The formatted String
  */
  public static String formatTime(double t)
  {
    String ft = "--:--";

    if( t >= 0D) {
      // round up to nearest minute
      int minutes = (int)
          (t * Astro.HOURS_PER_DAY * Astro.MINUTES_PER_HOUR + Astro.ROUND_UP);
      ft = twoDigits(minutes / Astro.IMINUTES_PER_HOUR) + ":" +
           twoDigits(minutes % Astro.IMINUTES_PER_HOUR);
    }
    return ft;
  }

  //-------------------------------------------------------------------------
  // returns String version of two digit number, with leading zero if needed
  // The input is expected to be in the range 0 to 99
  //
  private static String twoDigits(int i) {
    return (i > 9) ? "" + i : "0" + i;
  }
}
