/*****************************************************************************\
 * VsopData
\*****************************************************************************/

package com.nzv.astro.ephemeris.planetary;

// One VSOP term

class VsopSet {
  VsopSet( double a, double b, double c ) { A=a; B=b; C=c; }
  double A;
  double B;
  double C;
};

// A set of VSOP terms

class VsopTerms {
  int rows;          // number of term sets
  VsopSet pTerms[];  // pointer to start of data

  VsopTerms() { rows=0; }
  VsopTerms( int r, VsopSet p[] ) { rows=r; pTerms=p; }
};

/**
 * All the static VSOP data, in a separate file for managability.
 * <P>
 * Library users can ignore this class.
 */
public final class VsopData {

// Mercury Terms

static final int MercuryLonTerms0Rows = 38;
static final int MercuryLonTerms1Rows = 16;
static final int MercuryLonTerms2Rows = 10;
static final int MercuryLonTerms3Rows = 8;
static final int MercuryLonTerms4Rows = 6;
static final int MercuryLonTerms5Rows = 1;

static final int MercuryLatTerms0Rows = 14;
static final int MercuryLatTerms1Rows = 11;
static final int MercuryLatTerms2Rows = 9;
static final int MercuryLatTerms3Rows = 7;
static final int MercuryLatTerms4Rows = 2;
static final int MercuryLatTerms5Rows = 0;

static final int MercuryRadTerms0Rows = 13;
static final int MercuryRadTerms1Rows = 8;
static final int MercuryRadTerms2Rows = 7;
static final int MercuryRadTerms3Rows = 5;
static final int MercuryRadTerms4Rows = 0;
static final int MercuryRadTerms5Rows = 0;

static final VsopSet MercuryLonTerms0[] = {
    new VsopSet(        440250710.0,              0.0,              0.0  ),
    new VsopSet(         40989415.0,       1.48302034,  26087.903141574  ),
    new VsopSet(          5046294.0,        4.4778549,  52175.806283148  ),
    new VsopSet(           855347.0,       1.16520322,  78263.709424723  ),
    new VsopSet(           165590.0,       4.11969163, 104351.612566297  ),
    new VsopSet(            34562.0,      0.779307658, 130439.515707871  ),
    new VsopSet(             7583.0,       3.71348401, 156527.418849445  ),
    new VsopSet(             3560.0,       1.51202669,   1109.378552093  ),
    new VsopSet(             1803.0,       4.10333178,   5661.332049152  ),
    new VsopSet(             1726.0,      0.358322399, 182615.321991019  ),
    new VsopSet(             1590.0,       2.99510418,  25028.521211385  ),
    new VsopSet(             1365.0,       4.59918319,  27197.281693668  ),
    new VsopSet(             1017.0,       0.88031439,  31749.235190726  ),
    new VsopSet(              714.0,       1.54144865,  24978.524589481  ),
    new VsopSet(              644.0,       5.30266111,  21535.949644515  ),
    new VsopSet(              451.0,       6.04989275,  51116.424352959  ),
    new VsopSet(              404.0,       3.28228847, 208703.225132594  ),
    new VsopSet(              352.0,       5.24156297,  20426.571092422  ),
    new VsopSet(              345.0,       2.79211901,  15874.617595363  ),
    new VsopSet(              343.0,       5.76531885,    955.599741609  ),
    new VsopSet(              339.0,       5.86327765,   25558.21217648  ),
    new VsopSet(              325.0,       1.33674335,  53285.184835242  ),
    new VsopSet(              273.0,       2.49451164,    529.690965095  ),
    new VsopSet(              264.0,       3.91705094,  57837.138332301  ),
    new VsopSet(              260.0,      0.987324282,   4551.953497059  ),
    new VsopSet(              239.0,      0.113439534,   1059.381930189  ),
    new VsopSet(              235.0,      0.266721189,  11322.664098304  ),
    new VsopSet(              217.0,      0.659872073,  13521.751441591  ),
    new VsopSet(              209.0,       2.09178234,   47623.85278609  ),
    new VsopSet(              183.0,       2.62878671,  27043.502883183  ),
    new VsopSet(              182.0,       2.43413502,  25661.304950698  ),
    new VsopSet(              176.0,        4.5363683,  51066.427731055  ),
    new VsopSet(              173.0,       2.45200164,   24498.83024629  ),
    new VsopSet(              142.0,       3.36003949,  37410.567239879  ),
    new VsopSet(              138.0,      0.290984478,  10213.285546211  ),
    new VsopSet(              125.0,       3.72079804,  39609.654583166  ),
    new VsopSet(              118.0,       2.78149786, 77204.32749453301  ),
    new VsopSet(              106.0,       4.20572116,  19804.827291583 )
};

static final VsopSet MercuryLonTerms1[] = {
    new VsopSet(    2608814706223.0,                0.0,                0.0  ),
    new VsopSet(          1126008.0,       6.21703971,  26087.903141574  ),
    new VsopSet(           303471.0,       3.05565472,  52175.806283148  ),
    new VsopSet(            80538.0,       6.10454743,  78263.709424723  ),
    new VsopSet(            21245.0,       2.83531934, 104351.612566297  ),
    new VsopSet(             5592.0,       5.82675673, 130439.515707871  ),
    new VsopSet(             1472.0,       2.51845458, 156527.418849445  ),
    new VsopSet(              388.0,       5.48039226, 182615.321991019  ),
    new VsopSet(              352.0,       3.05238094,   1109.378552093  ),
    new VsopSet(              103.0,       2.14879174, 208703.225132594  ),
    new VsopSet(               94.0,       6.11791164,  27197.281693668  ),
    new VsopSet(               91.0,      0.000454817,  24978.524589481  ),
    new VsopSet(               52.0,       5.62107554,   5661.332049152  ),
    new VsopSet(               44.0,       4.57348501,  25028.521211385  ),
    new VsopSet(               28.0,       3.04195431,  51066.427731055  ),
    new VsopSet(               27.0,       5.09210139, 234791.128274168 )
};

static final VsopSet MercuryLonTerms2[] = {
    new VsopSet(            53050.0,                0.0,                0.0  ),
    new VsopSet(            16904.0,       4.69072301,  26087.903141574  ),
    new VsopSet(             7397.0,       1.34735625,  52175.806283148  ),
    new VsopSet(             3018.0,        4.4564354,  78263.709424723  ),
    new VsopSet(             1107.0,       1.26226538, 104351.612566297  ),
    new VsopSet(              378.0,       4.31998056, 130439.515707871  ),
    new VsopSet(              123.0,       1.06868541, 156527.418849445  ),
    new VsopSet(               39.0,        4.0801161, 182615.321991019  ),
    new VsopSet(               15.0,       4.63343086,   1109.378552093  ),
    new VsopSet(               12.0,      0.791876464, 208703.225132594 )
};

static final VsopSet MercuryLonTerms3[] = {
    new VsopSet(              188.0,      0.034668301,  52175.806283148  ),
    new VsopSet(              142.0,       3.12505453,  26087.903141574  ),
    new VsopSet(               97.0,       3.00378172,  78263.709424723  ),
    new VsopSet(               44.0,       6.01867966, 104351.612566297  ),
    new VsopSet(               35.0,                0.0,                0.0  ),
    new VsopSet(               18.0,       2.77538374, 130439.515707871  ),
    new VsopSet(                7.0,       5.81808666, 156527.418849445  ),
    new VsopSet(                3.0,       2.57014364, 182615.321991019 )
};

static final VsopSet MercuryLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(                3.0,       2.02848008,  26087.903141574  ),
    new VsopSet(                2.0,       1.41731804,  78263.709424723  ),
    new VsopSet(                2.0,       4.50137644,  52175.806283148  ),
    new VsopSet(                1.0,       4.49970181, 104351.612566297  ),
    new VsopSet(                1.0,       1.26591777, 130439.515707871 )
};

static final VsopSet MercuryLonTerms5[] = {
    new VsopSet(                1.0,       3.14159265,                0.0 )
};

static final VsopSet MercuryLatTerms0[] = {
    new VsopSet(         11737529.0,       1.98357499,  26087.903141574  ),
    new VsopSet(          2388077.0,        5.0373896,  52175.806283148  ),
    new VsopSet(          1222840.0,       3.14159265,                0.0  ),
    new VsopSet(           543252.0,       1.79644364,  78263.709424723  ),
    new VsopSet(           129779.0,       4.83232504, 104351.612566297  ),
    new VsopSet(            31867.0,       1.58088496, 130439.515707871  ),
    new VsopSet(             7963.0,       4.60972126, 156527.418849445  ),
    new VsopSet(             2014.0,       1.35324165, 182615.321991019  ),
    new VsopSet(              514.0,       4.37835409, 208703.225132594  ),
    new VsopSet(              209.0,       2.02020294,  24978.524589481  ),
    new VsopSet(              208.0,       4.91772564,  27197.281693668  ),
    new VsopSet(              132.0,       1.11908492, 234791.128274168  ),
    new VsopSet(              121.0,       1.81271752,  53285.184835242  ),
    new VsopSet(              100.0,       5.65684734,  20426.571092422 )
};

static final VsopSet MercuryLatTerms1[] = {
    new VsopSet(           429151.0,        3.5016978,  26087.903141574  ),
    new VsopSet(           146234.0,       3.14159265,                0.0  ),
    new VsopSet(            22675.0,      0.015153669,  52175.806283148  ),
    new VsopSet(            10895.0,       0.48540174,  78263.709424723  ),
    new VsopSet(             6353.0,        3.4294392, 104351.612566297  ),
    new VsopSet(             2496.0,      0.160512107, 130439.515707871  ),
    new VsopSet(              860.0,       3.18452434, 156527.418849445  ),
    new VsopSet(              278.0,       6.21020774, 182615.321991019  ),
    new VsopSet(               86.0,       2.95244392, 208703.225132594  ),
    new VsopSet(               28.0,      0.290689389,  27197.281693668  ),
    new VsopSet(               26.0,       5.97708963, 234791.128274168 )
};

static final VsopSet MercuryLatTerms2[] = {
    new VsopSet(            11831.0,       4.79065586,  26087.903141574  ),
    new VsopSet(             1914.0,                0.0,                0.0  ),
    new VsopSet(             1045.0,        1.2121654,  52175.806283148  ),
    new VsopSet(              266.0,       4.43418337,  78263.709424723  ),
    new VsopSet(              170.0,       1.62255639, 104351.612566297  ),
    new VsopSet(               96.0,       4.80023692, 130439.515707871  ),
    new VsopSet(               45.0,       1.60758268, 156527.418849445  ),
    new VsopSet(               18.0,       4.66904655, 182615.321991019  ),
    new VsopSet(                7.0,       1.43404889, 208703.225132594 )
};

static final VsopSet MercuryLatTerms3[] = {
    new VsopSet(              235.0,      0.353875246,  26087.903141574  ),
    new VsopSet(              161.0,                0.0,                0.0  ),
    new VsopSet(               19.0,        4.3627546,  52175.806283148  ),
    new VsopSet(                6.0,       2.50715381,  78263.709424723  ),
    new VsopSet(                5.0,       6.14257818, 104351.612566297  ),
    new VsopSet(                3.0,       3.12497553, 130439.515707871  ),
    new VsopSet(                2.0,       6.26642412, 156527.418849445 )
};

static final VsopSet MercuryLatTerms4[] = {
    new VsopSet(                4.0,       1.74579932,  26087.903141574  ),
    new VsopSet(                1.0,       3.14159265,                0.0 )
};

static final VsopSet MercuryLatTerms5[] = null;

static final VsopSet MercuryRadTerms0[] = {
    new VsopSet(         39528272.0,                0.0,                0.0  ),
    new VsopSet(          7834132.0,       6.19233723,  26087.903141574  ),
    new VsopSet(           795526.0,        2.9598969,  52175.806283148  ),
    new VsopSet(           121282.0,       6.01064154,  78263.709424723  ),
    new VsopSet(            21922.0,       2.77820094, 104351.612566297  ),
    new VsopSet(             4354.0,       5.82894543, 130439.515707871  ),
    new VsopSet(              918.0,       2.59650563, 156527.418849445  ),
    new VsopSet(              290.0,       1.42441937,  25028.521211385  ),
    new VsopSet(              260.0,       3.02817754,  27197.281693668  ),
    new VsopSet(              202.0,        5.6472504, 182615.321991019  ),
    new VsopSet(              201.0,       5.59227724,  31749.235190726  ),
    new VsopSet(              142.0,       6.25264203,  24978.524589481  ),
    new VsopSet(              100.0,       3.73435609,  21535.949644515 )
};

static final VsopSet MercuryRadTerms1[] = {
    new VsopSet(           217348.0,       4.65617159,  26087.903141574  ),
    new VsopSet(            44142.0,       1.42385544,  52175.806283148  ),
    new VsopSet(            10094.0,       4.47466326,  78263.709424723  ),
    new VsopSet(             2433.0,       1.24226083, 104351.612566297  ),
    new VsopSet(             1624.0,                0.0,                0.0  ),
    new VsopSet(              604.0,       4.29303117, 130439.515707871  ),
    new VsopSet(              153.0,        1.0606078, 156527.418849445  ),
    new VsopSet(               39.0,       4.11136751, 182615.321991019 )
};

static final VsopSet MercuryRadTerms2[] = {
    new VsopSet(             3118.0,        3.0823184,  26087.903141574  ),
    new VsopSet(             1245.0,       6.15183317,  52175.806283148  ),
    new VsopSet(              425.0,       2.92583353,  78263.709424723  ),
    new VsopSet(              136.0,       5.97983926, 104351.612566297  ),
    new VsopSet(               42.0,       2.74936981, 130439.515707871  ),
    new VsopSet(               22.0,       3.14159265,                0.0  ),
    new VsopSet(               13.0,       5.80143162, 156527.418849445 )
};

static final VsopSet MercuryRadTerms3[] = {
    new VsopSet(               33.0,       1.67971635,  26087.903141574  ),
    new VsopSet(               24.0,       4.63403169,  52175.806283148  ),
    new VsopSet(               12.0,       1.38983781,  78263.709424723  ),
    new VsopSet(                5.0,       4.43915387, 104351.612566297  ),
    new VsopSet(                2.0,        1.2073388, 130439.515707871 )
};

static final VsopSet MercuryRadTerms4[] = null;

static final VsopSet MercuryRadTerms5[] = null;

// Mercury TermTable
static final VsopTerms[] MercuryLonTerms = {
  new VsopTerms( MercuryLonTerms0Rows, MercuryLonTerms0 ),
  new VsopTerms( MercuryLonTerms1Rows, MercuryLonTerms1 ),
  new VsopTerms( MercuryLonTerms2Rows, MercuryLonTerms2 ),
  new VsopTerms( MercuryLonTerms3Rows, MercuryLonTerms3 ),
  new VsopTerms( MercuryLonTerms4Rows, MercuryLonTerms4 ),
  new VsopTerms( MercuryLonTerms5Rows, MercuryLonTerms5 )
};

static final VsopTerms[] MercuryLatTerms = {
  new VsopTerms( MercuryLatTerms0Rows, MercuryLatTerms0 ),
  new VsopTerms( MercuryLatTerms1Rows, MercuryLatTerms1 ),
  new VsopTerms( MercuryLatTerms2Rows, MercuryLatTerms2 ),
  new VsopTerms( MercuryLatTerms3Rows, MercuryLatTerms3 ),
  new VsopTerms( MercuryLatTerms4Rows, MercuryLatTerms4 ),
  new VsopTerms( MercuryLatTerms5Rows, MercuryLatTerms5 )
};

static final VsopTerms[] MercuryRadTerms = {
  new VsopTerms( MercuryRadTerms0Rows, MercuryRadTerms0 ),
  new VsopTerms( MercuryRadTerms1Rows, MercuryRadTerms1 ),
  new VsopTerms( MercuryRadTerms2Rows, MercuryRadTerms2 ),
  new VsopTerms( MercuryRadTerms3Rows, MercuryRadTerms3 ),
  new VsopTerms( MercuryRadTerms4Rows, MercuryRadTerms4 ),
  new VsopTerms( MercuryRadTerms5Rows, MercuryRadTerms5 )
};


// Venus Terms
static final int VenusLonTerms0Rows = 24;
static final int VenusLonTerms1Rows = 12;
static final int VenusLonTerms2Rows = 8;
static final int VenusLonTerms3Rows = 3;
static final int VenusLonTerms4Rows = 3;
static final int VenusLonTerms5Rows = 1;

static final int VenusLatTerms0Rows = 9;
static final int VenusLatTerms1Rows = 4;
static final int VenusLatTerms2Rows = 4;
static final int VenusLatTerms3Rows = 4;
static final int VenusLatTerms4Rows = 1;
static final int VenusLatTerms5Rows = 0;

static final int VenusRadTerms0Rows = 12;
static final int VenusRadTerms1Rows = 3;
static final int VenusRadTerms2Rows = 3;
static final int VenusRadTerms3Rows = 1;
static final int VenusRadTerms4Rows = 1;
static final int VenusRadTerms5Rows = 0;

static final VsopSet VenusLonTerms0[] = {
    new VsopSet(        317614667.0,                0.0,                0.0  ),
    new VsopSet(          1353968.0,        5.5931332,  10213.285546211  ),
    new VsopSet(            89892.0,       5.30650048,  20426.571092422  ),
    new VsopSet(             5477.0,       4.41630653,   7860.419392439  ),
    new VsopSet(             3456.0,       2.69964471,  11790.629088659  ),
    new VsopSet(             2372.0,        2.9937754,    3930.20969622  ),
    new VsopSet(             1664.0,       4.25018935,   1577.343542448  ),
    new VsopSet(             1438.0,       4.15745044,   9683.594581116  ),
    new VsopSet(             1317.0,       5.18668219,       26.2983198  ),
    new VsopSet(             1201.0,       6.15357115,  30639.856638633  ),
    new VsopSet(              769.0,      0.816296159,   9437.762934887  ),
    new VsopSet(              761.0,       1.95014702,    529.690965095  ),
    new VsopSet(              708.0,       1.06466707,    775.522611324  ),
    new VsopSet(              585.0,       3.99839885,    191.448266112  ),
    new VsopSet(              500.0,        4.1234021,  15720.838784878  ),
    new VsopSet(              429.0,        3.5864286,  19367.189162233  ),
    new VsopSet(              327.0,       5.67736584,   5507.553238667  ),
    new VsopSet(              326.0,       4.59056473,  10404.733812323  ),
    new VsopSet(              232.0,       3.16251057,   9153.903616022  ),
    new VsopSet(              180.0,       4.65337916,   1109.378552093  ),
    new VsopSet(              155.0,       5.57043889,  19651.048481098  ),
    new VsopSet(              128.0,       4.22604494,     20.775395492  ),
    new VsopSet(              128.0,      0.962098227,   5661.332049152  ),
    new VsopSet(              106.0,       1.53721191,    801.820931124 )
};

static final VsopSet VenusLonTerms1[] = {
    new VsopSet(    1021352943053.0,                0.0,                0.0  ),
    new VsopSet(            95708.0,       2.46424449,  10213.285546211  ),
    new VsopSet(            14445.0,      0.516245647,  20426.571092422  ),
    new VsopSet(              213.0,       1.79547929,  30639.856638633  ),
    new VsopSet(              174.0,       2.65535879,       26.2983198  ),
    new VsopSet(              152.0,       6.10635282,   1577.343542448  ),
    new VsopSet(               82.0,       5.70234134,    191.448266112  ),
    new VsopSet(               70.0,       2.68136035,   9437.762934887  ),
    new VsopSet(               52.0,       3.60013088,    775.522611324  ),
    new VsopSet(               38.0,       1.03379038,    529.690965095  ),
    new VsopSet(               30.0,       1.25056322,   5507.553238667  ),
    new VsopSet(               25.0,       6.10664793,  10404.733812323 )
};

static final VsopSet VenusLonTerms2[] = {
    new VsopSet(            54127.0,                0.0,                0.0  ),
    new VsopSet(             3891.0,        0.3451436,  10213.285546211  ),
    new VsopSet(             1338.0,       2.02011286,  20426.571092422  ),
    new VsopSet(               24.0,       2.04592119,       26.2983198  ),
    new VsopSet(               19.0,       3.53527372,  30639.856638633  ),
    new VsopSet(               10.0,       3.97130221,    775.522611324  ),
    new VsopSet(                7.0,       1.51962593,   1577.343542448  ),
    new VsopSet(                6.0,      0.999267579,    191.448266112  )
};

static final VsopSet VenusLonTerms3[] = {
    new VsopSet(              136.0,       4.80389021,  10213.285546211  ),
    new VsopSet(               78.0,       3.66876372,  20426.571092422  ),
    new VsopSet(               26.0,                0.0,                0.0  )
};

static final VsopSet VenusLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(                3.0,        5.2051417,  20426.571092422  ),
    new VsopSet(                2.0,       2.51099592,  10213.285546211  )
};

static final VsopSet VenusLonTerms5[] = {
    new VsopSet(                1.0,       3.14159265,                0.0  )
};

static final VsopSet VenusLatTerms0[] = {
    new VsopSet(          5923638.0,      0.267027758,  10213.285546211  ),
    new VsopSet(            40108.0,       1.14737178,  20426.571092422  ),
    new VsopSet(            32815.0,       3.14159265,                0.0  ),
    new VsopSet(             1011.0,       1.08946123,  30639.856638633  ),
    new VsopSet(              149.0,       6.25390296,   18073.70493865  ),
    new VsopSet(              138.0,      0.860201465,   1577.343542448  ),
    new VsopSet(              130.0,       3.67152484,   9437.762934887  ),
    new VsopSet(              120.0,       3.70468813,   2352.866153772  ),
    new VsopSet(              108.0,       4.53903678,   22003.91463487  )
};

static final VsopSet VenusLatTerms1[] = {
    new VsopSet(           513348.0,       1.80364311,  10213.285546211  ),
    new VsopSet(             4380.0,       3.38615712,  20426.571092422  ),
    new VsopSet(              199.0,                0.0,                0.0  ),
    new VsopSet(              197.0,       2.53001197,  30639.856638633  )
};

static final VsopSet VenusLatTerms2[] = {
    new VsopSet(            22378.0,       3.38509144,  10213.285546211  ),
    new VsopSet(              282.0,                0.0,                0.0  ),
    new VsopSet(              173.0,       5.25563767,  20426.571092422  ),
    new VsopSet(               27.0,       3.87040892,  30639.856638633  )
};

static final VsopSet VenusLatTerms3[] = {
    new VsopSet(              647.0,       4.99166565,  10213.285546211  ),
    new VsopSet(               20.0,       3.14159265,                0.0  ),
    new VsopSet(                6.0,       0.77376924,  20426.571092422  ),
    new VsopSet(                3.0,       5.44493763,  30639.856638633  )
};

static final VsopSet VenusLatTerms4[] = {
    new VsopSet(               14.0,      0.315371902,  10213.285546211  )
};

static final VsopSet VenusLatTerms5[] = null;

static final VsopSet VenusRadTerms0[] = {
    new VsopSet(         72334821.0,                0.0,                0.0  ),
    new VsopSet(           489824.0,       4.02151832,  10213.285546211  ),
    new VsopSet(             1658.0,       4.90206728,  20426.571092422  ),
    new VsopSet(             1632.0,       2.84548852,   7860.419392439  ),
    new VsopSet(             1378.0,       1.12846591,  11790.629088659  ),
    new VsopSet(              498.0,       2.58682188,   9683.594581116  ),
    new VsopSet(              374.0,       1.42314837,    3930.20969622  ),
    new VsopSet(              264.0,       5.52938186,   9437.762934887  ),
    new VsopSet(              237.0,       2.55135904,  15720.838784878  ),
    new VsopSet(              222.0,       2.01346777,  19367.189162233  ),
    new VsopSet(              126.0,       2.72769834,   1577.343542448  ),
    new VsopSet(              119.0,       3.01975365,  10404.733812323  )
};

static final VsopSet VenusRadTerms1[] = {
    new VsopSet(            34551.0,      0.891987106,  10213.285546211  ),
    new VsopSet(              234.0,       1.77224943,  20426.571092422  ),
    new VsopSet(              234.0,       3.14159265,                0.0  )
};

static final VsopSet VenusRadTerms2[] = {
    new VsopSet(             1407.0,       5.06366395,  10213.285546211  ),
    new VsopSet(               16.0,       5.47321688,  20426.571092422  ),
    new VsopSet(               13.0,                0.0,                0.0  )
};

static final VsopSet VenusRadTerms3[] = {
    new VsopSet(               50.0,       3.22263555,  10213.285546211  )
};

static final VsopSet VenusRadTerms4[] = {
    new VsopSet(                1.0,      0.922296978,  10213.285546211  )
};

static final VsopSet VenusRadTerms5[] = null;

// Venus TermTable
static final VsopTerms[] VenusLonTerms = {
  new VsopTerms( VenusLonTerms0Rows, VenusLonTerms0 ),
  new VsopTerms( VenusLonTerms1Rows, VenusLonTerms1 ),
  new VsopTerms( VenusLonTerms2Rows, VenusLonTerms2 ),
  new VsopTerms( VenusLonTerms3Rows, VenusLonTerms3 ),
  new VsopTerms( VenusLonTerms4Rows, VenusLonTerms4 ),
  new VsopTerms( VenusLonTerms5Rows, VenusLonTerms5 )
};

static final VsopTerms[] VenusLatTerms = {
  new VsopTerms( VenusLatTerms0Rows, VenusLatTerms0 ),
  new VsopTerms( VenusLatTerms1Rows, VenusLatTerms1 ),
  new VsopTerms( VenusLatTerms2Rows, VenusLatTerms2 ),
  new VsopTerms( VenusLatTerms3Rows, VenusLatTerms3 ),
  new VsopTerms( VenusLatTerms4Rows, VenusLatTerms4 ),
  new VsopTerms( VenusLatTerms5Rows, VenusLatTerms5 )
};

static final VsopTerms[] VenusRadTerms = {
  new VsopTerms( VenusRadTerms0Rows, VenusRadTerms0 ),
  new VsopTerms( VenusRadTerms1Rows, VenusRadTerms1 ),
  new VsopTerms( VenusRadTerms2Rows, VenusRadTerms2 ),
  new VsopTerms( VenusRadTerms3Rows, VenusRadTerms3 ),
  new VsopTerms( VenusRadTerms4Rows, VenusRadTerms4 ),
  new VsopTerms( VenusRadTerms5Rows, VenusRadTerms5 )
};

// Earth Terms
static final int EarthLonTerms0Rows = 64;
static final int EarthLonTerms1Rows = 34;
static final int EarthLonTerms2Rows = 20;
static final int EarthLonTerms3Rows = 7;
static final int EarthLonTerms4Rows = 3;
static final int EarthLonTerms5Rows = 1;

static final int EarthLatTerms0Rows = 5;
static final int EarthLatTerms1Rows = 2;
static final int EarthLatTerms2Rows = 0;
static final int EarthLatTerms3Rows = 0;
static final int EarthLatTerms4Rows = 0;
static final int EarthLatTerms5Rows = 0;

static final int EarthRadTerms0Rows = 40;
static final int EarthRadTerms1Rows = 10;
static final int EarthRadTerms2Rows = 6;
static final int EarthRadTerms3Rows = 2;
static final int EarthRadTerms4Rows = 1;
static final int EarthRadTerms5Rows = 0;

static final VsopSet EarthLonTerms0[] = {
    new VsopSet(        175347046.0,                0.0,                0.0  ),
    new VsopSet(          3341656.0,        4.6692568,   6283.075849991  ),
    new VsopSet(            34894.0,       4.62610242,  12566.151699983  ),
    new VsopSet(             3497.0,       2.74411801,   5753.384884897  ),
    new VsopSet(             3418.0,        2.8288658,       3.52311835  ),
    new VsopSet(             3136.0,       3.62767042, 77713.77146812101  ),
    new VsopSet(             2676.0,       4.41808351,   7860.419392439  ),
    new VsopSet(             2343.0,       6.13516238,    3930.20969622  ),
    new VsopSet(             1324.0,      0.742463564,  11506.769769794  ),
    new VsopSet(             1273.0,       2.03709656,    529.690965095  ),
    new VsopSet(             1199.0,       1.10962944,   1577.343542448  ),
    new VsopSet(              990.0,        5.2326813,   5884.926846583  ),
    new VsopSet(              902.0,       2.04505443,       26.2983198  ),
    new VsopSet(              857.0,       3.50849157,    398.149003408  ),
    new VsopSet(              780.0,       1.17882652,   5223.693919802  ),
    new VsopSet(              753.0,       2.53339054,   5507.553238667  ),
    new VsopSet(              505.0,       4.58292563,  18849.227549974  ),
    new VsopSet(              492.0,        4.2050664,    775.522611324  ),
    new VsopSet(              357.0,       2.91954117,      0.067310303  ),
    new VsopSet(              317.0,       5.84901952,  11790.629088659  ),
    new VsopSet(              284.0,       1.89869034,    796.298006816  ),
    new VsopSet(              271.0,      0.314886076,  10977.078804699  ),
    new VsopSet(              243.0,      0.344811409,   5486.777843175  ),
    new VsopSet(              206.0,       4.80646606,   2544.314419883  ),
    new VsopSet(              205.0,       1.86947814,   5573.142801433  ),
    new VsopSet(              202.0,       2.45767795,   6069.776754553  ),
    new VsopSet(              156.0,      0.833060738,    213.299095438  ),
    new VsopSet(              132.0,       3.41118276,   2942.463423292  ),
    new VsopSet(              126.0,        1.0830263,     20.775395492  ),
    new VsopSet(              115.0,      0.645449117,      0.980321068  ),
    new VsopSet(              103.0,      0.635998467,   4694.002954708  ),
    new VsopSet(              102.0,      0.975692218,  15720.838784878  ),
    new VsopSet(              102.0,       4.26679821,         7.113547  ),
    new VsopSet(               99.0,        6.2099294,   2146.165416475  ),
    new VsopSet(               98.0,      0.681012723,    155.420399434  ),
    new VsopSet(               86.0,       5.98322631, 161000.685737674  ),
    new VsopSet(               85.0,       1.29870743,   6275.962302991  ),
    new VsopSet(               85.0,       3.67080093,  71430.695618129  ),
    new VsopSet(               80.0,       1.80791331,   17260.15465469  ),
    new VsopSet(               79.0,       3.03698313,  12036.460734888  ),
    new VsopSet(               75.0,       1.75508916,   5088.628839767  ),
    new VsopSet(               74.0,       3.50319443,   3154.687084896  ),
    new VsopSet(               74.0,       4.67926566,    801.820931124  ),
    new VsopSet(               70.0,       0.83297597,   9437.762934887  ),
    new VsopSet(               62.0,       3.97763881,   8827.390269875  ),
    new VsopSet(               61.0,       1.81839811,   7084.896781115  ),
    new VsopSet(               57.0,       2.78430398,    6286.59896834  ),
    new VsopSet(               56.0,       4.38694881,  14143.495242431  ),
    new VsopSet(               56.0,       3.47006009,   6279.552731642  ),
    new VsopSet(               52.0,      0.189149458,  12139.553509107  ),
    new VsopSet(               52.0,       1.33282747,   1748.016413067  ),
    new VsopSet(               51.0,      0.283068645,   5856.477659115  ),
    new VsopSet(               49.0,       0.48735065,   1194.447010225  ),
    new VsopSet(               41.0,       5.36817351,   8429.241266467  ),
    new VsopSet(               41.0,       2.39850882,  19651.048481098  ),
    new VsopSet(               39.0,       6.16832995,  10447.387839604  ),
    new VsopSet(               37.0,       6.04133859,  10213.285546211  ),
    new VsopSet(               37.0,       2.56955239,   1059.381930189  ),
    new VsopSet(               36.0,       1.70876112,   2352.866153772  ),
    new VsopSet(               36.0,       1.77597315,   6812.766815086  ),
    new VsopSet(               33.0,      0.593094995,  17789.845619785  ),
    new VsopSet(               30.0,      0.442944641,  83996.847318112  ),
    new VsopSet(               30.0,       2.73975124,   1349.867409659  ),
    new VsopSet(               25.0,       3.16470953,   4690.479836359  )
};

static final VsopSet EarthLonTerms1[] = {
    new VsopSet(     628331966747.0,                0.0,                0.0  ),
    new VsopSet(           206059.0,       2.67823456,   6283.075849991  ),
    new VsopSet(             4303.0,        2.6351265,  12566.151699983  ),
    new VsopSet(              425.0,       1.59046981,       3.52311835  ),
    new VsopSet(              119.0,       5.79557488,       26.2983198  ),
    new VsopSet(              109.0,       2.96618002,   1577.343542448  ),
    new VsopSet(               93.0,       2.59212835,  18849.227549974  ),
    new VsopSet(               72.0,       1.13846158,    529.690965095  ),
    new VsopSet(               68.0,       1.87472305,    398.149003408  ),
    new VsopSet(               67.0,       4.40918235,   5507.553238667  ),
    new VsopSet(               59.0,       2.88797039,   5223.693919802  ),
    new VsopSet(               56.0,        2.1747168,    155.420399434  ),
    new VsopSet(               45.0,      0.398030798,    796.298006816  ),
    new VsopSet(               36.0,      0.466247398,    775.522611324  ),
    new VsopSet(               29.0,       2.64707384,         7.113547  ),
    new VsopSet(               21.0,       5.34138275,      0.980321068  ),
    new VsopSet(               19.0,       1.84628333,   5486.777843175  ),
    new VsopSet(               19.0,       4.96855125,    213.299095438  ),
    new VsopSet(               17.0,       2.99116865,   6275.962302991  ),
    new VsopSet(               16.0,       0.03216483,   2544.314419883  ),
    new VsopSet(               16.0,       1.43049285,   2146.165416475  ),
    new VsopSet(               15.0,       1.20532366,  10977.078804699  ),
    new VsopSet(               12.0,       2.83432285,   1748.016413067  ),
    new VsopSet(               12.0,       3.25804816,   5088.628839767  ),
    new VsopSet(               12.0,       5.27379791,   1194.447010225  ),
    new VsopSet(               12.0,       2.07502418,   4694.002954708  ),
    new VsopSet(               11.0,      0.766141992,    553.569402842  ),
    new VsopSet(               10.0,       1.30262991,    6286.59896834  ),
    new VsopSet(               10.0,       4.23925472,   1349.867409659  ),
    new VsopSet(                9.0,       2.69957063,    242.728603974  ),
    new VsopSet(                9.0,       5.64475868,    951.718406251  ),
    new VsopSet(                8.0,       5.30062665,   2352.866153772  ),
    new VsopSet(                6.0,       2.65033985,   9437.762934887  ),
    new VsopSet(                6.0,       4.66632584,   4690.479836359  )
};

static final VsopSet EarthLonTerms2[] = {
    new VsopSet(            52919.0,                0.0,                0.0  ),
    new VsopSet(             8720.0,       1.07209665,   6283.075849991  ),
    new VsopSet(              309.0,      0.867288188,  12566.151699983  ),
    new VsopSet(               27.0,      0.052978717,       3.52311835  ),
    new VsopSet(               16.0,       5.18826691,       26.2983198  ),
    new VsopSet(               16.0,       3.68457889,    155.420399434  ),
    new VsopSet(               10.0,      0.757422977,  18849.227549974  ),
    new VsopSet(                9.0,       2.05705419, 77713.77146812101  ),
    new VsopSet(                7.0,      0.826733054,    775.522611324  ),
    new VsopSet(                5.0,       4.66284525,   1577.343542448  ),
    new VsopSet(                4.0,       1.03057163,         7.113547  ),
    new VsopSet(                4.0,       3.44050804,   5573.142801433  ),
    new VsopSet(                3.0,       5.14074633,    796.298006816  ),
    new VsopSet(                3.0,       6.05291851,   5507.553238667  ),
    new VsopSet(                3.0,       1.19246506,    242.728603974  ),
    new VsopSet(                3.0,       6.11652627,    529.690965095  ),
    new VsopSet(                3.0,       0.30637881,    398.149003408  ),
    new VsopSet(                3.0,       2.27992811,    553.569402842  ),
    new VsopSet(                2.0,       4.38118838,   5223.693919802  ),
    new VsopSet(                2.0,       3.75435331,      0.980321068  )
};

static final VsopSet EarthLonTerms3[] = {
    new VsopSet(              289.0,       5.84384199,   6283.075849991  ),
    new VsopSet(               35.0,                0.0,                0.0  ),
    new VsopSet(               17.0,       5.48766912,  12566.151699983  ),
    new VsopSet(                3.0,       5.19577265,    155.420399434  ),
    new VsopSet(                1.0,       4.72200252,       3.52311835  ),
    new VsopSet(                1.0,       5.30045809,  18849.227549974  ),
    new VsopSet(                1.0,       5.96925937,    242.728603974  )
};

static final VsopSet EarthLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(                8.0,       4.13446589,   6283.075849991  ),
    new VsopSet(                1.0,       3.83803776,  12566.151699983  )
};

static final VsopSet EarthLonTerms5[] = {
    new VsopSet(                1.0,       3.14159265,                0.0  )
};

static final VsopSet EarthLatTerms0[] = {
    new VsopSet(              280.0,       3.19870156,  84334.661581308  ),
    new VsopSet(              102.0,       5.42248619,   5507.553238667  ),
    new VsopSet(               80.0,       3.88013204,   5223.693919802  ),
    new VsopSet(               44.0,        3.7044469,   2352.866153772  ),
    new VsopSet(               32.0,        4.0002637,   1577.343542448  )
};

static final VsopSet EarthLatTerms1[] = {
    new VsopSet(                9.0,       3.89729062,   5507.553238667  ),
    new VsopSet(                6.0,        1.7303885,   5223.693919802  )
};

static final VsopSet EarthLatTerms2[] = null;

static final VsopSet EarthLatTerms3[] = null;

static final VsopSet EarthLatTerms4[] = null;

static final VsopSet EarthLatTerms5[] = null;

static final VsopSet EarthRadTerms0[] = {
    new VsopSet(        100013989.0,                0.0,                0.0  ),
    new VsopSet(          1670700.0,       3.09846351,   6283.075849991  ),
    new VsopSet(            13956.0,        3.0552461,  12566.151699983  ),
    new VsopSet(             3084.0,       5.19846674, 77713.77146812101  ),
    new VsopSet(             1628.0,       1.17387749,   5753.384884897  ),
    new VsopSet(             1576.0,       2.84685246,   7860.419392439  ),
    new VsopSet(              925.0,       5.45292234,  11506.769769794  ),
    new VsopSet(              542.0,        4.5640915,    3930.20969622  ),
    new VsopSet(              472.0,       3.66100022,   5884.926846583  ),
    new VsopSet(              346.0,      0.963686177,   5507.553238667  ),
    new VsopSet(              329.0,       5.89983646,   5223.693919802  ),
    new VsopSet(              307.0,      0.298671395,   5573.142801433  ),
    new VsopSet(              243.0,       4.27349536,  11790.629088659  ),
    new VsopSet(              212.0,        5.8471454,   1577.343542448  ),
    new VsopSet(              186.0,       5.02194447,  10977.078804699  ),
    new VsopSet(              175.0,       3.01193636,  18849.227549974  ),
    new VsopSet(              110.0,       5.05510636,   5486.777843175  ),
    new VsopSet(               98.0,      0.886813113,   6069.776754553  ),
    new VsopSet(               86.0,       5.68959778,  15720.838784878  ),
    new VsopSet(               86.0,       1.27083733, 161000.685737674  ),
    new VsopSet(               65.0,      0.272506138,   17260.15465469  ),
    new VsopSet(               63.0,      0.921771088,    529.690965095  ),
    new VsopSet(               57.0,       2.01374292,  83996.847318112  ),
    new VsopSet(               56.0,       5.24159799,  71430.695618129  ),
    new VsopSet(               49.0,        3.2450124,   2544.314419883  ),
    new VsopSet(               47.0,        2.5780507,    775.522611324  ),
    new VsopSet(               45.0,       5.53715807,   9437.762934887  ),
    new VsopSet(               43.0,       6.01110242,   6275.962302991  ),
    new VsopSet(               39.0,       5.36071738,   4694.002954708  ),
    new VsopSet(               38.0,       2.39255344,   8827.390269875  ),
    new VsopSet(               37.0,      0.829529223,  19651.048481098  ),
    new VsopSet(               37.0,       4.90107592,  12139.553509107  ),
    new VsopSet(               36.0,       1.67468059,  12036.460734888  ),
    new VsopSet(               35.0,       1.84270693,   2942.463423292  ),
    new VsopSet(               33.0,      0.243703001,   7084.896781115  ),
    new VsopSet(               32.0,      0.183682298,   5088.628839767  ),
    new VsopSet(               32.0,       1.77775642,    398.149003408  ),
    new VsopSet(               28.0,       1.21344868,    6286.59896834  ),
    new VsopSet(               28.0,       1.89934331,   6279.552731642  ),
    new VsopSet(               26.0,        4.5889685,  10447.387839604  )
};

static final VsopSet EarthRadTerms1[] = {
    new VsopSet(           103019.0,        1.1074897,   6283.075849991  ),
    new VsopSet(             1721.0,       1.06442301,  12566.151699983  ),
    new VsopSet(              702.0,       3.14159265,                0.0  ),
    new VsopSet(               32.0,       1.02169059,  18849.227549974  ),
    new VsopSet(               31.0,       2.84353805,   5507.553238667  ),
    new VsopSet(               25.0,        1.3190671,   5223.693919802  ),
    new VsopSet(               18.0,       1.42429749,   1577.343542448  ),
    new VsopSet(               10.0,       5.91378195,  10977.078804699  ),
    new VsopSet(                9.0,       1.42046854,   6275.962302991  ),
    new VsopSet(                9.0,      0.271461506,   5486.777843175  )
};

static final VsopSet EarthRadTerms2[] = {
    new VsopSet(             4359.0,       5.78455134,   6283.075849991  ),
    new VsopSet(              124.0,       5.57934722,  12566.151699983  ),
    new VsopSet(               12.0,       3.14159265,                0.0  ),
    new VsopSet(                9.0,       3.62777733,  77713.771468121  ),
    new VsopSet(                6.0,       1.86958905,   5573.142801433  ),
    new VsopSet(                3.0,       5.47027913,  18849.227549974  )
};

static final VsopSet EarthRadTerms3[] = {
    new VsopSet(              145.0,       4.27319435,   6283.075849991  ),
    new VsopSet(                7.0,       3.91697609,  12566.151699983  )
};

static final VsopSet EarthRadTerms4[] = {
    new VsopSet(                4.0,       2.56384387,   6283.075849991  )
};

static final VsopSet EarthRadTerms5[] = null;

// Earth TermTable
static final VsopTerms[] EarthLonTerms = {
  new VsopTerms( EarthLonTerms0Rows, EarthLonTerms0 ),
  new VsopTerms( EarthLonTerms1Rows, EarthLonTerms1 ),
  new VsopTerms( EarthLonTerms2Rows, EarthLonTerms2 ),
  new VsopTerms( EarthLonTerms3Rows, EarthLonTerms3 ),
  new VsopTerms( EarthLonTerms4Rows, EarthLonTerms4 ),
  new VsopTerms( EarthLonTerms5Rows, EarthLonTerms5 )
};

static final VsopTerms[] EarthLatTerms = {
  new VsopTerms( EarthLatTerms0Rows, EarthLatTerms0 ),
  new VsopTerms( EarthLatTerms1Rows, EarthLatTerms1 ),
  new VsopTerms( EarthLatTerms2Rows, EarthLatTerms2 ),
  new VsopTerms( EarthLatTerms3Rows, EarthLatTerms3 ),
  new VsopTerms( EarthLatTerms4Rows, EarthLatTerms4 ),
  new VsopTerms( EarthLatTerms5Rows, EarthLatTerms5 )
};

static final VsopTerms[] EarthRadTerms = {
  new VsopTerms( EarthRadTerms0Rows, EarthRadTerms0 ),
  new VsopTerms( EarthRadTerms1Rows, EarthRadTerms1 ),
  new VsopTerms( EarthRadTerms2Rows, EarthRadTerms2 ),
  new VsopTerms( EarthRadTerms3Rows, EarthRadTerms3 ),
  new VsopTerms( EarthRadTerms4Rows, EarthRadTerms4 ),
  new VsopTerms( EarthRadTerms5Rows, EarthRadTerms5 )
};

// Mars Terms
static final int MarsLonTerms0Rows = 69;
static final int MarsLonTerms1Rows = 46;
static final int MarsLonTerms2Rows = 33;
static final int MarsLonTerms3Rows = 12;
static final int MarsLonTerms4Rows = 8;
static final int MarsLonTerms5Rows = 2;

static final int MarsLatTerms0Rows = 16;
static final int MarsLatTerms1Rows = 9;
static final int MarsLatTerms2Rows = 7;
static final int MarsLatTerms3Rows = 4;
static final int MarsLatTerms4Rows = 3;
static final int MarsLatTerms5Rows = 0;

static final int MarsRadTerms0Rows = 45;
static final int MarsRadTerms1Rows = 27;
static final int MarsRadTerms2Rows = 11;
static final int MarsRadTerms3Rows = 6;
static final int MarsRadTerms4Rows = 4;
static final int MarsRadTerms5Rows = 0;

static final VsopSet MarsLonTerms0[] = {
    new VsopSet(        620347712.0,                0.0,                0.0  ),
    new VsopSet(         18656368.0,         5.050371,     3340.6124267  ),
    new VsopSet(          1108217.0,       5.40099837,     6681.2248534  ),
    new VsopSet(            91798.0,       5.75478745,  10021.837280099  ),
    new VsopSet(            27745.0,       5.97049513,       3.52311835  ),
    new VsopSet(            12316.0,      0.849560812,   2810.921461605  ),
    new VsopSet(            10610.0,       2.93958525,   2281.230496511  ),
    new VsopSet(             8927.0,       4.15697846,      0.017253652  ),
    new VsopSet(             8716.0,        6.1100516,  13362.449706799  ),
    new VsopSet(             7775.0,       3.33968655,    5621.84292321  ),
    new VsopSet(             6798.0,      0.364622436,    398.149003408  ),
    new VsopSet(             4161.0,      0.228149753,   2942.463423292  ),
    new VsopSet(             3575.0,        1.6618654,   2544.314419883  ),
    new VsopSet(             3075.0,      0.856965971,    191.448266112  ),
    new VsopSet(             2938.0,       6.07893711,      0.067310303  ),
    new VsopSet(             2628.0,      0.648061436,   3337.089308351  ),
    new VsopSet(             2580.0,      0.029967062,   3344.135545049  ),
    new VsopSet(             2389.0,       5.03896401,    796.298006816  ),
    new VsopSet(             1799.0,      0.656340268,    529.690965095  ),
    new VsopSet(             1546.0,       2.91579633,   1751.539531416  ),
    new VsopSet(             1528.0,       1.14979306,   6151.533888305  ),
    new VsopSet(             1286.0,       3.06795925,   2146.165416475  ),
    new VsopSet(             1264.0,       3.62275092,   5092.151958116  ),
    new VsopSet(             1025.0,       3.69334294,    8962.45534991  ),
    new VsopSet(              892.0,      0.182938991,  16703.062133499  ),
    new VsopSet(              859.0,       2.40093704,   2914.014235824  ),
    new VsopSet(              833.0,       4.49495754,   3340.629680352  ),
    new VsopSet(              833.0,       2.46418591,   3340.595173048  ),
    new VsopSet(              749.0,       3.82248399,    155.420399434  ),
    new VsopSet(              724.0,      0.674975658,   3738.761430108  ),
    new VsopSet(              713.0,       3.66336015,   1059.381930189  ),
    new VsopSet(              655.0,      0.488640752,   3127.313331262  ),
    new VsopSet(              636.0,       2.92182704,   8432.764384816  ),
    new VsopSet(              553.0,       4.47478863,   1748.016413067  ),
    new VsopSet(              550.0,       3.81001205,      0.980321068  ),
    new VsopSet(              472.0,       3.62547819,   1194.447010225  ),
    new VsopSet(              426.0,      0.553651382,   6283.075849991  ),
    new VsopSet(              415.0,      0.496623148,    213.299095438  ),
    new VsopSet(              312.0,      0.998533228,   6677.701735051  ),
    new VsopSet(              307.0,       0.38052863,   6684.747971749  ),
    new VsopSet(              302.0,        4.4861815,   3532.060692811  ),
    new VsopSet(              299.0,       2.78323706,   6254.626662524  ),
    new VsopSet(              293.0,       4.22131278,     20.775395492  ),
    new VsopSet(              284.0,       5.76885494,   3149.164160588  ),
    new VsopSet(              281.0,       5.88163373,   1349.867409659  ),
    new VsopSet(              274.0,      0.133725012,   3340.679737003  ),
    new VsopSet(              274.0,      0.542221418,   3340.545116397  ),
    new VsopSet(              239.0,       5.37155472,   4136.910433516  ),
    new VsopSet(              236.0,       5.75504516,   3333.498879699  ),
    new VsopSet(              231.0,       1.28240685,   3870.303391794  ),
    new VsopSet(              221.0,       3.50466672,    382.896532223  ),
    new VsopSet(              204.0,       2.82133266,   1221.848566321  ),
    new VsopSet(              193.0,       3.35715138,       3.59042865  ),
    new VsopSet(              189.0,       1.49103017,   9492.146315005  ),
    new VsopSet(              179.0,       1.00561113,    951.718406251  ),
    new VsopSet(              174.0,       2.41360333,    553.569402842  ),
    new VsopSet(              172.0,      0.439430417,   5486.777843175  ),
    new VsopSet(              160.0,       3.94854735,   4562.460993021  ),
    new VsopSet(              144.0,       1.41874193,    135.065080035  ),
    new VsopSet(              140.0,       3.32592516,   2700.715140386  ),
    new VsopSet(              138.0,       4.30145177,         7.113547  ),
    new VsopSet(              131.0,        4.0449172,   12303.06777661  ),
    new VsopSet(              128.0,       2.20806651,   1592.596013633  ),
    new VsopSet(              128.0,       1.80665643,   5088.628839767  ),
    new VsopSet(              117.0,       3.12805282,   7903.073419721  ),
    new VsopSet(              113.0,       3.70070798,   1589.072895284  ),
    new VsopSet(              110.0,        1.0519508,    242.728603974  ),
    new VsopSet(              105.0,      0.785353821,   8827.390269875  ),
    new VsopSet(              100.0,       3.24343741,  11773.376811515  )
};

static final VsopSet MarsLonTerms1[] = {
    new VsopSet(     334085627474.0,                0.0,                0.0  ),
    new VsopSet(          1458227.0,       3.60426054,     3340.6124267  ),
    new VsopSet(           164901.0,       3.92631251,     6681.2248534  ),
    new VsopSet(            19963.0,       4.26594061,  10021.837280099  ),
    new VsopSet(             3452.0,       4.73210386,       3.52311835  ),
    new VsopSet(             2485.0,       4.61277567,  13362.449706799  ),
    new VsopSet(              842.0,       4.45858257,   2281.230496511  ),
    new VsopSet(              538.0,       5.01589728,    398.149003408  ),
    new VsopSet(              521.0,       4.99422678,   3344.135545049  ),
    new VsopSet(              433.0,       2.56066403,    191.448266112  ),
    new VsopSet(              430.0,       5.31646162,    155.420399434  ),
    new VsopSet(              382.0,       3.53881289,    796.298006816  ),
    new VsopSet(              314.0,       4.96335266,  16703.062133499  ),
    new VsopSet(              283.0,       3.15967518,   2544.314419883  ),
    new VsopSet(              206.0,       4.56891456,   2146.165416475  ),
    new VsopSet(              169.0,       1.32894813,   3337.089308351  ),
    new VsopSet(              158.0,       4.18501036,   1751.539531416  ),
    new VsopSet(              134.0,       2.23325104,      0.980321068  ),
    new VsopSet(              134.0,       5.97421904,   1748.016413067  ),
    new VsopSet(              118.0,       6.02407214,   6151.533888305  ),
    new VsopSet(              117.0,       2.21347652,   1059.381930189  ),
    new VsopSet(              114.0,       2.12869455,   1194.447010225  ),
    new VsopSet(              114.0,       5.42803224,   3738.761430108  ),
    new VsopSet(               91.0,       1.09627837,   1349.867409659  ),
    new VsopSet(               85.0,       3.90854841,    553.569402842  ),
    new VsopSet(               83.0,       5.29636626,   6684.747971749  ),
    new VsopSet(               81.0,       4.42813406,    529.690965095  ),
    new VsopSet(               80.0,       2.24864266,    8962.45534991  ),
    new VsopSet(               73.0,       2.50189461,    951.718406251  ),
    new VsopSet(               73.0,       5.84208163,    242.728603974  ),
    new VsopSet(               71.0,       3.85636094,   2914.014235824  ),
    new VsopSet(               68.0,       5.02327686,    382.896532223  ),
    new VsopSet(               65.0,       1.01802439,   3340.595173048  ),
    new VsopSet(               65.0,       3.04879604,   3340.629680352  ),
    new VsopSet(               62.0,        4.1518316,   3149.164160588  ),
    new VsopSet(               57.0,       3.88813699,   4136.910433516  ),
    new VsopSet(               48.0,       4.87362122,    213.299095438  ),
    new VsopSet(               48.0,       1.18238046,   3333.498879699  ),
    new VsopSet(               47.0,        1.3145242,   3185.192027266  ),
    new VsopSet(               41.0,      0.713853755,   1592.596013633  ),
    new VsopSet(               40.0,       2.72542481,         7.113547  ),
    new VsopSet(               40.0,       5.31611875,  20043.674560199  ),
    new VsopSet(               33.0,       5.41067412,   6283.075849991  ),
    new VsopSet(               28.0,      0.045341249,   9492.146315005  ),
    new VsopSet(               27.0,       3.88960725,   1221.848566321  ),
    new VsopSet(               27.0,       5.11271748,   2700.715140386  )
};

static final VsopSet MarsLonTerms2[] = {
    new VsopSet(            58016.0,       2.04979463,     3340.6124267  ),
    new VsopSet(            54188.0,                0.0,                0.0  ),
    new VsopSet(            13908.0,        2.4574236,     6681.2248534  ),
    new VsopSet(             2465.0,       2.80000021,  10021.837280099  ),
    new VsopSet(              398.0,       3.14118428,  13362.449706799  ),
    new VsopSet(              222.0,        3.1943608,       3.52311835  ),
    new VsopSet(              121.0,      0.543252925,    155.420399434  ),
    new VsopSet(               62.0,       3.48529427,  16703.062133499  ),
    new VsopSet(               54.0,       3.54191121,   3344.135545049  ),
    new VsopSet(               34.0,       6.00188499,   2281.230496511  ),
    new VsopSet(               32.0,       4.14015172,    191.448266112  ),
    new VsopSet(               30.0,        1.9987068,    796.298006816  ),
    new VsopSet(               23.0,       4.33403366,    242.728603974  ),
    new VsopSet(               22.0,       3.44532466,    398.149003408  ),
    new VsopSet(               20.0,       5.42191375,    553.569402842  ),
    new VsopSet(               16.0,      0.656789533,      0.980321068  ),
    new VsopSet(               16.0,       6.11000472,   2146.165416475  ),
    new VsopSet(               16.0,       1.22086122,   1748.016413067  ),
    new VsopSet(               15.0,       6.09541784,   3185.192027266  ),
    new VsopSet(               14.0,       4.01923812,    951.718406251  ),
    new VsopSet(               14.0,       2.61851898,   1349.867409659  ),
    new VsopSet(               13.0,      0.601890084,   1194.447010225  ),
    new VsopSet(               12.0,       3.86122163,   6684.747971749  ),
    new VsopSet(               11.0,       4.71822364,   2544.314419883  ),
    new VsopSet(               10.0,      0.250387147,    382.896532223  ),
    new VsopSet(                9.0,      0.681707136,   1059.381930189  ),
    new VsopSet(                9.0,       3.83209092,  20043.674560199  ),
    new VsopSet(                9.0,       3.88271826,   3738.761430108  ),
    new VsopSet(                8.0,        5.4649863,   1751.539531416  ),
    new VsopSet(                7.0,       2.57522504,   3149.164160588  ),
    new VsopSet(                7.0,        2.3784369,   4136.910433516  ),
    new VsopSet(                6.0,       5.47773073,   1592.596013633  ),
    new VsopSet(                6.0,       2.34104794,   3097.883822726  )
};

static final VsopSet MarsLonTerms3[] = {
    new VsopSet(             1482.0,      0.444346949,     3340.6124267  ),
    new VsopSet(              662.0,      0.884691787,     6681.2248534  ),
    new VsopSet(              188.0,       1.28799983,  10021.837280099  ),
    new VsopSet(               41.0,       1.64850787,  13362.449706799  ),
    new VsopSet(               26.0,                0.0,                0.0  ),
    new VsopSet(               23.0,       2.05267665,    155.420399434  ),
    new VsopSet(               10.0,       1.58006906,       3.52311835  ),
    new VsopSet(                8.0,       1.99858758,  16703.062133499  ),
    new VsopSet(                5.0,       2.82452458,    242.728603974  ),
    new VsopSet(                4.0,       2.01914273,   3344.135545049  ),
    new VsopSet(                3.0,       4.59144898,   3185.192027266  ),
    new VsopSet(                3.0,      0.650447143,    553.569402842  )
};

static final VsopSet MarsLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(               29.0,       5.63662412,     6681.2248534  ),
    new VsopSet(               24.0,       5.13868482,     3340.6124267  ),
    new VsopSet(               11.0,       6.03161074,  10021.837280099  ),
    new VsopSet(                3.0,      0.132283507,  13362.449706799  ),
    new VsopSet(                3.0,       3.56267988,    155.420399434  ),
    new VsopSet(                1.0,      0.493407834,  16703.062133499  ),
    new VsopSet(                1.0,       1.31734532,    242.728603974  )
};

static final VsopSet MarsLonTerms5[] = {
    new VsopSet(                1.0,       3.14159265,                0.0  ),
    new VsopSet(                1.0,       4.04089997,     6681.2248534  )
};

static final VsopSet MarsLatTerms0[] = {
    new VsopSet(          3197135.0,       3.76832042,     3340.6124267  ),
    new VsopSet(           298033.0,       4.10616996,     6681.2248534  ),
    new VsopSet(           289105.0,                0.0,                0.0  ),
    new VsopSet(            31366.0,       4.44651053,  10021.837280099  ),
    new VsopSet(             3484.0,       4.78812548,  13362.449706799  ),
    new VsopSet(              443.0,        5.0264262,   3344.135545049  ),
    new VsopSet(              443.0,       5.65233016,   3337.089308351  ),
    new VsopSet(              399.0,       5.13056815,  16703.062133499  ),
    new VsopSet(              293.0,       3.79290645,   2281.230496511  ),
    new VsopSet(              182.0,       6.13648012,   6151.533888305  ),
    new VsopSet(              163.0,       4.26399627,    529.690965095  ),
    new VsopSet(              160.0,        2.2319461,   1059.381930189  ),
    new VsopSet(              149.0,        2.1650121,    5621.84292321  ),
    new VsopSet(              143.0,       1.18215016,   3340.595173048  ),
    new VsopSet(              143.0,       3.21292181,   3340.629680352  ),
    new VsopSet(              139.0,       2.41796344,    8962.45534991  )
};

static final VsopSet MarsLatTerms1[] = {
    new VsopSet(           350069.0,       5.36847836,     3340.6124267  ),
    new VsopSet(            14116.0,       3.14159265,                0.0  ),
    new VsopSet(             9671.0,       5.47877786,     6681.2248534  ),
    new VsopSet(             1472.0,       3.20205767,  10021.837280099  ),
    new VsopSet(              426.0,       3.40843813,  13362.449706799  ),
    new VsopSet(              102.0,      0.776172862,   3337.089308351  ),
    new VsopSet(               79.0,       3.71768294,  16703.062133499  ),
    new VsopSet(               33.0,       3.45803724,    5621.84292321  ),
    new VsopSet(               26.0,       2.48293558,   2281.230496511  )
};

static final VsopSet MarsLatTerms2[] = {
    new VsopSet(            16727.0,      0.602213924,     3340.6124267  ),
    new VsopSet(             4987.0,       3.14159265,                0.0  ),
    new VsopSet(              302.0,       5.55871276,     6681.2248534  ),
    new VsopSet(               26.0,       1.89662673,  13362.449706799  ),
    new VsopSet(               21.0,      0.917499686,  10021.837280099  ),
    new VsopSet(               12.0,       2.24240739,   3337.089308351  ),
    new VsopSet(                8.0,       2.24892867,  16703.062133499  )
};

static final VsopSet MarsLatTerms3[] = {
    new VsopSet(              607.0,       1.98050634,     3340.6124267  ),
    new VsopSet(               43.0,                0.0,                0.0  ),
    new VsopSet(               14.0,       1.79588229,     6681.2248534  ),
    new VsopSet(                3.0,       3.45377082,  10021.837280099  )
};

static final VsopSet MarsLatTerms4[] = {
    new VsopSet(               13.0,                0.0,                0.0  ),
    new VsopSet(               11.0,       3.45724353,     3340.6124267  ),
    new VsopSet(                1.0,      0.504458053,     6681.2248534  )
};

static final VsopSet MarsLatTerms5[] = null;

static final VsopSet MarsRadTerms0[] = {
    new VsopSet(        153033488.0,                0.0,                0.0  ),
    new VsopSet(         14184953.0,       3.47971283,     3340.6124267  ),
    new VsopSet(           660776.0,       3.81783442,     6681.2248534  ),
    new VsopSet(            46179.0,       4.15595316,  10021.837280099  ),
    new VsopSet(             8110.0,        5.5595846,   2810.921461605  ),
    new VsopSet(             7485.0,       1.77238998,    5621.84292321  ),
    new VsopSet(             5523.0,       1.36436319,   2281.230496511  ),
    new VsopSet(             3825.0,       4.49407182,  13362.449706799  ),
    new VsopSet(             2484.0,       4.92545578,   2942.463423292  ),
    new VsopSet(             2307.0,      0.090817425,   2544.314419883  ),
    new VsopSet(             1999.0,       5.36059605,   3337.089308351  ),
    new VsopSet(             1960.0,       4.74249386,   3344.135545049  ),
    new VsopSet(             1167.0,       2.11261501,   5092.151958116  ),
    new VsopSet(             1103.0,       5.00908264,    398.149003408  ),
    new VsopSet(              992.0,       5.83862401,   6151.533888305  ),
    new VsopSet(              899.0,       4.40790434,    529.690965095  ),
    new VsopSet(              807.0,       2.10216647,   1059.381930189  ),
    new VsopSet(              798.0,       3.44839026,    796.298006816  ),
    new VsopSet(              741.0,       1.49906337,   2146.165416475  ),
    new VsopSet(              726.0,       1.24516914,   8432.764384816  ),
    new VsopSet(              692.0,       2.13378815,    8962.45534991  ),
    new VsopSet(              633.0,       0.89353285,   3340.595173048  ),
    new VsopSet(              633.0,       2.92430448,   3340.629680352  ),
    new VsopSet(              630.0,       1.28738136,   1751.539531416  ),
    new VsopSet(              574.0,      0.828961963,   2914.014235824  ),
    new VsopSet(              526.0,       5.38292276,   3738.761430108  ),
    new VsopSet(              473.0,       5.19850458,   3127.313331262  ),
    new VsopSet(              348.0,       4.83219199,  16703.062133499  ),
    new VsopSet(              284.0,       2.90692295,   3532.060692811  ),
    new VsopSet(              280.0,       5.25749248,   6283.075849991  ),
    new VsopSet(              276.0,       1.21767968,   6254.626662524  ),
    new VsopSet(              275.0,       2.90818884,   1748.016413067  ),
    new VsopSet(              270.0,       3.76394729,   5884.926846583  ),
    new VsopSet(              239.0,       2.03669896,   1194.447010225  ),
    new VsopSet(              234.0,       5.10546492,   5486.777843175  ),
    new VsopSet(              228.0,       3.25529021,   6872.673119511  ),
    new VsopSet(              223.0,       4.19861594,   3149.164160588  ),
    new VsopSet(              219.0,       5.58340249,    191.448266112  ),
    new VsopSet(              208.0,       4.84626442,   3340.679737003  ),
    new VsopSet(              208.0,       5.25476081,   3340.545116397  ),
    new VsopSet(              186.0,       5.69871556,   6677.701735051  ),
    new VsopSet(              183.0,       5.08062683,   6684.747971749  ),
    new VsopSet(              179.0,       4.18423026,   3333.498879699  ),
    new VsopSet(              176.0,       5.95341786,   3870.303391794  ),
    new VsopSet(              164.0,       3.79889068,   4136.910433516  )
};

static final VsopSet MarsRadTerms1[] = {
    new VsopSet(          1107433.0,       2.03250525,     3340.6124267  ),
    new VsopSet(           103176.0,       2.37071846,     6681.2248534  ),
    new VsopSet(            12877.0,                0.0,                0.0  ),
    new VsopSet(            10816.0,       2.70888094,  10021.837280099  ),
    new VsopSet(             1195.0,       3.04702182,  13362.449706799  ),
    new VsopSet(              439.0,       2.88835073,   2281.230496511  ),
    new VsopSet(              396.0,       3.42324611,   3344.135545049  ),
    new VsopSet(              183.0,       1.58428644,   2544.314419883  ),
    new VsopSet(              136.0,       3.38507018,  16703.062133499  ),
    new VsopSet(              128.0,        6.0434336,   3337.089308351  ),
    new VsopSet(              128.0,      0.629912206,   1059.381930189  ),
    new VsopSet(              127.0,       1.95389776,    796.298006816  ),
    new VsopSet(              118.0,       2.99761345,   2146.165416475  ),
    new VsopSet(               88.0,       3.42052759,    398.149003408  ),
    new VsopSet(               83.0,       3.85574987,   3738.761430108  ),
    new VsopSet(               76.0,       4.45101839,   6151.533888305  ),
    new VsopSet(               72.0,       2.76442181,    529.690965095  ),
    new VsopSet(               67.0,       2.54892603,   1751.539531416  ),
    new VsopSet(               66.0,        4.4059755,   1748.016413067  ),
    new VsopSet(               58.0,      0.543543279,   1194.447010225  ),
    new VsopSet(               54.0,      0.677509435,    8962.45534991  ),
    new VsopSet(               51.0,       3.72585409,   6684.747971749  ),
    new VsopSet(               49.0,       5.72959428,   3340.595173048  ),
    new VsopSet(               49.0,       1.47717922,   3340.629680352  ),
    new VsopSet(               48.0,       2.58061691,   3149.164160588  ),
    new VsopSet(               48.0,       2.28527897,   2914.014235824  ),
    new VsopSet(               39.0,       2.31900091,   4136.910433516  )
};

static final VsopSet MarsRadTerms2[] = {
    new VsopSet(            44242.0,      0.479306039,     3340.6124267  ),
    new VsopSet(             8138.0,      0.869983981,     6681.2248534  ),
    new VsopSet(             1275.0,       1.22594051,  10021.837280099  ),
    new VsopSet(              187.0,       1.57298992,  13362.449706799  ),
    new VsopSet(               52.0,       3.14159265,                0.0  ),
    new VsopSet(               41.0,       1.97080175,   3344.135545049  ),
    new VsopSet(               27.0,       1.91665616,  16703.062133499  ),
    new VsopSet(               18.0,       4.43499505,   2281.230496511  ),
    new VsopSet(               12.0,       4.52510454,   3185.192027266  ),
    new VsopSet(               10.0,        5.3914347,   1059.381930189  ),
    new VsopSet(               10.0,      0.418705772,    796.298006816  )
};

static final VsopSet MarsRadTerms3[] = {
    new VsopSet(             1113.0,        5.1498735,     3340.6124267  ),
    new VsopSet(              424.0,       5.61343767,     6681.2248534  ),
    new VsopSet(              100.0,       5.99726827,  10021.837280099  ),
    new VsopSet(               20.0,      0.076330621,  13362.449706799  ),
    new VsopSet(                5.0,       3.14159265,                0.0  ),
    new VsopSet(                3.0,      0.429519076,  16703.062133499  )
};

static final VsopSet MarsRadTerms4[] = {
    new VsopSet(               20.0,       3.58211651,     3340.6124267  ),
    new VsopSet(               16.0,       4.05116077,     6681.2248534  ),
    new VsopSet(                6.0,       4.46383962,  10021.837280099  ),
    new VsopSet(                2.0,       4.84374322,  13362.449706799  )
};

static final VsopSet MarsRadTerms5[] = null;

// Mars TermTable
static final VsopTerms[] MarsLonTerms = {
  new VsopTerms( MarsLonTerms0Rows, MarsLonTerms0 ),
  new VsopTerms( MarsLonTerms1Rows, MarsLonTerms1 ),
  new VsopTerms( MarsLonTerms2Rows, MarsLonTerms2 ),
  new VsopTerms( MarsLonTerms3Rows, MarsLonTerms3 ),
  new VsopTerms( MarsLonTerms4Rows, MarsLonTerms4 ),
  new VsopTerms( MarsLonTerms5Rows, MarsLonTerms5 )
};

static final VsopTerms[] MarsLatTerms = {
  new VsopTerms( MarsLatTerms0Rows, MarsLatTerms0 ),
  new VsopTerms( MarsLatTerms1Rows, MarsLatTerms1 ),
  new VsopTerms( MarsLatTerms2Rows, MarsLatTerms2 ),
  new VsopTerms( MarsLatTerms3Rows, MarsLatTerms3 ),
  new VsopTerms( MarsLatTerms4Rows, MarsLatTerms4 ),
  new VsopTerms( MarsLatTerms5Rows, MarsLatTerms5 )
};

static final VsopTerms[] MarsRadTerms = {
  new VsopTerms( MarsRadTerms0Rows, MarsRadTerms0 ),
  new VsopTerms( MarsRadTerms1Rows, MarsRadTerms1 ),
  new VsopTerms( MarsRadTerms2Rows, MarsRadTerms2 ),
  new VsopTerms( MarsRadTerms3Rows, MarsRadTerms3 ),
  new VsopTerms( MarsRadTerms4Rows, MarsRadTerms4 ),
  new VsopTerms( MarsRadTerms5Rows, MarsRadTerms5 )
};


// Jupiter Terms
static final int JupiterLonTerms0Rows = 64;
static final int JupiterLonTerms1Rows = 61;
static final int JupiterLonTerms2Rows = 57;
static final int JupiterLonTerms3Rows = 39;
static final int JupiterLonTerms4Rows = 19;
static final int JupiterLonTerms5Rows = 5;

static final int JupiterLatTerms0Rows = 26;
static final int JupiterLatTerms1Rows = 22;
static final int JupiterLatTerms2Rows = 14;
static final int JupiterLatTerms3Rows = 9;
static final int JupiterLatTerms4Rows = 6;
static final int JupiterLatTerms5Rows = 1;

static final int JupiterRadTerms0Rows = 46;
static final int JupiterRadTerms1Rows = 43;
static final int JupiterRadTerms2Rows = 36;
static final int JupiterRadTerms3Rows = 28;
static final int JupiterRadTerms4Rows = 15;
static final int JupiterRadTerms5Rows = 7;

static final VsopSet JupiterLonTerms0[] = {
    new VsopSet(         59954691.0,                0.0,                0.0  ),
    new VsopSet(          9695899.0,       5.06191793,    529.690965095  ),
    new VsopSet(           573610.0,       1.44406206,         7.113547  ),
    new VsopSet(           306389.0,        5.4173473,   1059.381930189  ),
    new VsopSet(            97178.0,       4.14264709,    632.783739313  ),
    new VsopSet(            72903.0,       3.64042909,    522.577418094  ),
    new VsopSet(            64264.0,       3.41145185,    103.092774219  ),
    new VsopSet(            39806.0,       2.29376745,    419.484643875  ),
    new VsopSet(            38858.0,       1.27231725,    316.391869657  ),
    new VsopSet(            27965.0,       1.78454589,    536.804512095  ),
    new VsopSet(            13590.0,       5.77481032,   1589.072895284  ),
    new VsopSet(             8769.0,       3.63000324,     949.17560897  ),
    new VsopSet(             8246.0,       3.58227962,    206.185548437  ),
    new VsopSet(             7368.0,       5.08101126,    735.876513532  ),
    new VsopSet(             6263.0,      0.024976437,    213.299095438  ),
    new VsopSet(             6114.0,       4.51319532,   1162.474704408  ),
    new VsopSet(             5305.0,       4.18625054,   1052.268383188  ),
    new VsopSet(             5305.0,       1.30671237,     14.227094002  ),
    new VsopSet(             4905.0,       1.32084632,    110.206321219  ),
    new VsopSet(             4647.0,        4.6995811,       3.93215326  ),
    new VsopSet(             3045.0,        4.3167596,    426.598190876  ),
    new VsopSet(             2610.0,       1.56667595,    846.082834751  ),
    new VsopSet(             2028.0,       1.06376547,       3.18139374  ),
    new VsopSet(             1921.0,      0.971689288,    639.897286314  ),
    new VsopSet(             1765.0,       2.14148078,    1066.49547719  ),
    new VsopSet(             1723.0,       3.88036009,   1265.567478626  ),
    new VsopSet(             1633.0,        3.5820109,    515.463871093  ),
    new VsopSet(             1432.0,        4.2968369,    625.670192312  ),
    new VsopSet(              973.0,       4.09764957,     95.979227218  ),
    new VsopSet(              884.0,       2.43701426,    412.371096874  ),
    new VsopSet(              733.0,       6.08534113,     838.96928775  ),
    new VsopSet(              731.0,       3.80591234,   1581.959348283  ),
    new VsopSet(              709.0,       1.29272574,    742.990060533  ),
    new VsopSet(              692.0,       6.13368223,   2118.763860378  ),
    new VsopSet(              614.0,       4.10853497,   1478.866574064  ),
    new VsopSet(              582.0,       4.53967718,    309.278322656  ),
    new VsopSet(              495.0,       3.75567461,    323.505416657  ),
    new VsopSet(              441.0,       2.95818461,    454.909366527  ),
    new VsopSet(              417.0,        1.0355443,       2.44768055  ),
    new VsopSet(              390.0,       4.89716106,   1692.165669502  ),
    new VsopSet(              376.0,       4.70299125,   1368.660252845  ),
    new VsopSet(              341.0,       5.71452526,    533.623118358  ),
    new VsopSet(              330.0,       4.74049819,       0.04818411  ),
    new VsopSet(              262.0,       1.87652461,      0.963207847  ),
    new VsopSet(              261.0,      0.820472464,     380.12776796  ),
    new VsopSet(              257.0,       3.72410724,    199.072001436  ),
    new VsopSet(              244.0,       5.22020879,    728.762966531  ),
    new VsopSet(              235.0,       1.22693908,    909.818733055  ),
    new VsopSet(              220.0,       1.65115016,    543.918059096  ),
    new VsopSet(              207.0,       1.85461667,    525.758811832  ),
    new VsopSet(              202.0,       1.80684574,   1375.773799846  ),
    new VsopSet(              197.0,       5.29252149,   1155.361157407  ),
    new VsopSet(              175.0,       3.72966555,    942.062061969  ),
    new VsopSet(              175.0,       3.22634903,    1898.35121794  ),
    new VsopSet(              175.0,       5.90973505,    956.289155971  ),
    new VsopSet(              158.0,       4.36483922,   1795.258443721  ),
    new VsopSet(              151.0,       3.90625023,     74.781598567  ),
    new VsopSet(              149.0,       4.37745104,   1685.052122502  ),
    new VsopSet(              141.0,       3.13568358,    491.557929457  ),
    new VsopSet(              138.0,       1.31797921,   1169.588251409  ),
    new VsopSet(              131.0,       4.16867946,   1045.154836188  ),
    new VsopSet(              117.0,       2.50022141,   1596.186442285  ),
    new VsopSet(              117.0,       3.38920921,      0.521264862  ),
    new VsopSet(              106.0,       4.55439798,    526.509571357  )
};

static final VsopSet JupiterLonTerms1[] = {
    new VsopSet(      52993480757.0,                0.0,                0.0  ),
    new VsopSet(           489741.0,        4.2206669,    529.690965095  ),
    new VsopSet(           228919.0,       6.02647464,         7.113547  ),
    new VsopSet(            27655.0,       4.57265957,   1059.381930189  ),
    new VsopSet(            20721.0,       5.45938936,    522.577418094  ),
    new VsopSet(            12106.0,       0.16985765,    536.804512095  ),
    new VsopSet(             6068.0,       4.42419502,    103.092774219  ),
    new VsopSet(             5434.0,       3.98478383,    419.484643875  ),
    new VsopSet(             4238.0,       5.89009351,     14.227094002  ),
    new VsopSet(             2212.0,       5.26771447,    206.185548437  ),
    new VsopSet(             1746.0,       4.92669379,   1589.072895284  ),
    new VsopSet(             1296.0,       5.55132765,       3.18139374  ),
    new VsopSet(             1173.0,       5.85647304,   1052.268383188  ),
    new VsopSet(             1163.0,      0.514508953,       3.93215326  ),
    new VsopSet(             1099.0,       5.30704982,    515.463871093  ),
    new VsopSet(             1007.0,      0.464783986,    735.876513532  ),
    new VsopSet(             1004.0,       3.15040302,    426.598190876  ),
    new VsopSet(              848.0,       5.75805851,    110.206321219  ),
    new VsopSet(              827.0,       4.80312016,    213.299095438  ),
    new VsopSet(              816.0,      0.586430549,    1066.49547719  ),
    new VsopSet(              725.0,       5.51827472,    639.897286314  ),
    new VsopSet(              568.0,        5.9886705,    625.670192312  ),
    new VsopSet(              474.0,       4.13245269,    412.371096874  ),
    new VsopSet(              413.0,       5.73652891,     95.979227218  ),
    new VsopSet(              345.0,       4.24159565,    632.783739313  ),
    new VsopSet(              336.0,       3.73248749,   1162.474704408  ),
    new VsopSet(              234.0,        4.0346997,     949.17560897  ),
    new VsopSet(              234.0,       6.24302227,    309.278322656  ),
    new VsopSet(              199.0,       1.50458443,     838.96928775  ),
    new VsopSet(              195.0,       2.21879011,    323.505416657  ),
    new VsopSet(              187.0,       6.08620566,    742.990060533  ),
    new VsopSet(              184.0,       6.27963589,    543.918059096  ),
    new VsopSet(              171.0,       5.41655984,    199.072001436  ),
    new VsopSet(              131.0,      0.626433774,    728.762966531  ),
    new VsopSet(              115.0,      0.680190502,    846.082834751  ),
    new VsopSet(              115.0,       5.28641699,   2118.763860378  ),
    new VsopSet(              108.0,        4.4928276,    956.289155971  ),
    new VsopSet(               80.0,         5.824124,   1045.154836188  ),
    new VsopSet(               72.0,        5.3416265,    942.062061969  ),
    new VsopSet(               70.0,        5.9726345,    532.872358832  ),
    new VsopSet(               67.0,       5.73365126,     21.340641002  ),
    new VsopSet(               66.0,      0.129241914,    526.509571357  ),
    new VsopSet(               65.0,        6.0880349,   1581.959348283  ),
    new VsopSet(               59.0,       0.58626971,   1155.361157407  ),
    new VsopSet(               58.0,      0.994530873,   1596.186442285  ),
    new VsopSet(               57.0,       5.96851305,   1169.588251409  ),
    new VsopSet(               57.0,       1.41198439,    533.623118358  ),
    new VsopSet(               55.0,       5.42806384,     10.294940739  ),
    new VsopSet(               52.0,       5.72661448,     117.31986822  ),
    new VsopSet(               52.0,      0.229812991,   1368.660252845  ),
    new VsopSet(               50.0,       6.08075148,    525.758811832  ),
    new VsopSet(               47.0,       3.62611843,   1478.866574064  ),
    new VsopSet(               47.0,      0.511440732,   1265.567478626  ),
    new VsopSet(               40.0,       4.16158014,   1692.165669502  ),
    new VsopSet(               34.0,      0.099139049,    302.164775655  ),
    new VsopSet(               33.0,       5.03596689,    220.412642439  ),
    new VsopSet(               32.0,       5.37492531,    508.350324092  ),
    new VsopSet(               29.0,       5.42208897,   1272.681025627  ),
    new VsopSet(               29.0,       3.35927242,       4.66586645  ),
    new VsopSet(               29.0,      0.759079097,     88.865680217  ),
    new VsopSet(               25.0,       1.60723063,     831.85574075  )
};

static final VsopSet JupiterLonTerms2[] = {
    new VsopSet(            47234.0,       4.32148324,         7.113547  ),
    new VsopSet(            38966.0,                0.0,                0.0  ),
    new VsopSet(            30629.0,        2.9302144,    529.690965095  ),
    new VsopSet(             3189.0,       1.05504616,    522.577418094  ),
    new VsopSet(             2729.0,       4.84545481,    536.804512095  ),
    new VsopSet(             2723.0,       3.41411527,   1059.381930189  ),
    new VsopSet(             1721.0,       4.18734385,     14.227094002  ),
    new VsopSet(              383.0,       5.76790714,    419.484643875  ),
    new VsopSet(              378.0,      0.760489649,    515.463871093  ),
    new VsopSet(              367.0,        6.0550912,    103.092774219  ),
    new VsopSet(              337.0,       3.78644384,       3.18139374  ),
    new VsopSet(              308.0,      0.693566541,    206.185548437  ),
    new VsopSet(              218.0,       3.81389191,   1589.072895284  ),
    new VsopSet(              199.0,       5.33996443,    1066.49547719  ),
    new VsopSet(              197.0,       2.48356402,       3.93215326  ),
    new VsopSet(              156.0,       1.40642427,   1052.268383188  ),
    new VsopSet(              146.0,       3.81373197,    639.897286314  ),
    new VsopSet(              142.0,       1.63435169,    426.598190876  ),
    new VsopSet(              130.0,       5.83738873,    412.371096874  ),
    new VsopSet(              117.0,       1.41435463,    625.670192312  ),
    new VsopSet(               97.0,       4.03383428,    110.206321219  ),
    new VsopSet(               91.0,       1.10630629,     95.979227218  ),
    new VsopSet(               87.0,       2.52235175,    632.783739313  ),
    new VsopSet(               79.0,       4.63726131,    543.918059096  ),
    new VsopSet(               72.0,        2.2171667,    735.876513532  ),
    new VsopSet(               58.0,      0.832163174,    199.072001436  ),
    new VsopSet(               57.0,        3.1229206,    213.299095438  ),
    new VsopSet(               49.0,       1.67283792,    309.278322656  ),
    new VsopSet(               40.0,       4.02485445,     21.340641002  ),
    new VsopSet(               40.0,      0.624169458,    323.505416657  ),
    new VsopSet(               36.0,       2.32581247,    728.762966531  ),
    new VsopSet(               29.0,       3.60838328,     10.294940739  ),
    new VsopSet(               28.0,       3.23992014,     838.96928775  ),
    new VsopSet(               26.0,       4.50118298,    742.990060533  ),
    new VsopSet(               26.0,       2.51240624,   1162.474704408  ),
    new VsopSet(               25.0,       1.21868111,   1045.154836188  ),
    new VsopSet(               24.0,       3.00532139,    956.289155971  ),
    new VsopSet(               19.0,       4.29028645,    532.872358832  ),
    new VsopSet(               18.0,      0.809539416,    508.350324092  ),
    new VsopSet(               17.0,       4.20001978,   2118.763860378  ),
    new VsopSet(               17.0,       1.83402147,    526.509571357  ),
    new VsopSet(               15.0,       5.81037987,   1596.186442285  ),
    new VsopSet(               15.0,      0.681741655,    942.062061969  ),
    new VsopSet(               15.0,       3.99989623,     117.31986822  ),
    new VsopSet(               14.0,       5.95169568,    316.391869657  ),
    new VsopSet(               14.0,       1.80336678,    302.164775655  ),
    new VsopSet(               13.0,       2.51856644,     88.865680217  ),
    new VsopSet(               13.0,       4.36856232,   1169.588251409  ),
    new VsopSet(               11.0,       4.43586635,    525.758811832  ),
    new VsopSet(               10.0,       1.71563161,   1581.959348283  ),
    new VsopSet(                9.0,       2.17684563,   1155.361157407  ),
    new VsopSet(                9.0,       3.29452783,    220.412642439  ),
    new VsopSet(                9.0,       3.31924494,     831.85574075  ),
    new VsopSet(                8.0,       5.75672228,    846.082834751  ),
    new VsopSet(                8.0,       2.70955517,    533.623118358  ),
    new VsopSet(                7.0,       2.17560093,   1265.567478626  ),
    new VsopSet(                6.0,      0.499398635,     949.17560897  )
};

static final VsopSet JupiterLonTerms3[] = {
    new VsopSet(             6502.0,       2.59862881,         7.113547  ),
    new VsopSet(             1357.0,       1.34635886,    529.690965095  ),
    new VsopSet(              471.0,       2.47503978,     14.227094002  ),
    new VsopSet(              417.0,       3.24451243,    536.804512095  ),
    new VsopSet(              353.0,       2.97360159,    522.577418094  ),
    new VsopSet(              155.0,       2.07565586,   1059.381930189  ),
    new VsopSet(               87.0,       2.51431584,    515.463871093  ),
    new VsopSet(               44.0,                0.0,                0.0  ),
    new VsopSet(               34.0,       3.82633795,    1066.49547719  ),
    new VsopSet(               28.0,       2.44754756,    206.185548437  ),
    new VsopSet(               24.0,       1.27667172,    412.371096874  ),
    new VsopSet(               23.0,       2.98231327,    543.918059096  ),
    new VsopSet(               20.0,       2.10099934,    639.897286314  ),
    new VsopSet(               20.0,       1.40255939,    419.484643875  ),
    new VsopSet(               19.0,       1.59368404,    103.092774219  ),
    new VsopSet(               17.0,       2.30214681,     21.340641002  ),
    new VsopSet(               17.0,       2.59821461,   1589.072895284  ),
    new VsopSet(               16.0,       3.14521117,    625.670192312  ),
    new VsopSet(               16.0,       3.36030126,   1052.268383188  ),
    new VsopSet(               13.0,       2.75973892,     95.979227218  ),
    new VsopSet(               13.0,       2.53862244,    199.072001436  ),
    new VsopSet(               13.0,        6.2657811,    426.598190876  ),
    new VsopSet(                9.0,       1.76334961,     10.294940739  ),
    new VsopSet(                9.0,       2.26563256,    110.206321219  ),
    new VsopSet(                7.0,       3.42566433,    309.278322656  ),
    new VsopSet(                7.0,       4.03869563,    728.762966531  ),
    new VsopSet(                6.0,       2.52096418,    508.350324092  ),
    new VsopSet(                5.0,       2.91184687,   1045.154836188  ),
    new VsopSet(                5.0,       5.25196154,    323.505416657  ),
    new VsopSet(                4.0,       4.30290261,     88.865680217  ),
    new VsopSet(                4.0,       3.52381362,    302.164775655  ),
    new VsopSet(                4.0,       4.09125315,    735.876513532  ),
    new VsopSet(                3.0,       1.43175991,    956.289155971  ),
    new VsopSet(                3.0,       4.35817508,   1596.186442285  ),
    new VsopSet(                3.0,       1.25276591,    213.299095438  ),
    new VsopSet(                3.0,        5.0150584,     838.96928775  ),
    new VsopSet(                3.0,       2.23785673,     117.31986822  ),
    new VsopSet(                2.0,       2.89662409,    742.990060533  ),
    new VsopSet(                2.0,       2.35581871,    942.062061969  )
};

static final VsopSet JupiterLonTerms4[] = {
    new VsopSet(              669.0,      0.852824211,         7.113547  ),
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(              100.0,      0.742589478,     14.227094002  ),
    new VsopSet(               50.0,       1.65346208,    536.804512095  ),
    new VsopSet(               44.0,       5.82026387,    529.690965095  ),
    new VsopSet(               32.0,       4.85829987,    522.577418094  ),
    new VsopSet(               15.0,       4.29061636,    515.463871093  ),
    new VsopSet(                9.0,      0.714785207,   1059.381930189  ),
    new VsopSet(                5.0,       1.29502259,    543.918059096  ),
    new VsopSet(                4.0,       2.31715517,    1066.49547719  ),
    new VsopSet(                4.0,      0.483267975,     21.340641002  ),
    new VsopSet(                3.0,       3.00245543,    412.371096874  ),
    new VsopSet(                2.0,      0.398589402,    639.897286314  ),
    new VsopSet(                2.0,        4.2592562,    199.072001436  ),
    new VsopSet(                2.0,       4.90536207,    625.670192312  ),
    new VsopSet(                2.0,       4.26147581,    206.185548437  ),
    new VsopSet(                1.0,       5.25546956,   1052.268383188  ),
    new VsopSet(                1.0,       4.71614634,     95.979227218  ),
    new VsopSet(                1.0,       1.28604571,   1589.072895284  )
};

static final VsopSet JupiterLonTerms5[] = {
    new VsopSet(               50.0,       5.25658966,         7.113547  ),
    new VsopSet(               16.0,       5.25126838,     14.227094002  ),
    new VsopSet(                4.0,      0.014618693,    536.804512095  ),
    new VsopSet(                2.0,       1.09739911,    522.577418094  ),
    new VsopSet(                1.0,       3.14159265,                0.0  )
};

static final VsopSet JupiterLatTerms0[] = {
    new VsopSet(          2268616.0,       3.55852607,    529.690965095  ),
    new VsopSet(           110090.0,                0.0,                0.0  ),
    new VsopSet(           109972.0,       3.90809347,   1059.381930189  ),
    new VsopSet(             8101.0,       3.60509573,    522.577418094  ),
    new VsopSet(             6438.0,      0.306271214,    536.804512095  ),
    new VsopSet(             6044.0,       4.25883109,   1589.072895284  ),
    new VsopSet(             1107.0,       2.98534422,   1162.474704408  ),
    new VsopSet(              944.0,       1.67522288,    426.598190876  ),
    new VsopSet(              942.0,       2.93619072,   1052.268383188  ),
    new VsopSet(              894.0,        1.7544743,         7.113547  ),
    new VsopSet(              836.0,       5.17881973,    103.092774219  ),
    new VsopSet(              767.0,       2.15473594,    632.783739313  ),
    new VsopSet(              684.0,        3.6780877,    213.299095438  ),
    new VsopSet(              629.0,      0.643432823,    1066.49547719  ),
    new VsopSet(              559.0,      0.013548305,    846.082834751  ),
    new VsopSet(              532.0,       2.70305954,    110.206321219  ),
    new VsopSet(              464.0,       1.17337249,     949.17560897  ),
    new VsopSet(              431.0,          2.60825,    419.484643875  ),
    new VsopSet(              351.0,       4.61062991,   2118.763860378  ),
    new VsopSet(              132.0,       4.77816991,    742.990060533  ),
    new VsopSet(              123.0,       3.34968181,   1692.165669502  ),
    new VsopSet(              116.0,       1.38688232,    323.505416657  ),
    new VsopSet(              115.0,       5.04892295,    316.391869657  ),
    new VsopSet(              104.0,       3.70103838,    515.463871093  ),
    new VsopSet(              103.0,          2.31879,   1478.866574064  ),
    new VsopSet(              102.0,       3.15293785,   1581.959348283  )
};

static final VsopSet JupiterLatTerms1[] = {
    new VsopSet(           177352.0,       5.70166488,    529.690965095  ),
    new VsopSet(             3230.0,       5.77941619,   1059.381930189  ),
    new VsopSet(             3081.0,       5.47464297,    522.577418094  ),
    new VsopSet(             2212.0,        4.7347748,    536.804512095  ),
    new VsopSet(             1694.0,       3.14159265,                0.0  ),
    new VsopSet(              346.0,       4.74595174,   1052.268383188  ),
    new VsopSet(              234.0,         5.188561,    1066.49547719  ),
    new VsopSet(              196.0,       6.18554287,         7.113547  ),
    new VsopSet(              150.0,       3.92721226,   1589.072895284  ),
    new VsopSet(              114.0,       3.43897272,    632.783739313  ),
    new VsopSet(               97.0,       2.91426304,     949.17560897  ),
    new VsopSet(               82.0,       5.07666098,   1162.474704408  ),
    new VsopSet(               77.0,       2.50522189,    103.092774219  ),
    new VsopSet(               77.0,      0.612889814,    419.484643875  ),
    new VsopSet(               74.0,       5.49958292,    515.463871093  ),
    new VsopSet(               61.0,       5.44740084,    213.299095438  ),
    new VsopSet(               50.0,       3.94799617,    735.876513532  ),
    new VsopSet(               46.0,      0.538503609,    110.206321219  ),
    new VsopSet(               45.0,       1.89516645,    846.082834751  ),
    new VsopSet(               37.0,       4.69828393,    543.918059096  ),
    new VsopSet(               36.0,       6.10952579,    316.391869657  ),
    new VsopSet(               32.0,       4.92452715,   1581.959348283  )
};

static final VsopSet JupiterLatTerms2[] = {
    new VsopSet(             8094.0,       1.46322844,    529.690965095  ),
    new VsopSet(              813.0,       3.14159265,                0.0  ),
    new VsopSet(              742.0,       0.95691639,    522.577418094  ),
    new VsopSet(              399.0,       2.89888666,    536.804512095  ),
    new VsopSet(              342.0,        1.4468379,   1059.381930189  ),
    new VsopSet(               74.0,      0.407246759,   1052.268383188  ),
    new VsopSet(               46.0,       3.48036896,    1066.49547719  ),
    new VsopSet(               30.0,       1.92504171,   1589.072895284  ),
    new VsopSet(               29.0,      0.990888318,    515.463871093  ),
    new VsopSet(               23.0,       4.27124052,         7.113547  ),
    new VsopSet(               14.0,       2.92242387,    543.918059096  ),
    new VsopSet(               12.0,       5.22168932,    632.783739313  ),
    new VsopSet(               11.0,       4.88024222,     949.17560897  ),
    new VsopSet(                6.0,       6.21089108,   1045.154836188  )
};

static final VsopSet JupiterLatTerms3[] = {
    new VsopSet(              252.0,       3.38087923,    529.690965095  ),
    new VsopSet(              122.0,       2.73311837,    522.577418094  ),
    new VsopSet(               49.0,       1.03689997,    536.804512095  ),
    new VsopSet(               11.0,       2.31463561,   1052.268383188  ),
    new VsopSet(                8.0,       2.76729758,    515.463871093  ),
    new VsopSet(                7.0,       4.25268319,   1059.381930189  ),
    new VsopSet(                6.0,       1.78115827,    1066.49547719  ),
    new VsopSet(                4.0,       1.13028917,    543.918059096  ),
    new VsopSet(                3.0,       3.14159265,                0.0  )
};

static final VsopSet JupiterLatTerms4[] = {
    new VsopSet(               15.0,          4.52957,    522.577418094  ),
    new VsopSet(                5.0,       4.47427159,    529.690965095  ),
    new VsopSet(                4.0,       5.43908581,    536.804512095  ),
    new VsopSet(                3.0,                0.0,                0.0  ),
    new VsopSet(                2.0,       4.51807036,    515.463871093  ),
    new VsopSet(                1.0,       4.20117612,   1052.268383188  )
};

static final VsopSet JupiterLatTerms5[] = {
    new VsopSet(                1.0,      0.091985541,    522.577418094  )
};

static final VsopSet JupiterRadTerms0[] = {
    new VsopSet(        520887429.0,                0.0,                0.0  ),
    new VsopSet(         25209327.0,        3.4910864,    529.690965095  ),
    new VsopSet(           610600.0,       3.84115366,   1059.381930189  ),
    new VsopSet(           282029.0,        2.5741988,    632.783739313  ),
    new VsopSet(           187647.0,        2.0759038,    522.577418094  ),
    new VsopSet(            86793.0,      0.710010906,    419.484643875  ),
    new VsopSet(            72063.0,      0.214656947,    536.804512095  ),
    new VsopSet(            65517.0,       5.97995851,    316.391869657  ),
    new VsopSet(            30135.0,       2.16132058,     949.17560897  ),
    new VsopSet(            29135.0,       1.67759244,    103.092774219  ),
    new VsopSet(            23947.0,      0.274578549,         7.113547  ),
    new VsopSet(            23453.0,       3.54023147,    735.876513532  ),
    new VsopSet(            22284.0,       4.19362773,   1589.072895284  ),
    new VsopSet(            13033.0,       2.96043056,   1162.474704408  ),
    new VsopSet(            12749.0,       2.71550103,   1052.268383188  ),
    new VsopSet(             9703.0,       1.90669572,    206.185548437  ),
    new VsopSet(             9161.0,       4.41352619,    213.299095438  ),
    new VsopSet(             7895.0,       2.47907551,    426.598190876  ),
    new VsopSet(             7058.0,       2.18184753,   1265.567478626  ),
    new VsopSet(             6138.0,       6.26417543,    846.082834751  ),
    new VsopSet(             5477.0,       5.65729325,    639.897286314  ),
    new VsopSet(             4170.0,       2.01605034,    515.463871093  ),
    new VsopSet(             4137.0,        2.7221998,    625.670192312  ),
    new VsopSet(             3503.0,      0.565312974,    1066.49547719  ),
    new VsopSet(             2617.0,       2.00993967,   1581.959348283  ),
    new VsopSet(             2500.0,       4.55182056,     838.96928775  ),
    new VsopSet(             2128.0,       6.12751462,    742.990060533  ),
    new VsopSet(             1912.0,      0.856219274,    412.371096874  ),
    new VsopSet(             1611.0,       3.08867789,   1368.660252845  ),
    new VsopSet(             1479.0,       2.68026191,   1478.866574064  ),
    new VsopSet(             1231.0,        1.8904298,    323.505416657  ),
    new VsopSet(             1217.0,       1.80171561,    110.206321219  ),
    new VsopSet(             1015.0,       1.38673238,    454.909366527  ),
    new VsopSet(              999.0,        2.8720894,    309.278322656  ),
    new VsopSet(              961.0,        4.5487699,   2118.763860378  ),
    new VsopSet(              886.0,       4.14785948,    533.623118358  ),
    new VsopSet(              821.0,       1.59342534,    1898.35121794  ),
    new VsopSet(              812.0,       5.94091899,    909.818733055  ),
    new VsopSet(              777.0,       3.67696955,    728.762966531  ),
    new VsopSet(              727.0,       3.98824686,   1155.361157407  ),
    new VsopSet(              655.0,       2.79065604,   1685.052122502  ),
    new VsopSet(              654.0,       3.38150775,   1692.165669502  ),
    new VsopSet(              621.0,       4.82284339,    956.289155971  ),
    new VsopSet(              615.0,       2.27624916,    942.062061969  ),
    new VsopSet(              562.0,      0.080959872,    543.918059096  ),
    new VsopSet(              542.0,      0.283602664,    525.758811832  )
};

static final VsopSet JupiterRadTerms1[] = {
    new VsopSet(          1271802.0,       2.64937511,    529.690965095  ),
    new VsopSet(            61662.0,       3.00076251,   1059.381930189  ),
    new VsopSet(            53444.0,       3.89717644,    522.577418094  ),
    new VsopSet(            41390.0,                0.0,                0.0  ),
    new VsopSet(            31185.0,       4.88276664,    536.804512095  ),
    new VsopSet(            11847.0,       2.41329588,    419.484643875  ),
    new VsopSet(             9166.0,       4.75979409,         7.113547  ),
    new VsopSet(             3404.0,       3.34688538,   1589.072895284  ),
    new VsopSet(             3203.0,       5.21083285,    735.876513532  ),
    new VsopSet(             3176.0,       2.79297987,    103.092774219  ),
    new VsopSet(             2806.0,       3.74223694,    515.463871093  ),
    new VsopSet(             2677.0,       4.33052879,   1052.268383188  ),
    new VsopSet(             2600.0,       3.63435102,    206.185548437  ),
    new VsopSet(             2412.0,       1.46947308,    426.598190876  ),
    new VsopSet(             2101.0,       3.92762682,    639.897286314  ),
    new VsopSet(             1646.0,       5.30953511,    1066.49547719  ),
    new VsopSet(             1641.0,        4.4162867,    625.670192312  ),
    new VsopSet(             1050.0,       3.16113623,    213.299095438  ),
    new VsopSet(             1025.0,       2.55432643,    412.371096874  ),
    new VsopSet(              806.0,       2.67750801,    632.783739313  ),
    new VsopSet(              741.0,       2.17094631,   1162.474704408  ),
    new VsopSet(              677.0,        6.2495348,     838.96928775  ),
    new VsopSet(              567.0,       4.57655415,    742.990060533  ),
    new VsopSet(              485.0,       2.46882793,     949.17560897  ),
    new VsopSet(              469.0,       4.70973464,    543.918059096  ),
    new VsopSet(              445.0,      0.402811814,    323.505416657  ),
    new VsopSet(              416.0,       5.36836018,    728.762966531  ),
    new VsopSet(              402.0,       4.60528842,    309.278322656  ),
    new VsopSet(              347.0,       4.68148809,     14.227094002  ),
    new VsopSet(              338.0,       3.16781951,    956.289155971  ),
    new VsopSet(              261.0,       5.34290306,    846.082834751  ),
    new VsopSet(              247.0,       3.92313824,    942.062061969  ),
    new VsopSet(              220.0,       4.84210965,   1368.660252845  ),
    new VsopSet(              203.0,       5.59995425,   1155.361157407  ),
    new VsopSet(              200.0,       4.43888814,   1045.154836188  ),
    new VsopSet(              197.0,       3.70551461,   2118.763860378  ),
    new VsopSet(              196.0,       3.75877587,    199.072001436  ),
    new VsopSet(              184.0,        4.2652677,     95.979227218  ),
    new VsopSet(              180.0,       4.40165491,    532.872358832  ),
    new VsopSet(              170.0,       4.84647489,    526.509571357  ),
    new VsopSet(              146.0,       6.12958366,    533.623118358  ),
    new VsopSet(              133.0,       1.32245736,    110.206321219  ),
    new VsopSet(              132.0,       4.51187951,    525.758811832  )
};

static final VsopSet JupiterRadTerms2[] = {
    new VsopSet(            79645.0,       1.35865897,    529.690965095  ),
    new VsopSet(             8252.0,       5.77773935,    522.577418094  ),
    new VsopSet(             7030.0,       3.27476966,    536.804512095  ),
    new VsopSet(             5314.0,        1.8383511,   1059.381930189  ),
    new VsopSet(             1861.0,       2.97682139,         7.113547  ),
    new VsopSet(              964.0,       5.48031822,    515.463871093  ),
    new VsopSet(              836.0,       4.19889882,    419.484643875  ),
    new VsopSet(              498.0,       3.14159265,                0.0  ),
    new VsopSet(              427.0,       2.22753102,    639.897286314  ),
    new VsopSet(              406.0,        3.7825073,    1066.49547719  ),
    new VsopSet(              377.0,       2.24248353,   1589.072895284  ),
    new VsopSet(              363.0,       5.36761847,    206.185548437  ),
    new VsopSet(              342.0,       6.09922969,   1052.268383188  ),
    new VsopSet(              339.0,       6.12690864,    625.670192312  ),
    new VsopSet(              333.0,      0.003289612,    426.598190876  ),
    new VsopSet(              280.0,       4.26162556,    412.371096874  ),
    new VsopSet(              257.0,       0.96295365,    632.783739313  ),
    new VsopSet(              230.0,      0.705307662,    735.876513532  ),
    new VsopSet(              201.0,       3.06850623,    543.918059096  ),
    new VsopSet(              200.0,       4.42884165,    103.092774219  ),
    new VsopSet(              139.0,       2.93235672,     14.227094002  ),
    new VsopSet(              114.0,      0.787139113,    728.762966531  ),
    new VsopSet(               95.0,       1.70498041,     838.96928775  ),
    new VsopSet(               86.0,       5.14434752,    323.505416657  ),
    new VsopSet(               83.0,      0.058348735,    309.278322656  ),
    new VsopSet(               80.0,       2.98122362,    742.990060533  ),
    new VsopSet(               75.0,       1.60495196,    956.289155971  ),
    new VsopSet(               70.0,       1.50988357,    213.299095438  ),
    new VsopSet(               67.0,       5.47307178,    199.072001436  ),
    new VsopSet(               62.0,        6.1013789,   1045.154836188  ),
    new VsopSet(               56.0,      0.955348105,   1162.474704408  ),
    new VsopSet(               52.0,       5.58435626,    942.062061969  ),
    new VsopSet(               50.0,       2.72063162,    532.872358832  ),
    new VsopSet(               45.0,       5.52445621,    508.350324092  ),
    new VsopSet(               44.0,      0.271181526,    526.509571357  ),
    new VsopSet(               40.0,       5.94566506,     95.979227218  )
};

static final VsopSet JupiterRadTerms3[] = {
    new VsopSet(             3519.0,       6.05800634,    529.690965095  ),
    new VsopSet(             1073.0,       1.67321346,    536.804512095  ),
    new VsopSet(              916.0,       1.41329676,    522.577418094  ),
    new VsopSet(              342.0,      0.522965427,   1059.381930189  ),
    new VsopSet(              255.0,       1.19625473,         7.113547  ),
    new VsopSet(              222.0,      0.952252262,    515.463871093  ),
    new VsopSet(               90.0,       3.14159265,                0.0  ),
    new VsopSet(               69.0,       2.26885282,    1066.49547719  ),
    new VsopSet(               58.0,       1.41389745,    543.918059096  ),
    new VsopSet(               58.0,      0.525801176,    639.897286314  ),
    new VsopSet(               51.0,       5.98016365,    412.371096874  ),
    new VsopSet(               47.0,       1.57864238,    625.670192312  ),
    new VsopSet(               43.0,       6.11689609,    419.484643875  ),
    new VsopSet(               37.0,       1.18262762,     14.227094002  ),
    new VsopSet(               34.0,       1.66671707,   1052.268383188  ),
    new VsopSet(               34.0,      0.847849779,    206.185548437  ),
    new VsopSet(               31.0,       1.04290246,   1589.072895284  ),
    new VsopSet(               30.0,       4.63236245,    426.598190876  ),
    new VsopSet(               21.0,       2.50071244,    728.762966531  ),
    new VsopSet(               15.0,      0.891369984,    199.072001436  ),
    new VsopSet(               14.0,      0.960401971,    508.350324092  ),
    new VsopSet(               13.0,       1.50233789,   1045.154836188  ),
    new VsopSet(               12.0,       2.60952614,    735.876513532  ),
    new VsopSet(               12.0,        3.5551351,    323.505416657  ),
    new VsopSet(               11.0,       1.79041438,    309.278322656  ),
    new VsopSet(               11.0,       6.27845113,    956.289155971  ),
    new VsopSet(               10.0,       6.26016859,    103.092774219  ),
    new VsopSet(                9.0,       3.45126812,     838.96928775  )
};

static final VsopSet JupiterRadTerms4[] = {
    new VsopSet(              129.0,      0.084193096,    536.804512095  ),
    new VsopSet(              113.0,       4.24858856,    529.690965095  ),
    new VsopSet(               83.0,       3.29754909,    522.577418094  ),
    new VsopSet(               38.0,       2.73326611,    515.463871093  ),
    new VsopSet(               27.0,       5.69142589,         7.113547  ),
    new VsopSet(               18.0,       5.40012537,   1059.381930189  ),
    new VsopSet(               13.0,       6.01560416,    543.918059096  ),
    new VsopSet(                9.0,      0.768139465,    1066.49547719  ),
    new VsopSet(                8.0,       5.68228066,     14.227094002  ),
    new VsopSet(                7.0,       1.42751292,    412.371096874  ),
    new VsopSet(                6.0,       5.12286932,    639.897286314  ),
    new VsopSet(                5.0,       3.33501947,    625.670192312  ),
    new VsopSet(                3.0,       3.40334805,   1052.268383188  ),
    new VsopSet(                3.0,       4.16090413,    728.762966531  ),
    new VsopSet(                3.0,       2.89802035,    426.598190876  )
};

static final VsopSet JupiterRadTerms5[] = {
    new VsopSet(               11.0,         4.752494,    536.804512095  ),
    new VsopSet(                4.0,       5.91516229,    522.577418094  ),
    new VsopSet(                2.0,       5.56781556,    515.463871093  ),
    new VsopSet(                2.0,       4.29659647,    543.918059096  ),
    new VsopSet(                2.0,       3.69357496,         7.113547  ),
    new VsopSet(                2.0,       4.13222809,   1059.381930189  ),
    new VsopSet(                2.0,       5.49312796,    1066.49547719  )
};

// Jupiter TermTable
static final VsopTerms[] JupiterLonTerms = {
  new VsopTerms( JupiterLonTerms0Rows, JupiterLonTerms0 ),
  new VsopTerms( JupiterLonTerms1Rows, JupiterLonTerms1 ),
  new VsopTerms( JupiterLonTerms2Rows, JupiterLonTerms2 ),
  new VsopTerms( JupiterLonTerms3Rows, JupiterLonTerms3 ),
  new VsopTerms( JupiterLonTerms4Rows, JupiterLonTerms4 ),
  new VsopTerms( JupiterLonTerms5Rows, JupiterLonTerms5 )
};

static final VsopTerms[] JupiterLatTerms = {
  new VsopTerms( JupiterLatTerms0Rows, JupiterLatTerms0 ),
  new VsopTerms( JupiterLatTerms1Rows, JupiterLatTerms1 ),
  new VsopTerms( JupiterLatTerms2Rows, JupiterLatTerms2 ),
  new VsopTerms( JupiterLatTerms3Rows, JupiterLatTerms3 ),
  new VsopTerms( JupiterLatTerms4Rows, JupiterLatTerms4 ),
  new VsopTerms( JupiterLatTerms5Rows, JupiterLatTerms5 )
};

static final VsopTerms[] JupiterRadTerms = {
  new VsopTerms( JupiterRadTerms0Rows, JupiterRadTerms0 ),
  new VsopTerms( JupiterRadTerms1Rows, JupiterRadTerms1 ),
  new VsopTerms( JupiterRadTerms2Rows, JupiterRadTerms2 ),
  new VsopTerms( JupiterRadTerms3Rows, JupiterRadTerms3 ),
  new VsopTerms( JupiterRadTerms4Rows, JupiterRadTerms4 ),
  new VsopTerms( JupiterRadTerms5Rows, JupiterRadTerms5 )
};

// Saturn Terms
static final int SaturnLonTerms0Rows = 90;
static final int SaturnLonTerms1Rows = 79;
static final int SaturnLonTerms2Rows = 63;
static final int SaturnLonTerms3Rows = 48;
static final int SaturnLonTerms4Rows = 27;
static final int SaturnLonTerms5Rows = 12;

static final int SaturnLatTerms0Rows = 34;
static final int SaturnLatTerms1Rows = 32;
static final int SaturnLatTerms2Rows = 29;
static final int SaturnLatTerms3Rows = 21;
static final int SaturnLatTerms4Rows = 12;
static final int SaturnLatTerms5Rows = 2;

static final int SaturnRadTerms0Rows = 44;
static final int SaturnRadTerms1Rows = 38;
static final int SaturnRadTerms2Rows = 32;
static final int SaturnRadTerms3Rows = 28;
static final int SaturnRadTerms4Rows = 23;
static final int SaturnRadTerms5Rows = 18;

static final VsopSet SaturnLonTerms0[] = {
    new VsopSet(         87401354.0,                0.0,                0.0  ),
    new VsopSet(         11107660.0,        3.9620509,    213.299095438  ),
    new VsopSet(          1414151.0,       4.58581516,         7.113547  ),
    new VsopSet(           398379.0,       0.52112026,    206.185548437  ),
    new VsopSet(           350769.0,       3.30329903,    426.598190876  ),
    new VsopSet(           206816.0,      0.246583669,    103.092774219  ),
    new VsopSet(            79271.0,       3.84007079,    220.412642439  ),
    new VsopSet(            23990.0,       4.66976935,    110.206321219  ),
    new VsopSet(            16574.0,      0.437191235,    419.484643875  ),
    new VsopSet(            15820.0,      0.938089538,    632.783739313  ),
    new VsopSet(            15054.0,       2.71670028,    639.897286314  ),
    new VsopSet(            14907.0,       5.76903284,    316.391869657  ),
    new VsopSet(            14610.0,       1.56518574,       3.93215326  ),
    new VsopSet(            13160.0,        4.4489118,     14.227094002  ),
    new VsopSet(            13005.0,       5.98119067,     11.045700264  ),
    new VsopSet(            10725.0,       3.12939597,    202.253395174  ),
    new VsopSet(             6126.0,         1.763285,    277.034993741  ),
    new VsopSet(             5863.0,      0.236570288,    529.690965095  ),
    new VsopSet(             5228.0,       4.20783162,       3.18139374  ),
    new VsopSet(             5020.0,        3.1778792,    433.711737877  ),
    new VsopSet(             4593.0,      0.619764244,    199.072001436  ),
    new VsopSet(             4006.0,       2.24479894,     63.735898303  ),
    new VsopSet(             3874.0,       3.22282693,    138.517496871  ),
    new VsopSet(             3269.0,      0.774918958,     949.17560897  ),
    new VsopSet(             2954.0,      0.982803852,     95.979227218  ),
    new VsopSet(             2461.0,       2.03163631,    735.876513532  ),
    new VsopSet(             1758.0,       3.26580515,    522.577418094  ),
    new VsopSet(             1640.0,       5.50504966,    846.082834751  ),
    new VsopSet(             1581.0,       4.37266314,    309.278322656  ),
    new VsopSet(             1391.0,       4.02331978,    323.505416657  ),
    new VsopSet(             1124.0,       2.83726794,    415.552490612  ),
    new VsopSet(             1087.0,       4.18343233,       2.44768055  ),
    new VsopSet(             1017.0,       3.71698152,     227.52618944  ),
    new VsopSet(              957.0,      0.507408899,   1265.567478626  ),
    new VsopSet(              853.0,       3.42141351,      175.1660598  ),
    new VsopSet(              849.0,       3.19149826,    209.366942175  ),
    new VsopSet(              789.0,       5.00745123,      0.963207847  ),
    new VsopSet(              749.0,       2.14398149,    853.196381752  ),
    new VsopSet(              744.0,       5.25276955,    224.344795702  ),
    new VsopSet(              687.0,       1.74714408,   1052.268383188  ),
    new VsopSet(              654.0,       1.59889332,       0.04818411  ),
    new VsopSet(              634.0,       2.29889903,    412.371096874  ),
    new VsopSet(              625.0,      0.970468313,      210.1177017  ),
    new VsopSet(              580.0,       3.09259007,     74.781598567  ),
    new VsopSet(              546.0,       2.12678554,      350.3321196  ),
    new VsopSet(              543.0,       1.51824321,       9.56122756  ),
    new VsopSet(              530.0,       4.44938897,     117.31986822  ),
    new VsopSet(              478.0,       2.96488054,    137.033024162  ),
    new VsopSet(              474.0,       5.47527186,    742.990060533  ),
    new VsopSet(              452.0,       1.04436664,    490.334089179  ),
    new VsopSet(              449.0,       1.28990416,    127.471796607  ),
    new VsopSet(              372.0,       2.27819109,    217.231248701  ),
    new VsopSet(              355.0,       3.01286483,     838.96928775  ),
    new VsopSet(              347.0,       1.53928228,    340.770892045  ),
    new VsopSet(              343.0,      0.246040391,      0.521264862  ),
    new VsopSet(              330.0,      0.247156178,   1581.959348283  ),
    new VsopSet(              322.0,      0.961374561,    203.737867882  ),
    new VsopSet(              322.0,       2.57182355,    647.010833315  ),
    new VsopSet(              309.0,       3.49486735,    216.480489176  ),
    new VsopSet(              287.0,       2.37043746,    351.816592309  ),
    new VsopSet(              278.0,      0.400204089,     211.81462273  ),
    new VsopSet(              249.0,       1.47010534,   1368.660252845  ),
    new VsopSet(              227.0,       4.91003163,     12.530172972  ),
    new VsopSet(              220.0,       4.20422425,    200.768922466  ),
    new VsopSet(              209.0,       1.34516255,    625.670192312  ),
    new VsopSet(              208.0,      0.483498205,   1162.474704408  ),
    new VsopSet(              208.0,       1.28302219,     39.356875915  ),
    new VsopSet(              205.0,       6.01082207,    265.989293478  ),
    new VsopSet(              185.0,       3.50344405,    149.563197135  ),
    new VsopSet(              184.0,      0.972549527,       4.19278569  ),
    new VsopSet(              182.0,       5.49122292,       2.92076131  ),
    new VsopSet(              174.0,       1.86305807,      0.750759525  ),
    new VsopSet(              165.0,      0.440055175,       5.41662597  ),
    new VsopSet(              149.0,        5.7359435,      52.69019804  ),
    new VsopSet(              148.0,       1.53529321,       5.62907429  ),
    new VsopSet(              146.0,       6.23102544,    195.139848173  ),
    new VsopSet(              140.0,        4.2945026,     21.340641002  ),
    new VsopSet(              131.0,       4.06828962,     10.294940739  ),
    new VsopSet(              125.0,       6.27737806,    1898.35121794  ),
    new VsopSet(              122.0,       1.97588777,       4.66586645  ),
    new VsopSet(              118.0,       5.34072934,    554.069987483  ),
    new VsopSet(              117.0,       2.67920401,   1155.361157407  ),
    new VsopSet(              114.0,       5.59427545,   1059.381930189  ),
    new VsopSet(              112.0,       1.10502664,     191.20769491  ),
    new VsopSet(              110.0,      0.166040241,       1.48447271  ),
    new VsopSet(              109.0,       3.43812716,    536.804512095  ),
    new VsopSet(              107.0,       4.01156609,    956.289155971  ),
    new VsopSet(              104.0,       2.19210363,     88.865680217  ),
    new VsopSet(              103.0,       1.19748124,   1685.052122502  ),
    new VsopSet(              101.0,       4.96513667,    269.921446741  )
};

static final VsopSet SaturnLonTerms1[] = {
    new VsopSet(      21354295596.0,                0.0,                0.0  ),
    new VsopSet(          1296855.0,       1.82820545,    213.299095438  ),
    new VsopSet(           564348.0,       2.88500136,         7.113547  ),
    new VsopSet(           107679.0,       2.27769912,    206.185548437  ),
    new VsopSet(            98323.0,       1.08070061,    426.598190876  ),
    new VsopSet(            40255.0,       2.04128257,    220.412642439  ),
    new VsopSet(            19942.0,       1.27954663,    103.092774219  ),
    new VsopSet(            10512.0,       2.74880393,     14.227094002  ),
    new VsopSet(             6939.0,        0.4049308,    639.897286314  ),
    new VsopSet(             4803.0,       2.44194098,    419.484643875  ),
    new VsopSet(             4056.0,       2.92166619,    110.206321219  ),
    new VsopSet(             3769.0,       3.64965632,       3.93215326  ),
    new VsopSet(             3385.0,       2.41694252,       3.18139374  ),
    new VsopSet(             3302.0,       1.26256487,    433.711737877  ),
    new VsopSet(             3071.0,       2.32739318,    199.072001436  ),
    new VsopSet(             1953.0,       3.56394683,     11.045700264  ),
    new VsopSet(             1249.0,       2.62803737,     95.979227218  ),
    new VsopSet(              922.0,       1.96089834,     227.52618944  ),
    new VsopSet(              706.0,       4.41689249,    529.690965095  ),
    new VsopSet(              650.0,       6.17418094,    202.253395174  ),
    new VsopSet(              628.0,       6.11088227,    309.278322656  ),
    new VsopSet(              487.0,         6.039982,    853.196381752  ),
    new VsopSet(              479.0,       4.98776988,    522.577418094  ),
    new VsopSet(              468.0,       4.61707844,     63.735898303  ),
    new VsopSet(              417.0,       2.11708169,    323.505416657  ),
    new VsopSet(              408.0,       1.29949557,    209.366942175  ),
    new VsopSet(              352.0,       2.31707079,    632.783739313  ),
    new VsopSet(              344.0,       3.95854179,    412.371096874  ),
    new VsopSet(              340.0,       3.63396399,    316.391869657  ),
    new VsopSet(              336.0,       3.77173073,    735.876513532  ),
    new VsopSet(              332.0,         2.860777,      210.1177017  ),
    new VsopSet(              289.0,        2.7326308,     117.31986822  ),
    new VsopSet(              281.0,       5.74398845,       2.44768055  ),
    new VsopSet(              266.0,      0.543446313,    647.010833315  ),
    new VsopSet(              230.0,        1.6442888,    216.480489176  ),
    new VsopSet(              192.0,       2.96512947,    224.344795702  ),
    new VsopSet(              173.0,       4.07695221,    846.082834751  ),
    new VsopSet(              167.0,       2.59745203,     21.340641002  ),
    new VsopSet(              136.0,       2.28580247,     10.294940739  ),
    new VsopSet(              131.0,       3.44108356,    742.990060533  ),
    new VsopSet(              128.0,       4.09533471,    217.231248701  ),
    new VsopSet(              109.0,       6.16141072,    415.552490612  ),
    new VsopSet(               98.0,       4.72845437,     838.96928775  ),
    new VsopSet(               94.0,        3.4839728,   1052.268383188  ),
    new VsopSet(               92.0,         3.947555,     88.865680217  ),
    new VsopSet(               87.0,       1.21951325,    440.825284878  ),
    new VsopSet(               83.0,       3.11269505,    625.670192312  ),
    new VsopSet(               78.0,       6.24408939,    302.164775655  ),
    new VsopSet(               67.0,      0.289617386,       4.66586645  ),
    new VsopSet(               66.0,       5.64757043,       9.56122756  ),
    new VsopSet(               62.0,       4.29344363,    127.471796607  ),
    new VsopSet(               62.0,       1.82789613,    195.139848173  ),
    new VsopSet(               58.0,       2.47630552,    191.958454436  ),
    new VsopSet(               57.0,       5.01889578,    137.033024162  ),
    new VsopSet(               55.0,      0.283563415,     74.781598567  ),
    new VsopSet(               54.0,       5.12628572,    490.334089179  ),
    new VsopSet(               51.0,       1.45766406,    536.804512095  ),
    new VsopSet(               47.0,       1.17721211,    149.563197135  ),
    new VsopSet(               47.0,       5.14818327,    515.463871093  ),
    new VsopSet(               46.0,       2.23198879,    956.289155971  ),
    new VsopSet(               44.0,       2.70873628,       5.41662597  ),
    new VsopSet(               40.0,      0.412815204,    269.921446741  ),
    new VsopSet(               40.0,       3.88870106,    728.762966531  ),
    new VsopSet(               38.0,      0.646659672,    422.666037613  ),
    new VsopSet(               38.0,       2.53379014,     12.530172972  ),
    new VsopSet(               37.0,       3.78239026,       2.92076131  ),
    new VsopSet(               35.0,       6.08421794,       5.62907429  ),
    new VsopSet(               34.0,       3.21070688,   1368.660252845  ),
    new VsopSet(               33.0,       4.64063092,    277.034993741  ),
    new VsopSet(               33.0,       5.43038091,    1066.49547719  ),
    new VsopSet(               33.0,      0.300638846,    351.816592309  ),
    new VsopSet(               32.0,       4.38622924,   1155.361157407  ),
    new VsopSet(               31.0,       2.43455856,      52.69019804  ),
    new VsopSet(               30.0,       2.84067005,      203.0041547  ),
    new VsopSet(               30.0,       6.18684614,    284.148540742  ),
    new VsopSet(               30.0,       3.39052569,   1059.381930189  ),
    new VsopSet(               29.0,        2.0261476,    330.618963658  ),
    new VsopSet(               28.0,       2.74178954,    265.989293478  ),
    new VsopSet(               26.0,        4.5121417,    340.770892045  )
};

static final VsopSet SaturnLonTerms2[] = {
    new VsopSet(           116441.0,       1.17987851,         7.113547  ),
    new VsopSet(            91921.0,      0.074252611,    213.299095438  ),
    new VsopSet(            90592.0,                0.0,                0.0  ),
    new VsopSet(            15277.0,       4.06492007,    206.185548437  ),
    new VsopSet(            10631.0,      0.257782774,    220.412642439  ),
    new VsopSet(            10605.0,       5.40963596,    426.598190876  ),
    new VsopSet(             4265.0,       1.04595557,     14.227094002  ),
    new VsopSet(             1216.0,       2.91860042,    103.092774219  ),
    new VsopSet(             1165.0,       4.60942129,    639.897286314  ),
    new VsopSet(             1082.0,       5.69130352,    433.711737877  ),
    new VsopSet(             1045.0,       4.04206454,    199.072001436  ),
    new VsopSet(             1020.0,      0.633691826,       3.18139374  ),
    new VsopSet(              634.0,        4.3882541,    419.484643875  ),
    new VsopSet(              549.0,       5.57303134,       3.93215326  ),
    new VsopSet(              457.0,       1.26840971,    110.206321219  ),
    new VsopSet(              425.0,      0.209354993,     227.52618944  ),
    new VsopSet(              274.0,       4.28841012,     95.979227218  ),
    new VsopSet(              162.0,       1.38139149,     11.045700264  ),
    new VsopSet(              129.0,       1.56586884,    309.278322656  ),
    new VsopSet(              117.0,       3.88120916,    853.196381752  ),
    new VsopSet(              105.0,       4.90003204,    647.010833315  ),
    new VsopSet(              101.0,      0.892704931,     21.340641002  ),
    new VsopSet(               96.0,       2.91093562,    316.391869657  ),
    new VsopSet(               95.0,       5.62561151,    412.371096874  ),
    new VsopSet(               85.0,       5.73472778,    209.366942175  ),
    new VsopSet(               83.0,       6.05030935,    216.480489176  ),
    new VsopSet(               82.0,       1.02477558,     117.31986822  ),
    new VsopSet(               75.0,       4.76178468,      210.1177017  ),
    new VsopSet(               67.0,      0.456486126,    522.577418094  ),
    new VsopSet(               66.0,      0.482979406,     10.294940739  ),
    new VsopSet(               64.0,      0.351798049,    323.505416657  ),
    new VsopSet(               61.0,        4.8751785,    632.783739313  ),
    new VsopSet(               53.0,       2.74730541,    529.690965095  ),
    new VsopSet(               46.0,       5.69296622,    440.825284878  ),
    new VsopSet(               45.0,         1.668567,    202.253395174  ),
    new VsopSet(               42.0,       5.70768188,     88.865680217  ),
    new VsopSet(               32.0,      0.070500503,     63.735898303  ),
    new VsopSet(               32.0,       1.67190022,    302.164775655  ),
    new VsopSet(               31.0,       4.16379538,    191.958454436  ),
    new VsopSet(               27.0,      0.832562144,    224.344795702  ),
    new VsopSet(               25.0,       5.65564729,    735.876513532  ),
    new VsopSet(               20.0,        5.9436461,    217.231248701  ),
    new VsopSet(               18.0,       4.90014737,    625.670192312  ),
    new VsopSet(               17.0,       1.62593421,    742.990060533  ),
    new VsopSet(               16.0,      0.578863208,    515.463871093  ),
    new VsopSet(               14.0,      0.206752937,     838.96928775  ),
    new VsopSet(               14.0,       3.76497167,    195.139848173  ),
    new VsopSet(               12.0,       4.71789724,      203.0041547  ),
    new VsopSet(               12.0,      0.126207142,     234.63973644  ),
    new VsopSet(               12.0,       3.12098484,    846.082834751  ),
    new VsopSet(               11.0,       5.92216845,    536.804512095  ),
    new VsopSet(               11.0,       5.60207983,    728.762966531  ),
    new VsopSet(               11.0,       3.20327613,    1066.49547719  ),
    new VsopSet(               10.0,       4.98736656,    422.666037613  ),
    new VsopSet(               10.0,       0.25709352,    330.618963658  ),
    new VsopSet(               10.0,       4.15472049,    860.309928753  ),
    new VsopSet(                9.0,      0.463799693,    956.289155971  ),
    new VsopSet(                8.0,       2.13990364,    269.921446741  ),
    new VsopSet(                8.0,       5.24602742,    429.779584614  ),
    new VsopSet(                8.0,       4.03401154,       9.56122756  ),
    new VsopSet(                7.0,       5.39724715,   1052.268383188  ),
    new VsopSet(                6.0,       4.46211131,    284.148540742  ),
    new VsopSet(                6.0,       5.93416925,    405.257549874  )
};

static final VsopSet SaturnLonTerms3[] = {
    new VsopSet(            16039.0,       5.73945377,         7.113547  ),
    new VsopSet(             4250.0,       4.58539676,    213.299095438  ),
    new VsopSet(             1907.0,        4.7608205,    220.412642439  ),
    new VsopSet(             1466.0,       5.91326678,    206.185548437  ),
    new VsopSet(             1162.0,       5.61973132,     14.227094002  ),
    new VsopSet(             1067.0,       3.60816533,    426.598190876  ),
    new VsopSet(              239.0,       3.86088273,    433.711737877  ),
    new VsopSet(              237.0,       5.76826452,    199.072001436  ),
    new VsopSet(              166.0,        5.1164115,       3.18139374  ),
    new VsopSet(              151.0,       2.73594642,    639.897286314  ),
    new VsopSet(              131.0,       4.74327545,     227.52618944  ),
    new VsopSet(               63.0,      0.228500895,    419.484643875  ),
    new VsopSet(               62.0,       4.74287052,    103.092774219  ),
    new VsopSet(               40.0,       5.47298059,     21.340641002  ),
    new VsopSet(               40.0,       5.96420267,     95.979227218  ),
    new VsopSet(               39.0,         5.833862,    110.206321219  ),
    new VsopSet(               28.0,       3.01235311,    647.010833315  ),
    new VsopSet(               25.0,      0.988081707,       3.93215326  ),
    new VsopSet(               19.0,       1.91614238,    853.196381752  ),
    new VsopSet(               18.0,       4.96738416,     10.294940739  ),
    new VsopSet(               18.0,       1.02506397,    412.371096874  ),
    new VsopSet(               18.0,       4.20376505,    216.480489176  ),
    new VsopSet(               18.0,       3.31913419,    309.278322656  ),
    new VsopSet(               16.0,       3.89825273,    440.825284878  ),
    new VsopSet(               16.0,        5.6166781,     117.31986822  ),
    new VsopSet(               13.0,       1.18068954,     88.865680217  ),
    new VsopSet(               11.0,       5.57520615,     11.045700264  ),
    new VsopSet(               11.0,       5.92906266,    191.958454436  ),
    new VsopSet(               10.0,       3.94838737,    209.366942175  ),
    new VsopSet(                9.0,        3.3933537,    302.164775655  ),
    new VsopSet(                8.0,       4.87736913,    323.505416657  ),
    new VsopSet(                7.0,      0.381987256,    632.783739313  ),
    new VsopSet(                6.0,       2.25492723,    522.577418094  ),
    new VsopSet(                6.0,       1.05621158,      210.1177017  ),
    new VsopSet(                5.0,       4.64268476,     234.63973644  ),
    new VsopSet(                4.0,       3.14159265,                0.0  ),
    new VsopSet(                4.0,       2.30677011,    515.463871093  ),
    new VsopSet(                3.0,         2.203094,    860.309928753  ),
    new VsopSet(                3.0,       0.58604395,    529.690965095  ),
    new VsopSet(                3.0,       4.93447677,    224.344795702  ),
    new VsopSet(                3.0,      0.423938842,    625.670192312  ),
    new VsopSet(                2.0,       4.76621392,    330.618963658  ),
    new VsopSet(                2.0,       3.34809166,    429.779584614  ),
    new VsopSet(                2.0,       3.19814958,    202.253395174  ),
    new VsopSet(                2.0,       1.18918501,    1066.49547719  ),
    new VsopSet(                2.0,       1.35488209,    405.257549874  ),
    new VsopSet(                2.0,       4.15631351,    223.594036177  ),
    new VsopSet(                2.0,        3.0669357,    654.124380316  )
};

static final VsopSet SaturnLonTerms4[] = {
    new VsopSet(             1662.0,       3.99826249,         7.113547  ),
    new VsopSet(              257.0,       2.98436499,    220.412642439  ),
    new VsopSet(              236.0,       3.90241428,     14.227094002  ),
    new VsopSet(              149.0,       2.74110824,    213.299095438  ),
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(              110.0,       1.51515739,    206.185548437  ),
    new VsopSet(               68.0,       1.72120953,    426.598190876  ),
    new VsopSet(               40.0,       2.04644897,    433.711737877  ),
    new VsopSet(               38.0,       1.23795458,    199.072001436  ),
    new VsopSet(               31.0,       3.01094184,     227.52618944  ),
    new VsopSet(               15.0,      0.828970645,    639.897286314  ),
    new VsopSet(                9.0,       3.71485301,     21.340641002  ),
    new VsopSet(                6.0,       2.41995291,    419.484643875  ),
    new VsopSet(                6.0,       1.15607096,    647.010833315  ),
    new VsopSet(                4.0,       1.45120819,     95.979227218  ),
    new VsopSet(                4.0,       2.11783225,    440.825284878  ),
    new VsopSet(                3.0,       4.09278078,    110.206321219  ),
    new VsopSet(                3.0,       2.77203154,    412.371096874  ),
    new VsopSet(                3.0,        3.0073025,     88.865680217  ),
    new VsopSet(                3.0,      0.002557213,    853.196381752  ),
    new VsopSet(                3.0,      0.392468541,    103.092774219  ),
    new VsopSet(                2.0,       3.77689198,     117.31986822  ),
    new VsopSet(                2.0,       2.82884329,     234.63973644  ),
    new VsopSet(                2.0,       5.07955458,    309.278322656  ),
    new VsopSet(                2.0,       2.23816037,    216.480489176  ),
    new VsopSet(                2.0,       5.19176876,    302.164775655  ),
    new VsopSet(                1.0,       1.54685247,    191.958454436  )
};

static final VsopSet SaturnLonTerms5[] = {
    new VsopSet(              124.0,       2.25923346,         7.113547  ),
    new VsopSet(               34.0,       2.16250653,     14.227094002  ),
    new VsopSet(               28.0,        1.1986815,    220.412642439  ),
    new VsopSet(                6.0,        1.2158427,     227.52618944  ),
    new VsopSet(                5.0,      0.235504001,    433.711737877  ),
    new VsopSet(                4.0,       6.22669694,    426.598190876  ),
    new VsopSet(                3.0,       2.97372046,    199.072001436  ),
    new VsopSet(                3.0,       4.28710933,    206.185548437  ),
    new VsopSet(                2.0,       6.25265362,    213.299095438  ),
    new VsopSet(                1.0,       5.27612561,    639.897286314  ),
    new VsopSet(                1.0,      0.235169516,    440.825284878  ),
    new VsopSet(                1.0,       3.14159265,                0.0  )
};

static final VsopSet SaturnLatTerms0[] = {
    new VsopSet(          4330678.0,       3.60284428,    213.299095438  ),
    new VsopSet(           240348.0,       2.85238489,    426.598190876  ),
    new VsopSet(            84746.0,                0.0,                0.0  ),
    new VsopSet(            34116.0,      0.572973078,    206.185548437  ),
    new VsopSet(            30863.0,       3.48441505,    220.412642439  ),
    new VsopSet(            14734.0,       2.11846598,    639.897286314  ),
    new VsopSet(             9917.0,       5.79003189,    419.484643875  ),
    new VsopSet(             6994.0,       4.73604689,         7.113547  ),
    new VsopSet(             4808.0,       5.43305316,    316.391869657  ),
    new VsopSet(             4788.0,       4.96512927,    110.206321219  ),
    new VsopSet(             3432.0,       2.73255752,    433.711737877  ),
    new VsopSet(             1506.0,       6.01304536,    103.092774219  ),
    new VsopSet(             1060.0,       5.63099292,    529.690965095  ),
    new VsopSet(              969.0,       5.20434966,    632.783739313  ),
    new VsopSet(              942.0,       1.39646678,    853.196381752  ),
    new VsopSet(              708.0,        3.8030233,    323.505416657  ),
    new VsopSet(              552.0,       5.13149109,    202.253395174  ),
    new VsopSet(              400.0,       3.35891414,     227.52618944  ),
    new VsopSet(              319.0,       3.62571551,    209.366942175  ),
    new VsopSet(              316.0,       1.99716764,    647.010833315  ),
    new VsopSet(              314.0,      0.465102724,    217.231248701  ),
    new VsopSet(              284.0,       4.88648482,    224.344795702  ),
    new VsopSet(              236.0,       2.13887472,     11.045700264  ),
    new VsopSet(              215.0,        5.9498261,    846.082834751  ),
    new VsopSet(              209.0,       2.12003894,    415.552490612  ),
    new VsopSet(              207.0,      0.730214629,    199.072001436  ),
    new VsopSet(              179.0,       2.95361515,     63.735898303  ),
    new VsopSet(              141.0,      0.644176203,    490.334089179  ),
    new VsopSet(              139.0,       4.59535168,     14.227094002  ),
    new VsopSet(              139.0,       1.99821991,    735.876513532  ),
    new VsopSet(              135.0,        5.2450082,    742.990060533  ),
    new VsopSet(              122.0,       3.11537141,    522.577418094  ),
    new VsopSet(              116.0,       3.10891547,    216.480489176  ),
    new VsopSet(              114.0,      0.962614421,      210.1177017  )
};

static final VsopSet SaturnLatTerms1[] = {
    new VsopSet(           397555.0,       5.33289993,    213.299095438  ),
    new VsopSet(            49479.0,       3.14159265,                0.0  ),
    new VsopSet(            18572.0,       6.09919206,    426.598190876  ),
    new VsopSet(            14801.0,        2.3058606,    206.185548437  ),
    new VsopSet(             9644.0,        1.6967466,    220.412642439  ),
    new VsopSet(             3757.0,       1.25429514,    419.484643875  ),
    new VsopSet(             2717.0,       5.91166665,    639.897286314  ),
    new VsopSet(             1455.0,      0.851616165,    433.711737877  ),
    new VsopSet(             1291.0,       2.91770857,         7.113547  ),
    new VsopSet(              853.0,       0.43572079,    316.391869657  ),
    new VsopSet(              298.0,      0.919092067,    632.783739313  ),
    new VsopSet(              292.0,       5.31574251,    853.196381752  ),
    new VsopSet(              284.0,       1.61881755,     227.52618944  ),
    new VsopSet(              275.0,       3.88864137,    103.092774219  ),
    new VsopSet(              172.0,      0.052151466,    647.010833315  ),
    new VsopSet(              166.0,       2.44351613,    199.072001436  ),
    new VsopSet(              158.0,       5.20850126,    110.206321219  ),
    new VsopSet(              128.0,       1.20711452,    529.690965095  ),
    new VsopSet(              110.0,       2.45695552,    217.231248701  ),
    new VsopSet(               82.0,       2.75839171,      210.1177017  ),
    new VsopSet(               81.0,       2.86038377,     14.227094002  ),
    new VsopSet(               69.0,       1.65537623,    202.253395174  ),
    new VsopSet(               65.0,       1.25527521,    216.480489176  ),
    new VsopSet(               61.0,       1.25273412,    209.366942175  ),
    new VsopSet(               59.0,       1.82410768,    323.505416657  ),
    new VsopSet(               46.0,      0.815347053,    440.825284878  ),
    new VsopSet(               36.0,       1.81851058,    224.344795702  ),
    new VsopSet(               34.0,       2.83971298,     117.31986822  ),
    new VsopSet(               33.0,        1.3055708,    412.371096874  ),
    new VsopSet(               32.0,       1.18676132,    846.082834751  ),
    new VsopSet(               27.0,       4.64744848,    1066.49547719  ),
    new VsopSet(               27.0,       4.44228739,     11.045700264  )
};

static final VsopSet SaturnLatTerms2[] = {
    new VsopSet(            20630.0,      0.504824228,    213.299095438  ),
    new VsopSet(             3720.0,       3.99833476,    206.185548437  ),
    new VsopSet(             1627.0,        6.1818994,    220.412642439  ),
    new VsopSet(             1346.0,                0.0,                0.0  ),
    new VsopSet(              706.0,       3.03914309,    419.484643875  ),
    new VsopSet(              365.0,       5.09928681,    426.598190876  ),
    new VsopSet(              330.0,        5.2789921,    433.711737877  ),
    new VsopSet(              219.0,       3.82841534,    639.897286314  ),
    new VsopSet(              139.0,       1.04272623,         7.113547  ),
    new VsopSet(              104.0,       6.15730993,     227.52618944  ),
    new VsopSet(               93.0,       1.97994413,    316.391869657  ),
    new VsopSet(               71.0,       4.14754353,    199.072001436  ),
    new VsopSet(               52.0,       2.88364834,    632.783739313  ),
    new VsopSet(               49.0,       4.43390207,    647.010833315  ),
    new VsopSet(               41.0,        3.1592777,    853.196381752  ),
    new VsopSet(               29.0,       4.52978328,      210.1177017  ),
    new VsopSet(               24.0,       1.11595912,     14.227094002  ),
    new VsopSet(               21.0,       4.35095844,    217.231248701  ),
    new VsopSet(               20.0,       5.30779711,    440.825284878  ),
    new VsopSet(               18.0,      0.853914768,    110.206321219  ),
    new VsopSet(               17.0,       5.68112084,    216.480489176  ),
    new VsopSet(               16.0,       4.25767226,    103.092774219  ),
    new VsopSet(               14.0,       2.99904334,    412.371096874  ),
    new VsopSet(               12.0,       2.52679928,    529.690965095  ),
    new VsopSet(                8.0,       3.31512424,    202.253395174  ),
    new VsopSet(                7.0,        5.5571413,    209.366942175  ),
    new VsopSet(                7.0,      0.287660251,    323.505416657  ),
    new VsopSet(                6.0,       1.16121321,     117.31986822  ),
    new VsopSet(                6.0,       3.61231887,    860.309928753  )
};

static final VsopSet SaturnLatTerms3[] = {
    new VsopSet(              666.0,        1.9900634,    213.299095438  ),
    new VsopSet(              632.0,       5.69778317,    206.185548437  ),
    new VsopSet(              398.0,                0.0,                0.0  ),
    new VsopSet(              188.0,       4.33779805,    220.412642439  ),
    new VsopSet(               92.0,       4.84104208,    419.484643875  ),
    new VsopSet(               52.0,        3.4214949,    433.711737877  ),
    new VsopSet(               42.0,       2.38073239,    426.598190876  ),
    new VsopSet(               26.0,       4.40167213,     227.52618944  ),
    new VsopSet(               21.0,        5.8531351,    199.072001436  ),
    new VsopSet(               18.0,       1.99321433,    639.897286314  ),
    new VsopSet(               11.0,       5.37344546,         7.113547  ),
    new VsopSet(               10.0,       2.54901826,    647.010833315  ),
    new VsopSet(                7.0,       3.45518373,    316.391869657  ),
    new VsopSet(                6.0,       4.80055225,    632.783739313  ),
    new VsopSet(                6.0,      0.016803788,      210.1177017  ),
    new VsopSet(                6.0,       3.51756748,    440.825284878  ),
    new VsopSet(                5.0,       5.63719731,     14.227094002  ),
    new VsopSet(                5.0,       1.22424419,    853.196381752  ),
    new VsopSet(                4.0,       4.71299371,    412.371096874  ),
    new VsopSet(                3.0,      0.626792076,    103.092774219  ),
    new VsopSet(                2.0,       3.71982275,    216.480489176  )
};

static final VsopSet SaturnLatTerms4[] = {
    new VsopSet(               80.0,       1.11918415,    206.185548437  ),
    new VsopSet(               32.0,       3.12218745,    213.299095438  ),
    new VsopSet(               17.0,         2.480732,    220.412642439  ),
    new VsopSet(               12.0,       3.14159265,                0.0  ),
    new VsopSet(                9.0,      0.384414249,    419.484643875  ),
    new VsopSet(                6.0,        1.5618638,    433.711737877  ),
    new VsopSet(                5.0,       2.63498295,     227.52618944  ),
    new VsopSet(                5.0,        1.2823564,    199.072001436  ),
    new VsopSet(                1.0,       1.43096672,    426.598190876  ),
    new VsopSet(                1.0,      0.669880836,    647.010833315  ),
    new VsopSet(                1.0,       1.72041928,    440.825284878  ),
    new VsopSet(                1.0,       6.18092274,    639.897286314  )
};

static final VsopSet SaturnLatTerms5[] = {
    new VsopSet(                8.0,       2.81927559,    206.185548437  ),
    new VsopSet(                1.0,      0.511872103,    220.412642439  )
};

static final VsopSet SaturnRadTerms0[] = {
    new VsopSet(        955758136.0,                0.0,                0.0  ),
    new VsopSet(         52921382.0,        2.3922622,    213.299095438  ),
    new VsopSet(          1873680.0,       5.23549605,    206.185548437  ),
    new VsopSet(          1464664.0,       1.64763046,    426.598190876  ),
    new VsopSet(           821891.0,       5.93520025,    316.391869657  ),
    new VsopSet(           547507.0,       5.01532629,    103.092774219  ),
    new VsopSet(           371684.0,       2.27114833,    220.412642439  ),
    new VsopSet(           361778.0,       3.13904303,         7.113547  ),
    new VsopSet(           140618.0,       5.70406653,    632.783739313  ),
    new VsopSet(           108975.0,       3.29313596,    110.206321219  ),
    new VsopSet(            69007.0,       5.94099622,    419.484643875  ),
    new VsopSet(            61053.0,      0.940377612,    639.897286314  ),
    new VsopSet(            48913.0,       1.55733389,    202.253395174  ),
    new VsopSet(            34144.0,      0.195185507,    277.034993741  ),
    new VsopSet(            32402.0,       5.47084607,     949.17560897  ),
    new VsopSet(            20937.0,       0.46349164,    735.876513532  ),
    new VsopSet(            20839.0,       1.52102591,    433.711737877  ),
    new VsopSet(            20747.0,       5.33255668,    199.072001436  ),
    new VsopSet(            15298.0,       3.05943653,    529.690965095  ),
    new VsopSet(            14296.0,       2.60433538,    323.505416657  ),
    new VsopSet(            12884.0,        1.6489231,    138.517496871  ),
    new VsopSet(            11993.0,       5.98051422,    846.082834751  ),
    new VsopSet(            11380.0,       1.73105747,    522.577418094  ),
    new VsopSet(             9796.0,       5.20475864,   1265.567478626  ),
    new VsopSet(             7753.0,       5.85191319,     95.979227218  ),
    new VsopSet(             6771.0,       3.00433479,     14.227094002  ),
    new VsopSet(             6466.0,      0.177331601,   1052.268383188  ),
    new VsopSet(             5850.0,       1.45519636,    415.552490612  ),
    new VsopSet(             5307.0,      0.597375341,     63.735898303  ),
    new VsopSet(             4696.0,       2.14919037,     227.52618944  ),
    new VsopSet(             4044.0,       1.64010324,    209.366942175  ),
    new VsopSet(             3688.0,      0.780161332,    412.371096874  ),
    new VsopSet(             3461.0,       1.85088803,      175.1660598  ),
    new VsopSet(             3420.0,       4.94549149,   1581.959348283  ),
    new VsopSet(             3401.0,      0.553867475,      350.3321196  ),
    new VsopSet(             3376.0,       3.69528479,    224.344795702  ),
    new VsopSet(             2976.0,       5.68467931,      210.1177017  ),
    new VsopSet(             2885.0,       1.38764078,     838.96928775  ),
    new VsopSet(             2881.0,      0.179607579,    853.196381752  ),
    new VsopSet(             2508.0,       3.53851863,    742.990060533  ),
    new VsopSet(             2448.0,       6.18412386,   1368.660252845  ),
    new VsopSet(             2406.0,        2.9655922,     117.31986822  ),
    new VsopSet(             2174.0,      0.015085874,    340.770892045  ),
    new VsopSet(             2024.0,       5.05411271,     11.045700264  )
};

static final VsopSet SaturnRadTerms1[] = {
    new VsopSet(          6182981.0,       0.25843515,    213.299095438  ),
    new VsopSet(           506578.0,      0.711146509,    206.185548437  ),
    new VsopSet(           341394.0,       5.79635774,    426.598190876  ),
    new VsopSet(           188491.0,      0.472157194,    220.412642439  ),
    new VsopSet(           186262.0,       3.14159265,                0.0  ),
    new VsopSet(           143891.0,       1.40744864,         7.113547  ),
    new VsopSet(            49621.0,        6.0174447,    103.092774219  ),
    new VsopSet(            20928.0,       5.09245655,    639.897286314  ),
    new VsopSet(            19953.0,       1.17560125,    419.484643875  ),
    new VsopSet(            18840.0,       1.60819563,    110.206321219  ),
    new VsopSet(            13877.0,      0.758862044,    199.072001436  ),
    new VsopSet(            12893.0,       5.94330258,    433.711737877  ),
    new VsopSet(             5397.0,       1.28852406,     14.227094002  ),
    new VsopSet(             4869.0,      0.867938942,    323.505416657  ),
    new VsopSet(             4247.0,      0.392993845,     227.52618944  ),
    new VsopSet(             3252.0,       1.25853471,     95.979227218  ),
    new VsopSet(             3081.0,       3.43662557,    522.577418094  ),
    new VsopSet(             2909.0,       4.60679155,    202.253395174  ),
    new VsopSet(             2856.0,       2.16731405,    735.876513532  ),
    new VsopSet(             1988.0,       2.45054205,    412.371096874  ),
    new VsopSet(             1941.0,       6.02393385,    209.366942175  ),
    new VsopSet(             1581.0,        1.2919179,      210.1177017  ),
    new VsopSet(             1340.0,       4.30801822,    853.196381752  ),
    new VsopSet(             1316.0,       1.25296446,     117.31986822  ),
    new VsopSet(             1203.0,       1.86654674,    316.391869657  ),
    new VsopSet(             1091.0,      0.075272469,    216.480489176  ),
    new VsopSet(              966.0,      0.479913791,    632.783739313  ),
    new VsopSet(              954.0,       5.15173411,    647.010833315  ),
    new VsopSet(              898.0,      0.983437761,    529.690965095  ),
    new VsopSet(              882.0,       1.88471725,   1052.268383188  ),
    new VsopSet(              874.0,       1.40224684,    224.344795702  ),
    new VsopSet(              785.0,       3.06377518,     838.96928775  ),
    new VsopSet(              740.0,       1.38225357,    625.670192312  ),
    new VsopSet(              658.0,       4.14362931,    309.278322656  ),
    new VsopSet(              650.0,       1.72489486,    742.990060533  ),
    new VsopSet(              613.0,       3.03307307,     63.735898303  ),
    new VsopSet(              599.0,       2.54924175,    217.231248701  ),
    new VsopSet(              503.0,        2.1295882,       3.93215326  )
};

static final VsopSet SaturnRadTerms2[] = {
    new VsopSet(           436902.0,       4.78671673,    213.299095438  ),
    new VsopSet(            71923.0,       2.50069995,    206.185548437  ),
    new VsopSet(            49767.0,       4.97168151,    220.412642439  ),
    new VsopSet(            43221.0,       3.86940444,    426.598190876  ),
    new VsopSet(            29646.0,       5.96310264,         7.113547  ),
    new VsopSet(             4721.0,       2.47527992,    199.072001436  ),
    new VsopSet(             4142.0,       4.10670941,    433.711737877  ),
    new VsopSet(             3789.0,       3.09771025,    639.897286314  ),
    new VsopSet(             2964.0,       1.37206249,    103.092774219  ),
    new VsopSet(             2556.0,       2.85065722,    419.484643875  ),
    new VsopSet(             2327.0,                0.0,                0.0  ),
    new VsopSet(             2208.0,       6.27588859,    110.206321219  ),
    new VsopSet(             2188.0,       5.85545832,     14.227094002  ),
    new VsopSet(             1957.0,       4.92448618,     227.52618944  ),
    new VsopSet(              924.0,       5.46392423,    323.505416657  ),
    new VsopSet(              706.0,        2.9708128,     95.979227218  ),
    new VsopSet(              546.0,       4.12854182,    412.371096874  ),
    new VsopSet(              431.0,       5.17825415,    522.577418094  ),
    new VsopSet(              405.0,       4.17294158,    209.366942175  ),
    new VsopSet(              391.0,       4.48106177,    216.480489176  ),
    new VsopSet(              374.0,       5.83435992,     117.31986822  ),
    new VsopSet(              361.0,       3.27703082,    647.010833315  ),
    new VsopSet(              356.0,       3.19152044,      210.1177017  ),
    new VsopSet(              326.0,       2.26867602,    853.196381752  ),
    new VsopSet(              207.0,       4.02188337,    735.876513532  ),
    new VsopSet(              204.0,      0.087748486,    202.253395174  ),
    new VsopSet(              180.0,       3.59704904,    632.783739313  ),
    new VsopSet(              178.0,       4.09716542,    440.825284878  ),
    new VsopSet(              154.0,        3.1347053,    625.670192312  ),
    new VsopSet(              148.0,      0.136143005,    302.164775655  ),
    new VsopSet(              133.0,       2.59350469,    191.958454436  ),
    new VsopSet(              132.0,       5.93293969,    309.278322656  )
};

static final VsopSet SaturnRadTerms3[] = {
    new VsopSet(            20315.0,       3.02186626,    213.299095438  ),
    new VsopSet(             8924.0,       3.19144206,    220.412642439  ),
    new VsopSet(             6909.0,       4.35174889,    206.185548437  ),
    new VsopSet(             4087.0,       4.22406927,         7.113547  ),
    new VsopSet(             3879.0,       2.01056446,    426.598190876  ),
    new VsopSet(             1071.0,       4.20360341,    199.072001436  ),
    new VsopSet(              907.0,       2.28344368,    433.711737877  ),
    new VsopSet(              606.0,       3.17458571,     227.52618944  ),
    new VsopSet(              597.0,       4.13455753,     14.227094002  ),
    new VsopSet(              483.0,       1.17345973,    639.897286314  ),
    new VsopSet(              393.0,                0.0,                0.0  ),
    new VsopSet(              229.0,       4.69838526,    419.484643875  ),
    new VsopSet(              188.0,       4.59003889,    110.206321219  ),
    new VsopSet(              150.0,       3.20199444,    103.092774219  ),
    new VsopSet(              121.0,       3.76831374,    323.505416657  ),
    new VsopSet(              102.0,       4.70974423,     95.979227218  ),
    new VsopSet(              101.0,       5.81884138,    412.371096874  ),
    new VsopSet(               93.0,       1.43531271,    647.010833315  ),
    new VsopSet(               84.0,        2.6346238,    216.480489176  ),
    new VsopSet(               73.0,       4.15395598,     117.31986822  ),
    new VsopSet(               62.0,       2.31239346,    440.825284878  ),
    new VsopSet(               55.0,      0.305264685,    853.196381752  ),
    new VsopSet(               50.0,       2.38854233,    209.366942175  ),
    new VsopSet(               45.0,       4.37317047,    191.958454436  ),
    new VsopSet(               41.0,      0.688451832,    522.577418094  ),
    new VsopSet(               40.0,        1.8383657,    302.164775655  ),
    new VsopSet(               38.0,       5.94455116,     88.865680217  ),
    new VsopSet(               32.0,       4.01146349,     21.340641002  )
};

static final VsopSet SaturnRadTerms4[] = {
    new VsopSet(             1202.0,       1.41499446,    220.412642439  ),
    new VsopSet(              708.0,        1.1615357,    213.299095438  ),
    new VsopSet(              516.0,       6.23973568,    206.185548437  ),
    new VsopSet(              427.0,        2.4692489,         7.113547  ),
    new VsopSet(              268.0,      0.186592067,    426.598190876  ),
    new VsopSet(              170.0,       5.95926972,    199.072001436  ),
    new VsopSet(              150.0,      0.479701671,    433.711737877  ),
    new VsopSet(              145.0,        1.4421106,     227.52618944  ),
    new VsopSet(              121.0,       2.40527321,     14.227094002  ),
    new VsopSet(               47.0,       5.56857489,    639.897286314  ),
    new VsopSet(               19.0,       5.85626429,    647.010833315  ),
    new VsopSet(               17.0,      0.529207743,    440.825284878  ),
    new VsopSet(               16.0,       2.90112466,    110.206321219  ),
    new VsopSet(               15.0,      0.299053168,    419.484643875  ),
    new VsopSet(               14.0,       1.30343551,    412.371096874  ),
    new VsopSet(               13.0,       2.09349306,    323.505416657  ),
    new VsopSet(               11.0,       0.21785507,     95.979227218  ),
    new VsopSet(               11.0,       2.46304826,     117.31986822  ),
    new VsopSet(               10.0,       3.14159265,                0.0  ),
    new VsopSet(                9.0,       1.56496313,     88.865680217  ),
    new VsopSet(                9.0,       2.28127318,     21.340641002  ),
    new VsopSet(                9.0,       0.68301278,    216.480489176  ),
    new VsopSet(                8.0,       1.27239489,     234.63973644  )
};

static final VsopSet SaturnRadTerms5[] = {
    new VsopSet(              129.0,       5.91282565,    220.412642439  ),
    new VsopSet(               32.0,      0.692562286,         7.113547  ),
    new VsopSet(               27.0,       5.91428529,     227.52618944  ),
    new VsopSet(               20.0,       4.95136802,    433.711737877  ),
    new VsopSet(               20.0,      0.673706534,     14.227094002  ),
    new VsopSet(               14.0,        2.6707428,    206.185548437  ),
    new VsopSet(               14.0,       1.45669521,    199.072001436  ),
    new VsopSet(               13.0,       4.58826996,    426.598190876  ),
    new VsopSet(                7.0,       4.62966127,    213.299095438  ),
    new VsopSet(                5.0,       3.61448275,    639.897286314  ),
    new VsopSet(                4.0,       4.89624165,    440.825284878  ),
    new VsopSet(                3.0,        4.0719086,    647.010833315  ),
    new VsopSet(                3.0,       4.65661022,    191.958454436  ),
    new VsopSet(                3.0,      0.486652733,    323.505416657  ),
    new VsopSet(                3.0,       3.18003019,    419.484643875  ),
    new VsopSet(                2.0,       3.69553554,     88.865680217  ),
    new VsopSet(                2.0,       3.31663577,     95.979227218  ),
    new VsopSet(                2.0,      0.560255528,     117.31986822  )
};

// Saturn TermTable
static final VsopTerms[] SaturnLonTerms = {
  new VsopTerms( SaturnLonTerms0Rows, SaturnLonTerms0 ),
  new VsopTerms( SaturnLonTerms1Rows, SaturnLonTerms1 ),
  new VsopTerms( SaturnLonTerms2Rows, SaturnLonTerms2 ),
  new VsopTerms( SaturnLonTerms3Rows, SaturnLonTerms3 ),
  new VsopTerms( SaturnLonTerms4Rows, SaturnLonTerms4 ),
  new VsopTerms( SaturnLonTerms5Rows, SaturnLonTerms5 )
};

static final VsopTerms[] SaturnLatTerms = {
  new VsopTerms( SaturnLatTerms0Rows, SaturnLatTerms0 ),
  new VsopTerms( SaturnLatTerms1Rows, SaturnLatTerms1 ),
  new VsopTerms( SaturnLatTerms2Rows, SaturnLatTerms2 ),
  new VsopTerms( SaturnLatTerms3Rows, SaturnLatTerms3 ),
  new VsopTerms( SaturnLatTerms4Rows, SaturnLatTerms4 ),
  new VsopTerms( SaturnLatTerms5Rows, SaturnLatTerms5 )
};

static final VsopTerms[] SaturnRadTerms = {
  new VsopTerms( SaturnRadTerms0Rows, SaturnRadTerms0 ),
  new VsopTerms( SaturnRadTerms1Rows, SaturnRadTerms1 ),
  new VsopTerms( SaturnRadTerms2Rows, SaturnRadTerms2 ),
  new VsopTerms( SaturnRadTerms3Rows, SaturnRadTerms3 ),
  new VsopTerms( SaturnRadTerms4Rows, SaturnRadTerms4 ),
  new VsopTerms( SaturnRadTerms5Rows, SaturnRadTerms5 )
};

// Uranus Terms
static final int UranusLonTerms0Rows = 91;
static final int UranusLonTerms1Rows = 57;
static final int UranusLonTerms2Rows = 35;
static final int UranusLonTerms3Rows = 18;
static final int UranusLonTerms4Rows = 4;
static final int UranusLonTerms5Rows = 0;

static final int UranusLatTerms0Rows = 28;
static final int UranusLatTerms1Rows = 20;
static final int UranusLatTerms2Rows = 11;
static final int UranusLatTerms3Rows = 4;
static final int UranusLatTerms4Rows = 1;
static final int UranusLatTerms5Rows = 0;

static final int UranusRadTerms0Rows = 59;
static final int UranusRadTerms1Rows = 35;
static final int UranusRadTerms2Rows = 18;
static final int UranusRadTerms3Rows = 10;
static final int UranusRadTerms4Rows = 2;
static final int UranusRadTerms5Rows = 0;

static final VsopSet UranusLonTerms0[] = {
    new VsopSet(        548129294.0,                0.0,                0.0  ),
    new VsopSet(          9260408.0,      0.891064215,     74.781598567  ),
    new VsopSet(          1504248.0,       3.62719262,       1.48447271  ),
    new VsopSet(           365982.0,       1.89962189,     73.297125859  ),
    new VsopSet(           272328.0,       3.35823711,    149.563197135  ),
    new VsopSet(            70328.0,       5.39254432,     63.735898303  ),
    new VsopSet(            68893.0,       6.09292489,     76.266071276  ),
    new VsopSet(            61999.0,       2.26952041,       2.96894542  ),
    new VsopSet(            61951.0,       2.85098908,     11.045700264  ),
    new VsopSet(            26469.0,       3.14152088,      71.81265315  ),
    new VsopSet(            25711.0,       6.11379843,    454.909366527  ),
    new VsopSet(            21079.0,       4.36059465,    148.078724426  ),
    new VsopSet(            17819.0,       1.74436982,      36.64856293  ),
    new VsopSet(            14613.0,       4.73732048,       3.93215326  ),
    new VsopSet(            11163.0,       5.82681994,    224.344795702  ),
    new VsopSet(            10998.0,      0.488654932,    138.517496871  ),
    new VsopSet(             9527.0,       2.95516893,     35.164090221  ),
    new VsopSet(             7546.0,       5.23626441,    109.945688789  ),
    new VsopSet(             4220.0,       3.23328536,     70.849445304  ),
    new VsopSet(             4052.0,       2.27754159,    151.047669843  ),
    new VsopSet(             3490.0,       5.48305567,    146.594251718  ),
    new VsopSet(             3355.0,       1.06549009,       4.45341812  ),
    new VsopSet(             3144.0,       4.75199308,     77.750543984  ),
    new VsopSet(             2927.0,       4.62903696,       9.56122756  ),
    new VsopSet(             2922.0,       5.35236743,     85.827298831  ),
    new VsopSet(             2273.0,       4.36600803,     70.328180442  ),
    new VsopSet(             2149.0,      0.607458009,     38.133035638  ),
    new VsopSet(             2051.0,       1.51773564,      0.111874585  ),
    new VsopSet(             1992.0,       4.92437291,    277.034993741  ),
    new VsopSet(             1667.0,       3.62744581,     380.12776796  ),
    new VsopSet(             1533.0,       2.58593414,      52.69019804  ),
    new VsopSet(             1376.0,       2.04281409,     65.220371012  ),
    new VsopSet(             1372.0,       4.19641616,    111.430161497  ),
    new VsopSet(             1284.0,       3.11346337,    202.253395174  ),
    new VsopSet(             1282.0,      0.542698695,    222.860322994  ),
    new VsopSet(             1244.0,      0.916126806,       2.44768055  ),
    new VsopSet(             1221.0,      0.199013962,     108.46121608  ),
    new VsopSet(             1151.0,       4.17898207,     33.679617513  ),
    new VsopSet(             1150.0,       0.93344454,       3.18139374  ),
    new VsopSet(             1090.0,       1.77501639,     12.530172972  ),
    new VsopSet(             1072.0,      0.235645029,     62.251425595  ),
    new VsopSet(              946.0,       1.19249463,    127.471796607  ),
    new VsopSet(              708.0,       5.18285227,    213.299095438  ),
    new VsopSet(              653.0,      0.965869091,      78.71375183  ),
    new VsopSet(              628.0,       0.18210182,    984.600331622  ),
    new VsopSet(              607.0,       5.43209729,    529.690965095  ),
    new VsopSet(              559.0,       3.35776738,      0.521264862  ),
    new VsopSet(              524.0,       2.01276707,    299.126394269  ),
    new VsopSet(              483.0,        2.1055399,      0.963207847  ),
    new VsopSet(              471.0,       1.40664336,    184.727287356  ),
    new VsopSet(              467.0,      0.414840689,     145.10977901  ),
    new VsopSet(              434.0,       5.52142978,    183.242814648  ),
    new VsopSet(              405.0,       5.98689011,       8.07675485  ),
    new VsopSet(              399.0,      0.338107654,    415.552490612  ),
    new VsopSet(              396.0,       5.87039581,    351.816592309  ),
    new VsopSet(              379.0,       2.34975805,     56.622351303  ),
    new VsopSet(              310.0,       5.83301305,    145.631043872  ),
    new VsopSet(              300.0,       5.64353974,     22.091400528  ),
    new VsopSet(              294.0,       5.83916826,     39.617508346  ),
    new VsopSet(              252.0,       1.63696776,    221.375850285  ),
    new VsopSet(              249.0,       4.74617121,     225.82926841  ),
    new VsopSet(              239.0,       2.35045875,    137.033024162  ),
    new VsopSet(              224.0,      0.515748635,     84.342826123  ),
    new VsopSet(              223.0,        2.8430938,      0.260632431  ),
    new VsopSet(              220.0,       1.92212988,     67.668051567  ),
    new VsopSet(              217.0,       6.14211863,       5.93789083  ),
    new VsopSet(              216.0,       4.77847481,    340.770892045  ),
    new VsopSet(              208.0,        5.5802057,     68.843707734  ),
    new VsopSet(              202.0,       1.29693041,       0.04818411  ),
    new VsopSet(              199.0,       0.95634155,    152.532142551  ),
    new VsopSet(              194.0,       1.88800123,    456.393839236  ),
    new VsopSet(              193.0,      0.916160585,    453.424893819  ),
    new VsopSet(              187.0,       1.31924326,      0.160058694  ),
    new VsopSet(              182.0,       3.53624029,     79.235016692  ),
    new VsopSet(              173.0,       1.53860728,    160.608897399  ),
    new VsopSet(              172.0,       5.67952685,    219.891377577  ),
    new VsopSet(              170.0,       3.67717521,       5.41662597  ),
    new VsopSet(              169.0,       5.87874001,     18.159247265  ),
    new VsopSet(              165.0,       1.42379715,    106.976743372  ),
    new VsopSet(              163.0,       3.05029378,    112.914634205  ),
    new VsopSet(              158.0,      0.738119972,     54.174670748  ),
    new VsopSet(              147.0,       1.26300172,      59.80374504  ),
    new VsopSet(              143.0,       1.29995488,     35.424722652  ),
    new VsopSet(              139.0,       5.38597723,     32.195144805  ),
    new VsopSet(              139.0,       4.25994787,    909.818733055  ),
    new VsopSet(              124.0,        1.3735999,         7.113547  ),
    new VsopSet(              110.0,       2.02685779,    554.069987483  ),
    new VsopSet(              109.0,       5.70581833,     77.962992305  ),
    new VsopSet(              104.0,       5.02820889,      0.750759525  ),
    new VsopSet(              104.0,        1.4577027,     24.379022388  ),
    new VsopSet(              103.0,      0.680953013,     14.977853527  )
};

static final VsopSet UranusLonTerms1[] = {
    new VsopSet(       7502543122.0,                0.0,                0.0  ),
    new VsopSet(           154458.0,       5.24201658,     74.781598567  ),
    new VsopSet(            24456.0,       1.71255705,       1.48447271  ),
    new VsopSet(             9258.0,      0.428446391,     11.045700264  ),
    new VsopSet(             8266.0,       1.50220035,     63.735898303  ),
    new VsopSet(             7842.0,       1.31983607,    149.563197135  ),
    new VsopSet(             3899.0,       0.46483574,       3.93215326  ),
    new VsopSet(             2284.0,       4.17367534,     76.266071276  ),
    new VsopSet(             1927.0,      0.530130802,       2.96894542  ),
    new VsopSet(             1233.0,       1.58634458,     70.849445304  ),
    new VsopSet(              791.0,       5.43641224,       3.18139374  ),
    new VsopSet(              767.0,        1.9955541,     73.297125859  ),
    new VsopSet(              482.0,       2.98401997,     85.827298831  ),
    new VsopSet(              450.0,       4.13826238,    138.517496871  ),
    new VsopSet(              446.0,         3.723004,    224.344795702  ),
    new VsopSet(              427.0,       4.73126059,     71.812653151  ),
    new VsopSet(              354.0,       2.58324497,    148.078724426  ),
    new VsopSet(              348.0,       2.45372261,       9.56122756  ),
    new VsopSet(              317.0,       5.57855232,      52.69019804  ),
    new VsopSet(              206.0,       2.36263144,       2.44768055  ),
    new VsopSet(              189.0,       4.20242881,     56.622351303  ),
    new VsopSet(              184.0,      0.283710047,    151.047669843  ),
    new VsopSet(              180.0,       5.68367731,     12.530172972  ),
    new VsopSet(              171.0,       3.00060075,      78.71375183  ),
    new VsopSet(              158.0,        2.9093197,      0.963207847  ),
    new VsopSet(              155.0,       5.59083926,       4.45341812  ),
    new VsopSet(              154.0,       4.65186886,     35.164090221  ),
    new VsopSet(              152.0,       2.94217327,     77.750543984  ),
    new VsopSet(              143.0,       2.59049247,     62.251425595  ),
    new VsopSet(              121.0,       4.14839205,    127.471796607  ),
    new VsopSet(              116.0,       3.73224604,     65.220371012  ),
    new VsopSet(              102.0,       4.18754518,    145.631043872  ),
    new VsopSet(              102.0,       6.03385875,      0.111874585  ),
    new VsopSet(               88.0,       3.99035788,     18.159247265  ),
    new VsopSet(               88.0,       6.15520788,    202.253395174  ),
    new VsopSet(               81.0,       2.64124744,     22.091400528  ),
    new VsopSet(               72.0,       6.04545934,     70.328180442  ),
    new VsopSet(               69.0,       4.05071895,     77.962992305  ),
    new VsopSet(               59.0,       3.70413919,     67.668051567  ),
    new VsopSet(               47.0,       3.54312461,    351.816592309  ),
    new VsopSet(               44.0,       5.90865822,         7.113547  ),
    new VsopSet(               43.0,       5.72357371,       5.41662597  ),
    new VsopSet(               39.0,       4.91519004,    222.860322994  ),
    new VsopSet(               36.0,       5.89964279,     33.679617513  ),
    new VsopSet(               36.0,       3.29197259,       8.07675485  ),
    new VsopSet(               36.0,       3.32784616,      71.60020483  ),
    new VsopSet(               35.0,       5.08034112,     38.133035638  ),
    new VsopSet(               31.0,       5.62015632,    984.600331622  ),
    new VsopSet(               31.0,       5.49591404,      59.80374504  ),
    new VsopSet(               31.0,       5.46414593,    160.608897399  ),
    new VsopSet(               30.0,       1.65980845,    447.795819527  ),
    new VsopSet(               29.0,        1.1472264,    462.022913528  ),
    new VsopSet(               29.0,        4.5186739,     84.342826123  ),
    new VsopSet(               27.0,       5.54127301,     131.40394987  ),
    new VsopSet(               27.0,       6.14640604,    299.126394269  ),
    new VsopSet(               26.0,       4.99362028,    137.033024162  ),
    new VsopSet(               25.0,       5.73584679,     380.12776796  )
};

static final VsopSet UranusLonTerms2[] = {
    new VsopSet(            53033.0,                0.0,                0.0  ),
    new VsopSet(             2358.0,       2.26014662,     74.781598567  ),
    new VsopSet(              769.0,       4.52561042,     11.045700264  ),
    new VsopSet(              552.0,       3.25814281,     63.735898303  ),
    new VsopSet(              542.0,       2.27573907,       3.93215326  ),
    new VsopSet(              529.0,       4.92348434,       1.48447271  ),
    new VsopSet(              258.0,       3.69059217,       3.18139374  ),
    new VsopSet(              239.0,       5.85806638,    149.563197135  ),
    new VsopSet(              182.0,       6.21763603,     70.849445304  ),
    new VsopSet(               54.0,       1.44225241,     76.266071276  ),
    new VsopSet(               49.0,       6.03101302,     56.622351303  ),
    new VsopSet(               45.0,        3.9090491,       2.44768055  ),
    new VsopSet(               45.0,      0.811526395,     85.827298831  ),
    new VsopSet(               38.0,       1.78467828,      52.69019804  ),
    new VsopSet(               37.0,       4.46228598,       2.96894542  ),
    new VsopSet(               33.0,        0.8638815,       9.56122756  ),
    new VsopSet(               29.0,       5.09818698,     73.297125859  ),
    new VsopSet(               24.0,       2.10702559,     18.159247265  ),
    new VsopSet(               22.0,       5.99320729,    138.517496871  ),
    new VsopSet(               22.0,       4.81730809,      78.71375183  ),
    new VsopSet(               21.0,       2.39880709,     77.962992305  ),
    new VsopSet(               21.0,       2.16918787,    224.344795702  ),
    new VsopSet(               17.0,       2.53537183,    145.631043872  ),
    new VsopSet(               17.0,       3.46631344,     12.530172972  ),
    new VsopSet(               12.0,      0.019413619,     22.091400528  ),
    new VsopSet(               11.0,      0.084962744,    127.471796607  ),
    new VsopSet(               10.0,       5.16453084,      71.60020483  ),
    new VsopSet(               10.0,       4.45556033,     62.251425595  ),
    new VsopSet(                9.0,       4.25550087,         7.113547  ),
    new VsopSet(                8.0,        5.5011593,     67.668051567  ),
    new VsopSet(                7.0,       1.24903906,       5.41662597  ),
    new VsopSet(                6.0,       3.36320161,    447.795819527  ),
    new VsopSet(                6.0,       5.44611674,     65.220371012  ),
    new VsopSet(                6.0,       4.51836836,    151.047669843  ),
    new VsopSet(                6.0,       5.72500087,    462.022913528  )
};

static final VsopSet UranusLonTerms3[] = {
    new VsopSet(              121.0,      0.024187899,     74.781598567  ),
    new VsopSet(               68.0,       4.12084268,       3.93215326  ),
    new VsopSet(               53.0,       2.38964061,     11.045700264  ),
    new VsopSet(               46.0,                0.0,                0.0  ),
    new VsopSet(               45.0,       2.04423798,       3.18139374  ),
    new VsopSet(               44.0,        2.9596504,       1.48447271  ),
    new VsopSet(               25.0,       4.88741308,     63.735898303  ),
    new VsopSet(               21.0,       4.54511487,     70.849445304  ),
    new VsopSet(               20.0,       2.31320314,    149.563197135  ),
    new VsopSet(                9.0,       1.57548872,     56.622351303  ),
    new VsopSet(                4.0,      0.227773196,     18.159247265  ),
    new VsopSet(                4.0,       5.39244611,     76.266071276  ),
    new VsopSet(                4.0,      0.950524486,     77.962992305  ),
    new VsopSet(                3.0,       4.97622812,     85.827298831  ),
    new VsopSet(                3.0,        4.1296936,      52.69019804  ),
    new VsopSet(                3.0,      0.372877963,      78.71375183  ),
    new VsopSet(                2.0,      0.857709618,    145.631043872  ),
    new VsopSet(                2.0,       5.65647821,       9.56122756  )
};

static final VsopSet UranusLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  ),
    new VsopSet(                6.0,       4.57882424,     74.781598567  ),
    new VsopSet(                3.0,      0.346230032,     11.045700264  ),
    new VsopSet(                1.0,       3.42199122,     56.622351303  )
};

static final VsopSet UranusLonTerms5[] = null;

static final VsopSet UranusLatTerms0[] = {
    new VsopSet(          1346278.0,       2.61877811,     74.781598567  ),
    new VsopSet(            62341.0,       5.08111176,    149.563197135  ),
    new VsopSet(            61601.0,       3.14159265,                0.0  ),
    new VsopSet(             9964.0,       1.61603876,     76.266071276  ),
    new VsopSet(             9926.0,      0.576303879,     73.297125859  ),
    new VsopSet(             3259.0,       1.26119386,    224.344795702  ),
    new VsopSet(             2972.0,       2.24367035,       1.48447271  ),
    new VsopSet(             2010.0,       6.05550401,    148.078724426  ),
    new VsopSet(             1522.0,      0.279603864,     63.735898303  ),
    new VsopSet(              924.0,       4.03822928,    151.047669843  ),
    new VsopSet(              761.0,       6.14000432,     71.812653151  ),
    new VsopSet(              522.0,       3.32085195,    138.517496871  ),
    new VsopSet(              463.0,      0.742567276,     85.827298831  ),
    new VsopSet(              437.0,       3.38082524,    529.690965095  ),
    new VsopSet(              435.0,      0.340652819,     77.750543984  ),
    new VsopSet(              431.0,       3.55445035,    213.299095438  ),
    new VsopSet(              420.0,       5.21279985,     11.045700264  ),
    new VsopSet(              245.0,      0.787951503,       2.96894542  ),
    new VsopSet(              233.0,       2.25716421,    222.860322994  ),
    new VsopSet(              216.0,       1.59121705,     38.133035638  ),
    new VsopSet(              180.0,       3.72487953,    299.126394269  ),
    new VsopSet(              175.0,       1.23550262,    146.594251718  ),
    new VsopSet(              174.0,       1.93654269,     380.12776796  ),
    new VsopSet(              160.0,       5.33635437,    111.430161497  ),
    new VsopSet(              144.0,       5.96239326,     35.164090221  ),
    new VsopSet(              116.0,        5.7387719,     70.849445304  ),
    new VsopSet(              106.0,       0.94103113,     70.328180442  ),
    new VsopSet(              102.0,       2.61876256,      78.71375183  )
};

static final VsopSet UranusLatTerms1[] = {
    new VsopSet(           206366.0,       4.12394311,     74.781598567  ),
    new VsopSet(             8563.0,      0.338199862,    149.563197135  ),
    new VsopSet(             1726.0,        2.1219316,     73.297125859  ),
    new VsopSet(             1374.0,                0.0,                0.0  ),
    new VsopSet(             1369.0,       3.06861722,     76.266071276  ),
    new VsopSet(              451.0,       3.77656181,       1.48447271  ),
    new VsopSet(              400.0,       2.84767038,    224.344795702  ),
    new VsopSet(              307.0,       1.25456767,    148.078724426  ),
    new VsopSet(              154.0,       3.78575468,     63.735898303  ),
    new VsopSet(              112.0,       5.57299892,    151.047669843  ),
    new VsopSet(              111.0,       5.32888677,    138.517496871  ),
    new VsopSet(               83.0,       3.59152796,     71.812653151  ),
    new VsopSet(               56.0,       3.40135416,     85.827298831  ),
    new VsopSet(               54.0,        1.7045577,     77.750543984  ),
    new VsopSet(               42.0,       1.21476607,     11.045700264  ),
    new VsopSet(               41.0,       4.45476669,      78.71375183  ),
    new VsopSet(               32.0,       3.77446208,    222.860322994  ),
    new VsopSet(               30.0,       2.56371684,       2.96894542  ),
    new VsopSet(               27.0,         5.336955,    213.299095438  ),
    new VsopSet(               26.0,      0.416206284,     380.12776796  )
};

static final VsopSet UranusLatTerms2[] = {
    new VsopSet(             9212.0,       5.80044306,     74.781598567  ),
    new VsopSet(              557.0,                0.0,                0.0  ),
    new VsopSet(              286.0,       2.17729776,    149.563197135  ),
    new VsopSet(               95.0,        3.8423757,     73.297125859  ),
    new VsopSet(               45.0,       4.87822046,     76.266071276  ),
    new VsopSet(               20.0,       5.46264485,       1.48447271  ),
    new VsopSet(               15.0,      0.879837157,    138.517496871  ),
    new VsopSet(               14.0,       2.84517743,    148.078724426  ),
    new VsopSet(               14.0,       5.07234044,     63.735898303  ),
    new VsopSet(               10.0,       5.00290895,    224.344795702  ),
    new VsopSet(                8.0,       6.26655615,      78.71375183  )
};

static final VsopSet UranusLatTerms3[] = {
    new VsopSet(              268.0,       1.25097888,     74.781598567  ),
    new VsopSet(               11.0,       3.14159265,                0.0  ),
    new VsopSet(                6.0,       4.00663614,    149.563197135  ),
    new VsopSet(                3.0,       5.77804695,     73.297125859  )
};

static final VsopSet UranusLatTerms4[] = {
    new VsopSet(                6.0,       2.85499529,     74.781598567  )
};

static final VsopSet UranusLatTerms5[] = null;

static final VsopSet UranusRadTerms0[] = {
    new VsopSet(       1921264848.0,                0.0,                0.0  ),
    new VsopSet(         88784984.0,       5.60377527,     74.781598567  ),
    new VsopSet(          3440836.0,       0.32836099,     73.297125859  ),
    new VsopSet(          2055653.0,        1.7829517,    149.563197135  ),
    new VsopSet(           649322.0,       4.52247298,     76.266071276  ),
    new VsopSet(           602248.0,        3.8600382,     63.735898303  ),
    new VsopSet(           496404.0,       1.40139935,    454.909366527  ),
    new VsopSet(           338526.0,       1.58002683,    138.517496871  ),
    new VsopSet(           243508.0,       1.57086595,     71.812653151  ),
    new VsopSet(           190522.0,       1.99809365,       1.48447271  ),
    new VsopSet(           161858.0,       2.79137864,    148.078724426  ),
    new VsopSet(           143706.0,       1.38368575,     11.045700264  ),
    new VsopSet(            93192.0,      0.174371936,      36.64856293  ),
    new VsopSet(            89806.0,       3.66105366,    109.945688789  ),
    new VsopSet(            71424.0,       4.24509327,    224.344795702  ),
    new VsopSet(            46677.0,       1.39976564,     35.164090221  ),
    new VsopSet(            39026.0,       3.36234711,    277.034993741  ),
    new VsopSet(            39010.0,       1.66971129,     70.849445304  ),
    new VsopSet(            36755.0,       3.88648935,    146.594251718  ),
    new VsopSet(            30349.0,      0.701004463,    151.047669843  ),
    new VsopSet(            29156.0,       3.18056175,     77.750543984  ),
    new VsopSet(            25786.0,       3.78537742,     85.827298831  ),
    new VsopSet(            25620.0,       5.25656293,     380.12776796  ),
    new VsopSet(            22637.0,      0.725191377,    529.690965095  ),
    new VsopSet(            20473.0,       2.79639812,     70.328180442  ),
    new VsopSet(            20472.0,       1.55588961,    202.253395174  ),
    new VsopSet(            17901.0,      0.554554886,       2.96894542  ),
    new VsopSet(            15503.0,       5.35405038,     38.133035638  ),
    new VsopSet(            14702.0,       4.90434407,     108.46121608  ),
    new VsopSet(            12897.0,       2.62154018,    111.430161497  ),
    new VsopSet(            12328.0,       5.96039151,    127.471796607  ),
    new VsopSet(            11959.0,       1.75044072,    984.600331622  ),
    new VsopSet(            11853.0,      0.993428146,      52.69019804  ),
    new VsopSet(            11696.0,       3.29825599,       3.93215326  ),
    new VsopSet(            11495.0,      0.437740279,     65.220371012  ),
    new VsopSet(            10793.0,       1.42104859,    213.299095438  ),
    new VsopSet(             9111.0,         4.996386,     62.251425595  ),
    new VsopSet(             8421.0,       5.25350717,    222.860322994  ),
    new VsopSet(             8402.0,       5.03877516,    415.552490612  ),
    new VsopSet(             7449.0,       0.79491906,    351.816592309  ),
    new VsopSet(             7329.0,       3.97277528,    183.242814648  ),
    new VsopSet(             6046.0,       5.67960948,      78.71375183  ),
    new VsopSet(             5524.0,       3.11499484,       9.56122756  ),
    new VsopSet(             5445.0,       5.10575635,     145.10977901  ),
    new VsopSet(             5238.0,       2.62960142,     33.679617513  ),
    new VsopSet(             4079.0,       3.22064789,    340.770892045  ),
    new VsopSet(             3919.0,       4.25015289,     39.617508346  ),
    new VsopSet(             3802.0,       6.10985559,    184.727287356  ),
    new VsopSet(             3781.0,       3.45840273,    456.393839236  ),
    new VsopSet(             3687.0,       2.48718117,    453.424893819  ),
    new VsopSet(             3102.0,       4.14031064,    219.891377577  ),
    new VsopSet(             2963.0,       0.82977992,     56.622351303  ),
    new VsopSet(             2942.0,      0.423938089,    299.126394269  ),
    new VsopSet(             2940.0,        2.1463746,    137.033024162  ),
    new VsopSet(             2938.0,       3.67657451,    140.001969579  ),
    new VsopSet(             2865.0,      0.309969038,     12.530172972  ),
    new VsopSet(             2538.0,       4.85457832,     131.40394987  ),
    new VsopSet(             2364.0,      0.442533284,    554.069987483  ),
    new VsopSet(             2183.0,       2.94040432,    305.346169393  )
};

static final VsopSet UranusRadTerms1[] = {
    new VsopSet(          1479896.0,       3.67205705,     74.781598567  ),
    new VsopSet(            71212.0,       6.22601007,     63.735898303  ),
    new VsopSet(            68627.0,       6.13411265,    149.563197135  ),
    new VsopSet(            24060.0,       3.14159265,                0.0  ),
    new VsopSet(            21468.0,       2.60176704,     76.266071276  ),
    new VsopSet(            20857.0,       5.24625494,     11.045700264  ),
    new VsopSet(            11405.0,      0.018484616,     70.849445304  ),
    new VsopSet(             7497.0,      0.423600333,     73.297125859  ),
    new VsopSet(             4244.0,        1.4169235,     85.827298831  ),
    new VsopSet(             3927.0,       3.15513991,     71.812653151  ),
    new VsopSet(             3578.0,       2.31160668,    224.344795702  ),
    new VsopSet(             3506.0,       2.58354049,    138.517496871  ),
    new VsopSet(             3229.0,       5.25499603,       3.93215326  ),
    new VsopSet(             3060.0,      0.153218932,       1.48447271  ),
    new VsopSet(             2564.0,      0.980768464,    148.078724426  ),
    new VsopSet(             2429.0,       3.99440122,      52.69019804  ),
    new VsopSet(             1645.0,       2.65349313,    127.471796607  ),
    new VsopSet(             1584.0,       1.43045619,      78.71375183  ),
    new VsopSet(             1508.0,       5.05996325,    151.047669843  ),
    new VsopSet(             1490.0,       2.67559167,     56.622351303  ),
    new VsopSet(             1413.0,       4.57461892,    202.253395174  ),
    new VsopSet(             1403.0,        1.3698535,     77.750543984  ),
    new VsopSet(             1228.0,        1.0470364,     62.251425595  ),
    new VsopSet(             1033.0,       0.26459059,     131.40394987  ),
    new VsopSet(              992.0,       2.17168866,     65.220371012  ),
    new VsopSet(              862.0,       5.05530802,    351.816592309  ),
    new VsopSet(              744.0,       3.07640149,     35.164090221  ),
    new VsopSet(              687.0,       2.49912566,     77.962992305  ),
    new VsopSet(              647.0,       4.47290423,     70.328180442  ),
    new VsopSet(              624.0,      0.862530738,       9.56122756  ),
    new VsopSet(              604.0,       0.90717668,    984.600331622  ),
    new VsopSet(              575.0,       3.23070709,    447.795819527  ),
    new VsopSet(              562.0,       2.71778159,    462.022913528  ),
    new VsopSet(              530.0,       5.91655309,    213.299095438  ),
    new VsopSet(              528.0,       5.15136007,       2.96894542  )
};

static final VsopSet UranusRadTerms2[] = {
    new VsopSet(            22440.0,      0.699531188,     74.781598567  ),
    new VsopSet(             4727.0,       1.69901642,     63.735898303  ),
    new VsopSet(             1682.0,       4.64833552,     70.849445304  ),
    new VsopSet(             1650.0,       3.09660079,     11.045700264  ),
    new VsopSet(             1434.0,       3.52119918,    149.563197135  ),
    new VsopSet(              770.0,                0.0,                0.0  ),
    new VsopSet(              500.0,       6.17229032,     76.266071276  ),
    new VsopSet(              461.0,      0.766766328,       3.93215326  ),
    new VsopSet(              390.0,       4.49605284,     56.622351303  ),
    new VsopSet(              390.0,       5.52673426,     85.827298831  ),
    new VsopSet(              292.0,      0.203890121,      52.69019804  ),
    new VsopSet(              287.0,       3.53357683,     73.297125859  ),
    new VsopSet(              273.0,       3.84707824,    138.517496871  ),
    new VsopSet(              220.0,       1.96418943,     131.40394987  ),
    new VsopSet(              216.0,      0.848124742,     77.962992305  ),
    new VsopSet(              205.0,       3.24758017,      78.71375183  ),
    new VsopSet(              149.0,       4.89840864,    127.471796607  ),
    new VsopSet(              129.0,        2.0814685,       3.18139374  )
};

static final VsopSet UranusRadTerms3[] = {
    new VsopSet(             1164.0,       4.73453292,     74.781598567  ),
    new VsopSet(              212.0,       3.34255735,     63.735898303  ),
    new VsopSet(              196.0,       2.98004616,     70.849445304  ),
    new VsopSet(              105.0,      0.958079376,     11.045700264  ),
    new VsopSet(               73.0,      0.997019079,    149.563197135  ),
    new VsopSet(               72.0,      0.025284557,     56.622351303  ),
    new VsopSet(               55.0,       2.59436811,       3.93215326  ),
    new VsopSet(               36.0,       5.65035573,     77.962992305  ),
    new VsopSet(               34.0,       3.81553326,     76.266071276  ),
    new VsopSet(               32.0,       3.59825178,     131.40394987  )
};

static final VsopSet UranusRadTerms4[] = {
    new VsopSet(               53.0,       3.00838033,     74.781598567  ),
    new VsopSet(               10.0,       1.91399084,     56.622351303  )
};

static final VsopSet UranusRadTerms5[] = null;

// Uranus TermTable
static final VsopTerms[] UranusLonTerms = {
  new VsopTerms( UranusLonTerms0Rows, UranusLonTerms0 ),
  new VsopTerms( UranusLonTerms1Rows, UranusLonTerms1 ),
  new VsopTerms( UranusLonTerms2Rows, UranusLonTerms2 ),
  new VsopTerms( UranusLonTerms3Rows, UranusLonTerms3 ),
  new VsopTerms( UranusLonTerms4Rows, UranusLonTerms4 ),
  new VsopTerms( UranusLonTerms5Rows, UranusLonTerms5 )
};

static final VsopTerms[] UranusLatTerms = {
  new VsopTerms( UranusLatTerms0Rows, UranusLatTerms0 ),
  new VsopTerms( UranusLatTerms1Rows, UranusLatTerms1 ),
  new VsopTerms( UranusLatTerms2Rows, UranusLatTerms2 ),
  new VsopTerms( UranusLatTerms3Rows, UranusLatTerms3 ),
  new VsopTerms( UranusLatTerms4Rows, UranusLatTerms4 ),
  new VsopTerms( UranusLatTerms5Rows, UranusLatTerms5 )
};

static final VsopTerms[] UranusRadTerms = {
  new VsopTerms( UranusRadTerms0Rows, UranusRadTerms0 ),
  new VsopTerms( UranusRadTerms1Rows, UranusRadTerms1 ),
  new VsopTerms( UranusRadTerms2Rows, UranusRadTerms2 ),
  new VsopTerms( UranusRadTerms3Rows, UranusRadTerms3 ),
  new VsopTerms( UranusRadTerms4Rows, UranusRadTerms4 ),
  new VsopTerms( UranusRadTerms5Rows, UranusRadTerms5 )
};

// Neptune Terms
static final int NeptuneLonTerms0Rows = 38;
static final int NeptuneLonTerms1Rows = 18;
static final int NeptuneLonTerms2Rows = 7;
static final int NeptuneLonTerms3Rows = 4;
static final int NeptuneLonTerms4Rows = 1;
static final int NeptuneLonTerms5Rows = 0;

static final int NeptuneLatTerms0Rows = 17;
static final int NeptuneLatTerms1Rows = 13;
static final int NeptuneLatTerms2Rows = 6;
static final int NeptuneLatTerms3Rows = 4;
static final int NeptuneLatTerms4Rows = 1;
static final int NeptuneLatTerms5Rows = 0;

static final int NeptuneRadTerms0Rows = 32;
static final int NeptuneRadTerms1Rows = 15;
static final int NeptuneRadTerms2Rows = 5;
static final int NeptuneRadTerms3Rows = 1;
static final int NeptuneRadTerms4Rows = 0;
static final int NeptuneRadTerms5Rows = 0;

static final VsopSet NeptuneLonTerms0[] = {
    new VsopSet(        531188633.0,              0.0,              0.0  ),
    new VsopSet(          1798476.0,       2.90101273,     38.133035638  ),
    new VsopSet(          1019728.0,      0.485809237,       1.48447271  ),
    new VsopSet(           124532.0,       4.83008091,      36.64856293  ),
    new VsopSet(            42064.0,       5.41054992,       2.96894542  ),
    new VsopSet(            37715.0,       6.09221835,     35.164090221  ),
    new VsopSet(            33785.0,       1.24488866,     76.266071276  ),
    new VsopSet(            16483.0,      7.7293e-005,    491.557929457  ),
    new VsopSet(             9199.0,        4.9374706,     39.617508346  ),
    new VsopSet(             8994.0,      0.274621426,      175.1660598  ),
    new VsopSet(             4216.0,       1.98711914,     73.297125859  ),
    new VsopSet(             3365.0,       1.03590122,     33.679617513  ),
    new VsopSet(             2285.0,       4.20606933,       4.45341812  ),
    new VsopSet(             1434.0,       2.78340433,     74.781598567  ),
    new VsopSet(              900.0,       2.07606702,    109.945688789  ),
    new VsopSet(              745.0,        3.1903253,     71.812653151  ),
    new VsopSet(              506.0,        5.7478537,    114.399106913  ),
    new VsopSet(              400.0,      0.349723426,   1021.248894551  ),
    new VsopSet(              345.0,        3.4618621,     41.101981054  ),
    new VsopSet(              340.0,         3.303699,     77.750543984  ),
    new VsopSet(              323.0,       2.24815189,     32.195144805  ),
    new VsopSet(              306.0,      0.496840399,      0.521264862  ),
    new VsopSet(              287.0,       4.50523446,       0.04818411  ),
    new VsopSet(              282.0,        2.2456558,    146.594251718  ),
    new VsopSet(              267.0,        4.8893261,      0.963207847  ),
    new VsopSet(              252.0,       5.78166597,    388.465155238  ),
    new VsopSet(              245.0,       1.24693338,       9.56122756  ),
    new VsopSet(              233.0,       2.50459795,    137.033024162  ),
    new VsopSet(              227.0,       1.79713054,    453.424893819  ),
    new VsopSet(              170.0,       3.32390631,     108.46121608  ),
    new VsopSet(              151.0,       2.19153094,     33.940249944  ),
    new VsopSet(              150.0,        2.9970611,       5.93789083  ),
    new VsopSet(              148.0,      0.859489861,    111.430161497  ),
    new VsopSet(              119.0,       3.67706204,       2.44768055  ),
    new VsopSet(              109.0,       2.41599378,    183.242814648  ),
    new VsopSet(              103.0,      0.040789667,      0.260632431  ),
    new VsopSet(              103.0,       4.40441222,     70.328180442  ),
    new VsopSet(              102.0,       5.70539237,      0.111874585  )
};

static final VsopSet NeptuneLonTerms1[] = {
    new VsopSet(       3837687717.0,                0.0,                0.0  ),
    new VsopSet(            16604.0,        4.8631913,       1.48447271  ),
    new VsopSet(            15807.0,       2.27923489,     38.133035638  ),
    new VsopSet(             3335.0,       3.68199676,     76.266071276  ),
    new VsopSet(             1306.0,       3.67320813,       2.96894542  ),
    new VsopSet(              605.0,       1.50477748,     35.164090221  ),
    new VsopSet(              179.0,       3.45318524,     39.617508346  ),
    new VsopSet(              107.0,       2.45126138,       4.45341812  ),
    new VsopSet(              106.0,       2.75479327,     33.679617513  ),
    new VsopSet(               73.0,       5.48724733,      36.64856293  ),
    new VsopSet(               57.0,       1.85767603,    114.399106913  ),
    new VsopSet(               57.0,       5.21649805,      0.521264862  ),
    new VsopSet(               35.0,       4.51676828,     74.781598567  ),
    new VsopSet(               32.0,        5.9041149,     77.750543984  ),
    new VsopSet(               30.0,       3.67043294,    388.465155238  ),
    new VsopSet(               29.0,       5.16877529,       9.56122756  ),
    new VsopSet(               29.0,       5.16732589,       2.44768055  ),
    new VsopSet(               26.0,       5.24526282,    168.052512799  )
};

static final VsopSet NeptuneLonTerms2[] = {
    new VsopSet(            53893.0,                0.0,                0.0  ),
    new VsopSet(              296.0,       1.85520292,       1.48447271  ),
    new VsopSet(              281.0,       1.19084539,     38.133035638  ),
    new VsopSet(              270.0,       5.72143228,     76.266071276  ),
    new VsopSet(               23.0,       1.21035597,       2.96894542  ),
    new VsopSet(                9.0,       4.42544992,     35.164090221  ),
    new VsopSet(                7.0,      0.540333068,       2.44768055  )
};

static final VsopSet NeptuneLonTerms3[] = {
    new VsopSet(               31.0,                0.0,                0.0  ),
    new VsopSet(               15.0,       1.35337076,     76.266071276  ),
    new VsopSet(               12.0,       6.04431419,       1.48447271  ),
    new VsopSet(               12.0,       6.11257808,     38.133035638  )
};

static final VsopSet NeptuneLonTerms4[] = {
    new VsopSet(              114.0,       3.14159265,                0.0  )
};

static final VsopSet NeptuneLonTerms5[] = null;

static final VsopSet NeptuneLatTerms0[] = {
    new VsopSet(          3088623.0,       1.44104373,     38.133035638  ),
    new VsopSet(            27780.0,       5.91271883,     76.266071276  ),
    new VsopSet(            27624.0,                0.0,                0.0  ),
    new VsopSet(            15448.0,       3.50877081,     39.617508346  ),
    new VsopSet(            15355.0,       2.52123799,      36.64856293  ),
    new VsopSet(             2000.0,        1.5099867,     74.781598567  ),
    new VsopSet(             1968.0,       4.37778196,       1.48447271  ),
    new VsopSet(             1015.0,       3.21561036,     35.164090221  ),
    new VsopSet(              606.0,       2.80246601,     73.297125859  ),
    new VsopSet(              595.0,       2.12892708,     41.101981054  ),
    new VsopSet(              589.0,       3.18655883,       2.96894542  ),
    new VsopSet(              402.0,       4.16883287,    114.399106913  ),
    new VsopSet(              280.0,        1.6816531,     77.750543984  ),
    new VsopSet(              262.0,       3.76722705,    213.299095438  ),
    new VsopSet(              254.0,       3.27120499,    453.424893819  ),
    new VsopSet(              206.0,       4.25652349,    529.690965095  ),
    new VsopSet(              140.0,       3.52969556,    137.033024162  )
};

static final VsopSet NeptuneLatTerms1[] = {
    new VsopSet(           227279.0,        3.8079309,     38.133035638  ),
    new VsopSet(             1803.0,       1.97576485,     76.266071276  ),
    new VsopSet(             1433.0,       3.14159265,                0.0  ),
    new VsopSet(             1386.0,       4.82555548,      36.64856293  ),
    new VsopSet(             1073.0,       6.08054241,     39.617508346  ),
    new VsopSet(              148.0,       3.85766231,     74.781598567  ),
    new VsopSet(              136.0,      0.477649573,       1.48447271  ),
    new VsopSet(               70.0,       6.18782052,     35.164090221  ),
    new VsopSet(               52.0,       5.05221792,     73.297125859  ),
    new VsopSet(               43.0,      0.307217372,    114.399106913  ),
    new VsopSet(               37.0,       4.89476629,     41.101981054  ),
    new VsopSet(               37.0,       5.75999349,       2.96894542  ),
    new VsopSet(               26.0,       5.21566336,    213.299095438  )
};

static final VsopSet NeptuneLatTerms2[] = {
    new VsopSet(             9691.0,        5.5712375,     38.133035638  ),
    new VsopSet(               79.0,       3.62705474,     76.266071276  ),
    new VsopSet(               72.0,      0.454766886,      36.64856293  ),
    new VsopSet(               59.0,       3.14159265,                0.0  ),
    new VsopSet(               30.0,       1.60671722,     39.617508346  ),
    new VsopSet(                6.0,       5.60736757,     74.781598567  )
};

static final VsopSet NeptuneLatTerms3[] = {
    new VsopSet(              273.0,       1.01688979,     38.133035638  ),
    new VsopSet(                2.0,                0.0,                0.0  ),
    new VsopSet(                2.0,       2.36805657,      36.64856293  ),
    new VsopSet(                2.0,       5.33364321,     76.266071276  )
};

static final VsopSet NeptuneLatTerms4[] = {
    new VsopSet(                6.0,       2.66872693,     38.133035638  )
};

static final VsopSet NeptuneLatTerms5[] = null;

static final VsopSet NeptuneRadTerms0[] = {
    new VsopSet(       3007013206.0,                0.0,                0.0  ),
    new VsopSet(         27062259.0,       1.32999459,     38.133035638  ),
    new VsopSet(          1691764.0,       3.25186139,      36.64856293  ),
    new VsopSet(           807831.0,       5.18592836,       1.48447271  ),
    new VsopSet(           537761.0,       4.52113903,     35.164090221  ),
    new VsopSet(           495726.0,       1.57105655,    491.557929457  ),
    new VsopSet(           274572.0,       1.84552257,      175.1660598  ),
    new VsopSet(           135134.0,       3.37220607,     39.617508346  ),
    new VsopSet(           121802.0,       5.79754444,     76.266071276  ),
    new VsopSet(           100895.0,      0.377027487,     73.297125859  ),
    new VsopSet(            69792.0,       3.79617227,       2.96894542  ),
    new VsopSet(            46688.0,        5.7493781,     33.679617513  ),
    new VsopSet(            24594.0,      0.508017282,    109.945688789  ),
    new VsopSet(            16939.0,       1.59422167,     71.812653151  ),
    new VsopSet(            14230.0,       1.07786113,     74.781598567  ),
    new VsopSet(            12012.0,       1.92062132,   1021.248894551  ),
    new VsopSet(             8395.0,      0.678168955,    146.594251718  ),
    new VsopSet(             7572.0,       1.07149263,    388.465155238  ),
    new VsopSet(             5721.0,       2.59059512,       4.45341812  ),
    new VsopSet(             4840.0,       1.90685991,     41.101981054  ),
    new VsopSet(             4483.0,       2.90573457,    529.690965095  ),
    new VsopSet(             4421.0,       1.74993797,     108.46121608  ),
    new VsopSet(             4354.0,      0.679856624,     32.195144805  ),
    new VsopSet(             4270.0,       3.41343866,    453.424893819  ),
    new VsopSet(             3381.0,      0.848106833,    183.242814648  ),
    new VsopSet(             2881.0,       1.98600105,    137.033024162  ),
    new VsopSet(             2879.0,       3.67415902,      350.3321196  ),
    new VsopSet(             2636.0,       3.09755943,    213.299095438  ),
    new VsopSet(             2530.0,       5.79839567,    490.073456749  ),
    new VsopSet(             2523.0,         0.486308,    493.042402165  ),
    new VsopSet(             2306.0,       2.80962936,     70.328180442  ),
    new VsopSet(             2087.0,      0.618583783,     33.940249944  )
};

static final VsopSet NeptuneRadTerms1[] = {
    new VsopSet(           236339.0,      0.704980112,     38.133035638  ),
    new VsopSet(            13220.0,         3.320155,       1.48447271  ),
    new VsopSet(             8622.0,       6.21628952,     35.164090221  ),
    new VsopSet(             2702.0,       1.88140667,     39.617508346  ),
    new VsopSet(             2155.0,       2.09431198,       2.96894542  ),
    new VsopSet(             2153.0,       5.16873841,     76.266071276  ),
    new VsopSet(             1603.0,                0.0,                0.0  ),
    new VsopSet(             1464.0,       1.18417031,     33.679617513  ),
    new VsopSet(             1136.0,         3.918912,      36.64856293  ),
    new VsopSet(              898.0,       5.24122933,    388.465155238  ),
    new VsopSet(              790.0,      0.533154846,    168.052512799  ),
    new VsopSet(              760.0,      0.020510336,    182.279606801  ),
    new VsopSet(              607.0,         1.077065,   1021.248894551  ),
    new VsopSet(              572.0,       3.40060785,    484.444382456  ),
    new VsopSet(              561.0,       2.88685816,    498.671476458  )
};

static final VsopSet NeptuneRadTerms2[] = {
    new VsopSet(             4247.0,       5.89910679,     38.133035638  ),
    new VsopSet(              218.0,      0.345818291,       1.48447271  ),
    new VsopSet(              163.0,       2.23872947,    168.052512799  ),
    new VsopSet(              156.0,       4.59414467,    182.279606801  ),
    new VsopSet(              127.0,       2.84786298,     35.164090221  )
};

static final VsopSet NeptuneRadTerms3[] = {
    new VsopSet(              166.0,       4.55243893,     38.133035638  )
};

static final VsopSet NeptuneRadTerms4[] = null;

static final VsopSet NeptuneRadTerms5[] = null;

// Neptune TermTable
static final VsopTerms[] NeptuneLonTerms = {
  new VsopTerms( NeptuneLonTerms0Rows, NeptuneLonTerms0 ),
  new VsopTerms( NeptuneLonTerms1Rows, NeptuneLonTerms1 ),
  new VsopTerms( NeptuneLonTerms2Rows, NeptuneLonTerms2 ),
  new VsopTerms( NeptuneLonTerms3Rows, NeptuneLonTerms3 ),
  new VsopTerms( NeptuneLonTerms4Rows, NeptuneLonTerms4 ),
  new VsopTerms( NeptuneLonTerms5Rows, NeptuneLonTerms5 )
};

static final VsopTerms[] NeptuneLatTerms = {
  new VsopTerms( NeptuneLatTerms0Rows, NeptuneLatTerms0 ),
  new VsopTerms( NeptuneLatTerms1Rows, NeptuneLatTerms1 ),
  new VsopTerms( NeptuneLatTerms2Rows, NeptuneLatTerms2 ),
  new VsopTerms( NeptuneLatTerms3Rows, NeptuneLatTerms3 ),
  new VsopTerms( NeptuneLatTerms4Rows, NeptuneLatTerms4 ),
  new VsopTerms( NeptuneLatTerms5Rows, NeptuneLatTerms5 )
};

static final VsopTerms[] NeptuneRadTerms = {
  new VsopTerms( NeptuneRadTerms0Rows, NeptuneRadTerms0 ),
  new VsopTerms( NeptuneRadTerms1Rows, NeptuneRadTerms1 ),
  new VsopTerms( NeptuneRadTerms2Rows, NeptuneRadTerms2 ),
  new VsopTerms( NeptuneRadTerms3Rows, NeptuneRadTerms3 ),
  new VsopTerms( NeptuneRadTerms4Rows, NeptuneRadTerms4 ),
  new VsopTerms( NeptuneRadTerms5Rows, NeptuneRadTerms5 )
};

};              // end class VsopTerms
