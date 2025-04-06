package Ej6;

public class Empleado {
    private String nombre;
    private double sueldo;

    // Constructor empleado
    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String toString() {
        return nombre + " - $" + sueldo;
    }
}
