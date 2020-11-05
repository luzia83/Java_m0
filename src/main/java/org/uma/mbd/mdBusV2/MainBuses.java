package org.uma.mbd.mdBusV2;

import org.uma.mbd.mdBusV2.buses.*;
import org.uma.mbd.mdBusV2.buses.OrdBus;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;

public class MainBuses {
    public static void main(String [] args) {
        Servicio servicio = new Servicio("Malaga");
        Comparator<Bus> cb = new OrdBus();
        //Comparator<Bus> cb2 =  new OrdLinea();
        Comparator<Bus> cb2 = (b1,b2) -> Integer.compare(b1.getCodLinea(), b2.getCodLinea());
        Comparator<Bus> cb3 = cb2.thenComparing(cb);
        try {
        	System.out.println(servicio.getCiudad());
            servicio.leeBuses("recursos/mdBusV2/buses.txt");
            Criterio cr1 = new PorLinea(21);
            servicio.guarda("recursos/mdBusV2/linea21.txt", cb3, cr1);
            servicio.guarda(new PrintWriter(System.out,true), cb3, cr1);
            Criterio cr2 = new EnMatricula("29");
            servicio.guarda("recursos/mdBusV2/contiene29.txt", cb3, cr2);
            servicio.guarda(new PrintWriter(System.out,true), cb3, cr2);
        } catch (FileNotFoundException e) {
            System.err.println("No existe el fichero de entrada");
        }
    }
}
