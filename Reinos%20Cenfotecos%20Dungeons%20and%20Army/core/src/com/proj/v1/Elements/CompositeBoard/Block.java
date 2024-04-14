package com.proj.v1.Elements.CompositeBoard;

public class Block implements Component {
    private char blockSymbol;

    public Block(char blockSymbol) {
        this.blockSymbol = blockSymbol;
    }

    @Override
    public void render() {
        System.out.print(blockSymbol);
    }
}
