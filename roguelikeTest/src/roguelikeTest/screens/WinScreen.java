package roguelikeTest.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("you win!!!!", 20, 1);
		terminal.writeCenter("--press Enter to play again--", 22);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_ENTER) {
			return new PlayScreen();
		}
		else {
			return this;
		}
	}

}
