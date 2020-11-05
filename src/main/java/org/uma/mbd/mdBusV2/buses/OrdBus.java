package org.uma.mbd.mdBusV2.buses;

import java.util.Comparator;

public class OrdBus implements Comparator<Bus> {

    @Override
    public int compare(Bus o1, Bus o2) {
        return Integer.compare(o1.getCodBus(), o2.getCodBus());
    }
}
