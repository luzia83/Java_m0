package org.uma.mbd.mdAlturas.alturas;

public class Pais {
    private String nombre, continente;
    private double altura;

    public Pais(String n, String c, double a) {
        nombre = n;
        continente = c;
        altura = a;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    public boolean equals(Pais p) {
        return nombre.equalsIgnoreCase(p.nombre);
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + "," + continente + "," + altura + ")";
    }
}
