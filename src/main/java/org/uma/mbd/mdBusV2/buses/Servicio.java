package org.uma.mbd.mdBusV2.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private String ciudad;
    private TreeSet<Bus> buses;

    public Servicio(String c) {
        ciudad = c;
        buses = new TreeSet<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public TreeSet<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leeBuses(sc);
        }
    }

    public void leeBuses(Scanner sc) {
        while (sc.hasNextLine()) {
            String datosBus = sc.nextLine();
            try (Scanner scb = new Scanner(datosBus)){
                scb.useDelimiter(",");
                int cb = scb.nextInt();
                String m = scb.next();
                int cl = scb.nextInt();
                Bus bus = new Bus(cb, m);
                bus.setCodLinea(cl);
                buses.add(bus);
                //System.out.println("Bus añadido " + bus);
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Dato no numérico en " + datosBus);
            } catch(NoSuchElementException e) {
                System.out.println("ERROR: Falta algún dato en " + datosBus);
            }
        }
    }

    public Set<Bus> filtra(Criterio criterio, Comparator<Bus> cb) {
        Set<Bus> listaBus = new TreeSet<>();
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                listaBus.add(bus);
            }
        }
        return listaBus;
    }

    public void guarda(String file, Comparator<Bus> cb, Criterio criterio) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, cb, criterio);
        }
    }

    public void guarda(PrintWriter pw, Comparator<Bus> cb, Criterio criterio) {
        pw.println(criterio);
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                pw.println(bus);
            }
        }
    }
}
