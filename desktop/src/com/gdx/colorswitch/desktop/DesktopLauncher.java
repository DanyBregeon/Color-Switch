package com.gdx.colorswitch.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.colorswitch.ColorSwitch;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Color Switch";
		config.width = 544;
		config.height = 816;
		new LwjglApplication(new ColorSwitch(), config);
	}
}
