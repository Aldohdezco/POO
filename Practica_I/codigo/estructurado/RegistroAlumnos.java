/*
 * Practica I - Programacion Orientada a Objetos (BUAP-FCC)
 *
 * Version ESTRUCTURADA de un registro de alumnos.
 * Este programa funciona, pero tiene los problemas tipicos del paradigma
 * estructurado: datos globales en arreglos paralelos, funciones que
 * dependen de indices y ninguna proteccion de los datos.
 *
 * Compilar y ejecutar:
 *     javac RegistroAlumnos.java
 *     java RegistroAlumnos
 *
 * NO modifique este archivo: su tarea es construir una version
 * orientada a objetos equivalente en otra carpeta.
 */
public class RegistroAlumnos {

    static final int MAX = 50;
    static final int NUM_PARCIALES = 3;

    // Arreglos paralelos: el alumno i esta "repartido" en tres arreglos.
    static String[] matriculas = new String[MAX];
    static String[] nombres = new String[MAX];
    static double[][] calificaciones = new double[MAX][NUM_PARCIALES];
    static int total = 0;

    public static void main(String[] args) {
        agregarAlumno("202612345", "Ana Lopez", 9.5, 8.0, 10.0);
        agregarAlumno("202612346", "Bruno Diaz", 7.0, 6.5, 8.0);
        agregarAlumno("202612347", "Carla Ruiz", 10.0, 9.0, 9.5);
        agregarAlumno("202612348", "Diego Mora", 5.0, 6.0, 4.5);

        System.out.println("=== Reporte inicial ===");
        imprimirReporte();
        System.out.printf("Promedio del grupo: %.2f%n", promedioGrupo());
        System.out.println("Mejor alumno: " + mejorAlumno());

        // ------------------------------------------------------------
        // Problema 1: cualquier parte del programa puede modificar
        // los datos y dejarlos en un estado invalido.
        // ------------------------------------------------------------
        calificaciones[1][2] = 15.0;   // calificacion fuera de rango
        nombres[3] = null;             // alumno sin nombre

        System.out.println();
        System.out.println("=== Reporte despues de modificar los datos ===");
        imprimirReporte();
        System.out.printf("Promedio del grupo: %.2f%n", promedioGrupo());

        // ------------------------------------------------------------
        // Problema 2: los arreglos paralelos se desincronizan facilmente.
        // Descomente la siguiente linea y observe que ocurre:
        // ------------------------------------------------------------
        // total = 10;
        // imprimirReporte();
    }

    static void agregarAlumno(String matricula, String nombre,
                              double p1, double p2, double p3) {
        if (total >= MAX) {
            System.out.println("Registro lleno");
            return;
        }
        matriculas[total] = matricula;
        nombres[total] = nombre;
        calificaciones[total][0] = p1;
        calificaciones[total][1] = p2;
        calificaciones[total][2] = p3;
        total++;
    }

    static double promedioAlumno(int i) {
        double suma = 0;
        for (int j = 0; j < NUM_PARCIALES; j++) {
            suma += calificaciones[i][j];
        }
        return suma / NUM_PARCIALES;
    }

    static double promedioGrupo() {
        double suma = 0;
        for (int i = 0; i < total; i++) {
            suma += promedioAlumno(i);
        }
        return total == 0 ? 0 : suma / total;
    }

    static String mejorAlumno() {
        int mejor = 0;
        for (int i = 1; i < total; i++) {
            if (promedioAlumno(i) > promedioAlumno(mejor)) {
                mejor = i;
            }
        }
        return nombres[mejor] + " (" + matriculas[mejor] + ")";
    }

    static void imprimirReporte() {
        for (int i = 0; i < total; i++) {
            String estado = promedioAlumno(i) >= 6 ? "APROBADO" : "REPROBADO";
            System.out.printf("%-10s %-12s %5.2f  %s%n",
                    matriculas[i], nombres[i].toUpperCase(),
                    promedioAlumno(i), estado);
        }
    }
}
