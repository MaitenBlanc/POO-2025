package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class MultiplicadorMatrices {

    public static void main(String[] args) {
        // Matrices a multiplicar
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] B = {{7, 8}, {9, 10}, {11, 12}};

        // Matriz resultado
        int filas = A.length;
        int columnas = B[0].length;
        int[][] C = new int[filas][columnas];

        // Lista para guardar los hilos
        List<Thread> hilos = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Runnable tarea = new TareaMultiplicacion(A, B, C, i, j);
                Thread hilo = new Thread(tarea);
                hilo.start();
                hilos.add(hilo);
            }
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join(); // El hilo principal espera a que este hilo termine.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
