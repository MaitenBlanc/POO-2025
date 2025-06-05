package models;

public class Punto {
    private double coordX;
    private double coordY;

    public Punto(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public void moveCenter(double newX, double newY) {
        this.coordX = newX;
        this.coordY = newY;
    }

    @Override
    public String toString() {
        return "Punto [Coordenada X= " + coordX + ", coordenada Y= " + coordY + "]";
    }

}
