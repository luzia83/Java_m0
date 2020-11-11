package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.*;

public class IndiceLineas extends Indice{
    private Map<String, Set<Integer>> palabras;

    public IndiceLineas() {
        super();
        palabras = new TreeMap<>();
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
                        Set<Integer> numLineas = new HashSet<>();
                        numLineas.add((Integer) numLinea);
                        palabras.put(palabra, numLineas);
                    }
                    else if (palabras.containsKey(palabra)) {
                        Set<Integer> numLineas = palabras.get(palabra);
                        numLineas.add((Integer) numLinea);
                        palabras.put(palabra, numLineas);
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
        for(Map.Entry<String, Set<Integer>> palabra : palabras.entrySet()) {
            System.out.println(palabra.getKey() + " " + palabra.getValue());
        }
    }
}
