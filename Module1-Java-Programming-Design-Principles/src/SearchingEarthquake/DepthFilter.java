package SearchingEarthquake;

public class DepthFilter implements Filter {
	
	private double min;
	private double max;
	
	public DepthFilter(double minDepth, double maxDepth) {
		
		min = minDepth;
		max = maxDepth;
	}

	@Override
	public boolean satisfies(QuakeEntry entry) {
		return (entry.getDepth()>=min &&entry.getDepth()<=max);
	}

}
