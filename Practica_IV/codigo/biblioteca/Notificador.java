public class Notificador {

    public void avisar(Prestamo p) {
        System.out.println("Aviso a " + p.getSocio().getNombre()
                + ": el prestamo de '" + p.getMaterial().getTitulo()
                + "' vencio el " + p.getVence());
    }
}
