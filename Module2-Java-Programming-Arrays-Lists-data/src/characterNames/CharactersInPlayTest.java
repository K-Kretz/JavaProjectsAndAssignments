package characterNames;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class for CharactersInPlay
 * 
 * Developer: Keith Kretz
 * Date Created: 6/28/2024
 * Last Updated: 6/28/2024
 */
public class CharactersInPlayTest {
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
         
         CharactersInPlay cip = new CharactersInPlay();
 		 cip.tester();
        
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
