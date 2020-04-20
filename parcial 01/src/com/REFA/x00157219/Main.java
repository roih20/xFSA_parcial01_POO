package com.REFA.x00157219;
import java.util.List;
import java.util.ArrayList;
import  javax.swing.*;
public class Main {

    public static void main(String[] args) {
        String nombre;
        nombre = JOptionPane.showInputDialog(null, "Nombre de la empresa: ");
        while (nombre == null){
            try{
                JOptionPane.showInputDialog(null, "Nombre de la empresa: ");
            }catch (NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        empresa unaEmpresa = new empresa(nombre);
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, Menu()));
            switch (op) {
                case 1:
                    addEmpleado(unaEmpresa);
                    break;
                case 2:
                    quitEmpleado(unaEmpresa);
                    JOptionPane.showMessageDialog(null, "Empleado despedido");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Lista de empleados:\n" + unaEmpresa);
                    break;
                case 4:

                    for (empleado aux: unaEmpresa.getPlanilla()
                         ) {
                        JOptionPane.showMessageDialog(null, "\nEmpleado: "+ aux.getNombre() + "\nTotal del pago: "+ CalculadoraImpuestos.calcularPago(aux), "Informacion: ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 5:
                        JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "SALIENDO...");
                    break;
            }
        } while (op != 6);
    }

    static String Menu() {
        return "1) Agregar Empleado\n2) Despedir Empleado\n3) Ver lista de empleados\n4) Calcular sueldo\n5) Motrar totales\n6) Salir";
    }

    static private void addEmpleado(empresa unaEmpresa) {
        String nombre;
        nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del empleado: ");
        String puesto;
        double salario = 0;
        puesto = JOptionPane.showInputDialog(null, "Ingrese puesto:\nPlaza fija\nServicio profesional");
        if (puesto.equalsIgnoreCase("servicio profesional")) {
            double salario1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese sueldo: "));
            while (salario1 <= 0) {
                try {
                    salario1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese sueldo: "));
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            }
            int mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses de contrato: "));

            ServicioProfesional unEmpleado = new ServicioProfesional(nombre, puesto, salario1, mesesContrato);
            unaEmpresa.addEmpleado(unEmpleado);

        } else if (puesto.equalsIgnoreCase("plaza fija")) {
            double salario2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese sueldo: "));
            while (salario2 <= 0) {
                try {
                    salario2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese sueldo: "));
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            }
            int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero telefónico"));
            PlazaFija unEmpleado = new PlazaFija(nombre, puesto, salario2, extension);
            unaEmpresa.addEmpleado(unEmpleado);
        }



        empleado unEmpleado = new empleado(nombre, puesto, salario) {

        };
        unaEmpresa.addEmpleado(unEmpleado);
        addDocumento(unEmpleado);
    }

    static private void addDocumento(empleado unEmpleado) {
        int op = 0;
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea agregar documento?\n1) Si\n2) No"));
        while((op != 1 ) && (op != 2)){
            try{
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea agregar documento?\n1) Si\n2) No"));
            }catch(NumberFormatException ex){
                JOptionPane.showInputDialog(null, "dato invalido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException ex){
                JOptionPane.showInputDialog(null, "campo vacio", "Erorr", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (op == 1) {
            String nombre;
            nombre = JOptionPane.showInputDialog(null, "Ingrese documento personal:\nDUI ó NIT");
            String numero= null;
            if (nombre.equalsIgnoreCase("DUI")){
                numero = JOptionPane.showInputDialog(null, "Ingrese el numero de DUI: ");
            }else if (nombre.equalsIgnoreCase("NIT")){
                numero = JOptionPane.showInputDialog(null ,"Ingrese el numero de NIT:");
            }
            JOptionPane.showMessageDialog(null,  "Se agrego el numero correctamente");
            JOptionPane.showMessageDialog(null, "Empleado agregado");
            documento unDocumento = new documento(nombre, numero);
            unEmpleado.addDocumento(unDocumento);
        } else {
            JOptionPane.showMessageDialog(null, "Empleado agregado");
        }
    }

    static private void quitEmpleado(empresa unaEmpresa) {
        String NombreDespedir = JOptionPane.showInputDialog(null, "Empleado a despedir:");
        int cont = 0;
        for(int i = 0; i < unaEmpresa.getPlanilla().size(); i++){
            if(unaEmpresa.getPlanilla().get(i).nombre == NombreDespedir){
                cont++;
            }
        }
        if(cont > 1){
            JOptionPane.showMessageDialog(null, "Existen " + cont + " empleados con el mismo nombre");
            String NumeroDespedir = JOptionPane.showInputDialog(null, "Indique un numero de documento");
            for(int i = 0; i <unaEmpresa.getPlanilla().size(); i++){
                for(int j = 0; j < unaEmpresa.getPlanilla().get(i).documentos.size(); j++){
                    if(unaEmpresa.getPlanilla().get(i).documentos.get(j).getNumero() == NumeroDespedir){
                        unaEmpresa.getPlanilla().remove(i);
                    }
                }
            }
        }
        else {
            for(int i = 0; i < unaEmpresa.getPlanilla().size(); i++){
                if(NombreDespedir == unaEmpresa.getPlanilla().get(i).nombre)
                    unaEmpresa.getPlanilla().remove(i);
            }
        }
    }

    static private void removeDocumento(empleado unEmpleado) {
        String nombre;
        nombre = JOptionPane.showInputDialog(null, "Ingrese documento:\nDUI ó NIT");
        unEmpleado.removeDocumento(nombre);
    }

}