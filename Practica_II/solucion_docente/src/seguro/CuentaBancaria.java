package seguro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Practica II - SOLUCION DOCENTE: CuentaBancaria encapsulada.
 */
public class CuentaBancaria {

    private final String titular;
    private double saldo;
    private final List<String> historial = new ArrayList<>();

    public CuentaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular es obligatorio");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        registrar("DEPOSITO", monto);
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        registrar("RETIRO", monto);
        return true;
    }

    public boolean transferirA(CuentaBancaria destino, double monto) {
        if (destino == null || destino == this || monto <= 0 || monto > saldo) {
            return false;
        }
        // Acceso directo a los atributos privados de otro objeto de la
        // MISMA clase: el encapsulamiento en Java es por clase.
        this.saldo -= monto;
        destino.saldo += monto;
        this.registrar("TRANSFERENCIA ENVIADA", monto);
        destino.registrar("TRANSFERENCIA RECIBIDA", monto);
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public List<String> getHistorial() {
        return Collections.unmodifiableList(historial);
    }

    private void registrar(String tipo, double monto) {
        historial.add(String.format("%s %.2f", tipo, monto));
    }
}
