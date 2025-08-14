package exceptions;

import controllers.MensajesErrorController;
import model.ErrorEmpleado;

public class NoEncontradoException extends Exception {

    public NoEncontradoException(ErrorEmpleado mensaje) {
        super(MensajesErrorController.getMessage(mensaje.name()));
    }

}
