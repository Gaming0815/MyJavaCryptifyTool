package com.mycryptifytool;

public class Crypto {

	/** 
	 * encryptCA
	 * @param text
	 * @param key
	 * @return
	 */
	public String encryptCA(String text, int key) {
		
		String result = "";
		
		for (int i = 0; i < text.length(); i++) {
			
			char currentchar = text.charAt(i);
			int value = (int) currentchar;
			value = value + key;
			char newchar = (char) value;
			result = result + newchar;
		}
		
		return result;
		
	}
	
	/**
	 * decryptCA
	 * @param text
	 * @param key
	 * @return
	 */
	public String decryptCA(String text, int key) {
		
		String result = "";
		
		for (int i = 0; i < text.length(); i++) {
			
			char currentchar = text.charAt(i);
			int value = (int) currentchar;
			value = value - key;
			char newchar = (char) value;
			result = result + newchar;
		}
		
		return result;
		
	}
	
}
