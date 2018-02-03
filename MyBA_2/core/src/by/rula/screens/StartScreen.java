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
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

import by.rula.MyBA;

/**
 * Created by Rusel on 14.09.2017.
 */

public class StartScreen implements Screen {

    private MyBA game;
    private Stage stage;
    private Camera camera;

    private SpriteBatch batch;

    //Image bgImg;
    private Image btnPlay;

    private Sprite bgImg;
    private float heroBgAlpha;

    public StartScreen (MyBA game) {
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

        bgImg = new Sprite(new Texture(Gdx.files.internal("!background_960x540.png")));
        heroBgAlpha = 0;

        //btn play
        btnPlay = new Image(new Texture(Gdx.files.internal("tap_the_screen_960x540.png")));
        //btnPlay.setPosition(0, 0);
        btnPlay.setVisible(false);
        btnPlay.setColor(1, 1, 1, 0);
        btnPlay.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new MenuScreen(game));
                return true;
            }
        });

        stage.addActor(btnPlay);

    }

    @Override
    public void render(float delta) {

        //clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        camera.update();

        updateTap();
        stage.act();

        batch.begin();
        drawBackground();
        batch.end();

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
        bgImg.draw(batch, heroBgAlpha);
        if (heroBgAlpha < 0.975) {
            heroBgAlpha += 0.0075f;
        }
    }

    private void updateTap() {
        if (!btnPlay.isVisible() && heroBgAlpha > 0.975) {
            btnPlay.setVisible(true);
            btnPlay.addAction(Actions.alpha(1f, 0.5f));
        }
        if (btnPlay.getColor().a == 1) {
            btnPlay.addAction(Actions.alpha(0f, 0.5f));
        } else if (btnPlay.getColor().a == 0) {
            btnPlay.addAction(Actions.alpha(1f, 0.5f));
        }
    }
}
