package roguelikeTest.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import roguelikeTest.World;
import roguelikeTest.WorldBuilder;

public class PlayScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
		int top = getScrollY();
		displayTiles(terminal, left, top);
		terminal.write('@', centerX - left, centerY - top);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			scrollBy(-1, 0);
			break;
		case KeyEvent.VK_RIGHT:
			scrollBy(1, 0);
			break;
		case KeyEvent.VK_UP:
			scrollBy(0, -1);
			break;
		case KeyEvent.VK_DOWN: 
			scrollBy(0, 1);
			break;
		case KeyEvent.VK_ENTER:
			return new PlayScreen();
		default: break;
		}
		return this;
	}
	
	private World world;
		private int centerX;
		private int centerY;
		private int screenWidth;
		private int screenHeight;
	
	
	public PlayScreen() {
		screenWidth = 80;
		screenHeight = 40;
		createWorld();
	}

	public void createWorld() {
		world = new WorldBuilder(90, 90)
				.makeCaves()
				.build();
	}
	
	public int getScrollX() {
		return Math.max(0, Math.min(centerX - screenWidth / 2, world.width() - screenWidth));
	}
	public int getScrollY() {
		return Math.max(0, Math.min(centerY - screenHeight / 2, world.height() - screenHeight));
	}
	private void displayTiles(AsciiPanel terminal, int left, int top) {
		int wy, wx;
		for (int x = 0; x < screenWidth; x++) {
			for (int y = 0; y < screenHeight; y++) {
				wx = x + left;
				wy = y + top;
				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
			}
		}
	}
	private void scrollBy(int mx, int my) {
		centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
		centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
	}
		
}
