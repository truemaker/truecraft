package com.devquickie.minecraftclone.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.devquickie.minecraftclone.MinecraftClone;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 512;
		config.height = 384;
                config.title = "TrueCraft";
		new LwjglApplication(new MinecraftClone(), config);
	}
}
