/**
 * ASSIGNMENT 2: TWO KEYS
 * 
 * In this assignment, you will put together the CaesarCipherTwo class that encrypts a message with two keys
 * (the same way as the previous lesson: key1 is used to encrypt every other letter, starting with the first, 
 * and key2 is used to encrypt every other letter, starting with the second), and also decrypts the same message.
 * 
 * Developer: Keith Kretz
 * Date Created: 6/20/2024
 * Last Updated: 6/20/2024
 * 
 */
package com.secure.util;

/**
 * 
 */
public class CaesarCipherTwo {

	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	
	private int mainKey1;
	private int mainKey2;
	
	public CaesarCipherTwo(int key1, int key2) 
	{
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encrypt(String input) {
		
		StringBuilder sb = new StringBuilder(input.toLowerCase());
		
		for(int i=0; i<input.length(); i++) 
		{
			char letter = sb.charAt(i);
			
			int index = alphabet.indexOf(letter);
			
			if(index != -1) 
			{
				if(i%2 == 0) 
				{
					sb.setCharAt(i, shiftedAlphabet1.charAt(index));
				}
				else
				{
					sb.setCharAt(i, shiftedAlphabet2.charAt(index));
				}
			}
		}
		
		return sb.toString();
	}
	
	public String decrypt(String input) {
		
		CaesarCipherTwo cct = new CaesarCipherTwo(26-mainKey1,26-mainKey2);
		
		return cct.encrypt(input);
	}
	
	public static void main(String[] args) {

		CaesarCipherTwo cc1 = new CaesarCipherTwo(14,24);
		

		String test1 = cc1.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println(test1);

		System.out.println(cc1.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
		
	}

}
