package cz.ysoft.demo.encryption.morse;

import cz.ysoft.demo.encryption.Encoder;

public class MorseEncoder implements Encoder {
	private static final String UNKNOWN_CHARACTER = "?";

	private static final Encoder INSTANCE = new MorseEncoder();

	static char[] ENGLISH = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ' };

	static String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
			"..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|" };
	
/*	static Map<Character, String> encoder;
	static Map<String, Character> decoder;
	static {
		System.out.println(MORSE.length);
		System.out.println(ENGLISH.length);
		System.out.println(String.valueOf('c'));
		encoder = new HashMap<Character, String>();
		decoder = new HashMap<String, Character>();

		for (int i = 0; i < ENGLISH.length; i++) {
			encoder.put(ENGLISH[i], MORSE[i]);
			decoder.put(MORSE[i], ENGLISH[i]);
		}
	}
*/

	public String encode(String c) {
		if (c == null) {
			return null;
		}
		c = c.toLowerCase();

		StringBuilder stringBuilder = new StringBuilder();
		for (int x = 0; x < c.length(); x++) {

			// string.append(encoder.get(c.charAt ( x )) + " " );

			String string = null;
			for (int y = 0; y < ENGLISH.length; y++) {
				if (ENGLISH[y] == c.charAt(x))

					string = MORSE[y] + " ";

			}
			if(string == null) {
				string = UNKNOWN_CHARACTER + " ";
			}
			stringBuilder.append(string);

		}

		return stringBuilder.toString();
	}

	public String decode(String b) {
		if (b == null) {
			return null;
		}
		String[] words = null;
		if (b.contains("|")) {
			words = b.split("[|]");
		} else {
			words = new String[1];
			words[0] = b;
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (String word : words) {
			String[] characters = word.split(" ");
			for (int h = 0; h < characters.length; h++) {
				String string = null;
				for (int i = 0; i < MORSE.length; i++) {
					if (characters[h].equals(MORSE[i])) {
						string = String.valueOf(ENGLISH[i]);
					}
				}
				if(characters[h].equals(UNKNOWN_CHARACTER)) {
					string = UNKNOWN_CHARACTER;
				}
				else if(string == null) {
					string = "";
				}
				stringBuilder.append(string);
			}
			stringBuilder.append(" ");
		}

		return stringBuilder.toString();
	}

	public static Encoder getInstance() {
		return INSTANCE;
	}

}
