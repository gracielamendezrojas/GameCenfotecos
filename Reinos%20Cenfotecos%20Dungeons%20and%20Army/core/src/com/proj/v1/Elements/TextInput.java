package com.proj.v1.Elements;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.proj.v1.Utils.Resources;

public class TextInput extends TextField{
    public TextInput(String text, Skin skin, float h, float w, float x, float y, int alignment) {
        super(text, skin);
        setSize(h,w);
        setPosition(x,y);
        setAlignment(alignment);
    }


    public TextInput(String text, Skin skin, float pHeight, float pWidth, double pPercentageX, double pPercentageY, int alignment) {
        super(text, skin);
        setHeight(pHeight);
        setWidth(pWidth);
        float x = (float) ((Resources.WIDTH- this.getWidth()) * pPercentageX);
        float y = (float) ((Resources.HEIGHT- this.getHeight()) * pPercentageY);
        setPosition(x,y);
        setAlignment(alignment);
    }

    public TextInput(String text, Skin skin, String styleName) {
        super(text, skin, styleName);
    }

    public TextInput(String text, TextFieldStyle style) {
        super(text, style);
    }



}
