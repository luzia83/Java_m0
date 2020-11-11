package org.uma.mbd.mdPartidos.partidos;

public class Partido {
    private String nombre;
    private int nVotos;

    public Partido(String nombre, int votos) {
        this.nombre = nombre;
        nVotos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getnVotos() {
        return nVotos;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Partido;
        Partido p = res? (Partido) o : null;
        return res && p.getNombre().equalsIgnoreCase(this.getNombre());
    }

    @Override
    public int hashCode() {
        return getNombre().toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return getNombre() + " : " + getnVotos();
    }
}
