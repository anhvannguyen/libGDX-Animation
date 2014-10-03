package me.anhvannguyen.animationtest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.anhvannguyen.animationtest.Main;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Animation Test";
		config.width = 800;
		config.height = 480;
		config.resizable = false;
		new LwjglApplication(new Main(), config);
	}
}
