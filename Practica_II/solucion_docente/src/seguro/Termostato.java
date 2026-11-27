package seguro;

/*
 * Practica II - SOLUCION DOCENTE: Termostato.
 */
public class Termostato {

    public static final double MINIMO = 10.0;
    public static final double MAXIMO = 30.0;
    public static final double PASO = 0.5;

    private boolean encendido = false;
    private double objetivo = 22.0;

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public boolean estaEncendido() {
        return encendido;
    }

    public boolean subir() {
        return encendido && setObjetivo(objetivo + PASO);
    }

    public boolean bajar() {
        return encendido && setObjetivo(objetivo - PASO);
    }

    public boolean setObjetivo(double valor) {
        if (valor < MINIMO || valor > MAXIMO) {
            return false;
        }
        objetivo = valor;
        return true;
    }

    public double getObjetivo() {
        return objetivo;
    }
}
