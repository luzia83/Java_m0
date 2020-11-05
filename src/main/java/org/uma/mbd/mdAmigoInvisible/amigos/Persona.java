package org.uma.mbd.mdAmigoInvisible.amigos;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private Persona amigo;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void setAmigo(Persona am) {
        this.amigo = am;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Persona;
        Persona p = res? (Persona)o : null;
        return res && getNombre().equalsIgnoreCase(p.getNombre());
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        String nombre;
        if (amigo != null) {
            nombre = amigo.getNombre();
        }
        else {
            nombre = "sin amigo";
        }
        return this.nombre + " --> " + nombre;
    }

    public int compareTo(Persona p) {
        return nombre.compareToIgnoreCase(p.getNombre());
    }

}
