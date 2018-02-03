package by.rula.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

import by.rula.MyBA;
import by.rula.actors.playscreenactors.heroes.Axe;
import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.heroes.Invoker;
import by.rula.actors.playscreenactors.heroes.ShadowFiend;

/**
 * Created by Rusel on 31.08.2017.
 */
public class PickHeroScreen implements Screen {

    private MyBA game;
    private Stage stage;
    private Camera camera;
    private SpriteBatch batch;

    private Image iconInvoker;
    private Image iconShadowFiend;
    private Image iconAxe;

    private Image btnBack;
    private Image btnReset;

    private Sprite background;
    private float backgroundAlpha;
    private Sprite heroBg;
    private float heroBgAlpha;

    Image btnOK;

    private Hero hero;

    public PickHeroScreen(MyBA game) {
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

        background = new Sprite(new Texture(Gdx.files.internal("!background_960x540.png")));
        backgroundAlpha = 1;

        iconInvoker = new Image(new Texture(Gdx.files.internal("icon_inv_128x128.png")));
        iconInvoker.setPosition(80, 360);
        iconInvoker.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                setHero(new Invoker());
                System.out.println("pick invoker");
                return true;
            }
        });

        iconShadowFiend = new Image(new Texture(Gdx.files.internal("icon_sf_128x128.png")));
        iconShadowFiend.setPosition(80, 200);
        iconShadowFiend.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                setHero(new ShadowFiend());
                System.out.println("pick shadow fiend");
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        iconAxe = new Image(new Texture(Gdx.files.internal("icon_axe_128x128.png")));
        iconAxe.setPosition(80, 40);
        iconAxe.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                setHero(new Axe());
                System.out.println("pick axe");
                return true;
            }
        });

        btnOK = new Image(new Texture(Gdx.files.internal("btn_256x128.png")));
        btnOK.setPosition(270, 10);  //(352, 10)
        btnOK.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                if (hero != null) {
                    PlayScreen ps = new PlayScreen(game, hero);
                    game.gsm.set(ps);
                } else {
                    System.out.println("Choose your hero");
                }
                return true;
            }
        });

        //btn Back
        btnBack = new Image(new Texture(Gdx.files.internal("esc_btn_256x128.png")));
        btnBack.setPosition(0, 473);  //590, 394    352, 10
        btnBack.setBounds(btnBack.getX(), btnBack.getY(), btnBack.getWidth() / 2, btnBack.getHeight() / 2);
        btnBack.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new MenuScreen(game));
                return true;
            }
        });

        //btn Reset
        btnReset = new Image(new Texture(Gdx.files.internal("swap_btn_256x128.png")));
        btnReset.setPosition(0, 409);  //590, 394    352, 10
        btnReset.setBounds(btnReset.getX(), btnReset.getY(), btnReset.getWidth() / 2, btnReset.getHeight() / 2);
        btnReset.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new PickHeroScreen(game));
                return true;
            }
        });



        stage.addActor(iconInvoker);
        stage.addActor(iconShadowFiend);
        stage.addActor(iconAxe);
        //stage.addActor(btnOK);
        stage.addActor(btnBack);
        stage.addActor(btnReset);
    }

    @Override
    public void render(float delta) {
        //clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        camera.update();

        //add Btn
        if (hero != null) {
            stage.addActor(btnOK);
        }

        batch.begin();

        drawBackground();
        drawCurrentHero();

        batch.end();

        stage.act();
        stage.draw();
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

    private void drawBackground() {
        if (heroBg == null) {
            background.draw(batch);
        } else {
            // update background position();
            if (background.getScaleX() > 0.65f) {
                background.setScale(background.getScaleX() - 0.015f);
                background.setPosition(background.getX() - 3.5f, background.getY() - 0.75f);
            }
            background.draw(batch, backgroundAlpha);
            //update backgroundAlpha
            if (backgroundAlpha > 0.3f) {
                backgroundAlpha -= 0.035f;
            }
        }
    }

    private void drawCurrentHero() {
        if (heroBg != null) {
            updateHeroBgPosition();
            heroBg.draw(batch, heroBgAlpha);
            if (heroBgAlpha < 0.975) {
                heroBgAlpha += 0.035f;
            }
        }
    }

    private void updateHeroBgPosition() {
        if (heroBg.getX() > 0) {
            heroBg.setX(heroBg.getX() - 7.5f);
        }
    }

    private void setHero(Hero hero) {
        this.hero = hero;
        heroBg = new Sprite(hero.getHeroBg());
        heroBg.setX(180f);
        heroBgAlpha = 0;
    }

}
