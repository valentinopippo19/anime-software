package com.darling.franxx.model;

import com.darling.franxx.patterns.observer.ObservadorFranxx;
import com.darling.franxx.patterns.state.EstadoFranxx;
import com.darling.franxx.patterns.state.EstadoDisponible;
import com.darling.franxx.patterns.strategy.EstrategiaAtaque;
import com.darling.franxx.patterns.strategy.EstrategiaCombate;

import java.util.ArrayList;
import java.util.List;

public abstract class Franxx {
    private final int id;
    private final String nombre;
    private double nivelEnergia;
    private final Arma armaPrincipal;
    private final List<Piloto> pilotos = new ArrayList<>();
    private EstadoFranxx estado;
    private EstrategiaCombate estrategia;
    private final List<ObservadorFranxx> observadores = new ArrayList<>();

    protected Franxx(int id, String nombre, double nivelEnergia, Arma armaPrincipal) {
        this.id = id;
        this.nombre = nombre;
        this.nivelEnergia = nivelEnergia;
        this.armaPrincipal = armaPrincipal;
        this.estado = new EstadoDisponible();
        this.estrategia = new EstrategiaAtaque();
    }

    public void iniciarMision() { estado.iniciarMision(this); }

    public void atacar(Klaxosaurio objetivo) { estado.atacar(this, objetivo); }

    public void defender() { estado.defender(this); }

    public void patrullar() { estado.patrullar(this); }

    public void retirarse() { estado.retirarse(this); }

    public void reparar() { estado.reparar(this); }

    public void ejecutarEstrategia(Klaxosaurio objetivo) {
        estrategia.ejecutar(this, objetivo);
    }

    public void cambiarEstado(EstadoFranxx nuevoEstado) {
        this.estado = nuevoEstado;
        notificar();
    }

    public void cambiarEstrategia(EstrategiaCombate nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }

    public void agregarPiloto(Piloto piloto) {
        if (pilotos.size() < 2 && !pilotos.contains(piloto)) {
            pilotos.add(piloto);
            piloto.agregarCompatibilidad(this);
        }
    }

    public void agregarObservador(ObservadorFranxx observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    private void notificar() {
        for (ObservadorFranxx observador : observadores) {
            observador.actualizar(this);
        }
    }

    public void recibirDanio(double cantidad) {
        nivelEnergia = Math.max(0, nivelEnergia - cantidad);
        if (nivelEnergia <= 20) {
            cambiarEstado(new com.darling.franxx.patterns.state.EstadoDaniado());
        }
    }

    public void restaurarEnergia() {
        nivelEnergia = 100;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getNivelEnergia() { return nivelEnergia; }
    public Arma getArmaPrincipal() { return armaPrincipal; }
    public List<Piloto> getPilotos() { return List.copyOf(pilotos); }
    public EstadoFranxx getEstado() { return estado; }
    public EstrategiaCombate getEstrategia() { return estrategia; }

    public abstract String getModelo();
    public abstract String getHabilidadEspecial();

    @Override
    public String toString() {
        return getModelo() + " #" + id + " - " + nombre
                + " | energía=" + nivelEnergia
                + " | estado=" + estado.getNombre()
                + " | estrategia=" + estrategia.getNombre();
    }
}
