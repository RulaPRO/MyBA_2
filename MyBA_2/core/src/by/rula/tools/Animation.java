package by.rula.tools;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Rusel on 31.08.2017.
 */
public class Animation {

    private Array<TextureRegion> frames; //массив текстур для анимации текущего действия

    private float maxFrameTime; //время между сменой кадров
    private float currentFrameTime; //время отображения текущего кадра

    private int frameCount; //колличество кадров анимации
    private int currentFrame; //номер текущего кадра анимации

    private int currentAction; //текущее действие

    private int frameWidth;
    private int frameHeight;

    public Animation(TextureRegion region, int frameCount, int currentAction) {
        frames = new Array<TextureRegion>();
        this.currentAction = currentAction;
        frameWidth = 256;
        frameHeight = 144;
        for(int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, this.currentAction * frameHeight, frameWidth, frameHeight));
        }
        this.frameCount = frameCount;
        maxFrameTime = 0.1f;
        currentFrame = 0;
    }

    public Animation(TextureRegion region, int frameCount, int currentAction, int frameWidth, int frameHeight) {
        frames = new Array<TextureRegion>();
        this.currentAction = currentAction;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        for(int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, this.currentAction * frameHeight, frameWidth, frameHeight));
        }
        this.frameCount = frameCount;
        maxFrameTime = 0.1f;
        currentFrame = 0;
    }

    public void update(float delta) {
        currentFrameTime += delta;
        if(currentFrameTime > maxFrameTime) {
            currentFrame++;
            currentFrameTime = 0;
        }
        if(currentFrame >= frameCount) {
            currentFrame = 0;
        }
    }

    public void setCurrentAction(int i) {
        currentAction = i;
    }

    public int getCurrentAction() {
        return currentAction;
    }

    public void setCurrentFrame(int i) {
        currentFrame = i;
    }

    public TextureRegion getFrame() {
        return frames.get(currentFrame);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public Array<TextureRegion> getFrames() {
        return frames;
    }

    public int getFrameCount() {
        return frameCount;
    }
}
