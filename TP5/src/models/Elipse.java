package models;

public class Elipse extends Figura {
    private double minorR;
    private double majorR;

    public Elipse(String color, Punto center, String nameForm, double minorR, double majorR) {
        super(color, center, nameForm);
        this.minorR = minorR;
        this.majorR = majorR;
    }

    public double getMinorR() {
        return minorR;
    }

    public void setMinorR(double minorR) {
        this.minorR = minorR;
    }

    public double getMajorR() {
        return majorR;
    }

    public void setMajorR(double majorR) {
        this.majorR = majorR;
    }

    // Sobreescritura toString
    @Override
    public String toString() {
        return "Elipse [" + super.toString() + "]";
    }

    // Calcular área y perímetro sobreescribiendo los métodos de Figura
    @Override
    public double calculateArea() {
        return Math.PI * minorR * majorR;
    }

    // Fórmula usada --> p ≈ π*(3(a+b) − √(3a+b)(a+3b))
    @Override
    public double calculatePerimeter() {
        return Math.PI * (3 * (minorR + majorR) - Math.sqrt((3 * minorR + majorR) * (minorR + 3 * majorR)));
    }

    // Cambiar tamaño
    public void resize(double scaleFactor) {
        if (scaleFactor <= 0) {
            System.out.println("El factor escala debe ser mayor que 0.");
            return;
        }

        minorR *= scaleFactor;
        majorR *= scaleFactor;
    }
}
