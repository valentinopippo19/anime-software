package com.darling.franxx.patterns.strategy;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public interface EstrategiaCombate {
    void ejecutar(Franxx franxx, Klaxosaurio objetivo);
    String getNombre();
}
