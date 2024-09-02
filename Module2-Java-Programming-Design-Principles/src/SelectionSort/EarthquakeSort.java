/* EarthquakeSort Class
 * 
 * Sort EarthquakeEntries
 * 
 * Developer: Keith Kretz
 * Date Created: 8/20/2024
 * Last Updated: 8/20/2024
 */
package SelectionSort;

import java.util.ArrayList;

/**
 * 
 */
public class EarthquakeSort {

	public int getSmallestMagIndex(ArrayList<QuakeEntry> list, int from) {
		
		int minIndex = from;
		
		for(int i = from+1; i<list.size(); i++)
		{
			if(list.get(i).getMagnitude() < list.get(minIndex).getMagnitude())
				minIndex = i;
		}
		
		return minIndex;
	}
	
	public void getSmallestMag(ArrayList<QuakeEntry> list){
		
		ArrayList<QuakeEntry> outList = new ArrayList<QuakeEntry>();
		
		for(int i=0; i<list.size(); i++)
		{
			int smallIndex = getSmallestMagIndex(list, i);
			
			QuakeEntry qi = list.get(i);
			QuakeEntry qMin = list.get(smallIndex);
			
			list.set(i, qMin);
			list.set(smallIndex, qi);
		}
		
		

	}
	
}
