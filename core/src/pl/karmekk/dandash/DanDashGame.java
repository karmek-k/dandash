package pl.karmekk.dandash;

import com.badlogic.gdx.ApplicationAdapter;
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

        player = new Player(0, 0, 300f, 0.5f);

        drawables = new Array<>();
        drawables.add(player);

        bullets = new Array<>();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);

        player.move();

        // TODO: extract this to a separate method
        if (player.isShooting(100)) {
            Bullet bullet = new Bullet(player.getX(), player.getY(), new Vector2(0, 500));
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

        batch.begin();

        for (Drawable drawable : drawables) {
            drawable.draw(batch);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

        for (Drawable drawable : drawables) {
            drawable.dispose();
        }
    }
}
