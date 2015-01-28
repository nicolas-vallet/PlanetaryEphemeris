/*****************************************************************************\
 * TimePair
\*****************************************************************************/
package com.nzv.astro.ephemeris.planetary;

//import java.io.Serializable;

/**
 * A simple class used to store a pair of times. This is typically
 * either a rise/set or a start/end pair.
 */
public class TimePair /*implements Serializable*/ {
 /**
  * Explicit (both values) constructor.
  *
  * @param a The first (rise or start) time
  * @param b The second (set or end) time
  */
	  public TimePair(double a, double b) { this.a=a; this.b=b; c = 0D;}

 /**
  * Explicit (three values) constructor.
  *
  * @param a The first (rise or start) time
  * @param b The second (set or end) time
  * @param c The third (culmination) time
  */
	  public TimePair(double a, double b, double c) { this.a=a; this.b=b; this.c = c;}

 /**
  * Copy constructor
  */
  public TimePair(TimePair tp) {
    if ( null != tp ) {
      this.a=tp.a;
      this.b=tp.b;
      this.c=tp.c;
    }
    else
      a = b = c= 0D;
  }

 /**
  * Default constructor
  */
  public TimePair() { a = b = c = 0D; }

 /**
  * The start or rise time
  */
  public double a;

  /**
   * The end or set time.
   */
   public double b;
   
   /**
    * The third (Culmination) time.
    */
    public double c;
}
