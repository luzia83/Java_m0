package org.uma.mbd.mdPruebas;

import java.util.*;

public class Posiciones {
    public static void main(String[] args) {
        Map<String,List<Integer>> mPos = new TreeMap<>();
        for(int i = 0; i < args.length; i++) {
            //Buscamos la lista asociada a args[i] en mPos
            List<Integer> lPos = mPos.get(args[i]);
            if (lPos == null) {
                lPos = new ArrayList<>();
                mPos.put(args[i],lPos);
            }
            lPos.add(i);
        }
        for(Map.Entry<String,List<Integer>> entrada: mPos.entrySet()) {
            String clave = entrada.getKey();
            List<Integer> lPos = entrada.getValue();
            System.out.println(clave+ ":\t" + lPos);
        }
    }
}
