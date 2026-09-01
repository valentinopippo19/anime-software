package com.darling.franxx.patterns.state;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstadoDisponible implements EstadoFranxx {
    public void iniciarMision(Franxx franxx) {
        franxx.cambiarEstado(new EstadoEnMision());
    }
    public void atacar(Franxx franxx, Klaxosaurio objetivo) {
        throw new IllegalStateException("El FRANXX debe estar en misión para atacar.");
    }
    public void defender(Franxx franxx) { throw new IllegalStateException("Debe iniciar una misión."); }
    public void patrullar(Franxx franxx) { throw new IllegalStateException("Debe iniciar una misión."); }
    public void retirarse(Franxx franxx) { throw new IllegalStateException("No está en misión."); }
    public void reparar(Franxx franxx) { throw new IllegalStateException("No necesita reparación."); }
    public String getNombre() { return "DISPONIBLE"; }
}
