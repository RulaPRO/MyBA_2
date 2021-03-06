package by.rula.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

import by.rula.MyBA;
import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.PlayScreenHUD;
import by.rula.actors.playscreenactors.heroes.Axe;
import by.rula.actors.playscreenactors.heroes.ShadowFiend;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;

/**
 * Created by Rusel on 31.08.2017.
 */
public class PlayScreen implements Screen {

    private MyBA game;
    private SpriteBatch batch;

    public Stage stage;

    private BitmapFont bitmapFont;

    private Image bgImg;
    //private Image btnSwap;

    private Hero player;
    private Hero sf;
    private Hero axe;

    private Actor btnEsc;

    private Group heroesManager;
    private Group bulletManager;
    private Group heroesSpellManager;

    private PlayScreenHUD hud;

    public PlayScreen(MyBA game, Hero hero) {
        this.game = game;
        player = hero;
    }

    @Override
    public void show() {

        batch = game.batch;

        stage = new Stage(new FitViewport(MyBA.V_WIDTH * 2, MyBA.V_HEIGHT * 2));
        stage.setDebugAll(true);

        //controller
        Gdx.input.setInputProcessor(stage);

        // font
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(1f);

        //actors
        //background
        bgImg = new Image(new Texture(Gdx.files.internal("bg_1920x1080.png")));
        bgImg.setName("background");

        //button Esc
        btnEsc = new Image(new Texture(Gdx.files.internal("esc_btn_256x128.png")));
        btnEsc.setPosition(0, stage.getHeight() - 128);
        btnEsc.setName("btnEsc");
        btnEsc.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gsm.set(new PickHeroScreen(game));
                return true;
            }
        });

        //button swap
//        btnSwap = new Image(new Texture(Gdx.files.internal("swap_btn_256x128.png")));
//        btnSwap.setPosition(0, stage.getHeight() - btnSwap.getHeight() - 128);
//        btnSwap.addListener(new InputListener() {
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                swap();
//                return true;
//            }
//        });

        player.setPosition(500, 470);
        player.setSide("radiant");

        sf = new ShadowFiend();
        sf.setPosition(1100, 470);
        sf.setFaceRight(false);

        axe = new Axe();
        axe.setPosition(1400, 470);
        axe.setFaceRight(false);

        // heroes group
        heroesManager = new Group();
        heroesManager.setName("heroesManager");

        heroesManager.addActor(sf);
        heroesManager.addActor(axe);
        heroesManager.addActor(player);

        // heroes bullet group
        bulletManager = new Group();
        bulletManager.setName("bulletManager");

        // heroes spell group
        heroesSpellManager = new Group();
        heroesSpellManager.setName("heroesSpellManager");

        //skill manager
        //skillManager = player.getHeroSkillManager();

        //HUD
        hud = new PlayScreenHUD(this);
        hud.setPosition(0,0);

        stage.addActor(bgImg);

        stage.addActor(heroesManager);
        stage.addActor(bulletManager);
        stage.addActor(heroesSpellManager);

        //add HUD
        stage.addActor(hud);
        stage.addActor(btnEsc);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //batch.setProjectionMatrix(camera.combined);

        stage.act();
        stage.draw();

        //Actors info
//        System.out.println("-----------------------");
//        for (Actor a : stage.getActors()) {
//            if (a instanceof Group) {
//                System.out.println(a.getName() + " " + ((Group) a).getChildren().size);
//            } else {
//                System.out.println(a.getName());
//            }
//        }
//        System.out.println("+++++++++++++++++++++++");
//        System.out.println("-----------------------");

        // info
        batch.begin();
        int x = 350;
        int y = 150;
        for (Actor a : stage.getActors()) {
            if (a instanceof Group) {
                bitmapFont.draw(batch, "Group \"" + a.getName() + "\" " + ((Group) a).getChildren().size, x, y);
                //System.out.println(a.getName() + " " + ((Group) a).getChildren().size);
            } else {
                bitmapFont.draw(batch, "Actor \"" + a.getName() + "\" ", x, y);
                //System.out.println(a.getName());
            }
            y -= 15;
        }
        batch.end();
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
        stage.dispose();
        //player.dispose();
        //inv.dispose();
        //sf.dispose();
        //sfbot.dispose();
        //axe.dispose();
    }

//    private void swap() {
//        if (player == inv) {
//            player = sf;
//            skillManager.remove();
//            stage.addActor(skillManager = player.getSkillManager());
//            System.out.println(player.getName());
//        } else if (player == sf) {
//            player = axe;
//            skillManager.remove();
//            stage.addActor(skillManager = player.getSkillManager());
//            System.out.println(player.getName());
//        } else if (player == axe) {
//            player = inv;
//            skillManager.remove();
//            stage.addActor(skillManager = player.getSkillManager());
//            System.out.println(player.getName());
//        }
//    }

//    public Array<CollisionBox> getHeroesDireCollBox() {
//        return heroesDireCollBox;
//    }
//
//    public Array<CollisionBox> getHeroesRadiantCollBox() {
//        return heroesRadiantCollBox;
//    }

//    public void setSelectedHeroInfo(Hero hero) {
//        selectedHeroInfo.setInfo(hero);
//    }
//
//    public void setSkillManager(Hero hero) {
//        skillManager.setManager(hero);
//    }

    public Hero getPlayer() {
        return player;
    }

    public void setPlayer(Hero player) {
        this.player = player;
    }
}
