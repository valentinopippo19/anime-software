package com.darling.franxx.model;

public class Genista extends Franxx {
    public Genista(int id) {
        super(id, "Genista", 100, new Arma("Martillo pesado", "Impacto", 40, 100));
    }
    public String getModelo() { return "Genista"; }
    public String getHabilidadEspecial() { return "Golpe pesado"; }
}
