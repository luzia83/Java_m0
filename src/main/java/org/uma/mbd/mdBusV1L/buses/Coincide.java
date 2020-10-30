package org.uma.mbd.mdBusV1L.buses;

import java.util.Optional;

public class Coincide implements Criterio {
    private Bus bus;

    public Coincide(Bus bus) {
        this.bus = bus;
    }

    public boolean esSeleccionable(Bus bus) {
        Optional<Bus> ob = Optional.of(bus);
        if (ob.isPresent()) {
            return this.bus.equals(bus);
        }
        else {
            return false;
        }
    }

    public String toString() {
        return bus.toString();
    }
}
