package SelectionSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testQuakeSortInPlace {

//	@Test
//	void testSortByLargestDepth() {
//		QuakeSortInPlace qsip = new QuakeSortInPlace();
//		
//		EarthQuakeParser parser = new EarthQuakeParser();
//		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\earthQuakeDataDec6sample1.atom";
//		
//		ArrayList<QuakeEntry> list = parser.read(source);
//		
//		qsip.sortByLargestDepth(list);
//	}
	@Test
	void testOnePassBubbleSort() {
		QuakeSortInPlace qsip = new QuakeSortInPlace();
		
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\earthQuakeDataDec6sample1.atom";
		
		ArrayList<QuakeEntry> list = parser.read(source);
		
		qsip.sortByMagnitudeWithBubbleSortWithCheck(list);
		
	}
//	@Test
//	void testSortByMagnitudeWithCheck() {
//		QuakeSortInPlace qsip = new QuakeSortInPlace();
//		
//		EarthQuakeParser parser = new EarthQuakeParser();
//		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\earthQuakeDataDec6sample1.atom";
//		
//		ArrayList<QuakeEntry> list = parser.read(source);
//		
//		qsip.sortByMagnitudeWithCheck(list);
//	}

}
