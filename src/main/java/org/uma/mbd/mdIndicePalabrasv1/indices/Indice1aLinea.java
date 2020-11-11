package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Indice1aLinea extends Indice {
    private Map<String, Integer> palabras;

    public Indice1aLinea() {
        super();
        this.palabras = new TreeMap<>();
    }

    @Override
    public void agregarLinea(String texto) {
        super.agregarLinea(texto);
        palabras.clear();
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSignif = new TreeSet<>();
        for (String ns : noSignificativas) {
            noSignif.add(ns.toLowerCase());
        }
        int numLinea = 1;
        for (String linea : texto) {
            try (Scanner scanner = new Scanner(linea)) {
                scanner.useDelimiter(delimitadores);
                while (scanner.hasNext()) {
                    String palabra = scanner.next().toLowerCase();
                    if (!noSignif.contains(palabra) && !palabras.containsKey(palabra)) {
                        palabras.put(palabra, numLinea);
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Error leyendo el texto");
            } ;
            numLinea++;
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for(Map.Entry<String, Integer> palabra : palabras.entrySet()) {
            System.out.println(palabra.getKey() + " " + palabra.getValue());
        }
    }
}
