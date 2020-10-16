package org.uma.mbd.mdJarras.jarras;

public class Mesa {
    private Jarra a, b;

    public Mesa (int capA, int capB) {
        a = new Jarra(capA);
        b = new Jarra(capB);
    }

    public void llenaA(){
        a.llena();
    }

    public void llenaB(){
        b.llena();
    }

    public void vaciaA(){
        a.vacia();
    }

    public void vaciaB() {
        b.vacia();
    }

    public void vuelcaAsobreB(){
        b.llenaDesde(a);
    }

    public void vuelcaBsobreA(){
        a.llenaDesde(b);
    }

    public int getContenidoA(){
        return a.contenido;
    }

    public int getContenidoB(){
        return b.contenido;
    }

    public int getCapacidadA() {
        return a.capacidad;
    }

    public int getCapacidadB() {
        return b.capacidad;
    }

    public int getContenido() {
        return a.contenido + b.contenido;
    }

    public String toString() {
        return "Mesa: " + a.toString() + ", " + b.toString();
    }
}
