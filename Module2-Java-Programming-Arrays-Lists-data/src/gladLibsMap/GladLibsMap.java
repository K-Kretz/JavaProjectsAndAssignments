/**
 * Assignment 3: GladLibsMap
 * 
 * modify previous program to use one HashMap that maps word types to ArrayList of possible words to select. 
 * Your program should still work for the additional categories verbs and fruits and should not use duplicate words from a category.
 * 
 * Developer: Keith Kretz
 * Date Created: 7/22/2024
 * Last Updated: 7/22/2024 
 */
package gladLibsMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibsMap {
	
	HashMap<String,ArrayList<String>> myMap;
	
//	private ArrayList<String> adjectiveList;
//	private ArrayList<String> nounList;
//	private ArrayList<String> colorList;
//	private ArrayList<String> countryList;
//	private ArrayList<String> nameList;
//	private ArrayList<String> animalList;
//	private ArrayList<String> timeList;
//	private ArrayList<String> verbList;
//	private ArrayList<String> fruitList;
	private ArrayList<String> usedWords;
	private ArrayList<String> categoriesUsed;
	
	private Random myRandom;
	
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data";
	
	public GladLibsMap() throws IOException{
		
		usedWords = new ArrayList<String>();
		myMap = new HashMap<String, ArrayList<String>>();
		myRandom = new Random();
		categoriesUsed = new ArrayList<String>();
		
		initializeFromSource(dataSourceDirectory);
	}
	
	public GladLibsMap(String source) throws IOException{
		initializeFromSource(source);
		myRandom = new Random();
	}
	
	private void initializeFromSource(String source) throws IOException {
		
		String[] categories = new String[] {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
		for(int i=0; i<categories.length; i++)
		{
			myMap.put(categories[i], readIt(source+"\\"+categories[i]+".txt"));
		}
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		if (myMap.containsKey(label)) {
			if(!categoriesUsed.contains(label))
			{
				categoriesUsed.add(label);
			}
			return randomFrom(myMap.get(label));
		}
		if (label.equals("number")){
			return ""+myRandom.nextInt(50)+5;
		}
		return "**UNKNOWN**";
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
		while(usedWords.contains(sub))
		{
			sub = getSubstitute(w.substring(first+1,last));
		}
		usedWords.add(sub);
		return prefix+sub+suffix;
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source) throws IOException{
		String story = "";
		if (source.startsWith("http")) 
		{
			URL resource = new URL(source);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()));
			
			String line;
			
			while((line = br.readLine()) != null)
			{
				
				String[] word = line.toLowerCase().split("\\s+");
				for(int i=0; i<word.length; i++)
				{
					
					story = story + processWord(word[i]) + " ";
				}
			}

		}
		else 
		{
			BufferedReader br = new BufferedReader(new FileReader(source));
			
			String line;
			
			while((line = br.readLine()) != null)
			{
				
				String[] word = line.toLowerCase().split("\\s+");
				for(int i=0; i<word.length; i++)
				{
					
					story = story + processWord(word[i]) + " ";
				}
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source) throws IOException{
		
		ArrayList<String> list = new ArrayList<String>();
		
		if (source.startsWith("http")) 
		{
			URL resource = new URL(source);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()));
			
			String line;
			
			while((line = br.readLine()) != null)
			{
				list.add(line);
			}
		}
		else 
		{
			BufferedReader br = new BufferedReader(new FileReader(source));
			
			String line;
			
			while((line = br.readLine()) != null)
			{
				list.add(line);
			}
		}
		return list;
	}
	
	public void makeStory() throws IOException{
	    System.out.println("\n");
		String story = fromTemplate("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data\\dnaMystery1.txt");
		printOut(story, 60);
		
		 System.out.println("\n");
		
		System.out.println(totalWordsInMap());
		
		System.out.println(totalWordsConsidered());
		
//		System.out.println("\n");
//		for (int i=0; i<usedWords.size(); i++) {
//			System.out.println(usedWords.get(i));
//		}
//		
//		
//		System.out.println(usedWords.size());
	}
	
	public int totalWordsInMap() {
		
		int totalWords=0;
		
		for(String word : myMap.keySet())
		{
			totalWords += myMap.get(word).size();
		}
		
		return totalWords;
	}


	public int totalWordsConsidered() {
		
		int totalWords=0;

		for(int i=0; i< categoriesUsed.size(); i++) 
		{
			totalWords += myMap.get(categoriesUsed.get(i)).size();
		}
		
		return totalWords;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		GladLibsMap gl = new GladLibsMap();

		gl.makeStory();
	}

}
