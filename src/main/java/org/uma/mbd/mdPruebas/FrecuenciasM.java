package org.uma.mbd.mdPruebas;

import java.util.*;

public class FrecuenciasM {
    public static void main(String[] args) {
        Comparator<String> oli = Comparator.<String>naturalOrder().reversed();
        Comparator<String> oli2 = Comparator.comparingInt(String::length);
        Map<String, Integer> frecs = new TreeMap<>(oli2.thenComparing(oli));
        //Map<String, Integer> frecs = new TreeMap<>(oli);
        //Map<String, Integer> frecs = new HashMap<>();
        for(String arg: args) {
            int frec = frecs.getOrDefault(arg, 0);
            frecs.put(arg, frec+1);
        }
        for(Map.Entry<String,Integer> par: frecs.entrySet()) {//for(String key: frecs.keySet()) {
            //int frec = frecs.get(key);
            char[] barra = new char[par.getValue()]; //char[] barra = new char[frec];
            Arrays.fill(barra, '*');
            System.out.println(par.getKey());
        }
    }
}
