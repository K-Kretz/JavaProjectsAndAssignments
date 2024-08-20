package SearchingEarthQuakeInterfaces;

public class MinMagFilter implements Filter {

	private double minMag;
	
	public MinMagFilter(double min) {
		minMag = min;
	}
	
	@Override
	public boolean satisfies(QuakeEntry entry) {
		
		return entry.getMagnitude() >= minMag;
	}
	
	@Override
	public String getName() {
		
		return "MinMagFilter";
	}
}
