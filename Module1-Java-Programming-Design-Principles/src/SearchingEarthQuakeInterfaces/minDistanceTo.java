package SearchingEarthQuakeInterfaces;

public class minDistanceTo implements Filter {

	private Location myLoc;
	private double maxDist;
	
	public minDistanceTo(Location loc, double max) {
	
		myLoc = loc;
		maxDist = max;
	}
	@Override
	public boolean satisfies(QuakeEntry entry) {
		return (entry.getLocation().distanceTo(myLoc) < maxDist);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
