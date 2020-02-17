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
    private Cuenta esPropiedad;
    private Cuenta beneficia;
    private int Documento;
    private String nombre;
    private Cliente autorizado;

  
    public String cuentanombre ()
    {
        return getEsPropiedad().getNumero();
    }
    public Cliente getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Cliente autorizado) {
        this.autorizado = autorizado;
    }
    
    public Cuenta getBeneficia() {
        return beneficia;
    }

    public void setBeneficia(Cuenta beneficia) {
        this.beneficia = beneficia;
    }
  

    public Cliente( int Documento, String nombre) {
       
        this.Documento = Documento;
        this.nombre = nombre;
    }

    public Cuenta getEsPropiedad() {
        return esPropiedad;
    }

    public void setEsPropiedad(Cuenta esPropiedad) {
        this.esPropiedad = esPropiedad;
    }

    

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
