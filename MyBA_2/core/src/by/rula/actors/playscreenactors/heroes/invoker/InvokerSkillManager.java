package by.rula.actors.playscreenactors.heroes.invoker;

import com.badlogic.gdx.graphics.g2d.Batch;

import by.rula.actors.playscreenactors.heroes.Invoker;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 19.09.2017.
 */
public class InvokerSkillManager extends HeroSkillManager {

    private Invoker hero;

    private SkillButton skill5;
    private SkillButton skill6;

    public InvokerSkillManager(Invoker hero) {
        //super();
        this.hero = hero;

        skill1 = new by.rula.actors.playscreenactors.heroes.invoker.skillbuttons.SkillButtonQuas(hero);
        skill1.setPosition(1426, 46);
        skill2 = new by.rula.actors.playscreenactors.heroes.invoker.skillbuttons.SkillButtonWex(hero);
        skill2.setPosition(1436, 226);
        skill3 = new by.rula.actors.playscreenactors.heroes.invoker.skillbuttons.SkillButtonExort(hero);
        skill3.setPosition(1566, 356);
        skill4 = new by.rula.actors.playscreenactors.heroes.invoker.skillbuttons.SkillButtonInvoke(hero);
        skill4.setPosition(1746, 366);


        addActor(skill1);
        addActor(skill2);
        addActor(skill3);
        addActor(skill4);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (hero.getSkills().size > 0) {
            skill5 = hero.getSkills().get(0);
            skill5.setPosition(1246, 46);
            addActor(skill5);
        }
        if (hero.getSkills().size > 1) {
            //skill5 = hero.getSkills().get(0);
            skill5.setPosition(1256, 226);

            skill6 = hero.getSkills().get(1);
            skill6.setPosition(1246, 46);
            addActor(skill6);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
