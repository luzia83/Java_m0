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

    public  void cerrarCuenta(int nc) {
        int pos = posicionCuenta(nc);
        cuentas.remove(pos);
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

    public void ingreso(int nc, double cantidad) {
        int pos = posicionCuenta(nc);
        cuentas.get(pos).ingreso(cantidad);
    }

    public double debito(int nc, double cantidad) {
        int pos = posicionCuenta(nc);
        double real = Math.min(cantidad, cuentas.get(pos).getSaldo());
        cuentas.get(pos).debito(real);
        return real;
    }

    public double saldo(int nc) {
        int pos = posicionCuenta(nc);
        return cuentas.get(pos).getSaldo();
    }

    public double transferencia(int nco, int ncd, double cantidad) {
        int pos = posicionCuenta(ncd); // antes de sacar el dinero hay que comprobar que existe la cuenta destino
        double real = debito(nco, cantidad);
        ingreso(ncd, real);
        return real;
    }

    @Override
    public String toString() {
        String salida = nombre + " : [";
        for (int i = 0; i < cuentas.size(); i++) {
            salida += cuentas.get(i);
            if (i < cuentas.size()-1) {
                salida += " ";
            }
        }
        salida += "]";
        return salida;
    }
}
