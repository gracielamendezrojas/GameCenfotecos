package com.proj.v1.Viewer.Concreto;

import com.proj.v1.Viewer.Abstracto.IChangeTurn;

public class ChangeTurn implements IChangeTurn {
    private ChangePlayer ch = new ChangePlayer();
    private boolean change;
    @Override
    public void notifyChange() {
        ch.turn(isTurn());
    }

    public boolean isTurn() {
        return this.change;
    }

    public void setTurn(boolean turn) {
        this.change = turn;
        notifyChange();
    }

}
