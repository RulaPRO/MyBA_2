package by.rula.actors.playscreenactors.heroes.invoker.skillbuttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.heroes.Invoker;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 20.09.2017.
 */
public class SkillButtonWWW extends SkillButton {

    private Sprite icon;
    private int index;

    public SkillButtonWWW(Invoker hero) {
        super(hero);
        icon = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("invoker_skill_map_640x64.png"))), 64 * 4, 0, 64, 64);
        setBounds(0, 0, 128, 128);
        index = 3;

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Im WWW");
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

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

    public int getIndex() {
        return index;
    }
}