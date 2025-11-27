package technology.sola.engine.game.systems;

import org.jspecify.annotations.NullMarked;
import technology.sola.ecs.EcsSystem;
import technology.sola.ecs.World;
import technology.sola.engine.game.components.PlayerComponent;
import technology.sola.engine.input.Key;
import technology.sola.engine.input.KeyboardInput;
import technology.sola.engine.physics.SolaPhysics;
import technology.sola.engine.physics.component.DynamicBodyComponent;

@NullMarked
public class PlayerSystem extends EcsSystem {
  private final KeyboardInput keyboardInput;
  private final SolaPhysics solaPhysics;

  public PlayerSystem(KeyboardInput keyboardInput, SolaPhysics solaPhysics) {
    this.keyboardInput = keyboardInput;
    this.solaPhysics = solaPhysics;
  }

  @Override
  public void update(World world, float deltaTime) {
    for (var entry : world.createView().of(PlayerComponent.class, DynamicBodyComponent.class).getEntries()) {
      DynamicBodyComponent dynamicBodyComponent = entry.c2();

      if (dynamicBodyComponent.isGrounded()) {
        if ((keyboardInput.isKeyHeld(Key.D) || keyboardInput.isKeyHeld(Key.RIGHT)) && dynamicBodyComponent.getVelocity().x() < 100) {
          dynamicBodyComponent.applyForce(300, 0);
        }
        if ((keyboardInput.isKeyHeld(Key.A) || keyboardInput.isKeyHeld(Key.LEFT)) && dynamicBodyComponent.getVelocity().x() > -100) {
          dynamicBodyComponent.applyForce(-300, 0);
        }
      }

      if (dynamicBodyComponent.isGrounded() && keyboardInput.isKeyHeld(Key.SPACE)) {
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
