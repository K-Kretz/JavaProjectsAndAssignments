/**
 * ASSIGNMENT 2: WordFrequencies
 * 
 * CharactersInPlay Description.
 * The program determines the characters in one of 
 * Shakespeare's plays that have the most speaking parts.
 * Consider the play "The tragedy of Macabeth" in the file
 * macabethSmall.txt
 * 
 * Developer: Keith Kretz
 * Date Created: 6/28/2024
 * Last Updated: 6/28/2024
 */
package characterNames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CharactersInPlay {
	
	private ArrayList<String> myCharacters;
	private ArrayList<Integer> myCount;
	
	public CharactersInPlay() {
		
		myCharacters = new ArrayList<String>();
		myCount = new ArrayList<Integer>();
		
	}
	
	public void update(String person){
		
			int index = myCharacters.indexOf(person);
			
			if(index == -1) 
			{
				myCharacters.add(person);
				myCount.add(1);
			}
			else
			{
				myCount.set(index, myCount.get(index)+1);
			}	
	}
	
	public void findAllCharaters() throws IOException {
		myCharacters.clear();
		myCount.clear();
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\GladLibs\\data\\errors.txt"));
		
		String line;
		String[] periods;
		String[] emptyArray = null;
		
		while((line = br.readLine()) != null)
		{
			periods = line.split("\\.");	
			
			for(int i=0; i<periods.length; i++)
			{
				update(periods[i]);
			}
			
			periods = emptyArray;
		}
		
	}
	
	public void tester() throws IOException {
		
		findAllCharaters();
		
		for(int i=0; i<myCharacters.size(); i++)
		{
			if(myCount.get(i)>1)
			System.out.println(myCharacters.get(i) + "\t" + myCount.get(i));
		}
		characterWithNumParts(10,15);
		
	}
	public void characterWithNumParts(int num1, int num2) {
		
		for(int i=0; i<myCharacters.size(); i++) 
		{
			if(myCount.get(i) >= num1 && myCount.get(i) <= num2) 
			{
				System.out.println(myCharacters.get(i) + " with number of parts greater than or equal to " + num1 + " and less than or equal to " + num2);
			}
		}

		
	}

//	public static void main(String[] args) throws IOException {
//		CharactersInPlay cip = new CharactersInPlay();
//		
//		cip.tester();
//
//	}

}
