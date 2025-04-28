package Ej6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Empleado empleadoGanaMas(ArrayList<Empleado> empleados) {
        Empleado ganaMas = empleados.get(0);

        for (Empleado e : empleados) {
            if (e.getSueldo() > ganaMas.getSueldo()) {
                ganaMas = e;
            }
        }

        return ganaMas;
    }

    public static double sueldoPromedio(ArrayList<Empleado> empleados) {
        double sumaSueldos = 0;

        for (Empleado e : empleados) {
            sumaSueldos += e.getSueldo();
        }
        return sumaSueldos / empleados.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        String registrar;

        System.out.print("\nRegistrar empleados? (S/N): ");
        registrar = scanner.nextLine();

        do {
            System.out.print("\nNombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Sueldo: ");
            double sueldo = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            empleados.add(new Empleado(nombre, sueldo));

            System.out.print("\n¿Registrar otro empleado? (S/N): ");
            registrar = scanner.nextLine().trim().toLowerCase();

        } while (registrar.toLowerCase().equals("s"));

        System.out.println("*******************************************");
        System.out.println("Empleado que más gana: " + empleadoGanaMas(empleados));
        System.out.println("Sueldo promedio: $" + sueldoPromedio(empleados));

        scanner.close();
    }
}
