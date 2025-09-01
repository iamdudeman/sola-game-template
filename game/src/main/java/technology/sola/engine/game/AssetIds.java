package technology.sola.engine.game;

import org.jspecify.annotations.NullMarked;

@NullMarked
public final class AssetIds {
  public static final class Audio {
    public static final String QUACK = "quack";

    private Audio() {
    }
  }

  public static final class Controls {
    public static final String PLAYER = "player";

    private Controls() {
    }
  }

  public static final class Font {
    public static final String MONO_10 = "mono-10";

    private Font() {
    }
  }

  public static final class Gui {
    public static final String DUCK_TEXT = "duck_text";

    private Gui() {
    }
  }

  public static final class Sprites {
    public static final class Duck {
      public static final String SHEET_ID = "duck";
      public static final String DUCK = "duck";

      private Duck() {
      }
    }

    private Sprites() {
    }
  }

  private AssetIds() {
  }
}
