import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nIngrese una clasificacion: ");
        int clasificacion = scanner.nextInt();

        if (clasificacion < 0 || clasificacion > 10) {
            System.out.println("Clasificación inválida. Ingrese un número del 1 al 10.");
        } else if (clasificacion == 10) {
            System.out.println(ClasificacionNota.SOBRESALIENTE.getNombre());
        } else if (clasificacion >= 7 && clasificacion < 10) {
            System.out.println(ClasificacionNota.APROBADO.getNombre());
        } else {
            System.out.println(ClasificacionNota.REPROBADO.getNombre());
        }

        scanner.close();
    }
}
