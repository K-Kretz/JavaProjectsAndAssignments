package wordFrequencies;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class for WordFrequencies
 * 
 * Developer: Keith Kretz
 * Date Created: 6/25/2024
 * Last Updated: 6/25/2024
 */
public class WordFrequenciesTest {
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
         
         WordFrequencies wf = new WordFrequencies();
         
         wf.tester();
         
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
