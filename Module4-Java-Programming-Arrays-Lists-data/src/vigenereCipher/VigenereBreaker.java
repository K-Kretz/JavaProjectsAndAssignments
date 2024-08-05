package vigenereCipher;

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
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
