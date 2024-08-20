package SearchingEarthQuakeInterfaces;

public interface Filter {
	
	public boolean satisfies(QuakeEntry entry);
	
	public String getName();

}
