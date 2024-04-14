package com.proj.v1.FlyweightPattern.ConcreteFleyweightNotShared;

import com.proj.v1.FabricMethodPattern.Characters.Character;
import com.proj.v1.FabricMethodPattern.Concrete_Fabrics.Character_Fabric;
import com.proj.v1.FlyweightPattern.FWFabric.FWFactory;
import com.proj.v1.FlyweightPattern.IFlyweight.IFlyweight;

public class CharacterWithPoints implements IFlyweight {
    public Character _VisualDataCharacter;
    public IFlyweight _IFlyweight;
    private int lifePoints;
    private int attackPoints;
    private int defensePoints;
    private static int _Count = 0;
    private static int _Id;
    private static Character_Fabric _Fabric = new Character_Fabric();


    //CONSTRUCTORES
    public CharacterWithPoints(String pSourceTexture){
        _VisualDataCharacter=_Fabric.createCharacter(setPointsByCharacter(pSourceTexture),10, 100,pSourceTexture);
        _IFlyweight = FWFactory.getCharacter(pSourceTexture);
        set_Id();
    }

    private int setPointsByCharacter(String pSourceTexture){
        int characterId = 0;
        if(pSourceTexture.contains("Artillero")){
            setLifePoints(4);
            setAttackPoints(6);
            setDefensePoints(10);
            characterId = 2;
        }
        if(pSourceTexture.contains("Infanteria")){
            setLifePoints(5);
            setAttackPoints(3);
            setDefensePoints(5);
            characterId = 3;
        }
        if(pSourceTexture.contains("Tanque")){
            setLifePoints(2);
            setAttackPoints(10);
            setDefensePoints(10);
            characterId = 4;
        }
        return characterId;
    }
    public void set_Id() {
        _Count++;
        this._Id =_Count;
    }

    public int get_Id() {
        return _Id;
    }

    public Character get_DatosExtrinsecos() {
        return _VisualDataCharacter;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public String showCharacteristics() {
        String _CharacterInfo ="";
        _CharacterInfo += "Id: " + this.get_Id();
        //_CharacterInfo += _VisualDataCharacter.get_Name();
        _CharacterInfo += "\nPuntos de defensa: "+ this.getDefensePoints();
        _CharacterInfo += "\nPuntos de ataque: "+ this.getAttackPoints();
        _CharacterInfo += "\nCantidad de vidas: "+ this.getLifePoints();

        return  _CharacterInfo;
    }

}




