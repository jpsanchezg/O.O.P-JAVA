/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro;

import entidades.Cliente;
import entidades.Cuenta;

/**
 *
 * @author aulasingenieria
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //a
        Cliente cl = new Cliente(100, "J");
        Cuenta cu = new Cuenta("C99", 5000);
        cl.setEsPropiedad(cu);
        cu.setDueno(cl);
        //b
        Cuenta cu2 = new Cuenta("C80", 8000);     
        cu2.setBeneficiaA(cl);
        //c
        Cliente cl2 = new Cliente(200, "K");
        cl.setAutorizado(cl2);
        //d i
        System.out.println("El usuario de cuenta: "+cu.getNumero()+" es de nombre: "+cu.getDueno().getNombre());
        //d ii
        System.out.println("El usuario de documento: "+cl.getDocumento()+" es de numero de cuenta: "+cl.numCuenta(100));
        //d iii
        System.out.println("El usuario de de cuenta: "+cu2.getNumero()+" beneficia a: "+cu2.nomBen("C80"));
        //d iv
        if(cu.benefi("C99")!=null){
            System.out.println("El usuario de de cuenta: "+cu.getNumero()+" beneficia a: "+cu.benefi("C99"));
        }else{
            System.out.println("No tiene beneficiario");
        }
        //d v
        if(cl.getEsPropiedad().getBeneficiaA()!=null){
            System.out.println("El nombre del beneficiario de: "+cl.getNombre()+ " es: "+cl.getEsPropiedad().getBeneficiaA().getNombre());
        }else{
            System.out.println("No tiene beneficiario");
        }
        //d vi
        cu.setBeneficiaA(cl);
        //d vii
        if(cu.au().getNombre()!=null){
            System.out.println("El nombre del autorizado es: "+cu.au().getNombre());
        }else{
            System.out.println("No hay autorizado");
        }
    }
    
}
