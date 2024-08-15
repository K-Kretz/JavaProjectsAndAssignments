/**
 * LargestQuakes Class
 * 
 * Determine the N biggest earthquakes, those with largest magnitude.
 * 
 * Developer: Keith Kretz
 * Date Created: 8/8/2024
 * Last Updated: 8/14/2024  
 */



package SearchingEarthquake;

import java.util.*;

public class LargestQuakes {
	
	public void findLargestQuakes(){
		
		EarthQuakeParser parser = new EarthQuakeParser();
		
		String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module1-Java-Programming-Design-Principles\\src\\data\\nov20quakedata.atom";
		
		ArrayList<QuakeEntry> list = parser.read(source);
		
//		for(QuakeEntry entry: list)
//		{
//			System.out.println(entry);
//		}
//		System.out.println("found "+list.size()+" quakes");
		
		int indexLargest = indexOfLargest(list);
		
		System.out.println("Largest Quake index is "+indexLargest);
		
		ArrayList<QuakeEntry> largestList = getLargest(list,5);
		for(QuakeEntry entry : largestList)
		{
			System.out.println(entry);
		}
	}
	
	
	public int indexOfLargest(ArrayList<QuakeEntry> quakeData) {
		
		double largestQuake=0;
		int index=0;
		
		for(int i=0; i<quakeData.size(); i++)
		{
			QuakeEntry entry = quakeData.get(i);
			double mag = entry.getMagnitude();
			if(mag > largestQuake)
			{
				largestQuake = mag;
				index = i;
			}

		}
		
		return index;
	}
	
	public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
		
		ArrayList<QuakeEntry> filteredList = new ArrayList<QuakeEntry>();
		ArrayList<QuakeEntry> copyData = new ArrayList<QuakeEntry>(quakeData);
		
		for(int i=0; i<howMany; i++)
		{
				int indexLargest = indexOfLargest(copyData);
				filteredList.add(copyData.get(indexLargest));
				copyData.remove(indexLargest);
		}
		
		return filteredList;
	}

}