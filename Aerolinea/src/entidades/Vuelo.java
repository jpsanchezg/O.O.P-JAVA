/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author aulasingenieria
 */
public class Vuelo {
    private int numero;
    private LocalDate fecha;
    private Piloto piloto;

    public Vuelo(int numero, LocalDate fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }

    public Vuelo() {
    }
    
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public boolean asignarPiloto(String nom, double sal) {
        Piloto p = new Piloto(nom, sal);
        if(sal<0){
            return false;
        }else{
            this.piloto=p;
            return true;
        }
    }
    
    
}
