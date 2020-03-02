/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Banco;
import entidades.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez
 */
public class PantallaBanco {

    /**
     * @param args the command line arguments
     */
    
    private Banco banco = new Banco();
    
    public static void main(String[] args) {
        // TODO code application logic here
        PantallaBanco pr = new PantallaBanco();
        Cuenta c1 = pr.banco.crearCuenta("100", 2000);
        Cuenta c2 = pr.banco.crearCuenta("200", 3000);
        Cuenta c3 = pr.banco.crearCuenta("100", 4000);
        Cuenta c4 = pr.banco.crearCuenta("300", 1000);
        Cuenta c5 = pr.banco.crearCuenta("400", 5000);
        
        if(pr.banco.agregarCuenta(c1)){
            System.out.println("Se pudo agregar");
        }else{
            System.out.println("Cuenta ya existente");
        }
        if(pr.banco.agregarCuenta(c2)){
            System.out.println("Se pudo agregar");
        }else{
            System.out.println("Cuenta ya existente");
        }
        if(pr.banco.agregarCuenta(c3)){
            System.out.println("Se pudo agregar");
        }else{
            System.out.println("Cuenta ya existente");
        }
        if(pr.banco.agregarCuenta(c4)){
            System.out.println("Se pudo agregar");
        }else{
            System.out.println("Cuenta ya existente");
        }
        if(pr.banco.agregarCuenta(c5)){
            System.out.println("Se pudo agregar");
        }else{
            System.out.println("Cuenta ya existente");
        }
        
        System.out.println("Saldo anterior: "+pr.banco.buscarCuenta("300").getSaldo());
        
        if(!pr.banco.actualizarSaldo("300", 500)){
            System.out.println("No se pudo actualizar saldo");
        }else{
            System.out.println("Saldo actual: "+pr.banco.buscarCuenta("300").getSaldo());
        }
        
        Cuenta cAux = pr.banco.removerCuenta("200");
        
        if(cAux==null){
            System.out.println("Cuenta inexistente");
        }else{
            System.out.println("Cuenta correctamente removida");
            System.out.println("Saldo: "+cAux.getSaldo());
        }
        for(Cuenta actual:pr.banco.buscarCuentaVIP(3000)){
            System.out.println("La cuenta numero: "+actual.getNumero()+" es VIP");
        }
        System.out.println("Saldo total cuentas normales: "+pr.banco.saldoTotalCuenta());
        System.out.println("Saldo total cuentas vip: "+pr.banco.saldoTotalCuenta(pr.banco.buscarCuentaVIP(3000)));
        System.out.println("Cantidad cuentas normales: "+pr.banco.cantidadCuentas());
        System.out.println("Cantidad cuentas vip: "+pr.banco.cantidadCuentas(pr.banco.buscarCuentaVIP(3000)));
        System.out.println("Saldo promedio cuentas normales: "+pr.banco.saldoPromedioCuentas());
        System.out.println("Saldo promedio cuentas vip: "+pr.banco.saldoPromedioCuentas(pr.banco.buscarCuentaVIP(3000)));
    }
    
}
