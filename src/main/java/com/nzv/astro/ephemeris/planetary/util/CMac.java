/**
 ***************************************************************************\
 * CMac - a simple Java class to recreate some handy-dandy utilities from
 *        the land of C
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

package com.nzv.astro.ephemeris.planetary.util;

//--------------------------------------------------------------------------
/**
 * This is a set of handy utility functions (from 'C' land). <BR>
 * Note: For simplicity, these assume the 'C' locale and ASCII charset
 */
public class CMac {

  static final int CASE_DIFF = 'a' - 'A';

  /**
   * Returns true if the char isupper() or islower().
   */
  public static boolean isalpha( char c ) {
    return ( isupper(c) || islower(c) );
  }

  /**
   * Returns true if the char is from 'A' to 'Z' inclusive.
   */
  public static boolean isupper( char c ) {
    return ( c >= 'A' && c <= 'Z' );
  }

  /**
   * Returns true if the char is from 'a' to 'z' inclusive.
   */
  public static boolean islower( char c ) {
    return ( c >= 'a' && c <= 'z' );
  }

  /**
   * Returns true if the char is from '0' to '9' inclusive.
   */
  public static boolean isdigit( char c ) {
    return ( c >= '0' && c <= '9' );
  }

  /**
   * Returns true if the char isdigit() or is from 'A' to 'F'
   * or 'a' to 'f' inclusive.
   */
  public static boolean isxdigit( char c ) {
    return ( isdigit(c ) || ( c >= 'A' && c <= 'F' ) || ( c >= 'a' && c <= 'f' ) );
  }

  /**
   * Returns true if the char isalpha() or isdigit().
   */
  public static boolean isalnum( char c ) {
    return ( isalpha(c) || isdigit(c) );
  }

  /**
   * Returns true if the char is in the set SP, HT, LF, VT, FF, CR.
   */
  public static boolean isspace( char c ) {
    return ( ' ' == c || ( c >= '\t' && c <= '\r') );
  }

  /**
   * Returns true if the int value of the char is from 0 to 127 inclusive.
   */
  public static boolean isascii( char c ) {
    return ( c <= (char)127 );
  }

  /**
   * Returns uppercase of input char if input is from 'a' to 'z', else
   * returns input char unchanged.
   */
  public static char toupper( char c ) {
    return (char)((islower(c)) ? (c - CASE_DIFF) : c );
  }

  /**
   * Returns lowercase of input char if input is from 'A' to 'Z', else
   * returns input char unchanged.
   */
  public static char tolower( char c ) {
    return (char)((isupper(c)) ? (c + CASE_DIFF) : c );
  }

  //----------------------------------------------------------------------------
  //**** unit test ****
  //----------------------------------------------------------------------------
  /**
   * (for unit testing only)
   */
  static void main( String args[] )
  {
    final String PROCNAME = "CMac";

    System.out.println( "toupper('a') = " + toupper( 'a' ) );
    System.out.println( "tolower('Z') = " + tolower( 'Z' ) );
  }
}
