package modelo;

import java.time.LocalDate;

public class BucleTemporal implements FenomenoAdolescencia {

    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private boolean activo;

    public BucleTemporal(
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = false;
    }

    @Override
    public void iniciar() {
        activo = true;
    }

    @Override
    public void resolver() {
        activo = false;
    }

    @Override
    public boolean estaActivo() {
        return activo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}