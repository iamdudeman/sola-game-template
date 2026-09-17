package technology.sola.browser;

import technology.sola.engine.game.GameSola;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.platform.browser.BrowserSolaPlatform;
import technology.sola.engine.platform.browser.BrowserSolaPlatformConfig;
import technology.sola.engine.platform.browser.core.BrowserSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class BrowserMain {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new BrowserSolaLoggerFactory());
  }

  public static void main(String[] args) {
    var solaPlatform = new BrowserSolaPlatform(
      new BrowserSolaPlatformConfig(true, Color.BLACK, true)
    );
    var sola = new GameSola();

    solaPlatform.play(sola);
  }
}
