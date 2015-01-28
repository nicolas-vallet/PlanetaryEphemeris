package com.nzv.astro.ephemeris.planetary;

/**
 * NoInitException is thrown if the caller attempts to call a
 * method which requires some sort of initializtion if init was
 * not done.
 *
 * @author meh 2002
 */
public class NoInitException extends Exception {

  /**
   * Catches exceptions without a specified string
   */
  public NoInitException() {}

  /**
   * Constructs the appropriate exception with the specified string
   *
   * @param message           String Exception message
   */
  public NoInitException(String message) {super(message);}
}
