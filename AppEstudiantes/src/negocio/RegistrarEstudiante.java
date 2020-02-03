/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Estudiante;

/**
 *
 * @author Santiago Fernández Becerra 03 Feb 2020
 */
public class RegistrarEstudiante {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Estudiante estu1 = new Estudiante("Santiago", 100, 4.3);
        Estudiante estu2 = new Estudiante("Juanpa", 101, 3.1);
        Estudiante estu3 = new Estudiante("Jose", 102, 2.9);
        System.out.println("El estudiante es "+estu1.toString());
        if(estu1.actualizarPromedio(3.8)){
            System.out.println("Se pudo actualizar");
        }else{
            System.out.println("No se pudo actualizar");
        }
        System.out.println("El promedio actualizado de "+estu1.getNombre()+" es "+estu1.getPromedio());
        System.out.println("El promedio actualizado de "+estu2.getNombre()+" es "+estu2.getPromedio());
        System.out.println("El promedio actualizado de "+estu3.getNombre()+" es "+estu3.getPromedio());
        if(estu1.definirPruebaAcademica()){
            System.out.println("Está en prueba con promedio de "+estu1.getPromedio());
        }else{
            System.out.println("No está en prueba");
        }
        if(estu2.definirPruebaAcademica()){
            System.out.println("Está en prueba con promedio de "+estu2.getPromedio());
        }else{
            System.out.println("No está en prueba");
        }
        if(estu3.definirPruebaAcademica()){
            System.out.println("Está en prueba con promedio de "+estu3.getPromedio());
        }else{
            System.out.println("No está en prueba");
        }
        double max=-1, min=9999;
        double prim=estu1.getPromedio(), seg=estu2.getPromedio(), ter=estu3.getPromedio();
        if(prim>max){
            max=prim;
            if(seg>max){
                max=seg;
                if(ter>max){
                    max=ter;
                }
            }
        }
        if(prim<min){
            min=prim;
            if(seg<min){
                min=seg;
                if(ter<min){
                    min=ter;
                }
            }
        }
        if(estu1.getPromedio()==max){
            System.out.println("El mejor promedio es "+estu1.getNombre());
        }else if(estu2.getPromedio()==max){
            System.out.println("El mejor promedio es "+estu2.getNombre());
        }else if(estu3.getPromedio()==max){
            System.out.println("El mejor promedio es "+estu3.getNombre());
        }
        
        if(estu1.getPromedio()==min){
            System.out.println("El minimo promedio es "+estu1.getNombre());
        }else if(estu2.getPromedio()==min){
            System.out.println("El minimo promedio es "+estu2.getNombre());
        }else if(estu3.getPromedio()==min){
            System.out.println("El minimo promedio es "+estu3.getNombre());
        }
    }   
}
