package technology.sola.javafx;

import technology.sola.engine.game.GameSola;
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
    var platformConfig = new JavaFxSolaPlatformConfig();
    var solaPlatform = new JavaFxSolaPlatform(platformConfig);
    var sola = new GameSola();

    solaPlatform.play(sola);
  }
}
