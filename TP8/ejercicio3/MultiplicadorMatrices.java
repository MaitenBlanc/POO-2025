package ejercicio3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiplicadorMatrices {

    public static void main(String[] args) {
        // Matrices a multiplicar
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] B = {{7, 8}, {9, 10}, {11, 12}};

        // Matriz resultado
        int filas = A.length;
        int columnas = B[0].length;
        int[][] C = new int[filas][columnas];

        // N° de procesadores disponibles.
        int numProcesadores = Runtime.getRuntime().availableProcessors();
        // Hilos
        ExecutorService executor = Executors.newFixedThreadPool(numProcesadores);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Runnable tarea = new TareaMultiplicacion(A, B, C, i, j);
                executor.submit(tarea);
            }
        }

        // Apagado del executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdown();
            Thread.currentThread().interrupt();
        }

        System.out.println("\nMatriz resultante: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
