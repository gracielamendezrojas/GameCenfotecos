package com.proj.v1.PrototypePattern.Prefas;

import com.proj.v1.PrototypePattern.APrototype.ASquare;
import com.proj.v1.PrototypePattern.Prototype.Square;

import java.util.ArrayList;

public class SquadPrefa {
    private Square _Square;
    public ArrayList<Square> _ListaPrefa = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned90 = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned180 = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned270 = new ArrayList<>();

/*
    @Override
    public String setColor(boolean change) {
        return null;
    }
*/
    public void drawPrefa() {
        this._Square = new Square();

        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(y==0) {
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefa.add(_PrefaClon);
                }
                if((y==1 || y ==2) && x==0){
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefa.add(_PrefaClon);
                }
            }
        }
    }
    public void drawPrefaTurned90() {
        this._Square = new Square();

        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(y==2) {
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned90.add(_PrefaClon);
                }
                if((y==0 || y ==1) && x==0){
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned90.add(_PrefaClon);
                }
            }
        }
    }

    public void drawPrefaTurned180() {
        this._Square = new Square();
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(y==2) {
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned180.add(_PrefaClon);
                }
                if((y==1 || y ==0) && x==2){
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned180.add(_PrefaClon);
                }
            }
        }
    }

    public void drawPrefaTurned270() {
        this._Square = new Square();
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(y==0) {
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned270.add(_PrefaClon);
                }
                if((y==1 || y ==2) && x==2){
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(5);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefaTurned270.add(_PrefaClon);
                }
            }
        }
    }

}

