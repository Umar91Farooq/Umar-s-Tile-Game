package dev.umar.tilegame.states;

import java.awt.Graphics;

import dev.umar.tilegame.Game;
import dev.umar.tilegame.Handler;
import dev.umar.tilegame.entities.creatures.Player;
import dev.umar.tilegame.entities.statics.Tree;
import dev.umar.tilegame.gfx.Assets;
import dev.umar.tilegame.tiles.Tile;
import dev.umar.tilegame.worlds.World;

public class GameState extends State{

	
	private World world;
	
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler,"res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	public void tick() {
		world.tick();	
	}

	public void render(Graphics g) {
		world.render(g);
	}

}
