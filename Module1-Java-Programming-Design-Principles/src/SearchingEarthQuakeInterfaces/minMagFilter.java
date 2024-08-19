package SearchingEarthQuakeInterfaces;

public class minMagFilter implements Filter {

	private double minMag;
	
	public minMagFilter(double min) {
		minMag = min;
	}
	
	@Override
	public boolean satisfies(QuakeEntry entry) {
		
		return entry.getMagnitude() >= minMag;
	}
}
