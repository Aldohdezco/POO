import java.util.HashMap;
import java.util.Map;

/* Practica V - SOLUCION DOCENTE: unica responsabilidad = conocer productos */
public class Catalogo {
    private final Map<String, Producto> productos = new HashMap<>();

    public void agregar(Producto p) {
        productos.put(p.getNombre(), p);
    }

    public Producto buscar(String nombre) {
        return productos.get(nombre);
    }

    public static Catalogo predeterminado() {
        Catalogo c = new Catalogo();
        c.agregar(new Producto("TECLADO", 450.0));
        c.agregar(new Producto("MOUSE", 280.0));
        c.agregar(new Producto("MONITOR", 3899.0));
        c.agregar(new Producto("AUDIFONOS", 799.0));
        c.agregar(new Producto("WEBCAM", 1150.0));
        return c;
    }
}
