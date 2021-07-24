package pl.karmekk.dandash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.karmekk.dandash.entities.Player;
import pl.karmekk.dandash.interfaces.Drawable;

public class DanDashGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private Array<Drawable> drawables;

    @Override
    public void create() {
        batch = new SpriteBatch();

        player = new Player(200f);

        drawables = new Array<>();
        drawables.add(player);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.2f, 0.2f, 0.2f, 1f);

        batch.begin();

        for (Drawable drawable : drawables) {
            drawable.draw(batch);
        }

        batch.end();

        player.handleMovement();
    }

    @Override
    public void dispose() {
        batch.dispose();

        for (Drawable drawable : drawables) {
            drawable.dispose();
        }
    }
}
