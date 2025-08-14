
import exceptions.*;
import model.Empleado;
import service.EmpleadoService;

public class App {

    public static void main(String[] args) {
        try {
            // Nombre inválido
            Empleado e1 = new Empleado("Ma", 4000);
            e1.setLegajo(1);
            EmpleadoService.agregar(e1);
        } catch (StringException | EnteroPositivoException ex) {
            System.out.println("\nError: " + ex.getMessage());
        }

        try {
            // Empleado válido
            Empleado e2 = new Empleado("Marcos", 10000);
            e2.setLegajo(2);
            EmpleadoService.agregar(e2);

            // Empleado válido
            Empleado e3 = new Empleado("Romina", 5000);
            e3.setLegajo(3);
            EmpleadoService.agregar(e3);

            // Sueldo inválido
            Empleado e4 = new Empleado("Ana", -400);
            e4.setLegajo(4);
            EmpleadoService.agregar(e4);
        } catch (StringException | EnteroPositivoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            // Legajo inválido
            Empleado e5 = new Empleado("Pedro", 1500);
            e5.setLegajo(-1);
            EmpleadoService.agregar(e5);
        } catch (StringException | EnteroPositivoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            // Mostrar mayor sueldo
            Empleado mayorSueldo = EmpleadoService.mayorSueldo();
            System.out.println("Mayor sueldo: " + mayorSueldo);

            // Mostrar sueldo promedio
            Double sueldoPromedio = EmpleadoService.sueldoPromedio();
            System.out.println("Sueldo promedio: $" + sueldoPromedio);
        } catch (CollectionVaciaException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            // Eliminar empleado que no existe
            EmpleadoService.eliminar("Juan");
        } catch (CollectionVaciaException | NoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        try {
            // Eliminar empleado existente
            EmpleadoService.eliminar("Marcos");
            System.out.println("Empleado eliminado con éxito.");
        } catch (CollectionVaciaException | NoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // Lista final de empleados
        System.out.println(
                "Lista de empleados: ");
        EmpleadoService.getEmpleados()
                .forEach(System.out::println);
    }
}
