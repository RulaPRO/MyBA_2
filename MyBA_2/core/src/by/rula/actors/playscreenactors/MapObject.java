package by.rula.actors.playscreenactors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Rusel on 21.09.2017.
 */

public abstract class MapObject extends Actor {

    private Hero hero;
    protected boolean isFaceRight;

    protected boolean activity; //активнось объекта(если неактивен - значит выполнил жизненный цикл и готов к удалению со сцены)

    protected float startX; //стартовая позиция по оси X в момент выхода объекта на сцену в зону видимости камеры
    protected float startY; //стартовая позиция по оси Y в момент выхода объекта на сцену в зону видимости камеры

    protected float delay; //задержка перед выходом объекта на сцену в зону видимости камеры
    protected float lifeTime; //время жизни объекта на сцене в зоне видимости камеры

    protected float speed; //скорость премещения по оси X

    public MapObject(Hero hero) {
        super();

        this.hero = hero;
        this.isFaceRight = hero.isFaceRight();

        activity = true;

        lifeTime = 2f;
        delay = 0;

        startX = 0;
        startY = 0;

        setBounds(0, -200, 128, 128);
        //setPosition(0, -200);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        updateActivity();
        updateDelay(delta);
        updateLifeTime(delta);
    }

    private void updateActivity() {
        if (lifeTime <= 0) {
            activity = false;
        }
    }

    private void updateLifeTime(float delta) {
        if (delay <= 0) {
            lifeTime -= delta;
        }
    }

    private void updateDelay(float delta) {
        if (delay > 0) {
            delay -= delta;
            if (delay < 0) {
                delay = 0;
            }
        }
    }

    public void setSpeed(float speed) {
        if (this.speed != speed || this.speed != -speed) {
            if (isFaceRight) {
                this.speed = speed;
            } else {
                this.speed = -speed;
            }
        }
    }

    public float getLifeTime() {
        return lifeTime;
    }

    public boolean isActivity() {
        return activity;
    }

    public float getDelay() {
        return delay;
    }
}
