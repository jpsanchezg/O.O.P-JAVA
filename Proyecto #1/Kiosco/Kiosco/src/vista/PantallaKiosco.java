/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Libreria;
import dto.Factura;
import entidades.Libro;
import dto.Registro;
import dto.Transaccion;
import entidades.Billete;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class PantallaKiosco {

    /**
     * @param args the command line arguments
     */
    
    //Relaciones
    
    //1
    private Libreria quiosco = new Libreria();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Kiosco");
        
        PantallaKiosco pr = new PantallaKiosco();
        
        /*ArrayList <Libro> prueba = pr.quiosco.getLibrosDisponibles();
        System.out.println("size "+prueba.size());*/
        
        //2
        Scanner in = new Scanner (System.in);
        System.out.println("Desea iniciar prestamo (true/false): ");
        boolean inPrestamo = in.nextBoolean();
        if(inPrestamo) {
            if(!pr.quiosco.iniciarPrestamo()){
                System.out.println("Lo sentimos, no hay existencias de libros actualmente");
                System.exit(0);
            }else{
                System.out.println("Inicio de prestamo correctamente");
            }
        }else{
            System.exit(0);
        }
        //3
        System.out.println("Estos son los libros disponibles: ");
        ArrayList <Libro> listaLib = pr.quiosco.listarLibros();
        for(Libro actual : listaLib){
            System.out.println("ISBN: "+actual.getIsbn());
            System.out.println("Nombre Libro: "+actual.getNombre());
            System.out.println("Precio: "+actual.getPrecio());
        }
        //4
        Registro rActual = new Registro();
        Scanner in2 = new Scanner (System.in);
        String aIsbn;
        Libro actual;
        boolean op = true;
        while(op){
            System.out.println("Agregar Libros por ISBN: ");
            aIsbn = in2.nextLine();
            actual = pr.quiosco.buscarIsbn(aIsbn);
            rActual = pr.quiosco.agregarLibro(aIsbn);
            if(rActual == null){
                System.out.println("El libro con el isbn digitado no tiene existencias");
            }else{
                System.out.println("Nombre del libro: "+actual.getNombre());
                System.out.println("Precio acumulado del prestamo: "+rActual.getAcumulado());
                System.out.println("Libros acumulados del prestamo: "+rActual.getLibrosDelPrestamo());
                System.out.println("Libros acumulados de obsequio del prestamo: "+rActual.getLibrosObsequio());
            }
            System.out.println("¿Desea seguir agregando libros? (true/false): ");
            op = in.nextBoolean();	
        }
        //5
        System.out.println("Estos son los billetes disponibles: ");
        ArrayList <Billete> listaBill = pr.quiosco.listarBilletes();
        boolean op2 = true;
        Scanner in3 = new Scanner (System.in);
        Billete aBill = new Billete();
        int den;
        Transaccion tActual = new Transaccion();
        for(Billete bActual : listaBill){
            System.out.println("Denominacion: "+bActual.getDenominacion());
            System.out.println("Cantidad: "+bActual.getCantidad());
        }
        //6
        while(op2){
            System.out.println("Total a pagar: "+rActual.getAcumulado());
            System.out.println("Agregar Billetes por denominacion: ");
            den = in3.nextInt();
            aBill.setDenominacion(den);
            aBill.setCantidad(1);
            //aBill = new Billete(den, 1);
            if(pr.quiosco.agregarBillete(aBill)){
                System.out.println("Billete de denominacion "+aBill.getDenominacion()+" ha sido agregado");
            }else{
                System.out.println("No se pudo agregar billete");
            }
            tActual.setTotalBilletes(pr.quiosco.totalAcumuladoPrestamo());
            tActual.setTotalPrestamo(pr.quiosco.totalAcumulado());
            tActual.setSaldoFaltante(pr.quiosco.totalAcumuladoPrestamo()-pr.quiosco.totalAcumulado());
            System.out.println("Saldo actual: "+tActual.getTotalBilletes()+" Saldo prestamo: "+tActual.getTotalPrestamo()+" Saldo faltante: "+tActual.getSaldoFaltante());
            /*System.out.println("Desea seguir agregando billetes (true/false): ");
            op2 = in.nextBoolean();*/
            if(tActual.getSaldoFaltante()>0){
                System.out.println("Transaccion finalizada con exito");
                op2=false;
            }
        }     
        /*for(Billete bActual : listaBill){
            System.out.println("Denominacion: "+bActual.getDenominacion());
            System.out.println("Cantidad: "+bActual.getCantidad());
        }*/
        //7
        boolean op3;
        Scanner in4 = new Scanner (System.in);
        System.out.println("¿Desea terminar su prestamo? (true/false): ");
        op3 = in4.nextBoolean();
        if(op3==true){
            Factura fActual = pr.quiosco.finalizarPrestamo();
            if(fActual!=null){
                System.out.println("Numero total de libros del prestamo: "+fActual.getNumTotalLibros());
                System.out.println("Valor total prestamo: "+fActual.getValPrestamo());
                System.out.println("Numero total de billetes del prestamo: "+fActual.getNumBilletes());
                System.out.println("Total cambio del prestamo: "+fActual.getCambio());            
            }else{
                System.out.println("No se pudo generar factura");
            }            
        }
        //8
        
    }
    
}
