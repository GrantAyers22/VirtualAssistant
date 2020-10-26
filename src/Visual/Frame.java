package Visual;

import java.awt.image.BufferedImage;

public class Frame {
	private BufferedImage[] sprites = new BufferedImage[16];
	private BufferedImage[] up_strip = new BufferedImage[4];
	private BufferedImage[] down_strip = new BufferedImage[4];
	private BufferedImage[] left_strip = new BufferedImage[4];
	private BufferedImage[] right_strip = new BufferedImage[4];
	private String path;
	
	
	Frame(String p){
		path = p;
		
		// Creating the sprite sheet of all sprites
		sprites = new SpriteArray(path).getSheet();
		
		// creating the strip of up movement
		this.up_strip[0] = sprites[12];
		this.up_strip[1] = sprites[13];
		this.up_strip[2] = sprites[14];
		this.up_strip[3] = sprites[15];
		
		// creating the strip of down movement
		this.down_strip[0] = sprites[0];
		this.down_strip[1] = sprites[1];
		this.down_strip[2] = sprites[2];
		this.down_strip[3] = sprites[3];
		
		// creating the strip of left movement
		this.left_strip[0] = sprites[4];
		this.left_strip[1] = sprites[5];
		this.left_strip[2] = sprites[6];
		this.left_strip[3] = sprites[7];
		
		// creating the strip of right movement
		this.right_strip[0] = sprites[8];
		this.right_strip[1] = sprites[9];
		this.right_strip[2] = sprites[10];
		this.right_strip[3] = sprites[11];
		
		
	}
	
	// returns a frame of up movement
	public BufferedImage up_frame(int frame_number) {
		if (frame_number >= 4) {
			frame_number = 0;
		}
		return (this.up_strip[frame_number]);
	}
	
	// returns a frame of down movement
	public BufferedImage down_frame(int frame_number) {
		if (frame_number >= 4) {
			frame_number = 0;
		}
		return (this.down_strip[frame_number]);
	}
	
	// returns a frame of left movement
	public BufferedImage left_frame(int frame_number) {
		if (frame_number >= 4) {
			frame_number = 0;
		}
		return (this.left_strip[frame_number]);
	}
	
	// returns a frame of right movement
	public BufferedImage right_frame(int frame_number) {
		if (frame_number >= 4) {
			frame_number = 0;
		}
		return (this.right_strip[frame_number]);
	}
}
