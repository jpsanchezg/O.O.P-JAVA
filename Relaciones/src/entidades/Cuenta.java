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
public class Cuenta {
    
    private String numero;
    private int saldo;
    private Cliente dueno;
    private Cliente beneficiaA;

    public Cuenta(String numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cliente getDueno() {
        return dueno;
    }

    public void setDueno(Cliente dueno) {
        this.dueno = dueno;
    }

    public Cliente getBeneficiaA() {
        return beneficiaA;
    }

    public void setBeneficiaA(Cliente beneficiaA) {
        this.beneficiaA = beneficiaA;
    }
    
    public String nomBen(String numC){
        if(numC.equals(this.numero)){
            return beneficiaA.getNombre();
        }else{
            return "No se puede completar el proceso";
        }
    }
    
    public Cliente benefi(String numC){
        if(numC.equals(this.numero)){
            return this.beneficiaA;
        }else{
            return null;
        }
    }
    
    public Cliente au(){
        return this.getDueno().getAutorizado();
    }
}
