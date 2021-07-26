package pl.karmekk.dandash.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Bullet extends BaseEntity {
    private final Vector2 velocity;
    private final Vector2 linearAcceleration;
    private long initialTime;

    public Bullet(int x, int y, Vector2 velocity, Vector2 linearAcceleration) {
        super(x, y);
        this.velocity = velocity;
        this.linearAcceleration = linearAcceleration;

        this.initialTime = TimeUtils.millis();
    }

    @Override
    public void move() {
        this.rect.x += calculateSpeed(velocity.x, linearAcceleration.x) * dt();
        this.rect.y += calculateSpeed(velocity.y, linearAcceleration.y) * dt();
    }

    private float calculateSpeed(float velocityVal, float accelerationVal) {
        return velocityVal + accelerationVal * TimeUtils.timeSinceMillis(initialTime);
    }
}
