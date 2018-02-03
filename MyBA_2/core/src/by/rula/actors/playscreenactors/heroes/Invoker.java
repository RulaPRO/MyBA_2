package by.rula.actors.playscreenactors.heroes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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

        //heals
        heals = healsMax = 520f;
        healsRegen = 1f;
        //mana
        mana = manaMax = 251f;
        manaRegen = 0.6f;
        //damage
        damage = 41f;
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

        //texture
        heroMap = new Texture(Gdx.files.internal("invoker_map_v10.png"));
        heroBg = new Texture(Gdx.files.internal("background_inv_960x540.png"));
        heroSkillIconMap = new Texture(Gdx.files.internal("invoker_skill_map_256x64.png"));

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

        //spheres
        spheres = new Array<InvokerSphere>();
        //skills
        skills = new Array<SkillButton>();

        //bullets
//        bulletSprite = "Exort_24x24.png";
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
            batch.draw(spheres.get(0).getTextureSphere(spheres.get(0).getColorSphere()), getX() + -62, getY() + 150, 64, 64);
            batch.draw(spheres.get(1).getTextureSphere(spheres.get(1).getColorSphere()), getX() + 19, getY() + 160, 64, 64);
            batch.draw(spheres.get(2).getTextureSphere(spheres.get(2).getColorSphere()), getX() + 100, getY() + 150, 64, 64);
        } else if(spheres.size == 2) {
            batch.draw(spheres.get(0).getTextureSphere(spheres.get(0).getColorSphere()), getX() + -19, getY() + 155, 64, 64);
            batch.draw(spheres.get(1).getTextureSphere(spheres.get(1).getColorSphere()), getX() + 57, getY() + 155, 64, 64);
        } else if(spheres.size == 1) {
            batch.draw(spheres.get(0).getTextureSphere(spheres.get(0).getColorSphere()), getX() + 19, getY() + 150, 64, 64);
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

    public void addSphere(int color) {
        if(spheres.size == 3) spheres.removeIndex(0);
        InvokerSphere s = new InvokerSphere();
        s.setColorSphere(color);
        spheres.add(s);
    }

    public Array<InvokerSphere> getSpheres() {
        return spheres;
    }

    public Array<SkillButton> getSkills() {
        return skills;
    }

    public void createMeteor() {
        SkillMeteor skillMeteor = new SkillMeteor(this);
        addSpell(skillMeteor);
    }

    public void createTornado() {
        SkillTornado skillTornado = new SkillTornado(this);
        addSpell(skillTornado);
    }

    public void createDeafeningBlast() {
        SkillDeafeningBlast skillDeafeningBlast = new SkillDeafeningBlast(this);
        addSpell(skillDeafeningBlast);
    }

    public void createSunStrike() {
        SkillSunStrike skillSunStrike = new SkillSunStrike(this);
        addSpell(skillSunStrike);
    }

    public void createIceWall() {
        SkillIceWall skillIceWall = new SkillIceWall(this);
        addSpell(skillIceWall);
    }
}