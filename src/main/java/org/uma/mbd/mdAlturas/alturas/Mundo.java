package org.uma.mbd.mdAlturas.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mundo {
    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<Pais>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leePaises(sc);
        }
    }

    public void leePaises(Scanner sc) {
        while (sc.hasNextLine()) {
            String datosPais = sc.nextLine();
            try (Scanner sc1 = new Scanner(datosPais)) {
                sc1.useDelimiter(",");
                sc1.useLocale(Locale.ENGLISH);
                String p = sc1.next();
                String c = sc1.next();
                double a = sc1.nextDouble();
                Pais pais = new Pais(p, c, a);
                paises.add(pais);
            } catch (InputMismatchException e) {
                System.out.println("Error leyendo pais " + datosPais);
            } catch (NoSuchElementException e) {
                System.out.println("Datos incompletos en " + datosPais);
            }
        }
    }

    public List<Pais> selecciona(Seleccion sel) {
        List<Pais> listaPaises = new ArrayList<>();
        for(Pais pais : paises) {
            if (sel.test(pais)) {
                listaPaises.add(pais);
            }
        }
        return listaPaises;
    }
}
