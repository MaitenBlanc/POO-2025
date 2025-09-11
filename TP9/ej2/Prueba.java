package ej2;

public class Prueba {

    public static void main(String[] args) {
        // ... (código del ejercicio 1)
        System.out.println("\n--- Ejercicio Clase Genérica ---\n");

        // Creamos un par que asocia un String con un Integer
        Par<String, Integer> producto = new Par<>("Laptop Gamer", 101);
        System.out.println("Producto: " + producto);

        // Creamos un par que asocia un String con un Double
        Par<String, Double> estudiante = new Par<>("Ana Pérez", 9.5);
        System.out.println("Estudiante: " + estudiante);

        // Demostración de la SEGURIDAD DE TIPOS
        Integer idProducto = producto.getSegundo();
        System.out.println("ID recuperado (ya es Integer, no necesita cast): " + idProducto);

        // ¡Esto dará un ERROR DE COMPILACIÓN!
        // El compilador sabe que el segundo elemento debe ser Integer.
        // descomente la siguiente línea para ver el error.
        // producto.setSegundo("ciento-uno");
    }
}
