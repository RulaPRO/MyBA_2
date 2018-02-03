package by.rula.actors.playscreenactors.heroes.invoker.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.MapObject;

/**
 * Created by Rusel on 27.09.2017.
 */

public class SkillMeteor extends MapObject {

    private Sprite sprite;
    private Hero hero;

    private float distanse;

    public SkillMeteor(Hero hero) {
        super(hero);

        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("invoker_skill_map_640x64.png"))), 64 * 7, 0, 64, 64);
        //setBounds(0, 0, 128, 128);
        //setPosition(0, -200);

        this.hero = hero;

        delay = 0.9f;
        lifeTime = 2.5f;
        distanse = 0;

        //set start position
        if (isFaceRight) {
            startX = hero.getX() + hero.getWidth() / 2 - 200;
        } else {
            startX = hero.getX() + hero.getWidth() / 2 - getWidth() + 200;
        }
        startY = hero.getY() + 340;



        setName("meteor");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (isFaceRight) {
            batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
        } else {
            batch.draw(sprite, getX() + getWidth(), getY(), -getWidth(), getHeight());
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        updatePosition();
        distanse += speed;

//        System.out.println("METEOR delay " + delay);
//        System.out.println("METEOR lifeTime " + lifeTime);
//        System.out.println("METEOR X " + this.getX());
//        System.out.println("METEOR Y " + this.getY());
//        System.out.println("METEOR speed " + speed);

    }

    private void updatePosition() {
        if (delay == 0) {
            if (getY() == -200 ) {
                setPosition(startX, startY);
            }else if (getY() > 440) {
                setSpeed(10f);
                moveBy(0, -7.5f);
            } else if (getY() <= 440) {
                if (getY() < 440) {
                    setY(440);
                }
                setSpeed(6f);
            }
            moveBy(speed, 0);
        }
    }
}
