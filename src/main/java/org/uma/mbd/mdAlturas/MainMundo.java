package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.*;

import java.io.FileNotFoundException;
import java.util.List;

public class MainMundo {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo mundo = new Mundo();

        mundo.leePaises("recursos/mdAlturas/alturas.txt");

        double altura = 1.77;
        Seleccion sel1 = new MayoresQue(altura);
        List<Pais> paisesAltos = mundo.selecciona(sel1);
        System.out.println("Paises con altura media mayor que " + altura);
        for(Pais pais : paisesAltos) {
            System.out.println(pais);
        }
        System.out.println();

        Seleccion sel2 = new MenoresQue(altura);
        List<Pais> paisesBajos = mundo.selecciona(sel2);
        System.out.println("Paises con altura media menor que " + altura);
        for(Pais pais : paisesBajos) {
            System.out.println(pais);
        }
        System.out.println();

        Seleccion sel3 = new EnContinente("Europe");
        List<Pais> paisesEuropa = mundo.selecciona(sel3);
        System.out.println("Paises de Europa");
        for(Pais pais : paisesEuropa) {
            System.out.println(pais);
        }
    }
}
