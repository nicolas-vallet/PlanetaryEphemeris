/**
 ***************************************************************************\
 * Str is a set handy String utilities.
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

/**
 * This class holds a potporri of static String functions not included
 * in <TT>java.lang.String</TT>.
 */
public class Str {

  private static final int HEX_DIFF = 'A' - '9' - 1;

 /**
  * Extract the first digit substring from the passed in <TT>String</TT>
  * and convert to an int.
  *
  * @param s The <TT>String</TT> to search
  *
  * @return The converted digits or -1 if no digits were found
  */
  public static int extractInt( String s ) {
    int rv = -1;
    if ( null != s ) {

      int i = 0, j = 0, len = s.length();
      for ( ; i < len; i++ ) {
        if ( CMac.isdigit( s.charAt(i) ) )
          break;
      }
      if ( i < len ) {      // found a digit?
        j = i;
        for ( ; j < len; j++ ) {    // find end of digits (or EOS)
          if ( !CMac.isdigit( s.charAt(j) ) )
            break;
        }
        String num = ( j < len )
            ? s.substring( i, j )
            : s.substring( i );

        try {
          rv = Integer.parseInt( num );
        }
        catch ( NumberFormatException nfe) {
          rv = -1;
        }
      }
    }
    return rv;
  }

 /**
  * Remove spaces, commas, dots and single quotes from a <TT>String</TT>.
  * <P>
  * This is usually called to help make text into a reasonably safe
  * filename.
  *
  * @param s The <TT>String</TT> to filter
  *
  * @return The filtered <TT>String</TT>
  */
  public static String deSpace(String s) {
    StringBuffer buf = new StringBuffer();

    int i = 0;
    while ( i < s.length() ) {
      char c = s.charAt(i);
      if ( ' ' != c && ',' != c && '.' != c && '\'' != c )
        buf.append( c );
      i++;
    }
    return buf.toString();
  }

 /**
  * Convert a <code>char</code> to a "<code>%hh</code>" string.
  *
  * @param c char to convert
  * @return <code>%hh</code> representation of char.
  */
  public static String hex(char c) {
    int lsi = (c & 0x0F) + '0';
    char lsd = (char)(lsi + (( lsi > '9' ) ? HEX_DIFF : 0));
    int msi = (c >> 4) + '0';
    char msd = (char)(msi + (( msi > '9' ) ? HEX_DIFF : 0));

    return "%" + msd + lsd;
  }

 /**
  * Convert a "<code>%hh</code>" <code>String</code> to a <code>char</code>.
  *
  * @param h String <code>%hh</code> representation of char.
  * @return char represented by <code>%hh</code> parameter
  */
  public static char unhex(String h) {
    if ( '%' != h.charAt(0) )
      return h.charAt(0);

    int lsi = CMac.toupper(h.charAt(2)) - '0';
    if ( lsi > 9 )
      lsi -= HEX_DIFF;

    int msi = CMac.toupper(h.charAt(1)) - '0';
    if ( msi > 9 )
      msi -= HEX_DIFF;
    msi <<= 4;

    return (char)(msi + lsi);
  }

 /**
  * Make a <TT>String</TT> URL-friendly by escaping all reserved chars.
  * <P>
  * A handy function lifted from ECMAScript. The characters which
  * are "escaped" (i.e., converted to <TT>%hh</TT> form) include all
  * those which are not alphanumeric AND not in the set <TT>@*-_./</TT>
  * Probably the most commonly seen are "<TT>%20</TT>", which represents
  * the space (" ") character, and "<TT>%27</TT>", which represents
  * the single quote ("'") character.
  * <P>
  * Example<BR>
  * Before: <TT>Foo's Funny Filename.html</TT>
  * <P>
  * After: <TT>Foo%27s%20Funny%20Filename.html</TT>
  *
  * @param in The <TT>String</TT> to escape
  *
  * @return The <TT>String</TT> with all reserved chars converted to
  *     "<TT>%hh</TT>" form.
  */
  public static String escape(String in) {
    StringBuffer buf = new StringBuffer();

    int i = 0;
    while ( i < in.length() ) {
      char c = in.charAt(i);
      if ( CMac.isalnum( c ) )
        buf.append( c );
      else {
        switch (c) {
        case '@':
        case '*':
        case '-':
        case '_':
        //case '+':
        case '.':
        case '/':
          buf.append( c );
          break;
        default:
          buf.append( hex(c) );
          break;
        }
      }
      i++;
    }
    return buf.toString();
  }

 /**
  * Make a URL-friendly "escaped" <TT>String</TT> human-friendly.
  * <P>
  * A handy function lifted from ECMAScript. The characters are
  * are "unescaped" by converting all triglyphs of the form "<TT>%hh</TT>"
  * to single characters. "<TT>+</TT>" signs are also converted to spaces.
  * <P>
  * Probably the most commonly seen are "<TT>%20</TT>", which represents
  * the space (" ") character, and "<TT>%27</TT>", which represents
  * the single quote ("'") character.
  * <P>
  * Example<BR>
  * Before: <TT>Foo%27s%20Funny%20Filename.html</TT>
  * <P>
  * After: <TT>Foo's Funny Filename.html</TT>
  *
  * @param in The <TT>String</TT> to unescape
  *
  * @return The <TT>String</TT> with all "<TT>%hh</TT>" triglyphs
  *     converted back to single characters.
  */
  public static String unescape(String in) {
    StringBuffer buf = new StringBuffer();

    int i = 0;
    while ( i < in.length() ) {
      char c = in.charAt(i);
      if ( '+' == c )
        buf.append( ' ' );
      else if ( '%' == c ) {
        buf.append( unhex( in.substring(i, i+3) ) );
        i += 2;
      }
      else
        buf.append( c );
      i++;
    }
    return buf.toString();
  }

 /**
  * Check for a string which represents boolean <TT>true</TT>.
  * <P>
  * This function assumes a <TT>String</TT> which starts with '<TT>t</TT>',
  * '<TT>T</TT>', or '<TT>1</TT>' means <TT>true</TT>.
  *
  * @param tf The <TT>String</TT> to test
  *
  * @return <TT>true</TT> if the input has at least one character and
  *    evaluated as <TT>true</TT>, <TT>false</TT> otherwise . Note
  *    that a <TT>null</TT> input string returns <TT>false</TT>.
  */
  public static boolean boolCheck(String tf) {
    boolean result = false;
    if ( null != tf )
      if ( tf.length() > 0  ) {
        char c = tf.charAt(0);
        result = ( 't' == c || 'T' == c || '1' == c );
      }
    return result;
  }

 /**
  * Format a <TT>String</TT> representation of an integer at the
  * specified width.
  * <P>
  * Note that this function will return an incorrect representation
  * if the integer is wider than the specified width. For example:<BR>
  * <TT>  fmt( 1, 3 )</TT> will return "<TT>001</TT>"<BR>
  * <TT>  fmt( 12, 3 )</TT> will return "<TT>012</TT>"<BR>
  * <TT>  fmt( 1234, 3 )</TT> will return "<B><TT>234</TT></B>"
  *
  * @param i The integer to format
  * @param w The format width
  *
  * @return A formatted <TT>String</TT>
  */
  public static String fmt(int i, int w) {
    StringBuffer sb = new StringBuffer();
    while ( w-- > 0 )  {
      sb.append( (char)('0' + (i % 10)) );
      i /= 10;
    }
    sb.reverse();
    return sb.toString();
  }

 /**
  * Format a <TT>String</TT> representation of an integer at the
  * specified width, and add the specified suffix.
  * <P>
  * Note that this will return an incorrect representation if the
  * integer is wider than the specified width. For example:<BR>
  * <TT>  fmt( 1, 3, ':' )</TT> will return "<TT>001:</TT>"<BR>
  * <TT>  fmt( 12, 3, ':' )</TT> will return "<TT>012:</TT>"<BR>
  * <TT>  fmt( 1234, 3, ':' )</TT> will return "<B><TT>234:</TT></B>"
  *
  * @param i The integer to format
  * @param w The format width
  * @param suffix The character to append
  *
  * @return A formatted <TT>String</TT>
  */
  public static String fmt(int i, int w, char suffix) {
    return fmt( i, w) + suffix;
  }

 /**
  * Format a <TT>String</TT> representation of an integer using a
  * default width of two (2).
  * <P>
  * Note that this will return an incorrect representation if the
  * integer is wider than two digits. For example:<BR>
  * <TT>  fmt( 1 )</TT> will return "<TT>01</TT>"<BR>
  * <TT>  fmt( 12 )</TT> will return "<TT>12</TT>"<BR>
  * <TT>  fmt( 1234 )</TT> will return "<B><TT>34</TT></B>"
  *
  * @param i The integer to format
  *
  * @return A formatted <TT>String</TT>
  */
  public static String fmt(int i) {
    return fmt( i, 2 );
  }

 /**
  * Format a <TT>String</TT> representation of an integer using a
  * default width of two (2), and add the specified suffix.
  * <P>
  * Note that this will return an incorrect representation if the
  * integer is wider than the specified width. For example:<BR>
  * <TT>  fmt( 1, ':' )</TT> will return "<TT>01:</TT>"<BR>
  * <TT>  fmt( 12, ':' )</TT> will return "<TT>12:</TT>"<BR>
  * <TT>  fmt( 1234, ':' )</TT> will return "<B><TT>34:</TT></B>"
  *
  * @param i The integer to format
  * @param suffix The character to append
  *
  * @return A formatted <TT>String</TT>
  */
  public static String fmt(int i, char suffix) {
    return fmt( i, 2 ) + suffix;
  }

  //----------------------------------------------------------------------------
  //**** unit test ****
  //----------------------------------------------------------------------------
 /**
  * (for unit testing only)
  */
  static void main( String args[] )
  {
    final String PROCNAME = "Str";

    String org = "<This is a #@^*~& test!>";
    String esc = escape( org );
    System.out.println( "escape:\n  " + org + " =\n  " + esc );
    System.out.println( "\nunescape:\n  " + esc + " =\n  " + unescape(esc) );
  }

} // end class Str
