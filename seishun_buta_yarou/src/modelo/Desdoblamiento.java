package modelo;

public class Desdoblamiento
        implements FenomenoAdolescencia {

    private final String identidadOriginal;
    private boolean activo;

    public Desdoblamiento(String identidadOriginal) {
        this.identidadOriginal = identidadOriginal;
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

    public String getIdentidadOriginal() {
        return identidadOriginal;
    }
}