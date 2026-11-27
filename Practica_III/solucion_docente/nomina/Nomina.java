/* Practica III - SOLUCION DOCENTE */
public class Nomina {
    public static void main(String[] args) {
        Empleado[] empleados = {
            new Asalariado("E01", "Ana Lopez", 4500),
            new PorHoras("E02", "Bruno Diaz", 120, 38),
            new PorHoras("E03", "Carla Ruiz", 120, 46),
            new PorComision("E04", "Diego Mora", 60000, 0.06),
            new BaseMasComision("E05", "Elena Vega", 40000, 0.04, 2500),
            new Becario("E06", "Fernando Gil")
        };

        double total = 0;
        for (Empleado e : empleados) {
            System.out.println(e);          // enlace dinamico
            total += e.calcularPago();
        }
        System.out.printf("%nTotal de la nomina: $%,.2f%n", total);
    }
}
