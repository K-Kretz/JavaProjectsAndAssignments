package SortingAtScale;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testDifferentSorters {

//	@Test
//	void testSortWithCompareTo() {
//		DifferentSorters ds = new DifferentSorters();
//		ds.sortWithCompareTo();
//	}
//	@Test
//	void testsorByTitleAndDepth() {
//		DifferentSorters ds = new DifferentSorters();
//		ds.sorByTitleAndDepth();
//	}
	@Test
	void testsortByLastWordInTitleThenByMagnitude() {
		DifferentSorters ds = new DifferentSorters();
		ds.sortByLastWordInTitleThenByMagnitude();
	}

//	@Test
//	void testSortByMagnitude() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSortByDistance() {
//		fail("Not yet implemented"); // TODO
//	}

}
