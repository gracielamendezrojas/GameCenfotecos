package com.proj.v1.FabricMethodPattern.AFabrics;

import com.proj.v1.FabricMethodPattern.Characters.Character;

public interface IMethod_Fabric {
    public Character createCharacter(int pId, float pX, float pY, String pSourceTexture);

}
