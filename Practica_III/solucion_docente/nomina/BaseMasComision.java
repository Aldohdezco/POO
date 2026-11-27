/* Practica III - SOLUCION DOCENTE: herencia de dos niveles */
public class BaseMasComision extends PorComision {

    private final double base;

    public BaseMasComision(String id, String nombre, double ventas,
                           double tasa, double base) {
        super(id, nombre, ventas, tasa);
        this.base = base;
    }

    @Override
    public double calcularPago() {
        return base + super.calcularPago();   // reutiliza la regla del padre
    }

    @Override
    public String tipo() {
        return "Base+comision";
    }
}
