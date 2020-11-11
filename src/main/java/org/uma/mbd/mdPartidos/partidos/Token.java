package org.uma.mbd.mdPartidos.partidos;

import org.apache.commons.collections.iterators.CollatingIterator;

import java.util.*;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token (Partido p, double r) {
        partido = p;
        ratio = r;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public int compareTo(Token token) {
        //primero se compara por ratio y despues por nombre de partido
        int resultado = Double.compare(token.getRatio(), this.getRatio());
        if (resultado == 0) {
            resultado = getPartido().getNombre().compareTo(token.getPartido().getNombre());
        }
        return resultado;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc) {
        Iterator<Token> iter = tks.iterator();
        int contador = 0;
        Set<Token> tokens = new HashSet<>();
        while (iter.hasNext() && contador < numEsc) {
            tokens.add(iter.next());
        }
        return tokens;
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks) {
        Map<Partido, Integer> map = new HashMap<>();
        for (Token token : tks) {
            if (map.containsKey(token.getPartido())) {
                int valor = map.get(token.getPartido());
                map.replace(token.getPartido(), valor+1);
            }
            else {
                map.put(token.getPartido(), 1);
            }
        }
        return map;
    }
}
