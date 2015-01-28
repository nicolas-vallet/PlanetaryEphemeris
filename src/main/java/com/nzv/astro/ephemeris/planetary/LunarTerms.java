/*****************************************************************************\
 * LunarTerms
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//---------------------------------------------------------------------------
/**
 * terms for longitude & radius
 */
class LunarTermsLonRad {
  public LunarTermsLonRad( int d_, int m_, int mp_, int f_, long sl_, long sr_ ) {
    d=d_; m=m_; mp=mp_; f=f_; sl=sl_; sr=sr_;
  }
  public int d, m, mp, f;
  public long sl, sr;
};

//---------------------------------------------------------------------------
/**
 * terms for latitude
 */
class LunarTermsLat {
  public LunarTermsLat( int d_, int m_, int mp_, int f_, long sb_ ) {
    d=d_; m=m_; mp=mp_; f=f_; sb=sb_;
  }
  public int d, m, mp, f;
  public long sb;
};

//---------------------------------------------------------------------------
/**
 * terms for phase
 */
class LunarTermsPh {
  public LunarTermsPh( int e_, int m_, int mp_, int f_, int om_,
                      double nm_, double fm_ )
  {
    e=e_; m=m_; mp=mp_; f=f_; om=om_; nm = nm_; fm=fm_;
  }
  public int e, m, mp, f, om;
  double nm, fm;
};

//---------------------------------------------------------------------------
/**
 * Holds a large quantity of constant data terms for class Lunar.
 * <P>
 * Based on C code by Bill Gray (www.projectpluto.com).<BR>
 */
public class LunarTerms {
  // All "magic numbers" are from Meeus, Astronomical Algorithms, 2ed.

  static final double LunarFundimentals_Lp[] = {
      218.3164477,
   481267.88123421,
       -0.0015786,
        1.85583502e-6,
       -1.53388349e-8
  };

  static final double LunarFundimentals_D[] = {
      297.8501921,
   445267.1114034,
       -0.0018819,
        1.83194472e-6,
       -8.84447e-9
  };

  static final double LunarFundimentals_M[] = {
      357.5291092,
    35999.0502909,
       -0.0001536,
        4.08329931e-8,
              0.0
  };

  static final double LunarFundimentals_Mp[] = {
      134.9633964,
   477198.8675055,
        0.0087414,
        1.43474081e-5,
       -6.79717238e-8
  };

  static final double LunarFundimentals_F[] = {
       93.2720950,
   483202.0175233,
       -0.0036539,
       -2.83607487e-7,
        1.15833247e-9
  };

  static final double PhaseFundimentals_M[] = {
          2.5534,
         29.10535670,
         -0.0000014,
         -0.000000110,
          0.0
  };

  static final double PhaseFundimentals_Mp[] = {
        201.5643,
        385.81693528,
          0.0107582,
          0.00001238,
         -0.000000058
  };

  static final double PhaseFundimentals_F[] = {
        160.7108,
        390.67050284,
         -0.0016118,
         -0.00000227,
          0.000000011
  };

  static final double PhaseFundimentals_Om[] = {
        124.7746,
         -1.56375588,
          0.0020672,
          0.00000215,
          0.0
  };

  static final int N_LTERM_LLR = 60;

  // Lunar longitude & radius terms

  static final LunarTermsLonRad LunarLonRad[] =  {
      new LunarTermsLonRad( 0,  0,  1,  0,  6288774, -20905335 ),
      new LunarTermsLonRad( 2,  0, -1,  0,  1274027,  -3699111 ),
      new LunarTermsLonRad( 2,  0,  0,  0,   658314,  -2955968 ),
      new LunarTermsLonRad( 0,  0,  2,  0,   213618,   -569925 ),
      new LunarTermsLonRad( 0,  1,  0,  0,  -185116,     48888 ),
      new LunarTermsLonRad( 0,  0,  0,  2,  -114332,     -3149 ),
      new LunarTermsLonRad( 2,  0, -2,  0,    58793,    246158 ),
      new LunarTermsLonRad( 2, -1, -1,  0,    57066,   -152138 ),
      new LunarTermsLonRad( 2,  0,  1,  0,    53322,   -170733 ),
      new LunarTermsLonRad( 2, -1,  0,  0,    45758,   -204586 ),
      new LunarTermsLonRad( 0,  1, -1,  0,   -40923,   -129620 ),
      new LunarTermsLonRad( 1,  0,  0,  0,   -34720,    108743 ),
      new LunarTermsLonRad( 0,  1,  1,  0,   -30383,    104755 ),
      new LunarTermsLonRad( 2,  0,  0, -2,    15327,     10321 ),
      new LunarTermsLonRad( 0,  0,  1,  2,   -12528,         0 ),
      new LunarTermsLonRad( 0,  0,  1, -2,    10980,     79661 ),
      new LunarTermsLonRad( 4,  0, -1,  0,    10675,    -34782 ),
      new LunarTermsLonRad( 0,  0,  3,  0,    10034,    -23210 ),
      new LunarTermsLonRad( 4,  0, -2,  0,     8548,    -21636 ),
      new LunarTermsLonRad( 2,  1, -1,  0,    -7888,     24208 ),
      new LunarTermsLonRad( 2,  1,  0,  0,    -6766,     30824 ),
      new LunarTermsLonRad( 1,  0, -1,  0,    -5163,     -8379 ),
      new LunarTermsLonRad( 1,  1,  0,  0,     4987,    -16675 ),
      new LunarTermsLonRad( 2, -1,  1,  0,     4036,    -12831 ),
      new LunarTermsLonRad( 2,  0,  2,  0,     3994,    -10445 ),
      new LunarTermsLonRad( 4,  0,  0,  0,     3861,    -11650 ),
      new LunarTermsLonRad( 2,  0, -3,  0,     3665,     14403 ),
      new LunarTermsLonRad( 0,  1, -2,  0,    -2689,     -7003 ),
      new LunarTermsLonRad( 2,  0, -1,  2,    -2602,         0 ),
      new LunarTermsLonRad( 2, -1, -2,  0,     2390,     10056 ),
      new LunarTermsLonRad( 1,  0,  1,  0,    -2348,      6322 ),
      new LunarTermsLonRad( 2, -2,  0,  0,     2236,     -9884 ),
      new LunarTermsLonRad( 0,  1,  2,  0,    -2120,      5751 ),
      new LunarTermsLonRad( 0,  2,  0,  0,    -2069,         0 ),
      new LunarTermsLonRad( 2, -2, -1,  0,     2048,     -4950 ),
      new LunarTermsLonRad( 2,  0,  1, -2,    -1773,      4130 ),
      new LunarTermsLonRad( 2,  0,  0,  2,    -1595,         0 ),
      new LunarTermsLonRad( 4, -1, -1,  0,     1215,     -3958 ),
      new LunarTermsLonRad( 0,  0,  2,  2,    -1110,         0 ),
      new LunarTermsLonRad( 3,  0, -1,  0,     -892,      3258 ),
      new LunarTermsLonRad( 2,  1,  1,  0,     -810,      2616 ),
      new LunarTermsLonRad( 4, -1, -2,  0,      759,     -1897 ),
      new LunarTermsLonRad( 0,  2, -1,  0,     -713,     -2117 ),
      new LunarTermsLonRad( 2,  2, -1,  0,     -700,      2354 ),
      new LunarTermsLonRad( 2,  1, -2,  0,      691,         0 ),
      new LunarTermsLonRad( 2, -1,  0, -2,      596,         0 ),
      new LunarTermsLonRad( 4,  0,  1,  0,      549,     -1423 ),
      new LunarTermsLonRad( 0,  0,  4,  0,      537,     -1117 ),
      new LunarTermsLonRad( 4, -1,  0,  0,      520,     -1571 ),
      new LunarTermsLonRad( 1,  0, -2,  0,     -487,     -1739 ),
      new LunarTermsLonRad( 2,  1,  0, -2,     -399,         0 ),
      new LunarTermsLonRad( 0,  0,  2, -2,     -381,     -4421 ),
      new LunarTermsLonRad( 1,  1,  1,  0,      351,         0 ),
      new LunarTermsLonRad( 3,  0, -2,  0,     -340,         0 ),
      new LunarTermsLonRad( 4,  0, -3,  0,      330,         0 ),
      new LunarTermsLonRad( 2, -1,  2,  0,      327,         0 ),
      new LunarTermsLonRad( 0,  2,  1,  0,     -323,      1165 ),
      new LunarTermsLonRad( 1,  1, -1,  0,      299,         0 ),
      new LunarTermsLonRad( 2,  0,  3,  0,      294,         0 ),
      new LunarTermsLonRad( 2,  0, -1, -2,        0,      8752)
    };
  // Lunar latitude terms

  static final LunarTermsLat LunarLat[] = {
    new LunarTermsLat( 0,  0,  0,  1, 5128122 ),
    new LunarTermsLat( 0,  0,  1,  1,  280602 ),
    new LunarTermsLat( 0,  0,  1, -1,  277693 ),
    new LunarTermsLat( 2,  0,  0, -1,  173237 ),
    new LunarTermsLat( 2,  0, -1,  1,   55413 ),
    new LunarTermsLat( 2,  0, -1, -1,   46271 ),
    new LunarTermsLat( 2,  0,  0,  1,   32573 ),
    new LunarTermsLat( 0,  0,  2,  1,   17198 ),
    new LunarTermsLat( 2,  0,  1, -1,    9266 ),
    new LunarTermsLat( 0,  0,  2, -1,    8822 ),
    new LunarTermsLat( 2, -1,  0, -1,    8216 ),
    new LunarTermsLat( 2,  0, -2, -1,    4324 ),
    new LunarTermsLat( 2,  0,  1,  1,    4200 ),
    new LunarTermsLat( 2,  1,  0, -1,   -3359 ),
    new LunarTermsLat( 2, -1, -1,  1,    2463 ),
    new LunarTermsLat( 2, -1,  0,  1,    2211 ),
    new LunarTermsLat( 2, -1, -1, -1,    2065 ),
    new LunarTermsLat( 0,  1, -1, -1,   -1870 ),
    new LunarTermsLat( 4,  0, -1, -1,    1828 ),
    new LunarTermsLat( 0,  1,  0,  1,   -1794 ),
    new LunarTermsLat( 0,  0,  0,  3,   -1749 ),
    new LunarTermsLat( 0,  1, -1,  1,   -1565 ),
    new LunarTermsLat( 1,  0,  0,  1,   -1491 ),
    new LunarTermsLat( 0,  1,  1,  1,   -1475 ),
    new LunarTermsLat( 0,  1,  1, -1,   -1410 ),
    new LunarTermsLat( 0,  1,  0, -1,   -1344 ),
    new LunarTermsLat( 1,  0,  0, -1,   -1335 ),
    new LunarTermsLat( 0,  0,  3,  1,    1107 ),
    new LunarTermsLat( 4,  0,  0, -1,    1021 ),
    new LunarTermsLat( 4,  0, -1,  1,     833 ),
    new LunarTermsLat( 0,  0,  1, -3,     777 ),
    new LunarTermsLat( 4,  0, -2,  1,     671 ),
    new LunarTermsLat( 2,  0,  0, -3,     607 ),
    new LunarTermsLat( 2,  0,  2, -1,     596 ),
    new LunarTermsLat( 2, -1,  1, -1,     491 ),
    new LunarTermsLat( 2,  0, -2,  1,    -451 ),
    new LunarTermsLat( 0,  0,  3, -1,     439 ),
    new LunarTermsLat( 2,  0,  2,  1,     422 ),
    new LunarTermsLat( 2,  0, -3, -1,     421 ),
    new LunarTermsLat( 2,  1, -1,  1,    -366 ),
    new LunarTermsLat( 2,  1,  0,  1,    -351 ),
    new LunarTermsLat( 4,  0,  0,  1,     331 ),
    new LunarTermsLat( 2, -1,  1,  1,     315 ),
    new LunarTermsLat( 2, -2,  0, -1,     302 ),
    new LunarTermsLat( 0,  0,  1,  3,    -283 ),
    new LunarTermsLat( 2,  1,  1, -1,    -229 ),
    new LunarTermsLat( 1,  1,  0, -1,     223 ),
    new LunarTermsLat( 1,  1,  0,  1,     223 ),
    new LunarTermsLat( 0,  1, -2, -1,    -220 ),
    new LunarTermsLat( 2,  1, -1, -1,    -220 ),
    new LunarTermsLat( 1,  0,  1,  1,    -185 ),
    new LunarTermsLat( 2, -1, -2, -1,     181 ),
    new LunarTermsLat( 0,  1,  2,  1,    -177 ),
    new LunarTermsLat( 4,  0, -2, -1,     176 ),
    new LunarTermsLat( 4, -1, -1, -1,     166 ),
    new LunarTermsLat( 1,  0,  1, -1,    -164 ),
    new LunarTermsLat( 4,  0,  1, -1,     132 ),
    new LunarTermsLat( 1,  0, -1, -1,    -119 ),
    new LunarTermsLat( 4, -1,  0, -1,     115 ),
    new LunarTermsLat( 2, -2,  0,  1,     107)
  };

  // Lunar phase terms
  static final int N_LTERM_PH = 25;

  static final LunarTermsPh LunarPhaseNF[] = {
    //               E   M   Mp  F   Om  New       Full
    new LunarTermsPh( 0,  0,  1,  0,  0, -0.40720, -0.40614 ),
    new LunarTermsPh( 1,  1,  0,  0,  0,  0.17241,  0.17302 ),
    new LunarTermsPh( 0,  0,  2,  0,  0,  0.01608,  0.01614 ),
    new LunarTermsPh( 0,  0,  0,  2,  0,  0.01039,  0.01043 ),
    new LunarTermsPh( 1, -1,  1,  0,  0,  0.00739,  0.00734 ),
    new LunarTermsPh( 1,  1,  1,  0,  0, -0.00514, -0.00515 ),
    new LunarTermsPh( 2,  2,  0,  0,  0,  0.00208,  0.00209 ),
    new LunarTermsPh( 0,  0,  1, -2,  0, -0.00111, -0.00111 ),
    new LunarTermsPh( 0,  0,  1,  2,  0, -0.00057, -0.00057 ),
    new LunarTermsPh( 1,  1,  2,  0,  0,  0.00056,  0.00056 ),
    new LunarTermsPh( 0,  0,  3,  0,  0, -0.00042, -0.00042 ),
    new LunarTermsPh( 1,  1,  0,  2,  0,  0.00042,  0.00042 ),
    new LunarTermsPh( 1,  1,  0, -2,  0,  0.00038,  0.00038 ),
    new LunarTermsPh( 1, -1,  2,  0,  0, -0.00024, -0.00024 ),
    new LunarTermsPh( 0,  0,  0,  0,  1, -0.00017, -0.00017 ),
    new LunarTermsPh( 0,  2,  1,  0,  0, -0.00007, -0.00007 ),
    new LunarTermsPh( 0,  0,  2, -2,  0,  0.00004,  0.00004 ),
    new LunarTermsPh( 0,  3,  0,  0,  0,  0.00004,  0.00004 ),
    new LunarTermsPh( 0,  1,  1, -2,  0,  0.00003,  0.00003 ),
    new LunarTermsPh( 0,  0,  2,  2,  0,  0.00003,  0.00003 ),
    new LunarTermsPh( 0,  1,  1,  2,  0, -0.00003, -0.00003 ),
    new LunarTermsPh( 0, -1,  1,  2,  0,  0.00003,  0.00003 ),
    new LunarTermsPh( 0, -1,  1, -2,  0, -0.00002, -0.00002 ),
    new LunarTermsPh( 0,  1,  3,  0,  0, -0.00002, -0.00002 ),
    new LunarTermsPh( 0,  0,  4,  0,  0,  0.00002,  0.00002 )
  };

  static final LunarTermsPh LunarPhaseQ[] = {
    //               E   M   Mp  F   Om  1Q        3Q
    new LunarTermsPh( 0,  0,  1,  0,  0, -0.62801, -0.62801 ),
    new LunarTermsPh( 1,  1,  0,  0,  0,  0.17172,  0.17172 ),
    new LunarTermsPh( 1,  1,  1,  0,  0, -0.01183, -0.01183 ),
    new LunarTermsPh( 0,  0,  2,  0,  0,  0.00862,  0.00862 ),
    new LunarTermsPh( 0,  0,  0,  2,  0,  0.00804,  0.00804 ),
    new LunarTermsPh( 1, -1,  1,  0,  0,  0.00454,  0.00454 ),
    new LunarTermsPh( 2,  2,  0,  0,  0,  0.00204,  0.00204 ),
    new LunarTermsPh( 0,  0,  1, -2,  0, -0.00180, -0.00180 ),
    new LunarTermsPh( 0,  0,  1,  2,  0, -0.00070, -0.00070 ),
    new LunarTermsPh( 0,  0,  3,  0,  0, -0.00040, -0.00040 ),
    new LunarTermsPh( 1, -1,  2,  0,  0, -0.00034, -0.00034 ),
    new LunarTermsPh( 1,  1,  0,  2,  0,  0.00032,  0.00032 ),
    new LunarTermsPh( 1,  1,  0, -2,  0,  0.00032,  0.00032 ),
    new LunarTermsPh( 2,  2,  1,  0,  0, -0.00028, -0.00028 ),
    new LunarTermsPh( 1,  1,  2,  0,  0,  0.00027,  0.00027 ),
    new LunarTermsPh( 0,  0,  0,  0,  1, -0.00017, -0.00017 ),
    new LunarTermsPh( 0, -1,  1, -2,  0, -0.00005, -0.00005 ),
    new LunarTermsPh( 0,  0,  2,  2,  0,  0.00004,  0.00004 ),
    new LunarTermsPh( 0,  1,  1,  2,  0, -0.00004,  0.00004 ),
    new LunarTermsPh( 0, -2,  1,  0,  0,  0.00004,  0.00004 ),
    new LunarTermsPh( 0,  1,  1, -2,  0,  0.00003,  0.00003 ),
    new LunarTermsPh( 0,  3,  0,  0,  0,  0.00003,  0.00003 ),
    new LunarTermsPh( 0,  0,  2, -2,  0,  0.00002,  0.00002 ),
    new LunarTermsPh( 0, -1,  1,  2,  0,  0.00002,  0.00002 ),
    new LunarTermsPh( 0,  1,  3,  0,  0, -0.00002, -0.00002 )
  };

};  // end class LunarTerms

