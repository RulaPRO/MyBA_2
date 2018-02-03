package by.rula.actors.playscreenactors.heroes.shadow_fiend;

import com.badlogic.gdx.graphics.g2d.Batch;

import by.rula.actors.playscreenactors.heroes.ShadowFiend;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skillbuttons.SkillButtonRequiemOfSouls;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skillbuttons.SkillButtonShadowrazeFar;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skillbuttons.SkillButtonShadowrazeMedium;
import by.rula.actors.playscreenactors.heroes.shadow_fiend.skillbuttons.SkillButtonShadowrazeNear;
import by.rula.actors.playscreenactors.hud.HeroSkillManager;

/**
 * Created by Rusel on 19.09.2017.
 */

public class ShadowFiendSkillManager extends HeroSkillManager {

    private ShadowFiend hero;

    public ShadowFiendSkillManager(ShadowFiend hero) {

        //super(hero);

        skill1 = new SkillButtonShadowrazeNear(hero);
        skill1.setPosition(1426, 46);
        skill2 = new SkillButtonShadowrazeMedium(hero);
        skill2.setPosition(1436, 226);
        skill3 = new SkillButtonShadowrazeFar(hero);
        skill3.setPosition(1566, 356);
        skill4 = new SkillButtonRequiemOfSouls(hero);
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
