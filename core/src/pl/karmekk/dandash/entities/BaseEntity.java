package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import pl.karmekk.dandash.interfaces.Drawable;
import pl.karmekk.dandash.interfaces.Movable;

/**
 * Base class for all entities that have a texture and dimensions
 * and can be drawn.
 */
public abstract class BaseEntity implements Drawable, Movable {
    protected Texture texture;
    protected Rectangle rect;

    /**
     * Builds a new entity that has the given rectangle and a default texture.
     */
    public BaseEntity(int x, int y) {
        this.texture = defaultTexture();

        Rectangle rect = new Rectangle();
        rect.x = x;
        rect.y = y;
        rect.width = this.texture.getWidth();
        rect.height = this.texture.getHeight();
        this.rect = rect;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    /**
     * Shortcut for Gdx.graphics.getDeltaTime().
     * @return Delta time
     */
    protected static float dt() {
        return Gdx.graphics.getDeltaTime();
    }

    /**
     * Returns a default texture for the entity.
     * @return The hard-coded default texture.
     */
    private Texture defaultTexture() {
        return new Texture(Gdx.files.internal("sprites/square.png"));
    }
}
