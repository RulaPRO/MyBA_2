package by.rula.actors.playscreenactors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Rusel on 28.02.2018.
 */

public class Bullet extends Actor {

    private Hero hero; // герой который создал bullet

    private Sprite bulletSprite;
    private Rectangle collRect;

    private boolean isFaceRight;
    private float moveSpeed;

    public Bullet(Hero hero, String bulletSpritePath, Rectangle bulletCollRect, boolean isFaceRight) {

        this.hero = hero;
        bulletSprite = new Sprite(new Texture(Gdx.files.internal(bulletSpritePath)));
        this.collRect = bulletCollRect;
        this.isFaceRight = isFaceRight;

        moveSpeed = 30f;
        if (!isFaceRight) {
            moveSpeed = -moveSpeed;
        }

        setBounds(0, 0, 24, 24);
        setPosition(hero.getX() + hero.getWidth() / 2 - getWidth() / 2, hero.getY() + 50);

        setName("bullet");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(isFaceRight) {
            batch.draw(bulletSprite, getX(), getY(), getWidth(), getHeight());
        } else {
            batch.draw(bulletSprite, getX() + getWidth(), getY(), - getWidth(), getHeight());
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        updatePosition();
        checkCollision();
    }

    private void updatePosition() {
        setX(getX() + moveSpeed);
        collRect.setPosition(getX(), getY());
    }

    private void checkCollision() {
        // получение коллекции всех героев на сцене
        Group g = getStage().getRoot().findActor("heroesManager");
        for(Actor a : g.getChildren()) {
            // удаляем пулю если
            // герой выпустивший эту пулю и герой с котрым пуля пересеклась из разных команд
            if (!hero.getSide().equals(((Hero)a).getSide()) && collRect.overlaps(((Hero)a).getHeroCollRect())) {
                ((Hero) a).makeDamage(hero.getDamage()); // нанесение урона
                remove(); // удаление пули со сцены
            }
        }
    }
}
