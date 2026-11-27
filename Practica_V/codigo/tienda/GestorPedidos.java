import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Practica V - "Clase Dios" (God Class).
 *
 * Esta clase FUNCIONA, pero concentra demasiadas responsabilidades.
 * Su tarea es analizarla y refactorizarla. No agregue funcionalidad aqui.
 *
 *   javac *.java
 *   java Main
 */
public class GestorPedidos {

    private final Map<String, Double> catalogo = new HashMap<>();
    private final List<String> pedidosProcesados = new ArrayList<>();
    private final String archivo;
    private int consecutivo = 1;

    public GestorPedidos(String archivo) {
        this.archivo = archivo;
        catalogo.put("TECLADO", 450.0);
        catalogo.put("MOUSE", 280.0);
        catalogo.put("MONITOR", 3899.0);
        catalogo.put("AUDIFONOS", 799.0);
        catalogo.put("WEBCAM", 1150.0);
    }

    public boolean procesarPedido(String cliente, String tipoCliente,
                                  String correo, String telefono,
                                  String[] productos, int[] cantidades) {
        // 1. Validacion
        if (cliente == null || cliente.isBlank()) {
            System.out.println("ERROR: cliente vacio");
            return false;
        }
        if (productos == null || cantidades == null
                || productos.length == 0 || productos.length != cantidades.length) {
            System.out.println("ERROR: productos y cantidades no coinciden");
            return false;
        }
        for (int i = 0; i < productos.length; i++) {
            if (!catalogo.containsKey(productos[i])) {
                System.out.println("ERROR: producto inexistente " + productos[i]);
                return false;
            }
            if (cantidades[i] <= 0) {
                System.out.println("ERROR: cantidad invalida para " + productos[i]);
                return false;
            }
        }

        // 2. Subtotal
        double subtotal = 0;
        for (int i = 0; i < productos.length; i++) {
            subtotal += catalogo.get(productos[i]) * cantidades[i];
        }

        // 3. Descuento segun el tipo de cliente
        double descuento;
        switch (tipoCliente) {
            case "FRECUENTE":
                descuento = subtotal * 0.05;
                break;
            case "VIP":
                descuento = subtotal * 0.10;
                if (subtotal > 5000) {
                    descuento += subtotal * 0.05;
                }
                break;
            case "EMPLEADO":
                descuento = Math.min(subtotal * 0.20, 1000);
                break;
            default:
                descuento = 0;
        }

        // 4. Impuestos
        double base = subtotal - descuento;
        double iva = base * 0.16;
        double total = base + iva;

        // 5. Persistencia en archivo de texto
        String folio = String.format("P%04d", consecutivo++);
        String fecha = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            out.printf("%s|%s|%s|%s|%.2f%n", folio, fecha, cliente, tipoCliente, total);
        } catch (IOException e) {
            System.out.println("ERROR al guardar: " + e.getMessage());
            return false;
        }
        pedidosProcesados.add(folio);

        // 6. Notificaciones
        if (correo != null && correo.contains("@")) {
            System.out.println("[CORREO a " + correo + "] Su pedido " + folio
                    + " por $" + String.format("%.2f", total) + " fue registrado.");
        }
        if (telefono != null && !telefono.isBlank()) {
            System.out.println("[SMS a " + telefono + "] Pedido " + folio + " confirmado.");
        }

        // 7. Ticket
        System.out.println("========== TICKET " + folio + " ==========");
        System.out.println("Cliente: " + cliente + " (" + tipoCliente + ")");
        for (int i = 0; i < productos.length; i++) {
            double precio = catalogo.get(productos[i]);
            System.out.printf("  %-10s x%-3d %10.2f%n", productos[i],
                    cantidades[i], precio * cantidades[i]);
        }
        System.out.printf("  Subtotal:        %10.2f%n", subtotal);
        System.out.printf("  Descuento:      -%10.2f%n", descuento);
        System.out.printf("  IVA (16%%):       %10.2f%n", iva);
        System.out.printf("  TOTAL:           %10.2f%n", total);
        System.out.println("====================================");
        return true;
    }

    public int totalProcesados() {
        return pedidosProcesados.size();
    }
}
