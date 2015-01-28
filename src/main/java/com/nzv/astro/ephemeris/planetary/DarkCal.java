/***************************************************************************\
 * DarkCal -- an app to figure out what the darkest hours are for a given
 *            location & month
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

package com.nzv.astro.ephemeris.planetary;

import java.io.*;
//import java.util.Properties;
import java.text.DecimalFormat;
//import com.mhuss.AstroLib.*;


import com.nzv.astro.ephemeris.planetary.util.Str;

/**
 * A command-line program to determine the darkest hours for a
 * given location & month. This is meant to be an aid for planning
 * your observing.
 */
public class DarkCal {
  static final String monthNames[] = {
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
  };

  static final String CFG_EXT = ".cfg";

  static final int DST_NONE = 0, DST_START=1, DST_END=2;

  boolean g_tabDelimited = false; // true means produce tab-delimited output
  boolean g_ignoreDst = false;    // true means ignore DST
  boolean g_html = false;         // true means produce HTML output
  boolean g_printable = false;    // true means produce printer-friendly HTML output
  PrintWriter g_pw;               // file to use for tab-d or HTML
  String g_optLink = "&nbsp;";    // optional return link

  //----------------------------------------------------------------------------
  DarkCal() {}

 /**
  * Constructor (HTML switch only)
  *
  * @param html true to produce HTML formatted output, plain text otherwise
  */
  public DarkCal(boolean html) { g_html = html; }

 /**
  * Constructor (<TT>PrintWriter</TT> and HTML switch)
  *
  * @param pw <TT>java.io.PrintWriter</TT> instance to use for output
  * @param html true to produce HTML formatted output, plain text otherwise
  */
  public DarkCal(PrintWriter pw, boolean html) {
    g_pw = pw;
    g_html = html;
  }

 /**
  * Constructor (<TT>PrintWriter</TT>, HTML switch, and printable switch)
  *
  * @param pw <TT>java.io.PrintWriter</TT> instance to use for output
  * @param html true to produce HTML formatted output, plain text otherwise
  * @param printable true to produce HTML in a more printer-friendly format
  */
  public DarkCal(PrintWriter pw, boolean html, boolean printable) {
    g_pw = pw;
    g_html = html;
    g_printable = printable;
  }

  //----------------------------------------------------------------------------
 /**
  * set <TT>PrintWriter</TT>
  *
  * @param pw <TT>java.io.PrintWriter</TT> instance to use for output
  */
  void setWriter( PrintWriter pw ) {
    g_pw = pw;
  }

  //----------------------------------------------------------------------------
 /**
  * Set the optional return link URL. It only makes sense to use
  * this function when the HTML output option is enabled.
  *
  * @param s The URL of the return link to insert into the HTML
  */
  public void setOptLink( String s ) {
    g_optLink = s;
  }

  //----------------------------------------------------------------------------
  // print heading
  //
  private void printHeading(DarkCalInput cd) {
    DecimalFormat llfmt = new DecimalFormat("##0.00");
    String pUtc = ( cd.tz < 0 ) ? "UTC" : "UTC+";
    String date = monthNames[ cd.month-1 ] + " " + cd.year;
    String location =  "latitude " +
        llfmt.format(cd.lat)  + ", longitude " +
        llfmt.format(cd.lon)  + ", timezone " +
        pUtc + cd.tz;

    if ( g_tabDelimited ) {
      g_pw.println( "\n" + date + " " + location + "\n\n" +
        "Day\tDarkest Hours\tEvent\tMoon Rises\tMoon Sets\t" +
        "Sunset\tAstronomical Twilight Ends\tNext Day\t" +
        "Astronomical Twilight Starts\tSunrise\n");
    }
    else if (g_html) {
      g_pw.println( "<HTML>\n" +
            "<HEAD>\n" +
            "  <TITLE>Darkest Hours</TITLE>\n" +
            "</HEAD>\n" );
      if ( g_printable )
        g_pw.println(
            "<BODY BGCOLOR=\"#FFFFE0\">\n" +
            "<STYLE type=\"text/css\">\n<!--\n" +
            "  BODY { background:#FFFFE0 }\n" +
            "  TD.title { font-size:14px; background:#E0E099 }\n" +
            "  TR.bar { background:#E0E099 }\n" );
      else
        g_pw.println(
            "<BODY TEXT=\"#DDDDDD\" BGCOLOR=\"#002048\">\n" +
            "<STYLE type=\"text/css\">\n<!--\n" +
            "  A:link { color:#6699FF; background:transparent }\n"  +
            "  A:visited { color:#CC66CC; background:transparent }\n" +
            "  BODY { color:#DDDDDD; background:#002048 }\n" +
            "  TD.title { font-size:14px; background:#003366 }\n" +
            "  TR.bar { background:#003366 }\n" );

        g_pw.println(
            "  TH { font-size:12px; text-align:left }\n" +
            "  TD { font-size:12px }\n" +
            "  .TinyPrint { font-family:Arial,sans-serif; font-size:8pt }\n" +
            "  .Hd2 { font-family:Verdana,Arial,sans-serif; font-size:14pt }\n" +
            "  .Hd3 { font-family:Verdana,Arial,sans-serif; font-size:12pt }\n" +
            "-->\n</STYLE>\n" +
            "<SPAN CLASS=\"Hd2\">Darkest Hours</SPAN><BR>\n" +
            "<TABLE CELLSPACING=0 BORDER=0 WIDTH=\"100%%\">\n<TR>" +
            "<TD WIDTH=\"33%\" CLASS=\"TinyPrint\">" + g_optLink + "</TD>\n" +
            "<TD WIDTH=\"33%\" ALIGN=\"CENTER\"><SPAN CLASS=\"Hd3\">" + date + "</SPAN></TD>\n" +
            "<TD CLASS=\"TinyPrint\" ALIGN=\"RIGHT\">By " +
            "<A HREF=\"http://mhuss.com/\">Mark Huss</A></TD></TR>\n" +
            "</TABLE>\n" +
            "<TABLE CELLSPACING=0 BORDER=0 WIDTH=\"100%%\">\n" +
            "<TR><TD  CLASS=\"title\" ALIGN=\"CENTER\" COLSPAN=10>" +
            location + "</TD></TR>\n" +
            "<TR>\n" +
            "  <TH>Day</TH>\n  <TH>Darkest<BR>Hours</TH>\n  <TH>Event</TH>\n" +
            "  <TH>Moon<BR>Rises</TH>\n  <TH>Moon<BR>Sets</TH>\n" +
            "  <TH>Sunset</TH>\n  <TH>AstTwi<BR>Ends</TH>\n  <TH>Next<BR>Day</TH>\n" +
            "  <TH>AstTwi<BR>Starts</TH>\n  <TH>Sunrise</TH>\n" +
            "</TR>\n");
    }
    else {
      g_pw.println( "\n" + date + " " + location + "\n\n" +
              "Day Darkest                  Moon   Moon   Sunset AstTwi Next AstTwi Sunrise\n" +
              "    Hours          Events    Rises  Sets          Ends   Day  Starts\n" +
              "--  -------------  --------  -----  -----  -----  -----  --   -----  -----\n" );
    }
  }

  //----------------------------------------------------------------------------
  private StringBuffer nextColumn( StringBuffer p, int sp, boolean empty )
  {
    if (g_tabDelimited)
      p.append('\t');
    else if (g_html) {
      if (empty)
        p.append("&nbsp;</TD>\n  <TD>");
      else
        p.append("</TD>\n  <TD>");
    }
    else {
      while (sp-- > 0)
        p.append(' ');
    }
    return p;
  }

  StringBuffer nextColumn( StringBuffer p, int sp ) {
    return nextColumn( p, sp, false );
  }

  //----------------------------------------------------------------------------
  // print a (double) time as hh:mm
  //
  // a time < 0 is printed as '--:--'
  //
  private StringBuffer printTime( StringBuffer p, double t, boolean ws )
  {
     p.append( TimeOps.formatTime(t) );
     return ws ? nextColumn( p, 2) : p;
  }

  StringBuffer printTime( StringBuffer p, double t ) {
    return printTime(p,t,true);
  }

  //----------------------------------------------------------------------------
  // print a pair of (double) times as hh:mm
  //
  private StringBuffer printTimes( StringBuffer p, TimePair tp ) {
    p = printTime( p, tp.a, false );
    p.append( " - " );
    return printTime( p, tp.b );
  }

  //----------------------------------------------------------------------------
  // print the day, substituting 'Su' on Sundays
  //
  // d = 1..31
  //
  private StringBuffer printDay( StringBuffer p, long jd, int d, boolean eom ) {
    if( (jd+d) % 7 == 6)        /* Sunday */
      p.append( "Su" );
    else {
      int nextDay = eom ? 1 : d+1;
      p.append( Str.fmt(nextDay, 2) );
    }
    return nextColumn(p,2);
  }

  StringBuffer printDay( StringBuffer p, long jd, int d) {
    return printDay( p, jd, d, false );
  }

  //----------------------------------------------------------------------------
  // figure out darkest hours & print to buffer
  //
  private StringBuffer printDarkness( StringBuffer p, int i, DarkCalData dcd )
  {
    // print out darkness range or 'none'
    if ( dcd.noDarkness[i] ) {
      p.append( " -- none -- " );
      p = nextColumn(p, 3);
    }
    else
      p = printTimes( p, dcd.dark[i] );

    return p;
  }

  /*----------------------------------------------------------------------------
  check for lunar and solar quarters & print if found

  The 'AstroOps.quadrant' function helps in figuring out dates of lunar phases
  and solstices/equinoxes.  If the solar longitude is in one quadrant at
  the start of a day,  but in a different quadrant at the end of a day,
  then we know that there must have been a solstice or equinox during that
  day.  Also,  if (lunar longitude - solar longitude) changes quadrants
  between the start of a day and the end of a day,  we know there must have
  been a lunar phase change during that day.
  */
  //

  private StringBuffer printEvents( StringBuffer p, int i, DarkCalData dcd, int dstDay )
  {
    int lenLeft = 10;

    PlanetData pd = new PlanetData();
    double lunarLon[] = new double[2], solarLon[] = new double[2];

    ObsInfo loc = new ObsInfo( new Latitude(dcd.dci.lat), new Longitude(dcd.dci.lon), dcd.dci.tz );
    // get ecliptic longitude for earth & moon
    //
    for( int j=0; j<2; j++ ) {
      double jd = dcd.jd[i] + (double)j;
      solarLon[j] = pd.calcLon( Planets.EARTH, jd, loc );
      lunarLon[j] = pd.calcLon( Planets.LUNA, jd, loc );
    }

    // We don't bother finding the exact instant of the following events.
    // The code just checks for a quadrant change and reports the  event.

    // check for lunar quarters
    //
    int quad1 = AstroOps.quadrant( lunarLon[1] - solarLon[1] );
    int quad0 = AstroOps.quadrant( lunarLon[0] - solarLon[0] );
    if( quad1 != quad0 ) {
      final String strings[] = { "1Q ", "FM ", "3Q ", "NM " };
      p.append(strings[quad0]);
      lenLeft -= 3;
    }

    // check for solar quarters
    //
    quad1 = AstroOps.quadrant( solarLon[1] );
    quad0 = AstroOps.quadrant( solarLon[0] );
    if( quad1 != quad0 ) {
      final String strings[] =
            { "SumSol ", "Aut Eq  ", "WinSol ", "Ver Eq " };

      p.append(strings[quad0]);
      lenLeft -= 7;
    }

    // handle DST indicator
    if ( DST_START == dstDay ) {
      p.append("DSTime");
      lenLeft -= 6;
    }
    else if ( DST_END == dstDay ) {
      p.append("STime");
      lenLeft -= 5;
    }

    if (lenLeft < 0 )
      lenLeft = 0;

    return nextColumn(p, lenLeft, (10 == lenLeft));
  }

  /**
   * Print out the data
   *
   * @param dcd The DarkCalData instance to use
   */
  public void printData(DarkCalData dcd) {
    DarkCalInput dci = dcd.dci;

    printHeading(dci);

    // print data for each day
    //
    int end = (int)(dcd.jdEnd - dcd.jdStart);

    for( int i=0; i<end; i++ ) {

      if (g_html) {
        if (0 == (i & 1))
          g_pw.println( "<TR CLASS=\"bar\">\n  <TD>" );
        else
          g_pw.println( "<TR>\n  <TD>" );
      }

      // print day
      StringBuffer p = printDay( new StringBuffer(), dcd.jdStart, i );

      // print darkest hours
      p = printDarkness(p, i, dcd);

      // check for lunar & solar quarters and DST, print if found
      int dstDay = DST_NONE;
      if ( dcd.dstStart == dcd.jdStart+i )
        dstDay = DST_START;
      else if ( dcd.dstEnd == dcd.jdStart+i )
        dstDay = DST_END;

      p = printEvents(p, i, dcd, dstDay);

      // print rise/set times for Luna
      p = printTime( p, dcd.moonRS[i].a );
      p = printTime( p, dcd.moonRS[i].b );

      // print set time for the sun
      p = printTime( p, dcd.sunRS[i].b );

      // print end of Astronomical Twilight */
      p = printTime( p, dcd.astTwi[i].b );

      // next day
      p = printDay( p, dcd.jdStart, i+1, i == end-1 );

      if (!g_tabDelimited && !g_html)
        p.append(' ');

      // print start of Astronomical Twilight */
      p = printTime( p, dcd.astTwi[i+1].a );

      // print rise time for the sun     (last column)
      p = printTime( p, dcd.sunRS[i+1].a, false );

      if (g_html)
        p.append( "</TD>\n</TR>" );

      g_pw.println( p.toString() );
    }
    if (g_html) {
      printEpilogue();
      g_pw.println( "</BODY>\n</HTML>\n" );
    }
  }

  private void printEpilogue() {
    g_pw.println( "</TABLE>\n<P>Notes:<BR>" +
        "This chart is based on the simple concept that most " +
        "observing occurs between sunset and sunup (solar " +
        "observing excepted, of course!) The right-hand columns " +
        "show this normal \"time slice,\" starting at sunset, " +
        "continuing through twilight, and ending the next day with " +
        "twilight and then sunrise. Astronomical Twilight is " +
        "defined as the time when the sun is 18 degrees below the " +
        "horizon, and is the time when the skies become as dark as " +
        "local light pollution will allow.</P>\n" );
    g_pw.println(
        "<P>The important data is in the Darkest Hours column, which " +
        "shows the times between end of twilight on the first day " +
        "until start of twilight the next day, <EM>when the Moon is " +
        "not above the horizon</EM>. These times may run from today to " +
        "today, today to tomorrow, or tomorrow (starting after " +
        "midnight) to tomorrow - the hours should make it obvious " +
        "which is which.</P>\n" );
    g_pw.println(
        "<P>These simple calculations should be taken with a grain of " +
        "salt; for example, a two-day-old moon is not much of a " +
        "\"darkness spoiler,\" and some observing can be done before " +
        "the end of astronomical twilight. All data were calculated " +
        "by a java program I wrote (based on a C++ class library " +
        "I wrote), which was in turn based on open source astronomical " +
        "software from " +
        "<A HREF=\"http://www.projectpluto.com/\">Project Pluto</A>. " +
        "Additional calculations came from Jean Meeus' book " +
        "<A HREF=\"http://www.willbell.com/math/mc1.htm\">" +
        "Astronomical Algorithms</A>.</P>\n" );
  }

  /**
   * Calculate the <TT>DarkCalData</TT> values and print them out.
   *
   * @param dci Month, year, and location to use
   */
  public void calcAndPrint(DarkCalInput dci) {
    DarkCalCalc dcc = new DarkCalCalc(dci, g_ignoreDst);
    printData(dcc.dcd);
  }

  /**
   * Read the <TT>DarkCalData</TT> values and print them out.
   *
   * @param dci Month, year, and location to use
   */
  public void print(DarkCalInput dci) {

    try {
      DarkCalCalc dcc = new DarkCalCalc(dci, g_ignoreDst);
      try {
        printData(dcc.dcd);
      }
      catch ( Exception e ) {
        System.err.println( "Error printing data object: " + e );
      }
    }
    catch ( Exception e ) {
      System.err.println("Error creating data object: " + e);
    }
  }
  //----------------------------------------------------------------------------
  // print usage and exit
  //
  private static void usage(String pn)
  {
    System.err.println(
        "usage: " + pn + " <month> <year> [-d] [-h] [-t] [-u]\n" +
        "       -d = ignore daylight savings time\n" +
        "       -h = HTML table output\n" +
        "       -t = tab-delimited output\n" +
        "       -u = output time in UTC\n\n" +
        "Notes:\n" +
        " - Command-line options override config file settings.\n" +
        " - To produce a sample config file with all options listed, run the\n" +
        "   program without a " + pn + ".cfg file in the current directory.\n" +
        " - This program currently only supports the Gregorian calendar." );

    System.exit(-1);
  }

 //----------------------------------------------------------------------------
 //**** main ****
 //----------------------------------------------------------------------------
 /**
  * The main program entry point.
  * <P><TT>
  * usage: DarkCal &lt;month&gt; &lt;year&gt; [-d] [-h] [-t] [-u] <BR>
  *        -d = ignore daylight savings time <BR>
  *        -h = HTML table output <BR>
  *        -t = tab-delimited output <BR>
  *        -u = output time in UTC
  * </TT><P>
  * Notes:
  * <UL>
  * <LI> This program requires a text configuration file called
  * <TT>DarkCal.cfg</TT>. To produce a sample config file, with all
  * possible options listed, run the program with no <TT>DarkCal.cfg</TT>
  * file in the current directory or in <TT>C:\etc</TT>.
  * <LI>Command-line options override config file settings.
  * <LI>This program currently only supports the Gregorian calendar.
  * </UL>
  */
  public static void main( String args[] )
  {
    final String PROCNAME = "DarkCal";
    
    DarkCalInput dci = new DarkCalInput();
    DarkCal dc = new DarkCal();
    /*
    dci.month = 7;
    dci.year = 2011;
    dci.lat=40.0;
    dci.lon=-75.8;
    dci.tz=-5;
    */
    // check / get arguments
    //
    if ( args.length < 2 )
      usage( PROCNAME );
    else if ( '-' == args[0].charAt(0) )
      usage( PROCNAME );

    if ( !DarkCalProp.load(dci, dc) ) {
      System.err.println( "Error: Unable to load DarkCal config file." );
      System.exit(1);
    }

    dci.month = Integer.parseInt( args[0] );
    dci.year = Integer.parseInt( args[1] );
    if ( dci.month < 1 || dci.month > 12 || dci.year <= 0)
      usage(PROCNAME);

    if ( args.length > 2 ) {
      for (int i = 2; i < args.length; i++ ) {
        if ( '-' != args[i].charAt(0) )
          usage( PROCNAME );
        else {
          char c = args[i].charAt(1);
          if ( 'd' == c )
            dc.g_ignoreDst = true;
          else if ( 'h' == c )
            dc.g_html = true;
          else if ( 't' == c )
            dc.g_tabDelimited = true;
          else if ( 'u' == c ) {
            dci.tz=0;
            dc.g_ignoreDst = true;
          }
          else
            usage( PROCNAME );
        }
      }
    }
    

    if ( dc.g_tabDelimited && dc.g_html ) {
      System.err.println( "Error: html and tabDelimited cannot both be specified.\n" );
      System.exit(-1);
    }

    if ( 0D == dci.lon && 0D == dci.lat )
      System.out.println( "Latitude & Longitude are both set to 0. Is this what you intended?\n" );

    String pExt = null;
    if (dc.g_html)
      pExt = ".html";
    else if (dc.g_tabDelimited)
      pExt = ".txt";

    if ( null != pExt ) {
      String filename = monthNames[dci.month-1] + dci.year + pExt;
      File f = new File( filename  );
      try {
        f.createNewFile();
        dc.setWriter( new PrintWriter( new FileOutputStream(f) ) );
      }
      catch (IOException ioe ) {
        System.err.println( "Error: Unable to create output file '" +
            filename + "': " + ioe );
        System.exit(1);
      }
      System.err.println( "Writing output to " + filename + "\n" );
    }
    else
      dc.setWriter( new PrintWriter( System.out ) );

    dc.print( dci );
    dc.g_pw.close();
  }

} // end class DarkCal
