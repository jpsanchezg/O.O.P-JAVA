/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Empleado;

/**
 *
 * @author aulasingenieria
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa emp = new Empresa();
        Empleado em1=crearEmpleado("Pedro", 123, 15);
        Empleado em2=crearEmpleado("Pablo", 456, 2);
        Empleado em3=crearEmpleado("Jose", 789, 5);
        emp.valEmpleado(em1);
        emp.valEmpleado(em2);
        emp.valEmpleado(em3);
        System.out.println("Total a pagar SENA por "+em1.getNombre()+" es: "+(em1.calcularNomina()*0.04));
        System.out.println("Total a pagar SENA por "+em2.getNombre()+" es: "+(em2.calcularNomina()*0.04));
        System.out.println("Total a pagar SENA por "+em3.getNombre()+" es: "+(em3.calcularNomina()*0.04));
    }
    
    public static Empleado crearEmpleado(String nombre, int cedula, int salario){
        return new Empleado(nombre, cedula, salario);
    }
    
    public void valEmpleado(Empleado em){
        System.out.println("Empleado: "+em.getNombre()+ " numero de cedula: "+em.getNumCedula()+ " con salario: "+em.getSalario());
        System.out.println("Total devengado: "+em.calcularDevengado());
        System.out.println("Total descuentos: "+em.calcularPrestaciones());
        System.out.println("Total nomina: "+em.calcularNomina());
    }
}
