package by.rula.actors.playscreenactors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import by.rula.actors.playscreenactors.Hero;

/**
 * Created by Rusel on 19.09.2017.
 */
public class SkillButton extends Actor{

    //private Hero hero;
    protected Texture iconMap;
    protected Sprite icon;
    private int index;

    public SkillButton(Hero hero) {
        //this.hero = hero;
        iconMap = hero.getHeroSkillIconMap();
        setBounds(0, 0, 128, 128);
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

    }

    public int getIndex() {
        return index;
    }

    //public Sprite getSkillIcon() {
    //    return icon;
    //}
}
