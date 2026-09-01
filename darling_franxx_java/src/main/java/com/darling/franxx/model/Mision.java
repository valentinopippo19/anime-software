package com.darling.franxx.model;

import java.time.LocalDateTime;

public class Mision {
    private final int id;
    private final String tipo;
    private final String objetivo;
    private final LocalDateTime fecha;
    private final Escuadron escuadron;
    private final Franxx franxx;
    private String estado;
    private String resultado;

    public Mision(int id, String tipo, String objetivo,
                  Escuadron escuadron, Franxx franxx) {
        this.id = id;
        this.tipo = tipo;
        this.objetivo = objetivo;
        this.escuadron = escuadron;
        this.franxx = franxx;
        this.fecha = LocalDateTime.now();
        this.estado = "PLANIFICADA";
        this.resultado = "";
    }

    public void iniciar() { estado = "EN CURSO"; }
    public void finalizar() { estado = "FINALIZADA"; }
    public void cancelar() { estado = "CANCELADA"; }
    public void registrarResultado(String resultado) { this.resultado = resultado; }

    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getObjetivo() { return objetivo; }
    public LocalDateTime getFecha() { return fecha; }
    public Escuadron getEscuadron() { return escuadron; }
    public Franxx getFranxx() { return franxx; }
    public String getEstado() { return estado; }
    public String getResultado() { return resultado; }

    @Override
    public String toString() {
        return "Misión #" + id + " | " + tipo + " | objetivo=" + objetivo
                + " | estado=" + estado + " | resultado=" + resultado;
    }
}
