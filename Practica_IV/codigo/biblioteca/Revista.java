public class Revista extends Material {

    private final int numero;

    public Revista(String id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
    }

    @Override
    public String descripcion() {
        return getTitulo() + " No. " + numero;
    }
}
