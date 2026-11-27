public class PruebaFiguras {
    public static void main(String[] args) {
        Figura[] figuras = {
            new Circulo(3), new Rectangulo(4, 5), new Triangulo(3, 4, 5)
        };
        Figura mayor = figuras[0];
        for (Figura f : figuras) {
            System.out.println(f);
            if (f.area() > mayor.area()) {
                mayor = f;
            }
        }
        System.out.println("Figura de mayor area: " + mayor.nombre);
    }
}
