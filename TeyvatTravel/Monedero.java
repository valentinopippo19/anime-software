public class Monedero {

    private double saldo;

    public Monedero() {
        saldo = 0;
    }

    public void recargar(double monto) {

        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {

        if (monto > 0 && saldo >= monto) {

            saldo -= monto;

            return true;
        }

        return false;
    }

    public void depositar(double monto) {

        if (monto > 0) {
            saldo += monto;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}