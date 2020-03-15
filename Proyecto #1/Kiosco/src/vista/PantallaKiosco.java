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
import dto.Reporte;
import dto.Transaccion;
import dto.Venta;
import entidades.Billete;
import java.util.ArrayList;
import java.util.Date;
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
        boolean exit = false;
        while (exit != true) {
            String inPrestamo;

            System.out.println("Bienvenido al Kiosco de los Libros Magicos");

            PantallaKiosco pr = new PantallaKiosco();
            /*ArrayList <Libro> prueba = pr.quiosco.getLibrosDisponibles();
            System.out.println("size "+prueba.size());*/

            //2
            Scanner in = new Scanner(System.in);
            System.out.println("-----------");
            System.out.println("Desea iniciar prestamo (Si/No): ");
            inPrestamo = in.nextLine();
            if (inPrestamo.toUpperCase().equals("SI")) {
                if (!pr.quiosco.iniciarPrestamo()) {
                    System.out.println("Lo sentimos, no hay existencias de libros actualmente");
                    System.exit(0);
                } else {
                    System.out.println("Inicio de prestamo correctamente");
                }
            } else {
                System.exit(0);
            }
            //4
            Registro rActual = new Registro();
            Scanner in2 = new Scanner(System.in);
            String aIsbn;
            Libro actual;
            String op = "SI";

            while (op.toUpperCase().equals("SI")) {
                //3
                System.out.println("-----------");
                System.out.println("Estos son los libros disponibles: ");
                ArrayList<Libro> listaLib = pr.quiosco.listarLibros();
                for (Libro lactual : listaLib) {
                    System.out.println("ISBN: " + lactual.getIsbn());
                    System.out.println("Nombre Libro: " + lactual.getNombre());
                    System.out.println("Precio: " + lactual.getPrecio());
                }
                System.out.println("-----------");
                System.out.println("Agregar Libros por ISBN: ");
                aIsbn = in2.nextLine();
                actual = pr.quiosco.buscarIsbn(aIsbn);
                rActual = pr.quiosco.agregarLibro(aIsbn);
                if (rActual == null) {
                    System.out.println("El libro con el isbn digitado no tiene existencias");
                } else {
                    System.out.println("Nombre del libro: " + actual.getNombre());
                    System.out.println("Precio acumulado del prestamo: " + rActual.getAcumulado());

                    System.out.println("Libros acumulados del prestamo: " + rActual.getLibrosDelPrestamo());
                    System.out.println("Libros acumulados de obsequio del prestamo: " + rActual.getLibrosObsequio());
                }
                System.out.println("-----------");

                System.out.println("¿Desea seguir agregando libros? (Si/No): ");

                op = in.nextLine();
            }
            //5
            System.out.println("-----------");
            System.out.println("Estos son los billetes disponibles: ");
            ArrayList<Billete> listaBill = pr.quiosco.listarBilletes();

            boolean op2 = true;
            Scanner in3 = new Scanner(System.in);
            Billete aBill = new Billete();
            int den;
            Transaccion tActual = new Transaccion();
            for (Billete bActual : listaBill) {
                System.out.println("Denominacion: " + bActual.getDenominacion());
                System.out.println("Cantidad: " + bActual.getCantidad());
            }
            //6
            while (op2) {
                System.out.println("Total a pagar: " + rActual.getAcumulado());
                System.out.println("-----------");
                System.out.println("Agregar Billetes por denominacion: ");
                den = in3.nextInt();
                aBill=pr.quiosco.buscarBillete(den);
                if(aBill!=null){//Debug D
                    if (pr.quiosco.agregarBillete(aBill)) {
                        System.out.println("Billete de denominacion " + aBill.getDenominacion() + " ha sido agregado");
                    } else {
                        System.out.println("No se pudo agregar billete");
                        System.out.println("Agregue un billete que esta en la lista de billetes permitidos");
                        System.out.println("-----------");
                    }
                    tActual.setTotalBilletes(pr.quiosco.totalAcumuladoPrestamo());
                    tActual.setTotalPrestamo(pr.quiosco.totalAcumulado());
                    tActual.setSaldoFaltante(pr.quiosco.totalAcumuladoPrestamo() - pr.quiosco.totalAcumulado());
                    System.out.println("Saldo actual: " + tActual.getTotalBilletes() + " Saldo prestamo: " + tActual.getTotalPrestamo() + " Saldo pendiente: " + tActual.getSaldoFaltante());
                    /*System.out.println("Desea seguir agregando billetes (true/false): ");
                    op2 = in.nextBoolean();*/
                    if (tActual.getSaldoFaltante() > 0) {
                        System.out.println("Transaccion finalizada con exito");
                        System.out.println("-----------");
                        op2 = false;
                    }
                }else{
                    System.out.println("No existe el billete");
                }
            }
            /*for(Billete bActual : listaBill){
                System.out.println("Denominacion: "+bActual.getDenominacion());
                System.out.println("Cantidad: "+bActual.getCantidad());
             }*/
            //7
            String op3 = "SI";
            Scanner in4 = new Scanner(System.in);
            System.out.println("¿Desea terminar su prestamo? (SI/NO): ");
            op3 = in4.nextLine();
            if (op3.toUpperCase().equals("SI")) {
                Factura fActual = pr.quiosco.finalizarPrestamo();
                if (fActual != null) {
                    System.out.println("Numero total de libros del prestamo: " + fActual.getNumTotalLibros());
                    System.out.println("Valor total prestamo: " + fActual.getValPrestamo());
                    System.out.println("Numero total de billetes del prestamo: " + fActual.getNumBilletes());
                    System.out.println("Total cambio del prestamo: " + fActual.getCambio());
                } else {
                    System.out.println("No se pudo generar factura");
                }
            }
            //8
            ArrayList <Billete> cambio=pr.quiosco.devolucion();
            System.out.println("Cambio: ");
            System.out.println(cambio.size());
            for (Billete billete : cambio) {
                System.out.println("Denominacion: "+billete.getDenominacion()+" Cantidad: "+billete.getCantidad());
            }
            //9
            String op4;
            Scanner in5 = new Scanner(System.in);
            System.out.println("¿Admin desea gerenar el reporte? digite la contraseña: ");
            op4 = in5.nextLine();
            if ("admin".equals(op4)) {
                java.util.Date fecha = new Date();
                Reporte eActual = pr.quiosco.generarReporte();
                System.out.println("Reporte del dia " + fecha + ": ");
                System.out.println("Valor total de prestamos: " + eActual.getValTotalPrestamos());
                ArrayList<Venta> ventas = eActual.getVentas();
                for(Venta vActual : ventas) {
                    System.out.println("Libro: " + vActual.getNomLibro());
                    System.out.println("Cantidad por libro: " + vActual.getCantLibro());
                    System.out.println("Valor libro: "+ vActual.getTotalValorLibro());
                    System.out.println("Cantidad de obsequios: "+ vActual.getCantObsequios());
                    System.out.println("Valor libros obsequio: "+ vActual.getTotalValorObsequios());
                }
                Scanner opc = new Scanner(System.in);
                String opci;
                System.out.println("Desea continuar? SI/NO");
                opci = opc.nextLine();
                if (opci.toUpperCase().equals("NO")) {
                    exit = true;
                    System.exit(0);
                }
            }          
        }
    }
}
