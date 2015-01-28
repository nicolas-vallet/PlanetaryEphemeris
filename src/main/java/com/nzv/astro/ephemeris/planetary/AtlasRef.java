/*****************************************************************************\
 * AtlasRef
 *
 * AtlasRef  is a class that figures out which page in a number of atlases
 *           given an R.A. and Dec. It also supports the Rukl lunar atlas
 *           given a lunar latitude and longitude.
 *
 * Based in part on C code from project pluto (www.projectpluto.com)
 *
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * AtlasRef is a class that figures out which page in a number of atlases
 * best show the given RA and Dec.
 * <P>
 * It also supports the Rukl lunar atlas given a lunar latitude and longitude.
 */
public class AtlasRef
{
 /**
  * This function returns the page number in the Millennium Star Atlas
  * that best shows the location specified.
  *
  * @param ra Right ascension in decimal hours
  * @param dec Declination in decimal degrees
  *
  * @return The appropriate Millenium Atlas page
  */
  public static int millenniumAtlasPage( double ra, double dec )
  {
    int page;

    if( dec >= 87.)             /* polar cap pages */
      page = ( ra < 4. || ra > 16. ? 2 : 1);
    else if( dec <= -87.)       /* polar cap pages */
      page = ( ra < 4. || ra > 16. ? 516 : 515);
    else
    {
      int gore = (int)( ra / 8.),
          zone = (int)(( 93. - dec) / 6.);
      double remains = Math.ceil( ra / 8.) * 8. - ra;
      final int per_zone[] = {
          2, 4, 8, 10, 12, 14, 16, 20, 20, 22, 22,
          24, 24, 24, 24, 24, 24, 24, 24, 24,
          22, 22, 20, 20, 16, 14, 12, 10, 8, 4, 2 };

      page = (int)( remains * (double)per_zone[zone] / 8.) + 1 + gore * 516;
      while( 0 != zone-- )
         page += per_zone[zone];
    }
    return page;
  }

 /**
  * This function returns the page number in Sky Atlas 2000
  * page that best shows the location specified.
  *
  * @param ra Right ascension in decimal hours
  * @param dec Declination in decimal degrees
  *
  * @return The appropriate Sky Atlas 2000 page
  */
  public static int skyAtlasPage( double ra, double dec )
  {
    int page;

    if( Math.abs( dec ) < 18.5 )      /* between -18.5 and 18.5 */
    {
      page = 9 + (int)( ra / 3. + 5. / 6. );
      if( page == 9 )
         page = 17;
    }
    else if( Math.abs( dec ) < 52. )  /* between 18.5 and 52, N and S */
    {
      page = 4 + (int)( ra / 4. );
      if( dec < 0. )
        page += 14;
    }
    else                             /* above 52,  N and S */
    {
      page = 1 + (int)( ra / 8. );
      if( dec < 0. )
        page += 23;
    }
    return page;
  }

 /**
  * This function returns the page number in Uranometria that
  * best shows the location specified.
  *
  * @param ra Right ascension in decimal hours
  * @param dec Declination in decimal degrees
  * @param fix472 True to swap charts 472 and 473 (needed in original
  *        edition)
  *
  * @return The appropriate Uranometria page
  */
  public static int uranometriaPage( double ra, double dec, boolean fix472 )
  {
    final int decLimits[] = {
        -900, -845, -725, -610, -500, -390, -280, -170, -55,
         55, 170, 280, 390, 500, 610, 725, 845, 900
    };
    final int nDivides[] = {
        2, 12, 20, 24, 30, 36, 45, 45, 45,
        45, 45, 36, 30, 24, 20, 12, 2
    };

    int divide, startValue = 472;

    for( divide = 0; (double)decLimits[divide + 1] < dec * 10.; divide++ )
      startValue -= (int)nDivides[divide + 1];

    double angle = ra * (int)nDivides[divide] / 24.;
    if( nDivides[divide] >= 20 )
      angle += .5;
    else if( nDivides[divide] == 12 )
      angle += 5. / 12.;

    int page = (int)angle % nDivides[divide] + startValue;

    if( page >= 472 && fix472 )       /* charts 472 and 473 are "flipped" */
      page = (472 + 473) - page;

    return page;
  }

 /**
  * This function returns the page number in the original edition of
  * Uranometria that best shows the location specified.
  *
  * @param ra Right ascension in decimal hours
  * @param dec Declination in decimal degrees
  *
  * @return The appropriate Uranometria page
  */
  public static int uranometriaPage( double ra, double dec )
  {
    return uranometriaPage( ra, dec, true );
  }

 /**
  * This function returns the page number in Rukl that best shows the
  * lunar location specified. Returns a String to accomodate Rukl's
  * roman numeral libration pages.
  *
  * @param lon lunar longitude
  * @param lat lunar latitude
  *
  * @return The appropriate Rukl page
  */
  public static String ruklPage( double lon, double lat )
  {
    double x = Math.cos( lat ) * Math.cos( lon );
    double y = Math.cos( lat ) * Math.sin( lon );
    double z = Math.sin( lat );
    int page = -1,
        ix = (int)( y * 5.5 + 5.5),
        iy = (int)( 4. - 4. * z);
    final int  page_starts[] = { -1, 7, 17, 28, 39, 50, 60, 68 };

    //strcpy( buff, "Rukl ");
    StringBuffer buff = new StringBuffer( "Rukl " );
    if( x > 0. )
    {
      if( iy <= 1 || iy >= 6) {
        if( 0 == ix )
          ix = 1;
        else if( 10 == ix )
          ix = 9;
      }

      if( 0 == iy || 7 == iy )
        if( 1 == ix )
          ix = 2;
        else if( 9 == ix )
          ix = 8;

      page = ix + page_starts[iy];
      buff.append( page );
    }

    /* Allow a basically eight-degree libration zone.  This */
    /* isn't _perfect_,  but it's "not bad" either. */

    if( x < Math.PI * 8. / 180. && x > -Math.PI * 8. / 180.)
    {
      int zone_no = (int)( Math.atan2( z, y) * 4. / Math.PI + 4.);
      String librationZonePages[] = {
          "VII", "VI", "V", "IV", "III", "II", "I", "VIII"
      };

      if( page > -1)
        buff.append( '/' );

      buff.append( librationZonePages[zone_no] );
    }
    return ( -1 == page ) ? "" : buff.toString();
  }

}  // end class AtlasRef
