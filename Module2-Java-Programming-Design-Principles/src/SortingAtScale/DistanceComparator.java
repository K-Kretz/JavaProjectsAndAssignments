package SortingAtScale;

import java.util.Comparator;

public class DistanceComparator implements Comparator<QuakeEntry> {
	
	Location fromWhere;
	
	public DistanceComparator(Location where) {
		fromWhere = where;
	}

	@Override
	public int compare(QuakeEntry q1, QuakeEntry q2) {
		return Double.compare(q1.getLocation().distanceTo(fromWhere), q2.getLocation().distanceTo(fromWhere));
	}

}
