public abstract class Material implements Prestable {

    private final String id;
    private final String titulo;
    private boolean disponible = true;

    protected Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract String descripcion();

    @Override
    public boolean estaDisponible() {
        return disponible;
    }

    @Override
    public void marcarPrestado() {
        disponible = false;
    }

    @Override
    public void marcarDevuelto() {
        disponible = true;
    }
}
