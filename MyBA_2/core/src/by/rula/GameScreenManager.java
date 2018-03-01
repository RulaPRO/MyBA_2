package by.rula;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Queue;

import by.rula.screens.PickHeroScreen;
import by.rula.screens.StartScreen;

public class GameScreenManager {

    MyBA game;

    private Queue<Screen> screens;

    public GameScreenManager(MyBA game) {

        this.game = game;
        screens = new Queue<Screen>();
        //add(new StartScreen(game));
        add(new PickHeroScreen(game));
        game.setScreen(getScreen());

    }

    //получает и отрисовывает скрин из вершины стека
    public void renderScreen(float dt) {
        screens.first().render(dt);
    }


    //возвращает скрин из вершины стека
    public Screen getScreen() {
        return screens.first();
    }

    //удаляет текущий скрин и помещает в вершину стека заданный в аргументе скрин
    public void set(Screen screen) {
        disposeScreen();
        add(screen);
        game.setScreen(screen);
    }

    //помещает в вершину стека заданный в аргументе скрин
    private void add(Screen screen) {
        screens.addFirst(screen);
    }

    //удаляет скрин из вершины стека
    private void disposeScreen() {
        screens.removeFirst().dispose();
    }

}
