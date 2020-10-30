package org.uma.mbd.mdBusV1L;

import org.uma.mbd.mdBusV1L.buses.Bus;
import org.uma.mbd.mdBusV1L.buses.Servicio;

import java.io.FileNotFoundException;
import java.util.List;

public class MainPrueba {
    public static void main(String[] args) throws FileNotFoundException {
        Servicio servicio;
        List<Bus> buses;

        servicio = new Servicio("Málaga");
        servicio.leeBuses("recursos/mdBusV1L/buses.txt");

        buses = servicio.getBuses();
        System.out.println(servicio.getCiudad());
        for(Bus bus: buses) {
            System.out.println(bus);
        }
    }
}
