package dev.umar.tilegame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.umar.tilegame.Handler;
import dev.umar.tilegame.gfx.Assets;
import dev.umar.tilegame.gfx.Text;
import dev.umar.tilegame.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;

	private int invX = 64, invY = 48,
			invWidth =512, invHeight =384,
			invListCenterX = invX +260,
			invListCenterY = invY + invHeight / 2 + 45,
			invListSpacing = 95;
	
	private int invImageX =45*3 , invImageY = 82*3 + 20,
			invImageWidth = 42, invImageHeight= 42;
	
	private int invCountX =484, invCountY =82*3 +40;
	
	private int selectedItem = 0;
	
	public Inventory(Handler handler){
	this.handler = handler;
	inventoryItems = new ArrayList<Item>();
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active )
			return;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem =  0;
		
	}
	
	public void render(Graphics g) {
		
		if(!active )
			return;
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		for(int i = -2; i< 2; i++) {
			if (selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0) {
				Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " < ", invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.RED, Assets.font28);
			}else {
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.BLACK, Assets.font28);
			}
			
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight ,null);
		Text.drawString(g, "x "+Integer.toString(item.getCount()), invCountX, invCountY, true, Color.BLUE, Assets.font28);
		
	}
	//Inventory methods
	
	public void addItem(Item item) {
		for (Item i : inventoryItems){
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//getters and setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
