package ej1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploIntroductorio {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Lista original: " + numeros);

        // 1. Filtrar (filter): Quedarnos solo con los números pares.
        // La lambda 'n -> n % 2 == 0' es un Predicate. Devuelve true si el número es par.
        System.out.println("\n--- Solo números pares ---");
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(pares);

        // 2. Transformar (map): Convertir cada número en su cuadrado.
        // La lambda 'n -> n * n' es una Function. Toma un entero y devuelve otro entero.
        System.out.println("\n--- El cuadrado de cada número ---");
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(cuadrados);

        // 3. Encadenar operaciones: Filtrar pares, elevarlos al cuadrado y sumarlos.
        // Esta es la verdadera potencia de los streams.
        System.out.println("\n--- Suma de los cuadrados de los números pares ---");
        int sumaDeCuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0) // Nos quedamos con [2, 4, 6, 8, 10]
                .mapToInt(n -> n * n) // Transformamos a [4, 16, 36, 64, 100]
                .sum();                       // Sumamos todo: 220

        System.out.println("La suma es: " + sumaDeCuadradosPares);
    }
}
