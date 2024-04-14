package com.proj.v1.PrototypePattern.APrototype;

import com.proj.v1.Color.IColor;

public abstract class ASquare implements IColor {
    protected float _X = 0;
    protected float _Y = 0;
    public static final int _WIDTH = 30;
    public static final int _HEIGHT = 30;
    private boolean _WithCharacter;
    public static final int _PREFA_X =1385;
    public static final int _PREFA_Y = 15;
    protected int _Id;
    public static final double _SIZE_PREFA = 30;

    //Constructor
    public ASquare(float _XPosition, float _YPosition) {
        this._X = _XPosition;
        this._Y =  _YPosition;
        set_WithCharacter(false);
    }

    //gets y sets
    public boolean is_WithCharacter() {
        return _WithCharacter;
    }

    public void set_WithCharacter(boolean _WithCharacter) {
        this._WithCharacter = _WithCharacter;
    }

    public float get_X() {
        return _X;
    }

    public void set_X(float _X) {
        this._X = _X;
    }

    public float get_Y() {
        return _Y;
    }

    public void set_Y(float _Y) {
        this._Y = _Y;
    }

    //clases abstractas
    protected abstract ASquare clone();
    public abstract void setId(int pId);


    public abstract String setColor(boolean change);
}
