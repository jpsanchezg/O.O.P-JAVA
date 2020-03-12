/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author aulasingenieria
 */
public class Autor {
    private String nombre;
    private String cedula;
    private String estado;
    private ArrayList<Libro> librosEscritos = new ArrayList <>();

    public Autor() {
    }

    public Autor(String nombre, String cedula, String estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(ArrayList<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    public String getNombre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
