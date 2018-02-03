package by.rula.actors.playscreenactors.heroes.invoker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Rusel on 20.09.2017.
 */
public class InvokerSphere{

    private int currentColor;

    public static final int QUAS = 0;
    public static final int WEX = 1;
    public static final int EXORT = 2;

    private Sprite[] sprites;

    private int width;
    private int height;

    public InvokerSphere() {

        width = 32;
        height = 32;

        Texture sphereMap = new Texture(Gdx.files.internal("sphere_map.png"));
        sprites = new Sprite[3];
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Sprite(new TextureRegion(sphereMap, i * width, 0, width, height));
        }

    }

    public int getColorSphere() {
        return currentColor;
    }

    public void setColorSphere(int i) {
        currentColor = i;
    }

    public Sprite getTextureSphere(int i) {
        return sprites[i];
    }
}