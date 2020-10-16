package org.uma.mbd.mdLibreria;

import org.uma.mbd.mdLibreria.libreria.Libreria;

public class PruebaLibreria {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        libreria.addLibro("george orwell", "1984", 8.20);
        libreria.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
        libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
        libreria.addLibro("Ray Bradbury","Fahrenheit451",7.40);
        libreria.addLibro("Alex Huxley", "Un Mundo Feliz",6.50);
        libreria.addLibro("Isaac Asimov", "La Fundación",7.30);
        libreria.addLibro("William Gibson", "Neuromante", 8.30);
        libreria.addLibro("Isaac Asimov","SegundaFundación",8.10);
        libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
        libreria.addLibro("George Orwell", "1984", 6.20);
        libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
    }
}
