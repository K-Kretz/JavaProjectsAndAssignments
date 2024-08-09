/**
 * EarthQuakeClientTest Class
 * 
 * Tests for EarthQuakeClient.java methods
 * 
 * Developer: Keith Kretz
 * Date Created: 8/8/2024
 * Last Updated: 8/8/2024 
 */
package SearchingEarthquake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class EarthQuakeClientTest {

	/**
	 * Test method for 
	 */
	@Test
	void testFilterByMagnitude() {
		//("Not yet implemented"); // TODO
	}

	/**
	 * Test method for 
	 */
	@Test
	void testFilterByDistanceFrom() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for 
	 */
//	@Test
//	void testDumpCSV() {
//		System.out.println("Testing testDumpCSV() Method: ");
//		EarthQuakeClient eqc = new EarthQuakeClient();
//		eqc.createCSV();
//	}

	/**
	 * Test method for 
	 */
//	@Test
//	void testBigQuakes() {
//		System.out.println("Testing bigQuakes() Method: ");
//		EarthQuakeClient eqc = new EarthQuakeClient();
//		eqc.bigQuakes();
//	}

	/**
	 * Test method for 
	 */
	@Test
	void testCreateCSV() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for 
	 */
	@Test
	void testCloseToMe() {
		//fail("Not yet implemented"); // TODO
	}
	@Test
	void findCloseQuakes() {
		System.out.println("Testing findCloseQuakes() Method: ");
		EarthQuakeClient eqc = new EarthQuakeClient();
		eqc.findCloseQuakes();
	}

}
