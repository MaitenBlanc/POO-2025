package com.uader.TP4_maven;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uader.TP4_maven.data.MapaMundial;
import com.uader.TP4_maven.model.Pais;

@SpringBootApplication
public class MapaMundialController {
    public static void main(String[] args) {
        SpringApplication.run(MapaMundialController.class, args);

        MapaMundial mapa = new MapaMundial();
        Scanner scanner = new Scanner(System.in);
        int option;

        do { 
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ver países por continente");
            System.out.println("2. Ver provincias por país");
            System.out.println("3. Ver países ordenados por superficie");
            System.out.println("4. Comparar superficie entre dos países");
            System.out.println("5. Ver países limítrofes");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: 
                    System.out.println("Ingrese un continente: ");
                    String continente = scanner.nextLine();
                    mapa.getPaises(continente).forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Ingrese un país: ");
                    String pais = scanner.nextLine();
                    mapa.getProvincias(pais).forEach(System.out::println);
                    break;
                case 3: 
                    mapa.getPaisesOrdenadosPorSuperficie().forEach(System.out::println);
                    break;
                case 4: 
                    System.out.println("Ingrese un país: ");
                    String pais1 = scanner.nextLine();
                    System.out.println("Ingrese otro país: ");
                    String pais2 = scanner.nextLine();
                    Pais mayorSuperficie = mapa.compararSuperficie(pais1, pais2);
                    System.out.println("El país con mayor superficie es: " + mayorSuperficie);
                    break;
                case 5:
                    System.out.println("Ingrese un país: ");
                    String paisLimitrofe = scanner.nextLine();
                    mapa.getLimitrofes(paisLimitrofe).forEach(System.out::println);
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}
