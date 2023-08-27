package technology.sola.javafx;

import technology.sola.engine.core.SolaPlatform;
import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSolaWithDefaults;
import technology.sola.engine.platform.javafx.JavaFxSolaPlatform;

public class JavaFxMain {
  public static void main(String[] args) {
    SolaPlatform solaPlatform = new JavaFxSolaPlatform();
    Sola sola = new GameSolaWithDefaults();

    solaPlatform.play(sola);
  }
}
