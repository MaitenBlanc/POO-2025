import java.util.Arrays;

public class ArrayEntero {
    private int[] numeros = { 4, 2, 3, 8, 1 };

    // Cuantos números hay en el array números
    public int cantidadNumeros() {
        int cantidad = numeros.length;
        return cantidad;
    }

    // Cual es el mayor.
    public int numeroMayor() {
        int mayor = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        return mayor;
    }

    // Cual es el promedio
    public double promedioArray() {
        double suma = 0;
        double promedio = 0;

        for (int i = 0; i < cantidadNumeros(); i++) {
            suma += numeros[i];
            promedio = suma / cantidadNumeros();
        }
        return promedio;
    }

    // Los números ordenados de menor a mayor y a la inversa.
    public int[] ordenAscendente() {
        int[] numerosAscendentes = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(numerosAscendentes);

        return numerosAscendentes;
    }

    public int[] ordenDescendente() {
        int[] numerosDescendentes = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(numerosDescendentes);

        for (int i = 0; i < numerosDescendentes.length / 2; i++) {
            // Hacemos un método de ordenamiento como en Pascal
            int aux = numerosDescendentes[i];
            numerosDescendentes[i] = numerosDescendentes[numerosDescendentes.length - 1 - i];
            numerosDescendentes[numerosDescendentes.length - 1 - i] = aux;
        }
        return numerosDescendentes;
    }

    // Para poder concatenar con los string de los sysout.
    public void imprimirArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
