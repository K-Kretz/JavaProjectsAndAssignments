/**
 * Class to test the LogAnalyzer Class
 * 
 * Developer: Keith Kretz
 * Date Created: 7/29/2024
 * Last Updated: 7/29/2024  
 */
package logAnalyzer;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogAnalyzerTest {
	
	/**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    
    @Before
    public void setUp() {
        
    }
    
    /**
     * Sets up main call to test method.
     */
    
    @Test
    public void mainTest1() throws IOException{
         LogAnalyzer la = new LogAnalyzer();
         la.readFile("short-test_log");
         System.out.println("mainTest1()");
         la.printAll();
        
    }
    
    @Test
    public void mainTest2() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("mainTest2()");
        System.out.println(la.countUniqueIPs());
    	
    }
    
    @Test
    public void mainTest3() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("mainTest3()");
        la.printAllHigherThanNum(400);
    	
    }
    
    @Test
    public void mainTest4() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("mainTest4()");
        System.out.println(la.uniqueIPVisitsOnDay("Mar 24").size());
    	
    }
    
    @Test
    public void mainTest5() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("mainTest5()");
        System.out.println(la.countUniqueIPsInRange(200,299));
    	
    }
    
    @Test
    public void mainTest6() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println("mainTest6()");
        
        HashMap<String,Integer> myCounts = la.countVisitsPerIp();
        for(String key: myCounts.keySet())
        {
        	System.out.println("IP address: " + key + " has "+myCounts.get(key)+" visits");
        }
    }
    
    @Test
    public void mainTest7() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println("mainTest7()");
        
        HashMap<String,Integer> myCounts = la.countVisitsPerIp();
        
        System.out.println(la.mostNumberVisitsByIP(myCounts));
    	
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

}
