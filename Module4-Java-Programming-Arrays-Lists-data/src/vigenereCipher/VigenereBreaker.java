package vigenereCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

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
    
    public HashSet<String> readDictionary(File f) throws IOException{
		
    	HashSet<String> hs = new HashSet<String>();
    	
    	BufferedReader br = new BufferedReader(new FileReader(f));

    	String lines;
    	
    	while((lines =br.readLine()) != null)
    	{
    		hs.add(lines);
    	}
    	
    	//System.out.println("Size of dictionary: "+hs.size());
    	
    	return hs;
    }

    public int countWords(String message, HashSet<String> dictionary) {
    	
    	int countRealWords = 0;
    	
    	for(String word : message.toLowerCase().split("\\W"))
    	{
    		if(dictionary.contains(word))
    		{
    			//System.out.println(word);
    			countRealWords +=1;
    		}
    	}
    	
    	return countRealWords;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
    	
    	String message = "";
    	int maxCount = 0;
    	int keyLengthcount=0;
    	
    	for(int i=1; i<=100; i++)
    	{
    		if(encrypted.length()>=100)
    		{
    			char letter = mostCommonCharIn(dictionary);
    			int[] key = tryKeyLength(encrypted, i, letter);
    			VigenereCipher vc = new VigenereCipher(key);
    			
    			String decryptMessage = vc.decrypt(encrypted);
    			int count = countWords(decryptMessage,dictionary);
    			
    			if(count > maxCount)
    			{
    				maxCount=count;
    				message = decryptMessage;
    				keyLengthcount = i;
    			}
    		}
    	}
    	
    	System.out.println("Real Words: "+maxCount);
    	System.out.println("Key Length: "+keyLengthcount);
    	
    	return message;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
		
    	char mostCommonLetter = '\0';
    	int mostCommonLetterValue = 0;
    	
    	HashMap<Character, Integer> characterCounter = new HashMap<Character, Integer>();
    	

    	
    	for(String word : dictionary)
    	{
    		char[] letters = word.toCharArray();
    		
    		for(int i=0; i<letters.length; i++)
    		{
    			if(!characterCounter.containsKey(letters[i]))
    			{
    				characterCounter.put(letters[i], 1);
    			}
    			else
    			{
    				characterCounter.replace(letters[i],characterCounter.get(letters[i])+1);
    			}
    		}
    	}
    	for(Character character : characterCounter.keySet())
    	{
    		if(characterCounter.get(character)>mostCommonLetterValue)
    		{
    			mostCommonLetter = character;
    			mostCommonLetterValue = characterCounter.get(character);
    		}
    	}
	
    	return mostCommonLetter;	
    }
    
    public String breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> languages) {
		
    	String message="";
    	String codedLanguage="";
    	int maxCount = 0;
    	
    	for(String language : languages.keySet())
    	{
    		String breakWithThisLanguageMessage = breakForLanguage(encrypted, languages.get(language));
    		int count = countWords(breakWithThisLanguageMessage, languages.get(language));
    		if(count>maxCount)
    		{
    			message = breakWithThisLanguageMessage;
    			maxCount = count;
    			codedLanguage = language;
    		}
    	} 	
    	
    	System.out.println("Was coded in language: "+codedLanguage);
    	
    	return message;
    }
    public File[] DirectoryResource(final JFrame frame) throws IOException{  
    	
    	File[] files = null;
    	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION)
        {
           files = fileChooser.getSelectedFiles();
        } 
        
        return files;
	}
    
    public void breakVigenere () throws IOException {
       

    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\secretmessage2.txt"));

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
    	
    	
    	
    	
    	File f = new File("C:\\Users\\keith\\git\\repository\\Module4-Java-Programming-Arrays-Lists-data\\src\\data\\English");
    	HashSet<String> dictionary = readDictionary(f);
    	
    	
    	
    	
    
    	
    	
    	String decryptedStory = breakForLanguage(trueStory, dictionary);
    	
    	//System.out.println(decryptedStory);
    	
    	
    }
    
    
    
}
