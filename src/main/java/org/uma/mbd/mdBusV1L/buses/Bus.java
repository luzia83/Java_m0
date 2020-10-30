package org.uma.mbd.mdBusV1L.buses;

public class Bus {
    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus(int cb, String m) {
        codBus = cb;
        matricula = m;
    }

    public void setCodLinea(int cl) {
        codLinea = cl;
    }

    public int getCodBus() {
        return codBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public boolean equals(Bus bus) {
        return (codBus == bus.codBus && matricula.toUpperCase() == bus.matricula.toUpperCase());
    }

    @Override
    public int hashCode() {
        return codBus;
    }

    public String toString() {
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }
}
