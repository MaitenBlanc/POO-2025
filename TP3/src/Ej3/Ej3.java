import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nIngrese una palabra: ");
        String palabra = scanner.nextLine();

        String palindromo = new StringBuilder(palabra).reverse().toString();

        if (palabra.equals(palindromo)) {
            System.out.println("La palabra " + palabra + " es palíndromo.");
        } else {
            System.out.println("La palabra " + palabra + " no es palíndromo.");
        }

        scanner.close();
    }
}
