/* testImplementingSelectionSort Class
 * 
 * Create test cases for ImplementingSelectionSort class
 * 
 * Developer: Keith Kretz
 * Date Created: 8/20/2024
 * Last Updated: 8/20/2024
 */
package SelectionSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testSortAlgorithm {

	@Test
	void testImplementingSelectionSort() {
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(1.1);
		list.add(3.3);
		list.add(2.2);
		list.add(5.5);
		list.add(4.4);
		
		SortAlgorithm iss = new SortAlgorithm(list);

		for(double d : iss.getList())
			System.err.println(d);
	}

}

