/***************************************************************************\
 * File -- handy File I/O utilities
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

import java.io.File;

/**
 * Miscellaneous handy-dandy utility functions for file I/O.
 */
public class FileU {
 /**
  * Get the system file separator ("/" or "\")
  *
  * @return "/" or "\"
  */
  public static String getFS() {
    return System.getProperty( "file.separator" );
  }

 /**
  * Determine if the specified file exists and is readable.
  *
  * @param filespec The file name to test
  *
  * @return <TT>true</TT> if the specified file exists and is readable,
  *     <TT>false</TT> otherwise
  */
  public static boolean exists( String filespec ) {
    File fd = new File( filespec );
    return fd.canRead();
  }

}
