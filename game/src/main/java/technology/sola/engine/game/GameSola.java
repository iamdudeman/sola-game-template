package technology.sola.engine.game;

import technology.sola.ecs.World;
import technology.sola.engine.assets.BulkAssetLoader;
import technology.sola.engine.assets.audio.AudioClip;
import technology.sola.engine.assets.graphics.SpriteSheet;
import technology.sola.engine.assets.graphics.font.Font;
import technology.sola.engine.assets.graphics.gui.GuiJsonDocument;
import technology.sola.engine.core.SolaConfiguration;
import technology.sola.engine.core.component.TransformComponent;
import technology.sola.engine.defaults.SolaWithDefaults;
import technology.sola.engine.game.components.PlayerComponent;
import technology.sola.engine.game.render.LoadingScreen;
import technology.sola.engine.game.systems.PlayerSystem;
import technology.sola.engine.graphics.Color;
import technology.sola.engine.graphics.components.LightComponent;
import technology.sola.engine.graphics.components.RectangleRendererComponent;
import technology.sola.engine.graphics.components.SpriteComponent;
import technology.sola.engine.graphics.gui.style.theme.GuiTheme;
import technology.sola.engine.graphics.renderer.Renderer;
import technology.sola.engine.graphics.screen.AspectMode;
import technology.sola.engine.physics.Material;
import technology.sola.engine.physics.component.ColliderComponent;
import technology.sola.engine.physics.component.DynamicBodyComponent;

public class GameSola extends SolaWithDefaults {
  private boolean isLoading = true;
  private LoadingScreen loadingScreen = new LoadingScreen();

  public GameSola() {
    super(SolaConfiguration.build("Game", 800, 600).withTargetUpdatesPerSecond(30));
  }

  @Override
  protected void onInit(DefaultsConfigurator defaultsConfigurator) {
    defaultsConfigurator.usePhysics().useGraphics().useLighting().useGui(GuiTheme.getDefaultLightTheme());

    platform.getViewport().setAspectMode(AspectMode.MAINTAIN);

    solaEcs.addSystems(new PlayerSystem(keyboardInput, solaPhysics));
    solaEcs.setWorld(buildWorld());
  }

  @Override
  protected void onAsyncInit(Runnable completeAsyncInit) {
    new BulkAssetLoader(assetLoaderProvider)
      .addAsset(SpriteSheet.class, AssetIds.Sprites.Duck.SHEET_ID, "assets/sprites/duck.sprites.json")
      .addAsset(Font.class, AssetIds.Font.MONO_10, "assets/font/monospaced_NORMAL_10.json")
      .addAsset(AudioClip.class, AssetIds.Audio.QUACK, "assets/audio/quack.wav")
      .addAsset(GuiJsonDocument.class, AssetIds.Gui.DUCK_TEXT, "assets/gui/duck_text.gui.json")
      .loadAll()
      .onComplete(assets -> {
        if (assets[2] instanceof AudioClip audioClip) {
          audioClip.addFinishListener(AudioClip::stop);
        }

        if (assets[3] instanceof GuiJsonDocument guiJsonDocument) {
          guiDocument.setRootElement(guiJsonDocument.rootElement());
        }

        // finish async load
        isLoading = false;
        loadingScreen = null;
        completeAsyncInit.run();
      });
  }

  @Override
  protected void onRender(Renderer renderer) {
    if (isLoading) {
      loadingScreen.drawLoading(renderer);
    } else {
      super.onRender(renderer);
    }
  }

  private World buildWorld() {
    World world = new World(100);

    world.createEntity()
      .addComponent(new PlayerComponent())
      .addComponent(new TransformComponent(350, 300, 32, 32))
      .addComponent(new RectangleRendererComponent(Color.BLUE, true))
      .addComponent(ColliderComponent.aabb())
      .addComponent(new DynamicBodyComponent(new Material(1, 0.1f, 50)))
      .setName("player");

    world.createEntity(
      new TransformComponent(150, 300),
      new SpriteComponent(AssetIds.Sprites.Duck.SHEET_ID, AssetIds.Sprites.Duck.DUCK),
      ColliderComponent.aabb(94, 116)
    );

    world.createEntity()
      .addComponent(new TransformComponent(150, 400, 400, 80f))
      .addComponent(new RectangleRendererComponent(Color.WHITE))
      .addComponent(new LightComponent(200, Color.WHITE).setOffset(200, -20))
      .addComponent(ColliderComponent.aabb());

    return world;
  }
}
