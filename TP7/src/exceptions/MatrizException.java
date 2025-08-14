package exceptions;

import java.util.List;

import model.MensajesErrorController;

public class MatrizException extends Exception {

    public MatrizException(ErrorMatriz codigo) {
        super(MensajesErrorController.getMessage(codigo.name()));
    }

    // Constructor para múltiples errores
    public MatrizException(List<ErrorMatriz> codigos) {
        super(codigos.stream()
                .map(c -> MensajesErrorController.getMessage(c.name()))
                .reduce((a, b) -> a + " | " + b)
                .orElse("Error desconocido.")
        );
    }

    @Override
    public String toString() {
        return "ERROR MATRIZ: " + getMessage();
    }

}
