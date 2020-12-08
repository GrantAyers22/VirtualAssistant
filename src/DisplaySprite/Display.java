package DisplaySprite;

import java.awt.image.BufferedImage;

import DisplaySprite.Strip;
import DisplaySprite.UpStrip;
import DisplaySprite.DownStrip;
import DisplaySprite.LeftStrip;
import DisplaySprite.RightStrip;

public class Display {
	
	private int direction;
	private int frameNumber;
	private final String path = "\\D:\\Virtual Assistant\\Sans_spritesheet.png";
	private BufferedImage[][] frames= {new UpStrip(path).getStrip(),
			  						   new DownStrip(path).getStrip(),
			  						   new LeftStrip(path).getStrip(),
			  						   new RightStrip(path).getStrip()};
	
	public Display(int d, int fn) {
		direction = d;
		frameNumber = fn;
	}
	
	public BufferedImage getCurrentSprite() {
		return frames[direction][frameNumber];
	}
	
	
}
