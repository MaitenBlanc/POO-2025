package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MensajesErrorController {

    private static final Properties errores;

    // Carga una sola vez el archivo errores.properties
    static {
        String route = "/resources/errores.properties";
        errores = new Properties();

        try (InputStream input = MensajesErrorController.class.getResourceAsStream(route)) {
            if (input == null) {
                System.out.println("No se encontró el archivo 'errores.properties'.");
            } else {
                errores.load(input);
            }
        } catch (IOException ex) {
            System.out.println("Error al cargar el archivo de errores: " + ex.getMessage());
        }
    }

    public static String getMessage(String errorCode) {
        return errores.getProperty(errorCode, "Error desconocido.");
    }
}
