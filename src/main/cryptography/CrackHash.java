package main.cryptography;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class CrackHash {
	
	private static String tempHash = "";
	private static Random randomGen = new Random();
	private static StringBuilder currentGuess = new StringBuilder("a");
	private static String[] possibleCharacters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public static void generateHash() throws NoSuchAlgorithmException {
		byte[] stringLength = new byte[8];
		
	    randomGen.nextBytes(stringLength);
		
		tempHash = SHA256.hash(new String(stringLength, Charset.forName("UTF-8")));
		
		System.out.println(tempHash);
	}
	
	private static boolean crackHash() throws NoSuchAlgorithmException {
		for (int i = currentGuess.length() - 1; i >= 0; i--) {
			if (Arrays.asList(possibleCharacters).indexOf(currentGuess.substring(i)) == 35) {
				//Append to BEGINNING, NOT END
				currentGuess.append("a");
				currentGuess.setCharAt(i, (char) 0);
				currentGuess.setCharAt(i+1, possibleCharacters[Arrays.asList(possibleCharacters).indexOf(currentGuess.substring(i))+1].charAt(0));
			} else {
				currentGuess.setCharAt(i, possibleCharacters[Arrays.asList(possibleCharacters).indexOf(currentGuess.substring(i))+1].charAt(0));
			}
		}
		
		System.out.println(currentGuess);
		
		if (SHA256.hash("a").equals(tempHash)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void makeGuess() throws NoSuchAlgorithmException {
		if (crackHash()) {
			System.out.println("Cracked");
		} else {
			makeGuess();
		}
	}
	
}
