package org.uma.mbd.mdTestL.tests;

public class Test {
    private String alumno;
    private int aciertos;
    private int errores;

    public Test(String al, int ac, int er) {
        alumno = al;
        aciertos = ac;
        errores = er;
    }
    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Test;
        Test test = res?(Test)o:null;
        return res&&alumno.equalsIgnoreCase(test.alumno);
    }

    public String getAlumno() {
        return alumno;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getErrores() {
        return errores;
    }

    @Override
    public int hashCode() {
        return alumno.toLowerCase().hashCode();
    }

    public double calificacion(double valAc, double valEr) {
        if (valAc <= 0 || valEr > 0) {
            throw new RuntimeException("Valoraciones erroneas");
        }
        return aciertos*valAc + errores*valEr;
    }

    @Override
    public String toString() {
        return alumno + ": " + aciertos + "," + errores;
    }
}
