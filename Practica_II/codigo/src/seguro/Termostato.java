package seguro;

/*
 * Practica II - Termostato (esqueleto).
 *
 * Especificacion:
 *   - La temperatura objetivo siempre esta en el rango [10.0, 30.0] C.
 *   - Al crearse, el termostato esta APAGADO con objetivo de 22.0 C.
 *   - subir() y bajar() cambian el objetivo en 0.5 C; devuelven false si
 *     el termostato esta apagado o si se saldria del rango.
 *   - setObjetivo(valor) devuelve false si el valor esta fuera de rango.
 *   - encender() / apagar() cambian el estado.
 *
 * Usted decide los atributos y su visibilidad.
 */
public class Termostato {

    public static final double MINIMO = 10.0;
    public static final double MAXIMO = 30.0;
    public static final double PASO = 0.5;

    public void encender() {
    }

    public void apagar() {
    }

    public boolean estaEncendido() {
        return false;
    }

    public boolean subir() {
        return false;
    }

    public boolean bajar() {
        return false;
    }

    public boolean setObjetivo(double valor) {
        return false;
    }

    public double getObjetivo() {
        return 0;
    }
}
