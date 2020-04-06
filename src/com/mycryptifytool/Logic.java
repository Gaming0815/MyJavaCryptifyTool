package com.mycryptifytool;


public class Logic {

	WindowBuilder windowbuilder;
	Crypto crypto;

	/**
	 * Logic
	 * @param parentWindowBuilder
	 */
	public Logic(WindowBuilder parentWindowBuilder) {

		windowbuilder = parentWindowBuilder;
		
	}
	
	/**
	 * encryptInputText
	 * @param text
	 * @param key
	 * @return
	 */
	public String encryptInputText(String text, int key) {
		
		return crypto.encryptCA(text, key);
		
	}
	
	/**
	 * decryptInputText
	 * @param encryptedtext
	 * @param key
	 * @return
	 */
	public String decryptInputText(String encryptedtext, int key) {
		
		return crypto.decryptCA(encryptedtext, key);
		
	}
	
}
