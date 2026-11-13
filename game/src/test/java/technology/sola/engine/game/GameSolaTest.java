package technology.sola.engine.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import technology.sola.engine.platform.automation.AutomationTestingSolaPlatform;
import technology.sola.engine.platform.automation.AutomationTestingSolaPlatformConfig;
import technology.sola.engine.platform.automation.AutomationTestingSolaPlatformDriver;
import technology.sola.logging.JavaSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

class GameSolaTest {
  static {
    SolaLogger.configure(SolaLogLevel.WARNING, new JavaSolaLoggerFactory());
  }

  private GameSola gameSola;
  private AutomationTestingSolaPlatformDriver driver;

  @BeforeEach
  void setup() {
    AutomationTestingSolaPlatform platform = new AutomationTestingSolaPlatform(
      new AutomationTestingSolaPlatformConfig()
    );

    gameSola = new GameSola();
    platform.play(gameSola);
    driver = platform.getDriver();
  }

  @Test
  void test() {
    driver.advanceTime(1);

    driver.snapshot("test");
  }
}
