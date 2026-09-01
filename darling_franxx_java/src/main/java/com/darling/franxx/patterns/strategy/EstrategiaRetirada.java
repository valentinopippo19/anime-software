package com.darling.franxx.patterns.strategy;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstrategiaRetirada implements EstrategiaCombate {
    public void ejecutar(Franxx franxx, Klaxosaurio objetivo) {
        franxx.retirarse();
    }
    public String getNombre() { return "Retirada"; }
}
