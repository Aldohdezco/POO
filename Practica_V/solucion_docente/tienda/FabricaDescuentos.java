/* Practica V - SOLUCION DOCENTE: patron Factory (metodo de fabrica simple) */
public class FabricaDescuentos {
    public static EstrategiaDescuento para(String tipoCliente) {
        if (tipoCliente == null) {
            return new SinDescuento();
        }
        switch (tipoCliente) {
            case "FRECUENTE":  return new DescuentoFrecuente();
            case "VIP":        return new DescuentoVip();
            case "EMPLEADO":   return new DescuentoEmpleado();
            case "ESTUDIANTE": return new DescuentoEstudiante();
            default:           return new SinDescuento();
        }
    }
}
