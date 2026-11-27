/* Practica V - SOLUCION DOCENTE: cambio de requerimientos (paso 9) */
public class MainExtension {
    public static void main(String[] args) {
        ServicioPedidos servicio = new ServicioPedidos(Catalogo.predeterminado(),
                new RepositorioArchivo("pedidos.txt"));
        servicio.suscribir(new NotificadorWhatsApp());   // canal nuevo
        servicio.suscribir(new ImpresoraTicket());

        servicio.procesarPedido(new Cliente("Elena Vega", "ESTUDIANTE", null, "2225550000"),
                new String[]{"AUDIFONOS", "WEBCAM"}, new int[]{1, 1});
    }
}
