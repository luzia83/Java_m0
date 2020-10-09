package org.uma.mbd.mdPunto;

import org.uma.mbd.mdPunto.puntos.Punto;
import org.uma.mbd.mdPunto.puntos.Segmento;

public class Main {
    public static void main(String[] args) {
        Punto pto = new Punto(3, 5);
        System.out.println(pto);
        pto.trasladar(2,-3);
        System.out.println(pto);

        Punto pto2 = new Punto(-1, 2);
        Segmento s = new Segmento(pto, pto2);
        System.out.println(s);
        System.out.println(s.longitud());

    }
}
