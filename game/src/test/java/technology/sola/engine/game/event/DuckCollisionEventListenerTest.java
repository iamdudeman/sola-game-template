package technology.sola.engine.game.event;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import technology.sola.ecs.Entity;
import technology.sola.engine.assets.AssetHandle;
import technology.sola.engine.assets.AssetLoader;
import technology.sola.engine.assets.audio.AudioClip;
import technology.sola.engine.game.AssetIds;
import technology.sola.engine.game.EntityNames;
import technology.sola.engine.graphics.gui.GuiDocument;
import technology.sola.engine.graphics.gui.elements.TextGuiElement;
import technology.sola.engine.physics.CollisionManifold;
import technology.sola.engine.physics.event.CollisionEvent;
import technology.sola.math.linear.Vector2D;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DuckCollisionEventListenerTest {
  @Mock
  private GuiDocument mockGuiDocument;
  @Mock
  private AssetLoader<AudioClip> mockAudioClipAssetLoader;
  @Mock
  private Entity mockEntity;
  @Mock
  private Entity mockEntity2;

  @Test
  void shouldTriggerAudioOnCollisionOfDuckAndPlayer() {
    AudioClip mockAudioClip = Mockito.mock(AudioClip.class);
    TextGuiElement textGuiElement = new TextGuiElement();

    Mockito.when(mockAudioClipAssetLoader.get(AssetIds.Audio.QUACK))
      .thenReturn(new AssetHandle<>(mockAudioClip));

    Mockito.when(mockEntity.getName()).thenReturn(EntityNames.PLAYER);
    Mockito.when(mockEntity2.getName()).thenReturn(EntityNames.DUCK);
    Mockito.when(mockGuiDocument.findElementById("duck_text", TextGuiElement.class)).thenReturn(textGuiElement);

    new DuckCollisionEventListener(mockGuiDocument, mockAudioClipAssetLoader)
      .onEvent(new CollisionEvent(new CollisionManifold(
        mockEntity,
        mockEntity2,
        Vector2D.ZERO_VECTOR,
        1
      )));

    assertEquals("Quack!", textGuiElement.getText());
    Mockito.verify(mockAudioClip, Mockito.times(1)).play();
  }

  @Test
  void shouldNotTriggerAudioOnCollisionOfDuckAndSomethingElse() {
    Mockito.when(mockEntity.getName()).thenReturn("other");
    Mockito.when(mockEntity2.getName()).thenReturn(EntityNames.DUCK);

    new DuckCollisionEventListener(mockGuiDocument, mockAudioClipAssetLoader)
      .onEvent(new CollisionEvent(new CollisionManifold(
        mockEntity,
        mockEntity2,
        Vector2D.ZERO_VECTOR,
        1
      )));

    Mockito.verify(mockAudioClipAssetLoader, Mockito.times(0)).get(Mockito.any());
  }
}
