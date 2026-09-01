public class Expedicion {

    private static int contador = 1;

    private int id;
    private String origen;
    private String destino;
    private double distancia;
    private double precio;
    private String estado;

    private Viajero viajero;
    private Guia guia;

    public Expedicion(String origen, String destino) {

        this.id = contador++;

        this.origen = origen;
        this.destino = destino;

        this.estado = "SOLICITADA";

        calcularDistancia();
        calcularPrecio();
    }

    private void calcularDistancia() {

        // Simulación de distancia
        this.distancia = 10 + Math.random() * 40;
    }

    public double calcularPrecio() {

        // Precio base + precio por kilómetro
        this.precio = 100 + (distancia * 15);

        return precio;
    }

    public void aceptar() {
        estado = "ACEPTADA";
    }

    public void rechazar() {
        estado = "RECHAZADA";
    }

    public void finalizar() {
        estado = "FINALIZADA";
    }

    public int getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public Viajero getViajero() {
        return viajero;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setViajero(Viajero viajero) {
        this.viajero = viajero;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}