
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import productos.Producto;
import productos.ProductoService;

public class TiendaApp {

    public static void main(String[] args) {
        // 1. Inicialización de datos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop Gamer", "Electrónica", 1500.00, 10));
        productos.add(new Producto("Teclado Mecánico", "Electrónica", 120.00, 30));
        productos.add(new Producto("Mouse Inalámbrico", "Electrónica", 40.00, 50));
        productos.add(new Producto("Silla de Oficina", "Hogar", 250.00, 15));
        productos.add(new Producto("Monitor 4K", "Electrónica", 450.00, 8));
        productos.add(new Producto("Libro de Java", "Libros", 35.00, 100));
        productos.add(new Producto("Cafetera Express", "Hogar", 80.00, 5));
        productos.add(new Producto("Auriculares Bluetooth", "Electrónica", 90.00, 25));

        // 2. Creación de la instancia del servicio
        ProductoService servicio = new ProductoService(productos);

        // 3. Uso de los métodos del servicio para resolver las consignas
        System.out.println("\n--- Tarea 1: Productos de Electrónica ---");
        List<Producto> electronica = servicio.obtenerProductosPorCategoria("Electrónica");
        electronica.forEach(System.out::println);

        System.out.println("\n--- Tarea 2: Producto más caro ---");
        Optional<Producto> masCaro = servicio.encontrarProductoMasCaro();
        masCaro.ifPresent(p -> System.out.println("El producto más caro es: " + p));

        System.out.println("\n--- Tarea 3: Nombres de productos con poco stock (< 10) ---");
        List<String> pocoStock = servicio.obtenerNombresProductosConPocoStock(10);
        System.out.println(pocoStock);

        System.out.println("\n--- Tarea 4: Productos ordenados por categoría y precio ---");
        List<Producto> ordenados = servicio.ordenarProductosPorCategoriaYPrecio();
        ordenados.forEach(System.out::println);

        System.out.println("\n--- Tarea 5: Productos agrupados por categoría ---");
        Map<String, List<Producto>> porCategoria = servicio.agruparProductosPorCategoria();
        porCategoria.forEach((cat, lista) -> System.out.println(cat + ": " + lista.size() + " productos"));

        System.out.println("\n--- Tarea 6: Valor total del inventario ---");
        double valorTotal = servicio.calcularValorTotalInventario();
        System.out.printf("El valor total del inventario es: $%.2f%n", valorTotal);

        System.out.println("\n--- Tarea 7: Productos ordenados por stock (asc) y nombre ---");
        List<Producto> ordenadosPorStock = servicio.obtenerProductosOrdenadosPorStockYNombre(10);
        ordenadosPorStock.forEach(System.out::println);

        System.out.println("\n--- Tarea 8: Manejo avanzado de Optional ---");

        // Escenario A: Búsqueda exitosa
        System.out.println("\nBuscando 'Laptop Gamer':");
        Optional<Producto> laptopOpt = servicio.buscarProductoPorNombre("Laptop Gamer");
        laptopOpt.ifPresent(p -> System.out.println("Encontrado: " + p.getNombre()));
        Double precioLaptop = laptopOpt.map(Producto::getPrecio).orElse(0.0);
        System.out.println("Precio con map() y orElse(): $" + precioLaptop);

        // Escenario B: Búsqueda fallida
        System.out.println("\nBuscando 'Tablet':");
        Optional<Producto> tabletOpt = servicio.buscarProductoPorNombre("Tablet");
        Producto productoPorDefecto = tabletOpt.orElse(new Producto("Producto no encontrado", "", 0.0, 0));
        System.out.println("Resultado con orElse(): " + productoPorDefecto.getNombre());
        try {
            tabletOpt.orElseThrow(() -> new NoSuchElementException("La 'Tablet' no existe en el catálogo."));
        } catch (NoSuchElementException e) {
            System.out.println("Resultado con orElseThrow(): " + e.getMessage());
        }
    }
}
