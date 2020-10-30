package org.uma.mbd.mdTestL;

import org.uma.mbd.mdTestL.tests.TestAsignatura;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PruebaTest {
	static List<String> examenes = List.of(
			"El hombre enmascarado:6+4",
			"La mujer Maravilla:9+1", 
			"El hombre invisible:4+6",
			"Dr. Jekyll y Mr. Hide:5+5", 
			"El increible hombre menguante:7+3",
			"El llanero solitario:7+3", 
			"La chica invisible:8+2",
			"La princesa guerrera:2+8" );

	public static void main(String[] args) throws IOException {
		TestAsignatura poo = new TestAsignatura(
				"Programación Orientada a Objetos", "recursos/mdTestL/alumnos.txt");

		System.out.println("Asignatura: " + poo.getNombre());
		System.out.println("Aprobados en el test: " + poo.aprobados());
		System.out.println("Nota media en el test: " + poo.notaMedia());
		poo.guardaNotaAlumnos("recursos/mdTestL/alumnosConNota.txt");
		PrintWriter pw = new PrintWriter(System.out, true);
		poo.guardaNotaAlumnos(pw);
	}
}
