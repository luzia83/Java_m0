package org.uma.mbd.mdTren.trenes;

import java.util.ArrayList;
import java.util.List;

public class Tren {
    private List<Vagon> vagones;

    public Tren(int nVagones, int capacidad) {
        vagones = new ArrayList<Vagon>();
        if (nVagones == 0) {
            throw new RuntimeException("El numero de vagones no puede ser 0");
        }
        for (int i = 0; i < nVagones; i++) {
            Vagon vagon = new Vagon(capacidad);
            vagones.add(vagon);
        }
    }

    public void carga(int ton) {
        int nVagon = 0;
        int restoTon = ton;
        while (restoTon > 0 && nVagon < vagones.size()) {
            Vagon vagon = vagones.get(nVagon);
            restoTon = vagon.carga(restoTon);
            vagones.set(nVagon, vagon);
            nVagon++;
        }
        while (restoTon > 0) {
            Vagon vagon = new Vagon(vagones.get(0).getCapacidad());
            restoTon = vagon.carga(restoTon);
            vagones.add(vagon);
        }
    }

    public void gasta(int ton) {
        int nVagon = 0;
        int restoTon = ton;
        while (restoTon > 0 && nVagon < vagones.size() ) {
            Vagon vagon = vagones.get(nVagon);
            restoTon = vagon.descarga(restoTon);
            vagones.set(nVagon, vagon);
            nVagon++;
        }
        if (restoTon > 0) {
            throw new IllegalArgumentException("El numero de toneladas es mayor que el valor permitido");
        }
    }

    public void optimiza() {
        for (int nVagon = 0; nVagon < vagones.size() ; nVagon++) {
            if (vagones.get(nVagon).getCarga() == 0) {
                vagones.remove(vagones.get(nVagon));
            }
        }
    }
    @Override
    public String toString() {
        String tren = "Tren[";
        for (int nVagon = 0; nVagon < vagones.size() ; nVagon++) {
            tren += vagones.get(nVagon).toString();
            if (nVagon < vagones.size() - 1) {
                tren += ",";
            }
        }
        tren += "]";
        return tren;
    }
}
