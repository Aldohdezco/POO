/* Practica V - SOLUCION DOCENTE: mismo escenario que la clase Dios */
public class Main {
    public static void main(String[] args) {
        ServicioPedidos servicio = new ServicioPedidos(Catalogo.predeterminado(),
                new RepositorioArchivo("pedidos.txt"));
        servicio.suscribir(new NotificadorCorreo());
        servicio.suscribir(new NotificadorSms());
        servicio.suscribir(new ImpresoraTicket());

        servicio.procesarPedido(new Cliente("Ana Lopez", "NORMAL", "ana@correo.mx", null),
                new String[]{"TECLADO", "MOUSE"}, new int[]{1, 2});
        servicio.procesarPedido(new Cliente("Bruno Diaz", "VIP", "bruno@correo.mx", "2221234567"),
                new String[]{"MONITOR", "WEBCAM"}, new int[]{1, 1});
        servicio.procesarPedido(new Cliente("Carla Ruiz", "EMPLEADO", "", "2227654321"),
                new String[]{"MONITOR", "AUDIFONOS"}, new int[]{2, 1});
        servicio.procesarPedido(new Cliente("Diego Mora", "FRECUENTE", "diego@correo.mx", null),
                new String[]{"AUDIFONOS"}, new int[]{0});

        System.out.println("Pedidos procesados: " + servicio.totalProcesados());
    }
}
