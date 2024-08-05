package vigenereCipher;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class to test the VigenereCipher Class
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

public class VigenereCipherTest {
	
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
    	
    	String trueStory ="";
    	for(String line : story)
    	{
    		trueStory = trueStory+line+" ";
    	}
        int[] key = new int[] {17,14,12,4};
    	
    	VigenereCipher vg = new VigenereCipher(key);
    	
    	System.out.println(vg.encrypt(trueStory));
    }
    
    @Test
    public void mainTest2() throws IOException {
    	
    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\titus-small.txt"));

    	String lines;
    	ArrayList<String> story = new ArrayList<String>();
    	
    	while((lines =br.readLine()) != null)
    	{
    		story.add(lines);
    	}
    	
    	String trueStory ="";
    	for(String line : story)
    	{
    		trueStory = trueStory+line+" ";
    	}
    	
    	VigenereBreaker vb = new VigenereBreaker();
    	
    	System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
    	
    	System.out.println(vb.sliceString("abcdefghijklm", 1, 3));
    	
    	System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
    	
    }
    
    @Test
    public void mainTest3() throws IOException {
    	
    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\athens_keyflute.txt"));

    	String lines;
    	ArrayList<String> story = new ArrayList<String>();
    	
    	while((lines =br.readLine()) != null)
    	{
    		story.add(lines);
    	}
    	
    	String trueStory ="";
    	for(String line : story)
    	{
    		trueStory = trueStory+line+" ";
    	}
    	
    	VigenereBreaker vb = new VigenereBreaker();
    	
    	int[] key = vb.tryKeyLength(trueStory, 5, 'e');
    	
    	for(int num : key)
    	{
    		System.out.println(num);
    	}
    }
    
    @Test
    public void mainTest4() throws IOException {
    	
    	
    	VigenereBreaker vb = new VigenereBreaker();
    	
    	vb.breakVigenere();
    	
    	
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