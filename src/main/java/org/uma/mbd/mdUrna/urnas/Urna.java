package org.uma.mbd.mdUrna.urnas;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    static public enum ColorBola{Blanca, Negra};

    private int nBlancas, nNegras;
    private static Random alea = new Random();

    public Urna(int nB, int nN) {
        if (nB < 0 || nN < 0) {
            throw new IllegalArgumentException("El nº de bolas no puede ser negativo!");
        }
        nBlancas = nB;
        nNegras = nN;
    }

    public int totalBolas() {
        return nBlancas + nNegras;
    }

    public void ponerBlanca() {
        nBlancas++;
    }

    public void ponerNegra() {
        nNegras++;
    }

    public ColorBola sacaBola() {
        ColorBola bolaSacada = null;

        if (totalBolas() == 0) {
            throw new NoSuchElementException("No hay bolas en la urna!");
        }
        int i = 1 + alea.nextInt(totalBolas());
        if (i <= nBlancas) {
            bolaSacada = ColorBola.Blanca;
            nBlancas--;
        } else {
            bolaSacada = ColorBola.Negra;
            nNegras--;
        }
        return bolaSacada;
    }
}
