package org.uma.mbd.mdBusV1L.buses;

import java.util.Optional;

public class EnMatricula implements Criterio {
    private String matricula;

    public EnMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean esSeleccionable(Bus bus) {
        Optional<Bus> ob = Optional.of(bus);
        if (ob.isPresent()) {
            return bus.getMatricula().toUpperCase().contains(matricula.toUpperCase());
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Autobuses cuya matricula contiene " + matricula;
    }
}
