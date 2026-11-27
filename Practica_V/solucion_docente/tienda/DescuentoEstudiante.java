/* Extension pedida en la practica: un tipo nuevo = una clase nueva */
public class DescuentoEstudiante implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal) {
        return subtotal * 0.12;
    }
}
