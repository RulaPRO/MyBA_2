package by.rula.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
import by.rula.actors.playscreenactors.heroes.HeroesSpells;
import by.rula.actors.playscreenactors.heroes.ShadowFiend;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;

/**
 * Created by Rusel on 31.08.2017.
 */
public class PlayScreen implements Screen {

    private MyBA game;
    private Camera camera;
    private SpriteBatch batch;

    public Stage stage;

    private Image bgImg;
    //private Image btnEsc;
    //private Image btnSwap;

    private Hero player;
    //private Hero selectedPlayer;

    private Hero sf;
    //private Hero sfbot;
    private Hero axe;
    //private Hero inv;

    private Actor btnEsc;

    private Group heroesManager;
    private Group bulletManager;

    private HeroesSpells heroesSpells;

    private PlayScreenHUD hud;

    private HeroSkillManager skillManager;

    //private HeroInfo selectedHeroInfo;

    //private Array<CollisionBox> heroesDireCollBox;
    //private Array<CollisionBox> heroesRadiantCollBox;

    public PlayScreen(MyBA game, Hero hero) {
        this.game = game;
        player = hero;
    }

    @Override
    public void show() {

        batch = game.batch;
        camera = game.camera;

        stage = new Stage(new FitViewport(MyBA.V_WIDTH * 2, MyBA.V_HEIGHT * 2));
        stage.setDebugAll(true);

        //controller
        Gdx.input.setInputProcessor(stage);

        //heroesDireCollBox = new Array();
        //heroesRadiantCollBox = new Array();

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

        player.setPosition(200, 470);
        player.setSide("radiant");

        sf = new ShadowFiend();
        sf.setPosition(800, 470);
        sf.setFaceRight(false);

        axe = new Axe();
        axe.setPosition(1100, 470);
        axe.setFaceRight(false);

        //player = inv;
        //selectedPlayer = player;

        // heroes group
        heroesManager = new Group();
        heroesManager.setName("heroesManager");

        heroesManager.addActor(sf);
        heroesManager.addActor(axe);
        heroesManager.addActor(player);

        // heroes bullets
        bulletManager = new Group();
        bulletManager.setName("bulletManager");

        // heroes spells
        heroesSpells = new HeroesSpells();

        //skill manager
        skillManager = player.getHeroSkillManager();

        //HUD
        hud = new PlayScreenHUD(this);
        hud.setPosition(0,0);

        //selectedHeroInfo = new HeroInfo(selectedPlayer);

        stage.addActor(bgImg);

        stage.addActor(heroesManager);
        stage.addActor(bulletManager);

        //add Array Spells
        stage.addActor(heroesSpells);

        //add HUD
        stage.addActor(hud);
        stage.addActor(btnEsc);
        //stage.addActor(skillManager);
        //stage.addActor(selectedHeroInfo);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //batch.setProjectionMatrix(camera.combined);

        stage.act();
        stage.draw();

        //Actors info
        System.out.println("-----------------------");
        for (Actor a : stage.getActors()) {
            if (a instanceof Group) {
                System.out.println(a.getName() + " " + ((Group) a).getChildren().size);
            } else {
                System.out.println(a.getName());
            }
        }
        System.out.println("+++++++++++++++++++++++");
        System.out.println("-----------------------");

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
        player.dispose();
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
