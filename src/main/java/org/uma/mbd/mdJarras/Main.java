package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args) {
        // Ejercicio Jarras
        Jarra j1 = new Jarra(5);
        Jarra j2 = new Jarra(7);

        j1.llena();
        j2.llenaDesde(j1);
        j1.llena();
        j2.llenaDesde(j1);
        j2.vacia();
        j2.llenaDesde(j1);
        j1.llena();
        j2.llenaDesde(j1);
        System.out.println(j1);
        System.out.println(j2);

        //Ejercicio Mesa
        Mesa mesa = new Mesa(5, 7);
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        mesa.vaciaB();
        mesa.vuelcaAsobreB();
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        System.out.println(mesa);
    }
}
