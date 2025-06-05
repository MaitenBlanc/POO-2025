
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

import models.Circulo;
import models.Cuadrado;
import models.Elipse;
import models.Figura;
import models.Punto;
import models.Rectangulo;

public class Principal {
    public static void main(String[] args) throws Exception {
        Collection<Figura> figuras = new ArrayList<>();

        // Crear objetos y probar métodos
        Rectangulo rectagulo1 = new Rectangulo("Rojo", new Punto(0, 0), "Rectángulo 1", 4, 5);
        Elipse elipse1 = new Elipse("Verde", new Punto(2, 2), "Elipse 1", 3, 2);
        Cuadrado cuadrado1 = new Cuadrado("Azul", new Punto(5, 5), "Cuadrado 1", 4);
        Circulo circulo1 = new Circulo("Amarillo", new Punto(6, 6), "Círculo 1", 3);

        figuras.add(rectagulo1);
        figuras.add(elipse1);
        figuras.add(cuadrado1);
        figuras.add(circulo1);

        System.out.println("\nFiguras Originales: ");
        for (Figura figura : figuras) {
            System.out.println(figura);
        }

        // e) Cambiar color y mover todas las figuras
        for (Figura figura : figuras) {
            figura.changeColor("Negro");
            figura.moveCenter(10, 10);
        }

        System.out.println("\nFiguras luego de cambiar color y mover centro: ");
        for (Figura figura : figuras) {
            System.out.println(figura);
        }

        // f) Mostrar área y perímetro de cada figura (usa polimorfismo para usar toString)
        // g) En Figura se usa métodos abstractos para Área y perímetro, para garantizar el polimorfismo
        // h) En Figura se usa métodos abstractos para Área y perímetro, para obligar a las clases hijo a implementarlas
        System.out.println("\nFiguras llamando al método toString: ");
        for (Figura figura : figuras) {
            System.out.println(figura);
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Área: " + df.format(figura.calculateArea()));
            System.out.println("Perímetro: " + df.format(figura.calculatePerimeter()));
        }
    }
}
