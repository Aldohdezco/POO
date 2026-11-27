import java.time.LocalDate;

public class Prestamo {

    private final Socio socio;
    private final Material material;
    private final LocalDate inicio;
    private final LocalDate vence;

    Prestamo(Socio socio, Material material, LocalDate inicio, int dias) {
        this.socio = socio;
        this.material = material;
        this.inicio = inicio;
        this.vence = inicio.plusDays(dias);
    }

    public boolean estaVencido(LocalDate hoy) {
        return hoy.isAfter(vence);
    }

    public Socio getSocio() {
        return socio;
    }

    public Material getMaterial() {
        return material;
    }

    public LocalDate getVence() {
        return vence;
    }
}
