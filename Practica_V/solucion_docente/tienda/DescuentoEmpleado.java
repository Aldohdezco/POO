public class DescuentoEmpleado implements EstrategiaDescuento {
    private static final double TOPE = 1000;

    @Override
    public double aplicar(double subtotal) {
        return Math.min(subtotal * 0.20, TOPE);
    }
}
