
public class Logic {

	WindowBuilder windowbuilder;

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
		
		return schriffierenCA(text, key);
		
	}
	
	/**
	 * decryptInputText
	 * @param encryptedtext
	 * @param key
	 * @return
	 */
	public String decryptInputText(String encryptedtext, int key) {
		
		return deschriffierenCA(encryptedtext, key);
		
	}
	
	
	/** 
	 * schriffierenCA
	 * @param text
	 * @param key
	 * @return
	 */
	public String schriffierenCA(String text, int key) {
		
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
	 * deschriffierenCA
	 * @param text
	 * @param key
	 * @return
	 */
	public String deschriffierenCA(String text, int key) {
		
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
