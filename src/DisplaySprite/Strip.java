package DisplaySprite;

import DisplaySprite.SpriteSheet;

import java.awt.image.BufferedImage;

public class Strip {

	private BufferedImage[] movementStrip;
	private String path;
	private int movementStripIterator;
	
	
	public Strip(String p){
		path = p;
	}
	
	public BufferedImage[] createStrip(int[] movementValues) {
		movementStripIterator = 0;
		BufferedImage[] all_movement = new SpriteSheet(path).getSprites();
		movementStrip = new BufferedImage[movementValues.length];

		
		for (int i = 0; i < all_movement.length; i++) {
			for (int j = 0; j < movementValues.length; j++) {
				if (i == movementValues[j]) {
					movementStrip[movementStripIterator] = all_movement[i];
					movementStripIterator++;
				}
			}
		}
		return movementStrip;
	}
	
}
