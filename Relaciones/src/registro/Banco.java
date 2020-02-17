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
        Cliente cli = new Cliente(100,"j");
        Cliente cli2 = new Cliente(200,"k");
        Cuenta cta1 = new Cuenta (5000,"C99");
        Cuenta cta2 = new Cuenta (8000,"C80");
        cli.setEsPropiedad(cta1); // respuesta de la pregunta A
        cli.setBeneficia(cta2); // esta es la respuesta de la B 
        cli.setBeneficia(cta1); // esta es la respuesta de la d 6
        cli2.setAutorizado(cli); // esta es la respueta de la C
        cta1.setDueno(cli);
        cta2.setDueno(cli2);
        
        System.out.println(cta1.getDueno().getNombre()); //respuesta de la pregunta d.1
        System.out.println(cli.cuentanombre());//respuesta de la pregunta d 2
        System.out.println(cta2.nombreClienteBeneficiario()); //respuesta de la pregunta d 3
        if (cta1.nombreClienteBeneficiario()!= null)
        {
            System.out.println("No tiene beneficiario"); //respuesta a la pregunta d 4
        }
        System.out.println(cli.getBeneficia().getNumero()); // respuesta a la pregunta d 5
        System.out.println(cta1.nombreautorizado()); //respuesta de la pregunta d 7
        
        
        
        
        
        
        
        // TODO code application logic here
    }
    
}
