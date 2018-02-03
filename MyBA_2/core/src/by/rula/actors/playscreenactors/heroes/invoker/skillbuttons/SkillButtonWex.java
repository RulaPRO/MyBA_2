package by.rula.actors.playscreenactors.heroes.invoker.skillbuttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.heroes.Invoker;
import by.rula.actors.playscreenactors.heroes.invoker.InvokerSphere;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 19.09.2017.
 */
public class SkillButtonWex extends SkillButton {

    private Invoker invoker;

    public SkillButtonWex(Invoker hero) {
        super(hero);
        invoker = hero;
        icon = new Sprite(new TextureRegion(iconMap), 64, 0, 64, 64);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Im WEX");
                invoker.addSphere(InvokerSphere.WEX);
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
