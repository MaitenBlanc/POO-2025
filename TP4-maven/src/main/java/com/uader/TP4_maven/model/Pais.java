package com.uader.TP4_maven.model;

import java.util.HashSet;
import java.util.Set;

public class Pais {
    private String nombre;
    private String capital;
    private double superficie;
    private Continente continente;
    private Set<Provincia> provincias = new HashSet<>();
    private Set<Pais> limitrofes = new HashSet<>();

    public Pais(String nombre, String capital, double superficie) {
        this.nombre = nombre;
        this.capital = capital;
        this.superficie = superficie;
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
        continente.addCountry(this);
    }

    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }

    public Set<Pais> getLimitrofes() {
        return limitrofes;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", capital='" + capital + '\'' +
                ", superficie=" + superficie +
                ", continente=" + (continente != null ? continente.getNombre() : "N/A") +
                '}';
    }

    // Agregar provincia
    public void addProvincia(Provincia p) {
        provincias.add(p);
    }

    // Agregar países limítrofes
    public void addLimitrofes(Pais p) {
        limitrofes.add(p);
    }
}
