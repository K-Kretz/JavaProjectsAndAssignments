package SearchingEarthquake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testLargestQuakes {

	@Test
	void testFindLargestQuakes() {
		System.out.println("Testing testDumpCSV() Method: ");
		LargestQuakes lq = new LargestQuakes();
		lq.findLargestQuakes();
	}

}
