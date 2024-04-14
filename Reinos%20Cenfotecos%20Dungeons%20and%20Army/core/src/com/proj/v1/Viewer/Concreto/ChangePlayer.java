package com.proj.v1.Viewer.Concreto;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.proj.v1.PrototypePattern.Prefas.CPrefa;
import com.proj.v1.PrototypePattern.Prefas.LinePrefa;
import com.proj.v1.Viewer.Abstracto.IChangePlayer;
import com.proj.v1.screens.GameScreen;

import javax.sound.sampled.Line;

public class ChangePlayer implements IChangePlayer {
   private boolean change;

    public ChangePlayer(){

    }

    @Override
    public boolean turn(boolean change) {
        if(change)
            return true;
        else
            return false;
    }





}
