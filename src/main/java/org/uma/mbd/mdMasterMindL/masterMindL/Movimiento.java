package org.uma.mbd.mdMasterMindL.masterMindL;

public class Movimiento {
    private String cifras;
    private int colocadas, descolocadas;

    public Movimiento(String i, int c, int d) {
        cifras = i;
        colocadas = c;
        descolocadas = d;
    }

    public String getCifras() {
        return cifras;
    }

    public int getColocadas() {
        return colocadas;
    }

    public int getDescolocadas() {
        return descolocadas;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Movimiento;
        Movimiento m = (Movimiento) o;
        return res && m.cifras.equals(cifras) && m.colocadas == colocadas && m.descolocadas == descolocadas;
    }

    @Override
    public int hashCode() {
        return cifras.hashCode();
    }

    @Override
    public String toString() {
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }
}
