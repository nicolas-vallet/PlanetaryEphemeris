/*****************************************************************************\
 * Nutation
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

/**
 * Nutation functions and static data.
 * <P>
 * Based on C code from Bill Gray (www.projectpluto.com)
 */
public class Nutation {
 /**
  * Default constructor.
  */
  public Nutation() { m_t = m_dPhi = m_dEpsilon = 0D; }

 /**
  * Time only constructor.
  *
  * @param t Time in Julian centuries from J2000.
  */
  public Nutation( double t ) {
    m_dPhi = m_dEpsilon = 0D;
    calc( t );
  }

 /**
  * Explicit (all values) constructor.
  *
  * @param t Time in Julian centuries from J2000.
  * @param dP delta phi value
  * @param dE delta epsilon value
  */
  public Nutation( double t, double dP, double dE ) {
    m_dPhi = dP; m_dEpsilon = dE;
    calc( t );
  }

 /**
  * Delta Phi value.
  * <P>
  * This value represents nutation (delta phi) in arcseconds
  *
  * @return delta phi value
  */
  public double getDPhi() { return m_dPhi; }

 /**
  * Delta Epsilon value.
  * <P>
  * This value represents nutation (delta epsilon) in arcseconds
  *
  * @return delta epsilon value
  */
  public double getDEpsilon() { return m_dEpsilon; }

 /**
  * Calculate nutation values.
  * <P>
  * Either dPhi or dEpsilon can be Astro.INVALID on input, in which
  * case that value is not computed.  (we added this because
  * sometimes,  you want only dPhi or dEpsilon;  in such cases,
  * computing _both_ is a waste of perfectly good CPU time).
  *
  * @param t Time in Julian centuries from J2000.
  */
  public void calc(double t) {
    m_t = t;

    // The nutation formula (and all the magic numbers below) come
    // from pp. 132-5, Meeus,  Astro Algorithms, 2ed.

    double terms[] = { 0., 0., 0., 0., 0. };

    double t2 = m_t * m_t;
    double t3 = t2 * m_t;

    for( int i=0; i<5; i++ ) {
        terms[i] = linearPart[i] * m_t + coefficients[i][0] / 100000.;
        terms[i] += t2 * coefficients[i][1] * 1.e-7;
        terms[i] += t3 / coefficients[i][2];
        terms[i] = Math.toRadians(terms[i]);
    }

    if( ! (m_dPhi < 0.) )
        m_dPhi = (-171996. - 174.2 * m_t) * Math.sin( terms[4] );

    if( ! (m_dEpsilon < 0.) )
        m_dEpsilon = (92025. + 8.9 * m_t) * Math.cos( terms[4] );

    for( int i=0; i<N_NUTATION_COEFFS; i++ ) {
        double totalArg = 0.;
        int mult = args[i][0];

        for( int j=4; j>=0; j--) {
          if( mult % 5 != 2)
            totalArg += (double)( mult % 5 - 2) * terms[j];
          mult /= 5;
        }

        double coeff = (double)(args[i][1]);
        if( i < 16 && 0 != timeDependent[i] )
          coeff += (double)(timeDependent[i]) * m_t / 10.;
        else if( 26 == i || 28 == i )
          coeff += (double)(27 - i) * m_t / 10.;

        if( ! (m_dPhi < 0.) )
          m_dPhi += coeff * Math.sin(totalArg);

        if( 0 != args[i][2] ) {
          coeff = (double)(args[i][2]);

          if( i < 9 && 0 != timeDependent[i + 16] )
            coeff += (double)(timeDependent[i + 16]) * m_t / 10.;

          if( ! (m_dEpsilon < 0.) )
            m_dEpsilon += coeff * Math.cos( totalArg );
        }
    }
    m_dPhi *= .0001;
    m_dEpsilon *= .0001;
  }

 /**
  * Calculate delta Phi nutation value only.
  * <P>
  * The current delta Epsilon value is preserved.
  *
  * @param t Time in Julian centuries from J2000.
  */
  public void calcDeltaPhi(double t) {
    double temp = m_dEpsilon;  // preserve value

    m_dEpsilon = Astro.INVALID;
    m_dPhi = 0D;
    calc(t);

    m_dEpsilon = temp;
  }

 /**
  * Calculate delta Epsilon nutation value only.
  * <P>
  * The current delta Phi value is preserved.
  *
  * @param t Time in Julian centuries from J2000.
  */
  public void calcDeltaEpsilon(double t) {
    double temp = m_dPhi;  //preserve value

    m_dEpsilon = Astro.INVALID;
    m_dEpsilon = 0D;
    calc(t);

    m_dPhi = temp;
  }

  //-------------------------------------------------------------------------

  private double m_t, m_dPhi, m_dEpsilon;

  private final double linearPart[] = {
      445267.111480, 35999.050340, 477198.867398,
      483202.017538, -1934.136261 };

  private final double coefficients[][] = {
      { 29785036., -19142.,  189474. },
      { 35752772., - 1603., -300000. },
      { 13496298.,  86972., 56250. },
      {  9327191., -36825., 327270. },
      { 12504452.,  20708., 450000. }
  };

  private final int N_NUTATION_COEFFS = 62;

  private final int args[][] = {
      {  324,-13187,5736 },
      { 1574, -2274, 977 },
      { 1564,  2062,-895 },
      { 1687,  1426,  54 },
      { 1587,   712,  -7 },
      {  449,  -517, 224 },
      { 1573,  -386, 200 },
      { 1599,  -301, 129 },
      {  199,   217, -95 },
      {  337,  -158,   0 },
      {  323,   129, -70 },
      { 1549,   123, -53 },
      { 2812,    63,   0 },
      { 1588,    63, -33 },
      { 2799,   -59,  26 },
      { 1538,   -58,  32 },
      { 1598,   -51,  27 },
      {  362,    48,   0 },
      { 1523,    46, -24 },
      { 2824,   -38,  16 },
      { 1624,   -31,  13 },
      { 1612,    29,   0 },
      {  349,    29, -12 },
      { 1572,    26,   0 },
      {  322,   -22,   0 },
      { 1548,    21, -10 },
      { 1812,    17,   0 },
      { 2788,    16,  -8 },
      {  574,   -16,   7 },
      { 1688,   -15,   9 },
      {  338,   -13,   7 },
      { 1438,   -12,   6 },
      { 1602,    11,   0 },
      { 2798,   -10,   5 },
      { 2849,    -8,   3 },
      { 1699,     7,  -3 },
      {  462,    -7,   0 },
      { 1449,    -7,   3 },
      { 2823,    -7,   3 },
      { 2837,     6,   0 },
      {  374,     6,  -3 },
      {  348,     6,  -3 },
      { 2763,    -6,   3 },
      { 2813,    -6,   3 },
      { 1462,     5,   0 },
      {  198,    -5,   3 },
      {  313,    -5,   3 },
      { 1623,    -5,   3 },
      { 1524,    -3,   0 },
      {  363,     4,   0 },
      {  448,     4,   0 },
      { 1474,    -3,   0 },
      { 2674,    -3,   0 },
      { 1649,    -3,   0 },
      { 2699,    -3,   0 },
      {  837,    -3,   0 },
      {  962,    -4,   0 },
      {  437,    -4,   0 },
      { 1577,     4,   0 },
      { 2187,    -4,   0 },
      { 1712,    -3,   0 },
      { 1597,     3,   0 }
  };

  private final int timeDependent[] = {
      -16, -2, 2, -34, 1, 12, -4, 0, -5, 0, 1, 0, 0, 1, 0, -1,
      -31, -5, 5, -1,  0, -6, 0, -1, 3 };

  //-------------------------------------------------------------------------
 /**
  * (for unit testing only)
  */
  public static void main( String args[] ) {
    System.out.println( "Nutation Test" );
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat df = new SimpleDateFormat();
    DecimalFormat dec = new DecimalFormat( "0.0#" );
    df.setCalendar( cal );
    double d = DateOps.dmyToDay(
        cal.get(Calendar.DATE),
        cal.get(Calendar.MONTH)+1,  // Calendar has 0-based months (!)
        cal.get(Calendar.YEAR)
    );

    Nutation n = new Nutation( d );
    System.out.println( "dPhi=" + dec.format( n.getDPhi() ) +
                        ", dEpsilon=" + dec.format( n.getDEpsilon() ) );
  }

} // end class Nutation




