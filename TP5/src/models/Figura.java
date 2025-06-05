package models;

public abstract class Figura {
    private String color;
    private Punto center;
    private String nameForm;

    public Figura(String color, Punto center, String nameForm) {
        this.color = color;
        this.center = center;
        this.nameForm = nameForm;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCenter(Punto center) {
        this.center = center;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    // toString heredado de Object
    @Override
    public String toString() {
        return "Figura [color= " + color + ", centro= " + center + ", Forma= " + nameForm + "]";
    }

    // Obtener color
    public String getColor() {
        return color;
    }

    // Cambiar color
    public void changeColor(String newColor) {
        this.color = newColor;
    }

    // Mover la forma (centro)
    public void moveCenter(double newX, double newY) {
        center.moveCenter(newX, newY);
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}
