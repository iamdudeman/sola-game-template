package technology.sola.android;

import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSola;
import technology.sola.engine.platform.android.AndroidSolaPlatformConfig;
import technology.sola.engine.platform.android.SolaAndroidActivity;
import technology.sola.engine.platform.android.core.AndroidSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class MainActivity extends SolaAndroidActivity {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new AndroidSolaLoggerFactory());
  }

  public MainActivity() {
    super(new AndroidSolaPlatformConfig());
  }

  @Override
  public Sola getInitialSola() {
    return new GameSola();
  }
}
