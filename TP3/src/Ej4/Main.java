public class Main {
    public static void main(String[] args) {
        ArrayEntero a = new ArrayEntero();

        System.out.println("Cantidad de números en el array: " + a.cantidadNumeros());
        System.out.println("Número mayor: " + a.numeroMayor());
        System.out.println("Promedio: " + a.promedioArray());
        System.out.println("Orden Ascendente: ");
        a.imprimirArray(a.ordenAscendente());
        System.out.println("Orden Descendente: ");
        a.imprimirArray(a.ordenDescendente());
    }
}
