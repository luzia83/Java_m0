package org.uma.mbd.mdBusV2.buses;

public class Bus implements Comparable<Bus> {
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

    @Override
    public int compareTo(Bus bus) {
        int res = Integer.compare(codLinea, bus.getCodLinea());
        if (res == 0) {
            res = Integer.compare(codBus, bus.getCodBus());
        }
        return res;
        /*int res;
        if (codLinea < bus.codLinea) {
            res = -1;
        }
        else if (codLinea > bus.codLinea) {
            res = 1;
        }
        else {
            if (codBus < bus.codBus) {
                res = -1;
            }
            else if (codBus > bus.codBus) {
                res = 1;
            }
            else {
                res = 0;
            }
        }
        return res;*/
    }

    public String toString() {
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }
}
