package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubParejas extends Club{
    private static Set<Pareja> parejas;

    public ClubParejas() {
        super();
        parejas = new HashSet<>();
    }

    private void leeSocios(String linea, String delim) {
        try(Scanner sc = new Scanner(linea)) {
            sc.useDelimiter(delim);
            while (sc.hasNext()) {
                String socio = sc.next();
                if (socio.contains("-")) {
                    String nombre1 = socio.split("-")[0];
                    String nombre2 = socio.split("-")[1];
                    Pareja pareja = new Pareja(new Persona(nombre1), new Persona(nombre2));
                }
                creaSocioDesdeString(socio);
            }
        } catch(NoSuchElementException e) {
            System.out.println("ERROR: Faltan datos en " + linea);
        }
    }

    protected void creaSocioDesdeString(String nombre) {
        if (nombre.contains("-")) {
            Persona socio1 = new Persona(nombre.split("-")[0]);
            Persona socio2 = new Persona(nombre.split("-")[1]);
            socios.add(socio1);
            socios.add(socio2);
        }
        else {
            Persona socio = new Persona(nombre);
            socios.add(socio);
        }
    }

    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>();
        for(int i = 0; i < socios.size(); i++) {
            posAmigos.add(i, (Integer)i);
        }
        boolean hayParejas = true;
        //desordenada indica si estan todos los elementos desordenados
        while (hayCoincidencias(posAmigos) || hayParejas) {
            while(hayCoincidencias(posAmigos)) {
                //mientras no este desordenada barajamos
                Collections.shuffle(posAmigos);
            }
            // Ya tenemos la lista desordenada
            int pos = 0;
            hayParejas = false;
            while (pos < socios.size() && !hayParejas) {
                //Persona socio = socios.get(posAmigos.get(pos));
                //Persona amigo = new Persona(socio.getNombre());
                Persona socio = socios.get(pos);
                Persona amigo = socios.get(posAmigos.get(pos));
                Pareja pareja = new Pareja(socio, amigo);
                if (parejas.contains(pareja)) {
                    hayParejas = true;
                }
                pos++;
            }
        }
        // Ya tenemos la lista desordenada y sin parejas
        for (int pos = 0; pos < socios.size(); pos++) {
            //Persona socio = socios.get(posAmigos.get(pos));
            //Persona amigo = new Persona(socio.getNombre());
            Persona socio = socios.get(pos);
            Persona amigo = socios.get(posAmigos.get(pos));
            socios.get(pos).setAmigo(amigo);
        }
    }

    private static boolean hayParejas(List<Persona> socios) {
        int pos = 0;
        boolean sonPareja = false;
        while (pos < socios.size() && !sonPareja) {
            Persona socio = socios.get(pos);
            Persona amigo = socio.getAmigo();
            if (amigo == null) {
                break;
            }
            Pareja pareja = new Pareja(socio, amigo);
            if (parejas.contains(pareja)) {
                sonPareja = true;
            }
            pos++;
        }
        return sonPareja;
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
}
