package technology.sola.engine.game;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import technology.sola.ecs.World;
import technology.sola.engine.assets.BulkAssetLoader;
import technology.sola.engine.assets.audio.AudioClip;
import technology.sola.engine.assets.graphics.font.Font;
import technology.sola.engine.assets.graphics.gui.GuiJsonDocument;
import technology.sola.engine.assets.graphics.spritesheet.SpriteSheet;
import technology.sola.engine.core.Sola;
import technology.sola.engine.core.SolaConfiguration;
import technology.sola.engine.core.component.TransformComponent;
import technology.sola.engine.game.components.PlayerComponent;
import technology.sola.engine.game.event.DuckCollisionEventListener;
import technology.sola.engine.game.render.LoadingScreen;
import technology.sola.engine.game.systems.PlayerSystem;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.graphics.SolaGraphics;
import technology.sola.engine.graphics.components.LightComponent;
import technology.sola.engine.graphics.components.RectangleRendererComponent;
import technology.sola.engine.graphics.components.SpriteComponent;
import technology.sola.engine.graphics.gui.style.theme.DefaultThemeBuilder;
import technology.sola.engine.graphics.renderer.Renderer;
import technology.sola.engine.graphics.screen.AspectMode;
import technology.sola.engine.physics.Material;
import technology.sola.engine.physics.SolaPhysics;
import technology.sola.engine.physics.component.ColliderComponent;
import technology.sola.engine.physics.component.DynamicBodyComponent;
import technology.sola.engine.physics.component.collider.ColliderShapeAABB;
import technology.sola.engine.physics.event.CollisionEvent;
import technology.sola.engine.physics.utils.ColliderUtils;

@NullMarked
public class GameSola extends Sola {
  @Nullable
  private LoadingScreen loadingScreen = new LoadingScreen();
  private SolaPhysics solaPhysics;
  private SolaGraphics solaGraphics;

  public GameSola() {
    super(new SolaConfiguration("Game", 800, 600, 30));
  }

  @Override
  protected void onInit() {
    solaPhysics = new SolaPhysics.Builder(solaEcs)
      .buildAndInitialize(eventHub);

    solaGraphics = new SolaGraphics.Builder(platform(), solaEcs)
      .withGui(mouseInput, DefaultThemeBuilder.buildLightTheme())
      .withLighting()
      .buildAndInitialize(assetLoaderProvider);

    platform().getViewport().setAspectMode(AspectMode.MAINTAIN);

    eventHub.add(CollisionEvent.class, new DuckCollisionEventListener(solaGraphics.guiDocument(), assetLoaderProvider.get(AudioClip.class)));

    solaEcs.addSystems(new PlayerSystem(keyboardInput, solaPhysics));

    new BulkAssetLoader(assetLoaderProvider)
      .addAsset(SpriteSheet.class, AssetIds.Sprites.Duck.SHEET_ID, "assets/sprites/duck.sprites.json")
      .addAsset(Font.class, AssetIds.Font.MONO_10, "assets/font/monospaced_NORMAL_10.font.json")
      .addAsset(AudioClip.class, AssetIds.Audio.QUACK, "assets/audio/quack.wav")
      .addAsset(GuiJsonDocument.class, AssetIds.Gui.DUCK_TEXT, "assets/gui/duck_text.gui.json")
      .loadAll()
      .onComplete(assets -> {
        if (assets[2] instanceof AudioClip audioClip) {
          audioClip.addFinishListener(AudioClip::stop);
        }

        if (assets[3] instanceof GuiJsonDocument guiJsonDocument) {
          solaGraphics.guiDocument().setRootElement(guiJsonDocument.rootElement());
        }

        // finish async load
        solaEcs.setWorld(buildWorld());
        loadingScreen = null;

        if (assets[0] instanceof SpriteSheet spriteSheet) {
          ColliderUtils.autoSizeColliderToSprite(
            solaEcs.getWorld().findEntityByName(EntityNames.DUCK),
            spriteSheet
          );
        }
      });
  }

  @Override
  protected void onRender(Renderer renderer) {
    if (loadingScreen != null) {
      loadingScreen.drawLoading(renderer);
    } else {
      solaGraphics.render(renderer);
    }
  }

  private World buildWorld() {
    World world = new World(100);

    world.createEntity()
      .addComponent(new PlayerComponent())
      .addComponent(new TransformComponent(350, 300, 32, 32))
      .addComponent(new RectangleRendererComponent(Color.BLUE, true))
      .addComponent(new ColliderComponent(new ColliderShapeAABB()))
      .addComponent(new DynamicBodyComponent(new Material(1, 0.1f, 50)))
      .setName(EntityNames.PLAYER);

    world.createEntity(
      new TransformComponent(150, 300),
      new SpriteComponent(AssetIds.Sprites.Duck.SHEET_ID, AssetIds.Sprites.Duck.DUCK),
      new ColliderComponent(new ColliderShapeAABB())
    ).setName(EntityNames.DUCK);

    world.createEntity()
      .addComponent(new TransformComponent(150, 400, 400, 80f))
      .addComponent(new RectangleRendererComponent(Color.WHITE))
      .addComponent(new LightComponent(200, Color.WHITE).setOffset(200, -20))
      .addComponent(new ColliderComponent(new ColliderShapeAABB()));

    return world;
  }
}
