package org.uma.mbd.mdBusV2.buses;

import java.util.Optional;

public class PorLinea implements Criterio {
    private int linea;

    public PorLinea(int cl) {
        linea = cl;
    }

    public boolean esSeleccionable(Bus bus) {
        Optional<Bus> ob = Optional.of(bus);
        if (ob.isPresent()) {
            return linea == bus.getCodLinea();
        }
        else {
            return false;
        }
    }

    public String toString() {
        return  "Autobuses de la linea " + linea;
    }
}
