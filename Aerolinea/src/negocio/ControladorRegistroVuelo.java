/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Piloto;
import entidades.Vuelo;
import java.time.LocalDate;

/**
 *
 * @author aulasingenieria
 */
public class ControladorRegistroVuelo {
    private Vuelo vuelo;

    public ControladorRegistroVuelo() {
        
    }  
    
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    
    
    public boolean crearVuelo(int num, LocalDate f){
        LocalDate hoy = LocalDate.now();
        if(f.isBefore(hoy)){
            return false;
        }else{
            this.vuelo = new Vuelo(num, f);
            return true;
        }
    }
    
    public boolean crearVuelo(Vuelo v){
        LocalDate hoy = LocalDate.now();
        if(v.getFecha().isBefore(hoy)){
            return false;
        }else{
            this.vuelo = v;
            return true;
        }
    }
    
    public Vuelo consultarVuelo(){
        return this.vuelo;
    }
    
    public boolean asignarPiloto(String nom, double sal){
        Piloto p = new Piloto(nom, sal);
        if(sal<0){
            return false;
        }else{
            this.vuelo.setPiloto(p);
            return true;
        }
    }
    
    public boolean asignarPilotoVuelo(String nom, double sal){
        return this.vuelo.asignarPiloto(nom, sal);
    }
    
    public Piloto consultarPiloto(){
        return this.vuelo.getPiloto();
    }
    
    public boolean modificarSalario(double sal){
        if(sal<0){
            return false;
        }else{
            this.vuelo.getPiloto().setSalario(sal);
            return true;
        }
    }
    
    public boolean reasignarPiloto(Piloto p){
        if(p.getNombre().isEmpty()){
            return false;
        }else{
            this.vuelo.setPiloto(p);
            return true;
        }
    }
}
