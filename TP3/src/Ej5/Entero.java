import java.util.Scanner;

public class Entero {
    private int numero;

    // constructor de la clase Enteros
    public Entero(int numero) {
        super();
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // calcula el cuadrado de n
    public long cuadrado() {
        return numero * numero;
    }

    // Número par o impar
    public String parImpar() {
        String respuesta;
        if (numero % 2 == 0) {
            respuesta = "El número " + numero + " es par.";
        } else {
            respuesta = "El número " + numero + " es impar.";
        }

        return respuesta;
    }

    // Factorial
    public int calcularFactorial() {
        int factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }

        return factorial;
    }

    // Primo
    public boolean esPrimo() {
        // 0 y 1 no son primos
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nIngrese un número: ");
        int numero = scanner.nextInt();

        Entero num = new Entero(numero);

        System.out.println("************************");
        System.out.println("Número: " + num.getNumero());
        System.out.println(num.parImpar());

        if (numero < 0) {
            System.out.println("No se puede calcular el factorial de un número negativo.");
        } else {
            System.out.println("Factorial = " + num.calcularFactorial());
        }

        if (num.esPrimo()) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
    }
}
