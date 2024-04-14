package com.proj.v1.io;

import com.badlogic.gdx.InputProcessor;
import com.proj.v1.Utils.Resources;

public class Input implements InputProcessor {

    private boolean _Down=false, _Up=false, _Enter=false, _Clicked=false;
    private int _MouseX, _MouseY;



    public boolean isDown() {
        return _Down;
    }

    public boolean isUp() {
        return _Up;
    }

    public boolean isEnter() {
        return _Enter;
    }

    public boolean isClicked() {
        return _Clicked;
    }


    //SET&GET
    public int get_MouseX() {
        return _MouseX;
    }

    public int get_MouseY() {
        return _MouseY;
    }

    private void setMouseX(int pMouseX) {
        this._MouseX = pMouseX;
    }

    private void setMouseY(int pMouseY) {
        this._MouseY = Resources.HEIGHT - pMouseY;
    }



    //Override section
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == com.badlogic.gdx.Input.Keys.DOWN)//ver si el keycode corresponde a la tecla seleccionada
            this._Down=true;

        if (keycode == com.badlogic.gdx.Input.Keys.UP)
            this._Up=true;

        if (keycode == com.badlogic.gdx.Input.Keys.ENTER || keycode == com.badlogic.gdx.Input.Keys.NUMPAD_ENTER)
            this._Enter=true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == com.badlogic.gdx.Input.Keys.DOWN)//Que se presiona
            this._Down=false;

        if (keycode == com.badlogic.gdx.Input.Keys.UP)//Que se deja de presionar
            this._Up=false;

        if (keycode == com.badlogic.gdx.Input.Keys.ENTER || keycode == com.badlogic.gdx.Input.Keys.NUMPAD_ENTER)
            this._Enter=false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this._Clicked = true; //si presionamos la pantalla con el mouse o el dedo la variable se pone en true
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this._Clicked = false;//sino es false
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        this.setMouseX(screenX);
        this.setMouseY(screenY);

        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }


}

