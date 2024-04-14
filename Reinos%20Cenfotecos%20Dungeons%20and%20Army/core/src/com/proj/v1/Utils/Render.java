package com.proj.v1.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Render { //Esta clase nos va a permitir guardar ciertas cosas que vamos a utilizar
    public static SpriteBatch _Batch;//la creamos estatica para poderla llamar sin tener que instanciarla

    public static void clearScreen(){
        ScreenUtils.clear(0,0,0,1); //Nos permite que la pantalla se limpie
    }

    public static void clearScreen(float pR, float pG, float pB, float pA){ //sobrecarga
        ScreenUtils.clear(pR,pG,pB,pA); //Nos permite que la pantalla se limpie
    }

    public static void print(String pMes){
        System.out.println(pMes);
    }

    public static void close(){ //cierra la ventana
        Gdx.app.exit();
    }
}

