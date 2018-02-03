package by.rula.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import by.rula.MyBA;

import static by.rula.MyBA.V_HEIGHT;
import static by.rula.MyBA.V_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "MyBA";
		config.width = V_WIDTH;
		config.height = V_HEIGHT;
		new LwjglApplication(new MyBA(), config);
	}
}
