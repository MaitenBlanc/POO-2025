
import exceptions.MatrizException;
import model.MatrizObjetos;

class App {

    public static void main(String args[]) {
        // Error columnas excedidas
        try {
            System.out.println("\nPrueba matriz columnas excedidas: ");
            MatrizObjetos maColExceeded = new MatrizObjetos(2, 400);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Error filas excedidas
        try {
            System.out.println("Prueba matriz filas excedidas: ");
            MatrizObjetos maRowExceeded = new MatrizObjetos(400, 2);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Error filas y columnas excedidas
        try {
            System.out.println("Prueba matriz filas y columnas excedidas: ");
            MatrizObjetos maRowColExceeded = new MatrizObjetos(400, 400);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Error dimensiones negativas
        try {
            System.out.println("Prueba matriz dimensiones negativas: ");
            MatrizObjetos maNegativeDim = new MatrizObjetos(-2, 6);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Matriz válida para pruebas siguientes
        MatrizObjetos matrix;
        try {
            System.out.println("Creación matriz válida 5x5");
            matrix = new MatrizObjetos(5, 5);
        } catch (MatrizException e) {
            System.out.println(e);
            return;
        }

        // Error fila fuera de rango
        try {
            System.out.println("Prueba matriz fila fuera de rango: ");
            matrix.setRowCol(10, 0, 3);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Error columna fuera de rango
        try {
            System.out.println("Prueba matriz columna fuera de rango: ");
            matrix.getRowCol(0, 10);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Error columna fuera de rango
        try {
            System.out.println("Prueba matriz fila y columna fuera de rango: ");
            matrix.setRowCol(10, 10, 5);
        } catch (MatrizException e) {
            System.out.println(e);
        }

        // Prueba Exitosa
        try {
            System.out.println("Prueba exitosa (setRowCol y getRowCol válidos): ");
            matrix.setRowCol(2, 3, 99);
            int valor = matrix.getRowCol(2, 3);
            System.out.println("Valor en matriz(2,3): " + valor);
            System.out.println("Matriz actualizada: ");
            System.out.println(matrix);
        } catch (MatrizException e) {
            // No debería fallar
            System.out.println(e);
        }
    }
}
