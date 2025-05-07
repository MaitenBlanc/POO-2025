package com.uader.TP4_maven.model;

public class Provincia {
    private String nombre;

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Provincia{");
        sb.append("nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
}
