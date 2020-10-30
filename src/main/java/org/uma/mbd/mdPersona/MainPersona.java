package org.uma.mbd.mdPersona;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MainPersona {

    public static void main(String [] args) {
        Persona p1 = new Persona("Juan", 35);
        Persona p2 = new Persona("Alba", 22);
        Persona p3 = new Persona("pedro", 22);
        System.out.println(p1.compareTo(p2));
        Comparator<Persona> comp = new OrdenNombre();
        Set<Persona> set = new TreeSet<Persona>(comp);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }

}

