package by.rula.actors.playscreenactors.heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.ShadowFiendSkillManager;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skills.SkillShadowrazeFar;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skills.SkillShadowrazeMedium;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skills.SkillShadowrazeNear;
import by.rula.tools.Animation;

/**
 * Created by Rusel on 31.08.2017.
 */

public class ShadowFiend extends Hero {

    //animation actions
    private static final int STAY = 0;
    private static final int RUN = 1;
    private static final int ATTACK = 2;
    public static final int SHADOW_RAZE = 3;

    private Animation shadowRaze;

    public ShadowFiend() {
        super();
        init();
    }

    public ShadowFiend(float x, float y) {
        this();
        setPosition(x, y);
    }

    private void init() {

        //heals
        heals = healsMax = 500f;
        healsRegen = 1.1f;
        //mana
        mana = manaMax = 291f;
        manaRegen = 0.7f;
        //damage
        damage = 41;
        attackCD = 1.5f;
        attackFrame = 5;
        attackCDTimeCounter = (float)attackFrame / 10;
        //run speed
        runSpeed = 3f;

        //texture
        heroMap = new Texture(Gdx.files.internal("sf_map_v4.png"));
        heroBg = new Texture(Gdx.files.internal("background_sf_960x540.png"));
        heroSkillIconMap = new Texture(Gdx.files.internal("sf_skill_map_256x64.png"));
        heroIcon = new Texture(Gdx.files.internal("icon_sf_128x128.png"));

        heroSkillManager = new ShadowFiendSkillManager(this);

        //animations
        stay = new Animation(new TextureRegion(heroMap), 7, 0);
        run = new Animation(new TextureRegion(heroMap), 8, 1);
        attack = new Animation(new TextureRegion(heroMap), 8, 2);
        shadowRaze = new Animation(new TextureRegion(heroMap), 9, 3);

        heroAnimation = stay;

        heroAnimations = new Array<Animation>();
        heroAnimations.add(stay);
        heroAnimations.add(run);
        heroAnimations.add(attack);
        heroAnimations.add(shadowRaze);

        //bullets
//        bulletSprite = "Quas_24x24.png";
        //info hero icon
//        heroIcon = "icon_sf_128x128.png";
//        heroIconImg = new Texture(Gdx.files.internal(heroIcon));

        setName("shadowFiend");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void createShadowrazeFar() {
        SkillShadowrazeFar skillShadowrazeFar = new SkillShadowrazeFar(this);
        addSpell(skillShadowrazeFar);
    }

    public void createShadowrazeMedium() {
        SkillShadowrazeMedium skillShadowrazeMedium = new SkillShadowrazeMedium(this);
        addSpell(skillShadowrazeMedium);
    }

    public void createShadowrazeNear() {
        SkillShadowrazeNear skillShadowrazeNear = new SkillShadowrazeNear(this);
        addSpell(skillShadowrazeNear);
    }
}