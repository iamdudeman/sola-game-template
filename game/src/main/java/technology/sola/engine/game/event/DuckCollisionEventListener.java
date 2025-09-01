package technology.sola.engine.game.event;

import org.jspecify.annotations.NullMarked;
import technology.sola.engine.assets.AssetLoader;
import technology.sola.engine.assets.audio.AudioClip;
import technology.sola.engine.event.EventListener;
import technology.sola.engine.game.AssetIds;
import technology.sola.engine.game.EntityNames;
import technology.sola.engine.graphics.gui.GuiDocument;
import technology.sola.engine.graphics.gui.elements.TextGuiElement;
import technology.sola.engine.physics.event.CollisionEvent;

@NullMarked
public class DuckCollisionEventListener implements EventListener<CollisionEvent> {
  private final GuiDocument guiDocument;
  private final AssetLoader<AudioClip> audioClipAssetLoader;

  public DuckCollisionEventListener(GuiDocument guiDocument, AssetLoader<AudioClip> audioClipAssetLoader) {
    this.guiDocument = guiDocument;
    this.audioClipAssetLoader = audioClipAssetLoader;
  }

  @Override
  public void onEvent(CollisionEvent collisionEvent) {
    collisionEvent.collisionManifold()
      .conditionallyResolveCollision(
        entity -> EntityNames.PLAYER.equals(entity.getName()),
        entity -> EntityNames.DUCK.equals(entity.getName()),
        (player, duck) -> {
          audioClipAssetLoader.get(AssetIds.Audio.QUACK).executeIfLoaded(AudioClip::play);
          guiDocument.findElementById("duck_text", TextGuiElement.class).setText("Quack!");
        }
      );
  }
}
