package pl.karmekk.dandash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.karmekk.dandash.entities.projectiles.Bullet;
import pl.karmekk.dandash.entities.Player;
import pl.karmekk.dandash.entities.Drawable;

public class DanDashGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private Array<Drawable> drawables;
    private Bullet bullet;

    @Override
    public void create() {
        batch = new SpriteBatch();

        player = new Player(0, 0, 300f, 0.5f);

        drawables = new Array<>();
        drawables.add(player);

        // demo
        bullet = new Bullet(400, 300, new Vector2(100, 0), new Vector2(-100, 0));
        drawables.add(bullet);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);

        // demo
        if (drawables.contains(bullet, true) && bullet.offScreen()) {
            System.out.println("Destroying the bullet");
            bullet.dispose();
            drawables.removeValue(bullet, true);
        }

        player.move();
        bullet.move(); // demo

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
