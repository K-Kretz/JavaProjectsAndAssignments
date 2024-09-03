package SortingAtScale;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {

	@Override
	public int compare(QuakeEntry o1, QuakeEntry o2) {
		

		String[] titleArray1 = o1.getInfo().split("\\s+");
		String[] titleArray2 = o2.getInfo().split("\\s+");
		
		if(titleArray1[titleArray1.length-1].compareTo(titleArray2[titleArray2.length-1]) < 0)
			return -1;
		if(titleArray1[titleArray1.length-1].compareTo(titleArray2[titleArray2.length-1]) > 0)
			return 1;
		
		return Double.compare(o1.getMagnitude(), o2.getMagnitude());
	}

}
