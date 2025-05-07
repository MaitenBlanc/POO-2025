package com.uader.TP4_maven.model;

import java.util.HashSet;
import java.util.Set;

public class Continente {
    private String nombre;
    private Set<Pais> paises = new HashSet<>();

    public Continente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Pais> getPaises() {
        return paises;
    }

    @Override
    public String toString() {
        return "Continente{" +
                "nombre='" + nombre + '\'' +
                ", cantidadPaises=" + paises.size() +
                '}';
    }

    // Agregar paises al continente
    public void addCountry(Pais pais) {
        paises.add(pais);
    }

}
