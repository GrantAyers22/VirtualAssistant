package Visual;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteArray {
	
	// Setting path
	private static String path = "";
	
	SpriteArray(String p) {
		setPath(p);
	}
	
	// Sprite Sheet function
	public BufferedImage[] getSheet() {
			
			BufferedImage bigImg = null;
			try {
				bigImg = ImageIO.read(new File(getPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// The above line throws an checked IOException which must be caught.

			final int width = 32;
			final int height = 50;
			final int rows = 4;
			final int cols = 4;
			BufferedImage[] sprites = new BufferedImage[rows * cols];

			for (int i = 0; i < rows; i++){
			    for (int j = 0; j < cols; j++){
			        sprites[(i * cols) + j] = bigImg.getSubimage(j * width,
			        											 i * height,
			        											 width,
			        											 height);
			    }
			}
			return sprites;
		}

	public static String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
