import java.text.Normalizer;
import java.util.Scanner;
import java.util.Set;

public class MapaMundialController {
    public static void main(String[] args) {
        // Instanciar MapaMundial
        MapaMundial mapaMundial = new MapaMundial();

        // MENU
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elegir una opción: ");
            System.out.println("1. Mostrar países de un continente.");
            System.out.println("2. Mostrar provincias de un país.");
            System.out.println("3. Mostrar países ordenados por superficie.");
            System.out.println("4. Comprar dos países.");
            System.out.println("5. Mostrar países limítrofes.");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese continente: ");
                    String nombreContinente = scanner.nextLine().toLowerCase().trim();
                    nombreContinente = Normalizer.normalize(nombreContinente, Normalizer.Form.NFD)
                            .replaceAll("[^\\p{ASCII}]", "");
                    Set<Pais> paises = mapaMundial.getPaises(nombreContinente);

                    if (paises.isEmpty()) {
                        System.out.println("Continente no encontrado.");
                    } else {
                        System.out.println("Países en " + nombreContinente + ": ");
                        for (Pais p : paises) {
                            System.out.println("- " + p);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Ingrese país: ");
                    String nombrePais = scanner.nextLine();
                    Set<Provincia> provincias = mapaMundial.getProvincias(nombrePais);

                    if (provincias.isEmpty()) {
                        System.out.println("País no encontrado.");
                    } else {
                        System.out.println("Provincias de " + nombrePais + ": ");
                        for (Provincia p : provincias) {
                            System.out.println("- " + p);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Países ordenados por superficie: ");
                    Set<Pais> paisesOrdenados = mapaMundial.paisesOdenadosPorSuperficie();

                    for (Pais p : paisesOrdenados) {
                        System.out.println("- " + p.getNombre() + ": " + p.getSuperficie() + " Km2.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese un país: ");
                    String pais1 = scanner.nextLine();
                    System.out.print("Ingrese otro país: ");
                    String pais2 = scanner.nextLine();

                    Pais p1 = null, p2 = null;
                    for (Continente c : mapaMundial.getContinentes()) {
                        for (Pais p : c.getPaises()) {
                            if (p.getNombre().equalsIgnoreCase(pais1)) {
                                p1 = p;
                            }
                            if (p.getNombre().equalsIgnoreCase(pais2)) {
                                p2 = p;
                            }
                        }
                    }
                    if (p1 != null && p2 != null) {
                        Pais mayor = mapaMundial.compararSuperficie(p1, p2);
                        System.out.println("El país con mayor superficie es: " + mayor.getNombre());
                    } else {
                        System.out.println("Algún país no fue encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese un país: ");
                    String paisLimitrofe = scanner.nextLine();
                    Set<Pais> limitrofes = mapaMundial.getLimitrofes(paisLimitrofe);
                    limitrofes.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Fin de la aplicación.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
