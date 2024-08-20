package SearchingEarthQuakeInterfaces;

import java.util.ArrayList;

public class MatchAllFilter implements Filter {

	private ArrayList<Filter> filters;
	
	public MatchAllFilter() {
		filters = new ArrayList<Filter>();
	}
	
	public void addFilter(Filter f) {	
		filters.add(f);
	}
	
	@Override
	public boolean satisfies(QuakeEntry entry) {
		for(Filter f : filters)
		{
			if(!f.satisfies(entry))
			{
				return false;
			}
		}	
		return true;	
	}

	@Override
	public String getName() {
		String name ="";
		for(Filter f : filters)
			name = name + " " + f.getName();
	
		return "Filters used: " + name;
	}
}
