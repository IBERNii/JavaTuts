package com.berni.mario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.berni.mario.MarioBros;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = MarioBros.V_HEIGHT * 2;
		config.width = MarioBros.V_WIDTH * 2;
		new LwjglApplication(new MarioBros(), config);
	}
}
