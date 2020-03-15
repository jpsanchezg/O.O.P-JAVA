/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Billete;
import java.util.ArrayList;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class Transaccion {
    
    //Atributos 
    private ArrayList <Billete> pagoBilletes = new ArrayList <Billete> ();
    private double totalBilletes;
    private double totalPrestamo;
    private double saldoFaltante;
    
    //Constructor 

    public Transaccion() {
    }

    public Transaccion(double totalBilletes, double totalPrestamo, double saldoFaltante) {
        this.totalBilletes = totalBilletes;
        this.totalPrestamo = totalPrestamo;
        this.saldoFaltante = saldoFaltante;
    }
    
    //Getters-Setters

    public ArrayList<Billete> getPagoBilletes() {
        return pagoBilletes;
    }

    public void setPagoBilletes(ArrayList<Billete> pagoBilletes) {
        this.pagoBilletes = pagoBilletes;
    }

    public double getTotalBilletes() {
        return totalBilletes;
    }

    public void setTotalBilletes(double totalBilletes) {
        this.totalBilletes = totalBilletes;
    }

    public double getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public double getSaldoFaltante() {
        return saldoFaltante;
    }

    public void setSaldoFaltante(double saldoFaltante) {
        this.saldoFaltante = saldoFaltante;
    }
    
    //Métodos
}
