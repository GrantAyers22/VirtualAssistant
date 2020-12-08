package Visual;

import ClickableFrame.CharacterFrame;

import DisplaySprite.Display;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class Movement{

	// Obtaining Screen Size
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static double width = screenSize.getWidth();
	private static double height = screenSize.getHeight();
		
	// creating x and y positioning variables
	private static int x;
	private static int y;
	
	// creating direction, iteration, and frame for movement tracking
	private int direction;
	private int iteration;
	private int framenumber;

	
	
	// creating hashmap for movement
	static Map<Integer, Runnable> Move = new HashMap<>();
	
	// Creating Frame
	private static CharacterFrame frame;
	
			
	Movement(int start_x, int start_y){
		// Setting Variables
		x = start_x;
		y = start_y;
		
		// setting direction iteration and frame
		direction = getDirection();
		iteration = 0;
		framenumber = 0;
		
		// populating the Move hashmap
		Move.put(0, () -> MoveUp());
		Move.put(1, () -> MoveDown());
		Move.put(2, () -> MoveLeft());
		Move.put(3, () -> MoveRight());
		
		
		// Creating the character frame
		frame = new CharacterFrame(35, 55);
		

		// Setting up and running the loop
		boolean running = true;
		
		
		while (running) {
			// moves the character
			moveLoop(framenumber, direction);
			
			// increments necessart values
			IncrementIteration();
			
			// delay
			pause(90);
		}
	
	
	
	}
	
	public static void moveLoop(int frame_num, int dir) {
		if (frame.getPressed()){
			Alert();
		}
		else {
			Wander(frame_num, dir);
		}
	}
	public static void Alert() {
		//OyCunt();
	}
	
	
	public static void Wander(int frame_num, int dir) {

		Move.get(dir).run();		
		BufferedImage Current_Frame = new Display(dir, frame_num).getCurrentSprite();
		frame.ShowAt(Current_Frame, x, y);
	}
	
	
	private void MoveUp() {
		if (y < -32) 
			y = (int) height;
		if (y < 0) 
			iteration = 0;
		y -= 5;
	}
	private void MoveDown() {
		if (y > height)
			y = 0;
		if (y > height-32)
			iteration = 0;
		y += 5;
	}
	private void MoveLeft() {
		if (x < -32)
			x = (int) width;
		if (x < 0)
			iteration = 0;
		x -= 8;
	}
	private void MoveRight() {
		if (x > width)
			x = -32;
		if (x > width-32) 
			iteration = 0;
		x += 8;
	}
	private void IncrementIteration() {
		iteration++;
		framenumber++;
		if (iteration >= 50) {
			direction = getDirection();
			iteration = 0;
		}
		if (framenumber == 4) {
			framenumber = 0;
		}
	}
	
	// Random number generator between 0 and 3 for direction
	private static int getDirection() {
		return ((int) (Math.random() * (3-0 + 1)+0));
		
	}
	/*
	private static void OyCunt() {
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
		frame.setLocation((static) x, y);
		
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
		// delay
		pause(500);
		textbox.setVisible(false);
		frame.resetPressed();
		frame.remove(current_label);
	}
	*/
	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
