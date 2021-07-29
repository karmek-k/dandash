package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import pl.karmekk.dandash.entities.projectiles.BulletEmitter;
import pl.karmekk.dandash.entities.projectiles.PlayerBulletEmitter;

/**
 * An entity representing the player.
 */
public class Player extends BaseEntity {
    private final float speed;
    private final float slowMultiplier;
    private final Vector2 movement;
    private BulletEmitter emitter;

    /**
     * Builds a new player that has the given speed and slow multiplier.
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     * @param speed How fast the player moves.
     * @param slowMultiplier The number speed is multiplied by when in slow mode.
     */
    public Player(int x, int y, float speed, float slowMultiplier, long shootDelay) {
        super(x, y);
        this.speed = speed;
        this.slowMultiplier = slowMultiplier;
        this.emitter = new PlayerBulletEmitter(x, y + 10, shootDelay);

        // only one Vector2D instance for performance
        this.movement = new Vector2();
    }

    public BulletEmitter getBulletEmitter() {
        return this.emitter;
    }

    @Override
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

        movement.nor();
        movement.x *= dt() * speed;
        movement.y *= dt() * speed;

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
