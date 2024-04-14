package com.proj.v1.MementoPattern;

public class Caretaker {
    private Memento memento;
    public void addMemento(Memento _pMemento){
        memento = _pMemento;
    }

    public Memento getMemento(){
        return this.memento;
    }
}
