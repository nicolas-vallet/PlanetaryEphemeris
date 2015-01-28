package com.nzv.astro.ephemeris.planetary;

/* pluto source from:
 * http://cpansearch.perl.org/src/SMUELLER/Astro-Nova-0.06/libnova-0.13.0/src/pluto.c
 * 
 * converted by Dr. W. Strickling, 2011-01-28
 */


public class Pluto2 {

	class pluto_argument 
	{
		double J, S, P;
	};

	class pluto_longitude
	{
		double A,B;
	};

	class pluto_latitude
	{
		double A,B;
	};

	class pluto_radius
	{
		double A,B;
	};

	/* cache variables */
	static double cJD = 0, cL = 0, cB = 0, cR = 0;

	static final int PLUTO_COEFFS = 43;

	static final int [] [] argument  = {
		{0, 0, 1},
		{0, 0, 2},
		{0, 0, 3},
		{0, 0, 4},
		{0, 0, 5},
		{0, 0, 6},
		{0, 1, -1},
		{0, 1, 0},
		{0, 1, 1},
		{0, 1, 2},
		{0, 1, 3},
		{0, 2, -2},
		{0, 2, -1},
		{0, 2, 0},
		{1, -1, 0},
		{1, -1, 1},
		{1, 0, -3},
		{1, 0, -2},
		{1, 0, -1},
		{1, 0, 0},
		{1, 0, 1},
		{1, 0, 2},
		{1, 0, 3},
		{1, 0, 4},
		{1, 1, -3},
		{1, 1, -2},
		{1, 1, -1},
		{1, 1, 0},
		{1, 1, 1},
		{1, 1, 3},
		{2, 0, -6},
		{2, 0, -5},
		{2, 0, -4},
		{2, 0, -3},
		{2, 0, -2},
		{2, 0, -1},
		{2, 0, 0},
		{2, 0, 1},
		{2, 0, 2},
		{2, 0, 3},
		{3, 0, -2},
		{3, 0, -1},
		{3, 0, 0}
	};


	static final long [] [] longitude  = {
		{-19799805, 19850055},
		{897144, -4954829},
		{611149, 1211027},
		{-341243, -189585},
		{129287, -34992},
		{-38164, 30893},
		{20442, -9987},
		{-4063, -5071},
		{-6016, -3336},
		{-3956, 3039},
		{-667, 3572},
		{1276, 501},
		{1152, -917},
		{630, -1277},
		{2571, -459},
		{899, -1449},
		{-1016, 1043},
		{-2343, -1012},
		{7042, 788},
		{1199, -338},
		{418, -67},
		{120, -274},
		{-60, -159},
		{-82, -29},
		{-36, -20},
		{-40, 7},
		{-14, 22},
		{4, 13},
		{5,2},
		{-1,0},
		{2,0},
		{-4, 5},
		{4, -7},
		{14, 24},
		{-49, -34},
		{163, -48},
		{9, 24},
		{-4, 1},
		{-3,1},
		{1,3},
		{-3, -1},
		{5, -3},
		{0,0}
	};

	static final long [] [] latitude = {
		{-5452852, -14974862},
		{3527812, 1672790},
		{-1050748, 327647},
		{178690, -292153},
		{18650, 100340},
		{-30697, -25823},
		{4878, 11248},
		{226, -64},
		{2030, -836},
		{69, -604},
		{-247, -567},
		{-57, 1},
		{-122, 175},
		{-49, -164},
		{-197, 199},
		{-25, 217},
		{589, -248},
		{-269, 711},
		{185, 193},
		{315, 807},
		{-130, -43},
		{5, 3},
		{2, 17},
		{2, 5},
		{2, 3},
		{3, 1},
		{2, -1},
		{1, -1},
		{0, -1},
		{0, 0},
		{0, -2},
		{2, 2},
		{-7, 0},
		{10, -8},
		{-3, 20},
		{6, 5},
		{14, 17},
		{-2, 0},
		{0, 0},
		{0, 0},
		{0, 1},
		{0, 0},
		{1, 0}
	}; 	

	static final long [] []  radius = {
		{66865439, 68951812},
		{-11827535, -332538},
		{1593179, -1438890},
		{-18444, 483220},
		{-65977, -85431},
		{31174, -6032},
		{-5794, 22161},
		{4601, 4032},
		{-1729, 234},
		{-415, 702},
		{239, 723},
		{67, -67},
		{1034, -451},
		{-129, 504},
		{480, -231},
		{2, -441},
		{-3359, 265},
		{7856, -7832},
		{36, 45763},
		{8663, 8547},
		{-809, -769},
		{263, -144},
		{-126, 32},
		{-35, -16},
		{-19, -4},
		{-15, 8},
		{-4, 12},
		{5, 6},
		{3, 1},
		{6, -2},
		{2, 2},
		{-2, -2},
		{14, 13},
		{-63, 13},
		{136, -236},
		{273, 1065},
		{251, 149},
		{-25, -9},
		{9, -2},
		{-8, 7},
		{2, -10},
		{19, 35},
		{10, 2}
	};




	/*! \fn void ln_get_pluto_helio_coords (double JD, struct ln_helio_posn * position)
	 * \param JD Julian Day
	 * \param position Pointer to store new heliocentric position
	 *
	 * Calculate Pluto's heliocentric coordinates for the given julian day. 
	 * This function is accurate to within 0.07" in longitude, 0.02" in latitude 
	 * and 0.000006 AU in radius vector.
	 *
	 * Note: This function is not valid outside the period of 1885-2099. 
	 */
	/* Chap 37. Equ 37.1
	 */

	static void ln_get_pluto_helio_coords (double JD, double [] lbr)
	{
		double sum_longitude = 0, sum_latitude = 0, sum_radius = 0;
		double J, S, P;
		double t, a, sin_a, cos_a;
		int i;


		/* get julian centuries since J2000 */
		t = (JD - 2451545) / 36525;

		/* calculate mean longitudes for jupiter, saturn and pluto */
		J =  34.35 + 3034.9057 * t;
		S =  50.08 + 1222.1138 * t;
		P = 238.96 +  144.9600 * t;

		/* calc periodic terms in table 37.A */
		for (i=0; i < PLUTO_COEFFS; i++) {
			a = argument[i][0] * J + argument[i][1] * S + argument[i][2] * P;
			sin_a = Math.sin (Math.toRadians(a));
			cos_a = Math.cos (Math.toRadians(a));

			/* longitude */
			sum_longitude += longitude[i][0] * sin_a + longitude[i][1] * cos_a;

			/* latitude */
			sum_latitude += latitude[i][0] * sin_a + latitude[i][1] * cos_a;

			/* radius */
			sum_radius += radius[i][0] * sin_a + radius[i][1]* cos_a;
		}

		/* calc L, B, R */
		lbr[0] = Math.toRadians(238.958116 + 144.96 * t + sum_longitude * 0.000001);
		lbr[1] = Math.toRadians(-3.908239 + sum_latitude * 0.000001);
		lbr[2] = 40.7241346 + sum_radius * 0.0000001; 
	}
}