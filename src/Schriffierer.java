
public class Schriffierer {

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
