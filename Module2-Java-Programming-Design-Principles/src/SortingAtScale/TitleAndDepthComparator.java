package SortingAtScale;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {

	@Override
	public int compare(QuakeEntry o1, QuakeEntry o2) {
		
		if(o1.getInfo().compareTo(o2.getInfo()) < 0)
			return -1;
		if(o1.getInfo().compareTo(o2.getInfo()) > 0)
			return 1;
		
		return Double.compare(o1.getDepth(), o2.getDepth());
	}

}
