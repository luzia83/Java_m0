package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion{
    private static double alturaMax;

    public MenoresQue(double am) {
        alturaMax = am;
    }

    public boolean test(Pais pais) {
        return pais.getAltura() <= alturaMax;
    }
}
