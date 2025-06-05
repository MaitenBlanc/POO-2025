package models;

public class Cuadrado extends Rectangulo {

    // Constructor con todos los atributos heredados de Rectángulo pero poniendo un
    // solo lado
    public Cuadrado(String color, Punto center, String nameForm, double side) {
        super(color, center, nameForm, side, side);
    }

    @Override
    public void resize(double scaleFactor) {
        if (scaleFactor <= 0) {
            System.out.println("El factor de escala debe ser mayor que 0.");
            return;
        }
        double minorSide = getMinorSide();
        double longerSide = getLongerSide();

        minorSide *= scaleFactor;
        longerSide = minorSide;
    }

}
