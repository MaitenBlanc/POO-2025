package matriz;

public class MatrizException extends Exception {

    public enum Errores {
        ERR_COLUMNAS_EXCEDIDAS("El número de columnas excede el máximo permitido."),
        ERR_FILAS_EXCEDIDAS("El número de filas excede el máximo permitido."),
        ERR_DIMENSIONES_NEGATIVAS("Las dimensiones de la matriz no pueden ser negativas."),
        ERR_FILA_FUERA_DE_RANGO("El índice de la fila está fuera de rango."),
        ERR_COLUMNA_FUERA_DE_RANGO("El índice de la columna está fuera de rango.");

        private final String name;

        Errores(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    };

    public MatrizException(Errores codigo) {
        super(codigo.getName());
    }

    @Override
    public String toString() {
        return "ERROR MATRIZ: " + getMessage();
    }

}
