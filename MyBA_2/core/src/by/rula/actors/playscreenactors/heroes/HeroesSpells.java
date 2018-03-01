package by.rula.actors.playscreenactors.heroes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;

import by.rula.actors.playscreenactors.MapObject;

/**
 * Created by Rusel on 28.09.2017.
 */

public class HeroesSpells extends Group {

    private Array<MapObject> spells;

    public HeroesSpells() {
        super();
        spells = new Array<MapObject>();
        setName("heroesSpells");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        removeSpells();
    }

    public void addSpell(MapObject spell) {
        addActor(spell);
    }

    public void removeSpells() {
        for (Actor a : getChildren()) {
            //if (((MapObject) a).getLifeTime() <= 0f) {
            if (!((MapObject) a).isActivity()) {
                a.remove();
            }
        }
    }
}
