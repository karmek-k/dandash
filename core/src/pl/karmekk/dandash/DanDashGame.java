package pl.karmekk.dandash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.karmekk.dandash.entities.Player;
import pl.karmekk.dandash.entities.Drawable;
import pl.karmekk.dandash.entities.projectiles.Bullet;

public class DanDashGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private Array<Drawable> drawables;
    private Array<Bullet> bullets;

    @Override
    public void create() {
        batch = new SpriteBatch();

        int x = Gdx.graphics.getWidth() / 2 - 4;
        int y = Gdx.graphics.getHeight() / 6 - 4;
        player = new Player(x, y, 300f, 0.5f);

        drawables = new Array<>();
        drawables.add(player);

        bullets = new Array<>();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);

        player.move();

        handleShooting();

        batch.begin();

        for (Drawable drawable : drawables) {
            drawable.draw(batch);
        }

        batch.end();
    }

    /**
     * Moves, creates and destroys bullets.
     */
    private void handleShooting() {
        if (player.isShooting(100)) { // demo
            Bullet bullet = new Bullet(player.getX(), player.getY(), new Vector2(0, 500)); // demo
            bullets.add(bullet);
            drawables.add(bullet);
        }
        for (Bullet b : bullets) {
            if (b.offScreen()) {
                drawables.removeValue(b, true);
                bullets.removeValue(b, true);
                b.dispose();

                continue;
            }

            b.move();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();

        for (Drawable drawable : drawables) {
            drawable.dispose();
        }
    }
}
