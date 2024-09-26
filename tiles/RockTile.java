package dev.umar.tilegame.tiles;

import dev.umar.tilegame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile( int id) {
		super(Assets.stone, id);
		
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
