/**
 * Assignment 1: CodonCount
 * 
 * Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in. 
 * 
 * Developer: Keith Kretz
 * Date Created: 7/12/2024
 * Last Updated: 7/12/2024
 */
package Assignments;

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
	
	public WordsInFiles() {
		
		wordsInFile = new HashMap<String, ArrayList<String>>();
		
	}
	
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
           File[] files = fileChooser.getSelectedFiles();
           for(File file: files)
           {
        	   addWordsFromFile(file);
           }    
        } 
	}
	
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
	
	public void printFilesIn(String word) {
		
		if(wordsInFile.containsKey(word))
		{
			for(int i=0; i<wordsInFile.get(word).size(); i++)
			{
				System.out.println(wordsInFile.get(word).get(i));
			}
		}
	
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		WordsInFiles wif = new WordsInFiles();
		
		wif.buildWordFileMap();
		
		System.out.println(wif.maxNumbers());
		System.out.println(wif.wordsInNumFiles(3));
		wif.printFilesIn("cats");
		
//		for(String word : wordsInFile.keySet())
//		{
//			System.out.println(word);
//			System.out.println(wordsInFile.get(word).toString());
//		}
	}

}
