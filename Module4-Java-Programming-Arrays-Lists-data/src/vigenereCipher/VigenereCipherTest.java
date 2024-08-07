package vigenereCipher;

import java.io.BufferedReader;
import java.io.File;
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
import java.util.HashSet;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Assert;
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
    
//    @Test
//    public void mainTest1() throws IOException{
//    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\titus-small.txt"));
//
//    	String lines;
//    	ArrayList<String> story = new ArrayList<String>();
//    	
//    	while((lines =br.readLine()) != null)
//    	{
//    		story.add(lines);
//    	}
//    	
//    	String trueStory ="";
//    	for(String line : story)
//    	{
//    		trueStory = trueStory+line+" ";
//    	}
//        int[] key = new int[] {17,14,12,4};
//    	
//    	VigenereCipher vg = new VigenereCipher(key);
//    	
//    	System.out.println(vg.encrypt(trueStory));
//    }
//    
//    @Test
//    public void mainTest2() throws IOException {
//    	
//    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\titus-small.txt"));
//
//    	String lines;
//    	ArrayList<String> story = new ArrayList<String>();
//    	
//    	while((lines =br.readLine()) != null)
//    	{
//    		story.add(lines);
//    	}
//    	
//    	String trueStory ="";
//    	for(String line : story)
//    	{
//    		trueStory = trueStory+line+" ";
//    	}
//    	
//    	VigenereBreaker vb = new VigenereBreaker();
//    	
//    	System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
//    	
//    	System.out.println(vb.sliceString("abcdefghijklm", 1, 3));
//    	
//    	System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
//    	
//    }
//    
//    @Test
//    public void mainTest3() throws IOException {
//    	
//    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\secretmessage1.txt"));
//
//    	String lines;
//    	ArrayList<String> story = new ArrayList<String>();
//    	
//    	while((lines =br.readLine()) != null)
//    	{
//    		story.add(lines);
//    	}
//    	
//    	String trueStory ="";
//    	for(String line : story)
//    	{
//    		trueStory = trueStory+line+" ";
//    	}
//    	
//    	VigenereBreaker vb = new VigenereBreaker();
//    	
//    	int[] key = vb.tryKeyLength(trueStory, 4, 'e');
//    	
//    	for(int num : key)
//    	{
//    		System.out.println(num);
//    	}
//    }
//    
//    @Test
//    public void mainTest4() throws IOException {
//    	
//    	
//    	VigenereBreaker vb = new VigenereBreaker();
//    	
//    	vb.breakVigenere();
//    	
//    	
//    }
    
//    @Test
//    public void mainTest5() throws IOException {    	
//    	// Quiz 1
//    			VigenereBreaker v = new VigenereBreaker();
//    			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\secretmessage2.txt"));
//    			String lines1;
//    	    	ArrayList<String> story = new ArrayList<String>();
//    	    	
//    	    	while((lines1 =br.readLine()) != null)
//    	    	{
//    	    		story.add(lines1);
//    	    	}
//    	    	
//    	    	String trueStory ="";
//    	    	for(String line : story)
//    	    	{
//    	    		trueStory = trueStory+line+" ";
//    	    	}
//    	    	
//    			File f = new File("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\English");
//    			HashSet<String> dictionary = v.readDictionary(f);
//    			String decrypt = v.breakForLanguage(trueStory, dictionary);
//    			System.out.println(decrypt);
////    			// Quiz 2
//    			int count = v.countWords(decrypt, dictionary);
//   			    System.out.println(count + " valid words are in the decrypted String.");
////    			
////    			// Quiz 3
////    			String [] lines = decrypt.split("\\r?\\n");
////    			System.out.println("The first line of text is " + lines[0]);
//    			
//    			// Quiz 4
//    			int [] key = v.tryKeyLength(trueStory, 38, 'e');
//    			VigenereCipher vc = new VigenereCipher(key);
//    	    	decrypt = vc.decrypt(trueStory);
//    	    	count = v.countWords(decrypt, dictionary);
//    	    	System.out.println(count + " valid words are in the decrypted String.");
//    }
//    @Test
//    public void mainTest6() throws IOException {    	
//    	
//    	VigenereBreaker vb = new VigenereBreaker();
//    	File f = new File("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\Italian");
//    	HashSet<String> dictionary = vb.readDictionary(f);
//    	char mostCommonLetter = vb.mostCommonCharIn(dictionary);
//    	System.out.println(mostCommonLetter);
//    	
//    	Assert.assertEquals(mostCommonLetter, 'a');
//    }
    @Test
    public void mainTest7() throws IOException {    	
    	
    	VigenereBreaker vb = new VigenereBreaker();
    	
    	JFrame frame = new JFrame();

		File[] files = vb.DirectoryResource(frame);	
    	
		HashMap<String,HashSet<String>> languages = new HashMap<String, HashSet<String>>();
		
    	for(File file : files)
    	{
    		String lang = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1);
    		languages.put(lang, vb.readDictionary(file));
    	}
//    	System.out.println(languages.get("English").size());
//    	System.out.println(languages.get("Dutch").size());
    	
    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\secretmessage4.txt"));
		String lines1;
    	ArrayList<String> story = new ArrayList<String>();
    	
    	while((lines1 =br.readLine()) != null)
    	{
    		story.add(lines1);
    	}
    	
    	String trueStory ="";
    	for(String line : story)
    	{
    		trueStory = trueStory+line+" ";
    	}
    	
     	String messageDecrypted = vb.breakForAllLangs(trueStory,languages);
    	System.out.println(messageDecrypted);
//    	
//    	Assert.assertEquals(mostCommonLetter, 'a');
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