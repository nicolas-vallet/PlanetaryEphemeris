import com.mhuss.AstroLib.DateOps;
import com.mhuss.AstroLib.Latitude;
import com.mhuss.AstroLib.Longitude;
import com.mhuss.AstroLib.NoInitException;
import com.mhuss.AstroLib.ObsInfo;
import com.mhuss.AstroLib.PlanetData;
import com.mhuss.AstroLib.Planets;
import com.mhuss.AstroLib.TimeOps;

public class TestEphemeris {

	public static void main(String[] args) throws NoInitException {
		long jd = DateOps.nowToDay();
		ObsInfo observatory = new ObsInfo(new Latitude(2), new Longitude(49), TimeOps.tzOffset());
		PlanetData engine = new PlanetData(Planets.SATURN, jd, observatory);
		System.out.println("Saturne: RA="+((Math.toDegrees(engine.getRightAscension())/15)+24)+" / DEC="+Math.toDegrees(engine.getDeclination()));
	}
}
