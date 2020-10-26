package ClickableFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//look into adding a serial id

public class CharacterFrame extends BasicFrame {

	private int width;
	private int height;
	
	public CharacterFrame(int w, int h) {
		super(w, h);
		
		width = w;
		height = h;
	
		// Setting Close Operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// remove minimize, enlarge and maximize
		this.setUndecorated(true);
						

		// Make it transparent
		this.setBackground(new Color(0, 0, 0, 0));
		
		// Set to be on top of visual stack
		this.setAlwaysOnTop(true);
		
		
	}
	public void ShowAt(BufferedImage current_sprite, int x, int y) {
		// Creating the picture of the current frame	
		ImageIcon pic = new ImageIcon(current_sprite);
		JLabel current_label = new JLabel(pic);
		current_label.setSize(width, height);
		
		this.add(current_label);

		// Pack and set visible
		this.pack();
		this.setVisible(true);
		
		// Placing the Frame
		this.setLocation(x, y);
		
		this.remove(current_label);
	}

	
}
