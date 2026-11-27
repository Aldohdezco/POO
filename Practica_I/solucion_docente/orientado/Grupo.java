import java.util.ArrayList;
import java.util.List;

/*
 * Practica I - SOLUCION DOCENTE: clase Grupo.
 */
public class Grupo {

    private final List<Alumno> alumnos = new ArrayList<>();

    public void agregar(Alumno alumno) {
        if (alumno != null) {
            alumnos.add(alumno);
        }
    }

    public double promedio() {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Alumno a : alumnos) {
            suma += a.promedio();
        }
        return suma / alumnos.size();
    }

    public Alumno mejorAlumno() {
        Alumno mejor = null;
        for (Alumno a : alumnos) {
            if (mejor == null || a.promedio() > mejor.promedio()) {
                mejor = a;
            }
        }
        return mejor;
    }

    public void imprimirReporte() {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
}
