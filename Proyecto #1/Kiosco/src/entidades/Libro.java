/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class Libro {
    
    //Atributos
    private String isbn;
    private int unidadesDisponibles;
    private int precio;
    private String nombre;
    //Relaciones
    private ArrayList <Libro> obsequios = new ArrayList <Libro> ();
    
    //Constructores

    public Libro() {
    }

    public Libro(String isbn, int unidadesDisponibles, int precio, String nombre) {
        this.isbn = isbn;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precio = precio;
        this.nombre = nombre;
    }
    
    //Getters-Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getObsequios() {
        return obsequios;
    }

    public void setObsequios(ArrayList<Libro> obsequios) {
        this.obsequios = obsequios;
    }
    
    //Métodos
    
    public void reducirCantidad(){
        this.unidadesDisponibles = this.unidadesDisponibles - 1;
        reducirObsequios();
    }

    public void reducirObsequios() {
        if(!this.obsequios.isEmpty()){
            for(Libro actual : this.obsequios){
                actual.unidadesDisponibles = actual.unidadesDisponibles - 1;
            }
        }
    }
    
    public int valorObsequios(){
        int cont = 0;
        for(Libro actual : this.obsequios){
            cont = cont + actual.getPrecio();
        }
        return cont;
    }
}
