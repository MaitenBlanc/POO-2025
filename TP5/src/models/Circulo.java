package models;

public class Circulo extends Elipse {
    // Constructor con todos los atributos heredados de Elipse pero poniendo un solo
    // radio
    public Circulo(String color, Punto center, String nameForm, double radius) {
        super(color, center, nameForm, radius, radius);
    }

    @Override
    public void resize(double scaleFactor) {
        if (scaleFactor <= 0) {
            System.out.println("El factor escala debe ser mayor que 0.");
            return;
        }

        double minorR = getMinorR();
        double majorR = getMajorR();

        minorR *= scaleFactor;
        majorR = minorR;
    }

}
