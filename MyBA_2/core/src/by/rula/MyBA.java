package by.rula;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyBA extends Game {

	public static final  int V_WIDTH = 960;
	public static final int V_HEIGHT = 540;

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public GameScreenManager gsm;


	@Override
	public void create() {

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		gsm = new GameScreenManager(this);
	}

	@Override
	public void render () {
		gsm.renderScreen(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {

	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
