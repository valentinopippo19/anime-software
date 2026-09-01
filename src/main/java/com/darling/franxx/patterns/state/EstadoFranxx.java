package com.darling.franxx.patterns.state;

import com.darling.franxx.model.Franxx;
import com.darling.franxx.model.Klaxosaurio;

public interface EstadoFranxx {
    void iniciarMision(Franxx franxx);
    void atacar(Franxx franxx, Klaxosaurio objetivo);
    void defender(Franxx franxx);
    void patrullar(Franxx franxx);
    void retirarse(Franxx franxx);
    void reparar(Franxx franxx);
    String getNombre();
}
