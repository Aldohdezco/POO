/* Practica III - SOLUCION DOCENTE */
public class PorComision extends Empleado {

    protected final double ventas;
    protected final double tasa;

    public PorComision(String id, String nombre, double ventas, double tasa) {
        super(id, nombre);
        this.ventas = ventas;
        this.tasa = tasa;
    }

    @Override
    public double calcularPago() {
        return ventas * tasa;
    }

    @Override
    public String tipo() {
        return "Por comision";
    }
}
