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
public class Factura {
    
    //Atributos
    private int numTotalLibros;
    private double valPrestamo;
    private int numBilletes;
    private double cambio;
    
    //Constructor 

    public Factura() {
    }

    public Factura(int numTotalLibros, double valPrestamo, int numBilletes, double cambio) {
        this.numTotalLibros = numTotalLibros;
        this.valPrestamo = valPrestamo;
        this.numBilletes = numBilletes;
        this.cambio = cambio;
    }
    
    //Getters-Setters

    public int getNumTotalLibros() {
        return numTotalLibros;
    }

    public void setNumTotalLibros(int numTotalLibros) {
        this.numTotalLibros = numTotalLibros;
    }

    public double getValPrestamo() {
        return valPrestamo;
    }

    public void setValPrestamo(double valPrestamo) {
        this.valPrestamo = valPrestamo;
    }

    public int getNumBilletes() {
        return numBilletes;
    }

    public void setNumBilletes(int numBilletes) {
        this.numBilletes = numBilletes;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    //Métodos
}
