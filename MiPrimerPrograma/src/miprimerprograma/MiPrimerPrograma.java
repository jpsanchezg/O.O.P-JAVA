/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerprograma;

import java.util.Scanner;

/**
 *
 * @author juan pablo sanchez gaitan
 * 27 de enero del 2020
 */
public class MiPrimerPrograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // bienvenida();
        tablasdemultiplicar();
        /*miteclado();

        mipromedio();*/

    }

    private static void mipromedio() {
        int[] edades = {3, 5, 6, 7, 10};
        float promedio;
        int maxi = -1;
        int mini = 9999;
        int aux = 0;
        int tam = 0;
        for (int i = 0; i < edades.length; i++) {
            aux = aux + edades[i];
            if (mini > edades[i]) {
                mini = edades[i];
            }
            if (maxi < edades[i]) {
                maxi = edades[i];
            }

            tam++;
        }
        promedio = aux / tam;

        System.out.println("el promedio es: " + promedio);
        System.out.println("el minimo es : " + mini);
        System.out.println("el maximo es:" + maxi);
    }

    private static void miteclado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("teclea algo loca:");
        String loca = sc.nextLine();
        System.out.println("Mi " + loca.toUpperCase());
        boolean sigue = true;
        while (sigue) {

            System.out.println("desea continuar?");
            String continuar = sc.nextLine();
            if (continuar.equals("si")) {

                String pendejo = sc.nextLine();
                System.out.println("Mi " + pendejo.toUpperCase());
            }
            if (continuar.equals("no")) {

                sigue = false;
            }
        }
    }

    private static void tablasdemultiplicar() {
        int multi;
        for (int x = 1; x < 10; x++) {
            System.out.println("La tabla del " + x);
            for (int j = 1; j < 11; j++) {

                multi = x * j;
                System.out.println("la multiplicacion :" + multi);
            }
            System.out.println("---------------------");

        }
    }

    private static void bienvenida() {
        // TODO code application logic here
        int x = 2, y = 3;
        int suma;
        suma = x + y;
        System.out.println("bienvenido la suma es esta " + suma);
        x = 0;
        if (x > 0) {

            System.out.println("la division es:" + (y / x));
        }
    }

}
