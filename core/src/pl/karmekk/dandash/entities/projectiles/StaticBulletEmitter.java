package pl.karmekk.dandash.entities.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import pl.karmekk.dandash.entities.Player;

public class StaticBulletEmitter extends BulletEmitter {
    /**
     * Builds a new entity that has the given rectangle and a default texture.
     *
     * @param x X coordinate of the bottom left vertex.
     * @param y Y coordinate of the bottom left vertex.
     */
    public StaticBulletEmitter(int x, int y, long shootDelay) {
        super(x, y, shootDelay);
    }

    @Override
    public boolean isShooting() {
        long timeSinceLastShot = TimeUtils.timeSinceMillis(this.lastShot);

        if (timeSinceLastShot >= this.shootDelay) {
            this.lastShot = TimeUtils.millis();

            return true;
        }

        return false;
    }

    @Override
    public Bullet buildProjectile(Player player) {
        int x = player.getX() - this.getX();
        int y = player.getY() - this.getY();

        return new Bullet(this.getX(), this.getY(), new Vector2(x, y));
    }

    @Override
    public void setShootDelay(long shootDelay) {
        this.shootDelay = shootDelay;
    }

    @Override
    public void move() {
        // static emitters don't move
    }
}
