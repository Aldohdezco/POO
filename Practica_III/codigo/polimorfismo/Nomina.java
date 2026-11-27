/*
 * Practica III - Nomina con herencia y polimorfismo (esqueleto).
 *
 * Cree las clases Asalariado, PorHoras, PorComision y BaseMasComision
 * (cada una en su propio archivo) y complete este programa para que
 * produzca EXACTAMENTE el mismo reporte que NominaSinPolimorfismo.
 *
 *   javac *.java
 *   java Nomina
 */
public class Nomina {
    public static void main(String[] args) {
        Empleado[] empleados = {
            // TODO: cree aqui los cinco empleados, por ejemplo:
            // new Asalariado("E01", "Ana Lopez", 4500),
        };

        double total = 0;
        for (Empleado e : empleados) {
            // Una sola linea sirve para TODOS los tipos de empleado:
            System.out.println(e);
            total += e.calcularPago();
        }
        System.out.printf("%nTotal de la nomina: $%,.2f%n", total);
    }
}
