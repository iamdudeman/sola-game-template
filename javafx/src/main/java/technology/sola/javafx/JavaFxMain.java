package technology.sola.javafx;

import technology.sola.engine.game.GameSola;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.platform.javafx.JavaFxSolaPlatform;
import technology.sola.engine.platform.javafx.JavaFxSolaPlatformConfig;
import technology.sola.logging.JavaSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class JavaFxMain {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new JavaSolaLoggerFactory());
  }

  public static void main(String[] args) {
    var solaPlatform = new JavaFxSolaPlatform(
      new JavaFxSolaPlatformConfig(true, Color.BLACK, true, null, null)
    );
    var sola = new GameSola();

    solaPlatform.play(sola);
  }
}
