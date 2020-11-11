package org.uma.mbd.mdAlturasV2.alturas;

public class Pais implements Comparable<Pais>{
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

    @Override
    public int compareTo(Pais p) {
        int resultado = Double.compare(this.getAltura(), p.getAltura());
        if (resultado == 0) {
            resultado = this.getNombre().compareTo(p.getNombre());
        }
        return resultado;
    }
}
