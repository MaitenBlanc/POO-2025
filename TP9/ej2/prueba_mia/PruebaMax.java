package ej2.prueba_mia;

public class PruebaMax {

    public static void main(String[] args) {
        // Array de enteros
        Integer[] numeros = {10, 45, 3, 99, 56};
        System.out.println("Array de enteros:");
        OperacionesArray.imprimirArray(numeros);
        Par<Integer, Integer> maxEntero = OperacionesArray.maximo(numeros);
        System.out.println("Máximo en enteros (índice, valor): " + maxEntero);

        System.out.println("\n---------------------------------\n");

        // Array de Strings
        String[] palabras = {"Hola", "Mundo", "Con", "Java"};
        System.out.println("Array de strings:");
        OperacionesArray.imprimirArray(palabras);
        Par<Integer, String> maxString = OperacionesArray.maximo(palabras);
        System.out.println("Máximo en strings (índice, valor): " + maxString);
    }
}
