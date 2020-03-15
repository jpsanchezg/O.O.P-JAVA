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
public class Venta {
    
    //Atributos
    private String nomLibro;
    private int cantLibro;
    private int totalValorLibro;
    private int cantObsequios;
    private int totalValorObsequios;
    
    //Constructor

    public Venta() {
    }

    public Venta(String nomLibro, int cantLibro, int totalValorLibro, int cantObsequios, int totalValorObsequios) {
        this.nomLibro = nomLibro;
        this.cantLibro = cantLibro;
        this.totalValorLibro = totalValorLibro;
        this.cantObsequios = cantObsequios;
        this.totalValorObsequios = totalValorObsequios;
    }
    
    //Getters-Setters

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public int getCantLibro() {
        return cantLibro;
    }

    public void setCantLibro(int cantLibro) {
        this.cantLibro = cantLibro;
    }

    public int getTotalValorLibro() {
        return totalValorLibro;
    }

    public void setTotalValorLibro(int totalValorLibro) {
        this.totalValorLibro = totalValorLibro;
    }

    public int getCantObsequios() {
        return cantObsequios;
    }

    public void setCantObsequios(int cantObsequios) {
        this.cantObsequios = cantObsequios;
    }

    public int getTotalValorObsequios() {
        return totalValorObsequios;
    }

    public void setTotalValorObsequios(int totalValorObsequios) {
        this.totalValorObsequios = totalValorObsequios;
    }
    
    //Métodos
    
    public void actualizarDatos(){
        this.cantLibro = this.cantLibro + 1;
        if(this.cantObsequios!=0){
            this.cantObsequios = this.cantObsequios + 1;
        }    
    }
    
}
