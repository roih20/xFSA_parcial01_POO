package com.REFA.x00157219;

 public class documento{
    private String nombre, numero;

    public documento(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombred() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + '\n' +
                "Numero: " + numero + '\n'
                ;
    }
}