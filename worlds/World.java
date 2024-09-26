package dev.umar.tilegame.worlds;

import java.awt.Graphics;

import dev.umar.tilegame.Game;
import dev.umar.tilegame.Handler;
import dev.umar.tilegame.entities.EntityManager;
import dev.umar.tilegame.entities.creatures.Player;
import dev.umar.tilegame.entities.statics.Emerald;
import dev.umar.tilegame.entities.statics.Gem;
import dev.umar.tilegame.entities.statics.Ruby;
import dev.umar.tilegame.entities.statics.Sapphire;
import dev.umar.tilegame.entities.statics.Tree;
import dev.umar.tilegame.items.ItemManager;
import dev.umar.tilegame.tiles.Tile;
import dev.umar.tilegame.utils.Utils;

public class World {
	private Handler handler;
	private int width , height, spawnX , spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	//Item
	private ItemManager itemManager;
	
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		
		entityManager.addEntity(new Tree(handler , 200, 350));
		entityManager.addEntity(new Gem(handler , 400, 400));
		entityManager.addEntity(new Tree(handler , 500, 900));
		entityManager.addEntity(new Gem(handler , 400, 850));
		entityManager.addEntity(new Ruby(handler , 500, 1000));
		entityManager.addEntity(new Sapphire(handler , 600, 1000));
		entityManager.addEntity(new Emerald(handler , 700, 1000));
		
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH );
		int xEnd = (int) Math.min(width, ( handler.getGameCamera().getxOffset() +handler.getWidth()) / Tile.TILE_WIDTH +1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT );
		int yEnd = (int) Math.min(height, ( handler.getGameCamera().getyOffset() +handler.getHeight()) / Tile.TILE_HEIGHT +1);
		
		
		for(int y =yStart; y< yEnd; y++) {
			for (int x= xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) ( y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//items
		itemManager.render(g);
		//Entities 
		entityManager.render(g);
		
	}
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int [width][height];
		for(int y =0;y < height; y++) {
			for(int x =0 ;x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	
}
