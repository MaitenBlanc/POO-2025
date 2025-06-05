package models;

public class Rectangulo extends Figura {
    private double minorSide;
    private double longerSide;

    public Rectangulo(String color, Punto center, String nameForm, double minorSide, double longerSide) {
        // Hereda de Figura
        super(color, center, nameForm);
        // Datos de rectángulo
        this.minorSide = minorSide;
        this.longerSide = longerSide;
    }

    public double getMinorSide() {
        return minorSide;
    }

    public void setMinorSide(double minorSide) {
        this.minorSide = minorSide;
    }

    public double getLongerSide() {
        return longerSide;
    }

    public void setLongerSide(double longerSide) {
        this.longerSide = longerSide;
    }

    // toString heredado de Figura
    @Override
    public String toString() {
        return "Rectangulo [" + super.toString() + ", lado menor= " + minorSide + ", lado mayor= " + longerSide + "]";
    }

    // Calcular área
    @Override
    public double calculateArea() {
        return minorSide * longerSide;
    }

    // Calcular perímetro
    @Override
    public double calculatePerimeter() {
        return minorSide * 2 + longerSide * 2;
    }

    // Cambiar tamaño
    public void resize(double scaleFactor) {
        if (scaleFactor <= 0) {
            System.out.println("El factor escala debe ser mayor que 0.");
            return;
        }

        minorSide *= scaleFactor;
        longerSide *= scaleFactor;
    }
}
