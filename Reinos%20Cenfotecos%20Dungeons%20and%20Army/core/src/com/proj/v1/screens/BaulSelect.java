package com.proj.v1.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.proj.v1.Elements.Command.Command;
import com.proj.v1.Elements.Command.Player1Command;
import com.proj.v1.Elements.Command.Player2Command;
import com.proj.v1.Elements.Dices;
import com.proj.v1.ProxyMethod.BaulProxy;
import com.proj.v1.Utils.Resources;

public class BaulSelect extends Dialog {
    private Dialog _BotonCerrar;

    BaulProxy baulProxy = new BaulProxy();

    BaulProxy baulJugador1 = new BaulProxy();
    Command commandJugador1 = new Player1Command(baulJugador1);

    BaulProxy baulJugador2 = new BaulProxy();
    Command commandJugador2 = new Player2Command(baulJugador2);

    public BaulSelect(String title, Skin skin) {
        super(title, skin);
        getBackground().setMinHeight(300f);
        getBackground().setMinWidth(400f);
        _BotonCerrar = button("Guardar", false);


            _BotonCerrar.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    hide(null);
                }
            });


            _BotonCerrar.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    hide(null);
                }
            });
        }


        public void baulLlenarPlayer1() {

            for (int i = 0; i < Player1Command.baulTropa.length; i++) {
                String unidad = Player1Command.baulTropa[i];

                // Verifica si unidad es nulo antes de compararlo
                if (unidad != null) {
                    Texture textureInfanteria = new Texture(Resources.DADO_INFANTERIA);
                    Texture textureTanque = new Texture(Resources.DADO_TANQUE);
                    Texture textureArtilleria = new Texture(Resources.DADO_ARTLLERA);

                    if (unidad.equals("Infanteria")) {
                        getContentTable().add(new Image(textureInfanteria));
                    } else if (unidad.equals("Tanque")) {
                        getContentTable().add(new Image(textureTanque));
                    } else if (unidad.equals("Artilleria")) {
                        getContentTable().add(new Image(textureArtilleria));
                    }
                }
            }

        }

            public void baulLlenarPlayer2() {

                for (int i = 0; i < Player2Command.baulTropa.length; i++) {
                    String unidad = Player2Command.baulTropa[i];

                    // Verifica si unidad es nulo antes de compararlo
                    if (unidad != null) {
                        Texture textureInfanteria = new Texture(Resources.DADO_INFANTERIA);
                        Texture textureTanque = new Texture(Resources.DADO_TANQUE);
                        Texture textureArtilleria = new Texture(Resources.DADO_ARTLLERA);

                        if (unidad.equals("Infanteria")) {
                            getContentTable().add(new Image(textureInfanteria));
                        } else if (unidad.equals("Tanque")) {
                            getContentTable().add(new Image(textureTanque));
                        } else if (unidad.equals("Artilleria")) {
                            getContentTable().add(new Image(textureArtilleria));
                        }
                    }
                }

        }


    public BaulSelect(String title, Skin skin, String windowStyleName) {
        super(title, skin, windowStyleName);
    }

    public BaulSelect(String title, WindowStyle windowStyle) {
        super(title, windowStyle);
    }

    @Override
    protected void result(Object object){
    }
}