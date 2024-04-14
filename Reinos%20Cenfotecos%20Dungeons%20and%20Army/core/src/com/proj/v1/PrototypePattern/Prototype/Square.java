package com.proj.v1.PrototypePattern.Prototype;

import com.proj.v1.PrototypePattern.APrototype.ASquare;

import java.util.ArrayList;

public class Square extends ASquare {
    public ArrayList<Square> _ListaPrefa = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned90 = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned180 = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned270 = new ArrayList<>();



    public Square() {
        super(100, 100);
    }

    public Square(float _XPosition, float _YPosition) {
        super(_XPosition, _YPosition);
    }

    public Square clone(){
        return new Square();
    }


    @Override
    public void setId(int pId) {
        this._Id = pId;
    }

    @Override
    public String setColor(boolean change) {
        return null;
    }
}
