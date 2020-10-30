package org.uma.mbd.mdMasterMindL.masterMindL;

import java.util.Random;

public class MasterMind {
    private String cifras;
    private static final int TAM_DEFECTO = 4;

    public MasterMind(int tamano){
        if (tamano < 1 || tamano > 10) {
            throw new MasterMindException("El tamaño debe estar entre 1 y 10");
        }
        boolean valido = false;
        do {
            int semilla = (int) Math.pow(10, tamano);
            Random r = new Random();
            int numero = r.nextInt(semilla);
            String strnumero = ((Integer) numero).toString();
            cifras = strnumero;
            if (validaCombinacion(strnumero)) {
                valido = true;
            }

        } while (valido == false);
    }

    public MasterMind(){
        this(TAM_DEFECTO);
    }

    public int getLongitud() {
        return cifras.length();
    }

    private boolean validaCombinacion(String cifras) {
        boolean valido;
        valido = (cifras.length() == getLongitud());
        if (valido) {
            int i = 0;
            boolean algunaCifraRepetida = false;
            while (i < cifras.length() && !algunaCifraRepetida) {
                char c = cifras.charAt(i);
                boolean cifraRepetida = false;
                int j = 0;
                while (j < cifras.length() && !cifraRepetida) {
                    if (i != j && cifras.charAt(i) == cifras.charAt(j)) {
                        cifraRepetida = true;
                    }
                    j++;
                }
                if (cifraRepetida) {
                    algunaCifraRepetida = true;
                }
                i++;
            }
            if (algunaCifraRepetida) {
                valido = false;
            }
        }
        return valido;
    }

    public Movimiento intento(String cifras) {
        boolean valido = validaCombinacion(cifras);
        if (!valido) {
            throw new MasterMindException("La cifra no es valida");
        }
        int colocadas = 0;
        int descolocadas = 0;
        for(int i = 0; i < cifras.length(); i++) {
            if (cifras.charAt(i) == this.cifras.charAt(i)) {
                colocadas++;
                descolocadas++;
            }
            else {
                for (int j = 0; j < cifras.length(); j++) {
                    if (cifras.charAt(i) == this.cifras.charAt(j)) {
                        descolocadas++;
                    }
                }
            }
        }
        Movimiento m = new Movimiento(cifras, colocadas, descolocadas);
        return m;
    }

    public String getSecreto() {
        return cifras;
    }
}
