package by.rula.actors.playscreenactors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import by.rula.actors.playscreenactors.Hero;
import by.rula.screens.PlayScreen;

/**
 * Created by Rusel on 04.03.2018.
 */

public class HeroInfo extends Actor {

    private Hero hero;

    private Texture healsBar;
    private Texture healsBar2;
    private Texture manaBar;
    private Texture manaBar2;

    public HeroInfo() {

        hero = null;

        healsBar2 = new Texture(Gdx.files.internal("healsbar2_256x24.png"));
        healsBar = new Texture(Gdx.files.internal("healsbar_256x24.png"));
        manaBar2 = new Texture(Gdx.files.internal("manabar2_256x24.png"));
        manaBar = new Texture(Gdx.files.internal("manabar_256x24.png"));

        setBounds(0, 0, 408, 144);
        setPosition(1512, 936);

        setName("heroInfo");

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);

        if (hero != null) {
            batch.draw(hero.getHeroIcon(), getX() + 5, getY() + 5, 128, 128);
            batch.draw(healsBar2, getX() + 141, getY() + 109, 256, 24);
            batch.draw(healsBar, getX() + 141, getY() + 109, (hero.getHeals() / hero.getHealsMax()) * healsBar2.getWidth(), 24);
            batch.draw(manaBar2, getX() + 141, getY() + 77, 256, 24);
            batch.draw(manaBar, getX() + 141, getY() + 77, (hero.getMana() / hero.getManaMax()) * manaBar2.getWidth(), 24);
        }
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
