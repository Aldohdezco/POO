public class Triangulo extends Figura {
    private final double a, b, c;

    public Triangulo(double a, double b, double c) {
        super("Triangulo");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {            // formula de Heron
        double s = perimetro() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimetro() {
        return a + b + c;
    }
}
