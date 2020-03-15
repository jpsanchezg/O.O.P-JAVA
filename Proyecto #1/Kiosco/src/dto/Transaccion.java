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
    private int totalBilletes;
    private int totalPrestamo;
    private int saldoFaltante;
    
    //Constructor 

    public Transaccion() {
    }

    public Transaccion(int totalBilletes, int totalPrestamo, int saldoFaltante) {
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

    public int getTotalBilletes() {
        return totalBilletes;
    }

    public void setTotalBilletes(int totalBilletes) {
        this.totalBilletes = totalBilletes;
    }

    public int getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(int totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public int getSaldoFaltante() {
        return saldoFaltante;
    }

    public void setSaldoFaltante(int saldoFaltante) {
        this.saldoFaltante = saldoFaltante;
    }
    
    //Métodos
}
