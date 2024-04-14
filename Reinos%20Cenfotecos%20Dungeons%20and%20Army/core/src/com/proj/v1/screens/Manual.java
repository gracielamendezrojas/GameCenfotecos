package com.proj.v1.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Manual extends FirstScreen {

    private SpriteBatch batch;
    private BitmapFont font;
    private Rectangle startBtn;

    FirstScreen firstScreen = new FirstScreen() {


        public void create() {
            batch = new SpriteBatch();
            font = new BitmapFont();
            font.getData().setScale(2);
            startBtn = new Rectangle(50, 50, 100, 50);
        }


        public void render() {
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            if (Gdx.input.isTouched()) {
                int x = Gdx.input.getX();
                int y = Gdx.graphics.getHeight() - Gdx.input.getY();
                if (startBtn.contains(x, y)) {
                    // El usuario hizo clic en el botón, volver al menú principal.
                    //Se llama al metodo show para que enseñe la primera pantalla.
                    firstScreen.show();
                    dispose();
                    return;
                }
            }

            batch.begin();
            font.draw(batch, "INSTRUCCIONES DE JUEGO", Gdx.graphics.getWidth() / 2 - 200, Gdx.graphics.getHeight() - 50);
            font.draw(batch, "1. Tu objetivo es destruir la base enemiga usando tus unidades o dejar a tu oponente sin unidades", 50, Gdx.graphics.getHeight() - 100);
            font.draw(batch, "2. Cada unidad vendra con una prefa para moverse en el tablero. ", 50, Gdx.graphics.getHeight() - 150);
            font.draw(batch, "3. Dependes de los dados para invocar a tus unidades.", 50, Gdx.graphics.getHeight() - 200);
            font.draw(batch, "4. Recuerda utilizar el cofre de dados para almacenar tus tiradas", 50, Gdx.graphics.getHeight() - 250);
            font.draw(batch, "5. No puedes sobreescribir prefas ya existentes", 50, Gdx.graphics.getHeight() - 300);

            font.draw(batch, "Volver al inicio", startBtn.x + 10, startBtn.y + 30);
            batch.end();
        }

        public void dispose() {
            batch.dispose();
            font.dispose();
        }
    };
}




