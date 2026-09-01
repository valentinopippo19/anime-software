package com.darling.franxx.model;

public class Klaxosaurio {
    private final int id;
    private final String tipo;
    private final int nivelPeligro;
    private double energia;

    public Klaxosaurio(int id, String tipo, int nivelPeligro, double energia) {
        this.id = id;
        this.tipo = tipo;
        this.nivelPeligro = nivelPeligro;
        this.energia = energia;
    }

    public void recibirAtaque(double dano) {
        energia = Math.max(0, energia - dano);
    }

    public boolean estaDerrotado() {
        return energia <= 0;
    }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public int getNivelPeligro() { return nivelPeligro; }
    public double getEnergia() { return energia; }

    @Override
    public String toString() {
        return "Klaxosaurio #" + id + " - " + tipo + " - peligro " + nivelPeligro
                + " - energía " + energia;
    }
}
