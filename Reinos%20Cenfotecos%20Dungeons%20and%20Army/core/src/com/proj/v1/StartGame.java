package com.proj.v1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.proj.v1.Elements.Image;
import com.proj.v1.screens.DefineFirstPlayer;
import com.proj.v1.screens.FirstScreen;
import com.proj.v1.Utils.Render;
import com.proj.v1.Utils.Resources;
import com.proj.v1.screens.GameScreen;
import com.proj.v1.screens.PlayerNameScreen;

public class StartGame extends Game {

	private Image _Background;

	@Override
	public void create () {
		Render._Batch = new SpriteBatch();

		Resources.MAIN.setScreen(new FirstScreen());
	}

}
