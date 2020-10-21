// Package
package Visual;

// imports
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import javax.imageio.ImageIO;
import Visual.Movement;
import Visual.SpriteArray;


// Main class
public class main {
	
	// Obtaining Screen Size
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static double width = screenSize.getWidth();
	private static double height = screenSize.getHeight();
		
	// Main function
	public static void main(String[] args) {
		
		String sprite_path = "\\D:\\Virtual Assistant\\Sprite_Sheet.png";
		int w = (int) width/2;
		int h = (int) height/2;
		Movement m = new Movement(w, h, sprite_path);
		
    } 

}
