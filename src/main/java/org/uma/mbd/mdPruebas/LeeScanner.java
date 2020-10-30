package org.uma.mbd.mdPruebas;

import java.io.*;
import java.util.*;

public class LeeScanner {
    public static void main(String[] args) throws FileNotFoundException {
        String fichero = "personas.txt";
        try (Scanner sc = new Scanner(new File(fichero))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}