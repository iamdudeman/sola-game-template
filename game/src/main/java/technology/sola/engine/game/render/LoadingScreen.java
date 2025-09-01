package technology.sola.engine.game.render;

import org.jspecify.annotations.NullMarked;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.graphics.renderer.Renderer;

import java.util.Arrays;

@NullMarked
public class LoadingScreen {
  private final int maxDots;
  private int loadingDotCount = 0;
  private long lastUpdate = System.currentTimeMillis();

  public LoadingScreen() {
    this(6);
  }

  public LoadingScreen(int maxDots) {
    this.maxDots = maxDots;
  }

  public void drawLoading(Renderer renderer) {
    long delay = loadingDotCount + 1 < maxDots ? 300 : 1300;

    if (System.currentTimeMillis() - lastUpdate > delay) {
      loadingDotCount = (loadingDotCount + 1) % maxDots;
      lastUpdate = System.currentTimeMillis();
    }

    String[] dotArray = new String[loadingDotCount];
    Arrays.fill(dotArray, ".");

    renderer.clear();
    renderer.drawString("Loading" + String.join("", dotArray), 20, renderer.getHeight() - 50, Color.WHITE);
  }
}
