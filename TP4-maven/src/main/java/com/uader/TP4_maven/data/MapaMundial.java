package com.uader.TP4_maven.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.uader.TP4_maven.model.Continente;
import com.uader.TP4_maven.model.Pais;
import com.uader.TP4_maven.model.Provincia;

public class MapaMundial {
    private Map<String, Continente> continentes = new HashMap<>();
    private Map<String, Pais> paises = new HashMap<>();

    public MapaMundial() {
        initialize();
    }

    private void initialize() {
        // Continentes
        Continente america = new Continente("America");
        Continente europa = new Continente("Europa");
        Continente asia = new Continente("Asia");
        Continente africa = new Continente("Africa");
        Continente oceania = new Continente("Oceania");
        Continente antartida = new Continente("Antartida");

        continentes.put("America", america);
        continentes.put("Europa", europa);
        continentes.put("Asia", asia);
        continentes.put("Africa", africa);
        continentes.put("Oceania", oceania);
        continentes.put("Antartida", antartida);

        // Paises
        Pais argentina = new Pais("Argentina", "Buenos Aires", 2780400);
        Pais uruguay = new Pais("Uruguay", "Montevideo", 176000);
        Pais brasil = new Pais("Brasil", "Brasilia", 8515767);
        Pais chile = new Pais("Chile", "Santiago", 756102);
        Pais españa = new Pais("España", "Madrid", 505990);
        Pais italia = new Pais("Italia", "Roma", 301340);

        paises.put("Argentina", argentina);
        paises.put("Uruguay", uruguay);
        paises.put("Brasil", brasil);
        paises.put("Chile", chile);
        paises.put("España", españa);
        paises.put("Italia", italia);

        // Vinculación a continente
        argentina.setContinente(america);
        uruguay.setContinente(america);
        brasil.setContinente(america);
        chile.setContinente(america);
        españa.setContinente(europa);
        italia.setContinente(europa);

        // Provincias
        Provincia entreRios = new Provincia("Entre Rios");
        Provincia buenosAires = new Provincia("Buenos Aires");
        Provincia santaFe = new Provincia("Santa Fe");
        Provincia corrientes = new Provincia("Corrientes");
        Provincia cordoba = new Provincia("Cordoba");

        Provincia salto = new Provincia("Salto");
        Provincia paysandu = new Provincia("Paysandu");
        Provincia canelones = new Provincia("Canelones");
        Provincia rocha = new Provincia("Rocha");
        Provincia maldonado = new Provincia("Maldonado");

        // Vinculación a país
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

        // Relaciones de países limítrofes
        argentina.addLimitrofes(uruguay);
        argentina.addLimitrofes(brasil);
        argentina.addLimitrofes(chile);

        brasil.addLimitrofes(argentina);
        uruguay.addLimitrofes(argentina);
        chile.addLimitrofes(argentina);
    }

    public Set<Pais> getPaises(String nombreContinente) {
        Continente c = continentes.get(nombreContinente);
        return c != null ? c.getPaises() : Collections.emptySet();
    }

    public Set<Provincia> getProvincias(String nombrePais) {
        Pais p = paises.get(nombrePais);
        return p != null ? p.getProvincias() : Collections.emptySet();
    }

    public List<Pais> getPaisesOrdenadosPorSuperficie() {
        List<Pais> list = new ArrayList<>(paises.values());
        list.sort(Comparator.comparingDouble(Pais::getSuperficie).reversed());
        return list;
    }

    public Pais compararSuperficie(String pais1, String pais2) {
        Pais p1 = paises.get(pais1);
        Pais p2 = paises.get(pais2);
        return (p1 != null && p2 != null && p1.getSuperficie() > p2.getSuperficie()) ? p1 : p2;
    }

    public Set<Pais> getLimitrofes(String nombrePais) {
        Pais p = paises.get(nombrePais);
        return p != null ? p.getLimitrofes() : Collections.emptySet();
    }
}
