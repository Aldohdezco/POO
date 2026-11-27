import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca(3);
        Socio ana = new Socio("S01", "Ana Lopez");
        bib.registrarSocio(ana);

        bib.colocarEnEstante(1, new Libro("L01", "Java: How to Program",
                "Deitel", "978-0134743356"));
        bib.colocarEnEstante(2, new Revista("R01", "Comunicaciones ACM", 68));

        LocalDate hoy = LocalDate.of(2026, 9, 1);
        Prestamo p = bib.prestar(ana, "L01", hoy);
        System.out.println("Prestado: " + p.getMaterial().descripcion());
        System.out.println("Segundo intento: " + bib.prestar(ana, "L01", hoy));

        bib.revisarVencimientos(new Notificador(), hoy.plusDays(10));
    }
}
