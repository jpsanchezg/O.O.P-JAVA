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

    private Cliente dueno;
    private Cliente beneficiario;
    private int Saldo;
    private String Numero;

    public String nombreautorizado() {
        return getDueno().getNombre();
    }

    public String nombreClienteBeneficiario() {
        return getDueno().getNombre();
    }

    public Cliente getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Cliente beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Cuenta(int Saldo, String Numero) {

        this.Saldo = Saldo;
        this.Numero = Numero;
    }

    public Cliente getDueno() {
        return dueno;
    }

    public void setDueno(Cliente dueno) {
        this.dueno = dueno;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

}
