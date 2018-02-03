package by.rula.actors.playscreenactors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Rusel on 16.09.2017.
 */

public class ButtonFrame extends Actor {

    private Sprite hudbtn;

    public ButtonFrame() {
        hudbtn = new Sprite(new Texture(Gdx.files.internal("frame_btn_80x80.png")));
        setBounds(0, 0, 80 * 2, 80 * 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(hudbtn, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {

    }
}
