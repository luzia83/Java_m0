package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ClubManager {
    private String fEntrada;
    private String fSalida;
    private boolean consola;
    private Club club;
    private String delim;

    public ClubManager(Club club) {
        this.club = club;
    }

    public ClubManager setEntrada (String fEntrada, String delim) {
        this.fEntrada = fEntrada;
        this.delim = delim;
        return this;
    }

    public ClubManager setSalida(String salida) {
        this.fSalida = salida;
        return this;
    }

    public ClubManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify() {
        if (fEntrada == null) {
            throw new AmigoException("ERROR: El fichero de entrada no existe");
        }
        if (fSalida == null && !consola) {
            throw new AmigoException("ERROR: No se ha definido la salida");
        }
    }

    public void build() throws FileNotFoundException {
        this.verify();
        this.club.lee(fEntrada, delim);
        this.club.hacerAmigos();
        if (consola) {
            this.club.presentaAmigos("System.out");
        }
        if (fSalida != null) {
            this.club.presentaAmigos(fSalida);
        }
    }
}
