package dev.umar.tilegame.entities.statics;

import dev.umar.tilegame.Handler;
import dev.umar.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{
	
	public StaticEntity(Handler handler, float x, float y, int width , int height) {
		super(handler, x ,y, width, height);
	}

}
