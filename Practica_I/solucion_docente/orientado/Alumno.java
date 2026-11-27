/*
 * Practica I - SOLUCION DOCENTE: clase Alumno.
 */
public class Alumno {

    public static final int NUM_PARCIALES = 3;

    private final String matricula;
    private final String nombre;
    private final double[] calificaciones = new double[NUM_PARCIALES];

    public Alumno(String matricula, String nombre) {
        if (matricula == null || matricula.isBlank()
                || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Matricula y nombre son obligatorios");
        }
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public boolean registrarCalificacion(int parcial, double valor) {
        if (parcial < 1 || parcial > NUM_PARCIALES || valor < 0 || valor > 10) {
            return false;
        }
        calificaciones[parcial - 1] = valor;
        return true;
    }

    public double promedio() {
        double suma = 0;
        for (double c : calificaciones) {
            suma += c;
        }
        return suma / NUM_PARCIALES;
    }

    public boolean aprobado() {
        return promedio() >= 6;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-12s %5.2f  %s", matricula,
                nombre.toUpperCase(), promedio(),
                aprobado() ? "APROBADO" : "REPROBADO");
    }
}
