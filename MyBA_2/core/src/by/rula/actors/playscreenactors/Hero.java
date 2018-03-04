package by.rula.actors.playscreenactors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;

import by.rula.actors.playscreenactors.hud.HeroSkillManager;
import by.rula.tools.Animation;

/**
 * Created by Rusel on 31.08.2017.
 */

public abstract class Hero extends Actor {

    protected String side; // команда за которую играет герой

    private static final float GRAVITY = -1.5f;
    private static final float GROUND = 440f;
    float velosity;

    float time;

    protected float heals;
    protected float healsMax;
    protected float healsRegen;

    protected float mana;
    protected float manaMax;
    protected float manaRegen;

    protected float damage;
    protected float attackRange;
    protected int attackFrame;
    protected float attackCD;
    protected float attackCDTimeCounter;

    protected float runSpeed;

    protected float cdSkill1;
    protected float cdSkill2;
    protected float cdSkill3;
    protected float cdSkill4;

    //collision box
    protected Rectangle heroCollRect;
    // bullet collision box
    protected Rectangle bulletCollRect;

    protected boolean isRunLeft, isRunRight;
    protected boolean isFaceRight;
    protected boolean isAttack, isAttackCD;

    //hero texture
    protected Texture heroMap;
    private static final int scale = 2;
    private static final float TEXTUREWIDTH = 256;
    private static final float TEXTUREHEIGHT = 144;

    protected Texture heroBg;

    //animations
    //animation actions
    public int currentAction; //номер текущего действия
    //animation actions
    private static final int STAY = 0;
    private static final int RUN = 1;
    private static final int ATTACK = 2;

    protected Animation heroAnimation;
    protected Animation stay;
    protected Animation run;
    protected Animation attack;

    protected Array<Animation> heroAnimations;

    //hero icons texture
    protected Texture heroSkillIconMap;

    protected HeroSkillManager heroSkillManager;

    //image info
    //protected String heroIcon;
    //protected Texture heroIconImg;

    //image bullet
    protected String bulletSprite;

    BitmapFont bitmapFont;

    public Hero() {

        //setBounds
        setBounds(0, 0, 50  * scale, 70 * scale);

        setPosition(150, 470);

        isFaceRight = true;

        velosity = 0;
        //attackCDTimeCounter = 0.5f;
        time = 0;

        cdSkill1 = 2f;
        cdSkill2 = 2f;
        cdSkill3 = 2f;
        cdSkill4 = 2f;

        setName("hero");
        side = "dire";

        // hero collision box
        //collWidth = 32;
        //collHeight = 128;
        heroCollRect = new Rectangle(getX(), getY(), getWidth(), getHeight());

        // bullet collision box
        bulletCollRect = new Rectangle(0, 0, 24, 24);
        // default sprite
        bulletSprite = "Exort_24x24.png";

//        if(side.equals("radiant")) {
//            screen.getHeroesRadiantCollBox().add(heroCollBox);
//            enemyCollBox = screen.getHeroesDireCollBox();
//            isFaceRight = true;
//        } else if (side.equals("dire")) {
//            screen.getHeroesDireCollBox().add(heroCollBox);
//            enemyCollBox = screen.getHeroesRadiantCollBox();
//        }

        //bullets = new Array();

//        addListener(new InputListener() {
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                screen.setSelectedHeroInfo(getThisHero());
//                return true;
//            }
//
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//
//            }
//        });

        bitmapFont = new BitmapFont();
    }

    private Hero getThisHero () {
        return this;
    }

    @Override
    public void act(float delta) {

        //fall from gravity (hero Y position update)
        falling();

        //hero X position update
        move();
        //hero collbox position update
        heroCollRect.setPosition(getX(), getY());

        //animation update
        if (currentAction < 3) {  //3
            //STAY
            if (!isRunLeft && !isRunRight && !isAttack) {
                if (currentAction != STAY) {
                    setAnimations(STAY);
                }
            }
            //RUN
            if (isRunLeft || isRunRight && !isAttack) {
                if (currentAction != RUN) {
                    setAnimations(RUN);
                }
            }
            //ATTACK
            if (isAttack) {
                if (currentAction != ATTACK && !isAttackCD) {
                    setAnimations(ATTACK);
                }
                if (heroAnimation.getCurrentFrame() == attackFrame && !isAttackCD) {
                    createBullet();
                    isAttackCD = true;
                }
                //if(heroAnimation.getCurrentFrame() == heroAnimation.getFrames().size - 1) {
                //    isAttackCD = false;
                //}
            }
        }

        //AttackCD
        if(currentAction == ATTACK && heroAnimation.getCurrentFrame() == heroAnimation.getFrames().size - 1 && isAttackCD) {
            setAnimations(STAY);
        }

        //SKILL animations set NORMAL (заперт на зацикленность анимации для скиллов)
        if(currentAction > 2 && heroAnimation.getCurrentFrame() == heroAnimation.getFrames().size - 1) {  //2

            if(isRunLeft || isRunRight) {
                setAnimations(RUN);
            } else {
                setAnimations(STAY);
            }
        }

        //texture animatin update
        heroAnimation.update(delta);

        if(isAttackCD) {
            attackCDTimeCounter += delta;
            if(attackCDTimeCounter >= attackCD) {
                isAttackCD = false;
                attackCDTimeCounter = (float)attackFrame / 10;
            }
            //System.out.println(attackCDTimeCounter);
        }

        time += delta;

        //regen heals and mana
        if(time >= 1f) {
            regenHeals();
            regenMana();
            time = time - 1f;
        }

//        checkCollision();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        //draw hero
        if(isFaceRight) {
            batch.draw(getCurrentTexture(), getX() - TEXTUREWIDTH + getWidth()/2, getY() - 30, TEXTUREWIDTH * scale, TEXTUREHEIGHT * scale);
        }
        else {
            batch.draw(getCurrentTexture(), getX() + TEXTUREWIDTH + getWidth()/2, getY() - 30, -TEXTUREWIDTH * scale, TEXTUREHEIGHT * scale);
        }

        bitmapFont.getData().setScale(2f);
        bitmapFont.draw(batch, "name " + getName(), getX() - 50, getY() + 320);
        bitmapFont.draw(batch, "team " + side, getX() - 50, getY() + 290);
        bitmapFont.draw(batch, "heals " + (int)heals + " \\  " + (int)healsMax, getX() - 50, getY() + 260);
        bitmapFont.draw(batch, "mana " + (int)mana + " \\  " + (int)manaMax, getX() - 50, getY() + 230);
        bitmapFont.draw(batch, "damage " + (int)damage, getX() - 50, getY() + 200);
        bitmapFont.draw(batch, "x." + getX() + " y." + getY(), getX() - 50, getY() + 170);
    }

    public TextureRegion getCurrentTexture() {
        return heroAnimation.getFrame();
    }

    public Texture getHeroBg() {
        return heroBg;
    }

    public Texture getHeroSkillIconMap() {
        return heroSkillIconMap;
    }

    public void setAnimations(int i) {
        currentAction = i;
        heroAnimation = heroAnimations.get(i);
        heroAnimation.setCurrentFrame(0);
    }

    public HeroSkillManager getHeroSkillManager() {
        return heroSkillManager;
    }

    //fall from gravity
    public void falling() {
        if (getY() > GROUND) {
            velosity += GRAVITY;
            setY(getY() + velosity);
        } else if (getY() < GROUND) {
            velosity = 0;
            setY(GROUND);
        }
    }

    //heals regen
    public void regenHeals() {
        if(heals < healsMax) {
            heals += healsRegen;
            if(heals > healsMax) {
                heals = healsMax;
            }
        }
    }

    //mana regen
    public void regenMana() {
        if(mana < manaMax) {
            mana += manaRegen;
            if(mana > manaMax) {
                mana = manaMax;
            }
        }
    }

    //taking damage
    public void makeDamage(float damage) {
        heals = heals - damage;
        if (heals < 0) heals = 0;
    }

    //spend mana
    public boolean spendMana(float spellCost) {
        if (mana - spellCost >= 0) {
            mana = mana - spellCost;
            return  true;
        } else {
            return false;
        }
    }

    //heal
    public void healing(float heal) {
        heals = heals + heal;
    }

    public void setFaceRight(boolean faceRight) {
        isFaceRight = faceRight;
    }

    public void moveLeft() {
        isRunLeft = true;
        isFaceRight = false;
    }

    public void moveRight() {
        isRunRight = true;
        isFaceRight = true;
    }

    public void stopMove() {
        isRunLeft = false;
        isRunRight = false;
    }

    private void move() {
        //if(isRunLeft) setX(getX() - runSpeed);
        if(isRunLeft && currentAction < 2) moveBy(-runSpeed, 0);
        //if(isRunRight) setX(getX() + runSpeed);
        if(isRunRight && currentAction < 2) moveBy(runSpeed, 0);
    }

    public void attackStart() {
        isAttack = true;
    }

    public void attackStop() {
        isAttack = false;
    }

    public void createBullet() {
        Bullet b = new Bullet(this, bulletSprite, bulletCollRect, isFaceRight);
        ((Group)this.getStage().getRoot().findActor("bulletManager")).addActor(b);
    }

    //collisions with
//    public void checkCollision() {
//
//        for(int i = 0; i < enemyCollBox.size; i++) {
//
//            for(int j = 0; j < bullets.size; j++) {
//
//                if (enemyCollBox.get(i).getCollRect().overlaps(bullets.get(j).getCollRect())) {
//
//                    bullets.removeIndex(j);
//
//                    //нанесение "урона" актеру с которым произошло столкновение
//                    enemyCollBox.get(i).getHero().makeDamage(damage);
//
//                }
//            }
//        }
//    }

    //add a spell to the stage
    public void addSpell(MapObject spell) {
        ((Group)this.getStage().getRoot().findActor("heroesSpellManager")).addActor(spell);
    }

    public float getHeals() {
        return heals;
    }

    public float getDamage() {
        return damage;
    }

    public boolean isFaceRight() {
        return isFaceRight;
    }

    public String getSide() {
        return side;
    }
    public void setSide(String side) {
        this.side = side;
    }

    public Rectangle getHeroCollRect() {
        return heroCollRect;
    }

    public void dispose() {
        heroMap.dispose();
        heroBg.dispose();
        heroSkillIconMap.dispose();
//        heroIconImg.dispose();
    }

}
