package com.proj.v1.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.proj.v1.Elements.Button;
import com.proj.v1.Elements.Image;
import com.proj.v1.Utils.Render;
import com.proj.v1.Utils.Resources;


public class FirstScreen implements Screen {

    Stage _Stage;
    private Image _Background;
    private Button _PlayButton;

    public FirstScreen(){
        this._Background = new Image(Resources.FIRSTGAME_BACKGROUND);
        this._Background.setSize(Resources.HEIGHT, Resources.WIDTH);

    }
    @Override
    public void show() {

        this._Background = new Image(Resources.FIRSTGAME_BACKGROUND);
        this._Background.setSize(Resources.HEIGHT, Resources.WIDTH);
        _Stage = new Stage();

        _PlayButton = new Button(80, 400, 0.5, 0.29, "Play");
        _PlayButton.changeScreen(new PlayerNameScreen());


        _Stage.addActor(_PlayButton);
        Gdx.input.setInputProcessor(_Stage);
    }

    @Override
    public void render(float delta) {

        Render._Batch.begin();

        this._Background.draw();

        Render._Batch.end();
        _Stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
