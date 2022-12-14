package technology.sola.browser;

import technology.sola.engine.core.SolaPlatform;
import technology.sola.engine.core.Sola;
import technology.sola.engine.game.GameSola;
import technology.sola.engine.platform.browser.BrowserSolaPlatform;

public class BrowserMain {
  public static void main(String[] args) {
    SolaPlatform solaPlatform = new BrowserSolaPlatform();
    Sola sola = new GameSola();

    solaPlatform.play(sola);
  }
}
