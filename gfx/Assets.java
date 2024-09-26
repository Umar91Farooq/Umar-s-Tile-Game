package dev.umar.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width=48, height=64 ,charWidth = 64 , charHeight = 64;
	
	public static Font font28, font48;
	
	public static BufferedImage dirt , grass , stone , tree ,wood ,gem , ruby, sapphire, emerald;
	public static BufferedImage[] player_down , player_up , player_left , player_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	
	public static void init() {
		
		font28 =FontLoader.loadFont("res/fonts/slkscr.ttf.ttf", 28);
		font48 =FontLoader.loadFont("res/fonts/vf.ttf.ttf", 48);
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen_files/button_default.png");
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/forest.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/char.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/tree.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/wall.png"));
		SpriteSheet sheet5 = new SpriteSheet(ImageLoader.loadImage("/textures/ui.png"));
		SpriteSheet sheet6 = new SpriteSheet(ImageLoader.loadImage("/textures/gems.png"));
		SpriteSheet sheet7 = new SpriteSheet(ImageLoader.loadImage("/textures/woodlog.png"));
		
		btn_start =new BufferedImage[2];
		btn_start[0]=sheet5.crop(0, 0, 238 , 125);
		btn_start[1]= sheet5.crop(0, 125 , 238 , 125);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_down[0] = sheet2.crop(0, 0, charWidth, charHeight);
		player_down[1] = sheet2.crop(charWidth, 0, charWidth, charHeight);
		player_down[2] = sheet2.crop(charWidth *2 , 0, charWidth, charHeight);
		player_down[3] = sheet2.crop(charWidth *3 , 0, charWidth, charHeight);
		
		player_up[0] = sheet2.crop(0, charHeight *3, charWidth, charHeight);
		player_up[1] = sheet2.crop(charWidth, charHeight *3, charWidth, charHeight);
		player_up[2] = sheet2.crop(charWidth *2 , charHeight *3, charWidth, charHeight);
		player_up[3] = sheet2.crop(charWidth *3 , charHeight *3, charWidth, charHeight);
		
		player_left[0] = sheet2.crop(0, charHeight, charWidth, charHeight);
		player_left[1] = sheet2.crop(charWidth, charHeight, charWidth, charHeight);
		player_left[2] = sheet2.crop(charWidth *2 , charHeight, charWidth, charHeight);
		player_left[3] = sheet2.crop(charWidth *3 , charHeight, charWidth, charHeight);
		
		player_right[0] = sheet2.crop(0, charHeight *2, charWidth, charHeight);
		player_right[1] = sheet2.crop(charWidth, charHeight *2, charWidth, charHeight);
		player_right[2] = sheet2.crop(charWidth *2 , charHeight *2, charWidth, charHeight);
		player_right[3] = sheet2.crop(charWidth *3 , charHeight *2, charWidth, charHeight);
		
		
		dirt =sheet.crop( 0, height *2, width, height);
		grass =sheet.crop(width, height*3, width, height);
		stone =sheet4.crop(0, 0, 250, 250);
		tree =sheet3.crop(0,0,473,542);
		gem =sheet6.crop(125, 125, 125, 125);
		ruby =sheet6.crop(0, 125, 125, 125);
		sapphire=sheet6.crop(0,0,125,125);
		emerald=sheet6.crop(125, 0, 125, 125);
		wood= sheet7.crop(0,0, 256, 256);
	}

}
