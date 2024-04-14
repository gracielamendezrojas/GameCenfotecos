package com.proj.v1.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.proj.v1.Elements.Dices;

public class DiceResult extends Dialog {
    private Dialog _BotonCerrar;

    public DiceResult(String title, Skin skin) {
        super(title, skin);
        getBackground().setMinHeight(300f);
        getBackground().setMinWidth(400f);
        _BotonCerrar = button("Guardar", false);
        getContentTable().add(new Image(Dices.selectInvocation()));
        getContentTable().add(new Image(Dices.selectInvocation()));
        getContentTable().add(new Image(Dices.selectMove()));




        _BotonCerrar.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                hide(null);
            }
        });
    }

    public DiceResult(String title, Skin skin, String windowStyleName) {
        super(title, skin, windowStyleName);
    }

    public DiceResult(String title, WindowStyle windowStyle) {
        super(title, windowStyle);
    }

    @Override
    protected void result(Object object){
    }
}