/**
 * EarthQuakeClient Class
 * 
 * Class to manipulate and store data on Earthquakes
 * 
 * Developer: Keith Kretz
 * Date Created: 8/8/2024
 * Last Updated: 8/8/2024
 */

package SearchingEarthquake;

import java.util.*;

public class EarthQuakeClient {
    
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
            
    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	
	public void bigQuakes() {
	    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module1-Java-Programming-Design-Principles\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        
        //method 1 of getting data filtered
//        for(QuakeEntry entry : list)
//        {
//        	if(entry.getMagnitude() > 5.0)
//        		System.out.println(entry);
//        }
        
        //method 2 0f using method filterByMagnitude()
        ArrayList<QuakeEntry> filteredList = filterByMagnitude(list, 5.0);
        for(QuakeEntry entry : filteredList)
        	System.out.println(entry);
       
	}
	
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module1-Java-Programming-Design-Principles\\src\\data\\nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";  
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }

    }
    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeList, Location loc, int howMany){
		
    	ArrayList<QuakeEntry> quakeListCopy = new ArrayList<QuakeEntry>(quakeList);
    	
    	ArrayList<QuakeEntry> numOfSpotsCloseList = new ArrayList<QuakeEntry>();
    	int minIndex=0;
    	for(int k=0; k< howMany; k++) {
    		for(int i=1; i<quakeListCopy.size(); i++) 
        	{
        		QuakeEntry entry = quakeListCopy.get(i);
        		Location locQuake = entry.getLocation();
        		if(locQuake.distanceTo(loc) < quakeListCopy.get(minIndex).getLocation().distanceTo(loc))
        		{
        			minIndex = i;
        		}
        	}
    		numOfSpotsCloseList.add(quakeListCopy.get(minIndex));     
    		quakeListCopy.remove(minIndex);
    	}
    	return numOfSpotsCloseList;
    }
    
    public void findCloseQuakes() {
    	
    	EarthQuakeParser parser = new EarthQuakeParser();
    	
    	String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";  
    	ArrayList<QuakeEntry> list = parser.read(source);
    	
    	Location jakarta = new Location(-6.211,106.845);
    	
    	ArrayList<QuakeEntry> close = getClosest(list,jakarta,10);
    	
    	for(QuakeEntry entry : close)
    	{
    		double distanceInMeters = jakarta.distanceTo(entry.getLocation());
    		System.out.printf("%4.2f\t %s\n", distanceInMeters/1000, entry);
    	}
    	System.out.printf("Number found: "+close.size());
    }
}
