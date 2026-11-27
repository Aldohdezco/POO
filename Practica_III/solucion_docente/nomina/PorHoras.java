/* Practica III - SOLUCION DOCENTE */
public class PorHoras extends Empleado {

    private static final double JORNADA = 40;
    private final double tarifa;
    private final double horas;

    public PorHoras(String id, String nombre, double tarifa, double horas) {
        super(id, nombre);
        this.tarifa = tarifa;
        this.horas = horas;
    }

    @Override
    public double calcularPago() {
        if (horas <= JORNADA) {
            return tarifa * horas;
        }
        return JORNADA * tarifa + (horas - JORNADA) * tarifa * 1.5;
    }

    @Override
    public String tipo() {
        return "Por horas";
    }
}
