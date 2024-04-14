package com.proj.v1.FabricMethodPattern.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;
import java.util.Random;

public abstract class Character {
    private Texture _Texture;
    private Sprite _Sprite;
    private float _Height, _Widht;
    protected int _Id;
    //protected String _Name;
    //private int lifePoints;
    //private int attackPoints;
    //private int defensePoints;
    //private Array moves;
    //private Array specialAttack;


    //CONSTRUCTORES
    public Character() {
        set_Id();
    }
    //GET & SET
    public void set_Height(float _Height) {
        this._Height = _Height;
    }

    public float get_Widht() {
        return _Widht;
    }

    public void set_Widht(float _Widht) {
        this._Widht = _Widht;
    }

    public Texture get_Texture() {
        return _Texture;
    }
    public Sprite get_Sprite() {
        return _Sprite;
    }
    public float get_X(){
        return this.get_Sprite().getX();
    }
    public float get_Y(){
        return this.get_Sprite().getY();
    }
    public float get_Height(){
        return this.get_Sprite().getHeight();
    }
    public float get_Width(){
        return this.get_Sprite().getWidth();
    }
    public int getId() {
        return _Id;
    }
    public void set_Texture(Texture _Texture) {
        this._Texture = _Texture;
    }

    public void set_Sprite(Sprite _Sprite) {
        this._Sprite = _Sprite;
    }
    public void set_X(float pX){
        this.get_Sprite().setX(pX);
    }
    public void set_Y(float pY){
        this.get_Sprite().setY(pY);
    }
    public void set_Size( float pW,float pH){
        this.get_Sprite().setSize(pW, pH);
    }

    //Funciones públicas
    public static int getRandomPosition() {
        int _MIN = 0;
        int _MAX = 24;
        Random _Random = new Random();
        int _Result = _Random.nextInt(_MAX-_MIN) + _MIN;
        return _Result;
    }
    public void flipFlop(){
        this.get_Sprite().flip(true, false);
    }
    public void UpDown(){
        this.get_Sprite().flip(false, true);
    }
    public void draw(SpriteBatch pSB){
        this.get_Sprite().draw(pSB);
    }
    //Funciones abstractas
    protected abstract void drawCharacter(float pX, float pY, String pSourceTexture);
    protected abstract void set_Id();

    //public abstract String get_Name();
}
