package by.rula.actors.playscreenactors.hud;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

import by.rula.actors.playscreenactors.Hero;

/**
 * Created by Rusel on 19.09.2017.
 */

public class HeroSkillManager extends Group {

    private int amountOfSkill;

    protected SkillButton skill1;
    protected SkillButton skill2;
    protected SkillButton skill3;
    protected SkillButton skill4;
    //protected SkillButton skill5;
    //protected SkillButton skill6;

    //public HeroSkillManager() {
    //    skill1.setPosition(1426, 46);
    //    skill2.setPosition(1436, 226);
    //    skill3.setPosition(1566, 356);
    //    skill4.setPosition(1746, 366);
    //    skill5.setPosition(100, 100);
    //    skill6.setPosition(200, 200);
    //}

    //public SkillManager(Hero hero) {
    //    this.hero = hero;
    //    //skill1 = hero.getSkill1();
    //}

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void setManager(Hero hero) {
        //this.hero = hero;
    }
}