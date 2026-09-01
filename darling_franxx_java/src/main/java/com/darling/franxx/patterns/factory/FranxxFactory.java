package com.darling.franxx.patterns.factory;

import com.darling.franxx.model.*;

public final class FranxxFactory {
    private FranxxFactory() {}

    public static Franxx crearFranxx(String tipo, int id) {
        return switch (tipo.toUpperCase()) {
            case "STRELIZIA" -> new Strelizia(id);
            case "DELPHINIUM" -> new Delphinium(id);
            case "ARGENTEA" -> new Argentea(id);
            case "GENISTA" -> new Genista(id);
            case "CHLOROPHYTUM" -> new Chlorophytum(id);
            default -> throw new IllegalArgumentException("Modelo desconocido: " + tipo);
        };
    }
}
