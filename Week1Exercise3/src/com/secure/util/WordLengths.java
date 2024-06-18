package com.secure.util;

import java.io.*;

public class WordLengths {
	
	public void countWordLengths(FileReader resource, int[] counts) throws IOException {
		
		BufferedReader br = new BufferedReader(resource);
		
		String test = br.readLine();

		while(br.read() != -1)
		{
			test = test + " " + br.readLine();
		}
		
		String[] words = test.split("\\s+|\\\"|\\.|\\,");
		
		for(int i=0; i<words.length; i++) 
		{
			if(words[i].length() >= counts.length)
				counts[counts.length-1] += 1;
			else
			counts[words[i].length()]++;
		}
	/*for(int i=0; i<words.length; i++) 
		System.out.println(words[i]);	*/

	}
	
	
	public int indexOfMax(int[] values) {
		
		int maxIndex = 0;
		int position = 0;
		for(int i=0; i<values.length; i++)
		{
			if(values[i] > maxIndex)
			{
				maxIndex = values[i];
				position = i;
			}
		}
		
		return position;
	
	}
	
	public void testCountWordLengths() throws IOException {

			FileReader fr = new FileReader("C:\\Users\\keith\\Desktop\\eclipse-workspace\\Week1Exercise3\\src\\com\\secure\\util\\lotsOfWords.txt");
			int[] counts = new int[31];
			
			countWordLengths(fr,counts);
			

			for(int i=2; i<counts.length; i++) 
			{
				System.out.println(counts[i] + " words of length " + i);
			}
			System.out.println("Most common word length: " + indexOfMax(counts));

	}
	

	public static void main(String[] args) throws IOException {
		

		WordLengths wl = new WordLengths();
		
		wl.testCountWordLengths();
	}

}
