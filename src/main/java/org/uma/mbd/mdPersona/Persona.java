package org.uma.mbd.mdPersona;

import java.util.*;
public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public boolean equals(Object o) {
        boolean res = o instanceof Persona;
        Persona p = res ? (Persona)o : null;
        return res && (edad == p.edad) && (p.nombre.equals(nombre));
    }

    @Override
    public String toString() {
        return "Persona(" + nombre + ", " + edad + ")";
     }

    @Override
    public int hashCode() {
        return nombre.hashCode() + Integer.hashCode(edad);
    }

    @Override
    public int compareTo(Persona p) {
        int res = Integer.compare(edad, p.edad);
        if (res == 0) {
            res = nombre.compareToIgnoreCase(nombre);
        }
        return res;
    }
}