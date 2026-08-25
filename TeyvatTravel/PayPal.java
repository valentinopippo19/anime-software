public class PayPal extends Pago {

    private String email;

    public PayPal(
            int id,
            double monto,
            String email) {

        super(id, monto);

        this.email = email;
    }

    @Override
    public boolean procesarPago() {

        return true;
    }

    public String getEmail() {
        return email;
    }
}