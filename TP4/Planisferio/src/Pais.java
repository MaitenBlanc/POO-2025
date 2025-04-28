
import java.util.HashSet;
import java.util.Set;

public class Pais {
    private String nombre;
    private String capital;
    private double superficie;
    private Continente continente;
    private Set<Provincia> provincias;

    public Pais(String nombre, String capital, double superficie, Continente continente) {
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
        this.continente = continente;
        this.provincias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "País: " + this.nombre + ", Capital: " + this.capital + ", Superficie: " + this.superficie + " km²";
    }

    // Método para agregar provincias
    public void addProvincia(Provincia provincia) {
        provincias.add(provincia);
    }

    // Método para devolver provincias
    public Set<Provincia> getProvincia() {
        return provincias;
    }
}
