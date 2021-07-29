package pl.karmekk.dandash.entities.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import pl.karmekk.dandash.entities.Player;

public class PlayerBulletEmitter extends BulletEmitter {
    private Player player;

    /**
     * Builds a new entity that has the given rectangle and a default texture.
     *
     * @param x          X coordinate of the bottom left vertex.
     * @param y          Y coordinate of the bottom left vertex.
     * @param shootDelay Delay between each bullet [ms].
     */
    public PlayerBulletEmitter(int x, int y, long shootDelay, Player player) {
        super(x, y, shootDelay);
        this.player = player;
    }

    /**
     * Returns whether the delay since the last shoot has been satisfied.
     * @return True if the bullet should be emitted, false otherwise
     */
    public boolean isShooting() {
        long timeSinceLastShot = TimeUtils.timeSinceMillis(this.lastShot);

        if (Gdx.input.isKeyPressed(Input.Keys.Z) && timeSinceLastShot >= this.shootDelay) {
            this.lastShot = TimeUtils.millis();

            return true;
        }

        return false;
    }

    @Override
    public Bullet buildProjectile() {
        return new Bullet(this.getX(), this.getY(), new Vector2(0, 500));
    }

    @Override
    public void move() {
        // moves along the player
    }
}
