package DisplaySprite;

import java.awt.image.BufferedImage;

public class LeftStrip extends Strip{

	//Setting the movement Values for Left Strip
	private final int[] movementValues = {4,5,6,7};
	private BufferedImage[] SpriteStrip;
	
	public LeftStrip(String path) {
		super(path);
		SpriteStrip = this.createStrip(movementValues);
	}
	public BufferedImage[] getStrip() {
		return SpriteStrip;
	}

}
