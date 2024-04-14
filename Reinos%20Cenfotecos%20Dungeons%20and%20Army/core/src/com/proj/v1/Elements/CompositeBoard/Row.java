package com.proj.v1.Elements.CompositeBoard;

import java.util.ArrayList;
import java.util.List;

public class Row implements Component {
    private List<Component> blocks;

    public Row() {
        blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public void render() {
        for (Component block : blocks) {
            block.render();
        }
        System.out.println();
    }
}
