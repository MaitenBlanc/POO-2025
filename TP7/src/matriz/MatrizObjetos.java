package matriz;

import java.util.*;

public class MatrizObjetos {

    static int max_rows = 200;
    static int max_cols = 200;
    private List<Object>[] cuerpo;

    public MatrizObjetos(int columnas, int filas) throws MatrizException {
        if (columnas > max_cols) {
            throw new MatrizException(MatrizException.Errores.ERR_COLUMNAS_EXCEDIDAS);
        }

        if (filas > max_rows) {
            throw new MatrizException(MatrizException.Errores.ERR_FILAS_EXCEDIDAS);
        }

        if (filas <= 0 || columnas <= 0) {
            throw new MatrizException(MatrizException.Errores.ERR_DIMENSIONES_NEGATIVAS);
        }

        // Inicialización de matriz
        cuerpo = new ArrayList[filas];
        for (int i = 0; i < filas; i++) {
            cuerpo[i] = new ArrayList<>(columnas);

            // Inicialización con null
            for (int j = 0; j < columnas; j++) {
                cuerpo[i].add(null);
            }

        }
    }

    public void ValidarIndices(int row, int col) throws MatrizException {
        if (row < 0 || row >= cuerpo.length) {
            throw new MatrizException(MatrizException.Errores.ERR_FILA_FUERA_DE_RANGO);
        } else if (col < 0 || col >= cuerpo[row].size()) {
            throw new MatrizException(MatrizException.Errores.ERR_COLUMNA_FUERA_DE_RANGO);
        }
    }

    public void SetRowCol(int row, int col, Object obj) throws MatrizException {
        ValidarIndices(row, col);
        cuerpo[row].set(col, obj);
    }

    public Object GetRowCol(int row, int col) throws MatrizException {
        ValidarIndices(row, col);
        return cuerpo[row].get(col);
    }

    @Override
    public String toString() {
        String staux = "";
        for (int i = 0; i < cuerpo.length; i++) {
            for (int j = 0; j < cuerpo[i].size(); j++) {
                staux = staux + cuerpo[i].get(j);
            }
        }
        return staux;

    }
}
