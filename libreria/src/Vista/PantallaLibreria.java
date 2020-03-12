/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controllers.ControllerAutor;
import controllers.ControllerLibro;
import entidades.Autor;
import entidades.Libro;

/**
 *
 * @author aulasingenieria
 */
public class PantallaLibreria {

    /**
     * @param args the command line arguments
     */
    private ControllerLibro controladorLibro = new ControllerLibro();
    private ControllerAutor controladorAutor = new ControllerAutor();
    private entidades.Autor controlerdeautor = new entidades.Autor();
    public static void main(String[] args) {
        PantallaLibreria pan = new PantallaLibreria();
        Autor auto1 = new Autor("juanito","10112234","activo");
        Autor auto2 = new Autor("pedro","10112234","activo");
        Autor auto3 = new Autor("juanita","10312234","activo");
        Libro libro1 = new Libro("noches de soledad","1234",100,auto1);
        Libro libro2 = new Libro("noches de pan","1234",200,auto1);
        Libro libro3 = new Libro("ella no te ama","1234",300,auto3);
        Libro libro4 = new Libro("eres g3i","12634",400,auto1);
       if(!pan.controladorAutor.agregarAutor(auto1)){
           System.out.println(" no se creo el autor");
       }else{
           System.out.println("se creo el autor");
       }
        if(!pan.controladorAutor.agregarAutor(auto2)){
           System.out.println("no se creo el autor");
       }else{
           System.out.println(" se creo el autor");
       }
         if(!pan.controladorAutor.agregarAutor(auto3)){
           System.out.println("no se creo el autor");
       }else{
           System.out.println(" se creo el autor");
       }
         if(!pan.controladorAutor.agregarLibroAAutor(auto1, libro1)){
             System.out.println("no se agrego el libro");
         }else{
             System.out.println("se agrego el libro");
         }
         
         if(!pan.controladorAutor.agregarLibroAAutor(auto1, libro2)){
             System.out.println("no se agrego el libro");
         }else{
             System.out.println("se agrego el libro");
         }
         
         if(!pan.controladorAutor.agregarLibroAAutor(auto3, libro3)){
             System.out.println("no se agrego el libro");
         }else{
             System.out.println("se agrego el libro");
         }
        
         if(!pan.controladorAutor.agregarLibroAAutor(auto1, libro4)){
             System.out.println("no se agrego el libro");
         }else{
             System.out.println("se agrego el libro");
         }
         System.out.println("el costo total del autor "+ pan.controladorAutor.BuscarAutor("10112234")+" es:" + pan.controladorAutor.calcularCostoTotalLibrosPorAutor("10112234"));
         System.out.println("el costo total del autor "+ pan.controladorAutor.BuscarAutor("10112234") + " es:" + pan.controladorAutor.calcularCostoTotalLibrosPorAutor("10312234"));
         System.out.println("el costo total de libros es:" + pan.controladorAutor.calcularCostoTotalLibros());

        // TODO code application logic here
    }
    
}
