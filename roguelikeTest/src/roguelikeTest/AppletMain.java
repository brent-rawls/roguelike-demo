package roguelikeTest;

import java.applet.Applet;
import javax.swing.JFrame;
import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

public class AppletMain extends Applet {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;

    public AppletMain(){
        super();
        terminal = new AsciiPanel(80, 24, AsciiFont.CP437_16x16);
        terminal.write("yo it works", 1, 1);
        add(terminal);
    }

    public void init(){
        super.init();
        this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
    }

    public void repaint(){
        super.repaint();
        terminal.repaint();
    }
}
