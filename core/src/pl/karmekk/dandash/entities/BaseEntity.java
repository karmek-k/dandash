package pl.karmekk.dandash.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import pl.karmekk.dandash.interfaces.Drawable;

public abstract class BaseEntity implements Drawable {
    private Texture texture;
    private Rectangle rect;

    public BaseEntity() {
        rect = new Rectangle();
        texture = defaultTexture();
    }

//    public BaseEntity(Rectangle rect, Texture texture) {
//        this.rect = rect;
//        this.texture = texture;
//    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    public void dispose() {
        texture.dispose();
    }

    private Texture defaultTexture() {
        return new Texture(Gdx.files.internal("sprites/square.png"));
    }
}
