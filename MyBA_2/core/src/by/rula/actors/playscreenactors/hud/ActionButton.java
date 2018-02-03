package by.rula.actors.playscreenactors.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Rusel on 16.09.2017.
 */

public class ActionButton extends Actor {

    private Sprite btn;

    private boolean flipX;

    public ActionButton() {
        btn = new Sprite(new Texture(Gdx.files.internal("left_btn.png")));
        setBounds(0, 0, 256, 256);
        flipX = false;
    }

    public ActionButton(String s) {
        btn = new Sprite(new Texture(Gdx.files.internal(s)));
        setBounds(0, 0, 256, 256);
        flipX = false;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!flipX) {
            batch.draw(btn, getX(), getY(), getWidth(), getHeight());
        }
        else {
            batch.draw(btn, getX() + getWidth(), getY(), - getWidth(), getHeight());
        }
    }

    public void setFlipX(boolean b) {
        this.flipX = b;
    }
}