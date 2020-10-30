package org.uma.mbd.mdBancoV1L.banco;

public class Cuenta {
    private String titular;
    private double saldo;
    private int numCuenta;

    public Cuenta(String t, double s, int n) {
        titular = t;
        saldo = s;
        numCuenta = n;
    }

    public Cuenta(String t, int n) {
        this(t, 0, n);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void ingreso(double cant) {
        saldo += cant;
    }

    public void debito(double cant) {
        saldo -= cant;
    }

    @Override
    public String toString() {
        return "[(" + titular + "," + numCuenta + ") -> " + saldo + "]";
    }
}
