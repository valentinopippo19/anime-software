package com.darling.franxx.patterns.state;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public class EstadoDaniado implements EstadoFranxx {
    public void iniciarMision(Franxx franxx) { throw new IllegalStateException("El FRANXX está dañado."); }
    public void atacar(Franxx franxx, Klaxosaurio objetivo) { throw new IllegalStateException("No puede atacar: FRANXX dañado."); }
    public void defender(Franxx franxx) { throw new IllegalStateException("No puede defender: FRANXX dañado."); }
    public void patrullar(Franxx franxx) { throw new IllegalStateException("No puede patrullar: FRANXX dañado."); }
    public void retirarse(Franxx franxx) {}
    public void reparar(Franxx franxx) { franxx.cambiarEstado(new EstadoReparandose()); }
    public String getNombre() { return "DAÑADO"; }
}
