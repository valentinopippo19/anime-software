package com.darling.franxx.model;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {
    private final String codigo;
    private final String nombre;
    private final List<Piloto> pilotos = new ArrayList<>();
    private final List<Franxx> franxx = new ArrayList<>();

    public Escuadron(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void agregarPiloto(Piloto piloto) {
        pilotos.add(piloto);
    }

    public void asignarFranxx(Franxx franxx) {
        if (!this.franxx.contains(franxx)) {
            this.franxx.add(franxx);
        }
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public List<Piloto> getPilotos() { return List.copyOf(pilotos); }
    public List<Franxx> getFranxx() { return List.copyOf(franxx); }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | pilotos=" + pilotos.size()
                + " | FRANXX=" + franxx.size();
    }
}
