package technology.sola.android;

import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSola;
import technology.sola.engine.platform.android.SolaAndroidActivity;
import technology.sola.logging.JavaSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class MainActivity extends SolaAndroidActivity {
  static {
    // todo might need AndroidSolaLoggerFactory
    SolaLogger.configure(SolaLogLevel.WARNING, new JavaSolaLoggerFactory());
  }

  @Override
  public Sola getInitialSola() {
    return new GameSola();
  }
}
