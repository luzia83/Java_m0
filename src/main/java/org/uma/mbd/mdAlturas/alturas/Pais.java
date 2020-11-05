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
    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Pais;
        Pais p = res ? (Pais)o : null;
        return res && nombre.equalsIgnoreCase(p.getNombre());
    }

    @Override
    public int hashCode() {
        return ((int) altura*100);
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + "," + continente + "," + altura + ")";
    }
}
