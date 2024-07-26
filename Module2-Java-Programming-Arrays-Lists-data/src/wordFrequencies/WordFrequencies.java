/**
 * ASSIGNMENT 1: WordFrequencies
 * 
 * write a program to determine the word that occurs the most often in a file. 
 * If more than one word occurs as the most often, then return the first such word found. 
 * You should make all words lowercase before counting them. 
 * 
 * Developer: Keith Kretz
 * Date Created: 6/25/2024
 * Last Updated: 6/25/2024
 */
package wordFrequencies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordFrequencies {
	
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	
	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
		
	}
	
	public void findUnique() throws IOException {
		myWords.clear();
		myFreqs.clear();

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data\\errors.txt"));
		
		String line;
		
		while((line = br.readLine()) != null)
		{
			
			String[] word = line.toLowerCase().split("\\s+");
			
			for(int i=0; i<word.length; i++)
			{
				
				int index = myWords.indexOf(word[i]);
				if(index==-1)
				{
					myWords.add(word[i]);
					myFreqs.add(1);
				}
				else
				{
					myFreqs.set(index, myFreqs.get(index)+1);
				}
			}
				
		}
	}
	
	public int findIndexOfMax() {
		
		int maxIndex=0;
		int maxValue=0;
		 for(int i=0; i<myWords.size(); i++)
		 {
			 if(myFreqs.get(i) > maxValue)
			 {
				maxValue = myFreqs.get(i);
			 	maxIndex = i;
			 }
		 }
		
		return maxIndex;		
	}
	
	public void tester() throws IOException{
		
		findUnique();
		System.out.println("Unique Words: " + myWords.size());
		
		System.out.println("Most common word: " + myWords.get(findIndexOfMax()) + " - " + myFreqs.get(findIndexOfMax()));
		
		
		for(int i=0; i<myWords.size(); i++)
		{
			if(myFreqs.get(i) >1)
			System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
		}
	}

//	public static void main(String[] args) throws IOException {
//		
//		WordFrequencies wf = new WordFrequencies();
//		
//		wf.tester();
//	}
}
