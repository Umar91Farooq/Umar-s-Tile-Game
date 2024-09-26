package dev.umar.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public  SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	//to get a desired part of the sheet displayed
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
