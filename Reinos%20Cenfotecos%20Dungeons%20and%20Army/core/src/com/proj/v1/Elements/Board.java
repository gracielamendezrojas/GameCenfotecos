package com.proj.v1.Elements;

import com.proj.v1.Utils.Resources;

import java.util.ArrayList;

import static com.proj.v1.PrototypePattern.APrototype.ASquare._SIZE_PREFA;

public class Board {
    private float _XPosition;
    private float _YPosition;
    private boolean _WithPrefa;
    private boolean _WithCharacter;
    private int _Id;
    private static int _Count= 0;
    public int _player;
    private ArrayList<Board> _ListBoard = new ArrayList<>();

    public Board() {
        set_WithCharacter(false);
        set_WithPrefa(false);
    }

    public Board(float _XPosition, float _YPosition) {
        this._XPosition = _XPosition;
        this._YPosition = _YPosition;
        set_WithCharacter(false);
        set_WithPrefa(false);
        set_Id();
    }

    public int get_player() {
        return _player;
    }

    public void set_player(int _player) {
        this._player = _player;
    }

    public float get_XPosition() {
        return _XPosition;
    }

    public void set_XPosition(float _XPosition) {
        this._XPosition = _XPosition;
    }

    public float get_YPosition() {
        return _YPosition;
    }

    public void set_YPosition(float _YPosition) {
        this._YPosition = _YPosition;
    }

    public boolean is_WithPrefa( ) {
         return _WithPrefa;
    }

    public void set_WithPrefa(boolean _WithPrefa) {
        this._WithPrefa = _WithPrefa;
    }

    public boolean is_WithCharacter( ) {
        return _WithCharacter;
    }

    public void set_WithCharacter(boolean _WithCharacter) {
        this._WithCharacter = _WithCharacter;
    }


    public int get_Id(){
        return _Id;
    }
    public boolean get_IsWithPrefaByCoordinates(int pX, int pY) {
        boolean boardWithPrefa = false;
        for(Board B: _ListBoard){
            if(B.get_XPosition() == pX && B.get_YPosition()== pY){
                if(B.is_WithPrefa()){
                    boardWithPrefa = true;
                }
            }
        }

        return boardWithPrefa;
    }
    public int get_PlayerByCoordinates(int pX, int pY) {
        int player = -1;
        for(Board B: _ListBoard){
            if(B.get_XPosition() == pX && B.get_YPosition()== pY){
                player = B._player;

            }
        }

        return player;
    }
    public void set_Id() {
        _Count++;
        this._Id = _Count;
    }

    public ArrayList<Board> get_ListBoard() {
        return _ListBoard;
    }

    public void set_ListBoard(ArrayList<Board> _ListBoard) {
        this._ListBoard = _ListBoard;
    }

    public void drawBoard(){
        for(int y = 0; y < 17; y++){
            for(int x = 0; x < 24; x++){
                float _X = (float) ((x * _SIZE_PREFA)+1035);
                float _Y = ((float) (770-(y * _SIZE_PREFA)));
                Board _BoardPiece = new Board(_X, _Y);
                _ListBoard.add(_BoardPiece);
            }
        }
    }

}
