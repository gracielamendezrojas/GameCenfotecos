package com.proj.v1.FlyweightPattern.FWFabric;

import com.proj.v1.FlyweightPattern.ConcreteFlyweight.ArtilleryMeta;
import com.proj.v1.FlyweightPattern.ConcreteFlyweight.InfantryMeta;
import com.proj.v1.FlyweightPattern.ConcreteFlyweight.TankMeta;
import com.proj.v1.FlyweightPattern.IFlyweight.IFlyweight;

import java.util.HashMap;
import java.util.Map;

public class FWFactory {
    private static Map<String, IFlyweight> _ICharactersList = new HashMap<>();
    public static IFlyweight getCharacter(String pSourceTexture){
        IFlyweight _IFLyCharacter = null;

        String _Key = pSourceTexture;
        if(_ICharactersList.containsKey(_Key)){
            _IFLyCharacter =  _ICharactersList.get(_Key);
        }else{
            if(pSourceTexture.contains("Artillero")){
                _IFLyCharacter=  new ArtilleryMeta();
            }
            if(pSourceTexture.contains("Infanteria")){
                _IFLyCharacter=  new InfantryMeta();
            }
            if(pSourceTexture.contains("Tanque")){
                _IFLyCharacter=  new TankMeta();
            }
            _ICharactersList.put(_Key,_IFLyCharacter);
        }
        return _IFLyCharacter;
    }

}
