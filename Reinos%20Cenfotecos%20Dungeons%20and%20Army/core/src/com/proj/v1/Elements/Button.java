package com.proj.v1.Elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.proj.v1.Utils.Resources;
import com.proj.v1.screens.DefineFirstPlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.proj.v1.Utils.Resources.SKIN_PATH;

public class Button extends TextButton {
private DefineFirstPlayer defineFirst = new DefineFirstPlayer();

    //Constructors section
    public Button(float pHeight, float pWidth, int pX, int pY, String pTitle, Color pColor) {
        super(pTitle, new Skin(Gdx.files.internal("buttons/neon-ui.json")));
        setHeight(pHeight);
        setWidth(pWidth);
        setX(pX);
        setY(pY);
        setColor(pColor);
    }

    public Button(float pHeight, float pWidth, int pX, int pY, String pTitle) {
        super(pTitle, new Skin(Gdx.files.internal("buttons/neon-ui.json")));
        setHeight(pHeight);
        setWidth(pWidth);
        setX(pX);
        setY(pY);
    }
    public Button(float pHeight, float pWidth, double pPercentageX, double pPercentageY, String pTitle) {
        super(pTitle, new Skin(Gdx.files.internal("buttons/neon-ui.json")));
        setHeight(pHeight);
        setWidth(pWidth);
        setY((float) ((Resources.HEIGHT- this.getHeight())* pPercentageY));
        setX((float) ((Resources.WIDTH- this.getWidth())* pPercentageX));
    }
    public Button(float pHeight, float pWidth, double pPercentageX, double pPercentageY, String pTitle, Color pColor) {
        super(pTitle, new Skin(Gdx.files.internal("buttons/neon-ui.json")));
        setHeight(pHeight);
        setWidth(pWidth);
        setY((float) ((Resources.HEIGHT- this.getHeight())* pPercentageY));
        setX((float) ((Resources.WIDTH- this.getWidth())* pPercentageX));
        setColor(pColor);
    }

    public Button(float pHeight, float pWidth, int pX, int pY) {
        super("Ok", new Skin(Gdx.files.internal("buttons/neon-ui.json")));
        setHeight(pHeight);
        setWidth(pWidth);
        setX(pX);
        setY(pY);
    }

    public Button(float pHeight, float pWidth, int pX, int pY, Color pColor) {
        super("Ok", new Skin(Gdx.files.internal(SKIN_PATH)));
        setHeight(pHeight);
        setWidth(pWidth);
        setX(pX);
        setY(pY);
        setColor(pColor);
    }

    //This function allows to change Screen by clicking the button
    //@param: Requires a param type Screen
    //@author: Graciela Méndez
    public void changeScreen(final Screen pScreen){
        addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Resources.MAIN.setScreen(pScreen);
//                defineFirst.defineFirstPlayer();
                super.clicked(event, x, y);

            }
        });
    }
    public void receiveText(final TextInput textInput){
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!textInput.getText().equals(""))
                    System.out.println(textInput.getText());
                else
                    System.out.println("error");

                try (Connection conn = DriverManager.getConnection("jdbc:sqlite:ReinosCenfo.sqlite")) {
                    Statement stmt = conn.createStatement();
                    String query = "INSERT OR IGNORE INTO Jugadores (PlayerName) VALUES ('" + textInput.getText() + "')";
                    int rowsAffected = stmt.executeUpdate(query);
                    System.out.println("Filas afectadas: " + rowsAffected);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });

    }
    public void rollDice(String Player1name, String Player2name){

    }

    public void rollInvocation(){
        final Dices dices = new Dices();
        addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dices.selectInvocation();
                dices.selectInvocation();
            }
        });
    }

    public void rollMove(){
        final Dices dices = new Dices();
        addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dices.selectMove();
            }
        });
    }

}









