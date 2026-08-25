package com.sailormoon.modelo;

import java.time.LocalDate;

public class HistorialEquipo {

    private Equipo equipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public HistorialEquipo(
            Equipo equipo,
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}