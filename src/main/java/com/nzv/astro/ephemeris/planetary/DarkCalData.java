/*****************************************************************************\
 * DarkCalData
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import java.io.*;
/**
 * A simple struct-style class to store DarkCal data
 */
public class DarkCalData /*implements Serializable*/ {

  static final int DAYS=33;     // 31 max plus one on either side

  DarkCalInput dci;
  long jdStart, jdEnd, dstStart, dstEnd;
  boolean ok, ignoreDst, cacheData, noDarkness[];
  double jd[];
  TimePair sunRS[], moonRS[], moonRS2[], astTwi[], dark[];

  /**
   * Default constructor
   */
  DarkCalData() { init( false ); }

  /**
   * Explicit constructor
   *
   * @param dci Month, year, and location to use.
   * @param ignoreDst <TT>true</TT> to ignore Daylight time
   */
  DarkCalData(DarkCalInput dci, boolean ignoreDst) {
    this.dci = dci;
    this.ignoreDst = ignoreDst;
    init( true );
  }

  private void init( boolean haveDCI ) {
    sunRS = new TimePair[DAYS];
    moonRS = new TimePair[DAYS];
    moonRS2 = new TimePair[DAYS];
    astTwi = new TimePair[DAYS];
    dark = new TimePair[DAYS];
    jd = new double[DAYS];
    noDarkness = new boolean[DAYS];

    ok = haveDCI;
  }

}
