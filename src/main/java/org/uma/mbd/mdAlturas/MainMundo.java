package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.MayoresQue;
import org.uma.mbd.mdAlturas.alturas.Mundo;
import org.uma.mbd.mdAlturas.alturas.Pais;
import org.uma.mbd.mdAlturas.alturas.Seleccion;

import java.io.FileNotFoundException;
import java.util.List;

public class MainMundo {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo mundo = new Mundo();

        mundo.leePaises("recursos/mdAlturas/alturas.txt");
        for(Pais pais : mundo.getPaises()) {
            System.out.println(pais);
        }
        double alt1 = 1.77;
        Seleccion sel1 = new MayoresQue(alt1);
        List<Pais> paisesAltos = mundo.selecciona(sel1);
        System.out.println("Paises con altura mayor que " + alt1);
        for(Pais pais : paisesAltos) {
            System.out.println(pais);
        }
    }
}
