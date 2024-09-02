
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

package SelectionSort;
import java.util.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from) {
    	
    	int largestIndex = from;
    	
    	for(int i=from+1; i<quakeData.size(); i++)
    	{
    		if(quakeData.get(i).getDepth()<quakeData.get(largestIndex).getDepth())
    		{
    			largestIndex = i;
    		}
    	}
    	return largestIndex;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in) {
    	
    	for(int i=0; i<50; i++)
    	{
    		int largestIndex = getLargestDepth(in,i);
    		
    		QuakeEntry qi = in.get(i);
    		QuakeEntry qLargest = in.get(largestIndex);
    		
    		in.set(i, qLargest);
    		in.set(largestIndex, qi);	
    		
    		System.out.println("pass: "+(i+1));
    		for(QuakeEntry entry : in)
    			System.err.println(entry);
    	}
    	
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted) {
    	
    	for(int i=0; i<quakeData.size()-1-numSorted; i++)
    	{
        		if(quakeData.get(i).getMagnitude()>quakeData.get(i+1).getMagnitude())
        		{
        			QuakeEntry buf = quakeData.get(i);
        			quakeData.set(i, quakeData.get(i+1));
        			quakeData.set(i+1, buf);
        		}
    	}
    	
    }
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> quakeData) {
    	
    	for(int i=0; i<quakeData.size()-1; i++)
    	{
    		onePassBubbleSort(quakeData,i);
    		
    		for(QuakeEntry entry : quakeData)
    			System.out.println(entry);
    		
    		System.out.println("After Pass "+i);
    	}
    	
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes) {
    	
    	
    	for(int i=0; i<quakes.size()-1; i++)
    	{
    		if(quakes.get(i).getMagnitude()>quakes.get(i+1).getMagnitude())
    			return false;
    	}
    	
    	return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in) {
    	
    	for(int i=0; i<in.size()-1; i++)
    	{
    		if(checkInSortedOrder(in) == true)
    			break;
    		
    		onePassBubbleSort(in,i);
    		
    		for(QuakeEntry entry : in)
    			System.out.println(entry);
    		
    		System.out.println("After Pass "+(i+1));
    		
    	}
    	
    }
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
    	
    	for(int i=0; i<in.size(); i++)
    	{
    		if(checkInSortedOrder(in) == true)
    			break;
    		
    		int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            
            for(QuakeEntry entry : in)
    			System.out.println(entry);
    		
    		System.out.println("After Pass "+(i+1));
    		
    	}
    	
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\nov20quakedatasmall.atom";
        //String source = "C:\Users\keith\git\JavaProjectsAndAssignments\Module2-Java-Programming-Design-Principles\src\data\nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "C:\Users\keith\git\JavaProjectsAndAssignments\Module2-Java-Programming-Design-Principles\src\data\nov20quakedata.atom";
        String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module2-Java-Programming-Design-Principles\\src\\data\\nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
