package com.darling.franxx.patterns.observer;

import com.darling.franxx.model.Franxx;

public class Mantenimiento implements ObservadorFranxx {
    private final StringBuilder eventos = new StringBuilder();
    public void actualizar(Franxx franxx) {
        if (franxx.getEstado().getNombre().equals("DAÑADO")
                || franxx.getEstado().getNombre().equals("REPARÁNDOSE")) {
            eventos.append("[MANTENIMIENTO] Revisar ").append(franxx.getNombre())
                   .append(" - estado: ").append(franxx.getEstado().getNombre()).append("\n");
        }
    }
    public String getEventos() { return eventos.toString(); }
}
