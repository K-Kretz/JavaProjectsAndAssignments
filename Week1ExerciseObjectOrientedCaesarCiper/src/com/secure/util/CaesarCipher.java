/** 
 * ASSIGNMENT 1: ONE KEY
 * 
 * In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method to decrypt with the same key. 
 * 
 * Developer: Keith Kretz
 * Date Created: 6/19/2024
 * Last Updated: 6/20/2024
 * 
 */
package com.secure.util;

/**
 * 
 */
public class CaesarCipher {
	
	private String alphabet;
	private String shiftedAlphabet;
	
	private int mainKey;
	
	public CaesarCipher(int key) {
		alphabet = "abcdefghijklmnopqrstuvwxyz";
		shiftedAlphabet =alphabet.substring(key) + alphabet.substring(0, key);
		
		mainKey = key;
	}
	
	public String encrypt(String input) {
		
		StringBuilder sb = new StringBuilder(input.toLowerCase());
		
		for(int i=0; i <input.length(); i++)
		{
			char letter = sb.charAt(i);
			
			int index = alphabet.indexOf(letter);
			
			if(index!= -1)
				sb.setCharAt(i, shiftedAlphabet.charAt(index));
		}
		
		return sb.toString();	
	}
	
	public String decrypt(String input) {
		
		CaesarCipher cc = new CaesarCipher(26-mainKey);
		
		return cc.encrypt(input);
	}

	public static void main(String[] args) {
	
		CaesarCipher cc1 = new CaesarCipher(15);
		

		String test1 = cc1.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println(test1);
		
		System.out.println(cc1.decrypt(test1));
		
	}

}
