package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion {
    private static String texto;

    public EnContinente(String t) {
        texto = t;
    }

    public boolean test(Pais pais) {
        return pais.getContinente().contains(texto);
    }
}
