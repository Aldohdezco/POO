public class DescuentoFrecuente implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal) {
        return subtotal * 0.05;
    }
}
