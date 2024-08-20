/* ImplementingSelectionSort Class
 * 
 * Implementing a Simple Selection Sort
 * 
 * Developer: Keith Kretz
 * Date Created: 8/20/2024
 * Last Updated: 8/20/2024
 */

package SelectionSort;

import java.util.ArrayList;

public class ImplementingSelectionSort {
	
private ArrayList<Double> outList = new ArrayList<Double>();	
	
public ImplementingSelectionSort(ArrayList<Double> inList){
	
	while(!inList.isEmpty()) 
	{
		double minElement = getSmallest(inList);
		inList.remove(minElement);
		outList.add(minElement);
	}
}

private double getSmallest(ArrayList<Double> list) {
	
	double min = list.get(0);
	for(double n : list)
	{
		if(n < min)
			min = n;
	}
	
	return min;
}

public ArrayList<Double> getList(){
	
	return outList;
}

}
