package SearchingEarthquake;

public class MagnitudeFilter implements Filter{

	private double minMag;
	private double maxMag;
	
	public MagnitudeFilter(double minM, double maxM) {
		
		minMag = minM;
		maxMag = maxM;	
	}
	
	
	@Override
	public boolean satisfies(QuakeEntry entry) {
		return (entry.getMagnitude()>=minMag && entry.getMagnitude()<=maxMag);
	}

}
