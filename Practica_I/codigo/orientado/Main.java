/*
 * Practica I - Programa principal de la version orientada a objetos.
 * Cuando termine Alumno y Grupo, este programa debe producir el mismo
 * reporte que RegistroAlumnos (version estructurada).
 *
 *     javac *.java
 *     java Main
 */
public class Main {
    public static void main(String[] args) {
        Grupo grupo = new Grupo();

        // TODO: cree los cuatro alumnos de la version estructurada,
        //       registre sus calificaciones y agreguelos al grupo.

        grupo.imprimirReporte();
        System.out.printf("Promedio del grupo: %.2f%n", grupo.promedio());
        System.out.println("Mejor alumno: " + grupo.mejorAlumno());
    }
}
