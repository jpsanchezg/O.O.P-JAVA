/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entidades.Autor;
import entidades.Libro;

import java.util.ArrayList;

/**
 *
 * @author aulasingenieria
 */
public class ControllerAutor {
    ArrayList<Autor> autores = new ArrayList<> ();
    private Autor buscarAutor(String p_cedula){
        for (Autor buscar: this.autores){
            if (buscar.getCedula().equals( p_cedula)){
                return buscar;
            }
        }
        return null;
    }
   public String BuscarAutor (String p_cedula){
       for(Autor buscar: this.autores){
           if (buscar.getCedula().equals(p_cedula)){
               return buscar.getNombre();
           }
       }
       return null;
   }

    private Libro buscarLibroDeAutor(String p_cedula,String p_isbn){
        Autor  autores = buscarAutor(p_cedula);
        if(autores != null){
            for (Libro buscar: autores.getLibrosEscritos()){
                if (buscar.getIsbn().equals(p_isbn)){
                    return buscar;
                }
            }
            return null;
        }
        return null;
        
        
    }
    public boolean agregarAutor(Autor aut){
        Autor  autores = buscarAutor(aut.getCedula());
        if(autores == null){
            this.autores.add(aut);
            return true;
        }
        return false;

    }
    public boolean agregarLibroAAutor (Autor aut, Libro lib){
         Autor  autores = buscarAutor(aut.getCedula());
         for ( Libro buscar: autores.getLibrosEscritos()){
             if(buscar.getIsbn().equals( lib.getIsbn())){
                 return false;
             }
         }
         autores.getLibrosEscritos().add(lib);
         return true;
    }
    public int calcularCostoTotalLibrosPorAutor(String p_cedula){
         Autor  autores = buscarAutor(p_cedula);
         int costoporautor = 0;
           for ( Libro buscar: autores.getLibrosEscritos()){
            costoporautor = costoporautor + buscar.getCosto();
         }
         return costoporautor;

    }
    public int calcularCostoTotalLibros(){
         int costototal = 0;
           for ( Autor buscar: this.autores){
            costototal = costototal + calcularCostoTotalLibrosPorAutor(buscar.getCedula());
            
         }
         return costototal ;

    }
    
    
}
