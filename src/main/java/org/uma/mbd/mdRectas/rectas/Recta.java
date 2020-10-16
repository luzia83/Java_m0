package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Vector v, Punto p) {
        direccion = v;
        pto = p;
    }

    public Recta(Punto p1, Punto p2) {
        direccion = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY());
        pto = p1;
    }

    public boolean pasaPor(Punto p) {
        Vector v = new Vector(p, pto);
        return v.paraleloA(direccion);
    }

    public boolean paralelaA(Recta r) {
        return this.direccion.paraleloA(r.direccion);
    }

    public Recta paralelaPor(Punto p) {
        Recta r = new Recta(direccion, p);
        return r;
    }

    public Recta perpendicularPor(Punto p) {
        Recta r = new Recta(direccion.ortogonal(), p);
        return r;
    }

    public Punto interseccionCon(Recta r) {
        double d = direccion.getComponenteX()*r.direccion.getComponenteY() - r.direccion.getComponenteX()*direccion.getComponenteY();
        double d1 = direccion.getComponenteX()*pto.getY() - direccion.getComponenteY()*pto.getX();
        double d2 = r.direccion.getComponenteX()*r.pto.getY() - r.direccion.getComponenteY()*r.pto.getX();

        if (d == 0) {
            throw new RuntimeException("Rectas paralelas");
        }
        double x = (d1*r.direccion.getComponenteX() - d2*direccion.getComponenteX())/d;
        double y = (d1*r.direccion.getComponenteY() - d2*direccion.getComponenteY())/d;
        Punto p = new Punto(x, y);
        return p;
    }

    public double distanciaDesde(Punto p) {
        Recta r = new Recta(direccion.ortogonal(), p);
        Punto pCorte = interseccionCon(r);
        return p.distancia(pCorte);
    }
    @Override
    public String toString() {
        return "R(" + direccion + "," + pto + ")";
    }
}
