/**
 * EXAMPLE 1: WordFrequencies
 * 
 * Using ArrayLists to count the Frequencies of words in a text file
 * 
 * Developer: Keith Kretz
 * Date Created: 6/25/2024
 * Last Updated: 6/25/2024
 */
package examples;

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
		

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\examples\\TestFile.txt"));
		
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
	
	public void tester() throws IOException{
		
		findUnique();
		System.out.println("Unique Words: " + myWords.size());
		for(int i=0; i<myWords.size(); i++)
		{
			System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
		}
	}

	public static void main(String[] args) {
		
		WordFrequencies wf = new WordFrequencies();
		
		try {
			wf.tester();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
