package wordsInFiles;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test Class for WordFrequenciesMap
 * 
 * Developer: Keith Kretz
 * Date Created: 7/12/2024
 * Last Updated: 7/22/2024
 */
public class WordsInFilesTest {
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
         
    	WordsInFiles wif = new WordsInFiles();
		
		wif.buildWordFileMap();
		
		int maximum = wif.maxNumbers();
		
		wif.printFilesIn("sea");
	   
	    ArrayList<String> testList = wif.wordsInNumFiles(wif.getFiles().length);
	    System.out.println("The maximum number of files word is in: "+maximum +" and there are "+testList.size());
	    
	    
	    
//	    for (int k =0;k <TestList.size();k++){
//	        System.out.println("Filenames where the words are ");
//	        printFilesIn(TestList.get(k));
//	    }
         
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

