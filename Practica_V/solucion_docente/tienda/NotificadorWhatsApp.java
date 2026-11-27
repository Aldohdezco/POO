/* Extension pedida en la practica: un canal nuevo = una clase nueva */
public class NotificadorWhatsApp implements ObservadorPedido {
    @Override
    public void pedidoProcesado(Pedido p) {
        String tel = p.getCliente().getTelefono();
        if (tel != null && !tel.isBlank()) {
            System.out.println("[WHATSAPP a " + tel + "] Hola " + p.getCliente().getNombre()
                    + ", tu pedido " + p.getFolio() + " va en camino.");
        }
    }
}
