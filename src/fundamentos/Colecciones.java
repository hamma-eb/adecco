/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author tarde
 */
public class Colecciones {
    public static void main(String[] args) {
        Vector v;
        
        v = new Vector();
        
        Animal tiburon = new Animal("anfibio","Tiburon",2);
        v.add(tiburon);
        
        Animal perro = new Animal("mamifero","demestico",4);
        v.add(perro);
        
        // extrear el objeto del vector
        for (int i = 0; i < v.size(); i++) {
            Animal a =(Animal) v.elementAt(i);
            System.out.println(a.toString());
        }
        
        
        /// arraye list
        
        ArrayList<Animal> animales;
        
        animales = new ArrayList();
        
        
        Animal tipo1 = new Animal("anfibio","Tiburon",2);
        animales.add(tipo1);
        
        Animal tipo2 = new Animal("mamifero","demestico",4);
        animales.add(tipo2);
        
        // extrear el objeto del vector
        for (int i = 0; i < v.size(); i++) {
            Animal a =(Animal) animales.get(i);
            System.out.println(a.toString());
        }
        
        
        
        
        
        
        
        
    }
}
