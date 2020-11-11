package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.*;

public class IndicePosicionesEnLineas extends Indice{
    private Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas() {
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
                int posEnLinea = 1;
                while (scanner.hasNext()) {
                    String palabra = scanner.next().toLowerCase();
                    if (!noSignif.contains(palabra) && !palabras.containsKey(palabra)) {
                        Set<Integer> posiciones = new HashSet<>();
                        posiciones.add((Integer) posEnLinea);
                        Map<Integer, Set<Integer>> numLineas = new TreeMap<>();
                        numLineas.put((Integer) numLinea, posiciones);
                        palabras.put(palabra, numLineas);
                    }
                    else if (palabras.containsKey(palabra)) {
                        Map<Integer, Set<Integer>> numLineas = palabras.get(palabra);
                        if (!numLineas.containsKey(numLinea)) {
                            Set<Integer> posiciones = new HashSet<>();
                            posiciones.add(posEnLinea);
                            numLineas.put(numLinea, posiciones);
                            palabras.put(palabra, numLineas);
                        }
                        else {
                            Set<Integer> posiciones = numLineas.get(numLinea);
                            posiciones.add(posEnLinea);
                            numLineas.put(numLinea, posiciones);
                            palabras.put(palabra, numLineas);
                        }
                    }
                    posEnLinea++;
                }
            } catch (RuntimeException e) {
                System.out.println("Error leyendo el texto");
            } ;
            numLinea++;
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for(Map.Entry<String, Map<Integer, Set<Integer>>> palabra : palabras.entrySet()) {
            System.out.println(palabra.getKey() + " " + palabra.getValue());
        }
    }
}
