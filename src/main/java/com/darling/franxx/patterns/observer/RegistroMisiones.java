package com.darling.franxx.patterns.observer;

import com.darling.franxx.model.Franxx;

public class RegistroMisiones implements ObservadorFranxx {
    private final StringBuilder eventos = new StringBuilder();
    public void actualizar(Franxx franxx) {
        eventos.append("[REGISTRO] Cambio de estado de ").append(franxx.getNombre())
               .append(": ").append(franxx.getEstado().getNombre()).append("\n");
    }
    public String getEventos() { return eventos.toString(); }
}
