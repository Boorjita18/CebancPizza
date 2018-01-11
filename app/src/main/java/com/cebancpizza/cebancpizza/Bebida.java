package com.cebancpizza.cebancpizza;

/**
 * Created by gorka on 10/01/2018.
 */

public class Bebida {

    String nombre;
    int cantidad;
    double precio;

    public Bebida(String nombre,int cantidad,double precio){
        this.nombre= nombre;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
