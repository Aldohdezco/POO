import java.util.ArrayList;
import java.util.List;

/* Practica V - SOLUCION DOCENTE: coordina, pero no calcula ni imprime */
public class ServicioPedidos {
    private final Catalogo catalogo;
    private final RepositorioPedidos repositorio;
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private int consecutivo = 1;
    private int procesados = 0;

    public ServicioPedidos(Catalogo catalogo, RepositorioPedidos repositorio) {
        this.catalogo = catalogo;
        this.repositorio = repositorio;
    }

    public void suscribir(ObservadorPedido o) {
        observadores.add(o);
    }

    public boolean procesarPedido(Cliente cliente, String[] productos, int[] cantidades) {
        List<LineaPedido> lineas = construirLineas(cliente, productos, cantidades);
        if (lineas == null) {
            return false;
        }
        Pedido pedido = new Pedido(String.format("P%04d", consecutivo++), cliente,
                lineas, FabricaDescuentos.para(cliente.getTipo()));
        if (!repositorio.guardar(pedido)) {
            return false;
        }
        procesados++;
        for (ObservadorPedido o : observadores) {
            o.pedidoProcesado(pedido);
        }
        return true;
    }

    private List<LineaPedido> construirLineas(Cliente cliente, String[] productos,
                                              int[] cantidades) {
        if (cliente == null || cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            System.out.println("ERROR: cliente vacio");
            return null;
        }
        if (productos == null || cantidades == null
                || productos.length == 0 || productos.length != cantidades.length) {
            System.out.println("ERROR: productos y cantidades no coinciden");
            return null;
        }
        List<LineaPedido> lineas = new ArrayList<>();
        for (int i = 0; i < productos.length; i++) {
            Producto p = catalogo.buscar(productos[i]);
            if (p == null) {
                System.out.println("ERROR: producto inexistente " + productos[i]);
                return null;
            }
            if (cantidades[i] <= 0) {
                System.out.println("ERROR: cantidad invalida para " + productos[i]);
                return null;
            }
            lineas.add(new LineaPedido(p, cantidades[i]));
        }
        return lineas;
    }

    public int totalProcesados() {
        return procesados;
    }
}
