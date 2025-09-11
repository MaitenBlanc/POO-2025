package ej2.prueba_mia;

public class OperacionesArray {
    // Devuelve un Par con el máximo valor del array 

    public static <T extends Comparable<T>> Par<Integer, T> maximo(T[] array) {
// Lógica para validar los índices (opcional pero recomendado)
        if (array == null || array.length == 0) {
            return null;
        }
        int indexMax = 0;
        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
                indexMax = i;
            }
        }
        return new Par<>(indexMax, max);
    }

    public static <T> void imprimirArray(T[] array) {
        System.out.print("[ ");
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println("]");
    }
}
