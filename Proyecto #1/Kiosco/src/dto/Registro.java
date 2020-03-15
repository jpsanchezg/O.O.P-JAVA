/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class Registro {
    
    //Atributos 
    private int librosDelPrestamo;
    private int librosObsequio;
    private int acumulado;    
    
    //Constructor 

    public Registro() {
    }

    public Registro(int librosDelPrestamo, int librosObsequio, int acumulado) {
        this.librosDelPrestamo = librosDelPrestamo;
        this.librosObsequio = librosObsequio;
        this.acumulado = acumulado;
    }
    
    //Getters-Setters

    public int getLibrosDelPrestamo() {
        return librosDelPrestamo;
    }

    public void setLibrosDelPrestamo(int librosDelPrestamo) {
        this.librosDelPrestamo = librosDelPrestamo;
    }

    public int getLibrosObsequio() {
        return librosObsequio;
    }

    public void setLibrosObsequio(int librosObsequio) {
        this.librosObsequio = librosObsequio;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }
    
    //Métodos
}
