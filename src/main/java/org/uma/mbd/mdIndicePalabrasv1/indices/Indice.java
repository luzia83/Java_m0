package org.uma.mbd.mdIndicePalabrasv1.indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract public class Indice {
    List<String> texto;

    public Indice() {
        this.texto = new ArrayList<>();
    }

    public void agregarLinea(String texto) {
        this.texto.add(texto);
    }

    abstract public void resolver(String delimitadores, Collection<String> noSignificativas);

    abstract public void presentarIndiceConsola();
}
