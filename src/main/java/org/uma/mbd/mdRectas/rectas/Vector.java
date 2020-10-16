package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;

    public Vector(double x, double y) {
        extremo = new Punto(x, y);
    }

    public Vector(Punto p) {
        extremo = p;
    }

    public Vector(Punto p1, Punto p2) {
        p2.trasladar(p1.getX(), p1.getY());
        extremo = p2;
    }

    public double getComponenteX() {
        return extremo.getX();
    }

    public double getComponenteY() {
        return extremo.getY();
    }

    public double modulo() {
        Punto eje = new Punto(0,0);
        return extremo.distancia(eje);
    }

    public Vector ortogonal() {
        Vector v = new Vector(-extremo.getY(), extremo.getX());
        return v;
    }

    public boolean paraleloA(Vector v) {
        return ( (this.extremo.getX()*v.extremo.getY()) == (this.extremo.getY()*v.extremo.getX()));
    }

    public Punto extremoDesde(Punto p) {
        Punto p2 = new Punto(extremo.getX(), extremo.getY());
        p2.trasladar(p.getX(), p.getY());
        return p2;
    }
    @Override
    public String toString() {
        return "V(" + extremo.getX() + "," + extremo.getY() + ")";
    }
}
