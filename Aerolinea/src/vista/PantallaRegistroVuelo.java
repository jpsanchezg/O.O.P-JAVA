/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidades.Piloto;
import entidades.Vuelo;
import java.time.LocalDate;
import negocio.ControladorRegistroVuelo;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez
 */
public class PantallaRegistroVuelo {

    /**
     * @param args the command line arguments
     */
    private ControladorRegistroVuelo controlador = new ControladorRegistroVuelo();
    
    public static void main(String[] args) {
        // TODO code application logic here
        PantallaRegistroVuelo pr = new PantallaRegistroVuelo();
        LocalDate hoy = LocalDate.of(2020, 2, 29);
        LocalDate ayer = LocalDate.of(2020, 2, 22);
        Vuelo v = new Vuelo(1, hoy);
        if(!pr.controlador.crearVuelo(v)){
            System.out.println("No se pudo crear vuelo");
            System.exit(0);//Si se asigna Vuelo v con la fecha de ayer directamente se termina el programa
        }else{
            System.out.println("Vuelo creado");
        }
        Vuelo vActual = pr.controlador.consultarVuelo();
        if(!pr.controlador.asignarPiloto("Juanpa", 1)){
            System.out.println("No se puede asignar piloto al vuelo");
        }else{
            System.out.println("Se puedo asignar el piloto al vuelo");
        }
        Piloto pActual = pr.controlador.consultarPiloto();
        if(!pr.controlador.modificarSalario(-1)){
            System.out.println("No se pudo modificar salario");
        }else{
            System.out.println("Se pudo modificar salario");
        }
        Piloto nuevo = new Piloto("", 2);
        if(!pr.controlador.reasignarPiloto(nuevo)){
            System.out.println("No se pudo reasignar piloto");
        }else{
            System.out.println("Se pudo reasignar piloto");
        }
    }

    public PantallaRegistroVuelo() {
        
    }  
}
