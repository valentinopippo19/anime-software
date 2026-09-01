package com.darling.franxx.patterns.strategy;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstrategiaDefensa implements EstrategiaCombate {
    public void ejecutar(Franxx franxx, Klaxosaurio objetivo) {
        // En defensa se prioriza resistir; se realiza un ataque reducido.
        if (franxx.getArmaPrincipal().puedeUtilizarse()) {
            franxx.getArmaPrincipal().atacar(objetivo);
        }
    }
    public String getNombre() { return "Defensa"; }
}
