package com.proj.v1.FlyweightPattern.ConcreteFlyweight;

import com.proj.v1.FlyweightPattern.IFlyweight.IFlyweight;

public class ArtilleryMeta implements IFlyweight {
    private  float _HEIGHT = 20;
    private  float _WIDHT = 20;
    private  String _Name;
    private  String _Description;

    //CONSTRUCTORES
    public ArtilleryMeta(){
        set_WIDHT(20);
        set_HEIGHT(20);
        set_Description("Artillery Troop starts with 4 life points, 6 attack points and 10 defense points");
        set_Name( "Artillery Troop");
    }

    public void set_HEIGHT(float _HEIGHT) {
        this._HEIGHT = _HEIGHT;
    }

    public void set_WIDHT(float _WIDHT) {
        this._WIDHT = _WIDHT;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public void set_Description(String _Description) {
        this._Description = _Description;
    }


    public float get_HEIGHT() {
        return _HEIGHT;
    }

    public float get_WIDHT() {
        return _WIDHT;
    }

    public String get_Name() {
        return _Name;
    }

    public String get_Description() {
        return _Description;
    }

    @Override
    public String showCharacteristics() {
        String _CharacterInfo ="";
        _CharacterInfo += "\n" + _Name;
        _CharacterInfo += "\n"+ _Description;

        return  _CharacterInfo;
    }
}
