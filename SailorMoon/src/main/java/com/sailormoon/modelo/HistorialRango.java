package com.sailormoon.modelo;


import java.time.LocalDate;

public class HistorialRango {

    private Rango rango;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public HistorialRango(
            Rango rango,
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        this.rango = rango;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Rango getRango() {
        return rango;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}