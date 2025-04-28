
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MapaMundial {
    private Set<Continente> continentes;

    public MapaMundial() {
        this.continentes = new HashSet<>();
    }

    // Instanciar e inicializar continentes
    public void addContinente(Continente continente) {
        continentes.add(continente);
    }

    public Set<Continente> getContinentes() {
        return continentes;
    }

    // Instanciar e inicializar países
    public Set<Pais> getPaises(String nombreContinente) {
        for (Continente c : continentes) {
            if (c.getNombre().equalsIgnoreCase(nombreContinente)) {
                return c.getPaises();
            }
        }

        return new HashSet<>();
    }

    public Set<Provincia> getProvincias(String nombrePais) {
        for (Continente c : continentes) {
            for (Pais p : c.getPaises()) {
                if (p.getNombre().equalsIgnoreCase(nombrePais)) {
                    return p.getProvincia();
                }
            }
        }
        return new HashSet<>();
    }

    // Método para ordenar los países por superficie
    public Set<Pais> paisesOdenadosPorSuperficie() {
        Set<Pais> paisesOrdenados = new TreeSet<>(Comparator.comparingDouble(Pais::getSuperficie));

        for (Continente c : continentes) {
            paisesOrdenados.addAll(c.getPaises());
        }

        return paisesOrdenados;
    }

    public Pais compararSuperficie(Pais p1, Pais p2) {
        // Ternario
        return p1.getSuperficie() >= p2.getSuperficie() ? p1 : p2;
    }
}
