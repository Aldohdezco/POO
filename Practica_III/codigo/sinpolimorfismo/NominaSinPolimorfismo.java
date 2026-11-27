/*
 * Practica III - Nomina SIN herencia ni polimorfismo.
 *
 * Cada empleado se distingue por un "codigo de tipo" y el calculo del
 * pago se resuelve con un switch. Observe cuantas partes del programa
 * hay que modificar si se agrega un nuevo tipo de empleado.
 *
 *   javac NominaSinPolimorfismo.java
 *   java NominaSinPolimorfismo
 */
public class NominaSinPolimorfismo {

    static final int ASALARIADO = 1;
    static final int POR_HORAS = 2;
    static final int POR_COMISION = 3;
    static final int BASE_MAS_COMISION = 4;

    public static void main(String[] args) {
        String[] ids     = {"E01", "E02", "E03", "E04", "E05"};
        String[] nombres = {"Ana Lopez", "Bruno Diaz", "Carla Ruiz",
                            "Diego Mora", "Elena Vega"};
        int[] tipos      = {ASALARIADO, POR_HORAS, POR_HORAS,
                            POR_COMISION, BASE_MAS_COMISION};
        // El significado de cada columna depende del tipo:
        //   ASALARIADO        -> {sueldoSemanal, -, -}
        //   POR_HORAS         -> {tarifa, horas, -}
        //   POR_COMISION      -> {ventas, tasa, -}
        //   BASE_MAS_COMISION -> {ventas, tasa, base}
        double[][] datos = {
            {4500, 0, 0},
            {120, 38, 0},
            {120, 46, 0},
            {60000, 0.06, 0},
            {40000, 0.04, 2500}
        };

        double total = 0;
        for (int i = 0; i < ids.length; i++) {
            double pago = calcularPago(tipos[i], datos[i]);
            total += pago;
            System.out.printf("%-6s %-16s %-14s $%,10.2f%n",
                    ids[i], nombres[i], nombreTipo(tipos[i]), pago);
        }
        System.out.printf("%nTotal de la nomina: $%,.2f%n", total);
    }

    static double calcularPago(int tipo, double[] d) {
        switch (tipo) {
            case ASALARIADO:
                return d[0];
            case POR_HORAS:
                if (d[1] <= 40) {
                    return d[0] * d[1];
                }
                return 40 * d[0] + (d[1] - 40) * d[0] * 1.5;
            case POR_COMISION:
                return d[0] * d[1];
            case BASE_MAS_COMISION:
                return d[2] + d[0] * d[1];
            default:
                return 0;
        }
    }

    static String nombreTipo(int tipo) {
        switch (tipo) {
            case ASALARIADO:        return "Asalariado";
            case POR_HORAS:         return "Por horas";
            case POR_COMISION:      return "Por comision";
            case BASE_MAS_COMISION: return "Base+comision";
            default:                return "Desconocido";
        }
    }
}
