package org.uma.mbd.mdCoches.coches;

public class CocheImportado extends Coche {
    private double homologacion;

    public CocheImportado(String n, double p, double h) {
        super(n, p);
        homologacion = h;
    }

    public double precioTotal() {
        return super.precioTotal() + homologacion;
    }
}
