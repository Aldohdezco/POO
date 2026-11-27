public class Libro extends Material {

    private final String autor;
    private final String isbn;

    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String descripcion() {
        return getTitulo() + " - " + autor + " (ISBN " + isbn + ")";
    }
}
