/*
 * Practica III - Superclase Empleado (YA ESTA COMPLETA).
 * Sus subclases deben sobrescribir calcularPago() y tipo().
 */
public class Empleado {

    protected final String id;
    protected final String nombre;

    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /** Pago semanal. Cada subclase define su propia regla. */
    public double calcularPago() {
        return 0.0;
    }

    /** Nombre del tipo de empleado para el reporte. */
    public String tipo() {
        return "Empleado";
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-16s %-14s $%,10.2f",
                id, nombre, tipo(), calcularPago());
    }
}
