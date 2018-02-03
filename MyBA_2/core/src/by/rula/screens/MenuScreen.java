package by.rula.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

import by.rula.MyBA;

/**
 * Created by Rusel on 10.09.2017.
 */

public class MenuScreen implements Screen {

    private MyBA game;
    private Stage stage;
    private Camera camera;
    private SpriteBatch batch;

    private Image background0;
    private Image background1;
    private Image background2;
    private Image background3;
    private Image background4;
    private Image backgrounds[];

    private Image iconUnactiveBg0;
    private Image iconUnactiveBg1;
    private Image iconUnactiveBg2;
    private Image iconUnactiveBg3;
    private Image iconUnactiveBg4;
    private Image iconsBg[];

    private Image iconActiveBg;

    private Image btnBack;
    private Image btnReset;
    private Image btnPlay;

    private Image btn0;
    private Image btn1;
    private Image btn2;
    private Image btn3;
    private Image btn4;

    private float menuX = 192;
    private float menuY = 0;

    private int activeBtn = 2;
    private boolean isActiveBtnChange = true;

    MenuScreen(MyBA game) {
        this.game = game;
    }

    @Override
    public void show() {

        batch = game.batch;
        camera = game.camera;

        stage = new Stage(new FitViewport(MyBA.V_WIDTH, MyBA.V_HEIGHT, camera));
        //stage.setDebugAll(true);

        //controller
        Gdx.input.setInputProcessor(stage);

        background0 = new Image(new Texture(Gdx.files.internal("!background_960x540.png")));
        background0.setBounds(-480, 0, 480, 270);
        background0.setColor(1, 1, 1, 0.35f);
        background1 = new Image(new Texture(Gdx.files.internal("!background_960x540.png")));
        background1.setBounds(-480, 0, 480, 270);
        background1.setColor(1, 1, 1, 0.35f);
        background2 = new Image(new Texture(Gdx.files.internal("!background_960x540.png")));
        background2.setBounds(0, 0, 960, 540);
        //background2.setColor(1, 1, 1, 0.35f);
        background3 = new Image(new Texture(Gdx.files.internal("!background_960x540.png")));
        background3.setBounds(960, 0, 480, 270);
        background3.setColor(1, 1, 1, 0.35f);
        background4 = new Image(new Texture(Gdx.files.internal("!background_960x540.png")));
        background4.setBounds(960, 0, 480, 270);
        background4.setColor(1, 1, 1, 0.35f);

        backgrounds = new Image[5];
        backgrounds[0] = background0;
        backgrounds[1] = background1;
        backgrounds[2] = background2;
        backgrounds[3] = background3;
        backgrounds[4] = background4;

        iconActiveBg = new Image(new Texture(Gdx.files.internal("icon_bg_192x96.png")));

        iconUnactiveBg0 = new Image(new Texture(Gdx.files.internal("icon_bg_96x96.png")));
        iconUnactiveBg1 = new Image(new Texture(Gdx.files.internal("icon_bg_96x96.png")));
        iconUnactiveBg2 = new Image(new Texture(Gdx.files.internal("icon_bg_96x96.png")));
        iconUnactiveBg3 = new Image(new Texture(Gdx.files.internal("icon_bg_96x96.png")));
        iconUnactiveBg4 = new Image(new Texture(Gdx.files.internal("icon_bg_96x96.png")));

        iconsBg = new Image[5];
        iconsBg[0] = iconUnactiveBg0;
        iconsBg[1] = iconUnactiveBg1;
        iconsBg[2] = iconUnactiveBg2;
        iconsBg[3] = iconUnactiveBg3;
        iconsBg[4] = iconUnactiveBg4;

        //btn Back
        btnBack = new Image(new Texture(Gdx.files.internal("esc_btn_256x128.png")));
        btnBack.setPosition(0, 473);
        btnBack.setBounds(btnBack.getX(), btnBack.getY(), btnBack.getWidth() / 2, btnBack.getHeight() / 2);
        btnBack.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new MenuScreen(game));
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        //btn Reset
        btnReset = new Image(new Texture(Gdx.files.internal("swap_btn_256x128.png")));
        btnReset.setPosition(0, 409);
        btnReset.setBounds(btnReset.getX(), btnReset.getY(), btnReset.getWidth() / 2, btnReset.getHeight() / 2);
        btnReset.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new MenuScreen(game));
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        //PLAY BTN
        btnPlay = new Image(new Texture(Gdx.files.internal("play_btn_256x128.png")));
        btnPlay.setPosition(352, -1000); //352, -1000
        btnPlay.setVisible(false);
        btnPlay.setColor( 1, 1, 1, 0);
        btnPlay.addAction(Actions.moveTo(352, 100, 0.5f));
        btnPlay.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new PickHeroScreen(game));
                return true;
            }
        });


        btn0 = new Image(new Texture(Gdx.files.internal("icon_shop_192x192.png")));
        btn0.setBounds(240, 0, 192 / 2, 192 / 2);
        btn0.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("click 1 btn");
                setActiveBg(0);

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        btn1 = new Image(new Texture(Gdx.files.internal("icon_pick_192x192.png")));
        btn1.setBounds(336, 0, 192 / 2, 192 / 2);
        btn1.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("click 2 btn");
                setActiveBg(1);

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        btn2 = new Image(new Texture(Gdx.files.internal("icon_fight_192x192.png")));
        btn2.setBounds(432, 0, 192 / 2, 192 / 2);
        btn2.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("click 3 btn");
                setActiveBg(2);

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        btn3 = new Image(new Texture(Gdx.files.internal("icon_guild_192x192.png")));
        btn3.setBounds(528, 0, 192 / 2, 192 / 2);
        btn3.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("click 4 btn");
                setActiveBg(3);

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        btn4 = new Image(new Texture(Gdx.files.internal("icon_tournament_192x192.png")));
        btn4.setBounds(624, 0, 192 / 2, 192 / 2);
        btn4.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("click 5 btn");
                setActiveBg(4);

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        stage.addActor(background0);
        stage.addActor(background1);
        stage.addActor(background2);
        stage.addActor(background3);
        stage.addActor(background4);

        stage.addActor(btnBack);
        stage.addActor(btnReset);
        stage.addActor(btnPlay);

        stage.addActor(iconUnactiveBg0);
        stage.addActor(iconUnactiveBg1);
        stage.addActor(iconUnactiveBg2);
        stage.addActor(iconUnactiveBg3);
        stage.addActor(iconUnactiveBg4);
        stage.addActor(iconActiveBg);

        stage.addActor(btn0);
        stage.addActor(btn1);
        stage.addActor(btn2);
        stage.addActor(btn3);
        stage.addActor(btn4);

        //setActiveBg(2);
    }

    @Override
    public void render(float delta) {
        //clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        camera.update();

        updateIconsBg();
        updateBtns();
        updateScreenBtnsVisible();

        //System.out.println(activeBtn);

        stage.act();

        batch.begin();
        batch.end();

        stage.draw();
    }

    //сыорачивание текущего и разворачивание нового фона Screen
    private void setActiveBg(int newActiveBg) {

        if (newActiveBg != activeBtn) {

            setScreenBtnsInvisible();

            //HIDE OLD BG
            if (activeBtn > newActiveBg) {
                backgrounds[activeBtn].addAction(Actions.moveTo(960, 0, 0.35f)); //720, 0, 0.25f
            } else if (activeBtn < newActiveBg) {
                backgrounds[activeBtn].addAction(Actions.moveTo(-480, 0, 0.35f)); //0, 0, 0.25f
            }
            backgrounds[activeBtn].addAction(Actions.sizeTo(480, 270, 0.35f)); //240, 135, 0.25f
            backgrounds[activeBtn].addAction(Actions.alpha(0f, 0.35f));

            //SET UP NEW BG
            if (activeBtn > newActiveBg) {
                backgrounds[newActiveBg].setPosition(-480, 0); //0, 0
            } else if (activeBtn < newActiveBg) {
                backgrounds[newActiveBg].setPosition(960, 0); //720, 0
            }
            backgrounds[newActiveBg].addAction(Actions.moveTo(0, 0, 0.35f)); //240, 0, 0.25f
            backgrounds[newActiveBg].addAction(Actions.sizeTo(960, 540, 0.35f)); //480, 270, 0.25f
            backgrounds[newActiveBg].addAction(Actions.alpha(1f, 0.75f));

            setActiveButton(newActiveBg);
        }
    }

    //смена номера активного Screen
    private void setActiveButton(int newActiveBtn) {
        if (0 <= newActiveBtn && newActiveBtn < 5) {
            activeBtn = newActiveBtn;
        }
        isActiveBtnChange = true;
    }

    //обновление фонов нижней части меню
    private void updateIconsBg () {
        if (isActiveBtnChange) {
            //ICON BG update size
            for (Image s : iconsBg) {
                s.setSize(96, 96);
            }
            iconsBg[activeBtn].setSize(192, 96);

            //ICON BG update position
            iconsBg[0].setPosition(menuX, menuY);
            for (int i = 1; i < 5; i++) {
                iconsBg[i].setPosition(iconsBg[i - 1].getX() + iconsBg[i - 1].getWidth(), iconsBg[i - 1].getY());
            }

            //ICON ACTIVE BG update position
            iconActiveBg.setPosition(iconUnactiveBg0.getX() + activeBtn * iconUnactiveBg0.getWidth(), menuY);

            isActiveBtnChange = false;
        }
    }

    //обновление кнопок-иконок нижней части меню
    private void updateBtns() {
        //BTN update position
        btn0.setX(iconUnactiveBg0.getX() + iconUnactiveBg0.getWidth() / 2 - btn0.getWidth() / 2);
        btn1.setX(iconUnactiveBg1.getX() + iconUnactiveBg1.getWidth() / 2 - btn1.getWidth() / 2);
        btn2.setX(iconUnactiveBg2.getX() + iconUnactiveBg2.getWidth() / 2 - btn2.getWidth() / 2);
        btn3.setX(iconUnactiveBg3.getX() + iconUnactiveBg3.getWidth() / 2 - btn3.getWidth() / 2);
        btn4.setX(iconUnactiveBg4.getX() + iconUnactiveBg4.getWidth() / 2 - btn4.getWidth() / 2);
    }

    //делает все кнопки активного Screen видимыми
    private void updateScreenBtnsVisible() {
        if (activeBtn == 2) {
            btnPlay.setVisible(true);
            btnPlay.addAction(Actions.alpha(1f, 0.75f));
            btnPlay.addAction(Actions.moveTo(352, 100, 0.5f));
        }
    }

    //делает все Screens кнопки невидимыми
    private void setScreenBtnsInvisible() {
        btnPlay.setVisible(false);
        btnPlay.addAction(Actions.alpha(0.35f));
        btnPlay.addAction(Actions.moveTo(352, -2000));
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }



}
