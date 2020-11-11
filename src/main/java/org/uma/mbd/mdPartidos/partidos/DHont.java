package org.uma.mbd.mdPartidos.partidos;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DHont extends DHontSimple {
    private double minPor;

    public DHont(double mp) {
        if (mp < 0 || mp >= 15) {
            throw new EleccionesException("Porcentaje mínimo no válido");
        }
        minPor = mp;
    }

    @Override
    public Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        Set<Token> tokens = new HashSet<>();
        for (Partido partido: partidos) {
            for (int i = 1; i <= numEsc; i++) {
                double porcent = partido.getnVotos()/i;
                if (porcent >= minPor) {
                    Token token = new Token(partido, partido.getnVotos() / i);
                    tokens.add(token);
                }
            }
        }
        return tokens;
    }

}
