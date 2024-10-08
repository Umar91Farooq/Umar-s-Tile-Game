package dev.umar.tilegame.entities.statics;

import java.awt.Graphics;

import dev.umar.tilegame.Handler;
import dev.umar.tilegame.gfx.Assets;
import dev.umar.tilegame.items.Item;
import dev.umar.tilegame.tiles.Tile;

public class Tree extends StaticEntity {
	 
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);
		
		bounds.x =10;
		bounds.y =(int) (height / 1.6f);
		bounds.width = width -20;
		bounds.height = (int) (height - height / 1.2f);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)(x),  (int)(y)));
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()) ,
				(int) (y - handler.getGameCamera().getyOffset()),
				width, height, null);
		
	}
}

