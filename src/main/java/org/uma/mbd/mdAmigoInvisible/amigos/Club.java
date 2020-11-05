package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Club {
    protected List<Persona> socios;

    public Club() {
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(fEntrada))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                leeSocios(linea, delim);
            }
        }
    }

    private void leeSocios(String linea, String delim) {
        try(Scanner sc = new Scanner(linea)) {
            sc.useDelimiter(delim); //("[ ,;-]+");
            while (sc.hasNext()) {
                String socio = sc.next();
                creaSocioDesdeString(socio);
            }
        } catch(NoSuchElementException e) {
            System.out.println("ERROR: Faltan datos en " + linea);
        }
    }

    protected void creaSocioDesdeString(String nombre) {
        Persona socio = new Persona(nombre);
        socios.add(socio);
    }

    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>();
        for(int i = 0; i < socios.size(); i++) {
            posAmigos.add(i, (Integer)i);
        }
        //desordenada indica si estan todos los elementos desordenados
        while (hayCoincidencias(posAmigos)) {
            //mientras no este desordenada barajamos
            Collections.shuffle(posAmigos);
        }
        // Ya tenemos la lista desordenada
        for (int pos = 0; pos < socios.size(); pos++) {
            Persona socio = socios.get(pos);
            Persona amigo = socios.get(posAmigos.get(pos));
            socios.get(pos).setAmigo(amigo);
        }
    }

    private static boolean hayCoincidencias(List<Integer> posAmigos) {
        //ordElemento indica si el elemento esta en su misma posicion
        boolean ordElemento = false;
        int i = 0;
        while(!ordElemento && i < posAmigos.size()) {
            ordElemento = (Integer)i == posAmigos.get(i);
            i++;
        }
        //Si recorremos la lista entera significa que ningun elemento esta en su posicion
        return ordElemento;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        if (fSalida == "System.out") {
            try (PrintWriter pw = new PrintWriter(System.out,true)) {
                presentaAmigos(pw);
            }
        } else {
            try (PrintWriter pw = new PrintWriter(fSalida)) {
                presentaAmigos(pw);
            }
        }
    }

    private void presentaAmigos(PrintWriter pw) {
        Collections.sort(socios);
        for (Persona p: socios) {
            pw.println(p);
        }
        /*List<Persona> lista = new ArrayList<>();
        lista.addAll(socios);
        Collections.sort(lista);
        for(Persona p: lista) {
            pw.println(p);
        }*/
    }
}
