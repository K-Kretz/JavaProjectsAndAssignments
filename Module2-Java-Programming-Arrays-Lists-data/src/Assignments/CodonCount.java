/**
 * Assignment 1: CodonCount
 * 
 * Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. 
 * A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. 
 * A reading frame is a way of dividing a strand of DNA into consecutive codons. 
 * 
 * Developer: Keith Kretz
 * Date Created: 7/9/2024
 * Last Updated: 7/9/2024
 */
package Assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CodonCount {


	private HashMap<String,Integer> codonMap;
	
	public CodonCount() {
		
		codonMap = new HashMap<String, Integer>();	
	}
	
	public void buildCodonMap(int start, String dna) {
		
		codonMap.clear();

		for(int i=start; i<dna.length(); i=i+3)
		{
			if(i+3 <=dna.length()) 
			{
				String codon = dna.substring(i,i+3);
				
				if(codonMap.keySet().contains(codon))
				{
					codonMap.put(codon, codonMap.get(codon)+1);
				}
				else 
				{
					codonMap.put(codon, 1);
				}
			}
		}
		int thisStart = 1;
		int thisEnd = 5;
		
		String commonCodon = getMostCodon();

		System.out.println("Reading frame starting with "+start+" results in "+codonMap.size()+" unique codons \n"
							+"and most common codon is "+commonCodon+" with count "+ codonMap.get(commonCodon)+"\n");
		
		System.out.println("Counts of codons between "+thisStart+" and "+thisEnd+" inclusive are:");
		printCodonCounts(thisStart,thisEnd);
		
	}
	
	public String getMostCodon() 
	{
		String commonCodon = null;
		int commonCodonValue = 0;
		for(String codonKey : codonMap.keySet())
		{
			
			if(codonMap.get(codonKey) > commonCodonValue)
			{
				commonCodonValue=codonMap.get(codonKey);
				commonCodon = codonKey;
			}
		}
		return commonCodon;
	}
	
	public void printCodonCounts(int start, int end) {
		
		for(String codonKey : codonMap.keySet())
		{
			
			if((codonMap.get(codonKey) >= start) && (codonMap.get(codonKey) <= end))
			{
				System.out.println(codonKey + "\t" + codonMap.get(codonKey));
			}
		}
		
	}
	
	public void testerCodonMap() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Module2-Java-Programming-Arrays-Lists-data\\src\\Assignments\\dna.txt"));
		
		String line = br.readLine();

		line.toUpperCase();
		
		buildCodonMap(0,line);
		System.out.println();
		buildCodonMap(1,line);
		System.out.println();
		buildCodonMap(2,line);
		System.out.println();
			
	}
		

	
	public static void main(String[] args) throws IOException {
		CodonCount cc = new CodonCount();
		
		cc.testerCodonMap();

	}

}
