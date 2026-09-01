package com.darling.franxx.model;

public class Delphinium extends Franxx {
    public Delphinium(int id) {
        super(id, "Delphinium", 100, new Arma("Lanza doble", "Cuerpo a cuerpo", 30, 100));
    }
    public String getModelo() { return "Delphinium"; }
    public String getHabilidadEspecial() { return "Combate cuerpo a cuerpo"; }
}
