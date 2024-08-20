package SearchingEarthQuakeInterfaces;

public class DistanceFilter implements Filter{

	private double maxDist;
	private Location loc;
	
	public DistanceFilter(double maxD, Location l) {
		maxDist = maxD;
		loc = l;
	}
	
	@Override
	public boolean satisfies(QuakeEntry entry) {
		return (entry.getLocation().distanceTo(loc)<maxDist);
	}
	
	@Override
	public String getName() {
		
		return "DistanceFilter";
	}

}
