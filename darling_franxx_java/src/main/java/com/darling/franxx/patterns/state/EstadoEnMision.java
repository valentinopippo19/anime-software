package com.darling.franxx.patterns.state;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstadoEnMision implements EstadoFranxx {
    public void iniciarMision(Franxx franxx) { throw new IllegalStateException("La misión ya está iniciada."); }
    public void atacar(Franxx franxx, Klaxosaurio objetivo) {
        franxx.ejecutarEstrategia(objetivo);
        if (objetivo.estaDerrotado()) {
            franxx.cambiarEstado(new EstadoDisponible());
        }
    }
    public void defender(Franxx franxx) {}
    public void patrullar(Franxx franxx) {}
    public void retirarse(Franxx franxx) { franxx.cambiarEstado(new EstadoDisponible()); }
    public void reparar(Franxx franxx) { throw new IllegalStateException("No puede repararse durante la misión."); }
    public String getNombre() { return "EN MISIÓN"; }
}
