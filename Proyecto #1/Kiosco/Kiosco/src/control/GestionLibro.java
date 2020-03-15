/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Libro;
import java.util.ArrayList;

/**
 *
 * @author Santiago Fernández - Juan Pablo Sánchez - Daniel Niño
 */
public class GestionLibro {
    
    //Constructores

    public GestionLibro() {
        
    }
    
    //Métodos

    public ArrayList<Libro> llenarLibros() {
        ArrayList <Libro> disponibles = new ArrayList <Libro> ();
        //Libreria
        Libro libro1 = new Libro("9781499513622", 5, 29, "Bajo la misma estrella");
        disponibles.add(libro1);
        Libro libro2 = new Libro("9782266257237", 10, 19, "Los juegos del hambre");
        disponibles.add(libro2);
        Libro libro3 = new Libro("9788826068244", 15, 39, "Mein Kampf");
        disponibles.add(libro3);
        Libro libro4 = new Libro("9781471331435", 20, 39, "1984");
        disponibles.add(libro4);
        Libro libro5 = new Libro("9788576654629", 25, 19, "Satanas");
        disponibles.add(libro5);
        //Regalo
        Libro libro6 = new Libro("9789197311205", 10, 29, "Manifiesto Comunista");
        disponibles.add(libro6);
        libro3.getObsequios().add(libro6);
        Libro libro7 = new Libro("9781624061547", 20, 29, "Divergente");
        disponibles.add(libro7);
        libro2.getObsequios().add(libro7);
        Libro libro8 = new Libro("9782811218836", 30, 19, "Yo antes de ti");
        disponibles.add(libro8);
        libro1.getObsequios().add(libro8);
        Libro libro9 = new Libro("9780965185196", 25, 39, "Un mundo feliz");
        disponibles.add(libro9);
        libro4.getObsequios().add(libro9);
        Libro libro10 = new Libro("9783492267816", 5, 29, "No quiero matarte");
        disponibles.add(libro9);
        libro10.getObsequios().add(libro9);
        return disponibles;
    }

}
