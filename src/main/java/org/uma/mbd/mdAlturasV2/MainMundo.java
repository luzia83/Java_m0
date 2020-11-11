package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.*;

import java.io.FileNotFoundException;
import java.util.*;

public class MainMundo {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo mundo = new Mundo();

        mundo.leePaises("recursos/mdAlturas/alturas.txt");

        double altura = 1.00;
        Seleccion sel1 = new MayoresQue(altura);
        List<Pais> paises = mundo.selecciona(sel1);

        Comparator<Pais> ordAltura = (p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());
        SortedSet<Pais> paisOrdAltura = new TreeSet<>(ordAltura);
        paisOrdAltura.addAll(paises);

        System.out.println("Paises ordenados por altura media:");
        for(Pais pais : paisOrdAltura) {
            System.out.println(pais);
        }
        System.out.println();

        Comparator<Pais> ordNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Set<Pais> paisOrdNombre = new TreeSet<>(ordNombre);
        paisOrdNombre.addAll(paises);

        System.out.println("Paises ordenados por nombre:");
        for(Pais pais : paisOrdNombre) {
            System.out.println(pais);
        }
        System.out.println();

        Comparator<Pais> ordContinente = (p1, p2) -> p1.getContinente().compareTo(p2.getContinente());
        Comparator<Pais> ordContNombre = ordContinente.thenComparing(ordNombre);
        Set<Pais> paisOrdContNombre = new TreeSet<>(ordContNombre);
        paisOrdContNombre.addAll(paises);

        System.out.println("Paises ordenados por continente y despues por nombre");
        for(Pais pais : paisOrdContNombre) {
            System.out.println(pais);
        }
        System.out.println();

        Comparator<Pais> ordNombreR = ordNombre.reversed();
        Comparator<Pais> ordContNombreR = ordContinente.thenComparing(ordNombreR);
        Set<Pais> paisOrdContNombreR = new TreeSet<>(ordContNombreR);
        paisOrdContNombreR.addAll(paises);

        System.out.println("Paises ordenados por continente y despues por el nombre al revés" );
        for(Pais pais : paisOrdContNombreR) {
            System.out.println(pais);
        }
        System.out.println();

        Comparator<Pais> ordNatural = (p1, p2)->p1.compareTo(p2);
        Set<Pais> paisOrdNatural = new TreeSet<>(ordNatural);
        paisOrdNatural.addAll(paises);

        System.out.println("Paises ordenados por orden natural:");
        for(Pais pais : paisOrdNatural) {
            System.out.println(pais);
        }
        System.out.println();

        Comparator<Pais> ordContNat = ordContinente.thenComparing(ordNatural);
        Set<Pais> paisOrdContNat = new TreeSet<>(ordContNat);
        paisOrdContNat.addAll(paises);

        System.out.println("Paises ordenados por continente y despues por orden natural: ");
        for(Pais pais : paisOrdContNat) {
            System.out.println(pais);
        }
    }
}
