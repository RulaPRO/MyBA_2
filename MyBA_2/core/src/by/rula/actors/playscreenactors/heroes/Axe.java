package by.rula.actors.playscreenactors.heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.heroes.axe.AxeSkillManager;
import by.rula.tools.Animation;

/**
 * Created by Rusel on 31.08.2017.
 */

public class Axe extends Hero {

    //animation actions
    private static final int STAY = 0;
    private static final int RUN = 1;
    private static final int ATTACK = 2;
    public static final int BERSERKERS_CALL = 4;
    public static final int BTTLE_HUNGER = 5;
    public static final int COUNTER_HELIX = 6;
    public static final int CULLING_BLADE = 7;

    public Axe() {

        super();

        //heals
        heals = healsMax = 700f;
        healsRegen = 1.1f;
        //mana
        mana = manaMax = 291f;
        manaRegen = 0.7f;
        //damage
        damage = 53;
        attackCD = 1.5f;
        attackFrame = 5;
        attackCDTimeCounter = (float)attackFrame / 10;
        //run speed
        runSpeed = 3f;

        //texture
        heroMap = new Texture(Gdx.files.internal("axe_map_v3.png"));
        heroBg = new Texture(Gdx.files.internal("background_axe_960x540.png"));
        heroSkillIconMap = new Texture(Gdx.files.internal("axe_skill_map_256x64.png"));
        heroIcon = new Texture(Gdx.files.internal("icon_axe_128x128.png"));

        heroSkillManager = new AxeSkillManager(this);

        //animations
        stay = new Animation(new TextureRegion(heroMap), 14, 0);
        run = new Animation(new TextureRegion(heroMap), 8, 1);
        attack = new Animation(new TextureRegion(heroMap), 12, 2);

        heroAnimation = stay;

        heroAnimations = new Array<Animation>();
        heroAnimations.add(stay);
        heroAnimations.add(run);
        heroAnimations.add(attack);

        //bullets
//        bulletSprite = "Quas_24x24.png";
//        //info hero icon
//        heroIcon = "icon_axe_128x128.png";
//        heroIconImg = new Texture(Gdx.files.internal(heroIcon));

        setName("axe");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}