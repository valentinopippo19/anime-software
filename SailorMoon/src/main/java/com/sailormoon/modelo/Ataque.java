package com.sailormoon.modelo;



public class Ataque {

    private int id;
    private String nombre;
    private String descripcion;
    private int nivelPoder;

    public Ataque(int id, String nombre, String descripcion, int nivelPoder) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelPoder = nivelPoder;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    @Override
    public String toString() {
        return nombre + " - Poder: " + nivelPoder;
    }
}