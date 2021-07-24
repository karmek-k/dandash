package pl.karmekk.dandash.entities;

import com.badlogic.gdx.math.Vector2;

public class Bullet extends BaseEntity {
    private final Vector2 velocity;

    public Bullet(int x, int y, Vector2 velocity) {
        super(x, y);
        this.velocity = velocity;
    }

    @Override
    public void move() {
        this.rect.x += velocity.x;
        this.rect.y += velocity.y;
    }
}
