package technology.sola.browser;

import technology.sola.engine.core.SolaPlatform;
import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSola;
import technology.sola.engine.platform.browser.BrowserSolaPlatform;
import technology.sola.engine.platform.browser.core.BrowserSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class BrowserMain {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new BrowserSolaLoggerFactory());
  }

  public static void main(String[] args) {
    SolaPlatform solaPlatform = new BrowserSolaPlatform();
    Sola sola = new GameSola();

    solaPlatform.play(sola);
  }
}
