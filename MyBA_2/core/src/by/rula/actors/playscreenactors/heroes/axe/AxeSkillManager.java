package by.rula.actors.playscreenactors.heroes.axe;

import com.badlogic.gdx.graphics.g2d.Batch;

import by.rula.actors.playscreenactors.heroes.Axe;
import by.rula.actors.playscreenactors.heroes.axe.skillbuttons.SkillButtonBattleHunger;
import by.rula.actors.playscreenactors.heroes.axe.skillbuttons.SkillButtonBerserkersCall;
import by.rula.actors.playscreenactors.heroes.axe.skillbuttons.SkillButtonCounterHelix;
import by.rula.actors.playscreenactors.heroes.axe.skillbuttons.SkillButtonCullingBlade;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;

/**
 * Created by Rusel on 19.09.2017.
 */
public class AxeSkillManager extends HeroSkillManager {

    private Axe hero;

    public AxeSkillManager(Axe hero) {
        //super(hero);
        this.hero = hero;

        skill1 = new SkillButtonBerserkersCall(hero);
        skill1.setPosition(1426, 46);
        skill2 = new SkillButtonBattleHunger(hero);
        skill2.setPosition(1436, 226);
        skill3 = new SkillButtonCounterHelix(hero);
        skill3.setPosition(1566, 356);
        skill4 = new SkillButtonCullingBlade(hero);
        skill4.setPosition(1746, 366);

        addActor(skill1);
        addActor(skill2);
        addActor(skill3);
        addActor(skill4);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}