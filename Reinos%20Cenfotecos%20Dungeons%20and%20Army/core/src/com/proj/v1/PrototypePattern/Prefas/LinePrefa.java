package com.proj.v1.PrototypePattern.Prefas;

import com.proj.v1.PrototypePattern.APrototype.ASquare;
import com.proj.v1.PrototypePattern.Prototype.Square;
import com.proj.v1.Viewer.Concreto.ChangePlayer;

import java.util.ArrayList;

public class LinePrefa  {
    private int _Count = 0;
    public Square _Square;
    public Square prefaLista;
    public ArrayList<Square> _ListaPrefa = new ArrayList<>();
    public ArrayList<Square> _ListaPrefaTurned = new ArrayList<>();
    private ChangePlayer CP = new ChangePlayer();
    private PrefaTablero prefaTablero = new PrefaTablero();

    public LinePrefa(){
    }

    public void drawPrefa() {
        _Count++;
        this._Square = new Square();

        for (int x = 0; x < 5; x++) {
            Square _PrefaClon = _Square.clone();
            _PrefaClon.setId(_Count);
            _PrefaClon.set_X((float) (x * ASquare._SIZE_PREFA) + ASquare._PREFA_X);
            _PrefaClon.set_Y(ASquare._PREFA_Y);
            _ListaPrefa.add(_PrefaClon);
        }
        prefaTablero.setActualPrefa(1);
    }

    public void drawPrefaTurned() {
        this._Square = new Square();

        //LinePrefa _Prefa = new LinePrefa(playerColor);

        for (int x = 5; x > 0; x--) {
            Square _PrefaClon = _Square.clone();
            _PrefaClon.setId(2);
            _PrefaClon.set_X (ASquare._PREFA_X);
            _PrefaClon.set_Y((float) (x * ASquare._SIZE_PREFA+ASquare._PREFA_Y));
            _ListaPrefaTurned.add(_PrefaClon);
        }
    }

    /*
    @Override
    public String setColor(boolean change) {
        if(change)
            return "Texture/Texture.png";
        else
            return "Texture/Azul.jpeg";
    }
     */
}

