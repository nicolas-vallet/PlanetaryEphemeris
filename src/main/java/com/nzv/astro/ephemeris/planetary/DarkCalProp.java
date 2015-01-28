/***************************************************************************\
 * DarkCalProp -- properties file support for DarkCal
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
import java.util.Properties;

import com.nzv.astro.ephemeris.planetary.util.FileU;

/**
 * Properties file support for DarkCal
 */
public class DarkCalProp {
  static final String CFG_FILENAME = "DarkCal.cfg";

 /**
  * Read and parse our config file.
  * <P>
  * Creates an example config file if none could be found.
  *
  * @param dci <TT>DarkCalInput</TT> instance to use
  * @param dc <TT>DarkCal</TT> instance to use
  *
  * @return <TT>true</TT> if successful, <TT>false</TT> otherwise.
  */
  static boolean load(DarkCalInput dci, DarkCal dc) {

    String etcCfgFile = "C:\\etc\\" + CFG_FILENAME;
    String homeCfgFile = "~/" + CFG_FILENAME;
    String usedCF = null;

    if ( FileU.exists( CFG_FILENAME ) )
      usedCF = CFG_FILENAME;
    else if ( FileU.exists( etcCfgFile ) )
      usedCF = etcCfgFile;
    else if ( FileU.exists( homeCfgFile ) )
      usedCF = homeCfgFile;
    else {
      System.err.println(
          "\nWarning: unable to find " + CFG_FILENAME + ":\n\n" +
          "- I'll try to create a 'template' file for you in the current directory.\n" +
          "- Edit this file to reflect your location.\n " );
      createExampleCfg();
      return false;
    }
    File f = new File( usedCF );

    Properties cf = new Properties();
    InputStream fis = null;

    try {
      fis = new FileInputStream( f );
    }
    catch( IOException ioe ) {
      System.err.println( "Unable to open input file " + usedCF + ": " + ioe );
      return false;
    }
    catch( Exception e ) {
      System.err.println( "Unexpected exception opening input file " + usedCF + ": " + e );
      return false;
    }

    if ( null != fis ) {
      try {
        cf.load(fis);
        fis.close();
        System.err.println( "Using " + usedCF );
      }
      catch( IOException ioe ) {
        System.err.println( "Unable to load system properties: " + ioe );
        return false;
      }
    }

    String p = cf.getProperty( "longitude" );
    if ( null != p )
      dci.lon = Double.parseDouble( p );

    p = cf.getProperty( "latitude" );
    if ( null != p )
      dci.lat = Double.parseDouble( p );

    p = cf.getProperty( "timeZone" );
    if ( null != p )
      dci.tz = Integer.parseInt( p );

    p = cf.getProperty( "htmlOutput" );
    if ( null != p )
      dc.g_html = Boolean.valueOf( p ).booleanValue();

    p = cf.getProperty( "ignoreDST" );
    if ( null != p )
      dc.g_ignoreDst = Boolean.valueOf( p ).booleanValue();

    p = cf.getProperty( "tabDelimited" );
    if ( null != p )
      dc.g_tabDelimited = Boolean.valueOf( p ).booleanValue();

    p = cf.getProperty( "useUTC" );
    if ( null != p ) {
      if ( Boolean.valueOf( p ).booleanValue() ) {
        dci.tz = 0;
        dc.g_ignoreDst = true;
      }
    }

    return true;
  }

  static private void createExampleCfg() {
    try {
      PrintWriter pw = new PrintWriter( new FileOutputStream( CFG_FILENAME ) );
      if ( null != pw ) {
        pw.println(
            "# " + CFG_FILENAME + "\n# Note: East and North are positive\n" +
            "# e.g., Philadelphia, PA, US is latitude -75.16, longitude 39.95,\n" +
            "#       and timeZone -5\n" +
            "longitude=0.0\nlatitude=0.0\ntimeZone=0\n\n" +
            "# Set this to true to ignore Daylight time:\n" +
            "ignoreDST=false\n\n" +
            "# Set this to true to use UTC (this overrides timeZone & DST)\n" +
            "useUTC=false\n\n" +
            "# Set this to true to output to an HTML file:\n" +
            "htmlOutput=false\n\n" +
            "# Set this to true to produce a text file with tab-delimited fields:\n" +
            "# (Note: html & tabs are mutually exclusive!)\n" +
            "tabDelimited=false\n" );
        pw.close();
      }
    }
    catch( Exception e ) {}
  }
}
