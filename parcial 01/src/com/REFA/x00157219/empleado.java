package com.REFA.x00157219;

import java.util.List;
import java.util.ArrayList;

public abstract class empleado {
    protected String nombre, puesto;
    protected double salario;
    protected List<documento> documentos = new ArrayList<>();

    public empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public List<documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento(documento unDocumento) {
        documentos.add(unDocumento);
    }

    public void removeDocumento(String nombre){
        for(documento aux : documentos) {
            if (aux.getNombred().equalsIgnoreCase(nombre)) {
                String finalNombre = nombre;
                documentos.removeIf(s -> s.getNombred() == finalNombre);
            }
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado=\n" +
                "Nombre: " + nombre + '\n' +
                "Puesto: " + puesto + '\n' +
                "Salario: " + salario + '\n' +
                "Documentos=\n" + documentos
                ;
    }
}