package modelo;

public class Relacion {

    private final TipoRelacion tipo;
    private final int intensidad;

    public Relacion(
            TipoRelacion tipo,
            int intensidad) {

        this.tipo = tipo;
        this.intensidad = intensidad;
    }

    public String describir() {
        return "Relación: " + tipo +
               " | Intensidad: " + intensidad;
    }

    public TipoRelacion getTipo() {
        return tipo;
    }

    public int getIntensidad() {
        return intensidad;
    }
}