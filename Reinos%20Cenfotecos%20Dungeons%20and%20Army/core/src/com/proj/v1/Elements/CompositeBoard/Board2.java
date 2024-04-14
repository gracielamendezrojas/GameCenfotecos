package com.proj.v1.Elements.CompositeBoard;

import java.util.ArrayList;
import java.util.List;

public class Board2 implements Component {
    private List<Component> rows;

    public Board2() {
        rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    @Override

    //Renderizamos el tablero
    public void render() {
        for (Component row : rows) {
            row.render();
        }
    }
}
