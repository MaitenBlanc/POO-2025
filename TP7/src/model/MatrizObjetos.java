package model;

import java.util.*;
import exceptions.*;

public class MatrizObjetos {

    private static final int max_rows = 200;
    private static final int max_cols = 200;
    private List<Integer>[] cuerpo;

    public MatrizObjetos(int filas, int columnas) throws MatrizException {
        List<ErrorMatriz> errores = new ArrayList<>();

        if (columnas > max_cols) {
            errores.add(ErrorMatriz.ERR_COLUMNAS_EXCEDIDAS);
        }

        if (filas > max_rows) {
            errores.add(ErrorMatriz.ERR_FILAS_EXCEDIDAS);
        }

        if (filas <= 0 || columnas <= 0) {
            errores.add(ErrorMatriz.ERR_DIMENSIONES_NEGATIVAS);
        }

        if (!errores.isEmpty()) {
            throw new MatrizException(errores);
        }

        // Inicialización de matriz
        cuerpo = new ArrayList[filas];
        for (int i = 0; i < filas; i++) {
            cuerpo[i] = new ArrayList<>(Collections.nCopies(columnas, 0));
        }
    }

    public void setRowCol(int row, int col, int value) throws MatrizException {
        validarIndices(row, col);
        cuerpo[row].set(col, value);
    }

    public int getRowCol(int row, int col) throws MatrizException {
        validarIndices(row, col);
        return cuerpo[row].get(col);
    }

    private void validarIndices(int row, int col) throws MatrizException {
        List<ErrorMatriz> errores = new ArrayList<>();

        if (row < 0 || row >= cuerpo.length) {
            errores.add(ErrorMatriz.ERR_FILA_FUERA_DE_RANGO);
        }
        if (col < 0 || col >= cuerpo[0].size()) {
            errores.add(ErrorMatriz.ERR_COLUMNA_FUERA_DE_RANGO);
        }
        if (!errores.isEmpty()) {
            throw new MatrizException(errores);
        }
    }

    @Override
    public String toString() {
        String staux = "";
        for (List<Integer> cuerpo1 : cuerpo) {
            for (int j = 0; j < cuerpo1.size(); j++) {
                staux = staux + cuerpo1.get(j) + " ";
            }
            staux = staux + "\n";
        }
        return staux;

    }
}
