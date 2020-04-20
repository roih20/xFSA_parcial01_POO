package com.REFA.x00157219;

public class CalculadoraImpuestos {
    public static double totalRenta;
    public static double totalISSS;
    public static double totalAFP;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(empleado unEmpleado) {
        double pagoTotal = 0;
        double AFP = 0;
        double ISS = 0;
        double renta = 0;
        double Restante=0;
        double x = 0;
        if (unEmpleado instanceof ServicioProfesional) {

            renta = 0.1 * unEmpleado.getSalario();
            totalRenta += renta;
            pagoTotal = unEmpleado.getSalario() - renta;
        } else if (unEmpleado instanceof PlazaFija) {
            AFP = 0.0625 * unEmpleado.getSalario();
            ISS = 0.03 * unEmpleado.getSalario();
            totalISSS += ISS;
            totalAFP += AFP;

             Restante = unEmpleado.getSalario() - AFP - ISS;
             x = Restante;
            if ((unEmpleado.getSalario() >= 0.01) && (unEmpleado.getSalario() <= 472.00)) {
                renta = 0;
            } else if ((unEmpleado.getSalario() >= 472.01) && (unEmpleado.getSalario() >= 895.24)) {
                renta = 0.1 * (x - 472) + 17.67;
            } else if ((unEmpleado.getSalario() >= 895.25) && (unEmpleado.getSalario() <= 2038.10)) {
                renta = 0.2 * (x - 895.24) + 60;
            } else if ((unEmpleado.getSalario() >= 2038.11)) {
                renta = 0.3 * (x - 2038.10) + 288.57;
            }

            pagoTotal = Restante - renta;
        }
        return pagoTotal;
    }

public static String mostrarTotales(){
        String resultado = "\nTotal AFP:" + totalAFP + "\nTotal ISS: " + totalISSS + "\nTotal de renta:"+ totalRenta ;
        return resultado;
}
    public static double getTotalRenta() {
        return totalRenta;
    }

    public static double getTotalISSS() {
        return totalISSS;
    }

    public static double getTotalAFP() {
        return totalAFP;
    }
}