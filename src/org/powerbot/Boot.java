package org.powerbot;

import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.swing.UIManager;

import org.powerbot.gui.BotChrome;
import org.powerbot.log.SystemConsoleHandler;

public class Boot implements Runnable {
	public static void main(final String[] params) {
		final Logger logger = Logger.getLogger("");
		for (final Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
		}
		logger.addHandler(new SystemConsoleHandler());

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception ignored) {
		}

		new BotChrome();
	}

	@Override
	public void run() {
		main(new String[]{});
	}
}
