package tcptextlengthserver;

/**
 * This class processes length of text
 *
 */
public class TextProcessor {
	
	public String getTextLength() {
		
		String text = "Utility";
		int textLength = text.length();
	
		return "The length of the String '" + text + "' " + "is " + textLength;
	}
	
}
