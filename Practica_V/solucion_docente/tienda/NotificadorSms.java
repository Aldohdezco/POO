public class NotificadorSms implements ObservadorPedido {
    @Override
    public void pedidoProcesado(Pedido p) {
        String tel = p.getCliente().getTelefono();
        if (tel != null && !tel.isBlank()) {
            System.out.println("[SMS a " + tel + "] Pedido " + p.getFolio() + " confirmado.");
        }
    }
}
