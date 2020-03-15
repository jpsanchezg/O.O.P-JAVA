/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dto.Factura;
import entidades.Billete;
import entidades.Libro;
import entidades.Prestamo;
import dto.Registro;
import dto.Reporte;
import dto.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import dto.Transaccion;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class Libreria {
    
    //Relaciones
    private GestionLibro gestion = new GestionLibro();
    private ArrayList <Libro> librosDisponibles = new ArrayList <Libro> ();
    private ArrayList <Prestamo> prestamos = new ArrayList <Prestamo> ();
    private Prestamo prestamoActual;
    private ArrayList <Billete> dineroAcumulado = new ArrayList <Billete> ();
    
    //Constructores

    public Libreria() {
        iniciarDia();
    }   
    
    //Getters-Setters

    public GestionLibro getGestion() {
        return gestion;
    }

    public void setGestion(GestionLibro gestion) {
        this.gestion = gestion;
    }

    public ArrayList<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public void setLibrosDisponibles(ArrayList<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

    public ArrayList<Billete> getDineroAcumulado() {
        return dineroAcumulado;
    }

    public void setDineroAcumulado(ArrayList<Billete> dineroAcumulado) {
        this.dineroAcumulado = dineroAcumulado;
    }
    
    //Métodos
    
    private ArrayList <Billete> llenarBilletes(){
        ArrayList <Billete> billetes = new ArrayList <Billete> ();
        Billete bill = new Billete (1, 20);
        billetes.add(bill);
        Billete bill1 = new Billete (5, 20);
        billetes.add(bill1);
        Billete bill2 = new Billete (10, 20);
        billetes.add(bill2);
        Billete bill3 = new Billete (20, 20);
        billetes.add(bill3);
        Billete bill4 = new Billete (50, 20);
        billetes.add(bill4);
        Billete bill5 = new Billete (100, 20);
        billetes.add(bill5);
        return billetes;
    }
    
    public void iniciarDia() {
        this.librosDisponibles=this.gestion.llenarLibros();
        this.dineroAcumulado=llenarBilletes();
    }
    
    public int consultarExistencias(){
    	return this.librosDisponibles.size();
    }
    
    public boolean iniciarPrestamo(){
    	if(consultarExistencias()==0){
            return false;
    	}else {
            this.prestamoActual = new Prestamo(LocalDate.now());
            this.prestamos.add(this.prestamoActual);
            return true;
    	}
    }
    
    public ArrayList <Libro> listarLibros(){
        return this.getLibrosDisponibles();
    }
    
    public Libro buscarIsbn(String isbn) {
        for(Libro actual : this.librosDisponibles) {
            if(actual.getIsbn().equals(isbn)&&consultarDisponible(actual)) {  			
                return actual;
            }
        }
        return null;
    }
    
    public boolean consultarDisponible(Libro libro) {
        if(libro.getUnidadesDisponibles()!=0) {
            return true;
        }else {
            return false;
        }
    }
    
    public int numPrestamo(){
        return this.prestamoActual.getLibrosEnPrestamo().size();
    }
    
    public int numObsequios(){
        int cont = 0;
        for(Libro actual : this.prestamoActual.getLibrosEnPrestamo()) {
            cont = cont + actual.getObsequios().size();
        }
        return cont;
    }
    
    public int totalAcumulado() {
        int cont = 0;
        for(Libro actual : this.prestamoActual.getLibrosEnPrestamo()) {
            cont = cont + actual.getPrecio();
        }
        return cont;
    }
    
    public Registro agregarLibro(String isbn) {
        Libro libro = buscarIsbn(isbn); 
        if(libro!=null){
            this.prestamoActual.getLibrosEnPrestamo().add(libro);
            Registro actual = new Registro(numPrestamo(), numObsequios(), totalAcumulado());
            return actual;
        }else {
            return null;
        }
    }
    
    public ArrayList <Billete> listarBilletes(){
        return this.getDineroAcumulado();
    }
    
    private boolean valDenominacion(int den){
        Billete bActual = buscarBillete(den);
        if(bActual!=null){
            if(den==bActual.getDenominacion()){
                return true;
            }
        }     
        return false;
    }
    
    public Billete buscarBillete(int den){
        for(Billete actual : this.dineroAcumulado){
            if(actual.getDenominacion() == den){
                return actual;
            }
        }
        return null;
    }
    
    public Integer buscarIndexBillete(int den){
        Billete bActual = buscarBillete(den);
        if(bActual.getDenominacion() == den){
            return this.dineroAcumulado.indexOf(bActual);
        }       
        return null;
    }
    
    
    public boolean agregarBillete(Billete actual){
        int den = actual.getDenominacion(), i;
        if(valDenominacion(den)){
            this.prestamoActual.getPagoBilletes().add(actual);
            i = buscarIndexBillete(den);
            this.dineroAcumulado.get(i).aumentarCantidad();
            return true;
        }
        return false;
    }
    
    public int totalAcumuladoPrestamo(){
        int cont = 0;
        ArrayList <Billete> billetes = this.prestamoActual.getPagoBilletes();
        for(Billete actual : billetes){
            cont = cont + actual.getDenominacion();
        }
        return cont;
    }
    
    public int vueltas(){
        return totalAcumuladoPrestamo()-totalAcumulado();
    }
    
    public void actualizarExistenciasLibros(){
        String isbn;
        int i;
        for(Libro actual : this.prestamoActual.getLibrosEnPrestamo()){
            isbn = actual.getIsbn();
            i = buscarIndexLibro(isbn);
            this.librosDisponibles.get(i).reducirCantidad();
        }
    }
    
    public void actualizarExistenciasBilletes(){
        int den, i;
        for(Billete actual : this.prestamoActual.getPagoBilletes()){
            den = actual.getDenominacion();
            i = buscarIndexBillete(den);
            this.dineroAcumulado.get(i).reducirCantidad();
        }
    }
    
    public Integer buscarIndexLibro(String isbn){
        Libro actual = buscarIsbn(isbn);
        if(actual.getIsbn().equals(isbn)){
            return this.librosDisponibles.indexOf(actual);
        }       
        return null;
    }    
        
    public Factura finalizarPrestamo(){
        Factura actual = new Factura();
        if(totalAcumulado()<=totalAcumuladoPrestamo()){
            if(vueltas()>=0){
                actualizarExistenciasLibros();
                actualizarExistenciasBilletes();
                actual.setNumTotalLibros(this.prestamoActual.getLibrosEnPrestamo().size());
                actual.setValPrestamo(totalAcumulado());
                actual.setNumBilletes(this.prestamoActual.getPagoBilletes().size());       
                actual.setCambio(vueltas());
            }
        }
        return actual;
    }
    
    public boolean verificarVueltas(){
        if(vueltas()>=0){
            return true;
        }
        return false;
    }
    
    public int valorTotalPrestamos(){
        int cont = 0;
        for(Prestamo pActual : this.prestamos){
            for(Libro libro : pActual.getLibrosEnPrestamo()){
                cont = cont + libro.getPrecio();
            }
        }
        return cont;
    }
    
    public Venta crearVenta(Libro lib){
        return new Venta(lib.getNombre(), lib.getUnidadesDisponibles(), lib.getPrecio(), lib.getObsequios().size(), lib.valorObsequios());
    }
    
    public boolean verificarVentas(ArrayList <Venta> ventas, String nom){
        for(Venta actual : ventas){
            if(actual.getNomLibro().equals(nom)){
                return true;
            }
        }
        return false;
    }
    
    public Integer buscarIndexVenta(ArrayList <Venta> ventas, String nom){
        for(Venta actual : ventas){
            if(actual.getNomLibro().equals(nom)){
                return ventas.indexOf(actual);//Debug D
            }
        }
        return null;
    }
    
    public Reporte generarReporte(){
        Reporte actual = new Reporte();
        ArrayList <Venta> ventas = new ArrayList <Venta> ();
        int i;
        actual.setValTotalPrestamos(valorTotalPrestamos());
        for(Prestamo pActual : this.prestamos){
            for(Libro lActual : pActual.getLibrosEnPrestamo()){
                if(verificarVentas(ventas, lActual.getNombre())){                   
                    i=buscarIndexVenta(ventas, lActual.getNombre());
                    ventas.get(i).actualizarDatos(); 
                }else{
                    ventas.add(crearVenta(lActual)); 
                } 
            }
        }
        actual.setVentas(ventas);
        return actual;
    }
    
    public ArrayList<Billete> devolucion(){
        ArrayList<Billete> cambio=new ArrayList<Billete>();
        Transaccion tActual=new Transaccion();
        tActual.setTotalBilletes(totalAcumuladoPrestamo());
        tActual.setTotalPrestamo(totalAcumulado());
        tActual.setSaldoFaltante(totalAcumuladoPrestamo() - totalAcumulado());
        for (int i = this.dineroAcumulado.size()-1; i >=0; i--) {
            int cont=0;
            while(tActual.getSaldoFaltante()-this.dineroAcumulado.get(i).getDenominacion()>=0){
                tActual.setSaldoFaltante(tActual.getSaldoFaltante()-this.dineroAcumulado.get(i).getDenominacion());
                cont=cont+1;
            }
        cambio.add(new Billete(this.dineroAcumulado.get(i).getDenominacion(), cont));
        this.dineroAcumulado.get(i).setCantidad(this.dineroAcumulado.get(i).getCantidad()-cont);               
        }
        return cambio;    
    }
    
}
