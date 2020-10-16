package org.uma.mbd.mdNPI.NPI;

public class NPI {
    private double x, y, z, t;

    public NPI() {
        x = 0;
        y = 0;
        z = 0;
        t = 0;
    }

    public void entra(double v) {
        t = z;
        z = y;
        y = x;
        x = v;
    }

    public void suma() {
        x = y + x;
        y = z;
        z = t;
    }

    public void resta() {
        x = y - x;
        y = z;
        z = t;
    }

    public void multiplica() {
        x = y * x;
        y = z;
        z = t;
    }

    public void divide() {
        x = y / x;
        y = z;
        z = t;
    }
     public double getResultado() {
        return x;
     }

     public String toString() {
        return "NPI( x = " + x + ", y = " + y + ", z = " + z + ", t = " + t + " )";
     }
}
