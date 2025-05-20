package technology.sola.engine.game.systems;

import org.jspecify.annotations.NullMarked;
import technology.sola.ecs.EcsSystem;
import technology.sola.ecs.World;
import technology.sola.engine.defaults.SolaControls;
import technology.sola.engine.defaults.SolaPhysics;
import technology.sola.engine.game.PlayerControls;
import technology.sola.engine.game.components.PlayerComponent;
import technology.sola.engine.physics.component.DynamicBodyComponent;

@NullMarked
public class PlayerSystem extends EcsSystem {
  private final SolaControls solaControls;
  private final SolaPhysics solaPhysics;

  public PlayerSystem(SolaControls solaControls, SolaPhysics solaPhysics) {
    this.solaControls = solaControls;
    this.solaPhysics = solaPhysics;
  }

  @Override
  public void update(World world, float deltaTime) {
    for (var entry : world.createView().of(PlayerComponent.class, DynamicBodyComponent.class).getEntries()) {
      DynamicBodyComponent dynamicBodyComponent = entry.c2();

      if (dynamicBodyComponent.isGrounded()) {
        if (solaControls.isActive(PlayerControls.RIGHT) && dynamicBodyComponent.getVelocity().x() < 100) {
          dynamicBodyComponent.applyForce(300, 0);
        }
        if (solaControls.isActive(PlayerControls.LEFT) && dynamicBodyComponent.getVelocity().x() > -100) {
          dynamicBodyComponent.applyForce(-300, 0);
        }
      }

      if (dynamicBodyComponent.isGrounded() && solaControls.isActive(PlayerControls.JUMP)) {
        dynamicBodyComponent.applyForce(0, -2500);
      } else if (dynamicBodyComponent.getVelocity().y() > 0) {
        dynamicBodyComponent.applyForce(0, 2f * solaPhysics.getGravitySystem().getGravityConstant() * dynamicBodyComponent.getMaterial().getMass());
      }
    }
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
