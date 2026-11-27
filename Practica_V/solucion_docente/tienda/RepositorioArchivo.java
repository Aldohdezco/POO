import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RepositorioArchivo implements RepositorioPedidos {
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final String archivo;

    public RepositorioArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public boolean guardar(Pedido p) {
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            out.printf("%s|%s|%s|%s|%.2f%n", p.getFolio(),
                    LocalDateTime.now().format(FORMATO),
                    p.getCliente().getNombre(), p.getCliente().getTipo(), p.total());
            return true;
        } catch (IOException e) {
            System.out.println("ERROR al guardar: " + e.getMessage());
            return false;
        }
    }
}
