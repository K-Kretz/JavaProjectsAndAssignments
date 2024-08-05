package vigenereCipher;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class to test the CaesarCipher Class
 * 
 * Developer: Keith Kretz
 * Date Created: 8/1/2024
 * Last Updated: 8/1/2024  
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	
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
    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\titus-small.txt"));

    	String lines;
    	ArrayList<String> story = new ArrayList<String>();
    	
    	while((lines =br.readLine()) != null)
    	{
    		story.add(lines);
    	}
        CaesarCipher cc = new CaesarCipher(1);
        
        System.out.println(story.toString());
        
        String encrpytedStory = cc.encrypt(story.toString());
        System.out.println(encrpytedStory);
        
        System.out.println(cc.decrypt(encrpytedStory));
    }
    
    @Test
    public void mainTest2() throws IOException {
    	
    	
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
