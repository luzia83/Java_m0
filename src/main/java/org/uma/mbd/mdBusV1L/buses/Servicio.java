package org.uma.mbd.mdBusV1L.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String c) {
        ciudad = c;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
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

    public List<Bus> filtra(Criterio criterio) {
        List<Bus> listaBus = new ArrayList<>();
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                listaBus.add(bus);
            }
        }
        return listaBus;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio) {
        pw.println(criterio);
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                pw.println(bus);
            }
        }
    }
}
