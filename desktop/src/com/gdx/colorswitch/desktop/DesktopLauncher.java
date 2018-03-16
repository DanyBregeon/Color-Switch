package com.gdx.colorswitch.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.colorswitch.ColorSwitch;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		if(LwjglApplicationConfiguration.getDesktopDisplayMode().height > 850) {
			config.height = 816;
			config.width = 544;
		}else {
			config.height = (int) (LwjglApplicationConfiguration.getDesktopDisplayMode().height*(5/6f));
			config.width = (int) (config.height*(2f/3f));
		}
		config.title = "Color Switch";
		//config.width = 544;//272;//544
		//config.height = 816;//408;//816
		//config.fullscreen = true;
		config.resizable = false;
		//config.addIcon(path, fileType);
		config.vSyncEnabled = true;
		new LwjglApplication(new ColorSwitch(), config);
	}
}
