package org.uma.mbd.mdBancoV1L.banco;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    private static final int PRIMER_NUM_CTA = 1001;
    private String nombre;
    private int snc;
    private List<Cuenta> cuentas;

    public Banco(String nom) {
        nombre = nom;
        snc = PRIMER_NUM_CTA;
        cuentas = new LinkedList<>();
    }

    public int abrirCuenta(String nCliente, double sal) {
        Cuenta cta = new Cuenta(nCliente, sal, snc);
        int nCuenta = snc;
        snc++;
        cuentas.add(cta);
        return nCuenta;
    }

    public int abrirCuenta(String nCliente) {
        return abrirCuenta(nCliente, 0);
    }

    private int posicionCuenta(int nc) {
        int pos = 0;
        while (pos < cuentas.size() && cuentas.get(pos).getNumCuenta() != nc) {
            pos++;
        }
        if (pos == cuentas.size()) {
            throw new RuntimeException("La cuenta " + nc + " no existe");
        }
        return pos;
    }

    public void ingreso(int s) {

    }
}
