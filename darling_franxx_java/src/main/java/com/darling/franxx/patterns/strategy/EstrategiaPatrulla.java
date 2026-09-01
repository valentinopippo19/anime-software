package com.darling.franxx.patterns.strategy;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstrategiaPatrulla implements EstrategiaCombate {
    public void ejecutar(Franxx franxx, Klaxosaurio objetivo) {
        // La patrulla no busca destruir al objetivo.
    }
    public String getNombre() { return "Patrulla"; }
}
