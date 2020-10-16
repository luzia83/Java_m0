package org.uma.mbd.mdCoches.coches;

public class Coche {
    private String nombre;
    private double precio;
    private static double PIVA = 0.16;

    public Coche(String n, double p) {
        nombre = n;
        precio = p;
    }

    public static void setPiva(double IVA) {
        PIVA = IVA;
    }

    public double precioTotal() {
        return precio*(1 + PIVA);
    }

    public String toString() {
        return nombre + " -> " + precioTotal();
    }
}
