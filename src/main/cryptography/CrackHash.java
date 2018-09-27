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
		
		System.out.println("Hash: " + tempHash);
	}
	
	private static boolean crackHash() throws NoSuchAlgorithmException {
		System.out.println("Guess: " + SHA256.hash(currentGuess.toString()));
		
		for (int i = currentGuess.length() - 1; i >= 0; i--) {
			if (Arrays.asList(possibleCharacters).indexOf(currentGuess.substring(i)) == 35) {
				addString(currentGuess, i);
			} else {
				if (i == currentGuess.length() - 1) {
					currentGuess.setCharAt(i, possibleCharacters[Arrays.asList(possibleCharacters).indexOf(currentGuess.substring(i))+1].charAt(0));
				}
			}
		}
		
		if (SHA256.hash(currentGuess.toString()).equals(tempHash)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static StringBuilder addString(StringBuilder string, int i) {
		StringBuilder out = string;
		int iteration = i;
		
		if (i == 0) {
			currentGuess.append("a");
			currentGuess.setCharAt(i, 'a');
		} else {
			if (Arrays.asList(possibleCharacters).indexOf(Character.toString(currentGuess.charAt(iteration))) == 35) {
				out.setCharAt(iteration, 'a');
				
				if (Arrays.asList(possibleCharacters).indexOf(Character.toString(currentGuess.charAt(iteration - 1))) == 35) {
					if (i == 0) {
						currentGuess.append("a");
						currentGuess.setCharAt(i, 'a');
					}
					
					addString(out, iteration-1);
				} else {
					out.setCharAt(iteration-1, possibleCharacters[Arrays.asList(possibleCharacters).indexOf(Character.toString(currentGuess.charAt(iteration-1)))+1].charAt(0));
				}
			}
		}

		return out;
	}
	
	public static void makeGuess() throws NoSuchAlgorithmException {
		if(crackHash()) {
			System.out.println("Cracked");
		} else {
			//Use Stack pop
			makeGuess();
		}
	}
	
}
