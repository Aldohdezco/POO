package inseguro;

import java.util.ArrayList;

/*
 * Practica II - Version INSEGURA de una cuenta bancaria.
 * Todos los atributos son publicos: cualquier clase puede leerlos y
 * modificarlos sin ninguna regla. NO corrija este archivo; sirve como
 * punto de comparacion.
 */
public class CuentaBancaria {
    public String titular;
    public double saldo;
    public ArrayList<String> historial = new ArrayList<>();

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
}
