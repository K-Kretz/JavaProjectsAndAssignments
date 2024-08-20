package SearchingEarthQuakeInterfaces;

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

	@Override
	public String getName() {
		
		return "MagnitudeFilter";
	}
	
}
