public class NotificadorCorreo implements ObservadorPedido {
    @Override
    public void pedidoProcesado(Pedido p) {
        String correo = p.getCliente().getCorreo();
        if (correo != null && correo.contains("@")) {
            System.out.println("[CORREO a " + correo + "] Su pedido " + p.getFolio()
                    + " por $" + String.format("%.2f", p.total()) + " fue registrado.");
        }
    }
}
