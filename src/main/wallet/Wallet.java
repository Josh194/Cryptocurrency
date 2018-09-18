package main.wallet;

import java.security.NoSuchAlgorithmException;

import main.cryptography.CrackHash;

public class Wallet {
	
	public static int amount = 0;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		CrackHash.generateHash();
		
		CrackHash.makeGuess();
	}
	
}
