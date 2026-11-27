public class ImpresoraTicket implements ObservadorPedido {
    @Override
    public void pedidoProcesado(Pedido p) {
        System.out.println("========== TICKET " + p.getFolio() + " ==========");
        System.out.println("Cliente: " + p.getCliente().getNombre()
                + " (" + p.getCliente().getTipo() + ")");
        for (LineaPedido l : p.getLineas()) {
            System.out.printf("  %-10s x%-3d %10.2f%n", l.getProducto().getNombre(),
                    l.getCantidad(), l.importe());
        }
        System.out.printf("  Subtotal:        %10.2f%n", p.subtotal());
        System.out.printf("  Descuento:      -%10.2f%n", p.descuento());
        System.out.printf("  IVA (16%%):       %10.2f%n", p.iva());
        System.out.printf("  TOTAL:           %10.2f%n", p.total());
        System.out.println("====================================");
    }
}
