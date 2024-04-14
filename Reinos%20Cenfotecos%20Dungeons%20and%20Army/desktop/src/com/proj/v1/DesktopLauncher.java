package com.proj.v1;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.proj.v1.Utils.Resources;

import java.io.IOException;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	public static void main (String[] arg) throws IOException {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle(Resources.APP_TITLE);
		config.setResizable(false);
		config.setWindowedMode(Resources.WIDTH,Resources.HEIGHT);
		config.setWindowIcon(Files.FileType.Internal, Resources.APP_LOGO);
		new Lwjgl3Application(Resources.MAIN, config);
	}
}
