/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entidades.Libro;
import java.util.ArrayList;

/**
 *
 * @author aulasingenieria
 */
public class ControllerLibro {
    private ArrayList<Libro> libros = new ArrayList<> ();
    private Libro buscarLibro(String isbn) {
        for (Libro buscar: this.libros){
            if(buscar.getIsbn().equals(isbn)){
                return buscar;
            }
        }
        return null;
    }
    
    public void agregarLibro(Libro lib){
        Libro libros = buscarLibro(lib.getIsbn());
        if(libros != null){
            this.libros.add(lib);
        }
    }
   /** public boolean agregarLibro(Libro lib, Autor aut){
        
    }
    public void asignarAutorALibro(Libro lib,Autor a){
        
    }
    public int calcularCostoTotalLibros(){
        
    }**/
}
