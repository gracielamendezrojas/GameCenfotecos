package com.proj.v1.Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.proj.v1.Utils.Render;

public class Image {
    private Texture _Texture;
    private Sprite _Sprite;

    //CONSTRUCTORES
    public Image(String pSource){
        this.set_Texture(new Texture(pSource));
        this.set_Sprite(new Sprite(this.get_Texture()));
    }


    //GET & SET

    public Texture get_Texture() {
        return _Texture;
    }

    public Sprite get_Sprite() {
        return _Sprite;
    }

    public float getX(){
        return this.get_Sprite().getX();
    }

    public float getY(){
        return this.get_Sprite().getY();
    }

    public float getHeight(){
        return this.get_Sprite().getHeight();
    }

    public float getWidth(){
        return this.get_Sprite().getWidth();
    }

    public void set_Texture(Texture _Texture) {
        this._Texture = _Texture;
    }

    public void set_Sprite(Sprite _Sprite) {
        this._Sprite = _Sprite;
    }

    public void setX(float pX){
        this.get_Sprite().setX(pX);
    }

    public void setY(float pY){
        this.get_Sprite().setY(pY);
    }

    public void setSize(float pH, float pW){

        this.get_Sprite().setSize(pW,pH);
    }

    public void setCoordinates(float pX, float pY){
        this.setX(pX);
        this.setY(pY);
    }

    /*****************************************************************************
     *Function:     Set Alpha
     * Description:  Esta funcion permite ajustar la transparencia de nuestras imagenes
     * @param pAlpha [float] es el valor de la transparencia.
     *               Puede estar dentro de un rango de 0 a 1.
     * @return       N/A
     *****************************************************************************/
    public void setAlpha (float pAlpha){
        this.get_Sprite().setAlpha(pAlpha);
    }

    //PUBLIC FUNCTIONS
    public void draw(){

        this.get_Sprite().draw(Render._Batch);
    }

    public void dispose(){
        this.get_Texture().dispose();

    }

}
