package com.darling.franxx.patterns.state;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstadoReparandose implements EstadoFranxx {
    public void iniciarMision(Franxx franxx) { throw new IllegalStateException("Está en reparación."); }
    public void atacar(Franxx franxx, Klaxosaurio objetivo) { throw new IllegalStateException("Está en reparación."); }
    public void defender(Franxx franxx) { throw new IllegalStateException("Está en reparación."); }
    public void patrullar(Franxx franxx) { throw new IllegalStateException("Está en reparación."); }
    public void retirarse(Franxx franxx) {}
    public void reparar(Franxx franxx) {
        franxx.restaurarEnergia();
        franxx.cambiarEstado(new EstadoDisponible());
    }
    public String getNombre() { return "REPARÁNDOSE"; }
}
