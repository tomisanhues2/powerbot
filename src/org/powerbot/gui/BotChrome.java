package org.powerbot.gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.powerbot.game.bot.Bot;
import org.powerbot.gui.component.BotPanel;
import org.powerbot.gui.component.BotToolBar;
import org.powerbot.util.Configuration;
import org.powerbot.util.io.Resources;

public class BotChrome extends JFrame implements WindowListener {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(BotChrome.class.getName());
	public static final int PANEL_WIDTH = 784, PANEL_HEIGHT = 562, MAX_BOTS = 3;
	public static BotPanel panel;

	public BotChrome() {
		setTitle(Configuration.NAME);
		setIconImage(Resources.getImage(Resources.Paths.ICON));
		addWindowListener(this);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		add(new BotToolBar(this), BorderLayout.NORTH);

		panel = new BotPanel();
		add(panel);

		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(getParent());
		setVisible(true);
	}

	@Override
	public void windowActivated(final WindowEvent arg0) {
	}

	@Override
	public void windowClosed(final WindowEvent arg0) {
	}

	@Override
	public void windowClosing(final WindowEvent arg0) {
		log.info("Shutting down");
		setVisible(false);
		int bots = Bot.bots.size();
		while (bots-- > 0) {
			Bot.bots.peekLast().killEnvironment();
		}
		dispose();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(final WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(final WindowEvent arg0) {
	}

	@Override
	public void windowIconified(final WindowEvent arg0) {
	}

	@Override
	public void windowOpened(final WindowEvent arg0) {
	}
}
