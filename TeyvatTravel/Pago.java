public abstract class Pago {

    protected int id;
    protected double monto;

    public Pago(int id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public abstract boolean procesarPago();

    public double getMonto() {
        return monto;
    }
}