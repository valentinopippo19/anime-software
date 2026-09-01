package modelo;

public class InvisibilidadSocial
        implements FenomenoAdolescencia {

    private double nivelVisibilidad;
    private boolean activo;

    public InvisibilidadSocial(double nivelVisibilidad) {
        this.nivelVisibilidad = nivelVisibilidad;
        this.activo = false;
    }

    @Override
    public void iniciar() {
        activo = true;
    }

    @Override
    public void resolver() {
        activo = false;
        nivelVisibilidad = 100;
    }

    @Override
    public boolean estaActivo() {
        return activo;
    }

    public double getNivelVisibilidad() {
        return nivelVisibilidad;
    }
}