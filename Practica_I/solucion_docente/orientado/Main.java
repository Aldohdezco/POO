/*
 * Practica I - SOLUCION DOCENTE: programa principal.
 */
public class Main {
    public static void main(String[] args) {
        Grupo grupo = new Grupo();
        grupo.agregar(crear("202612345", "Ana Lopez", 9.5, 8.0, 10.0));
        grupo.agregar(crear("202612346", "Bruno Diaz", 7.0, 6.5, 8.0));
        grupo.agregar(crear("202612347", "Carla Ruiz", 10.0, 9.0, 9.5));
        grupo.agregar(crear("202612348", "Diego Mora", 5.0, 6.0, 4.5));

        System.out.println("=== Reporte ===");
        grupo.imprimirReporte();
        System.out.printf("Promedio del grupo: %.2f%n", grupo.promedio());
        Alumno mejor = grupo.mejorAlumno();
        System.out.println("Mejor alumno: " + mejor.getNombre()
                + " (" + mejor.getMatricula() + ")");

        // Los ataques de la version estructurada ya no son posibles:
        Alumno bruno = new Alumno("202612346", "Bruno Diaz");
        boolean aceptada = bruno.registrarCalificacion(3, 15.0);
        System.out.println("Se acepto una calificacion de 15? " + aceptada);
        // bruno.calificaciones[2] = 15;  -> error de compilacion (private)
    }

    private static Alumno crear(String matricula, String nombre, double... cal) {
        Alumno a = new Alumno(matricula, nombre);
        for (int i = 0; i < cal.length; i++) {
            a.registrarCalificacion(i + 1, cal[i]);
        }
        return a;
    }
}
