package com.proj.v1.FabricMethodPattern.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.proj.v1.FabricMethodPattern.Characters.Character;
import com.proj.v1.FlyweightPattern.IFlyweight.IFlyweight;

public class Infantry extends Character implements IFlyweight {
    private static int _Count = 0;
    private static float _HEIGHT = 20;
    private static float _WIDHT = 20;


    //CONSTRUCTORES
    public Infantry(String pSourceTexture, int pId){
        drawCharacter(90, 245, pSourceTexture);
    }

    public Infantry(float pX, float pY, String pSourceTexture){
        drawCharacter(pX, pY, pSourceTexture);
    }
    protected void set_Id() {
        _Count++;
        this._Id =_Count;
    }
    @Override
    protected void drawCharacter (float pX, float pY, String pSourceTexture) {
        this.set_Texture(new Texture(pSourceTexture));
        this.set_Sprite(new Sprite(this.get_Texture()));
        this.set_X(pX);
        this.set_Y(pY);
        this.set_Size(_WIDHT, _HEIGHT);
        set_Id();

    }

    @Override
    public String showCharacteristics() {
        String _CharacterInfo ="";
        _CharacterInfo += "\nInfantero " + this.getId();
        return  _CharacterInfo;
    }

}
