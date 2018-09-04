package main.cryptography;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class CrackHash {
	
	private static String tempHash = "";
	private static Random randomGen = new Random();
	
	public static void generateHash() throws NoSuchAlgorithmException {
		byte[] stringLength = new byte[8];
		
	    randomGen.nextBytes(stringLength);
		
		tempHash = SHA256.hash(new String(stringLength, Charset.forName("UTF-8")));
		
		System.out.println(tempHash);
	}
	
	public static boolean crackHash() throws NoSuchAlgorithmException {
		
		if (SHA256.hash("a").equals(tempHash)) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
