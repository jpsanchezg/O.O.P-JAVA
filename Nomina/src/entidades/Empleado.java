/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Santiago Fernández Becerra 
 */
public class Empleado {
    private String nombre;
    private int numCedula;
    private double salario;
    private double nomina;
    private static final double SLMV = 800000;
    private static final int ST = 90000;
    private static final double PIBC = 0.75;
    private static final double PPENSION = 0.0375;
    private static final double PSALUD = 0.045;
    private static final double PFS = 0.01;

    public Empleado() {
    }

    public Empleado(String nombre, int numCedula, double salario) {
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.salario = (salario*SLMV);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(int numCedula) {
        this.numCedula = numCedula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    public boolean calcularStransporte(){
        boolean res = true;
        if(this.salario<=(2*SLMV)){
            
        }else{
            return false;
        }
        return res;
    }
    
    public double calcularDevengado(){
        double devengado = 0.0;
        if(calcularStransporte()){
            devengado=this.salario+ST;
        }else{
            devengado=this.salario;
        }
        return devengado;
        
    }
    
    public double calcularIbc(){
        return (calcularDevengado()*PIBC);
    }
    
    public double calcularPension(){
        return (calcularIbc()*PPENSION);
    }
    
    public double calcularSalud(){
        return (calcularIbc()*PSALUD);
    }
    
    public double calcularDescuentoFs(){
        double cantFs = 0.0;
        if(calcularIbc()>= (4*SLMV)){
           return (calcularIbc()*PFS);
        }else{
            return 0.0;
        }
    }
    
    public double calcularPrestaciones(){
        return (calcularDescuentoFs()+calcularIbc()+calcularPension()+calcularSalud());
    }
    
    public double calcularNomina(){
        return (calcularDevengado()-calcularPrestaciones());
    }
}
