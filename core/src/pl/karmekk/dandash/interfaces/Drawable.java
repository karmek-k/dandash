package pl.karmekk.dandash.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * An object that can be drawn on the screen with SpriteBatch.
 */
public interface Drawable {
    /**
     * Draws the object on the screen.
     * @param batch The SpriteBatch used by the game.
     */
    void draw(SpriteBatch batch);
}
