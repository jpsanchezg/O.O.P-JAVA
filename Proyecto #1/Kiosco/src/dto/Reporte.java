/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Libro;
import java.util.ArrayList;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class Reporte {
    
    //Atributos
    private int valTotalPrestamos;
    private ArrayList <Venta> ventas;
    private ArrayList <Libro> librosNoVendidos = new ArrayList <Libro> ();
    
    //Constructor

    public Reporte() {
    }

    public Reporte(int valTotalPrestamos, ArrayList<Venta> ventas) {
        this.valTotalPrestamos = valTotalPrestamos;
        this.ventas = ventas;
    }
    
    //Getters-Setters

    public int getValTotalPrestamos() {
        return valTotalPrestamos;
    }

    public void setValTotalPrestamos(int valTotalPrestamos) {
        this.valTotalPrestamos = valTotalPrestamos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Libro> getLibrosNoVendidos() {
        return librosNoVendidos;
    }

    public void setLibrosNoVendidos(ArrayList<Libro> librosNoVendidos) {
        this.librosNoVendidos = librosNoVendidos;
    }
    
    //Métodos   
}
