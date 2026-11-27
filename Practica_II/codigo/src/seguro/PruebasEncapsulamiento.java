package seguro;

import java.util.List;

/*
 * Practica II - Pruebas automaticas. NO modifique este archivo.
 * Todas las pruebas deben mostrar [OK] cuando su implementacion este lista.
 *
 *   javac -d out $(find src -name "*.java")
 *   java -cp out seguro.PruebasEncapsulamiento
 */
public class PruebasEncapsulamiento {

    private static int ok = 0;
    private static int total = 0;

    public static void main(String[] args) {
        System.out.println("--- CuentaBancaria ---");
        CuentaBancaria c = new CuentaBancaria("Ana Lopez", 1000);
        verificar("saldo inicial", c.getSaldo() == 1000);
        verificar("titular", "Ana Lopez".equals(c.getTitular()));
        verificar("deposito valido", c.depositar(500) && c.getSaldo() == 1500);
        verificar("deposito negativo rechazado", !c.depositar(-10) && c.getSaldo() == 1500);
        verificar("deposito cero rechazado", !c.depositar(0));
        verificar("retiro valido", c.retirar(200) && c.getSaldo() == 1300);
        verificar("retiro sin fondos rechazado", !c.retirar(5000) && c.getSaldo() == 1300);
        verificar("historial con 2 movimientos", c.getHistorial().size() == 2);
        verificar("historial no modificable", historialProtegido(c));

        CuentaBancaria d = new CuentaBancaria("Bruno Diaz", 0);
        verificar("transferencia valida",
                c.transferirA(d, 300) && c.getSaldo() == 1000 && d.getSaldo() == 300);
        verificar("transferencia sin fondos es todo o nada",
                !d.transferirA(c, 999) && c.getSaldo() == 1000 && d.getSaldo() == 300);
        verificar("constructor rechaza titular vacio", lanzaExcepcion("", 100));
        verificar("constructor rechaza titular null", lanzaExcepcion(null, 100));
        verificar("constructor rechaza saldo negativo", lanzaExcepcion("Carla", -1));

        System.out.println("--- Termostato ---");
        Termostato t = new Termostato();
        verificar("inicia apagado en 22", !t.estaEncendido() && t.getObjetivo() == 22.0);
        verificar("apagado no sube", !t.subir() && t.getObjetivo() == 22.0);
        t.encender();
        verificar("encendido sube 0.5", t.subir() && t.getObjetivo() == 22.5);
        verificar("encendido baja 0.5", t.bajar() && t.getObjetivo() == 22.0);
        verificar("setObjetivo fuera de rango", !t.setObjetivo(35) && t.getObjetivo() == 22.0);
        verificar("setObjetivo valido", t.setObjetivo(30.0) && t.getObjetivo() == 30.0);
        verificar("no supera el maximo", !t.subir() && t.getObjetivo() == 30.0);
        t.setObjetivo(10.0);
        verificar("no baja del minimo", !t.bajar() && t.getObjetivo() == 10.0);

        System.out.printf("%nResultado: %d de %d pruebas correctas%n", ok, total);
    }

    private static boolean historialProtegido(CuentaBancaria c) {
        try {
            List<String> h = c.getHistorial();
            int antes = c.getHistorial().size();
            h.clear();
            return c.getHistorial().size() == antes && antes > 0;
        } catch (UnsupportedOperationException e) {
            return true;
        }
    }

    private static boolean lanzaExcepcion(String titular, double saldo) {
        try {
            new CuentaBancaria(titular, saldo);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void verificar(String nombre, boolean condicion) {
        total++;
        if (condicion) {
            ok++;
        }
        System.out.printf("[%s] %s%n", condicion ? "OK" : "FALLA", nombre);
    }
}
