package org.uma.mbd.mdPruebas;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
public class LeeURLFile {
    public static void main(String[] args) throws IOException {
        String urlPath =
                "http://datosabiertos.malaga.eu/recursos/transporte" +
"/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";
        URL url = new URL(urlPath);
        try (InputStream fs = url.openStream();
             Scanner sc = new Scanner(fs)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}