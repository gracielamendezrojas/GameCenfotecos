package com.proj.v1.Utils;

import com.badlogic.gdx.Game;
import com.proj.v1.StartGame;

public class Resources{
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final String APP_LOGO = "icons/window-icon.png";
    public static final String APP_TITLE = "Prueba";
    public static final Game MAIN = new StartGame();

    //BACKGROUNDS
    public static final String FIRSTGAME_BACKGROUND="Backgrounds/firstGame_background.jpeg";
    public static final String PLAYERNAMES_BACKGROUND="Backgrounds/playersNames_background.png";
    public static final String GAME_BACKGROUND="Backgrounds/GameBoard-01.png";

    //SKINS
    public static final String SKIN_PATH = "buttons/neon-ui.json";

    //FONTS
    public static final String MENU_FONT="fonts/absoluteEmpire.otf";
    public static final String TIMER_FONT = "Fonts/good timing bd.otf";

    //DICES
    public static final String DADO_ARTLLERA = "Dices/Artilleria.png";
    public static final String DADO_INFANTERIA = "Dices/Infanteria.png";
    public static final String DADO_TANQUE = "Dices/Tanque.png";
    public static final String DADO_MOVIMIENTO = "Dices/Movimiento.png";
    public static final String DADO_ATAQUE = "Dices/Ataque.png";
    public static final String DADO_ATAQUE_ESPECIAL = "Dices/AtaqueEspecial.png";

}
