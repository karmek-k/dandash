package pl.karmekk.dandash.entities.projectiles;

import pl.karmekk.dandash.entities.BaseEntity;

/**
 * An object that can shoot bullets.
 */
public abstract class BulletEmitter extends BaseEntity {
    private long shootDelay;

    /**
     * Builds a new entity that has the given rectangle and a default texture.
     *
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     */
    public BulletEmitter(int x, int y, long shootDelay) {
        super(x, y);
        this.shootDelay = shootDelay;
    }

    public abstract boolean isShooting();

    void setShootDelay(long shootDelay) {
        this.shootDelay = shootDelay;
    }
}
