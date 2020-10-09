package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;

public class Main {
    public static void main(String[] args) {
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

    }
}
