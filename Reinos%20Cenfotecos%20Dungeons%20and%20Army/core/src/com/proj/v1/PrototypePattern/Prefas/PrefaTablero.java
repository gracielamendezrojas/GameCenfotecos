package com.proj.v1.PrototypePattern.Prefas;

import com.proj.v1.PrototypePattern.Prototype.Square;

import java.util.ArrayList;

public class PrefaTablero {
    ArrayList<Square> prefasTablero = new ArrayList<>();
    int actualPrefa = 0;

    public int getActualPrefa() {
        return actualPrefa;
    }

    public void setActualPrefa(int actualPrefa) {
        this.actualPrefa = actualPrefa;
    }

    public ArrayList<Square> getPrefasTablero() {
        return prefasTablero;
    }

    public void addPrefasTablero(Square prefa) {
        this.prefasTablero.add(prefa);
    }

    public int sizePrefasTablero(){
        return this.prefasTablero.size();
    }


}
