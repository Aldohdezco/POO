import java.util.Collections;
import java.util.List;

/* Practica V - SOLUCION DOCENTE: reglas de calculo de UN pedido */
public class Pedido {
    public static final double TASA_IVA = 0.16;

    private final String folio;
    private final Cliente cliente;
    private final List<LineaPedido> lineas;
    private final EstrategiaDescuento estrategia;

    public Pedido(String folio, Cliente cliente, List<LineaPedido> lineas,
                  EstrategiaDescuento estrategia) {
        this.folio = folio;
        this.cliente = cliente;
        this.lineas = List.copyOf(lineas);
        this.estrategia = estrategia;
    }

    public double subtotal() {
        double s = 0;
        for (LineaPedido l : lineas) {
            s += l.importe();
        }
        return s;
    }

    public double descuento() {
        return estrategia.aplicar(subtotal());
    }

    public double iva() {
        return (subtotal() - descuento()) * TASA_IVA;
    }

    public double total() {
        return subtotal() - descuento() + iva();
    }

    public String getFolio() { return folio; }
    public Cliente getCliente() { return cliente; }
    public List<LineaPedido> getLineas() { return Collections.unmodifiableList(lineas); }
}
