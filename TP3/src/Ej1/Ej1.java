import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese un numero: ");
        int num1 = scanner.nextInt(); 
        System.out.print("Ingrese un numero: ");
        int num2 = scanner.nextInt();
        System.out.print("Ingrese un numero: ");
        int num3 = scanner.nextInt();
        int resultado;

        if (num1 > 0) {
            resultado = num2 * num3;
        } else {
            resultado = num2 + num3;
        }

        System.out.println("Resultado = " + resultado);

        scanner.close();
    }
}
