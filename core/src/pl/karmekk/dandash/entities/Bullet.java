package pl.karmekk.dandash.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * A bullet that the player is supposed to dodge.
 *
 * Note that you should remember about destroying the bullet with the dispose() method
 * when it is not used anymore!
 */
public class Bullet extends BaseEntity {
    private final Vector2 velocity;
    private Vector2 linearAcceleration;
    private final long initialTime;

    /**
     * Creates a bullet with no linear acceleration.
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     * @param velocity Initial velocity.
     */
    public Bullet(int x, int y, Vector2 velocity) {
        super(x, y);
        this.velocity = velocity;
        this.linearAcceleration = new Vector2();

        this.initialTime = TimeUtils.millis();
    }

    /**
     *
     * Creates a bullet with no linear acceleration.
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     * @param velocity Initial velocity.
     * @param linearAcceleration Linear acceleration as a vector.
     */
    public Bullet(int x, int y, Vector2 velocity, Vector2 linearAcceleration) {
        this(x, y, velocity);
        this.linearAcceleration = linearAcceleration;
    }

    @Override
    public void move() {
        this.rect.x += calculateSpeed(velocity.x, linearAcceleration.x) * dt();
        this.rect.y += calculateSpeed(velocity.y, linearAcceleration.y) * dt();
    }

    /**
     * Calculates the bullet speed as a function of elapsed time.
     * @param velocityVal Initial velocity value - v0
     * @param accelerationVal Acceleration value - a
     * @return Bullet speed relative to elapsed time - v
     */
    private float calculateSpeed(float velocityVal, float accelerationVal) {
        float timeSinceCreation = TimeUtils.timeSinceMillis(initialTime) / 1000f;

        return velocityVal + accelerationVal * timeSinceCreation;
    }
}
