package com.sailormoon.modelo;

public class Rango {

    private int id;
    private String nombre;

    public Rango(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}