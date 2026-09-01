package com.sailormoon.modelo;

import java.util.ArrayList;
import java.util.List;

public class SailorScout {

    private int id;
    private String nombreCivil;
    private String nickname;
    private String avatar;
    private boolean activa;

    private Planeta planeta;
    private Equipo equipoActual;
    private Rango rangoActual;

    private List<Ataque> ataques;
    private List<Mision> misiones;
    private List<HistorialEquipo> historialEquipos;
    private List<HistorialRango> historialRangos;
    private List<UsoAtaque> usosAtaques;

    public SailorScout(
            int id,
            String nombreCivil,
            String nickname,
            String avatar,
            Planeta planeta,
            Equipo equipoActual,
            Rango rangoActual) {

        this.id = id;
        this.nombreCivil = nombreCivil;
        this.nickname = nickname;
        this.avatar = avatar;
        this.planeta = planeta;
        this.equipoActual = equipoActual;
        this.rangoActual = rangoActual;
        this.activa = true;

        this.ataques = new ArrayList<>();
        this.misiones = new ArrayList<>();
        this.historialEquipos = new ArrayList<>();
        this.historialRangos = new ArrayList<>();
        this.usosAtaques = new ArrayList<>();
    }

    public void aprenderAtaque(Ataque ataque) {

        if (!ataques.contains(ataque)) {
            ataques.add(ataque);
        }
    }

    public void participarEnMision(Mision mision) {

        mision.agregarParticipante(this);
        misiones.add(mision);
    }

    public void cambiarEquipo(
            Equipo nuevoEquipo,
            java.time.LocalDate fecha) {

        this.equipoActual = nuevoEquipo;
    }

    public int getId() {
        return id;
    }

    public void cambiarRango(Rango nuevoRango) {
        this.rangoActual = nuevoRango;
    }

    public boolean conoceAtaque(Ataque ataque) {
        return ataques.contains(ataque);
    }

    public void desactivar() {
        this.activa = false;
    }

    public String getNombreCivil() {
        return nombreCivil;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isActiva() {
        return activa;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public Equipo getEquipoActual() {
        return equipoActual;
    }

    public Rango getRangoActual() {
        return rangoActual;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public List<Mision> getMisiones() {
        return misiones;
    }

    public List<HistorialEquipo> getHistorialEquipos() {
        return historialEquipos;
    }

    public List<HistorialRango> getHistorialRangos() {
        return historialRangos;
    }

    public List<UsoAtaque> getUsosAtaques() {
        return usosAtaques;
    }

    @Override
    public String toString() {
        return nickname + " (" + nombreCivil + ")";
    }
}