package com.mycryptifytool;

public class Crypto {

	/**
	 * Encrypts text with a code using caesar encryption. (unsafe)
	 * @param text
	 * @param key
	 * @return String
	 */
	public static String encryptCaesarCipher(String text, int key) {
		
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
	 * Decrypts caesar encrypted text if correct code is given.
	 * @param text
	 * @param key
	 * @return String
	 */
	public static String decryptCaesarCipher(String text, int key) {
		
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

	/**
	 * Encrypts text with a password using poly-alphabetically encryption. (unsafe)
	 * @param text
	 * @param password
	 * @return String
	 */
	public static String encryptPolyalphabetic(String text, String password) {

		String result = "";
		String key = "";
		int repeat;
		int remainder;

		if (text.length() >= password.length()) {

			repeat = text.length() / password.length();
			remainder = text.length() % password.length();

			key = new String(new char[repeat + 1]).replaceAll(".", password).substring(0,
					password.length() * repeat + remainder);

		} else {

			key = password.substring(0, text.length());

		}

		for (int i = 0; i < key.length(); i++) {

			char currenttextchar = text.charAt(i);
			char currentkeychar = key.charAt(i);
			int textvalue = (int) currenttextchar;
			int keyvalue = (int) currentkeychar;
			int value = textvalue + keyvalue;
			char newchar = (char) value;
			result = result + newchar;

		}
		
		return result;

	}
	
	/**
	 * Decrypts poly-alphabetically encrypted text if correct password is given.
	 * @param text
	 * @param password
	 * @return String
	 */
	public static String decryptPolyalphabetic(String text, String password) {

		String result = "";
		String key = "";
		int repeat;
		int remainder;

		if (text.length() >= password.length()) {

			repeat = text.length() / password.length();
			remainder = text.length() % password.length();

			key = new String(new char[repeat + 1]).replaceAll(".", password).substring(0,
					password.length() * repeat + remainder);

		} else {

			key = password.substring(0, text.length());

		}

		for (int i = 0; i < key.length(); i++) {

			char currenttextchar = text.charAt(i);
			char currentkeychar = key.charAt(i);
			int textvalue = (int) currenttextchar;
			int keyvalue = (int) currentkeychar;
			int value = textvalue - keyvalue;
			char newchar = (char) value;
			result = result + newchar;

		}
		
		return result;

	}
	
}
