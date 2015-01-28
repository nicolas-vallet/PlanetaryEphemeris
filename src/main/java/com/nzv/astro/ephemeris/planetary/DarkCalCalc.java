/*****************************************************************************\
 * DarkCalCalc
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import java.io.*;

/**
 * A class to calculate and store <TT>DarkCal</TT> data, and optionally
 * cache the data to a file.
 */
public class DarkCalCalc {
  private DarkCalCalc() {}

 /**
  * Constructor
  *
  * @param dci Month, year, and observer location to use
  * @param ignoreDst <TT>true</TT> to ignore Daylight time
  */
  public DarkCalCalc(DarkCalInput dci, boolean ignoreDst) {
    calc(dci, ignoreDst);
  }

  DarkCalData dcd;

  //----------------------------------------------------------------------------
  // figure out the darkest hours for day (i) & put into dark[i]
  //
  private void findDark(int i) {
    if ( i > DarkCalData.DAYS-2 ) {
      System.err.println("illegal index");
      return;
    }

    double a_ = dcd.astTwi[i].b;
    double b_ = dcd.astTwi[i+1].a;

    dcd.dark[i] = new TimePair(a_,b_);

    // define day + time vars to deal with 'yesterday' and 'tomorrow'
    double darkStart = dcd.astTwi[i].b + i;
    double darkEnd = dcd.astTwi[i+1].a + (i+1);

    double moonRise;
    if ( dcd.moonRS2[i].a < 0. || dcd.moonRS2[i].b > dcd.moonRS2[i].a) {
        moonRise = dcd.moonRS2[i+1].a + (i+1);
        dcd.moonRS2[i].a = dcd.moonRS2[i+1].a;
    }
    else
        moonRise = dcd.moonRS2[i].a + i;

    double moonSet;
    if ( dcd.moonRS2[i].b < 0. || dcd.moonRS2[i].a > dcd.moonRS2[i].b ) {
      moonSet = dcd.moonRS2[i+1].b + (i+1);
      dcd.moonRS2[i].b = dcd.moonRS2[i+1].b;
    }
    else
      moonSet = dcd.moonRS2[i].b + i;

    // check moon rise & set
    if (moonSet > darkStart && moonSet < darkEnd) {
      darkStart = moonSet;
      dcd.dark[i].a = dcd.moonRS2[i].b;
    }
    if (moonRise > darkStart && moonRise < darkEnd ) {
      darkEnd = moonRise;
      dcd.dark[i].b = dcd.moonRS2[i].a;
    }

    dcd.noDarkness[i] = (moonRise < darkStart && moonSet > darkEnd );
  }

  //----------------------------------------------------------------------------
 /**
  * Calculate all the data using the given input
  *
  * @param dci Month, year, and observer location to use
  * @param ingnoreDst <TT>true</TT> to ignore Daylight time
  */
  void calc(DarkCalInput dci, boolean ignoreDst)
  {
    dcd = new DarkCalData(dci, ignoreDst);
    // calc. start and end days
    //
    dcd.jdStart = DateOps.dmyToDay( 1, dci.month, dci.year );
    dcd.jdEnd = ( dci.month < 12 ) ?
        DateOps.dmyToDay( 1, dci.month + 1, dci.year ) :
        DateOps.dmyToDay( 1, 1, dci.year + 1 );

    int end = (int)(dcd.jdEnd - dcd.jdStart);

    // fill in data for month in question
    //

    double tzAdj = (double)dci.tz * Astro.DAYS_PER_HOUR;
    dcd.dstStart = DateOps.dstStart( dci.year );
    dcd.dstEnd = DateOps.dstEnd( dci.year );
    PlanetData pd = new PlanetData();
    ObsInfo oi = new ObsInfo( new Latitude(dci.lat), new Longitude(dci.lon), dci.tz );

    for( int i=0; i<=end+1; i++ ) {
      long day = dcd.jdStart + i;

      // automatically adjust for DST if enabled
      // This 'rough' method will be off by one on moon rise/set between
      //   midnight and 2:00 on "clock change" days. (sun & astTwi never
      //   occur at these times.)
      //
      double dstAdj =
          ( false == ignoreDst && day>=dcd.dstStart && day<dcd.dstEnd) ?
          Astro.DAYS_PER_HOUR : 0.;

      dcd.jd[i] = (double)day - (tzAdj + dstAdj) - .5;

      // calculate rise/set times for the sun
      dcd.sunRS[i] = RiseSet.getTimes( RiseSet.SUN, dcd.jd[i], oi, pd );

      // calculate rise/set times for Astronomical Twilight
      dcd.astTwi[i] = RiseSet.getTimes( RiseSet.ASTRONOMICAL_TWI, dcd.jd[i], oi, pd );

      // calculate rise/set time for Luna )
      dcd.moonRS[i] = RiseSet.getTimes( RiseSet.MOON, dcd.jd[i], oi, pd );
    }

    // clone the moon array
    for(int j=0; j<dcd.moonRS.length; j++ )
      dcd.moonRS2[j] = new TimePair( dcd.moonRS[j] );

    // fill in the dark[] array
    for( int i=0; i<=end; i++ )
      findDark(i);
  }

};  // end class DarkCalData

