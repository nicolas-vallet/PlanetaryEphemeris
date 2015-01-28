/*****************************************************************************\
 * PlanetData
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

//import android.util.Log;

/**
 * This class handles planetary motion calculations and conversions.
 */
public class PlanetData {

	public static final double AU           = 149597870.691;  // 1 AU km


 /**
  * Default constructor.
  */
  public PlanetData() { m_planet = Planets.NAP; m_initComplete=false; }

 /**
  * Explicit (all parameters) constructor.
  *
  * @param planet Planet number (from <TT>Planets</TT> class)
  * @param jd Julian day number
  * @param oi Observer location
  */
  public PlanetData( int planet, double jd, double deltaT, ObsInfo oi ) {
	    calc( planet, jd, deltaT, oi );
	  }

  public PlanetData( int planet, double jd, ObsInfo oi ) {
	    calc( planet, jd, oi );
	  }

 /**
  * This calculates all LocationElements, then returns the longitude.
  * <BR>
  * Longitude is split out because it gets used most often.
  *
  * @param planet Planet number (from <TT>Planets</TT> class)
  * @param jd Julian day number
  * @param oi Observer location
  */
  public double calcLon( int planet, double jd, ObsInfo oi ) {
   if ( Planets.SUN == planet )
     planet = Planets.EARTH;
     // What we _really_ want is the location of the sun as seen from
     // the earth (geocentric view).  VSOP gives us the opposite, but
     // this will be corrected below.

    m_jd = jd;
    m_planet = planet;
    m_centuries = AstroOps.toMillenia( jd );
    m_polarLEs = new LocationElements();
    // choose appropriate method, based on planet
    //
    if( Planets.LUNA == planet ) {
      Lunar luna = new Lunar();
      try {
        luna.calcAllLEs( m_polarLEs, m_centuries );
        m_polarLEs.setRadius(m_polarLEs.getRadius()/AU); // Convert from km to AU
      } catch (NoInitException ni) {}

    }
    else if( Planets.PLUTO == planet ) {
    	double [] lbr = new double [3];
    	Pluto2.ln_get_pluto_helio_coords (jd, lbr);
    	m_polarLEs.setLongitude(lbr[0]);
    	m_polarLEs.setLatitude(lbr[1]);	
    	m_polarLEs.setRadius(lbr[2]);
      //Pluto.calcAllLEs( m_polarLEs, m_centuries );
    }
    else {
      Vsop.calcAllLEs( m_polarLEs, m_centuries, planet );
      if ( Planets.EARTH == planet ) {
       /*
        * What we _really_ want is the location of the sun as seen from
        * the earth (geocentric view).  VSOP gives us the opposite
        * (heliocentric) view, i.e., the earth as seen from the sun.
        * To work around this, we add PI to the longitude (rotate 180 degrees)
        * and negate the latitude.
        */
        m_polarLEs.setLongitude( m_polarLEs.getLongitude() + Math.PI );
        m_polarLEs.setLatitude( m_polarLEs.getLatitude() * -1D );
      }
            
    }
    return m_polarLEs.getLongitude();
  }

 /**
  * Calculate the data for a given planet, julian day, and location.
  * <BR>
  * This function must be called (directly or via constructor) before
  * calling any of the other functions in this class.
  *
  * @param planet Planet number (from <TT>Planets</TT> class)
  * @param jd Julian day number
  * @param oi Observer location
  */
  public void calc( int planet, double jd, double deltaT, ObsInfo oi ) {
	  calc (planet, jd, deltaT, oi, true, true);
  }
  
  // assumes deltaT = 0.0 for low precision purpose. (=> error in hour angle, if JD = TDT)
  public void calc( int planet, double jd, ObsInfo oi ) {
	  calc (planet, jd, 0.0, oi, false, false); 
  }
 
  
  /**
   * Calculate the data for a given planet, julian day, and location.
   * <BR>
   * This function must be called (directly or via constructor) before
   * calling any of the other functions in this class.
   *
   * @param planet Planet number (from <TT>Planets</TT> class)
   * @param jd Julian day number (tdt)
   * @param deltaT (in Days)
   * @param oi Observer location
   * @param topoc_Corr  correct topocentric
   * @param lightT_Corr correct light time
   */
  public void calc( int planet, double jd, double deltaT, ObsInfo oi, boolean topoc_Corr, boolean lightT_Corr) {
    // There's a lot of calculating here, but one we need most often
    // is the last one (AltAzLoc), which depends on all the previous
    // calculations
    //
	  
	  double localSiderealTime =
		  AstroOps.greenwichSiderealTime(jd-deltaT) + oi.getLongitudeRad(); // UTC required !
	  double obliquity = AstroOps.meanObliquity( m_centuries );


	  // Two pass iteration for light time correction (added by W. Strickling)
	  // needs  planetary  heliocentric position at jd -lightTimeCorrection 
	  // seen from earth's heliocentric position at jd 
	  // NOT FOR SOLAR POSITION!
	  double tmpVec[] = new double[MathOps.VECTOR_SIZE];  // buffers planet's xyz position, subject to transformations
	  double tmpVec2[] = new double[MathOps.VECTOR_SIZE]; // buffers Earth's xyz position
	  double lightTimeCorrection = 0; // in days
	  int passNo = 1;
	  if (! lightT_Corr) passNo = 2; // already last pass, if no light time correction required
	  do {
//		  Log.d ("PlanetData", "Pass " +passNo +",  LightTimeCorrection (min):"+ lightTimeCorrection *24.*60. );
		  calcLon( planet, jd -lightTimeCorrection, oi );  // Heliocentric planetary coordinates

		  // Conversion to cartesian into tmpVec 
		  MathOps.polarToCartesian( tmpVec, m_polarLEs.getLongitude(),
				  m_polarLEs.getLatitude(), 
				  m_polarLEs.getRadius());
		  
		  // Modification by Strickling: 
		  // conversion Heliozentric to geocentric position
		  
		  // calculate earth's position and convert tmpVec to geocentric
		  g_polarLEs = new LocationElements(); // for buffering earth's position
//		  if ((planet >= Planets.MERCURY) && (planet <= Planets.LUNA) && (planet != Planets.EARTH))
		  if (planet != Planets.EARTH && planet != Planets.SUN)
		  {
			  if (passNo ==1 || ! lightT_Corr) {  // Earth position does not change, calc only first time				  
				  // Calculate heliocentric coordinates of the Earth (g_polarLEs)
				  Vsop.calcAllLEs( g_polarLEs, m_centuries, Planets.EARTH );
				  MathOps.polarToCartesian( tmpVec2,  g_polarLEs.getLongitude(),
						  g_polarLEs.getLatitude(), 
						  g_polarLEs.getRadius());
			  }
		  }  

		  // tmpVec  = Helicoentric planet position or geocentric lunar position
		  // tmpVec2 = Helicoentric position of the Earth
		  
		  if (planet != Planets.LUNA && planet != Planets.EARTH && planet != Planets.SUN){
			  // Planets: Change tmpVec from heliocentric to geocentric
			  tmpVec [0] -= tmpVec2 [0];
			  tmpVec [1] -= tmpVec2 [1];
			  tmpVec [2] -= tmpVec2 [2];
		  }

		  // reduce geocentric equatorial position tmpVec cartesian coordinates to topocentric
		  if (planet == Planets.LUNA || planet == Planets.EARTH || planet == Planets.SUN)
		  {passNo = 2;}	// no light time correction for sun and moon 	  

		  // Topocentric reduction in passNo 2
		  if  (passNo == 2) { // only in second pass of for Moon and Sun
			  if (topoc_Corr) TopocReductionEcl (tmpVec, localSiderealTime, oi.getLatitudeRad(), obliquity);

			// MOON: Calculate heliocentric position of the moon, for physical ephemeris, magnitude etc
			  if (planet == Planets.LUNA){				  
				  tmpVec2 [0] += tmpVec [0];
				  tmpVec2 [1] += tmpVec [1];
				  tmpVec2 [2] += tmpVec [2];
				  double tmpVec3[] = new double[MathOps.VECTOR_SIZE];
				  MathOps.cartesianToPolar(tmpVec2, tmpVec3);
				  m_polarLEs = new LocationElements (tmpVec3);
			  }
		  }
		  // Calc lightTimeCorrection in days for passNo 2
		  else {  // passNo == 1
			  final double LIGHTSPEED   = 299792.458;   // km/s
			  lightTimeCorrection = Math.sqrt(
					  tmpVec [0]*tmpVec [0]  +tmpVec [1]*tmpVec [1]  +tmpVec [2]*tmpVec [2])
				* AU /(LIGHTSPEED *86400.0); 
		  }

		  passNo ++;
	  } while (passNo <= 2);  // end of Light time correction passes
	  // end Strickling modification

	  m_eclipticLEs = new LocationElements(tmpVec);

	  // At this point,  eclipticLE is a unit vector in ecliptic
	  // coords of date.  Rotate it by 'obliquity' to get
	  // a vector in equatorial coords of date:
	  //
	  MathOps.rotateVector( tmpVec, obliquity, 0 );
	  //TopocReductionEqu (tmpVec, localSiderealTime, oi.getLatitudeRad());
	  m_equatorialLEs = new LocationElements(tmpVec);  // Cartesian!!

	  // extract RA/Dec from equatorial coords of date
	  //
	  m_rightAscension = Math.atan2(
			  m_equatorialLEs.getY(), m_equatorialLEs.getX() );
	  //    m_declination = Math.asin( m_equatorialLEs.getZ() );
	  m_declination = Math.atan2( m_equatorialLEs.getZ(), 
			  Math.sqrt(m_equatorialLEs.getX()* m_equatorialLEs.getX() +
					  m_equatorialLEs.getY()*m_equatorialLEs.getY())); // Correction by Strickling

	  // The following two rotations take us from a vector in
	  // equatorial coords of date to an alt/az vector:
	  //
	  MathOps.rotateVector( tmpVec, -localSiderealTime, 2 );

	  //Strickling Change Z To X and Y to -Y
	  m_hourAngle = Math.atan2( -tmpVec[LocationElements.Y], tmpVec[LocationElements.X] ); 

	  MathOps.rotateVector( tmpVec, oi.getLatitudeRad() - Astro.PI_OVER_TWO, 1);
	  m_altAzLEs = new LocationElements(tmpVec);  // Cartesian!!

	  m_initComplete=true;
  } //calc
  
  
    /** Reduces cartesian equatorial coordinates from geocentric to topocentric
     * 
     * @param cartVec equatorial
     * @param localSiderealTime in radians
     * @param latRad Latitude in radians
     */
	static void TopocReductionEqu (double cartVec [], // cartesian coordinates in AU
  		double localSiderealTime, double latRad) {
		final double AE           = 149597870.691;  	// km
		final double R_EARTH      = 6368;               // km mean Radius
		
	    double tmpVec2[] = new double[MathOps.VECTOR_SIZE];
	    MathOps.polarToCartesian (tmpVec2, localSiderealTime, latRad, R_EARTH/AE);  
	    cartVec [0] -= tmpVec2 [0];
	    cartVec [1] -= tmpVec2 [1];
	    cartVec [2] -= tmpVec2 [2];
//	    Log.d ("TopRed", "TopRed  "  +localSiderealTime +"  " +Math.atan2(tmpVec2 [0], tmpVec2 [1]));
	} //TopocReduction **************************************


    /** Reduces cartesian ecliptical coordinates from geocentric to topocentric
     * 
     * @param cartVec equatorial
     * @param localSiderealTime in radians
     * @param latRad Latitude in radians
     */
	protected static void TopocReductionEcl (double cartVec [], // cartesian coordinates in AU
    		double localSiderealTime, double latRad, double obliquity) {
		final double AE           = 149597870.691;  	// km
		final double R_EARTH      = 6368;               // km mean Radius
		
	    double tmpVec2[] = new double[MathOps.VECTOR_SIZE];
	    MathOps.polarToCartesian (tmpVec2, localSiderealTime, latRad, R_EARTH/AE);
	    MathOps.rotateVector( tmpVec2, -obliquity, 0 );
	    cartVec [0] -= tmpVec2 [0];
	    cartVec [1] -= tmpVec2 [1];
	    cartVec [2] -= tmpVec2 [2];
	} //TopocReduction **************************************
  
  
  

 /**
  * Get the <TT>Planets</TT> number.
  *
  * Example: Planets.MERCURY
  */
  public int planet() { return m_planet; }

 /**
  * Get the Julian day number.
  */
  public double jd() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_jd;
  }

 /**
  * Get the hour angle.
  */
  public double hourAngle() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_hourAngle;
  }

 /**
  * Get the polar latitude. (Heliocentric polar coordinates)
  */
  public double getPolarLat() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_polarLEs.getLatitude();
  }

  /**
   * Get the polar longitude. (Heliocentric polar coordinates)
   */
   public double getPolarLon() throws NoInitException {
     if ( !m_initComplete )
       throw new NoInitException( NoInit );

     return m_polarLEs.getLongitude();
   }

  /**
   * Get the polar radius. (Distance to sun)
   */
   public double getPolarRadius() throws NoInitException {
     if ( !m_initComplete )
       throw new NoInitException( NoInit );

     return m_polarLEs.getRadius();
   }

   /**
    * Get the Solar ecliptic latitude in radians 
    * (Geocentric ecliptical coordinates of the Sun, usually close to zero)
    */
    public double getSolarLat() throws NoInitException {
      if ( !m_initComplete )
        throw new NoInitException( NoInit );
      if (g_polarLEs.getRadius() == -1) Vsop.calcAllLEs( g_polarLEs, m_centuries, Planets.EARTH );	
      return -g_polarLEs.getLatitude();
    }

    /**
    * Get the geocentric ecliptic longitude of the Sun in radians
    */
    public double getSolarLon() throws NoInitException {
      if ( !m_initComplete )
        throw new NoInitException( NoInit );
      if (g_polarLEs.getRadius() == -1) Vsop.calcAllLEs( g_polarLEs, m_centuries, Planets.EARTH );	
      return g_polarLEs.getLongitude() +Math.PI;
    }

   /**
    * Get the solar radius of the Earth. (Distance Earth to Sun)
    */
    public double getSolarRadius() throws NoInitException {
      if ( !m_initComplete )
        throw new NoInitException( NoInit );
      if (g_polarLEs.getRadius() == -1) Vsop.calcAllLEs( g_polarLEs, m_centuries, Planets.EARTH );	
      return g_polarLEs.getRadius();
    }

    /**
     * Get the geocentric ecliptic cartesian Coords x, y, z. Add. by Strickling
     */
     public LocationElements getEclipticXYZ() throws NoInitException {
       if ( !m_initComplete )
         throw new NoInitException( NoInit );

       // Add by Strickling
       return m_eclipticLEs;
     }

     /**
      * Get the ecliptic latitude. Mod. by Strickling, geocentric polar coordinates
      */
      public double getEclipticLat() throws NoInitException {
        if ( !m_initComplete )
          throw new NoInitException( NoInit );

        // Modification by Strickling, Here is polar conversion needed!
        // return m_eclipticLEs.getLatitude();
        return Math.atan2 (m_eclipticLEs.getZ(), Math.sqrt(m_eclipticLEs.getX()* m_eclipticLEs.getX() +
        		m_eclipticLEs.getY()*m_eclipticLEs.getY()));
      }

 /**
  * Get the ecliptic longitude. Mod. by Strickling, geocentric polar coordinates in radians
  */
  public double getEclipticLon() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    // Modification by Strickling, Here is polar conversion needed!
    // return m_eclipticLEs.getLongitude();
    return Math.atan2(m_eclipticLEs.getY(), m_eclipticLEs.getX());
  }

 /**
  * Get the ecliptic radius. Mod. by Strickling, Distance to Earth
  */
  public double getEclipticRadius() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    // Modification by Strickling, Here is polar conversion needed!
    // return m_eclipticLEs.getRadius();
    return Math.sqrt( m_eclipticLEs.getX()* m_eclipticLEs.getX() 
    		  +m_eclipticLEs.getY()* m_eclipticLEs.getY()
    		  +m_eclipticLEs.getZ()* m_eclipticLEs.getZ());
  }

 /**
  * Get the equatorial latitude (y). Cartesian Coord-System
  */
  public double getEquatorialLat() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

      return m_equatorialLEs.getLatitude();  
    }

 /**
  * Get the equatorial longitude (x).  Cartesian Coord-System
  */
  public double getEquatorialLon() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_equatorialLEs.getLongitude();
  }

 /**
  * Get the equatorial radius (z).  Cartesian Coord-System
  */
  public double getEquatorialRadius() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_equatorialLEs.getRadius();
  }

 /**
  * Get the Alt-Az latitude. (Converted into polar coordinates)
  */
  public double getAltAzLat() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    // Modification by Strickling, Here is polar conversion needed!
    // return m_altAzLEs.getLatitude();
    return Math.atan2 (m_altAzLEs.getZ(), Math.sqrt(m_altAzLEs.getX()* m_altAzLEs.getX() +
    		m_altAzLEs.getY()*m_altAzLEs.getY()));
  }

 /**
  * Get the Alt-Az longitude. Radians, south is 0 deg (Converted into polar coordinates)
  */
  public double getAltAzLon() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    // Modification by Strickling, Here is polar conversion needed!
    // return m_altAzLEs.getLongitude();
    return Math.atan2(m_altAzLEs.getY(), m_altAzLEs.getX());
  }

 /**
  * Get the Alt-Az radius. (Converted into polar coordinates)
  */
  public double getAltAzRadius() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    // Modification by Strickling, Here is polar conversion needed!
    // return m_altAzLEs.getRadius();
    return Math.sqrt( m_altAzLEs.getX()* m_altAzLEs.getX() 
  		  +m_altAzLEs.getY()* m_altAzLEs.getY()
  		  +m_altAzLEs.getZ()* m_altAzLEs.getZ());
  }

 /**
  * Get the right ascension in radians.
  */
  public double getRightAscension() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_rightAscension;
  }

 /**
  * Get the declination in radians.
  */
  public double getDeclination() throws NoInitException {
    if ( !m_initComplete )
      throw new NoInitException( NoInit );

    return m_declination;
  }

  // instance data

  protected boolean m_initComplete;
  protected int m_planet;

  protected double m_jd;
  protected double m_centuries;
  protected double m_hourAngle;

  protected double m_rightAscension;
  protected double m_declination;

  protected LocationElements g_polarLEs;		// Polar Coord-System Elemts of Earth  Variable inserted by Strickling
  protected LocationElements m_polarLEs;		// Polar Coord-System Heliocentric
  protected LocationElements m_eclipticLEs;	// Cartesian Coord-System
  protected LocationElements m_equatorialLEs;	// Cartesian Coord-System
  protected LocationElements m_altAzLEs;		// Cartesian Coord-System

  private final static String NoInit = "Call PlanetData.calc() first.";
}
