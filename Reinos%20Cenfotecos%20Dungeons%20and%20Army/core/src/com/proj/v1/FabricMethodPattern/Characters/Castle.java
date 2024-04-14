package com.proj.v1.FabricMethodPattern.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.proj.v1.PrototypePattern.APrototype.ASquare._SIZE_PREFA;

public class Castle extends Character {

    private static int _Count = 0;
    private static float _HEIGHT = (float) _SIZE_PREFA;
    private static float _WIDHT = (float) _SIZE_PREFA;


    //CONSTRUCTORES
    public Castle(String pSourceTexture, int pId){
        drawCharacter(338, 799, pSourceTexture);

    }

    public Castle(float pX, float pY, String pSourceTexture){
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


}
