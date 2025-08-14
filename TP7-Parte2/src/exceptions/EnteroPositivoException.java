package exceptions;

import controllers.MensajesErrorController;
import model.ErrorEmpleado;

public class EnteroPositivoException extends Exception {

    public EnteroPositivoException(ErrorEmpleado mensaje) {
        super(MensajesErrorController.getMessage(mensaje.name()));
    }

}
