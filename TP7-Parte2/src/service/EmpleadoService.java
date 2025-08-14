package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.*;
import model.Empleado;
import model.ErrorEmpleado;

public class EmpleadoService {

    private static List<Empleado> empleados = new ArrayList<Empleado>();

    public static Boolean agregar(Empleado empleado) throws EnteroPositivoException {
        empleado.setLegajo(empleado.getLegajo());
        return empleados.add(empleado);
    }

    // Devuelve el empleado de mayor sueldo
    public static Empleado mayorSueldo() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException(ErrorEmpleado.ERR_COLLECTION_VACIA);
        }
        Empleado mayor = empleados.get(0);
        Iterator<Empleado> iterador = empleados.iterator();
        while (iterador.hasNext()) {
            Empleado empleado = iterador.next();
            if (mayor.getSueldo() <= empleado.getSueldo()) {
                mayor = empleado;
            }
        }
        return mayor;
    }

    //Devuelve el sueldo promedio
    public static Double sueldoPromedio() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException(ErrorEmpleado.ERR_COLLECTION_VACIA);
        }
        Double total = 0.0;
        for (Empleado empleado : empleados) {
            total += empleado.getSueldo();
        }
        return total / empleados.size();
    }

    public static void eliminar(String nombre) throws CollectionVaciaException, NoEncontradoException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException(ErrorEmpleado.ERR_COLLECTION_VACIA);
        }

        boolean encontrado = false;

        Iterator<Empleado> iterador = empleados.iterator();
        while (iterador.hasNext()) {
            Empleado empl = iterador.next();
            if (empl.getNombre().equalsIgnoreCase(nombre)) {
                iterador.remove();
                encontrado = true;
            }

            if (!encontrado) {
                throw new NoEncontradoException(ErrorEmpleado.ERR_EMPLEADO_NO_ENCONTRADO);
            }
        }
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

}
