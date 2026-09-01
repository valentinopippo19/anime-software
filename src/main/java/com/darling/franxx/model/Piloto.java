package com.darling.franxx.model;

import java.util.ArrayList;
import java.util.List;

public class Piloto {
    private final String nombre;
    private final String codigo;
    private final int edad;
    private double nivelSincronizacion;
    private String estadoFisico;
    private final List<Franxx> compatibles = new ArrayList<>();

    public Piloto(String nombre, String codigo, int edad,
                  double nivelSincronizacion, String estadoFisico) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.nivelSincronizacion = nivelSincronizacion;
        this.estadoFisico = estadoFisico;
    }

    public void agregarCompatibilidad(Franxx franxx) {
        if (!compatibles.contains(franxx)) {
            compatibles.add(franxx);
        }
    }

    public boolean verificarCompatibilidad(Franxx franxx) {
        return compatibles.contains(franxx);
    }

    public void aumentarSincronizacion(double cantidad) {
        nivelSincronizacion = Math.min(100, nivelSincronizacion + cantidad);
    }

    public void actualizarEstadoFisico(String estado) {
        estadoFisico = estado;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public int getEdad() { return edad; }
    public double getNivelSincronizacion() { return nivelSincronizacion; }
    public String getEstadoFisico() { return estadoFisico; }
    public List<Franxx> getCompatibles() { return List.copyOf(compatibles); }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | sincronización: "
                + nivelSincronizacion + "% | estado: " + estadoFisico;
    }
}
