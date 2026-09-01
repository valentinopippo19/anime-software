package com.darling.franxx.model;

public class Strelizia extends Franxx {
    public Strelizia(int id) {
        super(id, "Strelizia", 100, new Arma("Rifle de energía", "Energía", 35, 100));
    }
    public String getModelo() { return "Strelizia"; }
    public String getHabilidadEspecial() { return "Modo Strelizia Apus"; }
}
