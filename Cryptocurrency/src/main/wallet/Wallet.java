package main.wallet;

import java.security.NoSuchAlgorithmException;

import javax.swing.SwingUtilities;

import main.cryptography.CrackHash;
import main.wallet.gui.GUI;

public class Wallet {
	
	public static int amount = 0;
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});		
		
		CrackHash.generateHash();
		
		CrackHash.makeGuess();
	}
}
