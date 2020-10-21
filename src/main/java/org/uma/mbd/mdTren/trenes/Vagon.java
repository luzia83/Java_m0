package org.uma.mbd.mdTren.trenes;

public class Vagon {
    private int capacidad;
    private int carga;

    public Vagon(int capacidad) {
        this.capacidad = capacidad;
        this.carga = 0;
    }

    public int carga(int ton) {
        if (carga + ton > capacidad) {
            int aux = (carga + ton - capacidad);
            carga = capacidad;
            return aux;
        }
        else {
            carga += ton;
            return 0;
        }
    }

    public int descarga(int ton) {
        if (ton < carga) {
            carga -= ton;
            return 0;
        }
        else {
            int aux = ton - carga;
            carga = 0;
            return aux;
        }
    }

    public int getCarga() {
        return carga;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "V(" + capacidad + "/" + carga + ")";
    }
}
