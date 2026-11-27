/* Practica III - SOLUCION DOCENTE: ejercicio de figuras */
public class Figura {
    protected final String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public double area() {
        return 0;
    }

    public double perimetro() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%-10s area=%8.2f  perimetro=%7.2f",
                nombre, area(), perimetro());
    }
}
