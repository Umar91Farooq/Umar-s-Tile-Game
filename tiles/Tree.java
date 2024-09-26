package dev.umar.tilegame.tiles;

import dev.umar.tilegame.gfx.Assets;

public class Tree extends Tile{

	public Tree( int id) {
		super(Assets.tree, id);
		
	}
	
	public boolean isSolid() {
		return true;
	}
}
