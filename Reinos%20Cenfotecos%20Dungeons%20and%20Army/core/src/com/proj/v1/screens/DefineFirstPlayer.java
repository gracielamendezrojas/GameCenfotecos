package com.proj.v1.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.proj.v1.Elements.Button;
import com.proj.v1.Elements.Image;
import com.proj.v1.Utils.Render;
import com.proj.v1.Utils.Resources;

import static com.proj.v1.Utils.Resources.SKIN_PATH;

public class DefineFirstPlayer implements Screen {
    Stage _Stage = new Stage();
    private Image _Background;
    private Button _HomeButton;
    private Button _StartGame;
    Skin skin;
    public static int rndNumber() {
        return MathUtils.random(0, 3);
    }

    @Override
    public void show() {
        skin = new Skin(Gdx.files.internal(SKIN_PATH));
        this._Background = new Image(Resources.GAME_BACKGROUND);
        this._Background.setSize(Resources.HEIGHT, Resources.WIDTH);
        Gdx.input.setInputProcessor(_Stage);

        _HomeButton = new Button(80, 100, 0.005, 0.99, "Home");
        _HomeButton.changeScreen(new FirstScreen());
        _Stage.addActor(_HomeButton);

        _StartGame = new Button(80, 400, 0.18, 0.2, "Iniciar partida");
        _StartGame.changeScreen(new GameScreen());
        _Stage.addActor(_StartGame);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    public int defineFirstPlayer(){
        String[] players = {"x","y"};
        int randNum = (int) Math.round(Math.random());
        String player1 = players[randNum];
        String player2 = players[(randNum+1)%2];
        if(player1.equals("x")){
            return 1;
        }else{
            return 0;
        }
    }


}
