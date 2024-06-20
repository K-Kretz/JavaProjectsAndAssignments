/**
 * ASSIGNMENT 1: ONE KEY
 * 
 *  Create a second class, TestCaesarCipher to test examples that use the CaesarCipher class, 
 *  including writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.
 * 
 * Developer: Keith Kretz
 * Date Created: 6/19/2024
 * Last Updated: 6/19/2024
 * 
 */
package com.secure.util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */
public class TestCaesarCipher {

	public int[] countLetters(String input) {
		
		int[] counter = new int[26];
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<input.length(); i++)
		{
			char letter = Character.toLowerCase(input.charAt(i));
			
			int index = alphabet.indexOf(letter);
			
			if(index != -1)
				counter[index]++;
		}
		
		return counter;
	}
	
	
	public int maxIndex(int[] freq) {
		
		int max=0;
		
		for(int i=0; i<freq.length; i++) {
			
			if(freq[i]>freq[max])
				max = i;
		}
		
		return max;
	}
	
	
	public void simpleTests() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Week1ExerciseObjectOrientedCaesarCiper\\src\\com\\secure\\util\\TestFile.txt"));
		
		String fileAsString = br.readLine();
		
		CaesarCipher cc = new CaesarCipher(18);
		
		String encryptedString = cc.encrypt(fileAsString);
		System.out.println(encryptedString);
		
		System.out.println(breakCaesarCipher(encryptedString));
		
	}
	
	public String breakCaesarCipher(String input) {
		
		int[] freq = countLetters(input);
		
		int mostCommonLetterIndex = maxIndex(freq);
		
		int decryptKey = mostCommonLetterIndex - 4;
		
		if(mostCommonLetterIndex < 4)
		{
			decryptKey = 26 - (4-mostCommonLetterIndex);
		}
		
		CaesarCipher cc = new CaesarCipher(decryptKey);
		
		return cc.decrypt(input);
	}
	
	public static void main(String[] args) throws IOException {
		
		TestCaesarCipher tcc = new TestCaesarCipher();
		
		tcc.simpleTests();
		
	}
}
