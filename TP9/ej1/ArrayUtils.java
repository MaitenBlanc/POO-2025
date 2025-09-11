package ej1;
class ArrayUtils {
    // T es un "parámetro de tipo" que será reemplazado por un tipo real

    public static <T> void intercambiar(T[] array, int indice1, int indice2) {
// Lógica para validar los índices (opcional pero recomendado)
        if (indice1 < 0 || indice1 >= array.length || indice2 < 0 || indice2 >= array.length) {
            System.out.println("Índices fuera de rango.");
            return;
        }
        T temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }
// EXTRA: Puedes pedirles que implementen otro método genérico, como imprimir un array.

    public static <T> void imprimirArray(T[] array) {
        System.out.print("[ ");
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println("]");
    }

}
