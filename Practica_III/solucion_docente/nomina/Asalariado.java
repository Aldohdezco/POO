/* Practica III - SOLUCION DOCENTE */
public class Asalariado extends Empleado {

    private final double sueldoSemanal;

    public Asalariado(String id, String nombre, double sueldoSemanal) {
        super(id, nombre);
        this.sueldoSemanal = sueldoSemanal;
    }

    @Override
    public double calcularPago() {
        return sueldoSemanal;
    }

    @Override
    public String tipo() {
        return "Asalariado";
    }
}
