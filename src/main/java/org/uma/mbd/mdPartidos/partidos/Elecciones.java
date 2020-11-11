package org.uma.mbd.mdPartidos.partidos;

import java.io.*;
import java.util.*;

public class Elecciones {
    private List<Partido> partidos;

     private Partido stringToPartido(String dato) {
        try (Scanner sc = new Scanner(dato)) {
            sc.useDelimiter("[,]+");
            String nombre = sc.next();
            int nVotos = sc.nextInt();
            Partido p = new Partido(nombre, nVotos);
            return p;
        } catch (InputMismatchException e) {
            throw new EleccionesException("Error leyendo partido");
        } catch (NoSuchElementException e) {
            throw new EleccionesException("Datos incompletos en partido");
        }
    }

    public void leeDatos(String [] datos) {
        partidos = new ArrayList<>();
        for (int i = 0; i < datos.length; i++) {
        //for (String dato: datos) {
            Partido p = stringToPartido(datos[i]);
            partidos.add(p);
        }
    }

    public void leeDatos(String nombreFichero) throws IOException {
        partidos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nombreFichero))) {
            String [] lineas = new String[100];
            int i = 0;
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                lineas[i] = linea;
                i++;
            }
            String [] lin = new String[i];
            for (int j = 0; j < lin.length; j++) {
                lin[j] = lineas[j];
            }
            leeDatos(lin);
        }
    }

    public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc) {
        Map<Partido, Integer> map = new HashMap<>();
        map = cs.ejecuta(partidos, numEsc);
        return map;
    }

    public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(nombreFichero)) {
            for (Map.Entry<Partido, Integer> par : map.entrySet()) {
                if (par.getValue() == 0) {
                    pw.println(par.getKey().toString() + " , Sin representación");
                }
                else {
                    pw.println(par.getKey().toString() + " , " + par.getValue());
                }
            }
        }
    }
}
