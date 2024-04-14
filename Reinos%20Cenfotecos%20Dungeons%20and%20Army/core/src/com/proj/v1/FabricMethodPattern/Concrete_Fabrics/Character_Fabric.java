package com.proj.v1.FabricMethodPattern.Concrete_Fabrics;

import com.proj.v1.FabricMethodPattern.AFabrics.IMethod_Fabric;
import com.proj.v1.FabricMethodPattern.Characters.*;
import com.proj.v1.FabricMethodPattern.Characters.Character;
import com.proj.v1.FabricMethodPattern.Characters.Artillery;
import com.proj.v1.FabricMethodPattern.Characters.Infantry;
import com.proj.v1.FabricMethodPattern.Characters.Tank;

public class Character_Fabric implements IMethod_Fabric {
    @Override
    public Character createCharacter(int pId, float pX, float pY, String pSourceTexture) {
        //Castles
        if(pId == 1){
            return new Castle(pX, pY, pSourceTexture);
        }
        //Artilleria
        if(pId == 2){
            return new Artillery(pX, pY, pSourceTexture);
        }
        //Infantería
        if(pId == 3){
            return new Infantry(pX, pY, pSourceTexture);
        }
        //Tanques
        if(pId == 4){
            return new Tank(pX, pY, pSourceTexture);
        }

        return null;
    }
}
