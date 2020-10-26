package DisplaySprite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage[] sprites;
	
	public SpriteSheet(String path) {
		generateSpriteSheet(path);
		
	}
	private void generateSpriteSheet(String p) {
		BufferedImage bigImg = null;
		
		try {
			bigImg = ImageIO.read(new File(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// The above line throws an checked IOException which must be caught.

		final int width = 32;
		final int height = 50;
		final int rows = 4;
		final int cols = 4;
		sprites = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++){
		    for (int j = 0; j < cols; j++){
		        sprites[(i * cols) + j] = bigImg.getSubimage(j * width,
		        											 i * height,
		        											 width,
		        											 height);
		    }
		}
	}
	public BufferedImage[] getSprites() {
		return sprites;
	}
}
