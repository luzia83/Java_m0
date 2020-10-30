package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion {
    private static double alturaMin;

    public MayoresQue(double am) {
        alturaMin = am;
    }

    public boolean test(Pais pais) {
        return pais.getAltura() >= alturaMin;
    }
}
