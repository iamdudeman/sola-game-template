package technology.sola.swing;

import technology.sola.engine.core.SolaPlatform;
import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSola;
import technology.sola.engine.platform.swing.SwingSolaPlatform;

public class SwingMain {
  public static void main(String[] args) {
    SolaPlatform solaPlatform = new SwingSolaPlatform();
    Sola sola = new GameSola();

    solaPlatform.play(sola);
  }
}
