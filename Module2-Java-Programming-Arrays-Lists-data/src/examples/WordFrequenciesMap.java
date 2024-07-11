/**
 * EXAMPLE 2: WordFrequenciesMap
 * 
 * Using previous WordFrequencie class but with the use of hashMaps.
 * 
 * Developer: Keith Kretz
 * Date Created: 7/9/2024
 * Last Updated: 7/9/2024
 */
package examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequenciesMap {
	
	private HashMap<String,Integer> map;
	
	public WordFrequenciesMap() {
		
		map = new HashMap<String, Integer>();
	}
	
	public void countWords() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\examples\\TestFile.txt"));
		
		String lines;
		
		while((lines = br.readLine()) != null)
		{
			String[] words = lines.split("\\s+");
			for(int i=0; i<words.length; i++)
			{
				if(map.keySet().contains(words[i]))
				{
					map.put(words[i],map.get(words[i])+1);
				}
				else
				{
					map.put(words[i],1);
				}
			}
			words = null;
		}
		
		for(String w : map.keySet())
		{
			int occurrances = map.get(w);
			if(occurrances > 500)
				System.out.println(occurrances+ "\t" + w);
		}
		
	}
	
	

	public static void main(String[] args) throws IOException {
		WordFrequenciesMap wfm = new WordFrequenciesMap();
		
		wfm.countWords();
	}

}
