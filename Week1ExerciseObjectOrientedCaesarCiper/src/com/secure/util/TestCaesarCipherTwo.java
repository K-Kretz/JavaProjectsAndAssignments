/**
 * ASSIGNMENT 2: TWO KEYS
 * 
 * Create a second class, TestCaesarCipherTwo to test examples that use the CaesarCipherTwo class, 
 * including writing a method that will automatically decrypt an encrypted file by determining the 
 * two keys that were used to encrypt it. 
 * 
 * Developer: Keith Kretz
 * Date Created: 6/20/2024
 * Last Updated: 6/20/2024
 * 
 */
package com.secure.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestCaesarCipherTwo {

	public int[] countLetters(String encrypt) {
		
		int[] counter = new int[26];
		String alphabet ="abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<encrypt.length(); i++) {
			
			char letter = Character.toLowerCase(encrypt.charAt(i));
			
			int index = alphabet.indexOf(letter);
			
			if(index != -1)
				counter[index]++;
		}
		
		return counter;
	}
	
	public int maxIndex(int[] freq) {
		
		int maxIndex = 0;
		for(int i=0; i<freq.length; i++)
		{
			if(freq[i] > freq[maxIndex])
				maxIndex =i;
		}
		
		return maxIndex;
	}
	
	
	public String halfOfString(String message, int start) {
		
		StringBuilder sbNew = new StringBuilder();
		for(int i=start; i<message.length(); i+=2) 
		{
			sbNew.append(message.charAt(i));
				
		}
		
		return sbNew.toString();
	}
	public int getKey(String s) {
		
		int[] freq = countLetters(s);
		
		int mostCommonLetterIndex = maxIndex(freq); 
		
		int decryptKey = mostCommonLetterIndex - 4;
		
		if(mostCommonLetterIndex < 4)
		{
			decryptKey = 26 - (4-mostCommonLetterIndex);
		}
		
		return decryptKey;
	}
	
	public String breakCaesarCipher(String input) {
		
		String firstHalf = halfOfString(input, 0);
		String secondHalf = halfOfString(input, 1);
		
		int firstHalfKey = getKey(firstHalf);
		int secondHalfKey = getKey(secondHalf);
		
		System.out.println("First Key: " + firstHalfKey);
		System.out.println("Second Key: " + secondHalfKey);
		
		CaesarCipherTwo cc3 = new CaesarCipherTwo(firstHalfKey,secondHalfKey);
		
		return cc3.decrypt(input);
	}
	
	
	public void simpleTests() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\keith\\git\\repository\\Week1ExerciseObjectOrientedCaesarCiper\\src\\com\\secure\\util\\smallHamlet.txt"));
		
		String fileAsString = br.readLine();
		
		CaesarCipherTwo cct = new CaesarCipherTwo(21,8);
		
		String encryptedString = cct.encrypt(fileAsString);
		System.out.println(encryptedString);
		
		System.out.println(breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
		
	}
	
	
	public static void main(String[] args) throws IOException {
		TestCaesarCipherTwo tcct = new TestCaesarCipherTwo();
		
		tcct.simpleTests();

	}

}
