package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.NPI.NPI;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        NPI npi = new NPI();
        npi.entra(3);
        npi.entra(6);
        npi.entra(2);
        npi.resta();
        npi.multiplica();
        npi.entra(5);
        npi.suma();
        System.out.println("Resultado: " + npi.getResultado());

        //Ejercicio 2
        NPI npi2 = new NPI();
        npi2.entra(3);
        npi2.entra(6);
        npi2.entra(2);
        npi2.resta();
        npi2.multiplica();
        npi2.entra(5);
        npi2.suma();
        npi2.entra(2);
        npi2.entra(7);
        npi2.suma();
        npi2.entra(5);
        npi2.divide();
        npi2.suma();
        System.out.println("Resultado: " + npi2.getResultado());
    }
}
