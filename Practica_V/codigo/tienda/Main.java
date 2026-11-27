/*
 * Practica V - Programa de prueba de la clase GestorPedidos.
 * Su version refactorizada debe producir los mismos totales.
 */
public class Main {
    public static void main(String[] args) {
        GestorPedidos gestor = new GestorPedidos("pedidos.txt");

        gestor.procesarPedido("Ana Lopez", "NORMAL", "ana@correo.mx", null,
                new String[]{"TECLADO", "MOUSE"}, new int[]{1, 2});

        gestor.procesarPedido("Bruno Diaz", "VIP", "bruno@correo.mx", "2221234567",
                new String[]{"MONITOR", "WEBCAM"}, new int[]{1, 1});

        gestor.procesarPedido("Carla Ruiz", "EMPLEADO", "", "2227654321",
                new String[]{"MONITOR", "AUDIFONOS"}, new int[]{2, 1});

        gestor.procesarPedido("Diego Mora", "FRECUENTE", "diego@correo.mx", null,
                new String[]{"AUDIFONOS"}, new int[]{0});

        System.out.println("Pedidos procesados: " + gestor.totalProcesados());
    }
}
