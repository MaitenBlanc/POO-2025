package exceptions;

import controllers.MensajesErrorController;
import model.ErrorEmpleado;

public class StringException extends Exception {

    public StringException(ErrorEmpleado message) {
        super(MensajesErrorController.getMessage(message.name()));
    }

}
