
public class Logic {

	WindowBuilder windowbuilder;

	public Logic(WindowBuilder parentWindowBuilder) {

		windowbuilder = parentWindowBuilder;
		
	}

	public String encryptInputText(String text, int key) {

		return schriffierenCA(text, key);

	}

	public String decryptInputText(String encryptedtext, int key) {

		return deschriffierenCA(encryptedtext, key);

	}

	public String schriffierenCA(String text, int key) {

		String result = "";

		for (int i = 0; i < text.length(); i++) {

			char currentchar = text.charAt(i);
			int value = currentchar;
			value = value + key;
			char newchar = (char) value;
			result = result + newchar;
		}

		return result;

	}

	public String deschriffierenCA(String text, int key) {

		String result = "";

		for (int i = 0; i < text.length(); i++) {

			char currentchar = text.charAt(i);
			int value = currentchar;
			value = value - key;
			char newchar = (char) value;
			result = result + newchar;
		}
		
		return result;
		
	}
	
}
