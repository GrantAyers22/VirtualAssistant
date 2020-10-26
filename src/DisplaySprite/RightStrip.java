package DisplaySprite;

import java.awt.image.BufferedImage;

public class RightStrip extends Strip{

	//Setting the movement Values for Left Strip
	private final int[] movementValues = {8,9,10,11};
	private BufferedImage[] SpriteStrip;
	
	public RightStrip(String path) {
		super(path);
		SpriteStrip = this.createStrip(movementValues);
	}
	public BufferedImage[] getStrip() {
		return SpriteStrip;
	}
}
	