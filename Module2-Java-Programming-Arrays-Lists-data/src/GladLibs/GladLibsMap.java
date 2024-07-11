/**
 * EXAMPLE 3: GladLibsMap
 * 
 * Improve the GladLibs class to use HashMaps.
 * 
 * Developer: Keith Kretz
 * Date Created: 7/9/2024
 * Last Updated: 7/9/2024
 */
package GladLibs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GladLibsMap {
	
	
	
	private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
	private ArrayList<String> timeList;
	private ArrayList<String> verbList;
	private ArrayList<String> fruitList;
	private ArrayList<String> usedWords;
	
	private Random myRandom;
	
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data";
	
	public GladLibsMap() throws IOException{
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}
	
	public GladLibsMap(String source) throws IOException{
		initializeFromSource(source);
		myRandom = new Random();
	}
	
	private void initializeFromSource(String source) throws IOException {
		adjectiveList= readIt(source+"\\adjective.txt");	
		nounList = readIt(source+"\\noun.txt");
		colorList = readIt(source+"\\color.txt");
		countryList = readIt(source+"\\country.txt");
		nameList = readIt(source+"\\name.txt");		
		animalList = readIt(source+"\\animal.txt");
		timeList = readIt(source+"\\timeframe.txt");	
		verbList = readIt(source+"\\verb.txt");
		fruitList = readIt(source+"\\fruit.txt");
		usedWords = new ArrayList<String>();
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		if (label.equals("country")) {
			return randomFrom(countryList);
		}
		if (label.equals("color")){
			return randomFrom(colorList);
		}
		if (label.equals("noun")){
			return randomFrom(nounList);
		}
		if (label.equals("name")){
			return randomFrom(nameList);
		}
		if (label.equals("adjective")){
			return randomFrom(adjectiveList);
		}
		if (label.equals("animal")){
			return randomFrom(animalList);
		}
		if (label.equals("timeframe")){
			return randomFrom(timeList);
		}
		if (label.equals("verb")){
			return randomFrom(verbList);
		}
		if (label.equals("fruit")){
			return randomFrom(fruitList);
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
		String story = fromTemplate("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data\\madtemplate2.txt");
		printOut(story, 60);
		
		System.out.println("\n");
		for (int i=0; i<usedWords.size(); i++) {
			System.out.println(usedWords.get(i));
		}
		
		System.out.println(usedWords.size());
	}


	
	
	
	public static void main(String[] args) throws IOException {
		
		GladLibsMap gl = new GladLibsMap();

		gl.makeStory();
	}

}
