
import java.util.HashSet;
import java.util.Set;

public class Continente {
    private String nombre;
    private Set<Pais> paises;

    public Continente(String nombre) {
        this.nombre = nombre;
        this.paises = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Continente: " + this.nombre;
    }

    // Método para agregar países
    public void addPais(Pais pais) {
        paises.add(pais);
    }

    // Método para devolver paises
    public Set<Pais> getPaises() {
        return paises;
    }
}
