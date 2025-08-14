package exceptions;

import controllers.MensajesErrorController;
import model.ErrorEmpleado;

public class CollectionVaciaException extends Exception {

    public CollectionVaciaException(ErrorEmpleado mensaje) {
        super(MensajesErrorController.getMessage(mensaje.name()));
    }

}
