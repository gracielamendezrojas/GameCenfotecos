package com.proj.v1.ProxyMethod;

import com.badlogic.gdx.graphics.Texture;
import com.proj.v1.Elements.Command.Command;
import com.proj.v1.Elements.Dices;
import com.proj.v1.Elements.Image;
import com.proj.v1.Utils.Resources;

import java.util.Random;

interface IDado {
    int getResultado();
}

class Dado implements IDado {
    private Random random = new Random();


    @Override
    public int getResultado() {
        return Dices.rollDice();
    }
}





public class BaulProxy implements IDado {
    private int lanzamientosRestantes = 3;

    public static Texture[] imagenBaul = new Texture[6];
    public static String[] baulTropa = new String[3];

    public static String[] baulAtaque = new String[3];

    private static int contadorAvanzar = 0;
    private static int contadorAtaque = 0;
    private static int contadorEspecial = 0;

    public static int cantidadInfanteria = 0;
    public static int cantidadArquero = 0;
    public static int cantidadTanque = 0;

    public static String[] getBaulTropa() {
        return baulTropa;
    }

    public static int getContadorAvanzar() {
        return contadorAvanzar;
    }

    public static void setContadorAvanzar(int contadorAvanzar) {
        BaulProxy.contadorAvanzar = contadorAvanzar;
    }

    public static int getContadorAtaque() {
        return contadorAtaque;
    }

    public static void setContadorAtaque(int contadorAtaque) {
        BaulProxy.contadorAtaque = contadorAtaque;
    }

    public static int getContadorEspecial() {
        return contadorEspecial;
    }

    public static void setContadorEspecial(int contadorEspecial) {
        BaulProxy.contadorEspecial = contadorEspecial;
    }

    public static int getCantidadInfanteria() {
        return cantidadInfanteria;
    }

    public static void setCantidadInfanteria(int cantidadInfanteria) {
        BaulProxy.cantidadInfanteria = cantidadInfanteria;
    }

    public static int getCantidadArquero() {
        return cantidadArquero;
    }

    public static void setCantidadArquero(int cantidadArquero) {
        BaulProxy.cantidadArquero = cantidadArquero;
    }

    public static int getCantidadTanque() {
        return cantidadTanque;
    }

    public static void setCantidadTanque(int cantidadTanque) {
        BaulProxy.cantidadTanque = cantidadTanque;
    }

    public int getResultado() {
        return Dices.rollDice();
    }

    static BaulProxy baul = new BaulProxy();

    public static Texture selectInvocation() {
        //command.execute();
        Image ResultImage = null;
        int resultDice = baul.getResultado();

        switch (Dices.rollDice()) {
            case 1:
            case 4:
                if (baulTropa[0] == null) {
                    baulTropa[0] = "Infanteria";
                    cantidadInfanteria++;
                } else if (baulTropa[1] == null) {
                    baulTropa[1] = "Infanteria";
                    cantidadInfanteria++;
                } else if (baulTropa[2] == null) {
                    baulTropa[2] = "Infanteria";
                    cantidadInfanteria++;
                } else {
                    // Todas las posiciones están ocupadas
                }
                ResultImage = new Image(Resources.DADO_INFANTERIA);
                System.out.println("Infanteria");
                break;
            case 2:
            case 5:
                if (baulTropa[0] == null) {
                    baulTropa[0] = "Arquero";
                    cantidadArquero++;
                } else if (baulTropa[1] == null) {
                    baulTropa[1] = "Arquero";
                    cantidadArquero++;
                } else if (baulTropa[2] == null) {
                    baulTropa[2] = "Arquero";
                    cantidadArquero++;
                } else {
                    // Todas las posiciones están ocupadas
                }
                ResultImage = new Image(Resources.DADO_ARTLLERA);
                System.out.println("Arquero");
                break;
            case 3:
            case 6:
                if (baulTropa[0] == null) {
                    baulTropa[0] = "Tanque";
                    cantidadTanque++;
                } else if (baulTropa[1] == null) {
                    baulTropa[1] = "Tanque";
                    cantidadTanque++;
                } else if (baulTropa[2] == null) {
                    baulTropa[2] = "Tanque";
                    cantidadTanque++;
                } else {
                    // Todas las posiciones están ocupadas
                }

                System.out.println("Tanque");
                break;
        }
        ResultImage = new Image(Resources.DADO_INFANTERIA);
        // Imprimir la cantidad de cada tipo de unidad creada
        System.out.println("Cantidad de infantería creada: " + getCantidadInfanteria());
        System.out.println("Cantidad de arqueros creados: " + cantidadArquero);
        System.out.println("Cantidad de tanques creados: " + cantidadTanque);

        return ResultImage.get_Texture();
    }


    public static Texture selectMove(){
        Image ResultImage = null;

        switch (Dices.rollDice()){
            case 1:
            case 6:
                if (baulAtaque[0] == null) {
                    baulAtaque[0] = "Avanzar";
                    contadorAvanzar++;
                } else if (baulAtaque[1] == null) {
                    baulAtaque[1] = "Avanzar";
                    contadorAvanzar++;
                } else if (baulAtaque[2] == null) {
                    baulAtaque[2] = "Avanzar";
                    contadorAvanzar++;
                }
                ResultImage = new Image(Resources.DADO_MOVIMIENTO);
                System.out.println("Avanzar");
                break;

            case 2:
            case 5:
                if (baulAtaque[0] == null) {
                    baulAtaque[0] = "Ataque";
                    contadorAtaque++;
                } else if (baulAtaque[1] == null) {
                    baulAtaque[1] = "Ataque";
                    contadorAtaque++;
                } else if (baulAtaque[2] == null) {
                    baulAtaque[2] = "Ataque";
                    contadorAtaque++;
                }
                ResultImage = new Image(Resources.DADO_ATAQUE);
                System.out.println("Ataque");
                break;

            case 3:
            case 4:
                if (baulAtaque[0] == null) {
                    baulAtaque[0] = "Special";
                    contadorEspecial++;
                } else if (baulAtaque[1] == null) {
                    baulAtaque[1] = "Special";
                    contadorEspecial++;
                } else if (baulAtaque[2] == null) {
                    baulAtaque[2] = "Special";
                    contadorEspecial++;
                }
                ResultImage = new Image(Resources.DADO_ATAQUE_ESPECIAL);
                System.out.println("Special");
                break;
        }

        // Imprimir la cantidad de cada tipo de unidad creada
        System.out.println("Cantidad de especial  creada: " + contadorEspecial);
        System.out.println("Cantidad de avanzar creados: " + contadorAvanzar);
        System.out.println("Cantidad de ataque creados: " + contadorAtaque);
        return ResultImage.get_Texture();
    }



}