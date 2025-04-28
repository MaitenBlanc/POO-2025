public enum ClasificacionNota {
    SOBRESALIENTE("Sobresaliente"),
    APROBADO("Aprobado"), 
    REPROBADO("Reprobado");

    String nombre;

    ClasificacionNota(String nombre) {       
        this.nombre = nombre; 
    }    

    public String getNombre() {
        return nombre;
    }
}
