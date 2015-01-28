/*****************************************************************************\
 * MathOps
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

/**
 * MathOps contains some useful trig, vector and matrix operations.
 * <P>
 * Based on C code by Bill Gray (www.projectpluto.com)
 */
public class MathOps {   // Change to public by Strickling

 /**
  * Calculates the arc cosine, but limits the input to the range
  * ( -1.0 < rad < +1.0 ). <BR>
  * This avoids overflow errors. If the input is <= -1.0 radians,
  * <TT>Math.PI</TT> is returned. If the input is >= 1.0 radians,
  * 0 is returned.
  *
  * @param arg The angle in radians
  *
  * @return The arc cosine, limited to the range 0 to Pi.
  */
  public static double acose( double arg ) {
    if( arg >= 1D )
      return( 0D );
    else if( arg <= -1D )
      return( Math.PI );
    else
      return( Math.acos( arg ) );
  }

 /**
  * Calculates the arc sine, but limits the input to the range
  * ( -1.0 < rad < +1.0 ). <BR>
  * This avoids overflow errors. If the input is less than
  * -1 (radian), -PI/2 is returned. If the input is greater than
  * 1 (radian), +PI/2 is returned.
  *
  * @param arg The angle in radians
  *
  * @return The arc sine, limited to the range -Pi/2 0 to Pi/2.
  */
  public static double asine( double arg ) {
    if( arg >= 1. )
      return( Astro.PI_OVER_TWO );
    else if( arg <= -1. )
      return( -Astro.PI_OVER_TWO );
    else
      return( Math.asin( arg) );
  }

  // typedef double AstroVector[3];
  public static final int VECTOR_SIZE = 3;

  //typedef double AstroMatrix[9];
  static final int MATRIX_SIZE = 9;

 /**
  * Initializes a matrix to base (identity) values.
  * The matrix is set as follows:<TT>
  *   [1][0][0]
  *   [0][1][0]
  *   [0][0][1]
  * </TT>
  *
  * @param matrix The matrix to initialize
  */
  public static void setIdentityMatrix( double matrix[] ) {
    for( int i=0; i<MATRIX_SIZE; i++ )
      matrix[i] = ( 0 != (i & 3) ? 0D : 1D );
  }

 /**
  * Rotate a vector along the specified axis.
  *
  * @param v The vector to rotate
  * @param angle The angle to use
  * @param axis The axis along which to rotate
  */
  public static void rotateVector( double v[], double angle, int axis )
  {
    double sinAng = Math.sin( angle );
    double cosAng = Math.cos( angle );
    int a = (axis + 1) % VECTOR_SIZE;
    int b = (axis + 2) % VECTOR_SIZE;

    double temp = v[a] * cosAng - v[b] * sinAng;
    v[b] = v[b] * cosAng + v[a] * sinAng;
    v[a] = temp;
  }

  /**
   * Convert polar coordinates to Cartesian coordinates.
   *
   * @param vect Vector to hold the Cartesian coordinates
   * @param lon Polar longitude
   * @param lat Polar latitude
   */
   static void polar3ToCartesian( double vect[], double lon, double lat )
   {
     double cosLat = Math.cos( lat );

     vect[0] = Math.cos( lon ) * cosLat;
     vect[1] = Math.sin( lon ) * cosLat;
     vect[2] = Math.sin( lat );
   }
   

   /**
    * Convert polar coordinates with radius to Cartesian coordinates
    * added by w. Strickling
    * @param vect Vector to hold the Cartesian coordinates
    * @param lon Polar longitude
    * @param lat Polar latitude
    */
   public static void polarToCartesian( double vect[], double lon, double lat, double radius )
   {
     double cosLat = Math.cos( lat );

     vect[0] = Math.cos( lon ) * cosLat *radius;
     vect[1] = Math.sin( lon ) * cosLat *radius;
     vect[2] = Math.sin( lat ) * radius;
   }
   
   /**
    * Convert polar coordinates with radius to Cartesian coordinates
    * added by w. Strickling
    * @param vectC Vector to hold the Cartesian coordinates
    * @param vectP Vector to hold the Polar coordinates
    */
   public static void polarToCartesian( double vectC[], double vectP [])
   { polarToCartesian (vectC, vectP[0], vectP[1], vectP[2]);
   }
   
   public static void cartesianToPolar ( double cartVect[], double polarCoord [])
   {
	   // Longitude
	   polarCoord [0] =  Math.atan2(cartVect [1], cartVect [0]); 
	   // Latitude
	   polarCoord [1] = Math.atan2 (cartVect [2], 
		   		Math.sqrt(cartVect [0] *cartVect [0] + cartVect [1]*cartVect [1]));
	   // Radius
	   polarCoord [2] = Math.sqrt(cartVect [0] *cartVect [0] + cartVect [1]*cartVect [1] + cartVect [2]*cartVect [2]);
   }
   

 /**
  * Invert an orthonormal matrix.
  * <P>
  * Inverting an orthonormal matrix is simple:
  * swap rows and columns, and you're done.
  */
  static void invertOrthonormalMatrix( double matrix[] )
  {
    double temp;

    // swap [1] and [3]
    temp = matrix[1];  matrix[1] = matrix[3];  matrix[3] = temp;
    // swap [2] and [6]
    temp = matrix[2];  matrix[2] = matrix[6];  matrix[6] = temp;
    // swap [5] and [7]
    temp = matrix[5];  matrix[5] = matrix[7];  matrix[7] = temp;
  }

 /**
  * Prespin matrices.
  *
  * @param m1 The first matrix
  * @param m2 The second matrix
  * @param angle The angle to use
  */
  static void preSpinMatrix( double m1[], double m2[], double angle )
  {
    double sinAng = Math.sin( angle );
    double cosAng = Math.cos( angle );
    double tval;

    for( int i=0; i<MATRIX_SIZE; i+=3 )
    {
      tval  = m1[i] * cosAng - m2[i] * sinAng;
      m2[i] = m2[i] * cosAng + m1[i] * sinAng;
      m1[i] = tval;
    }
  }

 /**
  * Spin matrix
  *
  * @param m1 The first matrix
  * @param m2 The second matrix
  * @param angle The angle to use
  */
  static void spinMatrix( double m1[], double m2[], double angle )
  {
    double sinAng = Math.sin( angle );
    double cosAng = Math.cos( angle );
    double tval;

    for( int i=0; i<VECTOR_SIZE; i++ )
    {
      tval  = m1[i] * cosAng - m2[i] * sinAng;
      m2[i] = m2[i] * cosAng + m1[i] * sinAng;
      m1[i] = tval;
    }
  }

}
