package pl.karmekk.dandash.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Bullet extends BaseEntity {
    private final Vector2 velocity;
    private Vector2 linearAcceleration;
    private final long initialTime;

    public Bullet(int x, int y, Vector2 velocity) {
        super(x, y);
        this.velocity = velocity;
        this.linearAcceleration = new Vector2();

        this.initialTime = TimeUtils.millis();
    }

    public Bullet(int x, int y, Vector2 velocity, Vector2 linearAcceleration) {
        this(x, y, velocity);
        this.linearAcceleration = linearAcceleration;
    }

    @Override
    public void move() {
        this.rect.x += calculateSpeed(velocity.x, linearAcceleration.x) * dt();
        this.rect.y += calculateSpeed(velocity.y, linearAcceleration.y) * dt();
    }

    private float calculateSpeed(float velocityVal, float accelerationVal) {
        float timeSinceCreation = TimeUtils.timeSinceMillis(initialTime) / 1000f;

        return velocityVal + accelerationVal * timeSinceCreation;
    }
}
