
import java.text.Normalizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MapaMundial {
    private Set<Continente> continentes;

    public MapaMundial() {
        this.continentes = new HashSet<>();
        inicializarData();
    }

    private void inicializarData() {
        // Continentes
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

        continentes.add(america);
        continentes.add(europa);
        continentes.add(asia);
        continentes.add(africa);
        continentes.add(oceania);
        continentes.add(antartida);

        // Países
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780400, america);
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176215, america);
        Pais brasil = new Pais("Brasil", "Brasilia", 8515767, america);
        Pais chile = new Pais("Chile", "Santiago", 756102, america);
        Pais paraguay = new Pais("Paraguay", "Asunción", 406752, america);
        Pais bolivia = new Pais("Bolivia", "Sucre", 1098581, america);

        Pais españa = new Pais("España", "Madrid", 505990, europa);
        Pais francia = new Pais("Francia", "París", 551695, europa);
        Pais italia = new Pais("Italia", "Roma", 301340, europa);
        Pais portugal = new Pais("Portugal", "Lisboa", 92212, europa);

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

        // Provincias
        argentina.addProvincia(new Provincia("Entre Ríos"));
        argentina.addProvincia(new Provincia("Buenos Aires"));
        argentina.addProvincia(new Provincia("Santa Fé"));
        argentina.addProvincia(new Provincia("Córdoba"));
        argentina.addProvincia(new Provincia("Corrientes"));

        uruguay.addProvincia(new Provincia("Salto"));
        uruguay.addProvincia(new Provincia("Paysandú"));
        uruguay.addProvincia(new Provincia("Canelones"));
        uruguay.addProvincia(new Provincia("Rocha"));
        uruguay.addProvincia(new Provincia("Maldonado"));

        // Países limítrofes
        argentina.addLimitrofes(uruguay);
        argentina.addLimitrofes(brasil);
        argentina.addLimitrofes(chile);
        argentina.addLimitrofes(paraguay);
        argentina.addLimitrofes(bolivia);

        uruguay.addLimitrofes(argentina);
        uruguay.addLimitrofes(brasil);

        brasil.addLimitrofes(argentina);
        brasil.addLimitrofes(uruguay);
        brasil.addLimitrofes(paraguay);
        brasil.addLimitrofes(bolivia);

        chile.addLimitrofes(argentina);
        chile.addLimitrofes(bolivia);

        paraguay.addLimitrofes(argentina);
        paraguay.addLimitrofes(brasil);
        paraguay.addLimitrofes(bolivia);

        bolivia.addLimitrofes(argentina);
        bolivia.addLimitrofes(brasil);
        bolivia.addLimitrofes(chile);
        bolivia.addLimitrofes(paraguay);
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

    public Set<Pais> getLimitrofes(String nombrePais) {
        for (Continente continente : continentes) {
            for (Pais pais : continente.getPaises()) {
                if (pais.getNombre().equalsIgnoreCase(nombrePais)) {
                    return pais.getLimitrofes();
                }
            }
        }
        return Collections.emptySet();
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
