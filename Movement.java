package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Movement{

	// Obtaining Screen Size
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static double width = screenSize.getWidth();
	private static double height = screenSize.getHeight();
	
	// Creating path, x, and y
	private static String path;
	private static int x;
	private static int y;
	
	// Creating Frame
	private static ClickableJFrame frame;
	
			
	Movement(int start_x, int start_y, String p){
		// Setting Variables
		x = start_x;
		y = start_y;
		path = p;
		
		
		frame = new ClickableJFrame(35, 55);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting up Frame Specifications
		frame.setUndecorated(true);
		frame.setSize(new Dimension(35, 55));
						

		// Make it transparent
		frame.setBackground(new Color(0, 0, 0, 0));
		frame.setAlwaysOnTop(true);
			
		// Setting up and running the loop
		boolean running = true;
		int run_counter = 0;
		int frame_counter = 0;
		int dir = getDirection();
		while (running) {
			moveLoop(frame_counter, dir);
			run_counter++;
			frame_counter++;
			
			// Find a new direction
			if (run_counter > 50) {
				dir = getDirection();
				run_counter = 0;			
			}
		
			// Wrap Frames around
			if (frame_counter == 3) {
				frame_counter = 0;
			}
			
			// Try Catch delay
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	}
	
	public static void moveLoop(int iteration, int direction) {
		if (frame.getPressed()){
			Alert();
		}
		else {
			Wander(iteration, direction);
		}
	}
	public static void Alert() {
		Frame framedata = new Frame(path);
		BufferedImage Alert_Frame = framedata.down_frame(0);
		
		// Mess around with Doctor
		// Creating the picture of the current frame	
		ImageIcon pic = new ImageIcon(Alert_Frame);
		JLabel current_label = new JLabel(pic);
		current_label.setSize(new Dimension(35, 55));
					
		// add current label to frame
		frame.add(current_label);
			
		// Packing Frame and making it visible
		frame.pack();
		frame.setVisible(true);
			
		// Placing the Frame
		frame.setLocation(x, y);
		
		JLabel label = new JLabel("OI CUNT!");
		label.setSize(150, 100);
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 33));
		JDialog textbox = new JDialog();
		textbox.add(label);
		textbox.setSize(150, 100);
		textbox.setLocation(frame.getLocation().x-43, frame.getLocation().y - 100);
		textbox.setUndecorated(true);
		textbox.setBackground(new Color(255,255,255,100));
		textbox.setVisible(true);
		
		// keep text box open for 1/2 a second
		// Try Catch delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textbox.setVisible(false);
		frame.resetPressed();
		frame.remove(current_label);
	}
	
	public static void Wander(int iteration, int direction) {
		//Creating the spriteslist
		Frame framedata = new Frame(path);
		BufferedImage Current_Frame = null;
		
		
		switch (direction){
			case 0:
				Current_Frame = framedata.up_frame((iteration));
				y -= 5;
				if (y <= 0) {
					y = (int) height-100;
				}
				break;
			case 1:
				Current_Frame = framedata.down_frame((iteration));
				y += 5;
				if (y >= height-50) {
					y = 0;
				}
				break;
			case 2:
				Current_Frame = framedata.left_frame((iteration));
				x -= 5;
				if (x <= -32) {
					x = (int) width;
				}
				break;
			case 3:
				Current_Frame = framedata.right_frame((iteration));		
				x += 5;
				if (x >= width) {
					x = 0;
				}
				break;
		}
		
		// Creating the picture of the current frame	
		ImageIcon pic = new ImageIcon(Current_Frame);
		JLabel current_label = new JLabel(pic);
		current_label.setSize(new Dimension(35, 55));
		
		
		// add current label to frame
		frame.add(current_label);
		
		// Packing Frame and making it visible
		frame.pack();
		frame.setVisible(true);
		
		// Placing the Frame
		frame.setLocation(x, y);
		
		// Deleting the current iteration of the man
		frame.remove(current_label);
	}
	
	// Random number generator between 0 and 3 for direction
	private static int getDirection() {
		return ((int) (Math.random() * (3-0 + 1)+0));
	}
}
