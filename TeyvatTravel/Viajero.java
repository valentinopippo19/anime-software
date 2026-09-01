public class Viajero extends Usuario {

    public Viajero(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
    }

    public Expedicion solicitarExpedicion(String origen, String destino) {

        Expedicion expedicion = new Expedicion(
                origen,
                destino
        );

        return expedicion;
    }

    public boolean realizarPago(Expedicion expedicion) {

        double precio = expedicion.getPrecio();

        if (monedero.retirar(precio)) {
            expedicion.setEstado("PAGADA");
            return true;
        }

        return false;
    }
}