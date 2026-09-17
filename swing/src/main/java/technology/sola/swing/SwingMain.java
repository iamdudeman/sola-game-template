package technology.sola.swing;

import technology.sola.engine.game.GameSola;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.platform.swing.SwingSolaPlatform;
import technology.sola.engine.platform.swing.SwingSolaPlatformConfig;
import technology.sola.logging.JavaSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class SwingMain {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new JavaSolaLoggerFactory());
  }

  public static void main(String[] args) {
    var solaPlatform = new SwingSolaPlatform(
      new SwingSolaPlatformConfig(true, Color.BLACK, null)
    );
    var sola = new GameSola();

    solaPlatform.play(sola);
  }
}
