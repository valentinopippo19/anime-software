public class TarjetaCredito extends Pago {

    private String numero;
    private String titular;
    private String vencimiento;

    public TarjetaCredito(
            int id,
            double monto,
            String numero,
            String titular,
            String vencimiento) {

        super(id, monto);

        this.numero = numero;
        this.titular = titular;
        this.vencimiento = vencimiento;
    }

    @Override
    public boolean procesarPago() {

        // Simulación de validación de tarjeta
        if (numero == null || numero.isEmpty()) {
            return false;
        }

        if (titular == null || titular.isEmpty()) {
            return false;
        }

        if (vencimiento == null || vencimiento.isEmpty()) {
            return false;
        }

        return true;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public String getVencimiento() {
        return vencimiento;
    }
}