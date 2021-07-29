package pl.karmekk.dandash.entities.projectiles;

/**
 * An object that can shoot bullets.
 */
public interface BulletEmitter {
    boolean isShooting();

    void setShootDelay(long shootDelay);
}
