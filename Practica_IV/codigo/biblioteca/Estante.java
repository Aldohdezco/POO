import java.util.ArrayList;
import java.util.List;

public class Estante {

    private final String codigo;
    private final List<Material> materiales = new ArrayList<>();

    public Estante(String codigo) {
        this.codigo = codigo;
    }

    /** El material llega desde fuera y puede moverse a otro estante. */
    public void colocar(Material m) {
        materiales.add(m);
    }

    public Material retirar(String idMaterial) {
        Material m = buscar(idMaterial);
        materiales.remove(m);
        return m;
    }

    public Material buscar(String idMaterial) {
        for (Material m : materiales) {
            if (m.getId().equals(idMaterial)) {
                return m;
            }
        }
        return null;
    }

    public String getCodigo() {
        return codigo;
    }
}
