package pl.karmekk.dandash.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * An object that can be drawn on the screen with SpriteBatch.
 */
public interface Drawable extends Disposable {
    /**
     * Draws the object on the screen.
     * @param batch The SpriteBatch used by the game.
     */
    void draw(SpriteBatch batch);
}
