package com.proj.v1.MementoPattern;

import com.proj.v1.Elements.Board;
import com.proj.v1.FabricMethodPattern.Characters.Character;
import com.proj.v1.FabricMethodPattern.Concrete_Fabrics.Character_Fabric;

public class Memento {
    Character _Castle1;
    Character _Castle2;
    Board _NewTablero;
    String _PlayerTurn;
    boolean _BlueTurn;
    String _CurrentPlayer;

    public Memento(Character _pCastle1, Character _pCastle2, String _pPlayerTurn, boolean _pBlueTurn, String _pCurrentPlayer){
        Character_Fabric _Fabric = new Character_Fabric();
        Board _Board = new Board();
        _Castle1 = _Fabric.createCharacter(1, _pCastle1.get_X(), _pCastle1.get_Y(), "Characters/Castle.png");
        _Castle2 = _Fabric.createCharacter(1, _pCastle2.get_X(), _pCastle2.get_Y(), "Characters/Castle.png");
        _NewTablero = _Board;
        _PlayerTurn = _pPlayerTurn;
        _BlueTurn = _pBlueTurn;
        _CurrentPlayer = _pCurrentPlayer;
    }

    public Character get_Castle1(){
        return _Castle1;
    }
    public Character get_Castle2(){
        return _Castle2;
    }
    public Board get_Tablero(){
        return _NewTablero;
    }
    public String get_playerTurn(){
        return _PlayerTurn;
    }
    public boolean get_BlueTurn(){
        return _BlueTurn;
    }
    public String get_CurrentPlayer(){
        return _CurrentPlayer;
    }
}
