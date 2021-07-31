package pl.karmekk.dandash.entities.projectiles;

import com.badlogic.gdx.utils.TimeUtils;
import pl.karmekk.dandash.entities.BaseEntity;

/**
 * An object that can shoot bullets.
 */
public abstract class BulletEmitter extends BaseEntity {
    protected long shootDelay;
    protected long lastShot;

    /**
     * Builds a new entity that has the given rectangle and a default texture.
     *
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     */
    public BulletEmitter(int x, int y, long shootDelay) {
        super(x, y);
        this.shootDelay = shootDelay;
        this.lastShot = TimeUtils.millis();
    }

    /**
     * @return True if the shooting event should be handled.
     */
    public abstract boolean isShooting();

    /**
     * Returns a bullet depending on the object
     * @return Bullet object
     */
    public abstract Bullet buildProjectile();

    void setShootDelay(long shootDelay) {
        this.shootDelay = shootDelay;
    }
}
