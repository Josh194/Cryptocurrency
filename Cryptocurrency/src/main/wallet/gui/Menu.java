package main.wallet.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(new Color(0, 66, 103));
		
		repaint();
	}
}
