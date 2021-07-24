package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * An entity representing the player.
 */
public class Player extends BaseEntity {
    private final float speed;
    private final float slowMultiplier;
    private final Vector2 movement;

    public Player(int x, int y, float speed, float slowMultiplier) {
        super(x, y);
        this.speed = speed;
        this.slowMultiplier = slowMultiplier;

        // only one Vector2D instance for performance
        this.movement = new Vector2();
    }

    public void move() {
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

        // slow movement
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            movement.x *= slowMultiplier;
            movement.y *= slowMultiplier;
        }

        int maxX = Gdx.graphics.getWidth() - this.texture.getWidth();
        int maxY = Gdx.graphics.getHeight() - this.texture.getHeight();

        rect.x = MathUtils.clamp(rect.x + movement.x, 0, maxX);
        rect.y = MathUtils.clamp(rect.y + movement.y, 0, maxY);
    }
}
