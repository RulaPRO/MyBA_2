package by.rula.actors.playscreenactors.heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import by.rula.actors.playscreenactors.Hero;
import by.rula.actors.playscreenactors.heroes.invoker.skills.SkillDeafeningBlast;
import by.rula.actors.playscreenactors.heroes.invoker.skills.SkillIceWall;
import by.rula.actors.playscreenactors.heroes.invoker.InvokerSkillManager;
import by.rula.actors.playscreenactors.heroes.invoker.InvokerSphere;
import by.rula.actors.playscreenactors.heroes.invoker.skills.SkillMeteor;
import by.rula.actors.playscreenactors.heroes.invoker.skills.SkillSunStrike;
import by.rula.actors.playscreenactors.heroes.invoker.skills.SkillTornado;
import by.rula.actors.playscreenactors.hud.SkillButton;
import by.rula.tools.Animation;

/**
 * Created by Rusel on 31.08.2017.
 */

public class Invoker extends Hero {

    //animations
    //private final int[] numFrames = {12, 8, 11, 12, 15, 15, 15};

    protected float cdEEE;
    protected float cdEEW;
    protected float cdWWQ;
    protected float cdQWE;
    protected float cdEEQ;
    protected float cdWWE;
    protected float cdQQE;
    protected float cdQQQ;

    //animation actions
    protected static final int STAY = 0;
    protected static final int RUN = 1;
    protected static final int ATTACK = 2;
    public static final int EEE = 3;
    public static final int EEW = 4;
    public static final int WWQ = 5;
    public static final int QWE = 6;
    public static final int EEQ = 7;
    public static final int WWE = 8;
    public static final int QQE = 9;
    public static final int QQQ = 10;
    public static final int QQW = 11;

    //private Animation heroAnimation;
    //private Animation stay;
    //private Animation run;
    //private Animation attack;
    private Animation eee;
    private Animation eew;
    private Animation wwq;
    private Animation qwe;
    private Animation eeq;
    private Animation wwe;
    private Animation qqe;
    private Animation qqq;
    private Animation qqw;


    //sphere
    private Array<InvokerSphere> spheres;
    private static final int QUAS = 0;
    private static final int WEX = 1;
    private static final int EXORT = 2;

    //skill icons
    private Array<SkillButton> skills;

    public Invoker() {

        super();

        //bounds

        side = "radiant";

        //heals
        heals = healsMax = 520f;
        healsRegen = 1f;
        //mana
        mana = manaMax = 267f;
        manaRegen = 0.6f;
        //damage
        damage = 123f; // 41
        attackCD = 1.5f;
        attackFrame = 5;
        attackCDTimeCounter = (float)attackFrame / 10;
        //run speed
        runSpeed = 3f;

        cdEEE = 2f;
        cdEEW = 2f;
        cdWWQ = 2f;
        cdQWE = 2f;
        cdEEQ = 2f;
        cdWWE = 2f;
        cdQQE = 2f;
        cdQQQ = 2f;

        //texture
        heroMap = new Texture(Gdx.files.internal("invoker_map_v12.png"));
        heroBg = new Texture(Gdx.files.internal("background_inv_960x540.png"));
        heroSkillIconMap = new Texture(Gdx.files.internal("invoker_skill_map_256x64.png"));
        heroIcon = new Texture(Gdx.files.internal("icon_inv_128x128.png"));

        heroSkillManager = new InvokerSkillManager(this);

        //animations
        stay = new Animation(new TextureRegion(heroMap), 12, 0);
        run = new Animation(new TextureRegion(heroMap), 8, 1);
        attack = new Animation(new TextureRegion(heroMap), 11, 2);
        eee = new Animation(new TextureRegion(heroMap), 12, 3);
        eew = new Animation(new TextureRegion(heroMap), 15, 4);
        wwq = new Animation(new TextureRegion(heroMap), 15, 5);
        qwe = new Animation(new TextureRegion(heroMap), 15, 6);
        eeq = new Animation(new TextureRegion(heroMap), 13, 7);
        wwe = new Animation(new TextureRegion(heroMap), 15, 8);
        qqe = new Animation(new TextureRegion(heroMap), 15, 9);
        qqq = new Animation(new TextureRegion(heroMap), 15, 10);
        qqw = new Animation(new TextureRegion(heroMap), 12, 11);

        heroAnimation = stay;

        heroAnimations = new Array<Animation>();
        heroAnimations.add(stay);
        heroAnimations.add(run);
        heroAnimations.add(attack);
        heroAnimations.add(eee);
        heroAnimations.add(eew);
        heroAnimations.add(wwq);
        heroAnimations.add(qwe);
        heroAnimations.add(eeq);
        heroAnimations.add(wwe);
        heroAnimations.add(qqe);
        heroAnimations.add(qqq);
        heroAnimations.add(qqw);

        //spheres
        spheres = new Array<InvokerSphere>();
        //skills
        skills = new Array<SkillButton>();

        //bullets
        bulletSprite = "Exort_24x24.png";
        //info hero icon
//        heroIcon = "icon_inv_128x128.png";
//        heroIconImg = new Texture(Gdx.files.internal(heroIcon));

        setName("invoker");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //draw spheres
        if(spheres.size == 3) {                 //140  226  312
            batch.draw(spheres.get(0).getTextureSphere(), getX() + -62, getY() + 150, 64, 64);
            batch.draw(spheres.get(1).getTextureSphere(), getX() + 19, getY() + 160, 64, 64);
            batch.draw(spheres.get(2).getTextureSphere(), getX() + 100, getY() + 150, 64, 64);
        } else if(spheres.size == 2) {
            batch.draw(spheres.get(0).getTextureSphere(), getX() + -19, getY() + 155, 64, 64);
            batch.draw(spheres.get(1).getTextureSphere(), getX() + 57, getY() + 155, 64, 64);
        } else if(spheres.size == 1) {
            batch.draw(spheres.get(0).getTextureSphere(), getX() + 19, getY() + 150, 64, 64);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //TORNADO
//        if (currentAction == WWQ && heroAnimation.getCurrentFrame() == 8) {
//            SkillTornado tornado = new SkillTornado(this);
//            tornado.setPosition(getX() + getWidth() / 2, getY());
//            addSpell(tornado);
//        }

        //BLAST
//        if (currentAction == QWE && heroAnimation.getCurrentFrame() == 9) {
//            SkillDeafeningBlast deafeningBlast = new SkillDeafeningBlast(this);
//            deafeningBlast.setPosition(getX() + getWidth() / 2, getY());
//            addSpell(deafeningBlast);
//        }

        //METEOR
//        if (currentAction == EEW && heroAnimation.getCurrentFrame() == 9) {
//            SkillMeteor meteor = new SkillMeteor(this);
//            if(isFaceRight) {
//                meteor.setPosition(getX() + getWidth() / 2 - 200, getY() + 340);
//            } else {
//                meteor.setPosition(getX() + getWidth() / 2 + 200, getY() + 340);
//            }
//            addSpell(meteor);
//        }

        //SUN STRIKE
//        if (currentAction == EEE && heroAnimation.getCurrentFrame() == 6) {
//            SkillSunStrike sunStrike = new SkillSunStrike(this);
//            if(isFaceRight) {
//                sunStrike.setPosition(getX() + getWidth() / 2 + 750, 2000);
//            } else {
//                sunStrike.setPosition(getX() + getWidth() / 2 - 750, 2000);
//            }
//            addSpell(sunStrike);
//        }

    }

    //запуск анимации прожатого заклинания
//    public void useSkill(int i) {
//        switch (skills.get(i).getIndex()) {
//            case 2:
//                setAnimations(WWQ);
//                break;
//            case 5:
//                setAnimations(QWE);
//                break;
//            case 8:
//                setAnimations(EEQ);
//                break;
//            case 9:
//                setAnimations(EEW);
//                break;
//            case 12:
//                setAnimations(EEE);
//                break;
//        }
//    }

    public void addSphere(int sphereColor) {
        if(spheres.size == 3) spheres.removeIndex(0);
        spheres.add(new InvokerSphere(sphereColor));
    }

    public Array<InvokerSphere> getSpheres() {
        return spheres;
    }

    public Array<SkillButton> getSkills() {
        return skills;
    }

    public void createMeteor() {
        addSpell(new SkillMeteor(this));
    }

    public void createTornado() {
        addSpell(new SkillTornado(this));
    }

    public void createDeafeningBlast() {
        addSpell(new SkillDeafeningBlast(this));
    }

    public void createSunStrike() {
        addSpell(new SkillSunStrike(this));
    }

    public void createIceWall() {
        addSpell(new SkillIceWall(this));
    }
}