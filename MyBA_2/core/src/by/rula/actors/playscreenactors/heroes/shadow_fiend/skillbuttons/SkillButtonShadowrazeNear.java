package by.rula.actors.playscreenactors.heroes.shadow_fiend.skillbuttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.heroes.ShadowFiend;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 19.09.2017.
 */
public class SkillButtonShadowrazeNear extends SkillButton {

    private ShadowFiend shadowFiend;

    public SkillButtonShadowrazeNear(ShadowFiend hero) {
        super(hero);
        shadowFiend = hero;
        icon = new Sprite(new TextureRegion(iconMap), 0, 0, 64, 64);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Im 1 SKILL");
                shadowFiend.setAnimations(ShadowFiend.SHADOW_RAZE);
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
}