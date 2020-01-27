/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerprograma;

import java.util.Scanner;

/**
 *
 * @author Santiago Fernández Becerra Enero 27 2020
 */
public class MiPrimerPrograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //metodo1();
        
        tablasMultiplicar();
        
        //cicloWhile();
        
        //maxMin();
        
    }

    private static void maxMin() {
        
        int [] edades = {3, 5, 6, 7, 10};
        int max=-1, min=9999999, aux = 0;
        float prom;
        for (int i = 0; i < edades.length; i++) {
            aux=aux+edades[i];
            if(max<edades[i]){
                max=edades[i];
            }
            if(min>edades[i]){
                min=edades[i];
            }
        }
        System.out.println("Mayor "+max);
        System.out.println("Menor "+min);
        prom = (aux/edades.length);
        System.out.println("Promedio es "+prom);
    }

    private static void cicloWhile() {
        String val = "SI";
        
        Scanner in = new Scanner(System.in);
        
        while(val.equals("SI")){
            
            System.out.println(">>");

            String tec = in.nextLine();

            System.out.println("mayuscula: "+tec.toUpperCase());
            
            System.out.println("¿Desea continuar?:");
            
            val = in.nextLine();
        }
    }

    private static void tablasMultiplicar() {
        int x;
        int y;
        
        for(x=1;x<11;x++){
            System.out.println("Tabla del "+x);
            for (y = 1; y < 11; y++) {
                System.out.println(x+"x"+y+"="+(x*y));
            }
            System.out.println("--------");
        } 
    }

    private static void metodo1() {
        // TODO code application logic here
        System.out.println("Bienvenido");
        
        int x = 2;
        int y = 3;
        int suma = x + y;
        
        System.out.println("hola " + suma);
        
        x=0;
        
        if(x > 0){
            System.out.println("Division es " + (y/x));
        }
    }
    
}
