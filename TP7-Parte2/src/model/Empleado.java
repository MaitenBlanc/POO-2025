package model;

import exceptions.*;

public class Empleado {

    private String nombre;
    private Integer sueldo;
    private Integer legajo;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, Integer sueldo) throws StringException, EnteroPositivoException {
        super();
        setNombre(nombre);
        setSueldo(sueldo);
    }

    public Empleado(String nombre) throws StringException {
        super();
        setNombre(nombre);
    }

    public Empleado(Integer sueldo) throws EnteroPositivoException {
        super();
        setSueldo(sueldo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws StringException {
        if (nombre.equals(null) || nombre.length() < 3) {
            throw new StringException(ErrorEmpleado.ERR_NOMBRE_INVALIDO);
        }
        this.nombre = nombre;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) throws EnteroPositivoException {
        if (sueldo == null || sueldo <= 0) {
            throw new EnteroPositivoException(ErrorEmpleado.ERR_SUELDO_INVALIDO);
        }
        this.sueldo = sueldo;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) throws EnteroPositivoException {
        if (legajo == null || legajo <= 0) {
            throw new EnteroPositivoException(ErrorEmpleado.ERR_LEGAJO_INVALIDO);
        }
        this.legajo = legajo;
    }

    public String getSueldoString() {
        return "$" + sueldo;
    }

    @Override
    public String toString() {
        return this.getNombre() + " - " + this.getSueldoString();
    }
}
