package com.proj.v1.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.proj.v1.Elements.Button;
import com.proj.v1.Elements.Image;

import com.proj.v1.Elements.TextInput;
import com.proj.v1.Utils.Render;
import com.proj.v1.Utils.Resources;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.proj.v1.Utils.Resources.PLAYERNAMES_BACKGROUND;
import static com.proj.v1.Utils.Resources.SKIN_PATH;


public class PlayerNameScreen extends SQLException implements Screen {



    SpriteBatch batch = new SpriteBatch();
    private Image Background;



    Stage _Stage = new Stage();
    Button _ContinueButton;
    Button _CancelButton;

    private TextInput txtPlayer1;
    private TextInput txtPlayer2;
    //private DefineFirstPlayer defineFirst = new DefineFirstPlayer();
    Skin skin;

    @Override
    public void show() {
        skin = new Skin(Gdx.files.internal(SKIN_PATH));
        this.Background = new Image(PLAYERNAMES_BACKGROUND);
        this.Background.setSize(Resources.HEIGHT,Resources.WIDTH);
        Gdx.input.setInputProcessor(_Stage);


        txtPlayer1 = new TextInput("Player 1", skin,80,200, 0.72, 0.60,5);
        txtPlayer2 = new TextInput("Player 2", skin,80,200, 0.72, 0.39,5);


        _ContinueButton = new Button(80, 200, 0.14, 0.235, "Continuar", Color.GREEN);
        _ContinueButton.receiveText(txtPlayer1);
        _ContinueButton.receiveText(txtPlayer2);
        //Josue Artavia
        _ContinueButton.rollDice(txtPlayer1.getText(),txtPlayer2.getText());

        //Jartavia
//        _ContinueButton.changeScreen(new GameScreen());
        _ContinueButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Resources.MAIN.setScreen(new GameScreen(txtPlayer1.getText(), txtPlayer2.getText()));
//                defineFirst.defineFirstPlayer();
            }
        });
        _Stage.addActor(_ContinueButton);


        _CancelButton = new Button(80, 200, 0.33, 0.235, "Cancelar");
        _CancelButton.changeScreen(new FirstScreen());
        _Stage.addActor(_CancelButton);
        _Stage.addActor(txtPlayer1);
        _Stage.addActor(txtPlayer2);



    }

    @Override
    public void render(float pDelta) {
        Gdx.gl.glClearColor(1f,1f,1f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(pDelta);
        Render._Batch.begin();
        this.Background.draw();
        Render._Batch.end();
        _Stage.draw();
    }

    @Override
    public void resize(int pWidth, int pHeight) {

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


    private void update(float pDelta){
        _Stage.act(pDelta);
    }

    public TextInput getTxtPlayer1() {
        return txtPlayer1;
    }

    public TextInput getTxtPlayer2() {
        return txtPlayer2;
    }
}
