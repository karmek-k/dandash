package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import pl.karmekk.dandash.interfaces.Drawable;

/**
 * Base class for all entities that have a texture and dimensions
 * and can be drawn.
 */
public abstract class BaseEntity implements Drawable {
    private Texture texture;
    private Rectangle rect;

    /**
     * Builds a new entity that has a default rectangle and texture.
     */
    public BaseEntity() {
        rect = new Rectangle();
        texture = defaultTexture();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    /**
     * Frees all resources used by this object.
     */
    public void dispose() {
        texture.dispose();
    }

    /**
     * Returns a default texture for the entity.
     * @return
     */
    private Texture defaultTexture() {
        return new Texture(Gdx.files.internal("sprites/square.png"));
    }
}
