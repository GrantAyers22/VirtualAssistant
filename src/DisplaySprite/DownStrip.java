package DisplaySprite;

import java.awt.image.BufferedImage;

public class DownStrip extends Strip{
	
	//Setting the movement Values for Left Strip
	private final int[] movementValues = {0, 1, 2, 3};
	private BufferedImage[] SpriteStrip;
	
	public DownStrip(String path) {
		super(path);
		SpriteStrip = this.createStrip(movementValues);
	}
	public BufferedImage[] getStrip() {
		return SpriteStrip;
	}
}
	