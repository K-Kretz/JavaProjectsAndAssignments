package vigenereCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VigenereBreaker {
	
    public String sliceString(String message, int whichSlice, int totalSlices) {
        
    	String slice = "";
    	
    	for(int i=whichSlice; i<message.length(); i+=totalSlices)
    	{
    		slice = slice + message.charAt(i);
    	}
    	
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        
        CaesarCracker cc = new CaesarCracker(mostCommon);
        
        for(int i=0; i<klength; i++)
        {
        	String slice = sliceString(encrypted,i,klength);
        	key[i] = cc.getKey(slice);
        }
        
        return key;
    }

    public void breakVigenere () throws IOException {
       

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
    	
    	int[] key = tryKeyLength(trueStory, 5, 'e');
    	
    	VigenereCipher vc = new VigenereCipher(key);
    	
    	String decryptedStory = vc.decrypt(trueStory);
    	
    	System.out.println(decryptedStory);
    	
    	
    }
    
}
