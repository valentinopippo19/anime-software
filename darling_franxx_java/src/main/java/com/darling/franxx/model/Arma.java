package com.darling.franxx.model;

public class Arma {
    private final String nombre;
    private final String tipo;
    private final double dano;
    private double energia;

    public Arma(String nombre, String tipo, double dano, double energia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.energia = energia;
    }

    public void atacar(Klaxosaurio objetivo) {
        if (!puedeUtilizarse()) {
            throw new IllegalStateException("El arma no tiene energía suficiente.");
        }
        energia -= 10;
        objetivo.recibirAtaque(dano);
    }

    public void recargar() {
        energia = 100;
    }

    public boolean puedeUtilizarse() {
        return energia >= 10;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getDano() { return dano; }
    public double getEnergia() { return energia; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", daño=" + dano + ", energía=" + energia + ")";
    }
}
