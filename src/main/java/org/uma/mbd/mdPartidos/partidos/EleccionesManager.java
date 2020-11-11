package org.uma.mbd.mdPartidos.partidos;

import java.io.*;
import java.util.Map;

public class EleccionesManager {
    private String [] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada, fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones) {
        this.elecciones = elecciones;
    }

    public EleccionesManager setDatos(String [] datos) {
        this.datos = datos;
        return this;
    }

    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
    }

    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }

    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify() {
        if (datos == null && fEntrada.isEmpty()) {
            throw new EleccionesException("No se ha definido ninguna entrada de datos");
        }
        else if (fSalida.isEmpty() && consola == false) {
            throw new EleccionesException("No se ha definido ninguna salida de datos");
        }
        else if (cs == null) {
            throw new EleccionesException("No se ha definido ningun criterio de selección");
        }
        else if (numEsc <= 0) {
            throw new EleccionesException("El número de escaños no es valido");
        }
    }

    public void build() throws IOException {
        verify();
        if (datos != null) {
            elecciones.leeDatos(datos);
        }
        else {
            elecciones.leeDatos(fEntrada);
        }
        Map<Partido, Integer> map = elecciones.generaResultados(cs, numEsc);
        elecciones.presentaResultados(fSalida, map);
    }
}
