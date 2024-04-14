package com.proj.v1.Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.proj.v1.Utils.Resources;

public class Dices {




    public static int rollDice() {
        return MathUtils.random(1, 6);
    }


    static int resultDice = rollDice();

    public int getResultDice() {
        return resultDice;
    }

    public void setResultDice(int resultDice) {
        this.resultDice = resultDice;
    }

    public static void defineFirst() {
        int player1Roll = rollDice();
        int player2Roll = rollDice();


        if (player1Roll > player2Roll) {
            System.out.println("El jugador 1 es el primero en jugar");
        } else if (player2Roll > player1Roll) {
            System.out.println("El jugador 2 es el primero en jugar");
        } else {
            System.out.println("Empate, vuelvan a lanzar los dados");
        }
    }

   /* public String defineFirst(String Player1, String Player2) {

        int player1Roll =0;
        int player2Roll= 0;

        //while()


            if (player1Roll > player2Roll) {
                System.out.println("El jugador 2 es el primero en jugar");
                return Player1;
            } else if (player2Roll > player1Roll) {
                System.out.println("El jugador 2 es el primero en jugar");
                return Player2;
            } else {
                System.out.println("Empate, vuelvan a lanzar los dados");


        }
        return null;
    }*/

   // public int equalsComprobation (int p1, int p2)
   // {
    //    if(p1==p2){}

   // }

    public static Texture selectInvocation(){
        Image ResultImage = null;
        resultDice = rollDice();

        switch (resultDice){
            case 1:
            case 4:
                ResultImage = new Image(Resources.DADO_INFANTERIA);
                //System.out.println("Infanteria");
                break;
            case 2:
            case 5:
                ResultImage = new Image(Resources.DADO_ARTLLERA);
                //System.out.println("Arquero");
                break;
            case 3:
            case 6:
                ResultImage = new Image(Resources.DADO_TANQUE);
                //System.out.println("Tanque");
                break;
//            case 4:
//                System.out.println("Infanteria");
//                break;
//            case 5:
//                System.out.println("Arquero");
//                break;
//            case 6:
//                System.out.println("Tanque");
//                break;
        }
        return ResultImage.get_Texture();
    }

    public static Texture selectMove(){


        resultDice = rollDice();
        Image ResultImage = null;

        switch (resultDice){
            case 1:
            case 6:
                ResultImage = new Image(Resources.DADO_MOVIMIENTO);
                System.out.println("Avanzar");
                break;
            case 2:
            case 5:
                ResultImage = new Image(Resources.DADO_ATAQUE);
                System.out.println("Ataque");
                break;
            case 3:
            case 4:
                ResultImage = new Image(Resources.DADO_ATAQUE_ESPECIAL);
                System.out.println("Special");
                break;
//            case 4:
//                System.out.println("Special");
//                break;
//            case 5:
//                System.out.println("Ataque");
//                break;
//            case 6:
//                System.out.println("Avanzar");
//                break;
        }
        return ResultImage.get_Texture();
    }
}
