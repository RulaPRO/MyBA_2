package by.rula.actors.playscreenactors.heroes.invoker.skillbuttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import by.rula.actors.playscreenactors.heroes.Invoker;
import by.rula.actors.playscreenactors.hud.SkillButton;

/**
 * Created by Rusel on 19.09.2017.
 */
public class SkillButtonInvoke extends SkillButton {

    private Invoker invoker;
    //private Array<SkillButton> skills;
    //private Array<InvokerSphere> spheres;

    private Sprite icon;

    public SkillButtonInvoke(Invoker hero) {
        super(hero);
        invoker = hero;
        //skills = invoker.getSkills();
        //spheres = new Array<InvokerSphere>();
        //spheres = invoker.getSpheres();
        icon = new Sprite(new TextureRegion(iconMap), 192, 0, 64, 64);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Im INVOKE");
                createSkill();
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(icon, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {

    }

    private void createSkill() {

        if(invoker.getSpheres().size == 3) {

            System.out.println("CreateSPELL(index " + spheresCombination() + ")");

            switch (spheresCombination()) {
                case 0:
                    System.out.println("Create QQQ");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton qqq = new SkillButtonQQQ(invoker);
                    invoker.getSkills().add(qqq);
                    break;
                case 1:
                    System.out.println("Create QQW");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton qqw = new SkillButtonQQW(invoker);
                    invoker.getSkills().add(qqw);
                    break;
                case 4:
                    System.out.println("Create QQE");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton qqe = new SkillButtonQQE(invoker);
                    invoker.getSkills().add(qqe);
                    break;
                case 2:
                    System.out.println("Create WWQ");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton wwq = new SkillButtonWWQ(invoker);
                    invoker.getSkills().add(wwq);
                    break;
                case 3:
                    System.out.println("Create WWW");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton www = new SkillButtonWWW(invoker);
                    invoker.getSkills().add(www);
                    break;
                case 6:
                    System.out.println("Create WWE");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton wwe = new SkillButtonWWE(invoker);
                    invoker.getSkills().add(wwe);
                    break;
                case 8:
                    System.out.println("Create EEQ");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton eeq = new SkillButtonEEQ(invoker);
                    invoker.getSkills().add(eeq);
                    break;
                case 9:
                    System.out.println("Create EEW");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton eew = new SkillButtonEEW(invoker);
                    invoker.getSkills().add(eew);
                    break;
                case 12:
                    System.out.println("Create EEE");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton eee = new SkillButtonEEE(invoker);
                    invoker.getSkills().add(eee);
                    break;
                case 5:
                    System.out.println("Create QWE");
                    if(invoker.getSkills().size == 2) {
                        invoker.getSkills().removeIndex(0);
                    }
                    SkillButton qwe = new SkillButtonQWE(invoker);
                    invoker.getSkills().add(qwe);
                    break;
            }

        } else {
            System.out.println("Cant Create SPELL");
        }
    }

    private int spheresCombination() {

        int summ = 0;
        int colorSphere0 = invoker.getSpheres().get(0).getColorSphere();
        int colorSphere1 = invoker.getSpheres().get(1).getColorSphere();
        int colorSphere2 = invoker.getSpheres().get(2).getColorSphere();

        if(colorSphere0 == 1) {
            summ += 1;
        } else if(colorSphere0 == 2) {
            summ += 4;
        }

        if(colorSphere1 == 1) {
            summ += 1;
        } else if(colorSphere1 == 2) {
            summ += 4;
        }

        if(colorSphere2 == 1) {
            summ += 1;
        } else if(colorSphere2 == 2) {
            summ += 4;
        }

        return summ;
    }
}
