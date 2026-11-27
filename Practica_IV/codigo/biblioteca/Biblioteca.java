import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private static final int DIAS_PRESTAMO = 7;

    private final List<Estante> estantes = new ArrayList<>();
    private final List<Socio> socios = new ArrayList<>();
    private final List<Prestamo> prestamos = new ArrayList<>();

    /** La biblioteca CREA sus propios estantes al construirse. */
    public Biblioteca(int numeroEstantes) {
        for (int i = 1; i <= numeroEstantes; i++) {
            estantes.add(new Estante("E" + i));
        }
    }

    /** Los socios existen antes y fuera de la biblioteca. */
    public void registrarSocio(Socio s) {
        socios.add(s);
    }

    public void colocarEnEstante(int numero, Material m) {
        estantes.get(numero - 1).colocar(m);
    }

    public Prestamo prestar(Socio socio, String idMaterial, LocalDate hoy) {
        for (Estante e : estantes) {
            Material m = e.buscar(idMaterial);
            if (m != null && m.estaDisponible()) {
                m.marcarPrestado();
                Prestamo p = new Prestamo(socio, m, hoy, DIAS_PRESTAMO);
                prestamos.add(p);
                return p;
            }
        }
        return null;
    }

    /** El Notificador solo se usa durante esta llamada. */
    public void revisarVencimientos(Notificador n, LocalDate hoy) {
        for (Prestamo p : prestamos) {
            if (p.estaVencido(hoy)) {
                n.avisar(p);
            }
        }
    }
}
