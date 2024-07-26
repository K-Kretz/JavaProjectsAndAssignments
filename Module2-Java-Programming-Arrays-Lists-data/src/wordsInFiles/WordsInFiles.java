/**
 * Assignment 2: WordsInFiles
 * 
 *  A description of WordsinFiles here.
 *  Create a map of words to the names of files they are in.
 *  That is, you will map a String to an ArrayList of Strings.
 *  Then you can determine which ArrayList value is the largest
 *  (has the most filenames) and its Key is thus, a word that is
 *  in the most number of files.
 * 
 * Developer: Keith Kretz
 * Date Created: 7/12/2024
 * Last Updated: 7/22/2024
 */
package wordsInFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class WordsInFiles {


	private static HashMap<String,ArrayList<String>> wordsInFile;
	
	private static  File[] files;
	
	public WordsInFiles() {
		
		wordsInFile = new HashMap<String, ArrayList<String>>();
		
	}
	
	public File[] getFiles() {
			
		return files;
	}
	
	 /*
     * Write a private void method named addWordsFromFile that has one
     * parameter f of type File.This method should add all the words from
     * f into the map.If a word is not in the map, then you must create
     * a new ArrayList of type String with this word, and have the word map
     * to this ArrayList.If a word is already in the map, then add the current
     * filename to its ArrayList, unless the filename is already in the 
     * ArrayList. You can use the File method getName to get the filename of 
     * a file
     */
	
	private static void addWordsFromFile(File f) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String line;
		
		while((line = br.readLine()) != null)
		{
			String[] words = line.split("\\s+");
			
			for(int i=0; i<words.length; i++)
			{
				if(!wordsInFile.containsKey(words[i]))
				{	
					ArrayList<String> wordFileList = new ArrayList<>();
					wordsInFile.put(words[i], wordFileList);
					wordsInFile.get(words[i]).add(f.getName());	
				}
				else
				{				
					if(!wordsInFile.get(words[i]).contains(f.getName()))
					{
						wordsInFile.get(words[i]).add(f.getName());	
					}
				}
			}
			words = null;
		}
		br.close();
	}
	
	/*
     * Write a void method named buildWordFileMap that has no parameters.
     * This method first clears the map, and then uses a DirectoryResource
     * to select a group of files.Foir each file,it puts all of its words
     * the map by calling the method addWordsFromFile. The remaining methods
     * to write all assume that the HashMap has been built.
     */
	
	public void buildWordFileMap() throws IOException {
		
		if(!wordsInFile.isEmpty())
			wordsInFile.clear();
		
		JFrame frame = new JFrame();

		DirectoryResource(frame);	
		
	}
	
	private static void DirectoryResource(final JFrame frame) throws IOException{  
	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION)
        {
           files = fileChooser.getSelectedFiles();
           for(File file: files)
           {
        	   addWordsFromFile(file);
           }    
        } 
	}
	
	 /*
     * Write the method maxNumber that has no parameters.This method returns 
     * the maximum number of files any word appears in, considering all words
     * from a group of files.In the example above, there are four files 
     * considered. No word appears in all four files.Two words appear in three
     * of the files, so maxNumber on those four files would return 3. 
     * This method assumes that the HashMap has already been constructed.
     */
	
	public int maxNumbers() {
		
		int maxWordInFiles = 0;
		
		for(String word : wordsInFile.keySet())
		{
			if(wordsInFile.get(word).size() > maxWordInFiles)
			{
				maxWordInFiles = wordsInFile.get(word).size();
			}
		}
		
		return maxWordInFiles;
	}
	
	
	 /*
     * Write the method WordInNumFiles that has one integer parameter 
     * called number.This method returns an ArrayList of words that appear
     * in exactly number files. In the example,the call of wordsInNumFiles(3)
     * would return an ArrayList with the words "cats" and "and", and the call
     * wordsInNumFiles(2) would return an ArrayList with the words "love",
     * "are" and "dogs", all the words that appear in exactly two files
     */
	
	public ArrayList<String> wordsInNumFiles(int number){
		
		ArrayList<String> words = new ArrayList<String>();
		
		for(String word : wordsInFile.keySet())
		{
			if(wordsInFile.get(word).size() == number)
			{
				words.add(word);
			}
		}
		return words;
	}
	
	 /*
     * Write the void method printFilesIn that has one String parameter named
     * word.This method prints the names of the files this word appears in,one
     * filename per line. For example, in the example above, the call
     * printFilesIn("cats") would print the three filenames: brief1.txt, 
     * brief3.txt and brief4.txt, each on a separate line.
     */
	
	public void printFilesIn(String word) {
		
		if(wordsInFile.containsKey(word))
		{
			for(int i=0; i<wordsInFile.get(word).size(); i++)
			{
				System.out.println(wordsInFile.get(word).get(i));
			}
		}
	
	}
	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		WordsInFiles wif = new WordsInFiles();
//		
//		wif.buildWordFileMap();
//		
//		int maximum = maxNumbers();
//		
//		printFilesIn("sea");
//	   
//	    ArrayList<String> testList = wordsInNumFiles(7);
//	    System.out.println("The maximum number of files word is in: "+maximum +" and there are "+testList.size());
//	    
//	    
//	    
////	    for (int k =0;k <TestList.size();k++){
////	        System.out.println("Filenames where the words are ");
////	        printFilesIn(TestList.get(k));
////	    }
			
//	}
}


