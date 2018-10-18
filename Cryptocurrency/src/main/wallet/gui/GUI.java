package main.wallet.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public static Menu menu = new Menu();
	
	private int WINDOW_WIDTH = 340;
	private int WINDOW_HEIGHT = 540;
	
	public GUI() {
		menu.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		super.add(menu);
		
		setTitle("Crypto");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}	
}
