package SearchingEarthquake;

import java.util.*;




public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "C:\\Users\\keith\\git\\JavaProjectsAndAssignments\\Module1-Java-Programming-Design-Principles\\src\\data\\nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        ArrayList<QuakeEntry> listFilter = new ArrayList<QuakeEntry>();
        
//      MagnitudeFilter f1 = new MagnitudeFilter(4.0,5.0); 
//      DepthFilter f2 = new DepthFilter(-35000.0, -12000.0);
        
        MagnitudeFilter f1 = new MagnitudeFilter(4.0,5.0); 
        DepthFilter f2 = new DepthFilter(-35000.0, -12000.0);
        
        listFilter = filter(list,f1);
        listFilter = filter(listFilter,f2);
        
        for(QuakeEntry entry : listFilter)
        	System.out.println(entry); 
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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
