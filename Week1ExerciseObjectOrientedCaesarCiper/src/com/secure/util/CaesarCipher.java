/** 
 * ASSIGNMENT 1: ONE KEY
 * 
 * In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method to decrypt with the same key. 
 * In addition you will create a second class, TestCaesarCipher to test examples that use the CaesarCipher class, including writing a method 
 * that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.
 * 
 * Developer: Keith Kretz
 * Date Created: 6/19/2024
 * Last Updated: 6/19/2024
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
		
		StringBuilder sb = new StringBuilder(input);
		
		for(int i=0; i <input.length(); i++)
		{
			char letter = input.charAt(i);
			
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		CaesarCipher cc1 = new CaesarCipher(17);
		

		String test1 = cc1.encrypt("This is a Test");
		System.out.println(test1);
		
		System.out.println(cc1.decrypt(test1));
		
	}

}
