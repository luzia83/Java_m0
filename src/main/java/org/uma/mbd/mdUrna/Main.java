package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urnas.Urna;

import java.util.NoSuchElementException;

import static org.uma.mbd.mdUrna.urnas.Urna.*;

public class Main {
    public static void main(String[] args) {
        try {
            int nBlancas = Integer.parseInt(args[0]);
            int nNegras = Integer.parseInt(args[1]);
            Urna urna = new Urna(nBlancas, nNegras);
            if (urna.totalBolas() == 0) {
                throw new RuntimeException("No hay bolas para sacar de la urna.");
            }
            while (urna.totalBolas() > 0) {

                if (urna.totalBolas() == 1) {
                    ColorBola cb = urna.sacaBola();
                    System.out.println(cb.toString());
                } else {
                    ColorBola cb1 = urna.sacaBola();
                    //System.out.println(cb1.toString());
                    ColorBola cb2 = urna.sacaBola();
                    //System.out.println(cb2.toString());

                    if (cb1 == cb2) {
                        urna.ponerBlanca();
                        System.out.println("Iguales");
                    } else {
                        urna.ponerNegra();
                    }
                    System.out.println();
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: deben ponerse dos argumentos");
        }
        catch (NumberFormatException e) {
            System.out.println("ERROR: los argumentos deben ser numericos");
        }
        catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (NoSuchElementException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
