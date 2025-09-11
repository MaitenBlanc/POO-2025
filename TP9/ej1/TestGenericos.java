package ej1;
public class TestGenericos {
    public static void main(String[] args) {
        // Prueba con un array de Integers
        Integer[] numeros = {10, 20, 30, 40, 50};
        System.out.println("Array de enteros original:");
        ArrayUtils.imprimirArray(numeros);

        ArrayUtils.intercambiar(numeros, 1, 3); // Intercambia 20 y 40

        System.out.println("Array de enteros después del intercambio:");
        ArrayUtils.imprimirArray(numeros);

        System.out.println("\n---------------------------------\n");

        // Prueba con un array de Strings
        String[] palabras = {"Hola", "Mundo", "desde", "Java"};
        System.out.println("Array de strings original:");
        ArrayUtils.imprimirArray(palabras);

        ArrayUtils.intercambiar(palabras, 0, 2); // Intercambia "Hola" y "desde"

        System.out.println("Array de strings después del intercambio:");
        ArrayUtils.imprimirArray(palabras);
    }
}
