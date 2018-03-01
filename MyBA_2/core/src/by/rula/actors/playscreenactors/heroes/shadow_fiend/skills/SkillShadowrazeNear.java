package by.rula.actors.playscreenactors.heroes.shadow_fiend.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.MapObject;

/**
 * Created by Rusel on 27.02.2018.
 */

public class SkillShadowrazeNear extends MapObject {

    private Sprite sprite;
    private Hero hero;

    public SkillShadowrazeNear(Hero hero) {
        super(hero);
        sprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("sf_skill_map_256x64.png"))), 0, 0, 64, 64);
        //setBounds(0, 0, 128, 128);

        this.hero = hero;

        delay = 0.3f;
        lifeTime = 1f;

        //set start position
        if (isFaceRight) {
            startX = hero.getX() + hero.getWidth() / 2 + 200;
        } else {
            startX = hero.getX() + hero.getWidth() / 2 - getWidth() - 200;
        }
        startY = hero.getY();

        setName("shadowrazenear");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if(isFaceRight) {
            batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
        } else {
            batch.draw(sprite, getX() + getWidth(), getY(), -getWidth(), getHeight());
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        updatePosition();
    }

    private void updatePosition() {
        if (delay == 0) {
            if (getY() == -200 ) {
                setPosition(startX, startY);
            }
        }
    }
}