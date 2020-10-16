package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    int contenido, capacidad;

    public Jarra(int cap){
        capacidad = cap;
        contenido = 0;
    }

    public void llena(){
        contenido = capacidad;
    }

    public void vacia(){
        contenido = 0;
    }

    public void llenaDesde(Jarra j){
        if ((j.contenido + this.contenido) >= this.capacidad) {
            j.contenido = j.contenido - (this.capacidad - this.contenido);
            this.llena();
        }
        else{
            this.contenido += j.contenido;
            j.vacia();
        }
    }

    public String toString() {
        return "Jarra( cap. " + capacidad + ", cont. " + contenido + ")";
    }
}
