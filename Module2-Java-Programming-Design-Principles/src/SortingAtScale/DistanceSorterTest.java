package SortingAtScale;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class DistanceSorterTest {

	@Test
	void testCompare() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\nov20quakedata.atom";		
		ArrayList<QuakeEntry> list = parser.read(source);
		Location where = new Location(35.9886, -78.9072);
		
		Collections.sort(list, new DistanceComparator(where));
		
		for(QuakeEntry qe: list)
		{
			System.out.println(qe);
		}
	}

}
