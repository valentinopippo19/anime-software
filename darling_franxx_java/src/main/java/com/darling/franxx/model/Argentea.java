package com.darling.franxx.model;

public class Argentea extends Franxx {
    public Argentea(int id) {
        super(id, "Argentea", 100, new Arma("Cuchillas", "Cuerpo a cuerpo", 25, 100));
    }
    public String getModelo() { return "Argentea"; }
    public String getHabilidadEspecial() { return "Ataque rápido"; }
}
