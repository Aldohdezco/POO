/* Practica V - SOLUCION DOCENTE: patron Strategy */
public interface EstrategiaDescuento {
    /** Devuelve el MONTO a descontar para el subtotal dado. */
    double aplicar(double subtotal);
}
