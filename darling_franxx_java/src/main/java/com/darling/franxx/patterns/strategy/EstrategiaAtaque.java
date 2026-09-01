package com.darling.franxx.patterns.strategy;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstrategiaAtaque implements EstrategiaCombate {
    public void ejecutar(Franxx franxx, Klaxosaurio objetivo) {
        franxx.getArmaPrincipal().atacar(objetivo);
    }
    public String getNombre() { return "Ataque"; }
}
