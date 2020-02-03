/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author aulasingenieria
 */
public class Estudiante {
    
    private String nombre;
    private int numero;
    private double promedio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Estudiante() {
    }

    public Estudiante(String nombre, int numero, double promedio) {
        this.nombre = nombre;
        this.numero = numero;
        this.promedio = promedio;
    }
    
    public boolean actualizarPromedio(double act){
        boolean res =true;
        if(act>0.0 && act<5.0){
            this.promedio=(this.promedio+act)/2;
        }else{
            res = false;
        }
        return res;
    }
    
    public boolean definirPruebaAcademica(){
        boolean res=true;
        if(this.promedio<=3.2){
        }else{
            res=false;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", numero=" + numero + ", promedio=" + promedio + '}';
    }
    
    
}
