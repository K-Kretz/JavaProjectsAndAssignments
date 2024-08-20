/**
 * EarthQuakeClientTest Class
 * 
 * Tests for EarthQuakeClient.java methods
 * 
 * Developer: Keith Kretz
 * Date Created: 8/8/2024
 * Last Updated: 8/14/2024 
 */
package SearchingEarthQuakeInterfaces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class EarthQuakeClientTest {

//	@Test
//	void testQuakesWithFilter() {
//		System.out.println("Testing QuakesWithFilter() Method: ");
//		EarthQuakeClient2 eqc = new EarthQuakeClient2();
//		eqc.quakesWithFilter();
//	}
	
	@Test
	void testMatchAllFilter2 () {
		System.out.println("Testing matchAllFilter2() Method: ");
		EarthQuakeClient2 eqc = new EarthQuakeClient2();
		eqc.matchAllFilter2();
	}
//	@Test
//	void testMatchAllFilter () {
//		System.out.println("Testing matchAllFilter() Method: ");
//		EarthQuakeClient2 eqc = new EarthQuakeClient2();
//		eqc.matchAllFilter();
//	}

}
