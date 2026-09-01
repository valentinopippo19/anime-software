public class Guia extends Usuario {

    private String licenciaAventurero;
    private Vehiculo vehiculo;
    private boolean disponible;

    public Guia(
            int id,
            String nombre,
            String email,
            String password,
            String licenciaAventurero,
            Vehiculo vehiculo) {

        super(id, nombre, email, password);

        this.licenciaAventurero = licenciaAventurero;
        this.vehiculo = vehiculo;
        this.disponible = true;
    }

    public boolean aceptarExpedicion(Expedicion expedicion) {

        if (disponible) {
            expedicion.setGuia(this);
            expedicion.aceptar();

            disponible = false;

            return true;
        }

        return false;
    }

    public boolean rechazarExpedicion(Expedicion expedicion) {

        expedicion.rechazar();

        return true;
    }

    public void finalizarExpedicion(Expedicion expedicion) {

        expedicion.finalizar();

        disponible = true;
    }

    public String getLicenciaAventurero() {
        return licenciaAventurero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public boolean isDisponible() {
        return disponible;
    }
}