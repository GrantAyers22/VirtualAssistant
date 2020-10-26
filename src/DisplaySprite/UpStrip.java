package DisplaySprite;

import DisplaySprite.Strip;
import DisplaySprite.SpriteSheet;
import java.awt.image.BufferedImage;

public class UpStrip extends Strip{
	
	// These are the values of moving up
	private final int[] UpValues = {12,13,14,15};
	private BufferedImage[] SpriteStrip;
	
	public UpStrip(String path) {
		super(path);
		SpriteStrip = this.createStrip(UpValues);
	}
	
	public BufferedImage[] getStrip() {
		return SpriteStrip;
	}
}
	