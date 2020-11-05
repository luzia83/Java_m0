package org.uma.mbd.mdAmigoInvisible.amigos;

public class Pareja {
    private Persona persona1, persona2;

    public Pareja(Persona p1, Persona p2) {
        persona1 = p1;
        persona2 = p2;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public Persona getPersona2() {
        return persona2;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Pareja;
        Pareja par = res? (Pareja)o : null;
        boolean opc1 = par.getPersona1().equals(getPersona1()) && par.getPersona2().equals(getPersona2());
        boolean opc2 = par.getPersona1().equals(getPersona2()) && par.getPersona2().equals(getPersona1());
        return res && (opc1 || opc2);
    }

    @Override
    public int hashCode() {
       return persona1.hashCode() + persona2.hashCode();
    }

    @Override
    public String toString() {
        return "(" + persona1.getNombre() + ", " + persona2.getNombre() + ")";
    }
}
