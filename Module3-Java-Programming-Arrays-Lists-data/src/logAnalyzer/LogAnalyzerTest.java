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
         la.printAll();
        
    }
    
    @Test
    public void mainTest2() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPs());
    	
    }
    
    @Test
    public void mainTest3() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(302);
    	
    }
    
    @Test
    public void mainTest4() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        System.out.println(la.uniqueIPVisitsOnDay("Sep 30").size());
    	
    }
    
    @Test
    public void mainTest5() throws IOException {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(300,399));
    	
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