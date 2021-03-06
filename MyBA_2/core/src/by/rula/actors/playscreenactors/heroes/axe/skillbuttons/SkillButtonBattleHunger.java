package by.rula.actors.playscreenactors.heroes.axe.skillbuttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.heroes.Axe;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 19.09.2017.
 */

public class SkillButtonBattleHunger extends SkillButton{

    private Axe axe;

    public SkillButtonBattleHunger(Axe hero) {
        super(hero);
        axe = hero;
        icon = new Sprite(new TextureRegion(iconMap), 64, 0, 64, 64);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Im Battle Hunger");
                //axe.setAnimations(Axe.BTTLE_HUNGER);
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(icon, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {

    }

    public Sprite getSkillIcon() {
        return icon;
    }
}
