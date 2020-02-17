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
public class Cliente {
    
    private int documento;
    private String nombre;
    private Cuenta esPropiedad;
    private Cliente autorizado;

    public Cliente(int documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getEsPropiedad() {
        return esPropiedad;
    }

    public void setEsPropiedad(Cuenta esPropiedad) {
        this.esPropiedad = esPropiedad;
    }

    public Cliente getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Cliente autorizado) {
        this.autorizado = autorizado;
    }
    
    public String numCuenta(int doc){
        if(doc==this.documento){
            return esPropiedad.getNumero();
        }else{
            return "No se puede completar el proceso";
        }
    }
    
}
