package by.rula.actors.playscreenactors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.hud.*;
import by.rula.screens.PlayScreen;

/**
 * Created by Rusel on 16.09.2017.
 */

public class PlayScreenHUD extends Group {

    private PlayScreen playScreen;

    private ActionButton buttonLeft;
    private ActionButton buttonRight;
    private ActionButton buttonAttack;

    private ButtonFrame btnframe1;
    private ButtonFrame btnframe2;
    private ButtonFrame btnframe3;
    private ButtonFrame btnframe4;
    private ButtonFrame btnframe5;
    private ButtonFrame btnframe6;

    private HeroSkillManager heroSkillManager;

    private HeroInfo heroInfo;

    public PlayScreenHUD(PlayScreen screen) {

        playScreen = screen;
        setName("hud");

        // buttons frame
        btnframe1 = new ButtonFrame();
        btnframe1.setPosition(1410, 30);
        btnframe2 = new ButtonFrame();
        btnframe2.setPosition(1420, 210);
        btnframe3 = new ButtonFrame();
        btnframe3.setPosition(1550, 340);
        btnframe4 = new ButtonFrame();
        btnframe4.setPosition(1730, 350);

        btnframe5 = new ButtonFrame();
        btnframe5.setPosition(1230, 30);
        btnframe6 = new ButtonFrame();
        btnframe6.setPosition(1240, 210);

        // current hero skill buttons
        heroSkillManager = screen.getPlayer().getHeroSkillManager();

        //
        heroInfo = new HeroInfo();

        // button left
        buttonLeft = new ActionButton();
        buttonLeft.setPosition(50, 50);
        buttonLeft.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().moveLeft();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().stopMove();
            }
        });

        // button right
        buttonRight = new ActionButton();
        buttonRight.setFlipX(true);
        buttonRight.setPosition(buttonLeft.getX() + 300, buttonLeft.getY());
        buttonRight.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().moveRight();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().stopMove();
            }
        });

        //button attack
        buttonAttack = new ActionButton("attack_btn.png");
        buttonAttack.setPosition(1920 - 300, 50);
        buttonAttack.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().attackStart();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                playScreen.getPlayer().attackStop();
            }
        });

        addActor(btnframe1);
        addActor(btnframe2);
        addActor(btnframe3);
        addActor(btnframe4);
        addActor(btnframe5);
        addActor(btnframe6);

        addActor(heroSkillManager);
        addActor(heroInfo);

        addActor(buttonLeft);
        addActor(buttonRight);
        addActor(buttonAttack);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}