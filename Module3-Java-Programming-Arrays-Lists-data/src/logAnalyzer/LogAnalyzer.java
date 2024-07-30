/**
 * Class to Analyze the Log Entries
 * 
 * Developer: Keith Kretz
 * Date Created: 7/29/2024
 * Last Updated: 7/29/2024  
 */
package logAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class LogAnalyzer {
	
	private ArrayList<LogEntry> records;
	
	public LogAnalyzer() {
		
		records = new ArrayList<LogEntry>();
	}
	
	public void readFile(String fileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module3-Java-Programming-Arrays-Lists-data\\src\\data\\"+fileName));
		
		String line;
		
		while((line = br.readLine()) != null)
		{
			records.add(WebLogParser.parseEntry(line));
		}
	}
	
	public void printAll() {
		
		for(LogEntry le : records) {
			
			System.out.println(le);
		}
	}
	
//	This method should return an integer representing the number of unique IP addresses.
//	It should also assume that the instance variable records already has its ArrayList of 
//	Strings read in from a file, and should access records in computing this value.
	public int countUniqueIPs() {
		
		ArrayList<String> visitedIPAddress = new ArrayList<String>();
		
		for(LogEntry le : records)
		{
			String ipAddr = le.getIpAddress();
			
			if(!visitedIPAddress.contains(ipAddr))
			{
				visitedIPAddress.add(ipAddr);	
			}
		}
		
		return visitedIPAddress.size();	
	}
	
	//This method should examine all the web log entries in records and print those LogEntrys that have a status code greater than num.
	public void printAllHigherThanNum(int num) {
		
		for(LogEntry le : records)
		{
			int status = le.getStatusCode();
			if(status > num)
			{
				System.out.println("StatusCode greater than "+num+": "+status);
			}
			
		}
		
	}
	
//	This method accesses the web logs in records and returns an ArrayList of Strings of unique IP addresses that had access on the given day.
//	(Note that the dates in LogEntrys are stored as a Date object, but using toString will allow you to access the characters in the Date.
	public ArrayList<String> uniqueIPVisitsOnDay(String someday){

		ArrayList<String> IPDates = new ArrayList<String>();
		
		for(LogEntry le: records)
		{
			String date = le.getAccessTime().toString();
			if(date.indexOf(someday) != -1)
			{
				String uniqueIP = le.getIpAddress();
				if(!IPDates.contains(uniqueIP))
				{
					IPDates.add(uniqueIP);
				}

			}
		}

		return IPDates;		
	}

	//This method returns the number of unique IP addresses in records that have a status code in the range from low to high, inclusive.
	public int countUniqueIPsInRange(int low, int high) {
		
		int count=0;
		ArrayList<String> countedIPAddress = new ArrayList<String>();
		
		for(LogEntry le: records)
		{
			if(low<=le.getStatusCode() && le.getStatusCode()<=high)
			{
				String uniqueIP = le.getIpAddress();
				if(!countedIPAddress.contains(uniqueIP))
				{
					countedIPAddress.add(uniqueIP);
					count+=1;
				}
			}
		}
		
		return count;
	}
	
	//This method returns a HashMap<String, Integer> that maps an IP address to the number of times that IP address appears in records, 
	//meaning the number of times this IP address visited the website.
	public HashMap<String,Integer> countVisitsPerIp(){
		
		HashMap<String,Integer> counts = new HashMap<String, Integer>();
		
		for(LogEntry le: records)
		{
			String IP = le.getIpAddress();

			if(!counts.containsKey(IP))
			{
				counts.put(IP, 1);
			}
			else
			{
				counts.put(IP, counts.get(IP)+1);
			}
			
		}
		
		return counts;
	}
	
	//This method returns the maximum number of visits to this website by a single IP address. 
	public int mostNumberVisitsByIP(HashMap<String,Integer> iPCounts) {
		
		int max =0;
		for(String keyIP: iPCounts.keySet())
		{
			int ipCount = iPCounts.get(keyIP);
			
			if(ipCount>max)
			{
				max = ipCount;
			}
		}
		
		return max;
	}

}
