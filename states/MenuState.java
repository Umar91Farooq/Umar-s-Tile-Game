package dev.umar.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.umar.tilegame.Game;
import dev.umar.tilegame.Handler;
import dev.umar.tilegame.gfx.Assets;
import dev.umar.tilegame.gfx.Text;
import dev.umar.tilegame.ui.ClickListener;
import dev.umar.tilegame.ui.UIImageButton;
import dev.umar.tilegame.ui.UIManager;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(250, 200, 128, 64, Assets.btn_start, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}
			} ));
			
		
	}
	
	public void tick() {
		uiManager.tick();
		
		//temp to skip menu state
//		handler.getMouseManager().setUIManager(null);
//		State.setState(handler.getGame().gameState);
		
	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		Text.drawString(g, "UMAR'S TILE GAME", 64, 64, false, Color.CYAN, Assets.font48);
		uiManager.render(g);
	}

}
