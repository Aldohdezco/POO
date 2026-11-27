package inseguro;

/*
 * Practica II - Demuestra como se rompen las reglas del negocio
 * cuando los datos no estan encapsulados.
 *
 *   javac -d out $(find src -name "*.java")
 *   java -cp out inseguro.DemoInsegura
 */
public class DemoInsegura {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 1000);
        System.out.println("Saldo inicial: " + cuenta.saldo);

        // Ataque 1: retirar mas de lo que hay
        cuenta.saldo -= 5000;
        System.out.println("Saldo despues de retirar 5000: " + cuenta.saldo);

        // Ataque 2: "depositar" sin dejar rastro en el historial
        cuenta.saldo += 1_000_000;
        System.out.println("Saldo inflado: " + cuenta.saldo);

        // Ataque 3: borrar la evidencia
        cuenta.historial.add("RETIRO 5000.00");
        cuenta.historial.clear();
        System.out.println("Movimientos registrados: " + cuenta.historial.size());

        // Ataque 4: dejar la cuenta sin titular
        cuenta.titular = null;
        System.out.println("Titular: " + cuenta.titular);

        // Ataque 5: crear una cuenta con saldo negativo
        CuentaBancaria otra = new CuentaBancaria("", -300);
        System.out.println("Cuenta '" + otra.titular + "' con saldo " + otra.saldo);
    }
}
