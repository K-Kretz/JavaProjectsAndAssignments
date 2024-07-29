package readingLogFiles;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class for ReadingLogFiles
 * 
 * Developer: Keith Kretz
 * Date Created: 7/28/2024
 * Last Updated: 7/28/2024
 */
public class LogEntryTest {
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
    public void mainTest() throws IOException{
         
    	LogEntry rlf1 = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
 		System.out.println(rlf1);
 		
 		LogEntry rlf2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
 		System.out.println(rlf2);
        
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
