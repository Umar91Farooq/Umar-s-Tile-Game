package dev.umar.tilegame.entities.statics;

import java.awt.Graphics;

import dev.umar.tilegame.Handler;
import dev.umar.tilegame.gfx.Assets;
import dev.umar.tilegame.items.Item;
import dev.umar.tilegame.tiles.Tile;

public class Gem extends StaticEntity{
	public Gem(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		bounds.x =3;
		bounds.y =(int) (height / 2f);
		bounds.width = width -6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.gemItem.createNew((int)x,  (int)y));

		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gem, (int)(x - handler.getGameCamera().getxOffset()) ,
				(int) (y - handler.getGameCamera().getyOffset()),
				width, height, null);
		
	
	}
}