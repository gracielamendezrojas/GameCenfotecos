package com.proj.v1.PrototypePattern.Prefas;

import com.proj.v1.PrototypePattern.APrototype.ASquare;
import com.proj.v1.PrototypePattern.Prototype.Square;

import java.util.ArrayList;

public class XPrefa{
    private Square _Square;

    public ArrayList<Square> _ListaPrefa = new ArrayList<>();


    public void drawPrefa() {
        this._Square = new Square();
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(y==1) {
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(7);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefa.add(_PrefaClon);
                }
                if((y==0 || y== 2) && x ==1){
                    Square _PrefaClon = _Square.clone();
                    _PrefaClon.setId(7);
                    _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
                    _PrefaClon.set_Y((float) (y * ASquare._SIZE_PREFA) + ASquare._PREFA_Y);
                    _ListaPrefa.add(_PrefaClon);
                }
            }
        }
    }

}

