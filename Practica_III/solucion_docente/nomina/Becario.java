/* Practica III - SOLUCION DOCENTE: tipo nuevo agregado SIN tocar Nomina */
public class Becario extends Empleado {

    private static final double APOYO = 1500;

    public Becario(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularPago() {
        return APOYO;
    }

    @Override
    public String tipo() {
        return "Becario";
    }
}
