package ejercicio2;

public class TareaMultiplicacion implements Runnable {

    private int[][] A;
    private int[][] B;
    private int[][] C;
    private int fila;
    private int columna;

    public TareaMultiplicacion(int[][] A, int[][] B, int[][] C, int fila, int columna) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.columna = columna;
        this.fila = fila;
    }

    @Override
    public void run() {
        // Producto punto: a.b = a1*b1 + a2*b2 + ... +an*bn
        int suma = 0;
        for (int i = 0; i < B.length; i++) {
            suma += A[fila][i] * B[i][columna];
        }
        C[fila][columna] = suma;
    }

}
