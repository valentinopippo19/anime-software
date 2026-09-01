package com.sailormoon.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mision {

    private int id;
    private LocalDate fechaInicio;
    private String nombre;
    private String descripcion;
    private EstadoMision estado;

    private List<SailorScout> participantes;
    private List<Enemigo> enemigos;

    private SailorScout sailorQueDerroto;

    public Mision(
            int id,
            String nombre,
            String descripcion,
            LocalDate fechaInicio) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.estado = EstadoMision.PENDIENTE;

        this.participantes = new ArrayList<>();
        this.enemigos = new ArrayList<>();
    }

    public void agregarParticipante(SailorScout sailor) {

        if (sailor.getEquipoActual() == null) {
            throw new IllegalStateException(
                    "La Sailor Scout debe pertenecer a un equipo."
            );
        }

        participantes.add(sailor);
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    public void finalizar(SailorScout sailor) {

        if (!participantes.contains(sailor)) {
            throw new IllegalArgumentException(
                    "La Sailor Scout no participa en esta misión."
            );
        }

        this.sailorQueDerroto = sailor;
        this.estado = EstadoMision.FINALIZADA;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoMision getEstado() {
        return estado;
    }

    public List<SailorScout> getParticipantes() {
        return participantes;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public SailorScout getSailorQueDerroto() {
        return sailorQueDerroto;
    }

    @Override
    public String toString() {
        return nombre + " - " + estado;
    }
}