/***************************************************************************\
 * Pluto
 * this source seems to provide wrong results! (Dr. W. Strickling, 2011-07-09)
 * use Class Pluto2 for correct calculations
 * 
\***************************************************************************/

package com.nzv.astro.ephemeris.planetary;

class PlutoCoeffs {
  PlutoCoeffs( int j_, int s_, int p_, int loa, int lob, int laa, int lab, int ra, int rb ) {
    j=j_; s=s_; p=p_; lon_a=loa; lon_b=lob; lat_a=laa; lat_b=lab; rad_a=ra; rad_b=rb;
  }
  int j, s, p, lon_a, lon_b, lat_a, lat_b, rad_a, rad_b;
};

class PlutoTerms {
  static final long plutoLongCoeff[][] = {
    {  68955876,  66867334, -14974876,  -5453098,  19848454, -19798886 },
    {   -333765, -11826086,   1672673,   3527363,  -4955707,    897499 },
    {  -1439953,   1593657,    327763,  -1050939,   1210521,    610820 },
    {    482443,    -18948,   -291925,    178691,   -189719,   -341639 },
    {    -85576,    -66634,    100448,     18763,    -34863,    129027 },
    {     -5765,     30841,    -25838,    -30594,     31061,    -38215 },
    {     45637,       105,       201,       157,       747,      7049 }
  };

  // pluto coefficients
  static final int N_COEFFS = 36;

  static final PlutoCoeffs plutoCoeff[] = {
    new PlutoCoeffs( 0,  1, -1, 20349, -9886,  4965, 11263, -6140, 22254 ),
    new PlutoCoeffs( 0,  1,  0, -4045, -4904,   310,  -132,  4434,  4443 ),
    new PlutoCoeffs( 0,  1,  1, -5885, -3238,  2036,  -947, -1518,   641 ),
    new PlutoCoeffs( 0,  1,  2, -3812,  3011,    -2,  -674,    -5,   792 ),
    new PlutoCoeffs( 0,  1,  3,  -601,  3468,  -329,  -563,   518,   518 ),
    new PlutoCoeffs( 0,  2, -2,  1237,   463,   -64,    39,   -13,  -221 ),
    new PlutoCoeffs( 0,  2, -1,  1086,  -911,   -94,   210,   837,  -494 ),
    new PlutoCoeffs( 0,  2,  0,   595, -1229,    -8,  -160,  -281,   616 ),
    new PlutoCoeffs( 1, -1,  0,  2484,  -485,  -177,   259,   260,  -395 ),
    new PlutoCoeffs( 1, -1,  1,   839, -1414,    17,   234,  -191,  -396 ),
    new PlutoCoeffs( 1,  0, -3,  -964,  1059,   582,  -285, -3218,   370 ),
    new PlutoCoeffs( 1,  0, -2, -2303, -1038,  -298,   692,  8019, -7869 ),
    new PlutoCoeffs( 1,  0,  0,  1179,  -358,   304,   825,  8623,  8444 ),
    new PlutoCoeffs( 1,  0,  1,   393,   -63,  -124,   -29,  -896,  -801 ),
    new PlutoCoeffs( 1,  0,  2,   111,  -268,    15,     8,   208,  -122 ),
    new PlutoCoeffs( 1,  0,  3,   -52,  -154,     7,    15,  -133,    65 ),
    new PlutoCoeffs( 1,  0,  4,   -78,   -30,     2,     2,   -16,     1 ),
    new PlutoCoeffs( 1,  1, -3,   -34,   -26,     4,     2,   -22,     7 ),
    new PlutoCoeffs( 1,  1, -2,   -43,     1,     3,     0,    -8,    16 ),
    new PlutoCoeffs( 1,  1, -1,   -15,    21,     1,    -1,     2,     9 ),
    new PlutoCoeffs( 1,  1,  0,    -1,    15,     0,    -2,    12,     5 ),
    new PlutoCoeffs( 1,  1,  1,     4,     7,     1,     0,     1,    -3 ),
    new PlutoCoeffs( 1,  1,  3,     1,     5,     1,    -1,     1,     0 ),
    new PlutoCoeffs( 2,  0, -6,     8,     3,    -2,    -3,     9,     5 ),
    new PlutoCoeffs( 2,  0, -5,    -3,     6,     1,     2,     2,    -1 ),
    new PlutoCoeffs( 2,  0, -4,     6,   -13,    -8,     2,    14,    10 ),
    new PlutoCoeffs( 2,  0, -3,    10,    22,    10,    -7,   -65,    12 ),
    new PlutoCoeffs( 2,  0, -2,   -57,   -32,     0,    21,   126,  -233 ),
    new PlutoCoeffs( 2,  0, -1,   157,   -46,     8,     5,   270,  1068 ),
    new PlutoCoeffs( 2,  0,  0,    12,   -18,    13,    16,   254,   155 ),
    new PlutoCoeffs( 2,  0,  1,    -4,     8,    -2,    -3,   -26,    -2 ),
    new PlutoCoeffs( 2,  0,  2,    -5,     0,     0,     0,     7,     0 ),
    new PlutoCoeffs( 2,  0,  3,     3,     4,     0,     1,   -11,     4 ),
    new PlutoCoeffs( 3,  0, -2,    -1,    -1,     0,     1,     4,   -14 ),
    new PlutoCoeffs( 3,  0, -1,     6,    -3,     0,     0,    18,    35 ),
    new PlutoCoeffs( 3,  0,  0,    -1,    -2,     0,     1,    13,     3 )
};

};

/**
 * A class that can calculate the orbit of Pluto.
 * <BR>
 * Based on C code by Bill Gray (www.projectpluto.com)
 */
public class Pluto {
 /**
  * Calculate all locations elements for a given time.
  *
  * @param loc The LocationElements class to populate
  * @param t time in Julian centuries
  */
  public static void calcAllLEs( LocationElements loc, double t ) {
    // jupiter's mean longitude
    double mlJup =  Math.toRadians(34.35 + 3034.9057 * t);

    // saturn's mean longitude
    double mlSat =  Math.toRadians(50.08 + 1222.1138 * t);

    // pluto's mean longitude
    double mlPl = Math.toRadians(238.96 +  144.9600 * t);

    // use local vars for retvals, hoping to encourage FP reg optimizations
    double lon_ = 238.956785 + 144.96 * t;
    double lat_ = -3.908202;
    double rad_ = 407.247248;  // temporarily in tenths of AUs; fixed at the end

    double arg;
    for( int i=0; i<7; i++ ) {
      if( i == 6)
        arg = mlJup - mlPl;
      else
        arg = (double)(i + 1) * mlPl;

      double cosArg = Math.cos(arg) * 1.e-6;
      double sinArg = Math.sin(arg) * 1.e-6;
      long plc[] = PlutoTerms.plutoLongCoeff[i];

      lon_ += (double)(plc[0]) * sinArg + (double)(plc[1]) * cosArg;
      lat_ += (double)(plc[2]) * sinArg + (double)(plc[3]) * cosArg;
      rad_ += (double)(plc[4]) * sinArg + (double)(plc[5]) * cosArg;
    }

    PlutoCoeffs pc[] = PlutoTerms.plutoCoeff;
    for( int i=0; i<PlutoTerms.N_COEFFS; i++ ) {
      if( 0 != ( pc[i].lon_a | pc[i].lon_b |
          pc[i].lat_a | pc[i].lat_b |
          pc[i].rad_a | pc[i].rad_b) )
      {
        if( 0 == pc[i].j )
          arg = 0.;
        else
          arg = ((1 == pc[i].j) ? mlJup : mlJup * (double)pc[i].j);

        if( pc[i].s < 0 )
          arg -= (-1 == pc[i].s) ? mlSat : mlSat + mlSat;

        if( pc[i].s > 0 )
          arg += (1 == pc[i].s) ? mlSat : mlSat + mlSat;

        if( 0 != pc[i].p )
          arg += mlPl * (double)pc[i].p;

        double cosArg = Math.cos(arg) * 1.e-6;
        double sinArg = Math.sin(arg) * 1.e-6;
        lon_ += sinArg * (double)(pc[i].lon_a) + cosArg * (double)(pc[i].lon_b);
        lat_ += sinArg * (double)(pc[i].lat_a) + cosArg * (double)(pc[i].lat_b);
        rad_ += sinArg * (double)(pc[i].rad_a) + cosArg * (double)(pc[i].rad_b);
      }
    }
    rad_ = rad_ / 10.0;  // convert back to AUs
    loc.set( Math.toRadians(lat_), Math.toRadians(lon_), rad_ );
  }
};
