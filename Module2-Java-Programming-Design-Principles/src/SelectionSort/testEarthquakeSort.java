package SelectionSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testEarthquakeSort {

	@Test
	void testGetSmallestMag() {
		EarthQuakeParser parser = new EarthQuakeParser();
		
		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\earthQuakeDataDec6sample2.atom";
		
		ArrayList<QuakeEntry> list = parser.read(source);
		
		QuakeSortInPlace es = new QuakeSortInPlace();
		
		es.sortByMagnitudeWithBubbleSortWithCheck(list);
		
		for(QuakeEntry entry : list)
			System.out.println(entry);
	}

}
