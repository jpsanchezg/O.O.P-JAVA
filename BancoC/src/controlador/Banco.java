/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author aulasingenieria
 */
public class Banco {
    
    ArrayList <Cuenta> maneja;

    public Banco() {
        maneja = new ArrayList <Cuenta> ();//1
    }
    
    public Cuenta buscarCuenta(String numero){
        for(Cuenta actual:maneja){
            if(actual.getNumero().equals(numero)){
                return actual;//2
            }
        }
        return null;
    }
    
    public int buscarCuenta(Cuenta cuentaBuscada){
        return this.maneja.indexOf(cuentaBuscada);
    }
    
    public Cuenta crearCuenta(String numero, int saldo){
        for(Cuenta actual:maneja){
            if(actual.getNumero().equals(numero)){
                return null;//4
            }
        }
        return new Cuenta(numero, saldo);
    }
    
    public boolean agregarCuenta(Cuenta cuenta){
        if(buscarCuenta(cuenta.getNumero())!=null){
            return false;//5
        }else{
            maneja.add(cuenta);
            return true;
        }  
    }
    
    public Cuenta removerCuenta(String numero){
        Cuenta actual = buscarCuenta(numero);
        if(actual!=null){
            maneja.remove(actual);
            return actual;//6
        }else{
            return null;
        }
    }
    
    public boolean actualizarSaldo(String numero, int nuevoSaldo){
        Cuenta actual = buscarCuenta(numero);
        if(actual!=null){
            actual.setSaldo(nuevoSaldo);
            return true;//7
        }else{
            return false;
        }
    }
    
    public ArrayList <Cuenta> buscarCuentaVIP(int saldoMinimoVip){
        ArrayList <Cuenta> vip = new ArrayList <Cuenta> ();
        for(Cuenta actual:maneja){
            if(actual.getSaldo()>=saldoMinimoVip){
                vip.add(actual);
            }
        }
        return vip;//8
    }
    
    public int saldoTotalCuenta(){
        int saldosTotales = 0;
        for(Cuenta actual:this.maneja){
            saldosTotales = saldosTotales + actual.getSaldo();
        }
        return saldosTotales;//9
    }
    
    public int saldoTotalCuenta(ArrayList <Cuenta> cuentas){
        int saldosTotales = 0;
        for(Cuenta actual:cuentas){
            saldosTotales = saldosTotales + actual.getSaldo();
        }
        return saldosTotales;//9
    }
    
    public int cantidadCuentas(){
        return this.maneja.size();//10
    }
    
    public int cantidadCuentas(ArrayList <Cuenta> cuentas){
        return cuentas.size();//10
    }
    
    public int saldoPromedioCuentas(ArrayList <Cuenta> cuentas){
        return saldoTotalCuenta(cuentas)/cantidadCuentas(cuentas);
    }
    
    public int saldoPromedioCuentas(){
        return saldoTotalCuenta()/cantidadCuentas();//11
    }
 
}
