package com.sailormoon.modelo;

import java.time.LocalDateTime;

public class UsoAtaque {

    private SailorScout sailor;
    private Ataque ataque;
    private Mision mision;
    private LocalDateTime fecha;
    private int energiaConsumida;

    public UsoAtaque(
            SailorScout sailor,
            Ataque ataque,
            Mision mision,
            LocalDateTime fecha,
            int energiaConsumida) {

        this.sailor = sailor;
        this.ataque = ataque;
        this.mision = mision;
        this.fecha = fecha;
        this.energiaConsumida = energiaConsumida;
    }

    public SailorScout getSailor() {
        return sailor;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Mision getMision() {
        return mision;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getEnergiaConsumida() {
        return energiaConsumida;
    }
}