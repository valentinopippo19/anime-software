package com.darling.franxx.patterns.observer;

import com.darling.franxx.model.Franxx;

public class CentroComando implements ObservadorFranxx {
    private final StringBuilder eventos = new StringBuilder();
    public void actualizar(Franxx franxx) {
        eventos.append("[CENTRO] ").append(franxx.getNombre())
               .append(" cambió a ").append(franxx.getEstado().getNombre()).append("\n");
    }
    public String getEventos() { return eventos.toString(); }
}
