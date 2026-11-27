public class DescuentoVip implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal) {
        double d = subtotal * 0.10;
        if (subtotal > 5000) {
            d += subtotal * 0.05;
        }
        return d;
    }
}
