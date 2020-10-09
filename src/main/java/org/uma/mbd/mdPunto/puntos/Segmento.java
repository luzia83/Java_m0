package org.uma.mbd.mdPunto.puntos;

public class Segmento {
    private Punto origen, extremo;
    public Segmento(Punto or, Punto ex){
        origen = or;
        extremo = ex;
    }
    public void trasladar(double a, double b){
        origen.trasladar(a, b);
        extremo.trasladar(a, b);
    }
    public double longitud(){
        return origen.distancia(extremo);
    }
    @Override
    public String toString(){
        return "S(" + origen + ", " + extremo + ")";
    }
}
