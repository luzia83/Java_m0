package org.uma.mbd.mdMasterMindL.masterMindL;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind {
    private List<Movimiento> movimientos;

    public MasterMindMemoria(int tamano) {
        super(tamano);
        movimientos = new ArrayList<>();
    }

    public MasterMindMemoria() {
        super();
        movimientos = new ArrayList<>();
    }

    public Movimiento intento(String cifras) {
        Movimiento movimiento = super.intento(cifras);
        for(Movimiento m : movimientos) {
            if (m.equals(movimiento)) {
                throw new MasterMindException("La combinacion está repetida");
            }
        }
        movimientos.add(movimiento);
        return movimiento;
    }

    public List<Movimiento> movimientos() {
        return movimientos;
    }
}
