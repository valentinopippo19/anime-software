package com.sailormoon.modelo;


public class Enemigo {

    private int id;
    private String nombre;
    private String tipo;
    private int nivelPeligrosidad;

    public Enemigo(int id, String nombre, String tipo, int nivelPeligrosidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }

    @Override
    public String toString() {
        return nombre + " - Peligrosidad: " + nivelPeligrosidad;
    }
}