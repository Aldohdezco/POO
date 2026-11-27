/* Practica V - SOLUCION DOCENTE */
public class Cliente {
    private final String nombre;
    private final String tipo;
    private final String correo;
    private final String telefono;

    public Cliente(String nombre, String tipo, String correo, String telefono) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}
