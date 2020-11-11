package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Proporcional implements CriterioSeleccion {

    public Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        int totalVotos = 0;
        for (Partido partido: partidos) {
            totalVotos += partido.getnVotos();
        }
        double vpe = totalVotos/numEsc;
        Set<Token> tokens = new HashSet<>();
        for (Partido partido: partidos) {
            for (int i = 1; i <= numEsc; i++) {
                Token token = new Token(partido, partido.getnVotos() - (i-1)*vpe);
                tokens.add(token);
            }
        }
        return tokens;
    }

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Comparator<Token> comp = (t1, t2) -> t1.compareTo(t2);
        Set<Token> tokens = creaTokens(partidos, numEsc);
        Set<Token> tokensOrd = new TreeSet<>(comp);
        tokensOrd.addAll(tokens);
        Set<Token> selTokens = new TreeSet<>();
        Iterator<Token> iterator = tokensOrd.iterator();
        for (int i = 1; i <= numEsc; i++) {
            Token token = iterator.next();
            selTokens.add(token);
        }
        Map<Partido, Integer> map = new HashMap<>();
        for (Token token: selTokens) {
            if (map.containsKey(token.getPartido())) {
                int old = map.get(token.getPartido());
                map.replace(token.getPartido(), old+1);
            }
            else {
                map.put(token.getPartido(), 1);
            }
        }
        return map;
    }
}
