import java.text.Normalizer;
import java.util.Scanner;
import java.util.Set;

public class MapaMundialController {
    public static void main(String[] args) {
        // Instanciar MapaMundial
        MapaMundial mapaMundial = new MapaMundial();

        // Inicialización de continentes
        Continente america = new Continente(
                Normalizer.normalize("América", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        Continente europa = new Continente("Europa");
        Continente asia = new Continente("Asia");
        Continente africa = new Continente(
                Normalizer.normalize("África", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        Continente oceania = new Continente(
                Normalizer.normalize("Oceanía", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
        Continente antartida = new Continente(
                Normalizer.normalize("Antártida", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));

        // Agregar continentes
        mapaMundial.addContinente(america);
        mapaMundial.addContinente(europa);
        mapaMundial.addContinente(asia);
        mapaMundial.addContinente(africa);
        mapaMundial.addContinente(oceania);
        mapaMundial.addContinente(antartida);

        // Inicialización de países
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780400, america);
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176215, america);
        Pais brasil = new Pais("Brasil", "Brasilia", 8515767, america);
        Pais chile = new Pais("Chile", "Santiago de Chile", 756102, america);
        Pais paraguay = new Pais("Paraguay", "Asunción", 406752, america);
        Pais bolivia = new Pais("Bolivia", "Sucre", 1098581, america);
        Pais españa = new Pais("España", "Madrid", 505990, europa);
        Pais francia = new Pais("Francia", "París", 643801, europa);
        Pais italia = new Pais("Italia", "Roma", 301340, europa);
        Pais portugal = new Pais("Portugal", "Lisboa", 92212, europa);

        // Agregar paises
        america.addPais(argentina);
        america.addPais(uruguay);
        america.addPais(brasil);
        america.addPais(chile);
        america.addPais(paraguay);
        america.addPais(bolivia);
        europa.addPais(españa);
        europa.addPais(francia);
        europa.addPais(italia);
        europa.addPais(portugal);

        // Inicialización de provincias
        Provincia entreRios = new Provincia("Entre Ríos");
        Provincia buenosAires = new Provincia("Buenos Aires");
        Provincia santaFe = new Provincia("Santa Fe");
        Provincia corrientes = new Provincia("Corrientes");
        Provincia cordoba = new Provincia("Córdoba");
        Provincia salto = new Provincia("Salto");
        Provincia paysandu = new Provincia("Paysandú");
        Provincia canelones = new Provincia("Canelones");
        Provincia rocha = new Provincia("Rocha");
        Provincia maldonado = new Provincia("Maldonado");

        // Agregar provincias
        argentina.addProvincia(entreRios);
        argentina.addProvincia(buenosAires);
        argentina.addProvincia(santaFe);
        argentina.addProvincia(corrientes);
        argentina.addProvincia(cordoba);
        uruguay.addProvincia(salto);
        uruguay.addProvincia(paysandu);
        uruguay.addProvincia(canelones);
        uruguay.addProvincia(rocha);
        uruguay.addProvincia(maldonado);

        // MENU
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elegir una opción: ");
            System.out.println("1. Mostrar países de un continente.");
            System.out.println("2. Mostrar provincias de un país.");
            System.out.println("3. Mostrar países ordenados por superficie.");
            System.out.println("4. Comprar dos países.");
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

                case 0:
                    System.out.println("Fin de la aplicación.");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
