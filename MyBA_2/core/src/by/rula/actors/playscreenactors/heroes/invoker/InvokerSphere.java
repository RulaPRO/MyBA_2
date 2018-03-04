package by.rula.actors.playscreenactors.heroes.invoker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Rusel on 20.09.2017.
 * Refactoring by Rusel on 03.03.2018.
 */

public class InvokerSphere{

    public static final int QUAS = 0;
    public static final int WEX = 1;
    public static final int EXORT = 2;

    private int sphereColor;

    private int width;
    private int height;

    private Sprite sphereSprite;

    public InvokerSphere(int sphereColor) {

        this.sphereColor = sphereColor;

        width = 32;
        height = 32;

        sphereSprite = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("sphere_map.png")), sphereColor * width, 0, width, height));

    }

    public int getColorSphere() {
        return sphereColor;
    }

    public Sprite getTextureSphere() {
        return sphereSprite;
    }
}