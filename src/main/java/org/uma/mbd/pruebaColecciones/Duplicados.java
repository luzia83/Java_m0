package org.uma.mbd.pruebaColecciones;

import java.util.HashSet;
import java.util.Set;

public class Duplicados {

    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();

        for (String arg : args) {
            if(!s.add(arg)) {
                System.out.println("Duplicado: " +arg);
            }
        }
        System.out.println(s.size() + " argumentos detectados:  " + s);
    }
}
