package org.uma.mbd.mdTestL.tests;

import java.io.File;
import java.util.*;
import java.io.*;

public class TestAsignatura {
    private String nombre;
    private List<Test> examenes;
    private double valAcierto;
    private double valErrores;
    private final int APROBADO = 5;

    public TestAsignatura(String n, double valAc, double valEr, List<String> datos) {
        nombre = n;
        valAcierto = valAc;
        valErrores = valEr;
        examenes = new ArrayList<>();
        extraeDatos(datos);

    }

    public TestAsignatura(String n, List<String> datos) {
        this(n, 1,0, datos);
    }

    public TestAsignatura(String n, double valAc, double valEr, String nombreFichero) throws IOException {
        nombre = n;
        valAcierto = valAc;
        valErrores = valEr;
        examenes = new ArrayList<>();
        leeDatos(nombreFichero);
    }

    public TestAsignatura(String n, String nombreFichero) throws IOException {
        this(n, 1, 0, nombreFichero);
    }

    public void leeDatos(String nombreFichero) throws IOException {
        try (Scanner sc = new Scanner(new File(nombreFichero))){
            leeDatos(sc);
        }
    }

    public void leeDatos(Scanner sc) {
        while (sc.hasNextLine()) {
            String datoAlumno = sc.nextLine();
            try {
                Test test = stringToTest(datoAlumno);
                examenes.add(test);
            } catch (InputMismatchException e) {
                System.out.println(datoAlumno + "Error: Dato no numérico");
            } catch (NoSuchElementException e) {
                System.out.println(datoAlumno + "Error: Faltan datos");
            }
        }
    }

    public void extraeDatos(List<String> datos) {
        for (String datoAlumno: datos) {
            try {
                Test test = stringToTest(datoAlumno);
                examenes.add(test);
            } catch (InputMismatchException e) {
                System.out.println(datoAlumno + "Error: Dato no numérico");
            } catch (NoSuchElementException e) {
                System.out.println(datoAlumno + "Error: Faltan datos");
            }
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public int aprobados() {
        int cont = 0;
        for (Test test: examenes) {
            if (test.calificacion(valAcierto, valErrores) >= APROBADO) {
                cont++;
            }
        }
        return cont;
    }

    public double notaMedia() {
        if (examenes.size() == 0) {
            throw new NoSuchElementException("No hay test");
        }
        double suma = 0;
        for (Test test: examenes) {
            suma += test.calificacion(valAcierto, valErrores);
        }
        return suma/examenes.size();
    }

    public void guardaNotaAlumnos(String fichero) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fichero)) {
            guardaNotaAlumnos(pw);
        }

    }

    public void guardaNotaAlumnos(PrintWriter pw) {
        for (Test test: examenes) {
            double cal = test.calificacion(valAcierto, valErrores);
            pw.println(test.getAlumno() + "," + test.calificacion(valAcierto, valErrores));
        }
    }

    public Test stringToTest(String datoAlumno) {
        try(Scanner sc = new Scanner(datoAlumno)) {
            sc.useDelimiter("[:+]+");
            String nomAlumno = sc.next();
            int pAc = sc.nextInt();
            int pEr = sc.nextInt();
            Test test = new Test(nomAlumno, pAc, pEr);
            return test;
        }
    }
}
