package com.nzv.astro.ephemeris.planetary;

/**
 * ValueException is thrown if the caller attempts to pass in an
 * invalid value, or the results of a calculation generate an
 * invalid value.
 *
 * @author meh 2002
 */
public class ValueException extends Exception {

  /**
   * Catches exceptions without a specified string
   */
  public ValueException() {}

  /**
   * Constructs the appropriate exception with the specified string
   *
   * @param message           String Exception message
   */
  public ValueException(String message) {super(message);}
}
