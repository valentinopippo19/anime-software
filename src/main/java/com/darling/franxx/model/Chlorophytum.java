package com.darling.franxx.model;

public class Chlorophytum extends Franxx {
    public Chlorophytum(int id) {
        super(id, "Chlorophytum", 100, new Arma("Lanzas gemelas", "Mixta", 28, 100));
    }
    public String getModelo() { return "Chlorophytum"; }
    public String getHabilidadEspecial() { return "Movilidad táctica"; }
}
