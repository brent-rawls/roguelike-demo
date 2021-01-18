package roguelikeTest.screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("this is the start screen", 10, 1);
		terminal.writeCenter("--press Enter to start--", 22);
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
