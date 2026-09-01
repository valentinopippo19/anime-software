package com.darling.franxx.service;

import com.darling.franxx.model.*;
import com.darling.franxx.patterns.factory.FranxxFactory;
import com.darling.franxx.patterns.observer.*;
import com.darling.franxx.patterns.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class FranxxService {
    private final List<Franxx> franxxList = new ArrayList<>();
    private final List<Piloto> pilotos = new ArrayList<>();
    private final List<Mision> misiones = new ArrayList<>();
    private final CentroComando centro = new CentroComando();
    private final Mantenimiento mantenimiento = new Mantenimiento();
    private final RegistroMisiones registro = new RegistroMisiones();
    private int nextId = 1;
    private int nextMision = 1;

    public FranxxService() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        Franxx s = crearFranxx("STRELIZIA");
        Franxx d = crearFranxx("DELPHINIUM");
        Franxx a = crearFranxx("ARGENTEA");

        Piloto hiro = new Piloto("Hiro", "P001", 16, 92, "Óptimo");
        Piloto zeroTwo = new Piloto("Zero Two", "P002", 16, 98, "Óptimo");
        Piloto ichigo = new Piloto("Ichigo", "P003", 17, 87, "Óptimo");
        Piloto goro = new Piloto("Goro", "P004", 17, 85, "Óptimo");

        pilotos.addAll(List.of(hiro, zeroTwo, ichigo, goro));
        s.agregarPiloto(hiro);
        s.agregarPiloto(zeroTwo);
        d.agregarPiloto(ichigo);
        d.agregarPiloto(goro);

        s.agregarObservador(centro);
        s.agregarObservador(mantenimiento);
        s.agregarObservador(registro);
        d.agregarObservador(centro);
        d.agregarObservador(mantenimiento);
        d.agregarObservador(registro);
        a.agregarObservador(centro);
        a.agregarObservador(mantenimiento);
        a.agregarObservador(registro);
    }

    public Franxx crearFranxx(String tipo) {
        Franxx f = FranxxFactory.crearFranxx(tipo, nextId++);
        f.agregarObservador(centro);
        f.agregarObservador(mantenimiento);
        f.agregarObservador(registro);
        franxxList.add(f);
        return f;
    }

    public void iniciarMision(Franxx f, String objetivo) {
        f.iniciarMision();
        Mision m = new Mision(nextMision++, "COMBATE", objetivo,
                new Escuadron("13", "Escuadrón 13"), f);
        m.iniciar();
        misiones.add(m);
    }

    public void atacar(Franxx f, Klaxosaurio k) {
        f.atacar(k);
        if (k.estaDerrotado()) {
            misiones.stream()
                    .filter(m -> m.getFranxx() == f && m.getEstado().equals("EN CURSO"))
                    .findFirst()
                    .ifPresent(m -> {
                        m.finalizar();
                        m.registrarResultado("Klaxosaurio derrotado");
                    });
        }
    }

    public void daniar(Franxx f, double dano) {
        f.recibirDanio(dano);
    }

    public void reparar(Franxx f) {
        f.reparar();
        if (f.getEstado().getNombre().equals("REPARÁNDOSE")) {
            f.reparar();
        }
    }

    public void cambiarEstrategia(Franxx f, String nombre) {
        f.cambiarEstrategia(switch (nombre) {
            case "Ataque" -> new EstrategiaAtaque();
            case "Defensa" -> new EstrategiaDefensa();
            case "Patrulla" -> new EstrategiaPatrulla();
            case "Retirada" -> new EstrategiaRetirada();
            default -> throw new IllegalArgumentException("Estrategia desconocida");
        });
    }

    public List<Franxx> getFranxxList() { return List.copyOf(franxxList); }
    public List<Piloto> getPilotos() { return List.copyOf(pilotos); }
    public List<Mision> getMisiones() { return List.copyOf(misiones); }

    public String getEventos() {
        return centro.getEventos() + mantenimiento.getEventos() + registro.getEventos();
    }
}
