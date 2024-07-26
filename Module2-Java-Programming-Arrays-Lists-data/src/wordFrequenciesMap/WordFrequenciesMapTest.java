package wordFrequenciesMap;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class for WordFrequenciesMap
 * 
 * Developer: Keith Kretz
 * Date Created: 7/9/2024
 * Last Updated: 7/9/2024
 */
public class WordFrequenciesMapTest {
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
         
    	WordFrequenciesMap wfm = new WordFrequenciesMap();
         
    	wfm.countWords();
         
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
