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
	

}
