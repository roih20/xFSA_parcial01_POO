package com.REFA.x00157219;
import java.util.ArrayList;
import java.util.List;
public class empresa {
    private String nombre;
    private List<empleado> planilla = new ArrayList<>();

    public empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado(empleado unEmpleado){
        planilla.add(unEmpleado);
    }

    public void quitEmpleado(String nombre){
        for(empleado aux : planilla) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                String finalNombre = nombre;
                planilla.removeIf(s-> s.getNombre() == finalNombre);
            }
        }
    }

    @Override
    public String toString() {
        return "Empresa= " +
                "Nombre: " + nombre + '\n' +
                "Planilla " + planilla + '\n'
                ;
    }

}

