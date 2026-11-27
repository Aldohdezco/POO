package seguro;

import java.util.List;

/*
 * Practica II - Version ENCAPSULADA de la cuenta bancaria (esqueleto).
 *
 * Reglas del negocio (invariantes) que la clase DEBE garantizar:
 *   1. El titular nunca es null ni vacio.
 *   2. El saldo nunca es negativo.
 *   3. Solo se puede depositar o retirar una cantidad mayor que cero.
 *   4. Cada deposito, retiro o transferencia exitosa agrega una linea
 *      al historial ("DEPOSITO 500.00", "RETIRO 200.00", ...).
 *   5. Nadie fuera de la clase puede modificar el historial.
 *
 * Complete los TODO. Verifique su trabajo ejecutando:
 *   java -cp out seguro.PruebasEncapsulamiento
 */
public class CuentaBancaria {

    // TODO 1: declare los atributos titular, saldo e historial
    //         con el modificador de acceso adecuado.

    /**
     * TODO 2: valide los parametros. Si el titular es null o vacio, o el
     * saldo inicial es negativo, lance:
     *     throw new IllegalArgumentException("mensaje");
     */
    public CuentaBancaria(String titular, double saldoInicial) {
    }

    /** TODO 3: devuelve false si el monto no es valido. */
    public boolean depositar(double monto) {
        return false;
    }

    /** TODO 4: devuelve false si el monto no es valido o no hay fondos. */
    public boolean retirar(double monto) {
        return false;
    }

    /**
     * TODO 5: transfiere dinero a otra cuenta. Debe ser "todo o nada":
     * si el retiro falla, el destino no recibe nada.
     */
    public boolean transferirA(CuentaBancaria destino, double monto) {
        return false;
    }

    public double getSaldo() {
        return 0;          // TODO 6
    }

    public String getTitular() {
        return null;       // TODO 7
    }

    /** TODO 8: devuelva una vista que NO permita modificar el historial. */
    public List<String> getHistorial() {
        return List.of();
    }

    // Pregunta para el reporte: por que NO existe un metodo setSaldo()?
}
