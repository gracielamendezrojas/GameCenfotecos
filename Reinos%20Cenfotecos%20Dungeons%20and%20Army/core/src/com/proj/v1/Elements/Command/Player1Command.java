package com.proj.v1.Elements.Command;

import com.proj.v1.ProxyMethod.BaulProxy;

import java.util.Arrays;

import static com.proj.v1.ProxyMethod.BaulProxy.selectInvocation;

public class Player1Command implements Command {

    public static String[] baulTropa = new String[3];

    public static String[] baulAtaque = new String[3];

    private BaulProxy baul;
    private Command command;
    public static int cantidadInfanteria;

    public static int cantidadTanque;

    public static int cantidadArquero;

    public static int antInfanteria;

    public static int antTanque;

    public static int antNormal;

    public static boolean oneTime = true;
    public Player1Command(BaulProxy baul) {
        this.baul = baul;
    }

    public void execute(boolean baulIsOpen) {

        System.out.println("FUNCIONO");

        if (baulIsOpen) {
            System.out.println("FUNCIONO2");
            if (oneTime) {

                System.out.println("FUNCIONO3");
                selectInvocation();

                for (int i = 0; i < baul.getBaulTropa().length; i++) {
                    if (baul.getBaulTropa()[i] != null && baul.getBaulTropa()[i].equals("Infanteria")) {
                        cantidadInfanteria++;

                    }
                }
                for (int i = 0; i < baul.getBaulTropa().length; i++) {
                    if (baul.getBaulTropa()[i] != null && baul.getBaulTropa()[i].equals("Tanque")) {
                        cantidadTanque++;
                    }
                }

                for (int i = 0; i < baul.getBaulTropa().length; i++) {
                    if (baul.getBaulTropa()[i] != null && baul.getBaulTropa()[i].equals("Arquero")) {
                        cantidadArquero++;
                    }
                }


               int index = 0;

                while (index < 1) {
                    if (cantidadInfanteria > index) {
                        baulTropa[index] = "Infanteria";
                        index++;
                    } else if (cantidadTanque > index) {
                        baulTropa[index] = "Tanque";
                        index++;
                    } else if (cantidadArquero > index) {
                        baulTropa[index] = "Arquero";
                        index++;
                    } else {
                        break;
                    }


                }

            }
             oneTime=false;
        }
    }

        public static void vaciarBaulTropa() {
            Arrays.fill(baulTropa, null);
        }

        public static void vaciarBaulAtaque() {
            Arrays.fill(baulAtaque, null);
        }

    }




