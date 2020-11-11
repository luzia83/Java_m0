package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public interface CriterioSeleccion {
    Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc);
}
