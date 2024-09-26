package dev.umar.tilegame;

import dev.umar.tilegame.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("\t\tUMAR'S TILE GAME", 640, 480);
		game.start();
	}

}
