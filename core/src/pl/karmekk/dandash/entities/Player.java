package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * An entity representing the player.
 */
public class Player extends BaseEntity {
    private final float speed;
    private final Vector2 movement;

    public Player(float speed) {
        this.speed = speed;
        this.movement = new Vector2();
    }

    public void handleMovement() {
        movement.x = 0;
        movement.y = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            movement.x += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            movement.x -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            movement.y += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            movement.y -= 1;
        }

        float dt = Gdx.graphics.getDeltaTime();
        movement.nor();
        movement.x *= dt * speed;
        movement.y *= dt * speed;

        rect.x += movement.x;
        rect.y += movement.y;
    }
}
