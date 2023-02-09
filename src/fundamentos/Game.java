/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos;

import java.util.ArrayList;

/**
 *
 * @author tarde
 */
public class Game {

    public static void main(String[] args) {
        int menu_no;
        ArrayList coches = new ArrayList();
        do {
            System.out.println("********************");
            System.out.println("* 1. crear coche   *");
            System.out.println("* 2. listar coches *");
            System.out.println("* 3. salir!        *");
            System.out.println("********************");
            System.out.println("");
            System.out.println("Intruduce un opcion :");
            int meno_n = 0;
            int test = 0;
            while (test == 0) {
                try {
                    meno_n = Integer.parseInt(Leer.porTeclado());
                    if (meno_n < 4 && meno_n > 0) {
                        test = 1;
                    } else {
                        System.out.println("escribe un numero dento de 1 a 3:");
                    }
                } catch (Exception e) {
                    System.out.println("escribe un numero:");
                }

            }

            menu_no = meno_n;
            switch (meno_n) {
                case 1:
                    String preguntas[] = new String[3];
                    preguntas[0] = "Marca";
                    preguntas[1] = "Model";
                    preguntas[2] = "Motor";
                    String preguntas2[] = new String[2];
                    int motor=0;
                    int test1;
                    for (int i = 0; i < 3; i++) {

                        test1 = 0;
                        while (test1 == 0) {
                            try {
                                System.out.println(preguntas[i]);
                                if(i < 2) {
                                    preguntas2[i] = Leer.porTeclado();
                                    test1 = 1;
                                }
                                
                                if(i > 1) {
                                    motor = Integer.parseInt(Leer.porTeclado());
                                    test1 = 1;
                                }

                                
                            } catch (Exception e) {
                                System.out.println("escribe un numero");
                            }

                        }

                    }
                    coches.add(new Coche(preguntas2[0], preguntas2[1], motor));

                    break;
                case 2:
                    System.out.println("******************");
                    System.out.println("");

                    for (int i = 0; i < coches.size(); i++) {
                        Coche coche = (Coche) coches.get(i);
                        System.out.println("model:" + coche.modelo + " marca: " + coche.marca + " motor " + coche.motor);
                    }
                    System.out.println("");
                    System.out.println("******************");
                    break;

            }

        } while (menu_no != 3);

        System.out.println("has salido");

    }
}
